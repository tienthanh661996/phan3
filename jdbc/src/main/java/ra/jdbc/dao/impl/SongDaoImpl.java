package ra.jdbc.dao.impl;

import ra.jdbc.dao.ISongDao;
import ra.jdbc.model.Song;
import ra.jdbc.util.ConnectDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SongDaoImpl implements ISongDao {
    @Override
    public List<Song> findAllSong() {
        List<Song>list =new ArrayList<>();
        Connection conn = ConnectDB.openConnection();
        try {
            CallableStatement callSt = conn.prepareCall("select* from Song");
            ResultSet rs =callSt.executeQuery();
            while (rs.next()){
                Song s=new Song();
                s.setId(rs.getInt("id"));
                s.setSongname(rs.getString("songname"));
                s.setAuthor(rs.getString("author"));
                s.setDescription(rs.getString("description"));
                s.setImageUrl(rs.getString("imageUrl"));
                s.setVideoUrl(rs.getString("videoUrl"));
                s.setDuration(rs.getInt("duration"));
                s.setStatus(rs.getBoolean("status"));
                list.add(s);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectDB.closeConnection(conn);
        }
        return  list;
    }

    @Override
    public void save(Song song) {
            Connection conn = ConnectDB.openConnection();

        }

    @Override
    public void delete(String id) {
            Connection conn = ConnectDB.openConnection();
            try {
                CallableStatement CallST =conn.prepareCall(("SELECT *from Song where id =?"));
                CallST.setString(1,id);
                CallST.executeUpdate();
            }
     catch (SQLException e) {
        throw new RuntimeException(e);
    }finally {
        ConnectDB.closeConnection(conn);
    }
}

    @Override
    public List<Song> findSongByName(String search) {
        List<Song> list = new ArrayList<>();
        Connection conn = ConnectDB.openConnection();
        try {
            CallableStatement callSt = conn.prepareCall("select* from Song where songName like ?");
            callSt.setString(1, "%" + search + "%");
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                Song s = new Song();
                s.setId(rs.getInt("id"));
                s.setSongname(rs.getString("songname"));
                s.setAuthor(rs.getString("author"));
                s.setDescription(rs.getString("description"));
                s.setImageUrl(rs.getString("imageUrl"));
                s.setVideoUrl(rs.getString("videoUrl"));
                s.setDuration(rs.getInt("duration"));
                s.setStatus(rs.getBoolean("status"));
                list.add(s);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectDB.closeConnection(conn);
        }
        return list;
    }}