package com.prayers.app.model;

import com.prayers.app.constants.GeneralConstants;

public class GloryBe extends Counter {

    public GloryBe(boolean end) {
        this.current = end ? getMaxValueInclusive() : getMinValue();
    }

    @Override
    public int getTotal() {
        return GeneralConstants.MAX_GLORY_BE_NINTH;
    }

    @Override
    protected int getMinValue() {
        return GeneralConstants.MIN_GLORY_BE;
    }

    @Override
    protected int getMaxValueInclusive() {
        return getTotal();
    }
}
