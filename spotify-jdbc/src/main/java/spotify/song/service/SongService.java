package spotify.song.service;

import spotify.song.repository.Song;

import java.util.List;

public interface SongService {

    void addSong(Song song);

    void deleteSong(long id);

    Song getSong(long id);

    List<Song> getAllSongs();

    void update(Song song);
}
