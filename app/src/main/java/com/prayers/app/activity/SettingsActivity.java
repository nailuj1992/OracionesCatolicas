package com.prayers.app.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.widget.Button;

import androidx.annotation.Nullable;

import com.prayers.app.constants.GeneralConstants;
import com.prayers.app.helper.LocaleHelper;
import com.prayers.app.utils.FieldsUtils;
import com.prayers.app.utils.RedirectionUtils;

public class SettingsActivity extends PreferenceActivity implements SharedPreferences.OnSharedPreferenceChangeListener {

    protected String initialLocale;

    private Button btnPrev;

    public SettingsActivity() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
        initialLocale = LocaleHelper.getPersistedLocale(this);

        prepareActivity();
    }

    @Override
    public final void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        prepareActivity();
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
    public void onResume() {
        super.onResume();
        // documentation requires that a reference to the listener is kept as long as it may be called, which is the case as it can only be called from this Fragment
        getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
        if (initialLocale != null && !initialLocale.equals(LocaleHelper.getPersistedLocale(this))) {
            recreate();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(LocaleHelper.onAttach(base));
    }

    @Override
    public final void onBackPressed() {
        FieldsUtils.toastMakeTest(getApplicationContext(), getResources().getText(R.string.title_home));
        RedirectionUtils.redirectToAnotherActivity(this, MainActivity.class);
    }

    public void prepareActivity() {
        setContentView(R.layout.settings_activity);

        btnPrev = (Button) findViewById(R.id.btn_prev);
        btnPrev.setOnClickListener(v -> onBackPressed());
    }

}
