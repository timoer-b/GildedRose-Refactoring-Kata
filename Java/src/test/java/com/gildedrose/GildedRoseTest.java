package com.gildedrose;

import org.junit.jupiter.api.Test;

import static com.gildedrose.helpers.ItemHelper.createItem;
import static com.gildedrose.items.ItemEnum.DEFAULT;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void givenDefaultItem_whenUpdateQuality_thenQualityDecreases() {
        int quality = 20;
        int sellIn = 10;
        Item[] items = new Item[] { createItem(DEFAULT.name(), sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(quality - 1, app.items[0].quality);
    }

    @Test
    void givenDefaultItem_whenUpdateQualityAndSellInPassed_thenQualityDecreasesTwiceAsFast() {
        int quality = 20;
        int sellIn = 0;
        Item[] items = new Item[] { createItem(DEFAULT.name(), sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(quality - 2, app.items[0].quality);
    }

    @Test
    void givenDefaultItem_whenUpdateQuality_thenQualtyNeverNegative() {
        int quality = 0;
        int sellIn = 10;
        Item[] items = new Item[] { createItem(DEFAULT.name(), sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void givenDefaultItem_whenUpdateQuality_thenSellInDecreases() {
        int sellIn = 10;
        Item[] items = new Item[] { createItem(DEFAULT.name(), sellIn, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(sellIn - 1, app.items[0].sellIn);
    }

}
