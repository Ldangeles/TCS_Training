package ClickClock;

import java.util.List;

public class AdminService {

    public boolean adminLogin(String email, String password) {
        return email.equals("admin") && password.equals("admin");
    }

    public void getUserList(UserController userController) {
        List<User> users = userController.getUserList();

        if(users.size() == 0) {
            System.out.println("Empty user list");
        } else {
            for(User user : users) {
                System.out.println(user);
            }
        }
    }

    public void getVideoList(UserController userController) {
        List<Video> videos = userController.getAllVideoList();

        if(videos.size() == 0) {
            System.out.println("Empty video list");
        } else {
            for(Video video : videos) {
                System.out.println(video);
            }
        }
    }


}
