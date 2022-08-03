package ClickClock;

import java.util.LinkedList;
import java.util.List;

public class User {
    private String username;
    private String email;
    private String password;

    private List<Video> videos;

    public User() {
        this.videos = new LinkedList<Video>();
    }

    public List<Video> getVideoList () {
        return this.videos;
    }

    public void createVideo(Video video) {
        this.videos.add(video);
    }

    public void deleteVideo(Video video) {
        for(int i = 0; i < this.videos.size(); i++) {
            Video v = this.videos.get(i);
            if(v.getTitle().equals(video.getTitle())) {
                this.videos.remove(i);
                break;
            }
        }
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;

        this.videos = new LinkedList<Video>();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "User [username=" + username + ", email=" + email + "]";
    }

}

