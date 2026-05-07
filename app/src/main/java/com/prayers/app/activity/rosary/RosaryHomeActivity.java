package com.prayers.app.activity.rosary;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import com.prayers.app.activity.AbstractClosableActivity;
import com.prayers.app.activity.R;
import com.prayers.app.activity.SpecialPrayersActivity;
import com.prayers.app.constants.GeneralConstants;
import com.prayers.app.constants.RedirectionConstants;
import com.prayers.app.mapper.RosaryMapper;
import com.prayers.app.model.rosary.Mysteries;
import com.prayers.app.utils.FieldsUtils;
import com.prayers.app.utils.GeneralUtils;
import com.prayers.app.utils.RedirectionUtils;

import java.util.Calendar;

public class RosaryHomeActivity extends AbstractClosableActivity {

    private Mysteries[] mysteries;
    private Mysteries selectedMysteries;

    private RadioGroup radioMysteries;

    @Override
    public int getActivity() {
        return R.layout.rosary_home_activity;
    }

    @Override
    public void prepareViewFields() {
        radioMysteries = (RadioGroup) findViewById(R.id.radio_mysteries);
    }

    @Override
    public void updateViewState() {
        mysteries = new Mysteries[GeneralConstants.MAX_GROUP_MYSTERIES];

        try {
            final String reflection = getString(R.string.txt_rosary_reflection);
            final String pause = getString(R.string.txt_rosary_pause);

            mysteries[GeneralConstants.JOYFUL_MYSTERIES] = RosaryMapper.prepopulateJoyfulMysteries(this, reflection, pause);
            mysteries[GeneralConstants.SORROWFUL_MYSTERIES] = RosaryMapper.prepopulateSorrowfulMysteries(this, reflection, pause);
            mysteries[GeneralConstants.GLORIOUS_MYSTERIES] = RosaryMapper.prepopulateGloriousMysteries(this, reflection, pause);
            mysteries[GeneralConstants.LUMINOUS_MYSTERIES] = RosaryMapper.prepopulateLuminousMysteries(this, reflection, pause);
        } catch (Exception ex) {
            android.util.Log.w(TAG_PRAYERS, getClass().getSimpleName() + ".updateViewState failed", ex);
        }

        selectedMysteries = null;
    }

    @Override
    public void backAction() {
        FieldsUtils.toastMakeTest(getApplicationContext(), getResources().getText(R.string.title_special_prayers));
        RedirectionUtils.redirectToAnotherActivity(this, SpecialPrayersActivity.class);
    }

    @Override
    public void nextAction() {
        int selected = radioMysteries.getCheckedRadioButtonId();
        if (selected != -1) {
            View radioView = radioMysteries.findViewById(selected);
            int idx = radioMysteries.indexOfChild(radioView) - 1;
            switch (idx) {
                case GeneralConstants.JOYFUL_MYSTERIES:
                    selectedMysteries = mysteries[GeneralConstants.JOYFUL_MYSTERIES];
                    break;
                case GeneralConstants.SORROWFUL_MYSTERIES:
                    selectedMysteries = mysteries[GeneralConstants.SORROWFUL_MYSTERIES];
                    break;
                case GeneralConstants.GLORIOUS_MYSTERIES:
                    selectedMysteries = mysteries[GeneralConstants.GLORIOUS_MYSTERIES];
                    break;
                case GeneralConstants.LUMINOUS_MYSTERIES:
                    selectedMysteries = mysteries[GeneralConstants.LUMINOUS_MYSTERIES];
                    break;
                default:
                    selectedMysteries = null;
            }
        } else {
            selectedMysteries = null;
            int day = GeneralUtils.getDayNumberToday();
            switch (day) {
                case Calendar.MONDAY:
                case Calendar.SATURDAY:
                    selectedMysteries = mysteries[GeneralConstants.JOYFUL_MYSTERIES];
                    break;
                case Calendar.TUESDAY:
                case Calendar.FRIDAY:
                    selectedMysteries = mysteries[GeneralConstants.SORROWFUL_MYSTERIES];
                    break;
                case Calendar.WEDNESDAY:
                case Calendar.SUNDAY:
                    selectedMysteries = mysteries[GeneralConstants.GLORIOUS_MYSTERIES];
                    break;
                case Calendar.THURSDAY:
                    selectedMysteries = mysteries[GeneralConstants.LUMINOUS_MYSTERIES];
                    break;
            }
        }
        if (selectedMysteries != null) {
            Bundle bundle = new Bundle();
            bundle.putSerializable(RedirectionConstants.SELECTED_MYSTERIES, selectedMysteries);

            RedirectionUtils.redirectToAnotherActivityWithExtras(this, bundle, RosaryMysteriesActivity.class);
        }
    }

}
