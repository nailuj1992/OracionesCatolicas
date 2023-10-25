package com.prayers.app.mapper;

import com.prayers.app.activity.AbstractActivity;
import com.prayers.app.activity.R;
import com.prayers.app.constants.GeneralConstants;
import com.prayers.app.exception.PrayersException;
import com.prayers.app.model.ninth.Joy;
import com.prayers.app.model.ninth.JoysForEveryday;
import com.prayers.app.model.ninth.NinthDay;

import java.util.ArrayList;
import java.util.List;

public class NinthMapper {

    public static NinthDay prepopulateFirstDay(AbstractActivity activity) throws PrayersException {
        String[] considerations = {activity.getString(R.string.txt_ninth_1_consideration_1), activity.getString(R.string.txt_ninth_1_consideration_2)};
        String[] paragraphs = {activity.getString(R.string.txt_ninth_1_paragraph_1)};

        return new NinthDay(GeneralConstants.FIRST_DAY_NINTH, activity.getString(R.string.title_ninth_day_1), activity.getString(R.string.title_ninth_day_1_only_days), considerations, paragraphs);
    }

    public static NinthDay prepopulateSecondDay(AbstractActivity activity) throws PrayersException {
        String[] considerations = {activity.getString(R.string.txt_ninth_2_consideration_1), activity.getString(R.string.txt_ninth_2_consideration_2), activity.getString(R.string.txt_ninth_2_consideration_3)};
        String[] paragraphs = {activity.getString(R.string.txt_ninth_2_paragraph_1)};

        return new NinthDay(GeneralConstants.SECOND_DAY_NINTH, activity.getString(R.string.title_ninth_day_2), activity.getString(R.string.title_ninth_day_2_only_days), considerations, paragraphs);
    }

    public static NinthDay prepopulateThirdDay(AbstractActivity activity) throws PrayersException {
        String[] considerations = {activity.getString(R.string.txt_ninth_3_consideration_1), activity.getString(R.string.txt_ninth_3_consideration_2)};
        String[] paragraphs = {activity.getString(R.string.txt_ninth_3_paragraph_1)};

        return new NinthDay(GeneralConstants.THIRD_DAY_NINTH, activity.getString(R.string.title_ninth_day_3), activity.getString(R.string.title_ninth_day_3_only_days), considerations, paragraphs);
    }

    public static NinthDay prepopulateFourthDay(AbstractActivity activity) throws PrayersException {
        String[] considerations = {activity.getString(R.string.txt_ninth_4_consideration_1), activity.getString(R.string.txt_ninth_4_consideration_2), activity.getString(R.string.txt_ninth_4_consideration_3)};
        String[] paragraphs = {activity.getString(R.string.txt_ninth_4_paragraph_1)};

        return new NinthDay(GeneralConstants.FOURTH_DAY_NINTH, activity.getString(R.string.title_ninth_day_4), activity.getString(R.string.title_ninth_day_4_only_days), considerations, paragraphs);
    }

    public static NinthDay prepopulateFifthDay(AbstractActivity activity) throws PrayersException {
        String[] considerations = {activity.getString(R.string.txt_ninth_5_consideration_1), activity.getString(R.string.txt_ninth_5_consideration_2), activity.getString(R.string.txt_ninth_5_consideration_3), activity.getString(R.string.txt_ninth_5_consideration_4)};
        String[] paragraphs = {activity.getString(R.string.txt_ninth_5_paragraph_1)};

        return new NinthDay(GeneralConstants.FIFTH_DAY_NINTH, activity.getString(R.string.title_ninth_day_5), activity.getString(R.string.title_ninth_day_5_only_days), considerations, paragraphs);
    }

    public static NinthDay prepopulateSixthDay(AbstractActivity activity) throws PrayersException {
        String[] considerations = {activity.getString(R.string.txt_ninth_6_consideration_1), activity.getString(R.string.txt_ninth_6_consideration_2)};
        String[] paragraphs = {activity.getString(R.string.txt_ninth_6_paragraph_1)};

        return new NinthDay(GeneralConstants.SIXTH_DAY_NINTH, activity.getString(R.string.title_ninth_day_6), activity.getString(R.string.title_ninth_day_6_only_days), considerations, paragraphs);
    }

    public static NinthDay prepopulateSeventhDay(AbstractActivity activity) throws PrayersException {
        String[] considerations = {activity.getString(R.string.txt_ninth_7_consideration_1), activity.getString(R.string.txt_ninth_7_consideration_2)};
        String[] paragraphs = {activity.getString(R.string.txt_ninth_7_paragraph_1)};

        return new NinthDay(GeneralConstants.SEVENTH_DAY_NINTH, activity.getString(R.string.title_ninth_day_7), activity.getString(R.string.title_ninth_day_7_only_days), considerations, paragraphs);
    }

    public static NinthDay prepopulateEighthDay(AbstractActivity activity) throws PrayersException {
        String[] considerations = {activity.getString(R.string.txt_ninth_8_consideration_1), activity.getString(R.string.txt_ninth_8_consideration_2), activity.getString(R.string.txt_ninth_8_consideration_3)};
        String[] paragraphs = {activity.getString(R.string.txt_ninth_8_paragraph_1), activity.getString(R.string.txt_ninth_8_paragraph_2)};

        return new NinthDay(GeneralConstants.EIGHTH_DAY_NINTH, activity.getString(R.string.title_ninth_day_8), activity.getString(R.string.title_ninth_day_8_only_days), considerations, paragraphs);
    }

    public static NinthDay prepopulateNinthDay(AbstractActivity activity) throws PrayersException {
        String[] considerations = {activity.getString(R.string.txt_ninth_9_consideration_1), activity.getString(R.string.txt_ninth_9_consideration_2), activity.getString(R.string.txt_ninth_9_consideration_3)};
        String[] paragraphs = {activity.getString(R.string.txt_ninth_9_paragraph_1), activity.getString(R.string.txt_ninth_9_paragraph_2)};

        return new NinthDay(GeneralConstants.NINTH_DAY_NINTH, activity.getString(R.string.title_ninth_day_9), activity.getString(R.string.title_ninth_day_9_only_days), considerations, paragraphs);
    }

    public static JoysForEveryday getJoysForEveryday(AbstractActivity activity, boolean end) throws PrayersException {
        List<Joy> joys = new ArrayList<>();

        joys.add(new Joy(activity.getString(R.string.txt_ninth_joy_begin), activity.getString(R.string.txt_ninth_joy_answer)));
        joys.add(new Joy(activity.getString(R.string.txt_ninth_joy_1), activity.getString(R.string.txt_ninth_joy_answer)));
        joys.add(new Joy(activity.getString(R.string.txt_ninth_joy_2), activity.getString(R.string.txt_ninth_joy_answer)));
        joys.add(new Joy(activity.getString(R.string.txt_ninth_joy_3), activity.getString(R.string.txt_ninth_joy_answer)));
        joys.add(new Joy(activity.getString(R.string.txt_ninth_joy_4), activity.getString(R.string.txt_ninth_joy_answer)));
        joys.add(new Joy(activity.getString(R.string.txt_ninth_joy_5), activity.getString(R.string.txt_ninth_joy_answer)));
        joys.add(new Joy(activity.getString(R.string.txt_ninth_joy_6), activity.getString(R.string.txt_ninth_joy_answer)));
        joys.add(new Joy(activity.getString(R.string.txt_ninth_joy_7), activity.getString(R.string.txt_ninth_joy_answer)));
        joys.add(new Joy(activity.getString(R.string.txt_ninth_joy_8), activity.getString(R.string.txt_ninth_joy_answer)));
        joys.add(new Joy(activity.getString(R.string.txt_ninth_joy_9), activity.getString(R.string.txt_ninth_joy_answer)));
        joys.add(new Joy(activity.getString(R.string.txt_ninth_joy_10), activity.getString(R.string.txt_ninth_joy_answer)));
        joys.add(new Joy(activity.getString(R.string.txt_ninth_joy_11), activity.getString(R.string.txt_ninth_joy_answer)));
        joys.add(new Joy(activity.getString(R.string.txt_ninth_joy_end), activity.getString(R.string.txt_ninth_joy_answer)));

        return new JoysForEveryday(joys, end);
    }

}
