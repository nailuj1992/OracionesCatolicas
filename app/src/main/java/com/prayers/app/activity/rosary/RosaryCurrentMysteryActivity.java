package com.prayers.app.activity.rosary;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.prayers.app.activity.AbstractClosableActivity;
import com.prayers.app.activity.R;
import com.prayers.app.constants.GeneralConstants;
import com.prayers.app.constants.RedirectionConstants;
import com.prayers.app.mapper.RosaryMapper;
import com.prayers.app.model.rosary.Mysteries;
import com.prayers.app.model.rosary.Mystery;
import com.prayers.app.ui.adapter.RosaryMysteryAdapter;
import com.prayers.app.utils.FieldsUtils;
import com.prayers.app.utils.RedirectionUtils;

public class RosaryCurrentMysteryActivity extends AbstractClosableActivity {

    private Mysteries selectedMysteries;
    private int selectedMystery;
    private Mystery mystery;

    private TextView txtTitleCurrentMystery;
    private TextView txtTextCurrentMystery;
    private RecyclerView viewParagraphs;
    private ImageView imgMysteriesBackground;

    private Button btnPrev;
    private Button btnNext;

    @Override
    public int getActivity() {
        return R.layout.rosary_current_mystery_activity;
    }

    @Override
    public void prepareOthersActivity() {
        txtTitleCurrentMystery = (TextView) findViewById(R.id.title_rosary_current_mystery);
        txtTextCurrentMystery = (TextView) findViewById(R.id.txt_rosary_current_mystery);
        viewParagraphs = FieldsUtils.configureRecyclerView(this, R.id.view_paragraphs);

        imgMysteriesBackground = (ImageView) findViewById(R.id.rosary_mysteries_background);

        btnPrev = (Button) findViewById(R.id.btn_prev);
        btnPrev.setOnClickListener(v -> backAction());

        btnNext = (Button) findViewById(R.id.btn_next);
        btnNext.setOnClickListener(v -> nextAction());
    }

    @Override
    public void updateViewState() {
        try {
            selectedMysteries = (Mysteries) getIntent().getExtras().getSerializable(RedirectionConstants.SELECTED_MYSTERIES);
            selectedMystery = (int) getIntent().getExtras().getInt(RedirectionConstants.SELECTED_MYSTERY);
            if (selectedMystery < selectedMysteries.getMysteries().length && selectedMystery >= 0) {
                mystery = selectedMysteries.getMysteries()[selectedMystery];
            } else {
                mystery = null;
            }

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
        } catch (Exception ex) {
            // TODO Log exception
        }
    }

    @Override
    public void backAction() {
        Bundle bundle = new Bundle();
        bundle.putSerializable(RedirectionConstants.SELECTED_MYSTERIES, selectedMysteries);

        if (selectedMystery == GeneralConstants.FIRST_MYSTERY) {
            RedirectionUtils.redirectToAnotherActivityWithExtras(this, bundle, RosaryApostlesCreedActivity.class);
        } else {
            bundle.putInt(RedirectionConstants.SELECTED_MYSTERY, selectedMystery - 1);

            RedirectionUtils.redirectToAnotherActivityWithExtras(this, bundle, RosaryFatimaActivity.class);
        }
    }

    @Override
    public void nextAction() {
        Bundle bundle = new Bundle();
        bundle.putSerializable(RedirectionConstants.SELECTED_MYSTERIES, selectedMysteries);
        bundle.putInt(RedirectionConstants.SELECTED_MYSTERY, selectedMystery);

        RedirectionUtils.redirectToAnotherActivityWithExtras(this, bundle, RosaryOurFatherActivity.class);
    }

}
