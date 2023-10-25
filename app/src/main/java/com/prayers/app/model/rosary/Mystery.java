package com.prayers.app.model.rosary;

import com.prayers.app.constants.GeneralConstants;
import com.prayers.app.exception.PrayersException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Mystery implements Serializable {

    private int value;
    private String name;
    private List<String> paragraphs;

    public Mystery(int value, String name, String... paragraphs) throws PrayersException {
        setValue(value);
        setName(name);
        setParagraphs(paragraphs);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getParagraphs() {
        if (paragraphs == null) {
            paragraphs = new ArrayList<>();
        }
        return paragraphs;
    }

    public void setParagraphs(String... paragraphs) throws PrayersException {
        if (paragraphs == null || paragraphs.length == 0) {
            throw new PrayersException(GeneralConstants.MYSTERY_WITH_PARAGRAPHS);
        }
        getParagraphs().addAll(Arrays.asList(paragraphs));
    }

}
