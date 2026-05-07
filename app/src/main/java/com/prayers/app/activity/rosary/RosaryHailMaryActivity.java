package com.prayers.app.activity.rosary;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.prayers.app.activity.R;
import com.prayers.app.constants.GeneralConstants;
import com.prayers.app.constants.RedirectionConstants;
import com.prayers.app.enums.ETypeHailMary;
import com.prayers.app.exception.PrayersException;
import com.prayers.app.mapper.RosaryMapper;
import com.prayers.app.model.HailMary;
import com.prayers.app.navigation.PrayerScreen;
import com.prayers.app.utils.RedirectionUtils;

public class RosaryHailMaryActivity extends AbstractRosaryActivity {

    private HailMary hailMary;

    private TextView txtTextCurrentMystery;
    private ImageView imgMysteriesBackground;

    private TextView txtTextExtra;
    private ImageView imgCurrentHailMary;

    @Override
    public int getActivity() {
        return R.layout.rosary_hail_mary_activity;
    }

    @Override
    public void prepareViewFields() {
        txtTextCurrentMystery = (TextView) findViewById(R.id.txt_rosary_current_mystery);
        txtTextExtra = (TextView) findViewById(R.id.txt_hail_mary_extra);
        imgCurrentHailMary = (ImageView) findViewById(R.id.rosary_current_hail_mary);
        imgMysteriesBackground = (ImageView) findViewById(R.id.rosary_mysteries_background);
    }

    @Override
    protected void updateRosaryView() {
        Bundle extras = getIntent().getExtras();
        if (extras == null) return;

        ETypeHailMary typeHailMary = (ETypeHailMary) extras.getSerializable(RedirectionConstants.HAIL_MARY_TYPE);
        boolean currentHailMary = extras.getBoolean(RedirectionConstants.HAIL_MARY_FROM_END);
        if (hailMary == null) {
            hailMary = new HailMary(currentHailMary, typeHailMary);
        }

        if (mystery != null) {
            txtTextCurrentMystery.setText(RosaryMapper.getCurrentMysteryLocation(this, selectedMysteries.getValue(), mystery));
        } else {
            txtTextCurrentMystery.setText(getString(R.string.txt_rosary_last_part));
        }

        updateHailMaryState();
        RosaryMapper.changeImageForRosary(this, selectedMysteries, imgMysteriesBackground);
    }

    private void updateHailMaryState() {
        if (hailMary.getType() == ETypeHailMary.ROSARY_SHORT) {
            switch (hailMary.getCurrent()) {
                case GeneralConstants.MIN_HAIL_MARY:
                    txtTextExtra.setText(getString(R.string.txt_rosary_last_part_1));
                    break;
                case GeneralConstants.HAIL_MARY_2:
                    txtTextExtra.setText(getString(R.string.txt_rosary_last_part_2));
                    break;
                case GeneralConstants.HAIL_MARY_3:
                    txtTextExtra.setText(getString(R.string.txt_rosary_last_part_3));
                    break;
            }
            txtTextExtra.setVisibility(View.VISIBLE);
        } else {
            txtTextExtra.setText(R.string.txt_blank);
            txtTextExtra.setVisibility(View.INVISIBLE);
            txtTextExtra.setHeight(0);
        }

        imgCurrentHailMary.setImageResource(RosaryMapper.getCurrentMysteryHailMaryImg(mystery, hailMary));
    }

    @Override
    public void backAction() {
        try {
            hailMary.decreaseValue();
            updateHailMaryState();
        } catch (PrayersException e) {
            PrayerScreen.goPrev(this, buildBaseBundle());
        }
    }

    @Override
    public void nextAction() {
        try {
            hailMary.increaseValue();
            updateHailMaryState();
        } catch (PrayersException e) {
            Class<? extends Activity> target = hailMary.getType() == ETypeHailMary.ROSARY_SHORT
                    ? RosaryHailHolyQueenActivity.class
                    : RosaryGloryBeActivity.class;
            RedirectionUtils.redirectToAnotherActivityWithExtras(this, buildBaseBundle(), target);
        }
    }

}
