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

public class NinthInitialPrayerActivity extends AbstractClosableActivity {

    private NinthDay selectedDay;

    private TextView txtInitialPrayer1;
    private TextView txtInitialPrayer2;

    private Button btnPrev;
    private Button btnNext;

    @Override
    public int getActivity() {
        return R.layout.ninth_initial_prayer_activity;
    }

    @Override
    public void prepareOthersActivity() {
        txtInitialPrayer1 = (TextView) findViewById(R.id.txt_ninth_initial_prayer_1);
        FieldsUtils.justifyText(txtInitialPrayer1);

        txtInitialPrayer2 = (TextView) findViewById(R.id.txt_ninth_initial_prayer_2);
        FieldsUtils.justifyText(txtInitialPrayer2);

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
        Bundle bundle = new Bundle();
        bundle.putSerializable(RedirectionConstants.SELECTED_NINTH_DAY, selectedDay);

        RedirectionUtils.redirectToAnotherActivityWithExtras(this, bundle, NinthBeginActivity.class);
    }

    @Override
    public void nextAction() {
        Bundle bundle = new Bundle();
        bundle.putSerializable(RedirectionConstants.SELECTED_NINTH_DAY, selectedDay);
        bundle.putSerializable(RedirectionConstants.GLORY_BE_FROM_END, Boolean.FALSE);

        RedirectionUtils.redirectToAnotherActivityWithExtras(this, bundle, NinthGloryBeActivity.class);
    }

}
