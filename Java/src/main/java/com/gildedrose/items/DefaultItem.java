package com.gildedrose.items;

public class DefaultItem extends AbstractItem {

    public DefaultItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        if (this.sellIn < 0) {
            this.quality -= 2;
        } else {
            this.quality--;
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
