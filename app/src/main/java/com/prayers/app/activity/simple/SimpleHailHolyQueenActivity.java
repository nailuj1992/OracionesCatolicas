package com.prayers.app.activity.simple;

import android.widget.Button;
import android.widget.TextView;

import com.prayers.app.activity.AbstractClosableActivity;
import com.prayers.app.activity.R;
import com.prayers.app.activity.SimplePrayersActivity;
import com.prayers.app.utils.FieldsUtils;
import com.prayers.app.utils.RedirectionUtils;

public class SimpleHailHolyQueenActivity extends AbstractClosableActivity {

    private TextView txtHailHolyQueen1;
    private TextView txtHailHolyQueen2;
    private Button btnPrev;

    @Override
    public int getActivity() {
        return R.layout.simple_hail_holy_queen_activity;
    }

    @Override
    public void prepareOthersActivity() {
        txtHailHolyQueen1 = (TextView) findViewById(R.id.txt_hail_holy_queen_1);
        FieldsUtils.justifyText(txtHailHolyQueen1);

        txtHailHolyQueen2 = (TextView) findViewById(R.id.txt_hail_holy_queen_2);
        FieldsUtils.justifyText(txtHailHolyQueen2);

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
