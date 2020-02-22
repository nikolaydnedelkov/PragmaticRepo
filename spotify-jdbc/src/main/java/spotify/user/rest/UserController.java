package spotify.user.rest;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;
import spotify.song.repository.Song;
import spotify.user.convertor.UserConvertor;
import spotify.user.model.UserModel;
import spotify.user.repository.User;
import spotify.user.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final UserConvertor userConvertor;

    public UserController(UserService userService, ModelMapper modelMapper, UserConvertor userConvertor) {
        this.userService = userService;
        this.userConvertor = userConvertor;
    }

    @PostMapping
    public void addUser(@RequestBody final UserModel userModel) {
        User user = userConvertor.convertToEntity(userModel);
        userService.addUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable final long id) {
        userService.deleteUser(id);
    }

    @GetMapping("/{id}")
    public UserModel getUser(@PathVariable final long id) {
        return userConvertor.convertToModel(userService.getUser(id));
    }

    @GetMapping
    public List<UserModel> getAllUsers() {
        return userService
                .getAllUsers()
                .stream()
                .map(userConvertor::convertToModel)
                .collect(Collectors.toList());
    }

    @PutMapping
    public void update(@RequestBody final UserModel userModel) {
        User user = userConvertor.convertToEntity(userModel);
        userService.update(user);
    }

    @GetMapping("playing/{id}")
    public Song getSong(@PathVariable final long id) {
        return userService.playSong(id);
    }
}
