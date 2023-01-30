package ru.practicum.user;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private Long id;
    private final Map<Long, User> users = new HashMap<>();

    @Override
    public List<User> findAll() {
        return new ArrayList<>(users.values());
    }

    @Override
    public User save(User user) {
        ++id;
        user.setId(id);
        users.put(id, user);
        return user;
    }

    @Override
    public void deleteUser(Long id) {
        users.remove(id);
    }


}
