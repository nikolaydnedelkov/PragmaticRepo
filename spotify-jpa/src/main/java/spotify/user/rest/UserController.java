package spotify.user.rest;

import org.springframework.web.bind.annotation.*;
import spotify.song.repository.Song;
import spotify.user.repository.User;
import spotify.user.service.UserService;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public void addUser(@RequestBody final User user) {
        userService.addUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable final int id) {
        userService.deleteUser(id);
    }

    @GetMapping("/{id}")
    public Object getUser(@PathVariable final int id) {
        return userService.getUser(id);
    }

    @GetMapping
    public Iterable<User> getAllUsers() {
        return userService.getAllUsers();
                    }

    @PutMapping
    public void update(@RequestBody final User user) {
        userService.update(user);
    }

    @GetMapping("playing/{id}")
    public Optional<Song> playSong(@PathVariable final int id) {
        return userService.playSong(id);
    }
}
