package com.buysync.buysynccore.controller;

import com.buysync.buysynccore.domain.Item;
import com.buysync.buysynccore.service.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/items")
@Slf4j
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @PostMapping("/add-item")
    public ResponseEntity<Item> addItem(@Valid @RequestBody Item item) {
        log.info("Request to add Item==[{}].", item);
        Item savedItem = itemService.save(item);
        log.info("Request processed to add Item==[{}].", item);
        return new ResponseEntity<>(savedItem, HttpStatus.CREATED);
    }

    @GetMapping("/all-items")
    public ResponseEntity<List<Item>> allItems() {
        log.info("Request to get all Items.");
        List<Item> allItems = itemService.getAllItems();
        log.info("Request processed to get all Items.");
        return new ResponseEntity<>(allItems, HttpStatus.CREATED);
    }
}
