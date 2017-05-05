import org.omg.PortableInterceptor.INACTIVE;

import java.io.*;
import java.util.Scanner;

public class MIPSSimulator {

    static int main_Memory[] = new int[1048576];
    static int general_Registers[] = new int[32];
    static int PC;
    static int nPC;
    static int Hi;
    static int Lo;
    static int zero = 0;
    static int memAllocat = 867530;
    static boolean debug = true;

    private final static int addInst = 0b0000_0000_0000_0000_0000_0000_0010_0000;
    private final static int addIInst = 0b0010_0000_0000_0000_0000_0000_0000_0000;
    private final static int addIUInst = 0b0010_0100_0000_0000_0000_0000_0000_0000;
    private final static int addUInst = 0b0000_0000_0000_0000_0000_0000_0010_0001;
    private final static int andInst = 0b0000_0000_0000_0000_0000_0000_0010_0100;
    private final static int andIInst = 0b0011_0000_0000_0000_0000_0000_0000_0000;
    private final static int beqInst = 0b0001_0000_0000_0000_0000_0000_0000_0000;
    private final static int bgezInst = 0b0000_0100_0000_0001_0000_0000_0000_0000;
    private final static int bgezalInst = 0b0000_0100_0001_0001_0000_0000_0000_0000;
    private final static int bgtzInst = 0b0001_1100_0000_0000_0000_0000_0000_0000;
    private final static int blezInst = 0b0001_1000_0000_0000_0000_0000_0000_0000;
    private final static int bltzInst = 0b0000_0100_0000_0000_0000_0000_0000_0000;
    private final static int bltzalInst = 0b0000_0100_0001_0000_0000_0000_0000_0000;
    private final static int bneInst = 0b0001_0100_0000_0000_0000_0000_0000_0000;
    private final static int divInst = 0b0000_0000_0000_0000_0000_0000_0001_1010;
    private final static int jumpInst = 0b0000_1000_0000_0000_0000_0000_0000_0000;
    private final static int jalInst = 0b0000_1100_0000_0000_0000_0000_0000_0000;
    private final static int jrInst = 0b0000_0000_0000_0000_0000_0000_0000_1000;
    private final static int lbInst = 0b1000_0000_0000_0000_0000_0000_0000_0000;
    private final static int luiInst = 0b0011_1100_0000_0000_0000_0000_0000_0000;
    private final static int lwInst = 0b1000_1100_0000_0000_0000_0000_0000_0000;
    private final static int mfhiInst = 0b0000_0000_0000_0000_0000_0000_0001_0000;
    private final static int mfloInst = 0b0000_0000_0000_0000_0000_0000_0001_0010;
    private final static int multInst = 0b0000_0000_0000_0000_0000_0000_0001_1000;
    private final static int orInst = 0b0000_0000_0000_0000_0000_0000_0010_0101;
    private final static int oriInst = 0b0011_0100_0000_0000_0000_0000_0000_0000;
    private final static int sbInst = 0b1010_0000_0000_0000_0000_0000_0000_0000;
    private final static int sllInst = 0b0000_0000_0000_0000_0000_0000_0000_0000;
    private final static int sllvInst = 0b0000_0000_00000_0000_0000_0000_0000_0100;
    private final static int sltInst = 0b0000_0000_0000_0000_0000_0000_0010_1010;
    private final static int sltiInst = 0b0010_1000_0000_0000_0000_0000_0000_0000;
    private final static int sltiuInst = 0b0010_1100_0000_0000_0000_0000_0000_0000;
    private final static int sltuInst = 0b0000_0000_0000_0000_0000_0000_0010_1011;
    private final static int sraInst = 0b0000_0000_0000_0000_0000_0000_0000_0011;
    private final static int srlInst = 0b0000_0000_0000_0000_0000_0000_0000_0010;
    private final static int srlvInst = 0b0000_0000_0000_0000_0000_0000_0000_0110;
    private final static int subInst = 0b0000_0000_0000_0000_0000_0000_0010_0010;
    private final static int subuInst = 0b0000_0000_0000_0000_0000_0000_0010_0011;
    private final static int swInst = 0b1010_1100_0000_0000_0000_0000_0000_0000;
    private final static int syscallInst = 0b0000_0000_0000_0000_0000_0000_0000_1100;
    private final static int xorInst = 0b0000_0000_0000_0000_0000_0000_0010_0110;
    private final static int xoriInst = 0b0011_1000_0000_0000_0000_0000_0000_0000;

    private final static int mask1 = 0b11111100000000000000011111111111;
    private final static int mask2 = 0b11111100000000000000000000000000;
    private final static int mask3 = 0b11111100000111110000000000000000;
    private final static int mask4 = 0b11111100000000001111111111111111;
    private final static int mask5 = 0b11111100000111111111111111111111;
    private final static int mask6 = 0b11111111111111110000011111111111;
    private final static int mask7 = 0b11111100000000000000000000111111;

    public static void main(String[] args) {

        System.out.println("This is a MIPS Simulator by Joshua McMahan\n");


        // Loads the file that will be selected by the user into a scanner
        try {
            Scanner user_in = new Scanner(new File(args[0]));

            //checks the file for lines that don't start with [ and skips them
            while (user_in.hasNext()) {
                String currentLine = user_in.nextLine();
                String splitString[] = currentLine.split("\\s");
                boolean isPC = false;
                int isR = -1;
                int step = 0;
                int currentAddress = -1;
                for (String strings : splitString) {
                    if (strings.equals("")) {
                        continue;
                    }
                    if (strings.startsWith("[")) {
                        //Do stuff for start of line
                        strings = strings.substring(1, strings.length() - 1); // Remove brackets
                        if (strings.startsWith("P")) {
                            // Do PC code
                            isPC = true;
                            //System.out.println("Reached PC block, String is: " + strings);

                        } else if (strings.startsWith("R")) {
                            // Do R code
                            isR = (int) Long.parseLong(strings.substring(1));

                            //System.out.println("Reached R block, String is: " + strings);

                        } else // Its a Hex address
                        {
                            currentAddress = (int) Long.parseLong(strings.substring(2), 16);
                            //System.out.println("We're a hex address inside brackets, String is: " + strings);
                        }
                    } else if (strings.startsWith("0x")) {
                        if (isPC) {
                            PC = (int) Long.parseLong(strings.substring(2), 16);
                            //System.out.println("Our PC is " + PC);
                        } else if (!(isR == -1)) {
                            general_Registers[isR] = (int) Long.parseLong(strings.substring(2), 16);
                            //System.out.println("R" + isR + " is: " + String.format("%08x",general_Registers[isR]));
                        } else // its main memory
                        {
                            //System.out.println("Strings as hex int: " +Integer.parseInt(strings.substring(2), 16));
                            int address = currentAddress / 4 + step;
                            main_Memory[address] = (int) Long.parseLong(strings.substring(2), 16);
                            step++;
                            //System.out.println("Memory address " + String.format("%08x",address) + " is set to: " + String.format("%08x",main_Memory[address]));
                        }
                        //System.out.print(" Our instruction is: " + strings + "\n");
                    } else {
                        break; // the string isn't valid
                    }
                }


            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }

        while (true) {
            int Instr = main_Memory[PC / 4];
            int operation = Instr >> 26 & 0b111111;
            int s = Instr >> 21 & 0b11111;
            int t = Instr >> 16 & 0b11111;
            int d = Instr >> 11 & 0b11111;
            int shamt = Instr >> 6 & 0b11111;
            int func = Instr & 0b111111;
            int imm = Instr & 0b1111111111111111;
            int target = Instr & 0b00000011111111111111111111111111;
            int signExtendImm = imm;
            if (signExtendImm < 0) signExtendImm = (Instr | 0xFFFF0000);
            int offset = 4;

            if (debug) {
                while (true) {
                    System.out.println("Your current PC is: " + PC);
                    System.out.println("and your instruction in Hex is: 0x" + String.format("%08x", Instr));
                    System.out.println("Please press enter to advance. Type r for registers, memory and number for memory. ");
                    Scanner scan = new Scanner(System.in);
                    String scannedString = scan.nextLine();
                    if (scannedString.equals(""))
                        break;
                    else if (scannedString.equals("r")) {
                        int i = 0;
                        while (i < 32) {
                            System.out.println("Reg " + i + ": " + general_Registers[i]);
                            i++;
                        }
                    } else if (scannedString.startsWith("memory")) {
                        String memory[] = scannedString.split("\\s");
                        if (memory.length < 2) {
                            System.out.print("Usage: memory 123");
                        } else {
                            int position = Integer.parseInt(memory[1]);
                            System.out.println("Memory position " + position + ": " + main_Memory[position]);
                        }

                    }
                    System.out.println("\n");
                }

            }

            if ((Instr & mask1) == addInst) {
                //$d = $s + $t; advance_pc (4);
                general_Registers[d] = general_Registers[s] + general_Registers[t];
                adv_pc(4);
            } else if ((Instr & mask2) == addIInst) {
                //$t = $s + imm; advance_pc (4);
                general_Registers[t] = general_Registers[s] + imm;
                adv_pc(4);
            } else if ((Instr & mask2) == addIUInst) {
                //$t = $s + imm; advance_pc (4);
                general_Registers[t] = general_Registers[s] + imm;
                adv_pc(4);
            } else if ((Instr & mask1) == addUInst) {
                //$d = $s + $t; advance_pc (4);
                general_Registers[d] = general_Registers[s] + general_Registers[t];
                adv_pc(4);
            } else if ((Instr & mask1) == andInst) {
                //$d = $s & $t; advance_pc (4);
                general_Registers[d] = general_Registers[s] + general_Registers[t];
                adv_pc(4);
            } else if ((Instr & mask2) == andIInst) {
                //$t = $s & imm; advance_pc (4);
                general_Registers[t] = general_Registers[s] + imm;
                adv_pc(4);
            } else if ((Instr & mask2) == beqInst) {
                //if $s == $t advance_pc (offset << 2)); else advance_pc (4)
                if (general_Registers[s] == general_Registers[t])
                    adv_pc(signExtendImm << 2);
                else adv_pc(4);
            } else if ((Instr & mask3) == bgezInst) {
                //if $s >= 0 advance_pc (offset << 2)); else advance_pc (4);
                if (general_Registers[s] >= 0)
                    adv_pc(signExtendImm << 2);
                else adv_pc(4);
            } else if ((Instr & mask3) == bgezalInst) {
                //if $s >= 0 $31 = PC + 8 (or nPC + 4); advance_pc (offset << 2)); else advance_pc (4);
                if (general_Registers[s] >= 0) {
                    general_Registers[31] = PC + 8;
                } else adv_pc(signExtendImm << 2);
            } else if ((Instr & mask3) == bgtzInst) {
                //if $s > 0 advance_pc (offset << 2)); else advance_pc (4);
                if (general_Registers[s] > 0)
                    adv_pc(signExtendImm << 2);
                else adv_pc(4);
            } else if ((Instr & mask3) == blezInst) {
                //if $s <= 0 advance_pc (offset << 2)); else advance_pc (4);
                if (general_Registers[s] <= 0)
                    adv_pc(signExtendImm << 2);
                else adv_pc(4);
            } else if ((Instr & mask3) == bltzInst) {

                if (general_Registers[s] < 0)
                    adv_pc(signExtendImm << 2);
            } else if ((Instr & mask3) == bltzalInst) {
                //if $s < 0 $31 = PC + 8 (or nPC + 4); advance_pc (offset << 2)); else advance_pc (4);
                if (general_Registers[s] < 0) {
                    general_Registers[s] = PC + 8;
                    adv_pc(signExtendImm << 2);
                } else adv_pc(4);
            } else if ((Instr & mask2) == bneInst) {
                //if $s != $t advance_pc (offset << 2)); else advance_pc (4);
                if (general_Registers[s] != general_Registers[t]) {
                    adv_pc(signExtendImm << 2);
                } else adv_pc(4);
            } else if ((Instr & mask4) == divInst) {
                //$LO = $s / $t; $HI = $s % $t; advance_pc (4);
                Lo = general_Registers[s] / general_Registers[t];
                Hi = general_Registers[s] % general_Registers[t];
                adv_pc(4);
            } else if ((Instr & mask2) == jumpInst) {
                //PC = nPC; nPC = (PC & 0xf0000000) | (target << 2);
                PC = nPC;
                nPC = (PC & 0xf0000000) | (target << 2);
            } else if ((Instr & mask2) == jalInst) {
                //$31 = PC + 8 (or nPC + 4); PC = nPC; nPC = (PC & 0xf0000000) | (target << 2);
                general_Registers[31] = PC + 8;
                PC = nPC;
                nPC = (PC & 0xf0000000) | (target << 2);
            } else if ((Instr & mask5) == jrInst) {
                //PC = nPC; nPC = $s;
                PC = nPC;
                nPC = general_Registers[s];
            } else if ((Instr & mask2) == lbInst) {
                //$t = MEM[$s + offset]; advance_pc (4);
                general_Registers[t] = main_Memory[s + imm];
                adv_pc(4);
            } else if ((Instr & mask2) == luiInst) {
                //$t = (imm << 16); advance_pc (4);
                general_Registers[t] = (imm << 16);
                adv_pc(4);
            } else if ((Instr & mask2) == lwInst) {
                //$t = MEM[$s + offset]; advance_pc (4);
                general_Registers[t] = main_Memory[s + imm];
                adv_pc(4);
            } else if ((Instr & mask6) == mfhiInst) {
                //$d = $HI; advance_pc (4);
                general_Registers[d] = Hi;
                adv_pc(4);
            } else if ((Instr & mask6) == mfloInst) {
                //$d = $LO; advance_pc (4);
                general_Registers[d] = Lo;
                adv_pc(4);
            } else if ((Instr & mask4) == multInst) {
                //$LO = $s * $t; advance_pc (4);
                Lo = general_Registers[s] * general_Registers[t];
                adv_pc(4);
            } else if ((Instr & mask1) == orInst) {
                //$d = $s | $t; advance_pc (4);
                general_Registers[d] = general_Registers[s] | general_Registers[t];
                adv_pc(4);
            } else if ((Instr & mask2) == oriInst) {
                //$t = $s | imm; advance_pc (4);
                general_Registers[t] = general_Registers[s] | imm;
                adv_pc(4);
            } else if ((Instr & mask2) == sbInst) {
                //MEM[$s + offset] = (0xff & $t); advance_pc (4);
                main_Memory[s + offset] = (0xff & general_Registers[t]);
                adv_pc(4);
            } else if ((Instr & mask7) == sllInst) {
                //$d = $t << h; advance_pc (4);
                general_Registers[d] = general_Registers[t] << shamt;
                adv_pc(4);
            } else if ((Instr & mask7) == sllvInst) {
                //$d = $t << $s; advance_pc (4);
                general_Registers[d] = general_Registers[t] << general_Registers[s];
                adv_pc(4);
            } else if ((Instr & mask1) == sltInst) {
                //if $s < $t $d = 1; advance_pc (4); else $d = 0; advance_pc (4);
                if (general_Registers[s] < general_Registers[t]) {
                    general_Registers[d] = 1;
                    adv_pc(4);
                } else {
                    general_Registers[d] = 0;
                    adv_pc(4);
                }
            } else if ((Instr & mask2) == sltiInst) {
                //if $s < imm $t = 1; advance_pc (4); else $t = 0; advance_pc (4);
                if (general_Registers[s] < imm) {
                    general_Registers[t] = 1;
                    adv_pc(4);
                } else {
                    general_Registers[t] = 0;
                    adv_pc(4);
                }
            } else if ((Instr & mask2) == sltiuInst) {
                //if $s < imm $t = 1; advance_pc (4); else $t = 0; advance_pc (4);
                if (general_Registers[s] < imm) {
                    general_Registers[t] = 1;
                    adv_pc(4);
                } else {
                    general_Registers[t] = zero;
                    adv_pc(4);
                }
            } else if ((Instr & mask1) == sltuInst) {
                //if $s < $t $d = 1; advance_pc (4); else $d = 0; advance_pc (4);
                if (general_Registers[s] < general_Registers[t]) {
                    general_Registers[d] = 1;
                    adv_pc(4);
                } else {
                    general_Registers[d] = zero;
                    adv_pc(4);
                }
            } else if ((Instr & mask7) == sraInst) {
                //$d = $t >> h; advance_pc (4);
                general_Registers[d] = general_Registers[t] >> shamt;
                adv_pc(4);
            } else if ((Instr & mask7) == srlInst) {
                //$d = $t >> h; advance_pc (4);
                general_Registers[d] = general_Registers[t] >> shamt;
                adv_pc(4);
            } else if ((Instr & mask1) == srlvInst) {
                //$d = $t >> $s; advance_pc (4);
                general_Registers[d] = general_Registers[t] >> general_Registers[s];
                adv_pc(4);
            } else if ((Instr & mask1) == subInst) {
                //$d = $s - $t; advance_pc (4);
                general_Registers[d] = general_Registers[s] - general_Registers[t];
                adv_pc(4);
            } else if ((Instr & mask1) == subuInst) {
                //$d = $s - $t; advance_pc (4);
                general_Registers[d] = general_Registers[s] - general_Registers[t];
                adv_pc(4);
            } else if ((Instr & mask2) == swInst) {
                //MEM[$s + offset] = $t; advance_pc (4);
                main_Memory[s + offset] = general_Registers[t];
                adv_pc(4);
            } else if ((Instr & mask7) == syscallInst) {
                //advance_pc (4);
                if (general_Registers[2] == 1) {
                    System.out.println(general_Registers[4]);
                } else if (general_Registers[2] == 4) {
                    //register 4 points to the string
                    int address = general_Registers[4];
                    while (true) {
                        int temp = main_Memory[address / 4];
                        temp >>= (address % 4) * 8;
                        temp &= 0xFF;

                        if (temp == '\0')
                            break;
                        address++;
                        System.out.print((char) temp);
                    }


                } else if (general_Registers[2] == 11) {
                    System.out.print((char) general_Registers[4]);
                } else if (general_Registers[2] == 5) {
                    Scanner userIn = new Scanner(System.in);
                    general_Registers[2] = userIn.nextInt();
                } else if (general_Registers[2] == 8) {
                    Scanner userIn = new Scanner(System.in);

                    int size = general_Registers[5] - 1;
                    String userString = userIn.nextLine();
                    for (int i = 0; i < size; i++) {
                        main_Memory[general_Registers[4 + i]] = (int) userString.charAt(i);
                    }
                } else if (general_Registers[2] == 9) {
                    int empty = general_Registers[4];
                    general_Registers[2] = memAllocat;
                    memAllocat += empty;
                } else if (general_Registers[2] == 10) {
                    System.exit(0);
                }
                adv_pc(4);
            } else if ((Instr & mask7) == xorInst) {
                //$d = $s ^ $t; advance_pc (4);
                general_Registers[d] = general_Registers[s] ^ general_Registers[t];
                adv_pc(4);
            } else if ((Instr & mask2) == xoriInst) {
                //$t = $s ^ imm; advance_pc (4);
                general_Registers[t] = general_Registers[s] ^ imm;
                adv_pc(4);
            }
        }

    }

    public static void adv_pc(int offset) {
        PC = nPC;
        nPC += offset;
    }
}


