package com.prayers.app.activity.simple;

import android.widget.TextView;

import com.prayers.app.activity.R;
import com.prayers.app.utils.FieldsUtils;

public class SimpleMagnificatActivity extends AbstractSimplePrayerActivity {

    private TextView txtMagnificat1;
    private TextView txtMagnificat2;
    private TextView txtMagnificat3;

    @Override
    public int getActivity() {
        return R.layout.simple_magnificat_activity;
    }

    @Override
    public void prepareViewFields() {
        txtMagnificat1 = (TextView) findViewById(R.id.txt_magnificat_1);
        FieldsUtils.justifyText(txtMagnificat1);

        txtMagnificat2 = (TextView) findViewById(R.id.txt_magnificat_2);
        FieldsUtils.justifyText(txtMagnificat2);

        txtMagnificat3 = (TextView) findViewById(R.id.txt_magnificat_3);
        FieldsUtils.justifyText(txtMagnificat3);
    }

}
