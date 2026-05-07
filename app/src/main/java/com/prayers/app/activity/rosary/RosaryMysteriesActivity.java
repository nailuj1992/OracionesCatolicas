package com.prayers.app.activity.rosary;

import android.widget.ImageView;
import android.widget.TextView;

import com.prayers.app.activity.R;
import com.prayers.app.constants.GeneralConstants;
import com.prayers.app.mapper.RosaryMapper;
import com.prayers.app.model.rosary.Mystery;
import com.prayers.app.navigation.PrayerScreen;
import com.prayers.app.utils.FieldsUtils;
import com.prayers.app.utils.RedirectionUtils;

public class RosaryMysteriesActivity extends AbstractRosaryActivity {

    private TextView txtTitleMysteries;
    private TextView txtTextMysteriesSchedule;
    private ImageView imgMysteriesBackground;

    private TextView txtFirstMystery;
    private TextView txtSecondMystery;
    private TextView txtThirdMystery;
    private TextView txtFourthMystery;
    private TextView txtFifthMystery;

    @Override
    public int getActivity() {
        return R.layout.rosary_mysteries_activity;
    }

    @Override
    public void prepareViewFields() {
        txtTitleMysteries = (TextView) findViewById(R.id.title_rosary_mysteries);
        txtTextMysteriesSchedule = (TextView) findViewById(R.id.txt_rosary_mysteries_schedule);
        imgMysteriesBackground = (ImageView) findViewById(R.id.rosary_mysteries_background);

        txtFirstMystery = (TextView) findViewById(R.id.txt_rosary_first_mystery);
        txtSecondMystery = (TextView) findViewById(R.id.txt_rosary_second_mystery);
        txtThirdMystery = (TextView) findViewById(R.id.txt_rosary_third_mystery);
        txtFourthMystery = (TextView) findViewById(R.id.txt_rosary_fourth_mystery);
        txtFifthMystery = (TextView) findViewById(R.id.txt_rosary_fifth_mystery);
    }

    @Override
    protected void updateRosaryView() {
        if (selectedMysteries == null) return;

        txtTitleMysteries.setText(selectedMysteries.getName());
        txtTextMysteriesSchedule.setText(selectedMysteries.getSchedule());

        Mystery[] all = selectedMysteries.getMysteries();
        txtFirstMystery.setText(String.format("%s%s", GeneralConstants.FIRST_ITEM, all[GeneralConstants.FIRST_MYSTERY].getName()));
        txtSecondMystery.setText(String.format("%s%s", GeneralConstants.SECOND_ITEM, all[GeneralConstants.SECOND_MYSTERY].getName()));
        txtThirdMystery.setText(String.format("%s%s", GeneralConstants.THIRD_ITEM, all[GeneralConstants.THIRD_MYSTERY].getName()));
        txtFourthMystery.setText(String.format("%s%s", GeneralConstants.FOURTH_ITEM, all[GeneralConstants.FOURTH_MYSTERY].getName()));
        txtFifthMystery.setText(String.format("%s%s", GeneralConstants.FIFTH_ITEM, all[GeneralConstants.FIFTH_MYSTERY].getName()));

        RosaryMapper.changeImageForRosary(this, selectedMysteries, imgMysteriesBackground);
    }

    @Override
    public void backAction() {
        FieldsUtils.toastMakeTest(getApplicationContext(), getResources().getText(R.string.title_rosary));
        RedirectionUtils.redirectToAnotherActivity(this, RosaryHomeActivity.class);
    }

    @Override
    public void nextAction() {
        PrayerScreen.goNext(this, buildBaseBundle());
    }

}
