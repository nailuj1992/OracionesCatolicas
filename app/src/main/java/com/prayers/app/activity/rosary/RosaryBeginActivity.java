package com.prayers.app.activity.rosary;

import android.widget.ImageView;
import android.widget.TextView;

import com.prayers.app.activity.R;
import com.prayers.app.mapper.RosaryMapper;
import com.prayers.app.navigation.PrayerScreen;
import com.prayers.app.utils.FieldsUtils;

public class RosaryBeginActivity extends AbstractRosaryActivity {

    private ImageView imgMysteriesBackground;

    private TextView txtSignCross1;
    private TextView txtSignCross2;
    private TextView txtRosaryOffering;

    @Override
    public int getActivity() {
        return R.layout.rosary_begin_activity;
    }

    @Override
    public void prepareViewFields() {
        imgMysteriesBackground = (ImageView) findViewById(R.id.rosary_mysteries_background);

        txtSignCross1 = (TextView) findViewById(R.id.txt_sign_cross_1);
        FieldsUtils.justifyText(txtSignCross1);

        txtSignCross2 = (TextView) findViewById(R.id.txt_sign_cross_2);
        FieldsUtils.justifyText(txtSignCross2);

        txtRosaryOffering = (TextView) findViewById(R.id.txt_rosary_offering);
        FieldsUtils.justifyText(txtRosaryOffering);
    }

    @Override
    protected void updateRosaryView() {
        RosaryMapper.changeImageForRosary(this, selectedMysteries, imgMysteriesBackground);
    }

    @Override
    public void backAction() {
        PrayerScreen.goPrev(this, buildBaseBundle());
    }

    @Override
    public void nextAction() {
        PrayerScreen.goNext(this, buildBaseBundle());
    }

}
