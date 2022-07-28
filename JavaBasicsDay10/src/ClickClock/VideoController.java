package ClickClock;

import java.util.List;

public class VideoController {
    private VideoService videoService;

    public VideoController() {
        this.videoService = new VideoService();
    }

    public List<Video> getVideoList () {
        return videoService.getVideoList();
    }

    public void createVideo(Video video) {
        this.videoService.createVideo(video);
    }

    public void deleteVideo(Video video) {
        this.videoService.deleteVideo(video);
    }
}