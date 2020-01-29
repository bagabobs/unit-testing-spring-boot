package baga.len.unittesting.bussiness;

import baga.len.unittesting.model.Item;
import org.springframework.stereotype.Service;

@Service
public class ItemBussinessService {
    public Item retreiveHardCodedItem() {
        return new Item(1, "Ballon", 10, 200);
    }
}
