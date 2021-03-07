package com.buysync.buysynccore.repository;

import com.buysync.buysynccore.domain.Item;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.util.Assert;

@DataJpaTest
@Slf4j
public class ItemRepositoryTests {

    @Autowired
    ItemRepository itemRepository;

    @Test
    public void saveItemTest() {
        Item item = new Item();
        item.setItemId("test");
        item.setItemName("testItemName");
        item.setNickName("Test Nick Name");
        item.setUnit("Kg");

        itemRepository.save(item);

        Item item1 = itemRepository.getOne("test");

        log.info(item1.toString());
        Assertions.assertNotNull(item1);
    }
}
