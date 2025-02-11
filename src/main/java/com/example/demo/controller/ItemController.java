package com.example.demo.controller;
import jakarta.validation.Valid;
import com.example.demo.model.Item;
import com.example.demo.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    @GetMapping("/{id}")
    public Optional<Item> getItemById(@PathVariable Long id) {
        return itemService.getItemById(id);
    }

    @PostMapping
    public Item addItem(@Valid @RequestBody Item item) {
        return itemService.saveItem(item);
    }


    // Update item by ID
    @PutMapping("/{id}")
    public Item updateItem(@PathVariable Long id, @RequestBody Item newItem) {
        return itemService.updateItem(id, newItem);
    }

    // Delete item by ID
    @DeleteMapping("/{id}")
    public String deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
        return "Item deleted successfully!";
    }
}
