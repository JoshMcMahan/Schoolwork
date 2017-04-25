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

    private final static int addInst = 0b000000000000000000000000100000;
    private final static int addIInst = 0b00100000000000000000000000000000;
    private final static int addIUInst = 0b00100100000000000000000000000000;
    private final static int addUInst = 0b00000000000000000000000000100001;
    private final static int andInst = 0b00000000000000000000000000100100;
    private final static int andIInst = 0b00110000000000000000000000000000;
    private final static int beqInst = 0b00010000000000000000000000000000;
    private final static int bgezInst = 0b00000100000000010000000000000000;
    private final static int bgezalInst = 0b00000100000100010000000000000000;
    private final static int bgtzInst = 0b00011100000000000000000000000000;
    private final static int blezInst = 0b00011000000000000000000000000000;
    private final static int bltzalInst = 0b00000100000100000000000000000000;
    private final static int bneInst = 0b00010100000000000000000000000000;
    private final static int divInst = 0b00000000000000000000000000011010;
    private final static int jumpInst = 0b00001000000000000000000000000000;
    private final static int jalInst = 0b00001100000000000000000000000000;
    private final static int jrInst = 0b00000000000000000000000000001000;
    private final static int lbInst = 0b10000000000000000000000000000000;
    private final static int luiInst = 0b00111100000000000000000000000000;
    private final static int lwInst = 0b10001100000000000000000000000000;
    private final static int mfhiInst = 0b00000000000000000000000000010000;
    private final static int mfloInst = 0b00000000000000000000000000001000;
    private final static int multInst = 0b00000000000000000000000000011000;
    private final static int orInst = 0b00000000000000000000000000100101;
    private final static int oriInst = 0b00110100000000000000000000000000;
    private final static int sbInst = 0b10100000000000000000000000000000;
    private final static int sllInst = 0b00000000000000000000000000000000;
    private final static int sllvInst = 0b00000000000000000000000000000100;
    private final static int sltInst = 0b00000000000000000000000000101010;
    private final static int sltiInst = 0b00101000000000000000000000000000;
    private final static int sltiuInst = 0b00101100000000000000000000000000;
    private final static int sltuInst = 0b00000000000000000000000000101011;
    private final static int sraInst = 0b00000000000000000000000000000010;
    private final static int srlInst = 0b00000000000000000000000000000010;
    private final static int srlvInst = 0b00000000000000000000000000000110;
    private final static int subInst = 0b00000000000000000000000000100010;
    private final static int subuInst = 0b00000000000000000000000000100011;
    private final static int swInst = 0b10101100000000000000000000000000;
    private final static int syscallInst = 0b00000000000000000000000000001100;
    private final static int xorInst = 0b00000000000000000000000000100110;
    private final static int xoriInst = 0b00111000000000000000000000000000;

    private final static int mask1 = 0b11111100000000000000011111111111;
    private final static int mask2 = 0b11111100000000000000000000000000;
    private final static int mask3 = 0b11111100000111110000000000000000;
    private final static int mask4 = 0b11111100000000001111111111111111;
    private final static int mask5 = 0b11111100000111111111111111111111;
    private final static int mask6 = 0b11111111111111110000011111111111;
    private final static int mask7 = 0b11111100000000000000000000111111;

    public static void main(String[] args) {

        // Loads the file that will be selected by the user into a scanner
        try {
            Scanner user_in = new Scanner(new File("hello.txt"));

            //checks the file for lines that don't start with [ and skips them
            while (user_in.hasNext()) {
                String currentLine = user_in.nextLine();
                String splitString[] = currentLine.split("\\s");

                for (String strings : splitString) {
                    if (strings.equals("")) {
                        continue;
                    }
                    if (strings.startsWith("[")) {
                        //Do stuff for start of line
                        strings = strings.substring(1, strings.length() - 1); // Remove brackets
                        if (strings.startsWith("P")) {
                            // Do PC code
                            System.out.println("Reached PC block, String is: " + strings);

                        } else if (strings.startsWith("R")) {
                            // Do R code

                            System.out.println("Reached R block, String is: " + strings);

                        } else
                        // Its a Hex address
                        {
                            System.out.println("We're a hex address inside brackets, String is: " + strings);
                        }
                    } else if (strings.startsWith("0x")) {
                        System.out.print(" Our instruction is: " + strings + "\n");
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
            int offset = 4;

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
                    adv_pc(offset << 2);
                else adv_pc(4);
            } else if ((Instr & mask3) == bgezInst) {
                //if $s >= 0 advance_pc (offset << 2)); else advance_pc (4);
                if (general_Registers[s] >= 0)
                    adv_pc(offset << 2);
                else adv_pc(4);
            } else if ((Instr & mask3) == bgezalInst) {
                //if $s >= 0 $31 = PC + 8 (or nPC + 4); advance_pc (offset << 2)); else advance_pc (4);
                if (general_Registers[s] >= 0) {
                    general_Registers[31] = PC + 8;
                } else adv_pc(offset << 2);
            } else if ((Instr & mask3) == bgtzInst) {
                //if $s > 0 advance_pc (offset << 2)); else advance_pc (4);
                if (general_Registers[s] > 0)
                    adv_pc(4);
            } else if ((Instr & mask3) == blezInst) {
                //if $s <= 0 advance_pc (offset << 2)); else advance_pc (4);
                if (general_Registers[s] <= 0)
                    adv_pc(offset << 2);
                else adv_pc(4);
            } else if ((Instr & mask3) == bltzalInst) {
                //if $s < 0 $31 = PC + 8 (or nPC + 4); advance_pc (offset << 2)); else advance_pc (4);
                if (general_Registers[s] < 0) {
                    general_Registers[s] = PC + 8;
                    adv_pc(offset << 2);
                } else adv_pc(4);
            } else if ((Instr & mask2) == bneInst) {
                //if $s != $t advance_pc (offset << 2)); else advance_pc (4);
                if (general_Registers[s] != general_Registers[t]) {
                    adv_pc(offset << 2);
                } else adv_pc(4);
            } else if ((Instr & mask4) == divInst) {
                //$LO = $s / $t; $HI = $s % $t; advance_pc (4);
                Lo = general_Registers[s] / general_Registers[t];
                Hi = general_Registers[s] % general_Registers[t];
                adv_pc(4);
            } else if ((Instr & mask2) == jumpInst) {
                //PC = nPC; nPC = (PC & 0xf0000000) | (target << 2);
                PC = nPC;
                nPC = (PC & 0xf0000000) | (general_Registers[t] << 2);
            } else if ((Instr & mask2) == jalInst) {
                //$31 = PC + 8 (or nPC + 4); PC = nPC; nPC = (PC & 0xf0000000) | (target << 2);
                general_Registers[31] = PC + 8;
                PC = nPC;
                nPC = (PC & 0xf0000000) | (general_Registers[t] << 2);
            } else if ((Instr & mask5) == jrInst) {
                //PC = nPC; nPC = $s;
                PC = nPC;
                nPC = general_Registers[s];
            } else if ((Instr & mask2) == lbInst) {
                //$t = MEM[$s + offset]; advance_pc (4);
                general_Registers[t] = main_Memory[s + offset];
                adv_pc(4);
            } else if ((Instr & mask2) == luiInst) {
                //$t = (imm << 16); advance_pc (4);
                general_Registers[t] = (imm << 16);
                adv_pc(4);
            } else if ((Instr & mask2) == lwInst) {
                //$t = MEM[$s + offset]; advance_pc (4);
                general_Registers[t] = main_Memory[s + offset];
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
                } else {general_Registers[d] = zero;
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
