public class Debugging {

    public static void main(String[] args){
        double[] grades = new double[]{

        };

        try {
            double average = average(grades);
            System.out.println(average);
        } catch (IllegalArgumentException exception){
            System.out.println(exception.getMessage());
        }
    }

    public static double average(double[] grades) throws IllegalArgumentException {
        if (grades.length == 0){
            throw new IllegalArgumentException("There are now grades registered");
        }

        double sum = 0;

        for (double grade : grades){
            sum = sum + grade;
        }

        return sum / grades.length;
    }

}
