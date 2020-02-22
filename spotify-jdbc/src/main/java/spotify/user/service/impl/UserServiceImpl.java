package spotify.user.service.impl;

import org.springframework.stereotype.Service;
import spotify.song.repository.Song;
import spotify.user.repository.User;
import spotify.user.repository.UserRepository;
import spotify.user.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void addUser(User user) {
        userRepository.add(user);
    }

    @Override
    public void deleteUser(long id) {
        userRepository.delete(id);
    }

    @Override
    public User getUser(long id) {
        return userRepository.get(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.getAll();
    }

    @Override
    public void update(User user) {
        userRepository.update(user);
    }

    @Override
    public Song playSong(long id) {
        return userRepository.playSong(id);
    }
}
