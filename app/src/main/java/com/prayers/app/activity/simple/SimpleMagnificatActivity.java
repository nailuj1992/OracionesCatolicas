package com.prayers.app.activity.simple;

import android.widget.Button;
import android.widget.TextView;

import com.prayers.app.activity.AbstractClosableActivity;
import com.prayers.app.activity.R;
import com.prayers.app.activity.SimplePrayersActivity;
import com.prayers.app.utils.FieldsUtils;
import com.prayers.app.utils.RedirectionUtils;

public class SimpleMagnificatActivity extends AbstractClosableActivity {

    private TextView txtMagnificat1;
    private TextView txtMagnificat2;
    private TextView txtMagnificat3;
    private Button btnPrev;

    @Override
    public int getActivity() {
        return R.layout.simple_magnificat_activity;
    }

    @Override
    public void prepareOthersActivity() {
        txtMagnificat1 = (TextView) findViewById(R.id.txt_magnificat_1);
        FieldsUtils.justifyText(txtMagnificat1);

        txtMagnificat2 = (TextView) findViewById(R.id.txt_magnificat_2);
        FieldsUtils.justifyText(txtMagnificat2);

        txtMagnificat3 = (TextView) findViewById(R.id.txt_magnificat_3);
        FieldsUtils.justifyText(txtMagnificat3);

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
