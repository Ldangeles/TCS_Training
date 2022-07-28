package ClickClock;

import java.util.LinkedList;
import java.util.List;

public class VideoService {
    private List<Video> videos;

    public VideoService() {
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
}

