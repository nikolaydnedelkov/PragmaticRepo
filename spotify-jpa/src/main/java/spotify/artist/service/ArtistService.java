package spotify.artist.service;

import spotify.artist.repository.Artist;

import java.util.Optional;

public interface ArtistService {

    void addArtist(Artist artist);

    void deleteArtist(int id);

    Optional<Artist> getArtist(int id);

    Iterable<Artist> getAllArtists();

    void update(Artist artist);

}
