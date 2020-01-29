package baga.len.unittesting.controller;

import baga.len.unittesting.bussiness.ItemBussinessService;
import baga.len.unittesting.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {
    @Autowired
    private ItemBussinessService bussinessService;

    @GetMapping("/dummy-item")
    public Item dummyItem() {
        return new Item(1, "chiki ball", 10, 100);
    }

    @GetMapping("/item-from-businness-service")
    public Item itemFromBusinessService() {
        return bussinessService.retreiveHardCodedItem();
    }
}
