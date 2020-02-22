package spotify.song.service.impl;

import org.springframework.stereotype.Service;
import spotify.song.repository.Song;
import spotify.song.repository.SongRepository;
import spotify.song.service.SongService;

import java.util.List;

@Service
public class SongServiceImpl implements SongService {

    private final SongRepository songRepository;

    public SongServiceImpl(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @Override
    public void addSong(Song song) {
        songRepository.add(song);
    }

    @Override
    public void deleteSong(long id) {
        songRepository.delete(id);
    }

    @Override
    public Song getSong(long id) {
        return songRepository.get(id);
    }

    @Override
    public List<Song> getAllSongs() {
        return songRepository.getAll();
    }

    @Override
    public void update(Song song) {
        songRepository.update(song);
    }
}
