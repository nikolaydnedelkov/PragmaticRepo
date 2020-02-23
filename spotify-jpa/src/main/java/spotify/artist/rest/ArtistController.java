package spotify.artist.rest;

import org.springframework.web.bind.annotation.*;
import spotify.artist.repository.Artist;
import spotify.artist.service.ArtistService;

import java.util.Optional;

@RestController
@RequestMapping("/artists")
public class ArtistController {
    private final ArtistService artistService;

    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @PostMapping
    public void addArtist(@RequestBody final Artist artist) {
        artistService.addArtist(artist);
    }

    @DeleteMapping("/{id}")
    public void deleteArtist(@PathVariable final int id) {
        artistService.deleteArtist(id);
    }

    @GetMapping("/{id}")
    public Optional<Artist> getArtist(@PathVariable final int id) {
        return artistService.getArtist(id);
    }

    @GetMapping
    public Iterable<Artist> getAllArtists() { return artistService.getAllArtists(); }

    @PutMapping
    public void update(@RequestBody final Artist artist) {
        artistService.update(artist);
    }
}
