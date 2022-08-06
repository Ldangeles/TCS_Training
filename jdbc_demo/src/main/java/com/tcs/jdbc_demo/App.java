package com.tcs.jdbc_demo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        try (Connection connection = DataSource.connect()){
            VideoDAO videoDAO = new VideoDAO(connection);

            Video video = new Video(0,1,"LeoVid3","ClassTest",34);

            videoDAO.publishVideo(video);

            List<Video> videos = videoDAO.getAllVideos();
            System.out.println(videos);

        } catch (SQLException exception){
            System.err.println("Couldn't connect to database");
        }

    }
}
