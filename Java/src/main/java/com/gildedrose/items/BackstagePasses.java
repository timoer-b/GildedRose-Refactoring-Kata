package com.gildedrose.items;

public class BackstagePasses extends AbstractItem {

    public BackstagePasses(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        if (this.sellIn < 0) {
            this.quality = 0;
        } else if (this.sellIn < 5) {
            this.quality += 3;
        } else if (this.sellIn < 10) {
            this.quality += 2;
        } else {
            this.quality += 1;
        }

        if (this.quality > 50) {
            this.quality = 50;
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