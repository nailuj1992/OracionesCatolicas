package com.prayers.app.activity.ninth;

import android.os.Bundle;
import android.widget.TextView;

import com.prayers.app.activity.R;
import com.prayers.app.constants.RedirectionConstants;
import com.prayers.app.navigation.PrayerScreen;
import com.prayers.app.utils.FieldsUtils;

public class NinthSaintJosephPrayerActivity extends AbstractNinthActivity {

    private TextView txtPrayer1;
    private TextView txtPrayer2;

    @Override
    public int getActivity() {
        return R.layout.ninth_saint_joseph_prayer_activity;
    }

    @Override
    public void prepareViewFields() {
        txtPrayer1 = (TextView) findViewById(R.id.txt_ninth_joseph_prayer_1);
        FieldsUtils.justifyText(txtPrayer1);

        txtPrayer2 = (TextView) findViewById(R.id.txt_ninth_joseph_prayer_2);
        FieldsUtils.justifyText(txtPrayer2);
    }

    @Override
    protected void updateNinthView() {
    }

    @Override
    public void backAction() {
        Bundle bundle = buildBaseBundle();
        bundle.putSerializable(RedirectionConstants.HAIL_MARY_FROM_END, Boolean.TRUE);
        PrayerScreen.goPrev(this, bundle);
    }

    @Override
    public void nextAction() {
        PrayerScreen.goNext(this, buildBaseBundle());
    }

}
