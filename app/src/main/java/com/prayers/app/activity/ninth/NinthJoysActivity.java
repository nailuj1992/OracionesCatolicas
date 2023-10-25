package com.prayers.app.activity.ninth;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.prayers.app.activity.AbstractClosableActivity;
import com.prayers.app.activity.R;
import com.prayers.app.constants.RedirectionConstants;
import com.prayers.app.exception.PrayersException;
import com.prayers.app.mapper.NinthMapper;
import com.prayers.app.model.ninth.JoysForEveryday;
import com.prayers.app.model.ninth.NinthDay;
import com.prayers.app.ui.adapter.NinthJoysAdapter;
import com.prayers.app.utils.FieldsUtils;
import com.prayers.app.utils.RedirectionUtils;

public class NinthJoysActivity extends AbstractClosableActivity {

    private NinthDay selectedDay;
    private JoysForEveryday joysForEveryday;

    private TextView txtTextProgress;
    private RecyclerView viewParagraphs;

    private Button btnPrev;
    private Button btnNext;

    @Override
    public int getActivity() {
        return R.layout.ninth_joys_activity;
    }

    @Override
    public void prepareOthersActivity() {
        txtTextProgress = (TextView) findViewById(R.id.txt_joys_progress);
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

            boolean currentJoy = (boolean) getIntent().getExtras().getBoolean(RedirectionConstants.JOYS_FROM_END);
            if (joysForEveryday == null) {
                joysForEveryday = NinthMapper.getJoysForEveryday(this, currentJoy);
            }

            updateJoyState();
        } catch (Exception ex) {
            // TODO Log exception
        }
    }

    private void updateJoyState() throws PrayersException {
        txtTextProgress.setText(String.format(getString(R.string.txt_progress), String.valueOf(joysForEveryday.getCurrent() + 1), String.valueOf(joysForEveryday.getTotal())));

        viewParagraphs.setAdapter(new NinthJoysAdapter(this, joysForEveryday.getCurrentJoy()));
    }

    @Override
    public void backAction() {
        try {
            joysForEveryday.decreaseValue();
            updateJoyState();
        } catch (PrayersException e) {
            Bundle bundle = new Bundle();
            bundle.putSerializable(RedirectionConstants.SELECTED_NINTH_DAY, selectedDay);

            RedirectionUtils.redirectToAnotherActivityWithExtras(this, bundle, NinthOurFatherActivity.class);
        }
    }

    @Override
    public void nextAction() {
        try {
            joysForEveryday.increaseValue();
            updateJoyState();
        } catch (PrayersException e) {
            Bundle bundle = new Bundle();
            bundle.putSerializable(RedirectionConstants.SELECTED_NINTH_DAY, selectedDay);

            RedirectionUtils.redirectToAnotherActivityWithExtras(this, bundle, NinthChildJesusPrayerActivity.class);
        }
    }

}
