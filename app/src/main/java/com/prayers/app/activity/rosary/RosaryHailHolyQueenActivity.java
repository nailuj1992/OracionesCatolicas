package com.prayers.app.activity.rosary;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.prayers.app.activity.R;
import com.prayers.app.constants.RedirectionConstants;
import com.prayers.app.mapper.RosaryMapper;
import com.prayers.app.navigation.PrayerScreen;

import static com.prayers.app.enums.ETypeHailMary.ROSARY_SHORT;

public class RosaryHailHolyQueenActivity extends AbstractRosaryActivity {

    private TextView txtTextCurrentMystery;
    private ImageView imgMysteriesBackground;
    private ImageView imgCurrentHailHolyQueen;

    @Override
    public int getActivity() {
        return R.layout.rosary_hail_holy_queen_activity;
    }

    @Override
    public void prepareViewFields() {
        txtTextCurrentMystery = (TextView) findViewById(R.id.txt_rosary_current_mystery);
        imgCurrentHailHolyQueen = (ImageView) findViewById(R.id.rosary_current_hail_holy_queen);
        imgMysteriesBackground = (ImageView) findViewById(R.id.rosary_mysteries_background);
    }

    @Override
    protected void updateRosaryView() {
        if (mystery != null) {
            txtTextCurrentMystery.setText(RosaryMapper.getCurrentMysteryLocation(this, selectedMysteries.getValue(), mystery));
        } else {
            txtTextCurrentMystery.setText(getString(R.string.txt_rosary_last_part));
        }

        imgCurrentHailHolyQueen.setImageResource(RosaryMapper.getCurrentMysteryGloryBeImg(mystery));
        RosaryMapper.changeImageForRosary(this, selectedMysteries, imgMysteriesBackground);
    }

    @Override
    public void backAction() {
        Bundle bundle = buildBaseBundle();
        bundle.putSerializable(RedirectionConstants.HAIL_MARY_TYPE, ROSARY_SHORT);
        bundle.putBoolean(RedirectionConstants.HAIL_MARY_FROM_END, Boolean.TRUE);
        PrayerScreen.goPrev(this, bundle);
    }

    @Override
    public void nextAction() {
        PrayerScreen.goNext(this, buildBaseBundle());
    }

}
