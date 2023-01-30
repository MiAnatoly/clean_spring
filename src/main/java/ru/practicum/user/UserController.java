package ru.practicum.user;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    private final String message;
    @Autowired
    public UserController(UserService userService, @Value("${message}") String message) {
        this.userService = userService;
        this.message = message; // в параметре message будет значение из файла с настройками
    }
    @GetMapping
    public List<User> getAllUsers() {
        log.info(message);
        return userService.getAllUsers();
    }

    @PostMapping
    public User saveNewUser(@RequestBody User user) {
        log.info("добавлен пользователь");
        return userService.saveUser(user);
    }
}
