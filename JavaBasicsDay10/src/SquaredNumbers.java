import java.util.Scanner;

public class SquaredNumbers {

        public static void main(String[] args){

            Scanner in = new Scanner(System.in);
            boolean success = false;
            int n = 0;

            while (!success) {

                try {
                    System.out.print("Type the max integer to square: ");
                    n = Integer.parseInt(in.nextLine());

                    if (n <= 0){
                        throw new IllegalArgumentException();
                    }

                    success = true;
                } catch (IllegalArgumentException exception) {
                    System.out.println("-----------------------");
                    System.out.println("Type a positive integer");
                    System.out.println("-----------------------");
                }
            }

            for(int i = 1; i<=n; i++){
                System.out.println(i+"^2 = "+Math.pow(i,2));
            }

        }
}
