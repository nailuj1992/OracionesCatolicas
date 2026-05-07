package com.prayers.app.model;

import com.prayers.app.constants.GeneralConstants;
import com.prayers.app.exception.PrayersException;

/**
 * Bounded integer counter shared by HailMary, GloryBe and JoysForEveryday.
 *
 * Subclasses pick their bounds via {@link #getMinValue()} and {@link #getMaxValueInclusive()}
 * (which is total-1 for 0-indexed counters and total for 1-indexed counters).
 */
public abstract class Counter {

    protected int current;

    public abstract int getTotal();

    protected abstract int getMinValue();

    protected abstract int getMaxValueInclusive();

    public final int getCurrent() {
        return current;
    }

    public final void increaseValue() throws PrayersException {
        if (current >= getMaxValueInclusive()) {
            throw new PrayersException(String.format(GeneralConstants.COUNT_NOT_INCREASE_MORE, getTotal()));
        }
        current++;
    }

    public final void decreaseValue() throws PrayersException {
        if (current <= getMinValue()) {
            throw new PrayersException(String.format(GeneralConstants.COUNT_NOT_DECREASE_MORE, getMinValue()));
        }
        current--;
    }
}
