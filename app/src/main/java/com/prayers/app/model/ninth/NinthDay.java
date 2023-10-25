package com.prayers.app.model.ninth;

import com.prayers.app.constants.GeneralConstants;
import com.prayers.app.exception.PrayersException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NinthDay implements Serializable {

    private int value;
    private String name;
    private String schedule;

    private List<String> considerations;
    private List<String> paragraphs;

    public NinthDay(int value, String name, String schedule, String[] considerations, String[] paragraphs) throws PrayersException {
        setValue(value);
        setName(name);
        setSchedule(schedule);
        setConsiderations(considerations);
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

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public List<String> getConsiderations() {
        if (considerations == null) {
            considerations = new ArrayList<>();
        }
        return considerations;
    }

    public void setConsiderations(String[] considerations) throws PrayersException {
        if (considerations == null || considerations.length == 0) {
            throw new PrayersException(GeneralConstants.CONSIDERATION_WITH_PARAGRAPHS);
        }
        getConsiderations().addAll(Arrays.asList(considerations));
    }

    public List<String> getParagraphs() {
        if (paragraphs == null) {
            paragraphs = new ArrayList<>();
        }
        return paragraphs;
    }

    public void setParagraphs(String[] paragraphs) throws PrayersException {
        if (paragraphs == null || paragraphs.length == 0) {
            throw new PrayersException(GeneralConstants.DAY_WITH_PARAGRAPHS);
        }
        getParagraphs().addAll(Arrays.asList(paragraphs));
    }

}
