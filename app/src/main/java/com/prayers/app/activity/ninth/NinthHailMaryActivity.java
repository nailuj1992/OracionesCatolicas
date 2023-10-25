package com.prayers.app.activity.ninth;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.prayers.app.activity.AbstractClosableActivity;
import com.prayers.app.activity.R;
import com.prayers.app.constants.RedirectionConstants;
import com.prayers.app.enums.ETypeHailMary;
import com.prayers.app.exception.PrayersException;
import com.prayers.app.model.HailMary;
import com.prayers.app.model.ninth.NinthDay;
import com.prayers.app.utils.RedirectionUtils;

public class NinthHailMaryActivity extends AbstractClosableActivity {

    private NinthDay selectedDay;
    private HailMary hailMary;

    private TextView txtTextProgress;

    private Button btnPrev;
    private Button btnNext;

    @Override
    public int getActivity() {
        return R.layout.ninth_hail_mary_activity;
    }

    @Override
    public void prepareOthersActivity() {
        txtTextProgress = (TextView) findViewById(R.id.txt_hail_mary_progress);

        btnPrev = (Button) findViewById(R.id.btn_prev);
        btnPrev.setOnClickListener(v -> backAction());

        btnNext = (Button) findViewById(R.id.btn_next);
        btnNext.setOnClickListener(v -> nextAction());
    }

    @Override
    public void updateViewState() {
        try {
            selectedDay = (NinthDay) getIntent().getExtras().getSerializable(RedirectionConstants.SELECTED_NINTH_DAY);

            boolean currentHailMary = (boolean) getIntent().getExtras().getBoolean(RedirectionConstants.HAIL_MARY_FROM_END);
            if (hailMary == null) {
                hailMary = new HailMary(currentHailMary, ETypeHailMary.NINTH);
            }

            updateHailMaryState();
        } catch (Exception ex) {
            // TODO Log exception
        }
    }

    private void updateHailMaryState() {
        txtTextProgress.setText(String.format(getString(R.string.txt_progress), String.valueOf(hailMary.getCurrent()), String.valueOf(hailMary.getTotal())));
    }

    @Override
    public void backAction() {
        try {
            hailMary.decreaseValue();
            updateHailMaryState();
        } catch (PrayersException e) {
            Bundle bundle = new Bundle();
            bundle.putSerializable(RedirectionConstants.SELECTED_NINTH_DAY, selectedDay);

            RedirectionUtils.redirectToAnotherActivityWithExtras(this, bundle, NinthVirginMaryPrayerActivity.class);
        }
    }

    @Override
    public void nextAction() {
        try {
            hailMary.increaseValue();
            updateHailMaryState();
        } catch (PrayersException e) {
            Bundle bundle = new Bundle();
            bundle.putSerializable(RedirectionConstants.SELECTED_NINTH_DAY, selectedDay);

            RedirectionUtils.redirectToAnotherActivityWithExtras(this, bundle, NinthSaintJosephPrayerActivity.class);
        }
    }

}
