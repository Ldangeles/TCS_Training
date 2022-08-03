package ClickClock;

import java.util.LinkedList;
import java.util.List;

public class UserService {
    private List<User> users;
    private User actualUser;

    public UserService() { //Constructor
        this.users = new LinkedList<User>(); //Create a list of User objects
    }

    public void createUser(User user) {
        for (User u : this.users) {
            if (u.getUsername().equals(user.getUsername()) || u.getEmail().equals(user.getEmail())) {
                throw new IllegalArgumentException();
            }
        }
        this.users.add(user);
    } //Add a user to users LinkedList
    public void postVideo(Video video){
        for (Video v : this.actualUser.getVideoList()) {
            if (v.getTitle().equals(video.getTitle())) {
                throw new IllegalArgumentException();
            }
        }

        this.actualUser.postVideo(video);
    } //Creates a video instance with a method from the actualUser instance

    public User getActualUser() {
        return actualUser;
    } //Getter for "actualUser" instance of User

    public boolean login(String email, String password) { //Login check
        for(User user : this.users) {
            if(user.getEmail().equals(email) && user.getPassword().equals(password)) {
                actualUser = user;
                return true;
            }
        }
        return false;
    }

    public List<User> getUserList () {
        return this.users;
    } //Getter for the complete users LinkedList

    public User getUser(User user) {
        //for(int i = 0; i < this.users.size(); i++)
        for (User u : this.users) {
            if (u.getEmail().equals(user.getEmail()))
                return user;
            else
                System.exit(0);
        }
        return user;
    }

    public void deleteUser(User user) { // Remove a User instance from users LinkedList
        for(int i = 0; i < this.users.size(); i++) {
            User u = this.users.get(i);
            if(u.getEmail().equals(user.getEmail())) {
                this.users.remove(i);
                break;
            }
        }
    }

    public List<Video> getVideoList () {
        return actualUser.getVideoList();
    } //Returns the video LinkedList inside the actualUser instance

    public List<Video> getAllVideoList () {
        List<Video> videos = new LinkedList<Video>(); // Create a LL to save ALL videos from all User instances

        /*for(int i = 0; i < this.users.size(); i++) {
            User u = this.users.get(i);
            List<Video> temp = u.getVideoList();
            for(int j = 0; j < temp.size(); j++){
                Video v = temp.get(j);
                videos.add(v);
            }
        }*/

        for (User u : this.users) { //Iterates in every User instance inside users LL
            List<Video> temp = u.getVideoList(); //Save LL from specific user in temp
            videos.addAll(temp); //Save all Video instances inside temp into videos LL
        }
        return videos;
    }
}

