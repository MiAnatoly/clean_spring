package ru.practicum.item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.practicum.user.UserRepository;
import ru.practicum.user.UserRepositoryImpl;
import ru.practicum.user.UserService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;
    @Override
    public List<Item> getItems(Long userId) {
        return itemRepository.getItems(userId);
    }

    @Override
    public Item addNewItem(Long userId, Item item) {
        return itemRepository.addNewItem(userId, item);
    }

    @Override
    public void deleteItem(Long userId, Long itemId) {
        itemRepository.deleteItem(userId, itemId);

    }
}
