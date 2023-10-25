package com.prayers.app.activity.ninth;

import android.os.Bundle;
import android.widget.Button;

import com.prayers.app.activity.AbstractClosableActivity;
import com.prayers.app.activity.R;
import com.prayers.app.constants.RedirectionConstants;
import com.prayers.app.model.ninth.NinthDay;
import com.prayers.app.utils.RedirectionUtils;

public class NinthOurFatherActivity extends AbstractClosableActivity {

    private NinthDay selectedDay;

    private Button btnPrev;
    private Button btnNext;

    @Override
    public int getActivity() {
        return R.layout.ninth_our_father_activity;
    }

    @Override
    public void prepareOthersActivity() {
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

        RedirectionUtils.redirectToAnotherActivityWithExtras(this, bundle, NinthSaintJosephPrayerActivity.class);
    }

    @Override
    public void nextAction() {
        Bundle bundle = new Bundle();
        bundle.putSerializable(RedirectionConstants.SELECTED_NINTH_DAY, selectedDay);
        bundle.putSerializable(RedirectionConstants.JOYS_FROM_END, Boolean.FALSE);

        RedirectionUtils.redirectToAnotherActivityWithExtras(this, bundle, NinthJoysActivity.class);
    }

}
