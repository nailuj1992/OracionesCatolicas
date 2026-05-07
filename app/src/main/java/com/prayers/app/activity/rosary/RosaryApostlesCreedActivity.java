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

public class RosaryApostlesCreedActivity extends AbstractRosaryActivity {

    private ImageView imgMysteriesBackground;

    private TextView txtApostlesCreed1;
    private TextView txtApostlesCreed2;

    @Override
    public int getActivity() {
        return R.layout.rosary_apostles_creed_activity;
    }

    @Override
    public void prepareViewFields() {
        imgMysteriesBackground = (ImageView) findViewById(R.id.rosary_mysteries_background);

        txtApostlesCreed1 = (TextView) findViewById(R.id.txt_apostles_creed_1);
        FieldsUtils.justifyText(txtApostlesCreed1);

        txtApostlesCreed2 = (TextView) findViewById(R.id.txt_apostles_creed_2);
        FieldsUtils.justifyText(txtApostlesCreed2);
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
        Bundle bundle = buildBaseBundle();
        bundle.putInt(RedirectionConstants.SELECTED_MYSTERY, GeneralConstants.FIRST_MYSTERY);
        PrayerScreen.goNext(this, bundle);
    }

}
