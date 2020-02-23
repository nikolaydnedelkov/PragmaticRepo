package spotify.song.service.impl;

import org.springframework.stereotype.Service;
import spotify.song.repository.Song;
import spotify.song.repository.SongRepository;
import spotify.song.service.SongService;

import java.util.Optional;

@Service
public class SongServiceImpl implements SongService {
    private final SongRepository songRepository;

    public SongServiceImpl(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @Override
    public void addSong(Song song) {
        songRepository.save(song);
    }

    @Override
    public void deleteSong(int id) {
        songRepository.deleteById(id);
    }

    @Override
    public Optional<Song> getSong(int id) {
        return songRepository.findById(id);
    }

    @Override
    public Iterable<Song> getAllSongs() {
        return songRepository.findAll();
    }

    @Override
    public void update(Song song) {
        songRepository.save(song);
    }
}
