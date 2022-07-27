public class LabHandsOn {

    public static void main(String[] args){
        String[] contactList = new String[] {"Alan", "Alexis", "Daniela", "Fernanda", "Juan", "Priscila", "Zeta"};

        for (String str: contactList) {
            if (!str.contains("Z")&&!str.contains("z")){
                System.out.println("Email sent to: " + str);
            }
        }
    }
}
