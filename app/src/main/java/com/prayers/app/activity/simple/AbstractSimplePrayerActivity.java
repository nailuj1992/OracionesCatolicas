package com.prayers.app.activity.simple;

import com.prayers.app.activity.AbstractClosableActivity;
import com.prayers.app.activity.R;
import com.prayers.app.activity.SimplePrayersActivity;
import com.prayers.app.utils.FieldsUtils;
import com.prayers.app.utils.RedirectionUtils;

/**
 * Base for the standalone Simple prayer screens (Our Father, Hail Mary, etc.).
 * Each prayer is a single screen with no flow — back returns to the prayer menu;
 * there is no next action.
 */
public abstract class AbstractSimplePrayerActivity extends AbstractClosableActivity {

    @Override
    public void prepareViewFields() {
    }

    @Override
    public void updateViewState() {
    }

    @Override
    public final void backAction() {
        FieldsUtils.toastMakeTest(getApplicationContext(), getResources().getText(R.string.title_simple_prayers));
        RedirectionUtils.redirectToAnotherActivity(this, SimplePrayersActivity.class);
    }

    @Override
    public final void nextAction() {
    }
}
