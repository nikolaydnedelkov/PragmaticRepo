package spotify.user.service;

import spotify.song.repository.Song;
import spotify.user.repository.User;

import java.util.List;

public interface UserService {

    void addUser(User user);

    void deleteUser(long id);

    User getUser(long id);

    List<User> getAllUsers();

    void update(User user);

    Song playSong(long id);

}
