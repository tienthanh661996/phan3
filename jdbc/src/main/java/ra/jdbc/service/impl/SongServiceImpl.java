package ra.jdbc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.jdbc.dao.ISongDao;
import ra.jdbc.model.Song;
import ra.jdbc.service.ISongService;

import java.util.List;
@Service
public class SongServiceImpl implements ISongService {
    @Autowired
    private ISongDao songDao;

    @Override
    public List<Song> findAll() {
        return  songDao.findAllSong();
    }

    @Override
    public void save(Song song) {
        songDao.save(song);
    }

    @Override
    public void delete(String id) {
        songDao.delete(id);
    }

    @Override
    public List<Song> findSongByName(String search) {
        return songDao.findSongByName(search);

    }
}
