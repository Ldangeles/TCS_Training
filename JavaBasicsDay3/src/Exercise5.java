/*Leer un número y mostrar su cuadrado, repetir el proceso hasta que se introduzca un número negativo.*/

import java.util.Scanner;

public class Exercise5 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        System.out.print("Type an integer: ");
        int number = Integer.parseInt(in.nextLine());

        if (number>0){
            while (number>0){
                System.out.println(Math.pow(number,2));
                System.out.print("Type an integer: ");
                number = Integer.parseInt(in.nextLine());
            }
        }

    }

}
