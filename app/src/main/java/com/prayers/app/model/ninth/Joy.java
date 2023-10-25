package com.prayers.app.model.ninth;

import com.prayers.app.constants.GeneralConstants;
import com.prayers.app.exception.PrayersException;

import java.io.Serializable;

public class Joy implements Serializable {

    private String[] lines;

    public Joy(String... lines) throws PrayersException {
        if (lines == null || lines.length == 0) {
            throw new PrayersException(GeneralConstants.JOY_WITHOUT_LINES);
        }
        this.lines = lines;
    }

    public String[] getLines() {
        return lines;
    }

}
