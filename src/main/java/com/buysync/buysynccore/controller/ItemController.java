package com.buysync.buysynccore.controller;

import com.buysync.buysynccore.domain.Item;
import com.buysync.buysynccore.service.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
@Slf4j
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @PostMapping("/add-item")
    public ResponseEntity<Item> addItem(@RequestBody Item item) {
        log.info("Add Item: " + item.toString() + "Started");
        Item savedItem = itemService.save(item);
        log.info("Add Item: " + item.toString() + "Ended");
        return new ResponseEntity<>(savedItem, HttpStatus.CREATED);
    }

    @GetMapping("/all-items")
    public ResponseEntity<List<Item>> allItems() {
        log.info("Show Items started");
        List<Item> allItems = itemService.getAllItems();
        log.info("Show Items Ended");
        return new ResponseEntity<>(allItems, HttpStatus.CREATED);
    }
}
