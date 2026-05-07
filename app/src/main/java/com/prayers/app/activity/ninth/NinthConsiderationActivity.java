package com.prayers.app.activity.ninth;

import android.os.Bundle;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.prayers.app.activity.R;
import com.prayers.app.constants.RedirectionConstants;
import com.prayers.app.navigation.PrayerScreen;
import com.prayers.app.ui.adapter.NinthConsiderationAdapter;
import com.prayers.app.utils.FieldsUtils;

public class NinthConsiderationActivity extends AbstractNinthActivity {

    private TextView txtTitleConsideration;
    private RecyclerView viewParagraphs;

    @Override
    public int getActivity() {
        return R.layout.ninth_consideration_activity;
    }

    @Override
    public void prepareViewFields() {
        txtTitleConsideration = (TextView) findViewById(R.id.title_ninth_consideration);
        viewParagraphs = FieldsUtils.configureRecyclerView(this, R.id.view_paragraphs);
    }

    @Override
    protected void updateNinthView() {
        if (selectedDay == null) return;
        txtTitleConsideration.setText(String.format(getString(R.string.title_consideration), selectedDay.getName()));
        viewParagraphs.setAdapter(new NinthConsiderationAdapter(this, selectedDay));
    }

    @Override
    public void backAction() {
        Bundle bundle = buildBaseBundle();
        bundle.putSerializable(RedirectionConstants.GLORY_BE_FROM_END, Boolean.TRUE);
        PrayerScreen.goPrev(this, bundle);
    }

    @Override
    public void nextAction() {
        PrayerScreen.goNext(this, buildBaseBundle());
    }

}
