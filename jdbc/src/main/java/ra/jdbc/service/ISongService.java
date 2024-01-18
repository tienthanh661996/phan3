package ra.jdbc.service;

import ra.jdbc.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> findAll();
    List<Song>  findSongByName(String search);
    void save (Song song);
    void delete (String id);

}

