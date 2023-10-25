package com.prayers.app.model;

import com.prayers.app.constants.GeneralConstants;
import com.prayers.app.exception.PrayersException;

public class GloryBe {

    private int current;

    public GloryBe(boolean end) {
        if (end) {
            this.current = getTotal();
        } else {
            this.current = GeneralConstants.MIN_GLORY_BE;
        }
    }

    public int getCurrent() {
        return current;
    }

    public int getTotal() {
        return GeneralConstants.MAX_GLORY_BE_NINTH;
    }

    public void increaseValue() throws PrayersException {
        if (current >= getTotal()) {
            throw new PrayersException(String.format(GeneralConstants.COUNT_NOT_INCREASE_MORE, getTotal()));
        }
        current++;
    }

    public void decreaseValue() throws PrayersException {
        if (current <= GeneralConstants.MIN_GLORY_BE) {
            throw new PrayersException(String.format(GeneralConstants.COUNT_NOT_DECREASE_MORE, GeneralConstants.MIN_GLORY_BE));
        }
        current--;
    }

}
