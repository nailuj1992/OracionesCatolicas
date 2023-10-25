package com.prayers.app.activity.ninth;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.prayers.app.activity.AbstractClosableActivity;
import com.prayers.app.activity.R;
import com.prayers.app.constants.RedirectionConstants;
import com.prayers.app.exception.PrayersException;
import com.prayers.app.model.GloryBe;
import com.prayers.app.model.ninth.NinthDay;
import com.prayers.app.utils.RedirectionUtils;

public class NinthGloryBeActivity extends AbstractClosableActivity {

    private NinthDay selectedDay;
    private GloryBe gloryBe;

    private TextView txtTextProgress;

    private Button btnPrev;
    private Button btnNext;

    @Override
    public int getActivity() {
        return R.layout.ninth_glory_be_activity;
    }

    @Override
    public void prepareOthersActivity() {
        txtTextProgress = (TextView) findViewById(R.id.txt_glory_be_progress);

        btnPrev = (Button) findViewById(R.id.btn_prev);
        btnPrev.setOnClickListener(v -> backAction());

        btnNext = (Button) findViewById(R.id.btn_next);
        btnNext.setOnClickListener(v -> nextAction());
    }

    @Override
    public void updateViewState() {
        try {
            selectedDay = (NinthDay) getIntent().getExtras().getSerializable(RedirectionConstants.SELECTED_NINTH_DAY);

            boolean currentGloryBe = (boolean) getIntent().getExtras().getBoolean(RedirectionConstants.GLORY_BE_FROM_END);
            if (gloryBe == null) {
                gloryBe = new GloryBe(currentGloryBe);
            }

            updateGloryBeState();
        } catch (Exception ex) {
            // TODO Log exception
        }
    }

    private void updateGloryBeState() {
        txtTextProgress.setText(String.format(getString(R.string.txt_progress), String.valueOf(gloryBe.getCurrent()), String.valueOf(gloryBe.getTotal())));
    }

    @Override
    public void backAction() {
        try {
            gloryBe.decreaseValue();
            updateGloryBeState();
        } catch (PrayersException e) {
            Bundle bundle = new Bundle();
            bundle.putSerializable(RedirectionConstants.SELECTED_NINTH_DAY, selectedDay);

            RedirectionUtils.redirectToAnotherActivityWithExtras(this, bundle, NinthInitialPrayerActivity.class);
        }
    }

    @Override
    public void nextAction() {
        try {
            gloryBe.increaseValue();
            updateGloryBeState();
        } catch (PrayersException e) {
            Bundle bundle = new Bundle();
            bundle.putSerializable(RedirectionConstants.SELECTED_NINTH_DAY, selectedDay);

            RedirectionUtils.redirectToAnotherActivityWithExtras(this, bundle, NinthConsiderationActivity.class);
        }
    }

}
