package com.prayers.app.activity.rosary;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.prayers.app.activity.R;
import com.prayers.app.constants.RedirectionConstants;
import com.prayers.app.mapper.RosaryMapper;
import com.prayers.app.navigation.PrayerScreen;

import static com.prayers.app.enums.ETypeHailMary.ROSARY_LONG;
import static com.prayers.app.enums.ETypeHailMary.ROSARY_SHORT;

public class RosaryOurFatherActivity extends AbstractRosaryActivity {

    private TextView txtTextCurrentMystery;
    private ImageView imgMysteriesBackground;
    private ImageView imgCurrentOurFather;

    @Override
    public int getActivity() {
        return R.layout.rosary_our_father_activity;
    }

    @Override
    public void prepareViewFields() {
        txtTextCurrentMystery = (TextView) findViewById(R.id.txt_rosary_current_mystery);
        imgCurrentOurFather = (ImageView) findViewById(R.id.rosary_current_our_father);
        imgMysteriesBackground = (ImageView) findViewById(R.id.rosary_mysteries_background);
    }

    @Override
    protected void updateRosaryView() {
        if (mystery != null) {
            txtTextCurrentMystery.setText(RosaryMapper.getCurrentMysteryLocation(this, selectedMysteries.getValue(), mystery));
        } else {
            txtTextCurrentMystery.setText(getString(R.string.txt_rosary_last_part));
        }

        imgCurrentOurFather.setImageResource(RosaryMapper.getCurrentMysteryOurFatherImg(mystery));
        RosaryMapper.changeImageForRosary(this, selectedMysteries, imgMysteriesBackground);
    }

    @Override
    public void backAction() {
        PrayerScreen.goPrev(this, buildBaseBundle());
    }

    @Override
    public void nextAction() {
        Bundle bundle = buildBaseBundle();
        bundle.putSerializable(RedirectionConstants.HAIL_MARY_TYPE, mystery != null ? ROSARY_LONG : ROSARY_SHORT);
        bundle.putBoolean(RedirectionConstants.HAIL_MARY_FROM_END, Boolean.FALSE);
        PrayerScreen.goNext(this, bundle);
    }

}
