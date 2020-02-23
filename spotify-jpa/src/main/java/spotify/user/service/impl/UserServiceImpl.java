package spotify.user.service.impl;

import org.springframework.stereotype.Service;
import spotify.song.repository.Song;
import spotify.song.repository.SongRepository;
import spotify.user.repository.User;
import spotify.user.repository.UserRepository;
import spotify.user.service.UserService;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final SongRepository songRepository;

    public UserServiceImpl(UserRepository userRepository, SongRepository songRepository) {
        this.userRepository = userRepository;
        this.songRepository = songRepository;
    }

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public Optional<User> getUser(int id) {
        return userRepository.findById(id);
    }

    @Override
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void update(User user) {
        userRepository.save(user);
    }

    @Override
    public Optional<Song> playSong(int id) {
        return songRepository.findById(id);
    }
}
