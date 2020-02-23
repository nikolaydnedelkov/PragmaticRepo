package spotify.artist.service.impl;

import org.springframework.stereotype.Service;
import spotify.artist.repository.Artist;
import spotify.artist.repository.ArtistRepository;
import spotify.artist.service.ArtistService;

import java.util.Optional;

@Service
public class ArtistServiceImpl implements ArtistService {

    private final ArtistRepository artistRepository;

    public ArtistServiceImpl(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    @Override
    public void addArtist(Artist artist) {
        artistRepository.save(artist);
    }

    @Override
    public void deleteArtist(int id) {
        artistRepository.deleteById(id);
    }

    @Override
    public Optional<Artist> getArtist(int id) {
        return artistRepository.findById(id);
    }

    @Override
    public Iterable<Artist> getAllArtists() {
        return artistRepository.findAll();
    }

    @Override
    public void update(Artist artist) {
        artistRepository.save(artist);
    }
}
