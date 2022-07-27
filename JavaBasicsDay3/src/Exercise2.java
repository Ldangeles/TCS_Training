import java.util.Scanner;

/*Solicitar el nombre al usuario, en base a la entrada del usuario, validar si el nombre es su nombre,
mostrar mensaje: “correcto”, de otra forma, mostrar “no eres “ + <sunombre>. Usar operador ternario. */

public class Exercise2 {

    public static void main(String [] args){
        Scanner in = new Scanner(System.in);

        String username = "Leonardo";

        System.out.print("Type your name: ");
        String actualUser = in.nextLine();

        /*flag = (actualUser.equals(username)) ? true : false;*/
        boolean flag = actualUser.equals(username);

        if (flag){
            System.out.print("Correct");
        } else {
            System.out.print("You're not "+username);
        }

    }
}
