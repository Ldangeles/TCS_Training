package ClickClock;

import java.util.List;

public class UserController {
    private UserService userService;

    public UserController() {
        this.userService = new UserService();
    }

    public boolean login(String email, String password) {
        return userService.login(email, password);
    }

    public List<User> getUserList () {
        return userService.getUserList();
    }

    public void createUser(User user) {
        this.userService.createUser(user);
    }

    public void deleteUser(User user) {
        this.userService.deleteUser(user);
    }
}