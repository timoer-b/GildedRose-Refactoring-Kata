package com.gildedrose.items;

public class Sulfuras extends AbstractItem {

    public Sulfuras(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        // Sulfuras never changes
    }

    @Override
    public void updateSellIn() {
        // Sulfuras never changes
    }

    @Override
    public void updateQualityAndSellIn() {
        this.updateSellIn();
        this.updateQuality();
    }
}
