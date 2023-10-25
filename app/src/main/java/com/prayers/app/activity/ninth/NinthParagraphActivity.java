package com.prayers.app.activity.ninth;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.prayers.app.activity.AbstractClosableActivity;
import com.prayers.app.activity.R;
import com.prayers.app.constants.RedirectionConstants;
import com.prayers.app.model.ninth.NinthDay;
import com.prayers.app.ui.adapter.NinthParagraphAdapter;
import com.prayers.app.utils.FieldsUtils;
import com.prayers.app.utils.RedirectionUtils;

public class NinthParagraphActivity extends AbstractClosableActivity {

    private NinthDay selectedDay;

    private TextView txtTitleParagraph;
    private RecyclerView viewParagraphs;

    private Button btnPrev;
    private Button btnNext;

    @Override
    public int getActivity() {
        return R.layout.ninth_paragraph_activity;
    }

    @Override
    public void prepareOthersActivity() {
        txtTitleParagraph = (TextView) findViewById(R.id.title_ninth_paragraph);
        viewParagraphs = FieldsUtils.configureRecyclerView(this, R.id.view_paragraphs);

        btnPrev = (Button) findViewById(R.id.btn_prev);
        btnPrev.setOnClickListener(v -> backAction());

        btnNext = (Button) findViewById(R.id.btn_next);
        btnNext.setOnClickListener(v -> nextAction());
    }

    @Override
    public void updateViewState() {
        try {
            selectedDay = (NinthDay) getIntent().getExtras().getSerializable(RedirectionConstants.SELECTED_NINTH_DAY);

            txtTitleParagraph.setText(String.format(getString(R.string.title_paragraph), selectedDay.getSchedule().replace("(", "").replace(")", "")));
            viewParagraphs.setAdapter(new NinthParagraphAdapter(this, selectedDay));
        } catch (Exception ex) {
            // TODO Log exception
        }
    }

    @Override
    public void backAction() {
        Bundle bundle = new Bundle();
        bundle.putSerializable(RedirectionConstants.SELECTED_NINTH_DAY, selectedDay);

        RedirectionUtils.redirectToAnotherActivityWithExtras(this, bundle, NinthConsiderationActivity.class);
    }

    @Override
    public void nextAction() {
        Bundle bundle = new Bundle();
        bundle.putSerializable(RedirectionConstants.SELECTED_NINTH_DAY, selectedDay);

        RedirectionUtils.redirectToAnotherActivityWithExtras(this, bundle, NinthVirginMaryPrayerActivity.class);
    }

}
