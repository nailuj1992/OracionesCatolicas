package com.prayers.app.activity.ninth;

import android.os.Bundle;
import android.widget.TextView;

import com.prayers.app.activity.R;
import com.prayers.app.constants.RedirectionConstants;
import com.prayers.app.navigation.PrayerScreen;
import com.prayers.app.utils.FieldsUtils;

public class NinthInitialPrayerActivity extends AbstractNinthActivity {

    private TextView txtInitialPrayer1;
    private TextView txtInitialPrayer2;

    @Override
    public int getActivity() {
        return R.layout.ninth_initial_prayer_activity;
    }

    @Override
    public void prepareViewFields() {
        txtInitialPrayer1 = (TextView) findViewById(R.id.txt_ninth_initial_prayer_1);
        FieldsUtils.justifyText(txtInitialPrayer1);

        txtInitialPrayer2 = (TextView) findViewById(R.id.txt_ninth_initial_prayer_2);
        FieldsUtils.justifyText(txtInitialPrayer2);
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
        bundle.putSerializable(RedirectionConstants.GLORY_BE_FROM_END, Boolean.FALSE);
        PrayerScreen.goNext(this, bundle);
    }

}
