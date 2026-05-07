package com.prayers.app.activity.ninth;

import android.os.Bundle;
import android.util.Log;

import com.prayers.app.activity.AbstractClosableActivity;
import com.prayers.app.constants.RedirectionConstants;
import com.prayers.app.model.ninth.NinthDay;

public abstract class AbstractNinthActivity extends AbstractClosableActivity {

    protected NinthDay selectedDay;

    protected abstract void updateNinthView();

    @Override
    public final void updateViewState() {
        try {
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                selectedDay = (NinthDay) extras.getSerializable(RedirectionConstants.SELECTED_NINTH_DAY);
            }
            updateNinthView();
        } catch (Exception ex) {
            Log.w(TAG_PRAYERS, getClass().getSimpleName() + ".updateViewState failed", ex);
        }
    }

    protected final Bundle buildBaseBundle() {
        Bundle bundle = new Bundle();
        bundle.putSerializable(RedirectionConstants.SELECTED_NINTH_DAY, selectedDay);
        return bundle;
    }
}
