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
import com.prayers.app.utils.FieldsUtils;
import com.prayers.app.utils.RedirectionUtils;

public class RosaryBeginActivity extends AbstractClosableActivity {

    private Mysteries selectedMysteries;

    private ImageView imgMysteriesBackground;

    private TextView txtSignCross1;
    private TextView txtSignCross2;
    private TextView txtRosaryOffering;

    private Button btnPrev;
    private Button btnNext;

    @Override
    public int getActivity() {
        return R.layout.rosary_begin_activity;
    }

    @Override
    public void prepareOthersActivity() {
        imgMysteriesBackground = (ImageView) findViewById(R.id.rosary_mysteries_background);

        txtSignCross1 = (TextView) findViewById(R.id.txt_sign_cross_1);
        FieldsUtils.justifyText(txtSignCross1);

        txtSignCross2 = (TextView) findViewById(R.id.txt_sign_cross_2);
        FieldsUtils.justifyText(txtSignCross2);

        txtRosaryOffering = (TextView) findViewById(R.id.txt_rosary_offering);
        FieldsUtils.justifyText(txtRosaryOffering);

        btnPrev = (Button) findViewById(R.id.btn_prev);
        btnPrev.setOnClickListener(v -> backAction());

        btnNext = (Button) findViewById(R.id.btn_next);
        btnNext.setOnClickListener(v -> nextAction());
    }

    @Override
    public void updateViewState() {
        try {
            selectedMysteries = (Mysteries) getIntent().getExtras().getSerializable(RedirectionConstants.SELECTED_MYSTERIES);

            RosaryMapper.changeImageForRosary(this, selectedMysteries, imgMysteriesBackground);
        } catch (Exception ex) {
            // TODO Log exception
        }
    }

    @Override
    public void backAction() {
        Bundle bundle = new Bundle();
        bundle.putSerializable(RedirectionConstants.SELECTED_MYSTERIES, selectedMysteries);

        RedirectionUtils.redirectToAnotherActivityWithExtras(this, bundle, RosaryMysteriesActivity.class);
    }

    @Override
    public void nextAction() {
        Bundle bundle = new Bundle();
        bundle.putSerializable(RedirectionConstants.SELECTED_MYSTERIES, selectedMysteries);

        RedirectionUtils.redirectToAnotherActivityWithExtras(this, bundle, RosaryApostlesCreedActivity.class);
    }

}
