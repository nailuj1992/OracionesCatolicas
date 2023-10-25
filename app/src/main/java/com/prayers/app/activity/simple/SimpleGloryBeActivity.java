package com.prayers.app.activity.simple;

import android.widget.Button;

import com.prayers.app.activity.AbstractClosableActivity;
import com.prayers.app.activity.R;
import com.prayers.app.activity.SimplePrayersActivity;
import com.prayers.app.utils.FieldsUtils;
import com.prayers.app.utils.RedirectionUtils;

public class SimpleGloryBeActivity extends AbstractClosableActivity {

    private Button btnPrev;

    @Override
    public int getActivity() {
        return R.layout.simple_glory_be_activity;
    }

    @Override
    public void prepareOthersActivity() {
        btnPrev = (Button) findViewById(R.id.btn_prev);
        btnPrev.setOnClickListener(v -> backAction());
    }

    @Override
    public void updateViewState() {
    }

    @Override
    public void backAction() {
        FieldsUtils.toastMakeTest(getApplicationContext(), getResources().getText(R.string.title_simple_prayers));
        RedirectionUtils.redirectToAnotherActivity(this, SimplePrayersActivity.class);
    }

    @Override
    public void nextAction() {
    }

}
