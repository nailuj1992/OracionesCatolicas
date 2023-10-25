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

public class RosaryApostlesCreedActivity extends AbstractClosableActivity {

    private Mysteries selectedMysteries;

    private ImageView imgMysteriesBackground;

    private TextView txtApostlesCreed1;
    private TextView txtApostlesCreed2;

    private Button btnPrev;
    private Button btnNext;

    @Override
    public int getActivity() {
        return R.layout.rosary_apostles_creed_activity;
    }

    @Override
    public void prepareOthersActivity() {
        imgMysteriesBackground = (ImageView) findViewById(R.id.rosary_mysteries_background);

        txtApostlesCreed1 = (TextView) findViewById(R.id.txt_apostles_creed_1);
        FieldsUtils.justifyText(txtApostlesCreed1);

        txtApostlesCreed2 = (TextView) findViewById(R.id.txt_apostles_creed_2);
        FieldsUtils.justifyText(txtApostlesCreed2);

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

        RedirectionUtils.redirectToAnotherActivityWithExtras(this, bundle, RosaryBeginActivity.class);
    }

    @Override
    public void nextAction() {
        Bundle bundle = new Bundle();
        bundle.putSerializable(RedirectionConstants.SELECTED_MYSTERIES, selectedMysteries);
        bundle.putInt(RedirectionConstants.SELECTED_MYSTERY, GeneralConstants.FIRST_MYSTERY);

        RedirectionUtils.redirectToAnotherActivityWithExtras(this, bundle, RosaryCurrentMysteryActivity.class);
    }

}
