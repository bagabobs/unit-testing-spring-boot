package baga.len.unittesting.bussiness;

import baga.len.unittesting.data.ItemRepository;
import baga.len.unittesting.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemBussinessService {
    @Autowired
    private ItemRepository itemRepository;

    public Item retreiveHardCodedItem() {
        return new Item(1, "Ballon", 10, 200);
    }

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public List<Item> getAllItemsWithValue() {
        List<Item> items = itemRepository.findAll();
        for(Item item : items) {
            item.setValue(item.getPrice() * item.getQuantity());
        }
        return items;
    }
}
