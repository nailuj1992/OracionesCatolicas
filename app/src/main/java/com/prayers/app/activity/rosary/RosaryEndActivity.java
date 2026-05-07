package com.prayers.app.activity.rosary;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.prayers.app.activity.R;
import com.prayers.app.constants.GeneralConstants;
import com.prayers.app.constants.RedirectionConstants;
import com.prayers.app.mapper.RosaryMapper;
import com.prayers.app.navigation.PrayerScreen;
import com.prayers.app.utils.FieldsUtils;

public class RosaryEndActivity extends AbstractRosaryActivity {

    private ImageView imgMysteriesBackground;

    private TextView txtSignCross;

    @Override
    public int getActivity() {
        return R.layout.rosary_end_activity;
    }

    @Override
    public void prepareViewFields() {
        imgMysteriesBackground = (ImageView) findViewById(R.id.rosary_mysteries_background);

        txtSignCross = (TextView) findViewById(R.id.txt_sign_cross);
        FieldsUtils.justifyText(txtSignCross);
    }

    @Override
    protected void updateRosaryView() {
        RosaryMapper.changeImageForRosary(this, selectedMysteries, imgMysteriesBackground);
    }

    @Override
    public void backAction() {
        Bundle bundle = buildBaseBundle();
        bundle.putInt(RedirectionConstants.SELECTED_MYSTERY, GeneralConstants.MAX_MYSTERIES);
        PrayerScreen.goPrev(this, bundle);
    }

    @Override
    public void nextAction() {
        redirectToHome();
    }

}
