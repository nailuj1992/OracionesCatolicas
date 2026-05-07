package com.prayers.app.model;

import com.prayers.app.constants.GeneralConstants;
import com.prayers.app.enums.ETypeHailMary;

public class HailMary extends Counter {

    private final ETypeHailMary type;

    public HailMary(boolean end, ETypeHailMary type) {
        this.type = type;
        this.current = end ? getMaxValueInclusive() : getMinValue();
    }

    public ETypeHailMary getType() {
        return type;
    }

    @Override
    public int getTotal() {
        return type.getValue();
    }

    @Override
    protected int getMinValue() {
        return GeneralConstants.MIN_HAIL_MARY;
    }

    @Override
    protected int getMaxValueInclusive() {
        return getTotal();
    }
}
