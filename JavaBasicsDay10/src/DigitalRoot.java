import java.util.Scanner;

public class DigitalRoot {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        boolean success = false;
        String n = "0";

        while (!success) {

            try {
                System.out.print("Type an integer to obtain it's digital root: ");
                n = in.nextLine();

                if (Integer.parseInt(n) <= 0)
                    throw new IllegalArgumentException();

                success = true;
            } catch (IllegalArgumentException exception) {
                System.out.println("-----------------------");
                System.out.println("Type a positive integer");
                System.out.println("-----------------------");
            }
        }

        System.out.print("The digital root of "+n+" is: "+digitalRoot(n));
    }

    public static int digitalRoot(String n){
        char[] numberArray = n.toCharArray();
        int result = 0;

        for(char num : numberArray){
            result += num-48;
        }
        return result;
    }
}
