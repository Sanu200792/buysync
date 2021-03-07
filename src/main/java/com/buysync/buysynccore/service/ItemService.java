package com.buysync.buysynccore.service;

import com.buysync.buysynccore.domain.Item;

import java.util.List;

public interface ItemService {
    Item save(Item item);
    List<Item> getAllItems();
}
