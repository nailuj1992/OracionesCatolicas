package com.prayers.app.activity.ninth;

import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.prayers.app.activity.R;
import com.prayers.app.navigation.PrayerScreen;
import com.prayers.app.ui.adapter.NinthParagraphAdapter;
import com.prayers.app.utils.FieldsUtils;

public class NinthParagraphActivity extends AbstractNinthActivity {

    private TextView txtTitleParagraph;
    private RecyclerView viewParagraphs;

    @Override
    public int getActivity() {
        return R.layout.ninth_paragraph_activity;
    }

    @Override
    public void prepareViewFields() {
        txtTitleParagraph = (TextView) findViewById(R.id.title_ninth_paragraph);
        viewParagraphs = FieldsUtils.configureRecyclerView(this, R.id.view_paragraphs);
    }

    @Override
    protected void updateNinthView() {
        if (selectedDay == null) return;
        txtTitleParagraph.setText(String.format(getString(R.string.title_paragraph), selectedDay.getSchedule().replace("(", "").replace(")", "")));
        viewParagraphs.setAdapter(new NinthParagraphAdapter(this, selectedDay));
    }

    @Override
    public void backAction() {
        PrayerScreen.goPrev(this, buildBaseBundle());
    }

    @Override
    public void nextAction() {
        PrayerScreen.goNext(this, buildBaseBundle());
    }

}
