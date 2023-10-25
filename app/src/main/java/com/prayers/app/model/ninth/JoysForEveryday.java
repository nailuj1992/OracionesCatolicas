package com.prayers.app.model.ninth;

import com.prayers.app.constants.GeneralConstants;
import com.prayers.app.exception.PrayersException;

import java.io.Serializable;
import java.util.List;

public class JoysForEveryday implements Serializable {

    private int current;
    private List<Joy> joys;

    public JoysForEveryday(List<Joy> joys, boolean end) throws PrayersException {
        if (joys == null || joys.isEmpty()) {
            throw new PrayersException(GeneralConstants.JOYS_NOT_NULL);
        }
        this.joys = joys;

        if (end) {
            this.current = getTotal() - 1;
        } else {
            this.current = 0;
        }
    }

    public int getCurrent() {
        return current;
    }

    public int getTotal() {
        return joys.size();
    }

    public Joy getCurrentJoy() throws PrayersException {
        if (current < 0 || current > getTotal() - 1) {
            throw new PrayersException(GeneralConstants.COUNT_OUT_OF_BOUNDS);
        }
        return joys.get(current);
    }

    public void increaseValue() throws PrayersException {
        if (current >= getTotal() - 1) {
            throw new PrayersException(String.format(GeneralConstants.COUNT_NOT_INCREASE_MORE, getTotal()));
        }
        current++;
    }

    public void decreaseValue() throws PrayersException {
        if (current <= 0) {
            throw new PrayersException(String.format(GeneralConstants.COUNT_NOT_DECREASE_MORE, 0));
        }
        current--;
    }

}
