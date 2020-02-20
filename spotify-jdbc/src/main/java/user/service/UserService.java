package user.service;

import user.repository.User;

import java.util.List;

public interface UserService {

    void addUser(User user);

    void deleteUser(long id);

    User getUser(long id);

    List<User> getAllUsers();

    void update(User user);

}
