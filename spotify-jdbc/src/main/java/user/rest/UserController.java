package user.rest;

import org.springframework.web.bind.annotation.*;
import user.repository.User;
import user.service.UserService;

import java.util.List;

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
    public void deleteCustomer(@PathVariable final long id) {
        userService.deleteUser(id);
    }

    @GetMapping("/{id}")
    public User getCustomer(@PathVariable final long id) {
        return userService.getUser(id);
    }

    @GetMapping
    public List<User> getAllCustomers() {
        return userService.getAllUsers();
    }

    @PutMapping
    public void update(@RequestBody final User user) {
        userService.update(user);
    }
}
