package spotify.user.service;

import spotify.song.repository.Song;
import spotify.user.repository.User;

import java.util.Optional;

public interface UserService {

    void addUser(User user);

    void deleteUser(int id);

    Object getUser(int id);

    Iterable<User> getAllUsers();

    void update(User user);

    Optional<Song> playSong(int id);
}
