import java.util.Scanner;

/*Pedir una nota de 0 a 10 y mostrarla de la forma: Insuficiente, Suficiente, Bien...*/

public class Exercise3 {

    public static void main(String [] args){

        Scanner in = new Scanner(System.in);

        System.out.print("Type your note: ");
        int note = Integer.parseInt(in.nextLine());

        switch (note){
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                System.out.print("Insufficient"); break;
            case 6:
            case 7:
                System.out.print("Sufficient"); break;
            case 8:
                System.out.print("Good"); break;
            case 9:
                System.out.print("Excellent"); break;
            case 10:
                System.out.print("Perfect"); break;
        }
    }
}

