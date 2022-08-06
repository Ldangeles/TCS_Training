package com.tcs.jdbc_demo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VideoDAO {

    final private Connection connection;

    public VideoDAO(Connection connection){
        this.connection = connection;
    }

    public List<Video> getAllVideos() throws SQLException{
        String sql = "SELECT * FROM videos";

        try(Statement statement = connection.createStatement()){
            List<Video> videos = new ArrayList<>();
            ResultSet rs = statement.executeQuery(sql);

            while(rs.next()){
                int id = rs.getInt("id");
                int user_id = rs.getInt("user_id");
                String title = rs.getString("title");
                String description = rs.getString("description");
                int duration = rs.getInt("duration");

                Video video = new Video(id, user_id, title, description, duration);
                videos.add(video);
            }
            return videos;
        }
    }

    public void publishVideo(Video video) throws SQLException{
        String sql = "INSERT INTO videos (user_id, title, description, duration) values (?, ?, ?, ?)";

        try(PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, video.getUser_id());
            statement.setString(2,video.getTitle());
            statement.setString(3,video.getDescription());
            statement.setInt(4,video.getDuration());

            statement.executeUpdate();
        }
    }
}
