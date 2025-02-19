package com.gildedrose;

import org.junit.jupiter.api.Test;

import static com.gildedrose.helpers.ItemHelper.createItem;
import static com.gildedrose.items.ItemEnum.AGED_BRIE;
import static com.gildedrose.items.ItemEnum.BACKSTAGE_PASSES;
import static com.gildedrose.items.ItemEnum.CONJURED;
import static com.gildedrose.items.ItemEnum.DEFAULT;
import static com.gildedrose.items.ItemEnum.SULFURAS;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void givenDefaultItem_whenUpdateQuality_thenQualityDecreases() {
        int quality = 20;
        int sellIn = 10;
        Item[] items = new Item[] { createItem(DEFAULT.getName(), sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(quality - 1, app.items[0].quality);
    }

    @Test
    void givenAgedBrieItem_whenUpdateQuality_thenQualityIncreases() {
        int quality = 20;
        int sellIn = 10;
        Item[] items = new Item[] { createItem(AGED_BRIE.getName(), sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(quality + 1, app.items[0].quality);
    }

    @Test
    void givenDefaultItem_whenUpdateQualityAndSellInPassed_thenQualityDecreasesTwiceAsFast() {
        int quality = 20;
        int sellIn = 0;
        Item[] items = new Item[] { createItem(DEFAULT.getName(), sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(quality - 2, app.items[0].quality);
    }

    @Test
    void givenDefaultItem_whenUpdateQuality_thenQualtyNeverNegative() {
        int quality = 0;
        int sellIn = 10;
        Item[] items = new Item[] { createItem(DEFAULT.getName(), sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void givenItems_whenUpdateQuality_thenQualtyNeverExceedsFifty() {
        int quality = 50;
        int sellIn = 10;
        Item[] items = new Item[] { createItem(AGED_BRIE.getName(), sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void givenDefaultItem_whenUpdateQuality_thenSellInDecreases() {
        int sellIn = 10;
        Item[] items = new Item[] { createItem(DEFAULT.getName(), sellIn, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(sellIn - 1, app.items[0].sellIn);
    }

    @Test
    void givenBackstagePassesItemSellInSmallerOrEqualToTen_whenUpdateQuality_thenQualityIncreasesTwiceAsFast() {
        int quality = 20;
        int sellIn = 10;
        Item[] items = new Item[] { createItem(BACKSTAGE_PASSES.getName(), sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(quality + 2, app.items[0].quality);
    }

    @Test
    void givenBackstagePassesItemSellInSmallerOrEqualToFive_whenUpdateQuality_thenQualityIncreasesThreeTimesAsFast() {
        int quality = 20;
        int sellIn = 5;
        Item[] items = new Item[] { createItem(BACKSTAGE_PASSES.getName(), sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(quality + 3, app.items[0].quality);
    }

    @Test
    void givenBackstagePassesItemSellInSmallerOrEqualToZero_whenUpdateQuality_thenQualityDropsToZero() {
        int quality = 20;
        int sellIn = 0;
        Item[] items = new Item[] { createItem(BACKSTAGE_PASSES.getName(), sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void givenSulfurasItem_whenUpdateQuality_thenQualityDoesNotChange() {
        int quality = 80;
        int sellIn = 10;
        Item[] items = new Item[] { createItem(SULFURAS.getName(), sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(quality, app.items[0].quality);
    }

    @Test
    void givenConjuredItem_whenUpdateQuality_thenQualityDecreasesTwiceAsFast() {
        int quality = 20;
        int sellIn = 10;
        Item[] items = new Item[] { createItem(CONJURED.getName(), sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(quality - 2, app.items[0].quality);
    }
}
