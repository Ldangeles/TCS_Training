package ClickClock;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class FrontEnd {

    final private Scanner in;
    final private UserController userController;
    final private AdminService adminService;

    public FrontEnd() {
        this.in = new Scanner(System.in);
        this.userController = new UserController();
        this.adminService = new AdminService();
    }

    public void run() {
        boolean success = false;
        int option = 0;

        while (!success) {
            this.printMainMenu();

            try {
                option = this.in.nextInt();

                if (option > 4) {
                    throw new IllegalArgumentException();
                }
                success = true;
            } catch (InputMismatchException exception){
                System.out.println("Please select one of the options");
                this.printMainMenu();
                option = this.in.nextInt();
            } catch (IllegalArgumentException exception){
                System.out.println("Please select one of the options");
            }

        }

        switch (option) {
            case 1 -> this.login();
            case 2 -> this.signup();
            case 3 -> this.adminLogin();
            case 4 -> this.runExit();
        }

    }

    private void runAdmin() {

        printAdminMenu();
        int option = this.in.nextInt();
        switch (option) {
            case 1 -> this.adminService.getUserList(this.userController);
            case 2 -> this.adminService.getVideoList(this.userController);
            case 3 -> this.runExit();
        }
    }

    private void runExit() {
        this.printExitMenu();
        System.exit(0);
    }

    private void runUser() {

        this.printUserMenu();
        int option = this.in.nextInt();
        switch (option) {
            case 1 -> this.postVideo();
            case 2 -> this.getVideoList();
            case 3 -> this.deleteUser();
            case 4 -> this.runExit();
        }
    }

    private void login() {
        System.out.print("\nEnter username: ");
        String username = this.in.next();
        System.out.print("\nEnter password: ");
        String password = this.in.next();

        if(this.userController.login(username, password)) {
            System.out.println("Login Successful");
            //actualUser = userController.getActualUser();
            runUser();
        } else {
            System.out.println("Wrong username or password");
        }

    }

    private void postVideo(){
        System.out.print("\nEnter title: ");
        String title = this.in.next();
        System.out.print("\nEnter description: ");
        String description = this.in.next();
        System.out.print("\nEnter duration: ");
        int duration = this.in.nextInt();

        Video video = new Video(title, description, duration, userController.getActualUser().getUsername());

        this.userController.createVideo(video);
    }

    private void getVideoList() {
        List<Video> videos = this.userController.getVideoList();

        if(videos.size() == 0) {
            System.out.println("Empty video list");
        } else {
            for(Video video : videos) {
                System.out.println(video);
            }
        }
    }

    private void deleteUser() {
        System.out.print("\nEnter email: ");
        String email = this.in.next();
        User user = new User();
        user.setEmail(email);

        this.userController.deleteUser(user);
    }

    private void signup() {
        System.out.print("\nEnter username: ");
        String username = this.in.next();
        System.out.print("\nEnter email: ");
        String email = this.in.next();
        System.out.print("\nEnter password: ");
        String password = this.in.next();

        User user = new User(username, email, password);

        this.userController.createUser(user);
    }
    private void adminLogin() {
        System.out.print("""
                ------------
                ADMIN LOGIN
                ------------""");

        System.out.print("\nEnter email: ");
        String email = this.in.next();
        System.out.print("\nEnter password: ");
        String password = this.in.next();

        if(this.adminService.adminLogin(email, password)) {
            System.out.println("Login Successful");
            runAdmin();
        } else {
            System.out.println("Wrong username or password");
        }

    }

    private void printMainMenu() {
        System.out.println("""
                ------------
                MAIN MENU
                ------------""");
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
                1: Post Video
                2: Video List
                3: Delete User
                4: EXIT
                >\s""");
    }

    private void printAdminMenu() {
        System.out.print("""
                1: User List
                2: Video List
                3: EXIT
                >\s""");
    }

    private void printExitMenu() {
        System.out.println("\nSee you later!");
        this.in.close();
    }

}
