package com.prayers.app.model;

import com.prayers.app.constants.GeneralConstants;
import com.prayers.app.enums.ETypeHailMary;
import com.prayers.app.exception.PrayersException;

public class HailMary {

    private int current;
    private ETypeHailMary type;

    public HailMary(boolean end, ETypeHailMary type) {
        this.type = type;
        if (end) {
            this.current = getTotal();
        } else {
            this.current = GeneralConstants.MIN_HAIL_MARY;
        }
    }

    public int getCurrent() {
        return current;
    }

    public ETypeHailMary getType() {
        return type;
    }

    public int getTotal() {
        return type.getValue();
    }

    public void increaseValue() throws PrayersException {
        if (current >= getTotal()) {
            throw new PrayersException(String.format(GeneralConstants.COUNT_NOT_INCREASE_MORE, getTotal()));
        }
        current++;
    }

    public void decreaseValue() throws PrayersException {
        if (current <= GeneralConstants.MIN_HAIL_MARY) {
            throw new PrayersException(String.format(GeneralConstants.COUNT_NOT_DECREASE_MORE, GeneralConstants.MIN_HAIL_MARY));
        }
        current--;
    }

}
