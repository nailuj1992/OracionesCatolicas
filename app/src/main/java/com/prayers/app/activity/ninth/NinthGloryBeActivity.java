package com.prayers.app.activity.ninth;

import android.widget.TextView;

import com.prayers.app.activity.R;
import com.prayers.app.constants.RedirectionConstants;
import com.prayers.app.exception.PrayersException;
import com.prayers.app.model.GloryBe;
import com.prayers.app.navigation.PrayerScreen;

public class NinthGloryBeActivity extends AbstractNinthActivity {

    private GloryBe gloryBe;

    private TextView txtTextProgress;

    @Override
    public int getActivity() {
        return R.layout.ninth_glory_be_activity;
    }

    @Override
    public void prepareViewFields() {
        txtTextProgress = (TextView) findViewById(R.id.txt_glory_be_progress);
    }

    @Override
    protected void updateNinthView() {
        boolean currentGloryBe = false;
        if (getIntent().getExtras() != null) {
            currentGloryBe = getIntent().getExtras().getBoolean(RedirectionConstants.GLORY_BE_FROM_END);
        }
        if (gloryBe == null) {
            gloryBe = new GloryBe(currentGloryBe);
        }
        updateGloryBeState();
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
            PrayerScreen.goPrev(this, buildBaseBundle());
        }
    }

    @Override
    public void nextAction() {
        try {
            gloryBe.increaseValue();
            updateGloryBeState();
        } catch (PrayersException e) {
            PrayerScreen.goNext(this, buildBaseBundle());
        }
    }

}
