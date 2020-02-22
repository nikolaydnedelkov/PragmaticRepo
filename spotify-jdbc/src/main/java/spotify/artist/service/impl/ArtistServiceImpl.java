package spotify.artist.service.impl;

import org.springframework.stereotype.Service;
import spotify.artist.repository.Artist;
import spotify.artist.repository.ArtistRepository;
import spotify.artist.service.ArtistService;
import spotify.song.repository.Song;

import java.util.List;

@Service
public class ArtistServiceImpl implements ArtistService {

    private final ArtistRepository artistRepository;

    public ArtistServiceImpl(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    @Override
    public void addArtist(Artist artist) {
        artistRepository.add(artist);
    }

    @Override
    public void deleteArtist(long id) {
        artistRepository.delete(id);
    }

    @Override
    public Artist getArtist(long id) {
        return artistRepository.get(id);
    }

    @Override
    public List<Artist> getAllArtists() {
        return artistRepository.getAll();
    }

    @Override
    public void update(Artist artist) {
        artistRepository.update(artist);
    }

    @Override
    public void addSong(Song song) {
        artistRepository.addSong(song);
    }

    @Override
    public void updateSong(Song song) {
        artistRepository.updateSong(song);
    }

    @Override
    public void deleteSong(long id) {
        artistRepository.deleteSong(id);
    }
}
