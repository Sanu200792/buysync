package com.buysync.buysynccore.repository;

import com.buysync.buysynccore.domain.Item;
import com.buysync.buysynccore.util.TestDataUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
@Slf4j
public class ItemRepositoryTests {

    @Autowired
    ItemRepository itemRepository;

    @Test
    public void test_saveItem() {
        // setup
        Item item = TestDataUtil.getTestItem();
        // save in db
        Item savedItem = itemRepository.save(item);
        // test saved data
        Assertions.assertNotNull(savedItem);
        Assertions.assertEquals(item.getItemName(), savedItem.getItemName());
        Assertions.assertEquals(item.getNickName(), savedItem.getNickName());
        Assertions.assertEquals(item.getUnit(), savedItem.getUnit());
    }

    @Test
    public void test_getItemById() {
        // setup test data
        Item savedItem = itemRepository.save(TestDataUtil.getTestItem());
        // get from Db
        Optional<Item> returnedItem = itemRepository.findById(savedItem.getItemId());

        // test returned data
        Assertions.assertTrue(returnedItem.isPresent());
        Item item = returnedItem.get();
        Assertions.assertEquals(savedItem.getItemId(), item.getItemId());
        Assertions.assertEquals(savedItem.getItemName(), item.getItemName());
        Assertions.assertEquals(savedItem.getNickName(), item.getNickName());
        Assertions.assertEquals(savedItem.getUnit(), item.getUnit());
    }
}
