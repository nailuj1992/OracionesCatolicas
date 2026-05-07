package com.prayers.app.activity.ninth;

import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.prayers.app.activity.R;
import com.prayers.app.constants.RedirectionConstants;
import com.prayers.app.exception.PrayersException;
import com.prayers.app.mapper.NinthMapper;
import com.prayers.app.model.ninth.JoysForEveryday;
import com.prayers.app.navigation.PrayerScreen;
import com.prayers.app.ui.adapter.NinthJoysAdapter;
import com.prayers.app.utils.FieldsUtils;

public class NinthJoysActivity extends AbstractNinthActivity {

    private JoysForEveryday joysForEveryday;

    private TextView txtTextProgress;
    private RecyclerView viewParagraphs;

    @Override
    public int getActivity() {
        return R.layout.ninth_joys_activity;
    }

    @Override
    public void prepareViewFields() {
        txtTextProgress = (TextView) findViewById(R.id.txt_joys_progress);
        viewParagraphs = FieldsUtils.configureRecyclerView(this, R.id.view_paragraphs);
    }

    @Override
    protected void updateNinthView() {
        try {
            boolean currentJoy = false;
            if (getIntent().getExtras() != null) {
                currentJoy = getIntent().getExtras().getBoolean(RedirectionConstants.JOYS_FROM_END);
            }
            if (joysForEveryday == null) {
                joysForEveryday = NinthMapper.getJoysForEveryday(this, currentJoy);
            }
            updateJoyState();
        } catch (PrayersException ex) {
            android.util.Log.w(TAG_PRAYERS, getClass().getSimpleName() + ".updateNinthView failed", ex);
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
            PrayerScreen.goPrev(this, buildBaseBundle());
        }
    }

    @Override
    public void nextAction() {
        try {
            joysForEveryday.increaseValue();
            updateJoyState();
        } catch (PrayersException e) {
            PrayerScreen.goNext(this, buildBaseBundle());
        }
    }

}
