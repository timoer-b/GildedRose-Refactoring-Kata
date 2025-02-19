package com.gildedrose.helpers;

import com.gildedrose.Item;

public class ItemHelper {
    public static Item createItem(String name, int sellIn, int quality) {
        return new Item(name, sellIn, quality);
    }
}
