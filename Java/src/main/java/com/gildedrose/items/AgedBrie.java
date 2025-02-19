package com.gildedrose.items;

public class AgedBrie extends AbstractItem {

    public AgedBrie(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        if (this.quality < 50) {
            this.quality++;
        }
    }
}
