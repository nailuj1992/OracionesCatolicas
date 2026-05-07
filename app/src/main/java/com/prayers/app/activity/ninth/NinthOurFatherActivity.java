package com.prayers.app.activity.ninth;

import android.os.Bundle;

import com.prayers.app.activity.R;
import com.prayers.app.constants.RedirectionConstants;
import com.prayers.app.navigation.PrayerScreen;

public class NinthOurFatherActivity extends AbstractNinthActivity {

    @Override
    public int getActivity() {
        return R.layout.ninth_our_father_activity;
    }

    @Override
    public void prepareViewFields() {
    }

    @Override
    protected void updateNinthView() {
    }

    @Override
    public void backAction() {
        PrayerScreen.goPrev(this, buildBaseBundle());
    }

    @Override
    public void nextAction() {
        Bundle bundle = buildBaseBundle();
        bundle.putSerializable(RedirectionConstants.JOYS_FROM_END, Boolean.FALSE);
        PrayerScreen.goNext(this, bundle);
    }

}
