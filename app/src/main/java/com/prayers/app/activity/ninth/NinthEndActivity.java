package com.prayers.app.activity.ninth;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.prayers.app.activity.AbstractClosableActivity;
import com.prayers.app.activity.R;
import com.prayers.app.constants.RedirectionConstants;
import com.prayers.app.model.ninth.NinthDay;
import com.prayers.app.utils.FieldsUtils;
import com.prayers.app.utils.RedirectionUtils;

public class NinthEndActivity extends AbstractClosableActivity {

    private NinthDay selectedDay;

    private TextView txtSignCross;

    private Button btnPrev;
    private Button btnEnd;

    @Override
    public int getActivity() {
        return R.layout.ninth_end_activity;
    }

    @Override
    public void prepareOthersActivity() {
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
            selectedDay = (NinthDay) getIntent().getExtras().getSerializable(RedirectionConstants.SELECTED_NINTH_DAY);
        } catch (Exception ex) {
            // TODO Log exception
        }
    }

    @Override
    public void backAction() {
        Bundle bundle = new Bundle();
        bundle.putSerializable(RedirectionConstants.SELECTED_NINTH_DAY, selectedDay);

        RedirectionUtils.redirectToAnotherActivityWithExtras(this, bundle, NinthChildJesusPrayerActivity.class);
    }

    @Override
    public void nextAction() {
        redirectToHome();
    }

}
