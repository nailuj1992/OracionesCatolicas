package com.prayers.app.mapper;

import android.content.res.Configuration;
import android.widget.ImageView;

import com.prayers.app.activity.AbstractActivity;
import com.prayers.app.activity.R;
import com.prayers.app.constants.GeneralConstants;
import com.prayers.app.exception.PrayersException;
import com.prayers.app.model.HailMary;
import com.prayers.app.model.rosary.Mysteries;
import com.prayers.app.model.rosary.Mystery;

public class RosaryMapper {

    public static Mysteries prepopulateJoyfulMysteries(AbstractActivity activity, String reflection, String pause) throws PrayersException {
        Mystery first = new Mystery(GeneralConstants.FIRST_MYSTERY, activity.getString(R.string.txt_rosary_joyful_1), reflection, activity.getString(R.string.txt_rosary_joyful_1_paragrafh_1), activity.getString(R.string.txt_rosary_joyful_1_paragrafh_2), pause);
        Mystery second = new Mystery(GeneralConstants.SECOND_MYSTERY, activity.getString(R.string.txt_rosary_joyful_2), reflection, activity.getString(R.string.txt_rosary_joyful_2_paragrafh_1), activity.getString(R.string.txt_rosary_joyful_2_paragrafh_2), pause);
        Mystery third = new Mystery(GeneralConstants.THIRD_MYSTERY, activity.getString(R.string.txt_rosary_joyful_3), reflection, activity.getString(R.string.txt_rosary_joyful_3_paragrafh_1), activity.getString(R.string.txt_rosary_joyful_3_paragrafh_2), pause);
        Mystery fourth = new Mystery(GeneralConstants.FOURTH_MYSTERY, activity.getString(R.string.txt_rosary_joyful_4), reflection, activity.getString(R.string.txt_rosary_joyful_4_paragrafh_1), activity.getString(R.string.txt_rosary_joyful_4_paragrafh_2), pause, activity.getString(R.string.txt_rosary_joyful_4_paragrafh_3));
        Mystery fifth = new Mystery(GeneralConstants.FIFTH_MYSTERY, activity.getString(R.string.txt_rosary_joyful_5), reflection, activity.getString(R.string.txt_rosary_joyful_5_paragrafh_1), activity.getString(R.string.txt_rosary_joyful_5_paragrafh_2), pause);

        return new Mysteries(GeneralConstants.JOYFUL_MYSTERIES, activity.getString(R.string.title_rosary_joyful), activity.getString(R.string.title_rosary_joyful_only_days), first, second, third, fourth, fifth);
    }

    public static Mysteries prepopulateSorrowfulMysteries(AbstractActivity activity, String reflection, String pause) throws PrayersException {
        Mystery first = new Mystery(GeneralConstants.FIRST_MYSTERY, activity.getString(R.string.txt_rosary_sorrowful_1), reflection, activity.getString(R.string.txt_rosary_sorrowful_1_paragrafh_1), activity.getString(R.string.txt_rosary_sorrowful_1_paragrafh_2), pause);
        Mystery second = new Mystery(GeneralConstants.SECOND_MYSTERY, activity.getString(R.string.txt_rosary_sorrowful_2), reflection, activity.getString(R.string.txt_rosary_sorrowful_2_paragrafh_1), activity.getString(R.string.txt_rosary_sorrowful_2_paragrafh_2), pause);
        Mystery third = new Mystery(GeneralConstants.THIRD_MYSTERY, activity.getString(R.string.txt_rosary_sorrowful_3), reflection, activity.getString(R.string.txt_rosary_sorrowful_3_paragrafh_1), pause);
        Mystery fourth = new Mystery(GeneralConstants.FOURTH_MYSTERY, activity.getString(R.string.txt_rosary_sorrowful_4), reflection, activity.getString(R.string.txt_rosary_sorrowful_4_paragrafh_1), activity.getString(R.string.txt_rosary_sorrowful_4_paragrafh_2), pause);
        Mystery fifth = new Mystery(GeneralConstants.FIFTH_MYSTERY, activity.getString(R.string.txt_rosary_sorrowful_5), reflection, activity.getString(R.string.txt_rosary_sorrowful_5_paragrafh_1), activity.getString(R.string.txt_rosary_sorrowful_5_paragrafh_2), activity.getString(R.string.txt_rosary_sorrowful_5_paragrafh_3), pause);

        return new Mysteries(GeneralConstants.SORROWFUL_MYSTERIES, activity.getString(R.string.title_rosary_sorrowful), activity.getString(R.string.title_rosary_sorrowful_only_days), first, second, third, fourth, fifth);
    }

    public static Mysteries prepopulateGloriousMysteries(AbstractActivity activity, String reflection, String pause) throws PrayersException {
        Mystery first = new Mystery(GeneralConstants.FIRST_MYSTERY, activity.getString(R.string.txt_rosary_glorious_1), reflection, activity.getString(R.string.txt_rosary_glorious_1_paragrafh_1), activity.getString(R.string.txt_rosary_glorious_1_paragrafh_2), pause);
        Mystery second = new Mystery(GeneralConstants.SECOND_MYSTERY, activity.getString(R.string.txt_rosary_glorious_2), reflection, activity.getString(R.string.txt_rosary_glorious_2_paragrafh_1), activity.getString(R.string.txt_rosary_glorious_2_paragrafh_2), pause);
        Mystery third = new Mystery(GeneralConstants.THIRD_MYSTERY, activity.getString(R.string.txt_rosary_glorious_3), reflection, activity.getString(R.string.txt_rosary_glorious_3_paragrafh_1), activity.getString(R.string.txt_rosary_glorious_3_paragrafh_2), pause);
        Mystery fourth = new Mystery(GeneralConstants.FOURTH_MYSTERY, activity.getString(R.string.txt_rosary_glorious_4), reflection, activity.getString(R.string.txt_rosary_glorious_4_paragrafh_1), activity.getString(R.string.txt_rosary_glorious_4_paragrafh_2), activity.getString(R.string.txt_rosary_glorious_4_paragrafh_3), pause);
        Mystery fifth = new Mystery(GeneralConstants.FIFTH_MYSTERY, activity.getString(R.string.txt_rosary_glorious_5), reflection, activity.getString(R.string.txt_rosary_glorious_5_paragrafh_1), activity.getString(R.string.txt_rosary_glorious_5_paragrafh_2), activity.getString(R.string.txt_rosary_glorious_5_paragrafh_3), pause);

        return new Mysteries(GeneralConstants.GLORIOUS_MYSTERIES, activity.getString(R.string.title_rosary_glorious), activity.getString(R.string.title_rosary_glorious_only_days), first, second, third, fourth, fifth);
    }

    public static Mysteries prepopulateLuminousMysteries(AbstractActivity activity, String reflection, String pause) throws PrayersException {
        Mystery first = new Mystery(GeneralConstants.FIRST_MYSTERY, activity.getString(R.string.txt_rosary_luminous_1), reflection, activity.getString(R.string.txt_rosary_luminous_1_paragrafh_1), activity.getString(R.string.txt_rosary_luminous_1_paragrafh_2), pause);
        Mystery second = new Mystery(GeneralConstants.SECOND_MYSTERY, activity.getString(R.string.txt_rosary_luminous_2), reflection, activity.getString(R.string.txt_rosary_luminous_2_paragrafh_1), activity.getString(R.string.txt_rosary_luminous_2_paragrafh_2), activity.getString(R.string.txt_rosary_luminous_2_paragrafh_3), pause);
        Mystery third = new Mystery(GeneralConstants.THIRD_MYSTERY, activity.getString(R.string.txt_rosary_luminous_3), reflection, activity.getString(R.string.txt_rosary_luminous_3_paragrafh_1), activity.getString(R.string.txt_rosary_luminous_3_paragrafh_2), activity.getString(R.string.txt_rosary_luminous_3_paragrafh_3), activity.getString(R.string.txt_rosary_luminous_3_paragrafh_4), pause);
        Mystery fourth = new Mystery(GeneralConstants.FOURTH_MYSTERY, activity.getString(R.string.txt_rosary_luminous_4), reflection, activity.getString(R.string.txt_rosary_luminous_4_paragrafh_1), activity.getString(R.string.txt_rosary_luminous_4_paragrafh_2), pause);
        Mystery fifth = new Mystery(GeneralConstants.FIFTH_MYSTERY, activity.getString(R.string.txt_rosary_luminous_5), reflection, activity.getString(R.string.txt_rosary_luminous_5_paragrafh_1), activity.getString(R.string.txt_rosary_luminous_5_paragrafh_2), pause);

        return new Mysteries(GeneralConstants.LUMINOUS_MYSTERIES, activity.getString(R.string.title_rosary_luminous), activity.getString(R.string.title_rosary_luminous_only_days), first, second, third, fourth, fifth);
    }

    public static void changeImageForRosary(AbstractActivity activity, Mysteries selectedMysteries, ImageView imgMysteriesBackground) {
        int orientation = activity.getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            switch (selectedMysteries.getValue()) {
                case GeneralConstants.JOYFUL_MYSTERIES:
                    imgMysteriesBackground.setImageResource(R.mipmap.joyful_horiz);
                    break;
                case GeneralConstants.SORROWFUL_MYSTERIES:
                    imgMysteriesBackground.setImageResource(R.mipmap.sorrowful_horiz);
                    break;
                case GeneralConstants.GLORIOUS_MYSTERIES:
                    imgMysteriesBackground.setImageResource(R.mipmap.glorious_horiz);
                    break;
                case GeneralConstants.LUMINOUS_MYSTERIES:
                    imgMysteriesBackground.setImageResource(R.mipmap.luminous_horiz);
                    break;
            }
        } else {
            switch (selectedMysteries.getValue()) {
                case GeneralConstants.JOYFUL_MYSTERIES:
                    imgMysteriesBackground.setImageResource(R.mipmap.joyful_vert);
                    break;
                case GeneralConstants.SORROWFUL_MYSTERIES:
                    imgMysteriesBackground.setImageResource(R.mipmap.sorrowful_vert);
                    break;
                case GeneralConstants.GLORIOUS_MYSTERIES:
                    imgMysteriesBackground.setImageResource(R.mipmap.glorious_vert);
                    break;
                case GeneralConstants.LUMINOUS_MYSTERIES:
                    imgMysteriesBackground.setImageResource(R.mipmap.luminous_vert);
                    break;
            }
        }
    }

    public static String getCurrentMysteryLocation(AbstractActivity activity, int currentMysteries, Mystery selectedMystery) {
        String ordinal = activity.getString(R.string.txt_blank);
        switch (selectedMystery.getValue()) {
            case GeneralConstants.FIRST_MYSTERY:
                ordinal = activity.getString(R.string.txt_first);
                break;
            case GeneralConstants.SECOND_MYSTERY:
                ordinal = activity.getString(R.string.txt_second);
                break;
            case GeneralConstants.THIRD_MYSTERY:
                ordinal = activity.getString(R.string.txt_third);
                break;
            case GeneralConstants.FOURTH_MYSTERY:
                ordinal = activity.getString(R.string.txt_fourth);
                break;
            case GeneralConstants.FIFTH_MYSTERY:
                ordinal = activity.getString(R.string.txt_fifth);
                break;
        }

        String mystery = activity.getString(R.string.txt_blank);
        switch (currentMysteries) {
            case GeneralConstants.JOYFUL_MYSTERIES:
                mystery = activity.getString(R.string.txt_rosary_joyful_mystery_single);
                break;
            case GeneralConstants.SORROWFUL_MYSTERIES:
                mystery = activity.getString(R.string.txt_rosary_sorrowful_mystery_single);
                break;
            case GeneralConstants.GLORIOUS_MYSTERIES:
                mystery = activity.getString(R.string.txt_rosary_glorious_mystery_single);
                break;
            case GeneralConstants.LUMINOUS_MYSTERIES:
                mystery = activity.getString(R.string.txt_rosary_luminous_mystery_single);
                break;
        }
        return String.format("%s %s", ordinal, mystery);
    }

    public static int getCurrentMysteryHailMaryImg(Mystery selectedMystery, HailMary hailMary) {
        if (selectedMystery == null) {
            switch (hailMary.getCurrent()) {
                case GeneralConstants.MIN_HAIL_MARY:
                    return R.mipmap.rosary_6_1;
                case GeneralConstants.HAIL_MARY_2:
                    return R.mipmap.rosary_6_2;
                case GeneralConstants.HAIL_MARY_3:
                    return R.mipmap.rosary_6_3;
            }
        }
        switch (selectedMystery.getValue()) {
            case GeneralConstants.FIRST_MYSTERY:
                switch (hailMary.getCurrent()) {
                    case GeneralConstants.MIN_HAIL_MARY:
                        return R.mipmap.rosary_1_1;
                    case GeneralConstants.HAIL_MARY_2:
                        return R.mipmap.rosary_1_2;
                    case GeneralConstants.HAIL_MARY_3:
                        return R.mipmap.rosary_1_3;
                    case GeneralConstants.HAIL_MARY_4:
                        return R.mipmap.rosary_1_4;
                    case GeneralConstants.HAIL_MARY_5:
                        return R.mipmap.rosary_1_5;
                    case GeneralConstants.HAIL_MARY_6:
                        return R.mipmap.rosary_1_6;
                    case GeneralConstants.HAIL_MARY_7:
                        return R.mipmap.rosary_1_7;
                    case GeneralConstants.HAIL_MARY_8:
                        return R.mipmap.rosary_1_8;
                    case GeneralConstants.HAIL_MARY_9:
                        return R.mipmap.rosary_1_9;
                    case GeneralConstants.HAIL_MARY_10:
                        return R.mipmap.rosary_1_10;
                }
            case GeneralConstants.SECOND_MYSTERY:
                switch (hailMary.getCurrent()) {
                    case GeneralConstants.MIN_HAIL_MARY:
                        return R.mipmap.rosary_2_1;
                    case GeneralConstants.HAIL_MARY_2:
                        return R.mipmap.rosary_2_2;
                    case GeneralConstants.HAIL_MARY_3:
                        return R.mipmap.rosary_2_3;
                    case GeneralConstants.HAIL_MARY_4:
                        return R.mipmap.rosary_2_4;
                    case GeneralConstants.HAIL_MARY_5:
                        return R.mipmap.rosary_2_5;
                    case GeneralConstants.HAIL_MARY_6:
                        return R.mipmap.rosary_2_6;
                    case GeneralConstants.HAIL_MARY_7:
                        return R.mipmap.rosary_2_7;
                    case GeneralConstants.HAIL_MARY_8:
                        return R.mipmap.rosary_2_8;
                    case GeneralConstants.HAIL_MARY_9:
                        return R.mipmap.rosary_2_9;
                    case GeneralConstants.HAIL_MARY_10:
                        return R.mipmap.rosary_2_10;
                }
            case GeneralConstants.THIRD_MYSTERY:
                switch (hailMary.getCurrent()) {
                    case GeneralConstants.MIN_HAIL_MARY:
                        return R.mipmap.rosary_3_1;
                    case GeneralConstants.HAIL_MARY_2:
                        return R.mipmap.rosary_3_2;
                    case GeneralConstants.HAIL_MARY_3:
                        return R.mipmap.rosary_3_3;
                    case GeneralConstants.HAIL_MARY_4:
                        return R.mipmap.rosary_3_4;
                    case GeneralConstants.HAIL_MARY_5:
                        return R.mipmap.rosary_3_5;
                    case GeneralConstants.HAIL_MARY_6:
                        return R.mipmap.rosary_3_6;
                    case GeneralConstants.HAIL_MARY_7:
                        return R.mipmap.rosary_3_7;
                    case GeneralConstants.HAIL_MARY_8:
                        return R.mipmap.rosary_3_8;
                    case GeneralConstants.HAIL_MARY_9:
                        return R.mipmap.rosary_3_9;
                    case GeneralConstants.HAIL_MARY_10:
                        return R.mipmap.rosary_3_10;
                }
            case GeneralConstants.FOURTH_MYSTERY:
                switch (hailMary.getCurrent()) {
                    case GeneralConstants.MIN_HAIL_MARY:
                        return R.mipmap.rosary_4_1;
                    case GeneralConstants.HAIL_MARY_2:
                        return R.mipmap.rosary_4_2;
                    case GeneralConstants.HAIL_MARY_3:
                        return R.mipmap.rosary_4_3;
                    case GeneralConstants.HAIL_MARY_4:
                        return R.mipmap.rosary_4_4;
                    case GeneralConstants.HAIL_MARY_5:
                        return R.mipmap.rosary_4_5;
                    case GeneralConstants.HAIL_MARY_6:
                        return R.mipmap.rosary_4_6;
                    case GeneralConstants.HAIL_MARY_7:
                        return R.mipmap.rosary_4_7;
                    case GeneralConstants.HAIL_MARY_8:
                        return R.mipmap.rosary_4_8;
                    case GeneralConstants.HAIL_MARY_9:
                        return R.mipmap.rosary_4_9;
                    case GeneralConstants.HAIL_MARY_10:
                        return R.mipmap.rosary_4_10;
                }
            case GeneralConstants.FIFTH_MYSTERY:
                switch (hailMary.getCurrent()) {
                    case GeneralConstants.MIN_HAIL_MARY:
                        return R.mipmap.rosary_5_1;
                    case GeneralConstants.HAIL_MARY_2:
                        return R.mipmap.rosary_5_2;
                    case GeneralConstants.HAIL_MARY_3:
                        return R.mipmap.rosary_5_3;
                    case GeneralConstants.HAIL_MARY_4:
                        return R.mipmap.rosary_5_4;
                    case GeneralConstants.HAIL_MARY_5:
                        return R.mipmap.rosary_5_5;
                    case GeneralConstants.HAIL_MARY_6:
                        return R.mipmap.rosary_5_6;
                    case GeneralConstants.HAIL_MARY_7:
                        return R.mipmap.rosary_5_7;
                    case GeneralConstants.HAIL_MARY_8:
                        return R.mipmap.rosary_5_8;
                    case GeneralConstants.HAIL_MARY_9:
                        return R.mipmap.rosary_5_9;
                    case GeneralConstants.HAIL_MARY_10:
                        return R.mipmap.rosary_5_10;
                }
        }
        return R.mipmap.rosary_empty;
    }

    public static int getCurrentMysteryGloryBeImg(Mystery selectedMystery) {
        if (selectedMystery != null) {
            switch (selectedMystery.getValue()) {
                case GeneralConstants.FIRST_MYSTERY:
                    return R.mipmap.rosary_1_11;
                case GeneralConstants.SECOND_MYSTERY:
                    return R.mipmap.rosary_2_11;
                case GeneralConstants.THIRD_MYSTERY:
                    return R.mipmap.rosary_3_11;
                case GeneralConstants.FOURTH_MYSTERY:
                    return R.mipmap.rosary_4_11;
                case GeneralConstants.FIFTH_MYSTERY:
                    return R.mipmap.rosary_5_11;
            }
        } else {
            return R.mipmap.rosary_6_4;
        }
        return R.mipmap.rosary_empty;
    }

    public static int getCurrentMysteryOurFatherImg(Mystery selectedMystery) {
        if (selectedMystery != null) {
            return R.mipmap.rosary_empty;
        } else {
            return R.mipmap.rosary_6_0;
        }
    }

}
