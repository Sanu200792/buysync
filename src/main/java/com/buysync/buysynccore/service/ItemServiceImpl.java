package com.buysync.buysynccore.service;

import com.buysync.buysynccore.domain.Item;
import com.buysync.buysynccore.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    @Override
    public Item save(Item item) {
        log.info("Saving item==[{}].", item);
        return itemRepository.save(item);
    }

    @Override
    public List<Item> getAllItems() {
        log.info("Getting all items.");
        return itemRepository.findAll();
    }
}
