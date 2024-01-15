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
                s.setDescription)rs.getString("description")
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
