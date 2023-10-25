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

public class NinthBeginActivity extends AbstractClosableActivity {

    private NinthDay selectedDay;

    private TextView txtSignCross1;
    private TextView txtSignCross2;
    private TextView txtNinthOffering;

    private Button btnPrev;
    private Button btnNext;

    @Override
    public int getActivity() {
        return R.layout.ninth_begin_activity;
    }

    @Override
    public void prepareOthersActivity() {
        txtSignCross1 = (TextView) findViewById(R.id.txt_sign_cross_1);
        FieldsUtils.justifyText(txtSignCross1);

        txtSignCross2 = (TextView) findViewById(R.id.txt_sign_cross_2);
        FieldsUtils.justifyText(txtSignCross2);

        txtNinthOffering = (TextView) findViewById(R.id.txt_ninth_offering);
        FieldsUtils.justifyText(txtNinthOffering);

        btnPrev = (Button) findViewById(R.id.btn_prev);
        btnPrev.setOnClickListener(v -> backAction());

        btnNext = (Button) findViewById(R.id.btn_next);
        btnNext.setOnClickListener(v -> nextAction());
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
        FieldsUtils.toastMakeTest(getApplicationContext(), getResources().getText(R.string.title_ninth));
        RedirectionUtils.redirectToAnotherActivity(this, NinthHomeActivity.class);
    }

    @Override
    public void nextAction() {
        Bundle bundle = new Bundle();
        bundle.putSerializable(RedirectionConstants.SELECTED_NINTH_DAY, selectedDay);

        RedirectionUtils.redirectToAnotherActivityWithExtras(this, bundle, NinthInitialPrayerActivity.class);
    }

}
