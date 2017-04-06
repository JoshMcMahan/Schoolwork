import java.util.Scanner;

public class Average {
    public static void main(String[] args)
    {
        System.out.println("Enter a series of numbers.  Enter a negative number to quit.");

        Scanner scanInput = new Scanner(System.in);
        double userInput = 0;
        double userSum = 0;
        int counter = 0;


        boolean Running = true;
        while(Running)
        {
            userInput = Double.parseDouble(scanInput.next());
            if (userInput >= 0) {
                userSum = userInput + userSum;
                counter++;

            } else
            {
                System.out.println("You entered a negative number");
                Running = false;
            }
        }

        System.out.println("You entered " + counter + " numbers averaging " + userSum/counter);
    }


}

