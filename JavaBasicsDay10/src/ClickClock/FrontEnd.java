package ClickClock;
import java.util.List;
import java.util.Scanner;

public class FrontEnd {

    private Scanner in;
    private UserController userController;

    public FrontEnd() {
        this.in = new Scanner(System.in);
        this.userController = new UserController();
    }

    public void run() {
        int option = 0;
        while(option != 5) {
            this.printMainMenu();
            option = this.in.nextInt();
            switch (option) {
                case 1 -> this.login();
                case 2 -> this.signup();
                case 3 -> this.runAdmin();
                case 4 -> this.runExit();
            }
        }
    }

    private void runAdmin() {
        int option = 0;
        this.adminLogin();
        printAdminMenu();
        option = this.in.nextInt();
        switch (option) {
            case 1 -> this.getUserList();
            case 2 -> this.runExit();
        }
    }

    private void printMainMenu() {
        System.out.print("""
                Select Option:
                1: Login
                2: Sign up
                3: Admin
                4: EXIT
                >\s""");
    }

    private void printUserMenu() {
        System.out.print("""
                1: Update User
                2: Delete User
                3: EXIT
                >\s""");
    }

    private void printAdminMenu() {
        System.out.print("""
                1: User List
                2: EXIT
                >\s""");
    }

    private void runExit() {
        this.printExitMenu();
        System.exit(0);
    }

    private void printExitMenu() {
        System.out.println("\nSee you later!");
        this.in.close();
    }


    private void login() {
        System.out.print("\nEnter email: ");
        String email = this.in.next();
        System.out.print("\nEnter password: ");
        String password = this.in.next();

        if(this.userController.login(email, password)) {
            System.out.println("Login Successful");
            runUser();
        } else {
            System.out.println("Wrong Email or Password");
        }

    }

    private void runUser() {

        this.printUserMenu();
        int option = this.in.nextInt();
        switch (option) {
            case 1 -> this.updateUser();
            case 2 -> this.deleteUser();
            case 3 -> this.runExit();
        }
    }

    private void updateUser() {
        System.out.print("\nEnter email: ");
        String email = this.in.next();
        System.out.print("\nEnter first name: ");
        String firstName = this.in.next();
        System.out.print("\nEnter last name: ");
        String lastName = this.in.next();
        System.out.print("\nEnter age: ");
        int age = this.in.nextInt();
        System.out.print("\nEnter password: ");
        String password = this.in.next();

        User user = new User(firstName, lastName, age, email, password);

        this.userController.updateUser(user);
    }

    private void deleteUser() {
        System.out.print("\nEnter email: ");
        String email = this.in.next();
        User user = new User();
        user.setEmail(email);

        this.userController.deleteUser(user);
    }

    private void signup() {
        System.out.print("\nEnter first name: ");
        String firstName = this.in.next();
        System.out.print("\nEnter last name: ");
        String lastName = this.in.next();
        System.out.print("\nEnter age: ");
        int age = this.in.nextInt();
        System.out.print("\nEnter email: ");
        String email = this.in.next();
        System.out.print("\nEnter password: ");
        String password = this.in.next();

        User user = new User(firstName, lastName, age, email, password);

        this.userController.createUser(user);
    }

    private void adminLogin() {
        System.out.print("\nEnter email: ");
        String email = this.in.next();
        System.out.print("\nEnter password: ");
        String password = this.in.next();

        if(email.equals("admin") && password.equals("admin")) {
            System.out.println("Login Successful");
        } else {
            System.out.println("Wrong Email or Password");
        }
    }

    private void getUserList() {
        List<User> users = this.userController.getUserList();

        if(users.size() == 0) {
            System.out.println("Empty user list");
        } else {
            for(User user : users) {
                System.out.println(user);
            }
        }
    }

}
