package com.gildedrose;

import java.util.Arrays;

import com.gildedrose.items.AbstractItem;
import com.gildedrose.items.AgedBrie;
import com.gildedrose.items.BackstagePasses;
import com.gildedrose.items.Conjured;
import com.gildedrose.items.DefaultItem;
import com.gildedrose.items.Sulfuras;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    private AbstractItem[] convertItems(Item[] items) {
        return Arrays.stream(items)
                .map(this::convertItem)
                .toArray(AbstractItem[]::new);
    }

    private AbstractItem convertItem(Item item) {
        switch (item.name) {
            case "Aged Brie":
                return new AgedBrie(item.name, item.sellIn, item.quality);
            case "Sulfuras, Hand of Ragnaros":
                return new Sulfuras(item.name, item.sellIn, item.quality);
            case "Backstage passes to a TAFKAL80ETC concert":
                return new BackstagePasses(item.name, item.sellIn, item.quality);
            case "Conjured Mana Cake":
                return new Conjured(item.name, item.sellIn, item.quality);
            default:
                return new DefaultItem(item.name, item.sellIn, item.quality);
        }
    }

    public void updateQuality() {
        items = Arrays.stream(convertItems(items))
                .map(item -> {
                    item.updateQualityAndSellIn();
                    return item;
                })
                .toArray(Item[]::new);
    }
}
