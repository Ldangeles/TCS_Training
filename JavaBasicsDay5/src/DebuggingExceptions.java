import java.util.Scanner;

public class DebuggingExceptions {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        boolean success = false;

        while (!success){

            System.out.print("Type the grades with commas in between: ");
            String input = in.nextLine();

            String[] numbers = input.split(",");
            double[] grades = new double[numbers.length];

            try {
                for (int i=0; i<numbers.length; i++){
                    grades[i]=Double.parseDouble(numbers[i]);
                }
                double average = average(grades);
                System.out.println("Average is "+average);
                success = true;
            } catch (NoGradesAvailableException exception){
                System.out.println("Type at least one grade");
                System.out.println("-----------------------");
            }



        }


    }

    public static double average(double[] grades) throws NoGradesAvailableException {
        if (grades.length == 0){
            throw new NoGradesAvailableException();
        }

        double sum = 0;

        for (double grade : grades){
            sum = sum + grade;
        }

        return sum / grades.length;
    }

}


