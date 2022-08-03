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

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;

        this.videos = new LinkedList<Video>();
    }

    public String getUsername() {
        return username;
    }
    public String getEmail() {
        return email;
    }
    public List<Video> getVideoList () {
        return this.videos;
    }
    public String getPassword() {
        return password;
    }

    public void postVideo(Video video) {
        for (Video v : this.videos) {
            if (v.getTitle().equals(video.getTitle())) {
                throw new IllegalArgumentException();
            }
        }
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

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "User [username= " + username + ", email= " + email +", # of videos= "+this.videos.size()+"]";
    }

}

