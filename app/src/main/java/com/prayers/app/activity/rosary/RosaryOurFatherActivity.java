package com.prayers.app.activity.rosary;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.prayers.app.activity.AbstractClosableActivity;
import com.prayers.app.activity.R;
import com.prayers.app.constants.RedirectionConstants;
import com.prayers.app.mapper.RosaryMapper;
import com.prayers.app.model.rosary.Mysteries;
import com.prayers.app.model.rosary.Mystery;
import com.prayers.app.utils.RedirectionUtils;

import static com.prayers.app.enums.ETypeHailMary.ROSARY_LONG;
import static com.prayers.app.enums.ETypeHailMary.ROSARY_SHORT;

public class RosaryOurFatherActivity extends AbstractClosableActivity {

    private Mysteries selectedMysteries;
    private int selectedMystery;
    private Mystery mystery;

    private TextView txtTextCurrentMystery;
    private ImageView imgMysteriesBackground;

    private ImageView imgCurrentOurFather;

    private Button btnPrev;
    private Button btnNext;

    @Override
    public int getActivity() {
        return R.layout.rosary_our_father_activity;
    }

    @Override
    public void prepareOthersActivity() {
        txtTextCurrentMystery = (TextView) findViewById(R.id.txt_rosary_current_mystery);
        imgCurrentOurFather = (ImageView) findViewById(R.id.rosary_current_our_father);
        imgMysteriesBackground = (ImageView) findViewById(R.id.rosary_mysteries_background);

        btnPrev = (Button) findViewById(R.id.btn_prev);
        btnPrev.setOnClickListener(v -> backAction());

        btnNext = (Button) findViewById(R.id.btn_next);
        btnNext.setOnClickListener(v -> nextAction());
    }

    @Override
    public void updateViewState() {
        try {
            selectedMysteries = (Mysteries) getIntent().getExtras().getSerializable(RedirectionConstants.SELECTED_MYSTERIES);
            selectedMystery = (int) getIntent().getExtras().getInt(RedirectionConstants.SELECTED_MYSTERY);
            if (selectedMystery < selectedMysteries.getMysteries().length && selectedMystery >= 0) {
                mystery = selectedMysteries.getMysteries()[selectedMystery];
            } else {
                mystery = null;
            }

            if (mystery != null) {
                txtTextCurrentMystery.setText(RosaryMapper.getCurrentMysteryLocation(this, selectedMysteries.getValue(), mystery));
            } else {
                txtTextCurrentMystery.setText(getString(R.string.txt_rosary_last_part));
            }

            imgCurrentOurFather.setImageResource(RosaryMapper.getCurrentMysteryOurFatherImg(mystery));
            RosaryMapper.changeImageForRosary(this, selectedMysteries, imgMysteriesBackground);
        } catch (Exception ex) {
            // TODO Log exception
        }
    }

    @Override
    public void backAction() {
        Bundle bundle = new Bundle();
        bundle.putSerializable(RedirectionConstants.SELECTED_MYSTERIES, selectedMysteries);
        bundle.putInt(RedirectionConstants.SELECTED_MYSTERY, selectedMystery);

        RedirectionUtils.redirectToAnotherActivityWithExtras(this, bundle, RosaryCurrentMysteryActivity.class);
    }

    @Override
    public void nextAction() {
        Bundle bundle = new Bundle();
        bundle.putSerializable(RedirectionConstants.SELECTED_MYSTERIES, selectedMysteries);
        bundle.putInt(RedirectionConstants.SELECTED_MYSTERY, selectedMystery);
        bundle.putSerializable(RedirectionConstants.HAIL_MARY_TYPE, mystery != null ? ROSARY_LONG : ROSARY_SHORT);
        bundle.putBoolean(RedirectionConstants.HAIL_MARY_FROM_END, Boolean.FALSE);

        RedirectionUtils.redirectToAnotherActivityWithExtras(this, bundle, RosaryHailMaryActivity.class);
    }

}
