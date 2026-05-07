package com.prayers.app.activity.rosary;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.prayers.app.activity.R;
import com.prayers.app.constants.GeneralConstants;
import com.prayers.app.constants.RedirectionConstants;
import com.prayers.app.mapper.RosaryMapper;
import com.prayers.app.navigation.PrayerScreen;
import com.prayers.app.ui.adapter.RosaryMysteryAdapter;
import com.prayers.app.utils.FieldsUtils;
import com.prayers.app.utils.RedirectionUtils;

public class RosaryCurrentMysteryActivity extends AbstractRosaryActivity {

    private TextView txtTitleCurrentMystery;
    private TextView txtTextCurrentMystery;
    private RecyclerView viewParagraphs;
    private ImageView imgMysteriesBackground;

    @Override
    public int getActivity() {
        return R.layout.rosary_current_mystery_activity;
    }

    @Override
    public void prepareViewFields() {
        txtTitleCurrentMystery = (TextView) findViewById(R.id.title_rosary_current_mystery);
        txtTextCurrentMystery = (TextView) findViewById(R.id.txt_rosary_current_mystery);
        viewParagraphs = FieldsUtils.configureRecyclerView(this, R.id.view_paragraphs);
        imgMysteriesBackground = (ImageView) findViewById(R.id.rosary_mysteries_background);
    }

    @Override
    protected void updateRosaryView() {
        if (mystery != null) {
            txtTitleCurrentMystery.setText(String.format(getString(R.string.txt_rosary_current_mystery), RosaryMapper.getCurrentMysteryLocation(this, selectedMysteries.getValue(), mystery)));
            txtTextCurrentMystery.setText(mystery.getName());
            viewParagraphs.setAdapter(new RosaryMysteryAdapter(this, mystery));
        } else {
            txtTitleCurrentMystery.setText(getString(R.string.title_rosary_last_part));
            txtTextCurrentMystery.setText(getString(R.string.txt_rosary_last_part));
            viewParagraphs.setAdapter(null);
        }

        RosaryMapper.changeImageForRosary(this, selectedMysteries, imgMysteriesBackground);
    }

    @Override
    public void backAction() {
        if (selectedMystery == GeneralConstants.FIRST_MYSTERY) {
            Bundle bundle = new Bundle();
            bundle.putSerializable(RedirectionConstants.SELECTED_MYSTERIES, selectedMysteries);
            RedirectionUtils.redirectToAnotherActivityWithExtras(this, bundle, RosaryApostlesCreedActivity.class);
        } else {
            Bundle bundle = buildBaseBundle();
            bundle.putInt(RedirectionConstants.SELECTED_MYSTERY, selectedMystery - 1);
            RedirectionUtils.redirectToAnotherActivityWithExtras(this, bundle, RosaryFatimaActivity.class);
        }
    }

    @Override
    public void nextAction() {
        PrayerScreen.goNext(this, buildBaseBundle());
    }

}
