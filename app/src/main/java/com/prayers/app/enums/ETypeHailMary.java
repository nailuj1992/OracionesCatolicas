package com.prayers.app.enums;

import com.prayers.app.constants.GeneralConstants;

public enum ETypeHailMary {

    ROSARY_SHORT(GeneralConstants.MAX_HAIL_MARY_ROSARY_SHORT),
    ROSARY_LONG(GeneralConstants.MAX_HAIL_MARY_ROSARY_LONG),
    NINTH(GeneralConstants.MAX_HAIL_MARY_NINTH);

    private int value;

    ETypeHailMary(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
