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
        boolean isExiting = false;
        int option = 0;

        while (!isExiting){
            boolean isAnOption = false;

            while (!isAnOption) {
                this.printMainMenu();

                try {
                    option = this.in.nextInt();

                    if (option > 4) {
                        throw new IllegalArgumentException();
                    }
                    isAnOption = true;
                } catch (InputMismatchException exception){
                    System.out.println("Please use a NUMBER to select one of the options below\n");
                    in.next();
                } catch (IllegalArgumentException exception){
                    System.out.println("Please select one of the options\n");
                }

            }

            if (option == 4)
                isExiting = true;

            switch (option) {
                case 1 -> this.login();
                case 2 -> this.signup();
                case 3 -> this.adminLogin();
                case 4 -> this.runExit();
            }
        }

    }

    private void runUser() {

        boolean isExiting = false;
        int option = 0;

        while (!isExiting) {
            boolean isAnOption = false;

            while (!isAnOption) {
                this.printUserMenu();
                try {
                    option = this.in.nextInt();

                    if (option > 4) {
                        throw new IllegalArgumentException();
                    }
                    isAnOption = true;
                } catch (InputMismatchException exception) {
                    System.out.println("Please use a NUMBER to select one of the options below\n");
                    in.next();
                } catch (IllegalArgumentException exception) {
                    System.out.println("Please select one of the options\n");
                }

            }

            if (option == 4)
                isExiting = true;

            switch (option) {
                case 1 -> this.postVideo();
                case 2 -> this.getVideoList();
                case 3 -> this.deleteUser();
                case 4 -> this.run();
            }
        }
    }

    private void runAdmin() {
        boolean isExiting = false;
        int option = 0;

        while (!isExiting) {
            boolean isAnOption = false;

            while (!isAnOption) {
                printAdminMenu();
                try {
                    option = this.in.nextInt();

                    if (option > 3) {
                        throw new IllegalArgumentException();
                    }
                    isAnOption = true;
                } catch (InputMismatchException exception) {
                    System.out.println("Please use a NUMBER to select one of the options below\n");
                    in.next();
                } catch (IllegalArgumentException exception) {
                    System.out.println("Please select one of the options\n");
                }
            }

            if (option == 3)
                isExiting = true;

            switch (option) {
                case 1 -> this.adminService.getUserList(this.userController);
                case 2 -> this.adminService.getVideoList(this.userController);
                case 3 -> this.run();
            }
        }
    }

    private void runExit() {
        this.printExitMenu();
        System.exit(0);
    }

    private void login() {
        System.out.print("""
                ------------
                USER LOGIN
                ------------""");
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
        boolean isAvailable = false;
        System.out.print("""
                ------------
                USER SIGNUP
                ------------""");

        while (!isAvailable) {

            System.out.print("\nEnter username: ");
            String username = this.in.next();
            System.out.print("\nEnter email: ");
            String email = this.in.next();
            System.out.print("\nEnter password: ");
            String password = this.in.next();

            User user = new User(username, email, password);

            try {
                this.userController.createUser(user);
                isAvailable = true;
            } catch (IllegalArgumentException exception) {
                System.out.println("Username or Email already in use");
            }
        }
    }

    private void postVideo(){
        boolean isAvailable = false;

        while (!isAvailable) {
            System.out.print("\nEnter title: ");
            String title = this.in.next();
            System.out.print("\nEnter description: ");
            String description = this.in.next();

            boolean isUnder5min = false;
            int duration = 0;

            while(!isUnder5min){
                try {
                    System.out.print("\nEnter duration in seconds: ");
                    duration = this.in.nextInt();
                    if (duration > 300) {
                        throw new IllegalArgumentException();
                    } else {
                        isUnder5min = true;
                    }
                } catch (IllegalArgumentException exception){
                    System.out.println("Video duration must be under 5 min (300 s)");
                } catch (InputMismatchException exception){
                    System.out.println("Please use a number to assign the video duration");
                    in.next();
                }
            }

            Video video = new Video(title, description, duration, userController.getActualUser().getUsername());

            try {
                this.userController.postVideo(video);
                isAvailable = true;
            } catch (IllegalArgumentException exception) {
                System.out.println("Title already in use");
            }

        }
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
        System.out.println("""
                ------------
                USER MENU
                ------------""");
        System.out.print("""
                1: Post Video
                2: Video List
                3: Delete User
                4: EXIT MAIN MENU
                >\s""");
    }

    private void printAdminMenu() {
        System.out.println("""
                ------------
                ADMIN MENU
                ------------""");
        System.out.print("""
                1: User List
                2: Video List
                3: EXIT MAIN MENU
                >\s""");
    }

    private void printExitMenu() {
        System.out.println("\nSee you later!");
        this.in.close();
    }

}
