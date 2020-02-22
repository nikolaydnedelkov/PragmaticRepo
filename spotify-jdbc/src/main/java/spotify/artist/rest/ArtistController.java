package spotify.artist.rest;

import org.springframework.web.bind.annotation.*;
import spotify.artist.repository.Artist;
import spotify.artist.service.ArtistService;
import spotify.song.repository.Song;

import java.util.List;

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
    public void deleteArtist(@PathVariable final long id) {
        artistService.deleteArtist(id);
    }

    @GetMapping("/{id}")
    public Artist getArtist(@PathVariable final long id) {
        return artistService.getArtist(id);
    }

    @GetMapping
    public List<Artist> getAllArtists() { return artistService.getAllArtists(); }

    @PutMapping
    public void update(@RequestBody final Artist artist) {
        artistService.update(artist);
    }

    @PostMapping("/song")
    public void addSong(@RequestBody final Song song) {
        artistService.addSong(song);
    }

    @PutMapping("/song")
    public void updateSong(@RequestBody final Song song) {
        artistService.updateSong(song);
    }

    @DeleteMapping("song/{id}")
    public void deleteSong(@PathVariable final long id) {
        artistService.deleteSong(id);
    }
}
