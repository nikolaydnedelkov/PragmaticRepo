package spotify.artist.service;

import spotify.artist.repository.Artist;
import spotify.song.repository.Song;

import java.util.List;

public interface ArtistService {

    void addArtist(Artist artist);

    void deleteArtist(long id);

    Artist getArtist(long id);

    List<Artist> getAllArtists();

    void update(Artist artist);

    void addSong(Song song);

    void updateSong(Song song);

    void deleteSong(long id);
}
