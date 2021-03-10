package com.buysync.buysynccore.util;

import com.buysync.buysynccore.domain.Item;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TestDataUtil {

    public Item getTestItem() {
        Item item = new Item().setItemName("testItemName")
                .setNickName("Test Nick Name")
                .setUnit("Kg");
        return item;
    }
}
