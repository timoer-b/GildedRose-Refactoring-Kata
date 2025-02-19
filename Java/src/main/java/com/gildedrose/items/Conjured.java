package com.gildedrose.items;

public class Conjured extends AbstractItem {

    public Conjured(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        if (this.quality > 0) {
            this.quality -= 2;
        }

        if (this.quality < 0) {
            this.quality = 0;
        }
    }

    @Override
    public void updateSellIn() {
        this.sellIn--;
    }

    @Override
    public void updateQualityAndSellIn() {
        this.updateSellIn();
        this.updateQuality();
    }
}
