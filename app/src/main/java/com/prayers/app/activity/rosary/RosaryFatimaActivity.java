package com.prayers.app.activity.rosary;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.prayers.app.activity.R;
import com.prayers.app.constants.RedirectionConstants;
import com.prayers.app.mapper.RosaryMapper;
import com.prayers.app.navigation.PrayerScreen;

public class RosaryFatimaActivity extends AbstractRosaryActivity {

    private TextView txtTextCurrentMystery;
    private ImageView imgMysteriesBackground;

    @Override
    public int getActivity() {
        return R.layout.rosary_fatima_activity;
    }

    @Override
    public void prepareViewFields() {
        txtTextCurrentMystery = (TextView) findViewById(R.id.txt_rosary_current_mystery);
        imgMysteriesBackground = (ImageView) findViewById(R.id.rosary_mysteries_background);
    }

    @Override
    protected void updateRosaryView() {
        if (mystery != null) {
            txtTextCurrentMystery.setText(RosaryMapper.getCurrentMysteryLocation(this, selectedMysteries.getValue(), mystery));
        } else {
            txtTextCurrentMystery.setText(getString(R.string.txt_blank));
        }

        RosaryMapper.changeImageForRosary(this, selectedMysteries, imgMysteriesBackground);
    }

    @Override
    public void backAction() {
        PrayerScreen.goPrev(this, buildBaseBundle());
    }

    @Override
    public void nextAction() {
        Bundle bundle = buildBaseBundle();
        bundle.putInt(RedirectionConstants.SELECTED_MYSTERY, selectedMystery + 1);
        PrayerScreen.goNext(this, bundle);
    }

}
