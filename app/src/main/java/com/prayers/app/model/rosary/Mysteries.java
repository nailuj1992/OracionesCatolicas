package com.prayers.app.model.rosary;

import com.prayers.app.constants.GeneralConstants;
import com.prayers.app.exception.PrayersException;

import java.io.Serializable;

public class Mysteries implements Serializable {

    private int value;
    private String name;
    private String schedule;
    private Mystery[] mysteries;

    public Mysteries(int value, String name, String schedule, Mystery... mysteries) throws PrayersException {
        setValue(value);
        setName(name);
        setSchedule(schedule);
        setMysteries(mysteries);
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

    public Mystery[] getMysteries() {
        if (mysteries == null) {
            mysteries = new Mystery[GeneralConstants.MAX_MYSTERIES];
        }
        return mysteries;
    }

    public void setMysteries(Mystery... mysteries) throws PrayersException {
        if (mysteries == null || mysteries.length != GeneralConstants.MAX_MYSTERIES) {
            throw new PrayersException(GeneralConstants.MYSTERIES_ITEMS_LENGTH_5);
        }
        this.mysteries = mysteries;
    }

}
