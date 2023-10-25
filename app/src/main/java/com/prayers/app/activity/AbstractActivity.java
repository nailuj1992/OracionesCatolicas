package com.prayers.app.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.PreferenceManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.prayers.app.constants.GeneralConstants;
import com.prayers.app.helper.LocaleHelper;

/**
 * Created by Avuuna on 30/05/2020.
 */
public abstract class AbstractActivity extends AppCompatActivity implements SharedPreferences.OnSharedPreferenceChangeListener {

    protected String initialLocale;

    /**
     * Get the view layout id bound to this activity object.
     *
     * @return
     */
    public abstract int getActivity();

    /**
     * Prepare all view fields.
     */
    public abstract void prepareActivity();

    /**
     * Update all fields on the view.
     */
    public abstract void updateViewState();

    /**
     * Does the back action.
     */
    public abstract void backAction();

    /**
     * Does the next action.
     */
    public abstract void nextAction();

    @Override
    protected final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialLocale = LocaleHelper.getPersistedLocale(this);
        overridePendingTransition(R.anim.enter_activity, R.anim.exit_activity);

        setContentView(getActivity());
        prepareActivity();
        updateViewState();
    }

    @Override
    public final void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        setContentView(getActivity());
        prepareActivity();
        updateViewState();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(LocaleHelper.onAttach(base));
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (initialLocale != null && !initialLocale.equals(LocaleHelper.getPersistedLocale(this))) {
            recreate();
        }
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, @Nullable String key) {
        switch (key) {
            case GeneralConstants.KEY_PREF_LANGUAGE:
                LocaleHelper.setLocale(getApplicationContext(), PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).getString(key, ""));
                recreate(); // necessary here because this Activity is currently running and thus a recreate() in onResume() would be too late
                break;
        }
    }

    @Override
    public final void onBackPressed() {
        backAction();
    }

}
