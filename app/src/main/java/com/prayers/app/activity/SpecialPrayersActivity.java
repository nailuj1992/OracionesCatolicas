package com.prayers.app.activity;

import android.widget.Button;

import com.prayers.app.activity.ninth.NinthHomeActivity;
import com.prayers.app.activity.rosary.RosaryHomeActivity;
import com.prayers.app.utils.FieldsUtils;
import com.prayers.app.utils.RedirectionUtils;

public class SpecialPrayersActivity extends AbstractActivity {

    private Button btnRosary;
    private Button btnNinth;
    private Button btnPrev;

    @Override
    public int getActivity() {
        return R.layout.special_prayers_activity;
    }

    @Override
    public void prepareActivity() {
        btnRosary = (Button) findViewById(R.id.btn_rosary);
        btnRosary.setOnClickListener(v -> gotoRosary());

        btnNinth = (Button) findViewById(R.id.btn_ninth);
        btnNinth.setOnClickListener(v -> gotoNinth());

        btnPrev = (Button) findViewById(R.id.btn_prev);
        btnPrev.setOnClickListener(v -> backAction());
    }

    @Override
    public void updateViewState() {
    }

    @Override
    public void backAction() {
        FieldsUtils.toastMakeTest(getApplicationContext(), getResources().getText(R.string.title_home));
        RedirectionUtils.redirectToAnotherActivity(this, MainActivity.class);
    }

    @Override
    public void nextAction() {
    }

    public void gotoRosary() {
        FieldsUtils.toastMakeTest(getApplicationContext(), getResources().getText(R.string.title_rosary));
        RedirectionUtils.redirectToAnotherActivity(this, RosaryHomeActivity.class);
    }

    public void gotoNinth() {
        FieldsUtils.toastMakeTest(getApplicationContext(), getResources().getText(R.string.title_ninth));
        RedirectionUtils.redirectToAnotherActivity(this, NinthHomeActivity.class);
    }

}
