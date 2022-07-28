package ClickClock;

import java.util.LinkedList;
import java.util.List;

public class UserService {
    private List<User> users;

    public UserService() {
        this.users = new LinkedList<User>();
    }

    public boolean login(String email, String password) {
        for(User user : this.users) {
            if(user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public List<User> getUserList () {
        return this.users;
    }

    public void createUser(User user) {
        this.users.add(user);
    }

    public void updateUser(User user) {
        for (User u : this.users) {
            if (u.getEmail().equals(user.getEmail())) {
                u.setFirstName(user.getFirstName());
                u.setLastName(user.getLastName());
                u.setAge(user.getAge());
                u.setPassword(user.getPassword());
                break;
            }
        }
    }

    public void deleteUser(User user) {
        for(int i = 0; i < this.users.size(); i++) {
            User u = this.users.get(i);
            if(u.getEmail().equals(user.getEmail())) {
                this.users.remove(i);
                break;
            }
        }
    }
}

