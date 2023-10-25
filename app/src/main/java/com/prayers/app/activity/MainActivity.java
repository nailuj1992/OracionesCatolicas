package com.prayers.app.activity;

import android.widget.Button;

import com.prayers.app.utils.FieldsUtils;
import com.prayers.app.utils.RedirectionUtils;

public class MainActivity extends AbstractActivity {

    private Button btnSpecialPrayers;
    private Button btnSimplePrayers;
    private Button btnSettings;

    @Override
    public int getActivity() {
        return R.layout.main_activity;
    }

    @Override
    public void prepareActivity() {
        btnSpecialPrayers = (Button) findViewById(R.id.btn_special_prayers);
        btnSpecialPrayers.setOnClickListener(v -> gotoSpecialPrayers());

        btnSimplePrayers = (Button) findViewById(R.id.btn_simple_prayers);
        btnSimplePrayers.setOnClickListener(v -> gotoSimplePrayers());

        btnSettings = (Button) findViewById(R.id.btn_settings);
        btnSettings.setOnClickListener(v -> gotoSettings());
    }

    @Override
    public void updateViewState() {
    }

    @Override
    public void backAction() {
    }

    @Override
    public void nextAction() {
    }

    public void gotoSpecialPrayers() {
        FieldsUtils.toastMakeTest(getApplicationContext(), getResources().getText(R.string.title_special_prayers));
        RedirectionUtils.redirectToAnotherActivity(this, SpecialPrayersActivity.class);
    }

    public void gotoSimplePrayers() {
        FieldsUtils.toastMakeTest(getApplicationContext(), getResources().getText(R.string.title_simple_prayers));
        RedirectionUtils.redirectToAnotherActivity(this, SimplePrayersActivity.class);
    }

    public void gotoSettings() {
        FieldsUtils.toastMakeTest(getApplicationContext(), getResources().getText(R.string.title_settings));
        RedirectionUtils.redirectToAnotherActivity(this, SettingsActivity.class);
    }

}
