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

public class NinthVirginMaryPrayerActivity extends AbstractClosableActivity {

    private NinthDay selectedDay;

    private TextView txtPrayer1;
    private TextView txtPrayer2;

    private Button btnPrev;
    private Button btnNext;

    @Override
    public int getActivity() {
        return R.layout.ninth_virgin_mary_prayer_activity;
    }

    @Override
    public void prepareOthersActivity() {
        txtPrayer1 = (TextView) findViewById(R.id.txt_ninth_mary_prayer_1);
        FieldsUtils.justifyText(txtPrayer1);

        txtPrayer2 = (TextView) findViewById(R.id.txt_ninth_mary_prayer_2);
        FieldsUtils.justifyText(txtPrayer2);

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

        RedirectionUtils.redirectToAnotherActivityWithExtras(this, bundle, NinthParagraphActivity.class);
    }

    @Override
    public void nextAction() {
        Bundle bundle = new Bundle();
        bundle.putSerializable(RedirectionConstants.SELECTED_NINTH_DAY, selectedDay);
        bundle.putSerializable(RedirectionConstants.HAIL_MARY_FROM_END, Boolean.FALSE);

        RedirectionUtils.redirectToAnotherActivityWithExtras(this, bundle, NinthHailMaryActivity.class);
    }

}
