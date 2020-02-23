package spotify.song.service;

import spotify.song.repository.Song;

import java.util.Optional;

public interface SongService {

    void addSong(Song song);

    void deleteSong(int id);

    Optional<Song> getSong(int id);

    Iterable<Song> getAllSongs();

    void update(Song song);
}
