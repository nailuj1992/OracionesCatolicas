package com.prayers.app.activity.ninth;

import android.widget.TextView;

import com.prayers.app.activity.R;
import com.prayers.app.navigation.PrayerScreen;
import com.prayers.app.utils.FieldsUtils;
import com.prayers.app.utils.RedirectionUtils;

public class NinthBeginActivity extends AbstractNinthActivity {

    private TextView txtSignCross1;
    private TextView txtSignCross2;
    private TextView txtNinthOffering;

    @Override
    public int getActivity() {
        return R.layout.ninth_begin_activity;
    }

    @Override
    public void prepareViewFields() {
        txtSignCross1 = (TextView) findViewById(R.id.txt_sign_cross_1);
        FieldsUtils.justifyText(txtSignCross1);

        txtSignCross2 = (TextView) findViewById(R.id.txt_sign_cross_2);
        FieldsUtils.justifyText(txtSignCross2);

        txtNinthOffering = (TextView) findViewById(R.id.txt_ninth_offering);
        FieldsUtils.justifyText(txtNinthOffering);
    }

    @Override
    protected void updateNinthView() {
    }

    @Override
    public void backAction() {
        FieldsUtils.toastMakeTest(getApplicationContext(), getResources().getText(R.string.title_ninth));
        RedirectionUtils.redirectToAnotherActivity(this, NinthHomeActivity.class);
    }

    @Override
    public void nextAction() {
        PrayerScreen.goNext(this, buildBaseBundle());
    }

}
