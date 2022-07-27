import java.util.Scanner;

public class ChessBoard {

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        boolean success = false;
        int n = 0;

        while (!success) {

            try {
                System.out.print("Type size of the chess board: ");
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
            System.out.print("\n");

            for(int j = 1; j<=n; j++){

                if(i%2==0){
                    if(j%2==0){
                        System.out.print(" N ");
                    } else {
                        System.out.print(" B ");
                    }
                } else {
                    if(j%2==0){
                        System.out.print(" B ");
                    } else {
                        System.out.print(" N ");
                    }
                }

            }
        }

    }
}
