package com.prayers.app.activity.rosary;

import android.os.Bundle;
import android.util.Log;

import com.prayers.app.activity.AbstractClosableActivity;
import com.prayers.app.constants.RedirectionConstants;
import com.prayers.app.model.rosary.Mysteries;
import com.prayers.app.model.rosary.Mystery;

public abstract class AbstractRosaryActivity extends AbstractClosableActivity {

    protected Mysteries selectedMysteries;
    protected int selectedMystery;
    protected Mystery mystery;

    protected abstract void updateRosaryView();

    @Override
    public final void updateViewState() {
        try {
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                selectedMysteries = (Mysteries) extras.getSerializable(RedirectionConstants.SELECTED_MYSTERIES);
                selectedMystery = extras.getInt(RedirectionConstants.SELECTED_MYSTERY);
                if (selectedMysteries != null
                        && selectedMystery >= 0
                        && selectedMystery < selectedMysteries.getMysteries().length) {
                    mystery = selectedMysteries.getMysteries()[selectedMystery];
                } else {
                    mystery = null;
                }
            }
            updateRosaryView();
        } catch (Exception ex) {
            Log.w(TAG_PRAYERS, getClass().getSimpleName() + ".updateViewState failed", ex);
        }
    }

    protected final Bundle buildBaseBundle() {
        Bundle bundle = new Bundle();
        bundle.putSerializable(RedirectionConstants.SELECTED_MYSTERIES, selectedMysteries);
        bundle.putInt(RedirectionConstants.SELECTED_MYSTERY, selectedMystery);
        return bundle;
    }
}
