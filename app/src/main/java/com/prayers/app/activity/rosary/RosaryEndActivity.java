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
import com.prayers.app.utils.FieldsUtils;
import com.prayers.app.utils.RedirectionUtils;

public class RosaryEndActivity extends AbstractClosableActivity {

    private Mysteries selectedMysteries;

    private ImageView imgMysteriesBackground;

    private TextView txtSignCross;

    private Button btnPrev;
    private Button btnEnd;

    @Override
    public int getActivity() {
        return R.layout.rosary_end_activity;
    }

    @Override
    public void prepareOthersActivity() {
        imgMysteriesBackground = (ImageView) findViewById(R.id.rosary_mysteries_background);

        txtSignCross = (TextView) findViewById(R.id.txt_sign_cross);
        FieldsUtils.justifyText(txtSignCross);

        btnPrev = (Button) findViewById(R.id.btn_prev);
        btnPrev.setOnClickListener(v -> backAction());

        btnEnd = (Button) findViewById(R.id.btn_end);
        btnEnd.setOnClickListener(v -> nextAction());
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
        bundle.putInt(RedirectionConstants.SELECTED_MYSTERY, GeneralConstants.MAX_MYSTERIES);

        RedirectionUtils.redirectToAnotherActivityWithExtras(this, bundle, RosaryHailHolyQueenActivity.class);
    }

    @Override
    public void nextAction() {
        redirectToHome();
    }

}
