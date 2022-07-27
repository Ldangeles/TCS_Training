import java.util.Scanner;
/* Pedir el día, mes y año de una fecha e indicar si la fecha es correcta. Suponiendo todos los meses de 30 días. */

public class Exercise1 {

    public static void main(String [] args){
        Scanner in = new Scanner(System.in);

        System.out.print("Type the day of the month: ");
        int day = isLessThan32(Integer.parseInt(in.nextLine()));

        System.out.print("Type the day of the month (Mmm): ");
        String month = isMonth(in.nextLine());

        if(day >= 30){
            if (month.equals("Feb")){
                System.out.print("February doesn't have 30 days");
            }

            if(day == 31 && !has31days(month)){
                System.out.print("Month doesn't have 31 days");
                System.exit(0);
            }
        }

        System.out.print("Type the year: ");
        int year = Integer.parseInt(in.nextLine());

        System.out.print("La fecha "+ month+" "+ day+" "+ year + " es correcta");
    }

    public static int isLessThan32 (int day){
        Scanner in = new Scanner(System.in);

        if (day <= 31){
            return day;
        } else {
            System.out.print("Type a valid day: ");
            isLessThan32(Integer.parseInt(in.nextLine()));
        }
        return day;
    }

    public static String isMonth(String month){
        Scanner in = new Scanner(System.in);

        if (month.matches("Jan|Feb|Mar|May|Jul|Aug|Oct|Dic|Apr|Jun|Sep|Nov")){
            return month;
        } else {
            System.out.println("Type a valid month: ");
            isMonth(in.nextLine());
        }
        return month;
    }

    public static boolean has31days(String month){
        return month.matches("Jan|Mar|May|Jul|Aug|Oct|Dic");
    }


}
