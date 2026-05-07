package com.prayers.app.activity.simple;

import android.widget.TextView;

import com.prayers.app.activity.R;
import com.prayers.app.utils.FieldsUtils;

public class SimpleHailHolyQueenActivity extends AbstractSimplePrayerActivity {

    private TextView txtHailHolyQueen1;
    private TextView txtHailHolyQueen2;

    @Override
    public int getActivity() {
        return R.layout.simple_hail_holy_queen_activity;
    }

    @Override
    public void prepareViewFields() {
        txtHailHolyQueen1 = (TextView) findViewById(R.id.txt_hail_holy_queen_1);
        FieldsUtils.justifyText(txtHailHolyQueen1);

        txtHailHolyQueen2 = (TextView) findViewById(R.id.txt_hail_holy_queen_2);
        FieldsUtils.justifyText(txtHailHolyQueen2);
    }

}
