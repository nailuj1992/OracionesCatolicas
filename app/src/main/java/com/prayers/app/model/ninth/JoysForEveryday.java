package com.prayers.app.model.ninth;

import com.prayers.app.constants.GeneralConstants;
import com.prayers.app.exception.PrayersException;
import com.prayers.app.model.Counter;

import java.io.Serializable;
import java.util.List;

public class JoysForEveryday extends Counter implements Serializable {

    private final List<Joy> joys;

    public JoysForEveryday(List<Joy> joys, boolean end) throws PrayersException {
        if (joys == null || joys.isEmpty()) {
            throw new PrayersException(GeneralConstants.JOYS_NOT_NULL);
        }
        this.joys = joys;
        this.current = end ? getMaxValueInclusive() : getMinValue();
    }

    public Joy getCurrentJoy() throws PrayersException {
        if (current < getMinValue() || current > getMaxValueInclusive()) {
            throw new PrayersException(GeneralConstants.COUNT_OUT_OF_BOUNDS);
        }
        return joys.get(current);
    }

    @Override
    public int getTotal() {
        return joys.size();
    }

    @Override
    protected int getMinValue() {
        return 0;
    }

    @Override
    protected int getMaxValueInclusive() {
        return getTotal() - 1;
    }
}
