package ru.practicum.item;

import org.springframework.stereotype.Repository;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Repository
public class ItemRepositoryImpl implements ItemRepository {
    private Long id;
    private final Map<Long, Item> items = new HashMap<>();
    private final Map<Long, List<Long>> itemsId = new HashMap<>();
    public List<Item> getItems(Long userId){
        List<Long> list = itemsId.get(userId);
        return list.stream().map(items::get).collect(Collectors.toList());
    }

    public Item addNewItem(Long userId, Item item) {
        ++id;
        item.setId(id);
        items.put(id, item);
        List<Long> list;
        if(!itemsId.containsKey(userId))
           list = new ArrayList<>();
        else
            list = itemsId.get(userId);
        list.add(id);
        itemsId.put(userId, list);
        return item;
    }

    public void deleteItem(Long userId, Long itemId) {
        List<Long> list = itemsId.get(userId);
        list.remove(itemId);
        itemsId.put(userId, list);
        items.remove(itemId);
    }
}
