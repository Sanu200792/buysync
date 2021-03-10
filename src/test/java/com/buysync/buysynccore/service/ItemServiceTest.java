package com.buysync.buysynccore.service;

import com.buysync.buysynccore.domain.Item;
import com.buysync.buysynccore.repository.ItemRepository;
import com.buysync.buysynccore.util.TestDataUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
public class ItemServiceTest {

    @Mock
    private ItemRepository itemRepository;

    @InjectMocks
    private ItemServiceImpl itemService;

    @Test
    public void test_getAllItems() {
        //setup
        Item item = TestDataUtil.getTestItem().setItemId(1000L);
        doReturn(Arrays.asList(item)).when(itemRepository).findAll();

        //when
        List<Item> items = itemService.getAllItems();

        //then
        Assertions.assertTrue(!CollectionUtils.isEmpty(items));
        Assertions.assertEquals(1, items.size());
        Item returnedItem = items.get(0);
        Assertions.assertEquals(item.getItemId(), returnedItem.getItemId());
        Assertions.assertEquals(item.getItemName(), returnedItem.getItemName());
        Assertions.assertEquals(item.getNickName(), returnedItem.getNickName());
        Assertions.assertEquals(item.getUnit(), returnedItem.getUnit());
    }

    @Test
    public void test_saveItem() {
        //setup
        Item item = TestDataUtil.getTestItem();
        doReturn(item.setItemId(1000L)).when(itemRepository).saveAndFlush(item);

        //when
        Item saveItems = itemService.save(item);

        //then
        Assertions.assertNotNull(item);
        Assertions.assertNotNull(saveItems.getItemId());
        Assertions.assertEquals(item.getItemName(), saveItems.getItemName());
        Assertions.assertEquals(item.getNickName(), saveItems.getNickName());
        Assertions.assertEquals(item.getUnit(), saveItems.getUnit());
    }

}
