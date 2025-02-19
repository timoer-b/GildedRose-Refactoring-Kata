package com.gildedrose.items;
public enum ItemEnum {
    AGED_BRIE("Aged Brie"),
    SULFURAS("Sulfuras, Hand of Ragnaros"),
    BACKSTAGE_PASSES("Backstage passes to a TAFKAL80ETC concert"),
    CONJURED("Conjured Mana Cake"),
    DEFAULT("Default");

    private String name;

    ItemEnum(String name) {
        this.name = name;
    }
}
