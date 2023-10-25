package com.prayers.app.activity.ninth;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import com.prayers.app.activity.AbstractClosableActivity;
import com.prayers.app.activity.R;
import com.prayers.app.activity.SpecialPrayersActivity;
import com.prayers.app.constants.GeneralConstants;
import com.prayers.app.constants.RedirectionConstants;
import com.prayers.app.mapper.NinthMapper;
import com.prayers.app.model.ninth.NinthDay;
import com.prayers.app.utils.FieldsUtils;
import com.prayers.app.utils.RedirectionUtils;

import java.util.Calendar;

public class NinthHomeActivity extends AbstractClosableActivity {

    private NinthDay[] days;
    private NinthDay selectedDay;

    private RadioGroup radioDays;

    private Button btnPrev;
    private Button btnBegin;

    @Override
    public int getActivity() {
        return R.layout.ninth_home_activity;
    }

    @Override
    public void prepareOthersActivity() {
        radioDays = (RadioGroup) findViewById(R.id.radio_days);

        btnPrev = (Button) findViewById(R.id.btn_prev);
        btnPrev.setOnClickListener(v -> backAction());

        btnBegin = (Button) findViewById(R.id.btn_begin);
        btnBegin.setOnClickListener(v -> nextAction());
    }

    @Override
    public void updateViewState() {
        days = new NinthDay[GeneralConstants.MAX_DAYS_NINTH];

        try {
            days[GeneralConstants.FIRST_DAY_NINTH] = NinthMapper.prepopulateFirstDay(this);
            days[GeneralConstants.SECOND_DAY_NINTH] = NinthMapper.prepopulateSecondDay(this);
            days[GeneralConstants.THIRD_DAY_NINTH] = NinthMapper.prepopulateThirdDay(this);
            days[GeneralConstants.FOURTH_DAY_NINTH] = NinthMapper.prepopulateFourthDay(this);
            days[GeneralConstants.FIFTH_DAY_NINTH] = NinthMapper.prepopulateFifthDay(this);
            days[GeneralConstants.SIXTH_DAY_NINTH] = NinthMapper.prepopulateSixthDay(this);
            days[GeneralConstants.SEVENTH_DAY_NINTH] = NinthMapper.prepopulateSeventhDay(this);
            days[GeneralConstants.EIGHTH_DAY_NINTH] = NinthMapper.prepopulateEighthDay(this);
            days[GeneralConstants.NINTH_DAY_NINTH] = NinthMapper.prepopulateNinthDay(this);
        } catch (Exception ex) {
            // TODO Log exception
        }

        selectedDay = null;
    }

    @Override
    public void backAction() {
        FieldsUtils.toastMakeTest(getApplicationContext(), getResources().getText(R.string.title_special_prayers));
        RedirectionUtils.redirectToAnotherActivity(this, SpecialPrayersActivity.class);
    }

    @Override
    public void nextAction() {
        int selected = radioDays.getCheckedRadioButtonId();
        if (selected != -1) {
            View radioView = radioDays.findViewById(selected);
            int idx = radioDays.indexOfChild(radioView) - 1;
            switch (idx) {
                case GeneralConstants.FIRST_DAY_NINTH:
                    selectedDay = days[GeneralConstants.FIRST_DAY_NINTH];
                    break;
                case GeneralConstants.SECOND_DAY_NINTH:
                    selectedDay = days[GeneralConstants.SECOND_DAY_NINTH];
                    break;
                case GeneralConstants.THIRD_DAY_NINTH:
                    selectedDay = days[GeneralConstants.THIRD_DAY_NINTH];
                    break;
                case GeneralConstants.FOURTH_DAY_NINTH:
                    selectedDay = days[GeneralConstants.FOURTH_DAY_NINTH];
                    break;
                case GeneralConstants.FIFTH_DAY_NINTH:
                    selectedDay = days[GeneralConstants.FIFTH_DAY_NINTH];
                    break;
                case GeneralConstants.SIXTH_DAY_NINTH:
                    selectedDay = days[GeneralConstants.SIXTH_DAY_NINTH];
                    break;
                case GeneralConstants.SEVENTH_DAY_NINTH:
                    selectedDay = days[GeneralConstants.SEVENTH_DAY_NINTH];
                    break;
                case GeneralConstants.EIGHTH_DAY_NINTH:
                    selectedDay = days[GeneralConstants.EIGHTH_DAY_NINTH];
                    break;
                case GeneralConstants.NINTH_DAY_NINTH:
                    selectedDay = days[GeneralConstants.NINTH_DAY_NINTH];
                    break;
                default:
                    selectedDay = null;
            }
        } else {
            selectedDay = null;
            Calendar cal = Calendar.getInstance();

            int month = cal.get(Calendar.MONTH);
            int day = cal.get(Calendar.DATE);
            if (month == Calendar.DECEMBER && day >= 16 && day <= 24) {
                switch (day) {
                    case 16:
                        selectedDay = days[GeneralConstants.FIRST_DAY_NINTH];
                        break;
                    case 17:
                        selectedDay = days[GeneralConstants.SECOND_DAY_NINTH];
                        break;
                    case 18:
                        selectedDay = days[GeneralConstants.THIRD_DAY_NINTH];
                        break;
                    case 19:
                        selectedDay = days[GeneralConstants.FOURTH_DAY_NINTH];
                        break;
                    case 20:
                        selectedDay = days[GeneralConstants.FIFTH_DAY_NINTH];
                        break;
                    case 21:
                        selectedDay = days[GeneralConstants.SIXTH_DAY_NINTH];
                        break;
                    case 22:
                        selectedDay = days[GeneralConstants.SEVENTH_DAY_NINTH];
                        break;
                    case 23:
                        selectedDay = days[GeneralConstants.EIGHTH_DAY_NINTH];
                        break;
                    case 24:
                        selectedDay = days[GeneralConstants.NINTH_DAY_NINTH];
                        break;
                }
            }
        }
        if (selectedDay != null) {
            Bundle bundle = new Bundle();
            bundle.putSerializable(RedirectionConstants.SELECTED_NINTH_DAY, selectedDay);

            RedirectionUtils.redirectToAnotherActivityWithExtras(this, bundle, NinthBeginActivity.class);
        } else {
            FieldsUtils.toastMakeTest(getApplicationContext(), getResources().getText(R.string.txt_ninth_today_not_suitable));
        }
    }

}
