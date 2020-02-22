package spotify.song.rest;

import org.springframework.web.bind.annotation.*;
import spotify.song.repository.Song;
import spotify.song.service.SongService;

import java.util.List;

@RestController
@RequestMapping("/songs")
public class SongController {

    private final SongService songService;

    public SongController(SongService songService) {
        this.songService = songService;
    }

    @PostMapping
    public void addSong(@RequestBody final Song song) {
        songService.addSong(song);
    }

    @DeleteMapping("/{id}")
    public void deleteSong(@PathVariable final long id) {
        songService.deleteSong(id);
    }

    @GetMapping("/{id}")
    public Song getSong(@PathVariable final long id) {
        return songService.getSong(id);
    }

    @GetMapping
    public List<Song> getAllSongs() {
        return songService.getAllSongs();
    }

    @PutMapping
    public void update(@RequestBody final Song song) {
        songService.update(song);
    }
}
