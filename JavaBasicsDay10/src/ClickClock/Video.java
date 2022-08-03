package ClickClock;

public class Video {
    private String title;
    private String description;
    private int duration;
    final private String username;

    public Video(String title, String description, int duration, String username) {
        this.title = title;
        this.description = description;
        this.duration = duration;
        this.username = username;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Video [title= " + title + ", description= " + description + ", duration= "+duration+", username= "+username+"]";
    }

}
