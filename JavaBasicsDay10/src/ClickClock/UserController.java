package ClickClock;

import java.util.List;

public class UserController {
    final private UserService userService;

    public UserController() {
        this.userService = new UserService();
    }

    public boolean login(String email, String password) {
        return userService.login(email, password);
    }

    public List<User> getUserList () {
        return userService.getUserList();
    }

    public List<Video> getAllVideoList () {
        return userService.getAllVideoList();
    }

    public void createUser(User user) {
        this.userService.createUser(user);
    }

    public void deleteUser(User user) {
        this.userService.deleteUser(user);
    }

    public void postVideo(Video video) {
        this.userService.postVideo(video);
    }

    public List<Video> getVideoList () {
        return userService.getVideoList();
    }

    public User getActualUser() {
        return this.userService.getActualUser();
    }
}