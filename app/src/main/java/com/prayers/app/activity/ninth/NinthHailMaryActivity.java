package com.prayers.app.activity.ninth;

import android.widget.TextView;

import com.prayers.app.activity.R;
import com.prayers.app.constants.RedirectionConstants;
import com.prayers.app.enums.ETypeHailMary;
import com.prayers.app.exception.PrayersException;
import com.prayers.app.model.HailMary;
import com.prayers.app.navigation.PrayerScreen;

public class NinthHailMaryActivity extends AbstractNinthActivity {

    private HailMary hailMary;

    private TextView txtTextProgress;

    @Override
    public int getActivity() {
        return R.layout.ninth_hail_mary_activity;
    }

    @Override
    public void prepareViewFields() {
        txtTextProgress = (TextView) findViewById(R.id.txt_hail_mary_progress);
    }

    @Override
    protected void updateNinthView() {
        boolean currentHailMary = false;
        if (getIntent().getExtras() != null) {
            currentHailMary = getIntent().getExtras().getBoolean(RedirectionConstants.HAIL_MARY_FROM_END);
        }
        if (hailMary == null) {
            hailMary = new HailMary(currentHailMary, ETypeHailMary.NINTH);
        }
        updateHailMaryState();
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
            PrayerScreen.goPrev(this, buildBaseBundle());
        }
    }

    @Override
    public void nextAction() {
        try {
            hailMary.increaseValue();
            updateHailMaryState();
        } catch (PrayersException e) {
            PrayerScreen.goNext(this, buildBaseBundle());
        }
    }

}
