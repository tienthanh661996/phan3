package ra.jdbc.dao;

import ra.jdbc.model.Song;

import java.util.List;

public interface ISongDao {
    List<Song> findAllSong();
    void save(Song song);
    void delete(String id);
    List<Song>findSongByName(String search);
}
