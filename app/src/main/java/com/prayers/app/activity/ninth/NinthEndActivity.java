package com.prayers.app.activity.ninth;

import android.widget.TextView;

import com.prayers.app.activity.R;
import com.prayers.app.navigation.PrayerScreen;
import com.prayers.app.utils.FieldsUtils;

public class NinthEndActivity extends AbstractNinthActivity {

    private TextView txtSignCross;

    @Override
    public int getActivity() {
        return R.layout.ninth_end_activity;
    }

    @Override
    public void prepareViewFields() {
        txtSignCross = (TextView) findViewById(R.id.txt_sign_cross);
        FieldsUtils.justifyText(txtSignCross);
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
        redirectToHome();
    }

}
