import java.util.Scanner;

public class PrimeOrNot {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        boolean success = false;
        int n = 0;

        while (!success) {

            try {
                System.out.print("Type an integer to see if it's prime or not: ");
                n = Integer.parseInt(in.nextLine());

                if (n <= 0)
                    throw new IllegalArgumentException();

                success = true;
            } catch (IllegalArgumentException exception) {
                System.out.println("-----------------------");
                System.out.println("Type a positive integer");
                System.out.println("-----------------------");
            }
        }

        boolean notPrime = false;

        for (int i = 2; i <= n / 2; ++i) {
            if (n % i == 0) {
                notPrime = true;
                break;
            }
        }

        if (notPrime)
            System.out.println(n + " is not a prime number.");
        else
            System.out.println(n + " is a prime number.");
    }
}

