package com.prayers.app.activity.rosary;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.prayers.app.activity.AbstractClosableActivity;
import com.prayers.app.activity.R;
import com.prayers.app.constants.GeneralConstants;
import com.prayers.app.constants.RedirectionConstants;
import com.prayers.app.mapper.RosaryMapper;
import com.prayers.app.model.rosary.Mysteries;
import com.prayers.app.model.rosary.Mystery;
import com.prayers.app.utils.FieldsUtils;
import com.prayers.app.utils.RedirectionUtils;

public class RosaryMysteriesActivity extends AbstractClosableActivity {

    private Mysteries selectedMysteries;

    private TextView txtTitleMysteries;
    private TextView txtTextMysteriesSchedule;
    private ImageView imgMysteriesBackground;

    private TextView txtFirstMystery;
    private TextView txtSecondMystery;
    private TextView txtThirdMystery;
    private TextView txtFourthMystery;
    private TextView txtFifthMystery;

    private Button btnPrev;
    private Button btnPray;

    @Override
    public int getActivity() {
        return R.layout.rosary_mysteries_activity;
    }

    @Override
    public void prepareOthersActivity() {
        txtTitleMysteries = (TextView) findViewById(R.id.title_rosary_mysteries);
        txtTextMysteriesSchedule = (TextView) findViewById(R.id.txt_rosary_mysteries_schedule);
        imgMysteriesBackground = (ImageView) findViewById(R.id.rosary_mysteries_background);

        txtFirstMystery = (TextView) findViewById(R.id.txt_rosary_first_mystery);
        txtSecondMystery = (TextView) findViewById(R.id.txt_rosary_second_mystery);
        txtThirdMystery = (TextView) findViewById(R.id.txt_rosary_third_mystery);
        txtFourthMystery = (TextView) findViewById(R.id.txt_rosary_fourth_mystery);
        txtFifthMystery = (TextView) findViewById(R.id.txt_rosary_fifth_mystery);

        btnPrev = (Button) findViewById(R.id.btn_prev);
        btnPrev.setOnClickListener(v -> backAction());

        btnPray = (Button) findViewById(R.id.btn_pray);
        btnPray.setOnClickListener(v -> nextAction());
    }

    @Override
    public void updateViewState() {
        try {
            selectedMysteries = (Mysteries) getIntent().getExtras().getSerializable(RedirectionConstants.SELECTED_MYSTERIES);

            txtTitleMysteries.setText(selectedMysteries.getName());
            txtTextMysteriesSchedule.setText(selectedMysteries.getSchedule());

            Mystery[] mysteries = selectedMysteries.getMysteries();
            txtFirstMystery.setText(String.format("%s%s", GeneralConstants.FIRST_ITEM, mysteries[GeneralConstants.FIRST_MYSTERY].getName()));
            txtSecondMystery.setText(String.format("%s%s", GeneralConstants.SECOND_ITEM, mysteries[GeneralConstants.SECOND_MYSTERY].getName()));
            txtThirdMystery.setText(String.format("%s%s", GeneralConstants.THIRD_ITEM, mysteries[GeneralConstants.THIRD_MYSTERY].getName()));
            txtFourthMystery.setText(String.format("%s%s", GeneralConstants.FOURTH_ITEM, mysteries[GeneralConstants.FOURTH_MYSTERY].getName()));
            txtFifthMystery.setText(String.format("%s%s", GeneralConstants.FIFTH_ITEM, mysteries[GeneralConstants.FIFTH_MYSTERY].getName()));

            RosaryMapper.changeImageForRosary(this, selectedMysteries, imgMysteriesBackground);
        } catch (Exception ex) {
            // TODO Log exception
        }
    }

    @Override
    public void backAction() {
        FieldsUtils.toastMakeTest(getApplicationContext(), getResources().getText(R.string.title_rosary));
        RedirectionUtils.redirectToAnotherActivity(this, RosaryHomeActivity.class);
    }

    @Override
    public void nextAction() {
        Bundle bundle = new Bundle();
        bundle.putSerializable(RedirectionConstants.SELECTED_MYSTERIES, selectedMysteries);

        RedirectionUtils.redirectToAnotherActivityWithExtras(this, bundle, RosaryBeginActivity.class);
    }

}
