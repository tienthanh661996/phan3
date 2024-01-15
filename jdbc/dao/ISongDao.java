package ra.jdbc.dao;

import ra.jdbc.model.Song;

import java.util.List;

public interface ISongDao {
    List<Song> findAllSong();

}
