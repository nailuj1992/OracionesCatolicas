package com.prayers.app.activity;

import android.widget.Button;

import com.prayers.app.fragment.CloseDialogFragment;
import com.prayers.app.utils.FieldsUtils;
import com.prayers.app.utils.RedirectionUtils;

public abstract class AbstractClosableActivity extends AbstractActivity {

    protected static final String TAG_PRAYERS = "PrayersApp";

    private Button btnHome;
    private Button btnPrev;
    private Button btnNext;

    /**
     * Subclass-specific view binding. Called after btn_home / btn_prev /
     * btn_next (or its layout-specific variant) have already been wired.
     */
    public abstract void prepareViewFields();

    @Override
    public final void prepareActivity() {
        btnHome = (Button) findViewById(R.id.btn_home);
        if (btnHome != null) {
            btnHome.setOnClickListener(v -> gotoHome());
        }

        btnPrev = (Button) findViewById(R.id.btn_prev);
        if (btnPrev != null) {
            btnPrev.setOnClickListener(v -> backAction());
        }

        btnNext = (Button) findViewById(R.id.btn_next);
        if (btnNext == null) btnNext = (Button) findViewById(R.id.btn_begin);
        if (btnNext == null) btnNext = (Button) findViewById(R.id.btn_end);
        if (btnNext == null) btnNext = (Button) findViewById(R.id.btn_pray);
        if (btnNext != null) {
            btnNext.setOnClickListener(v -> nextAction());
        }

        prepareViewFields();
    }

    private void gotoHome() {
        String txtCloseDialog = getString(R.string.txt_close_dialog);
        String txtYesChoice = getString(R.string.txt_yes_choice);
        String txtNoChoice = getString(R.string.txt_no_choice);
        CloseDialogFragment dialog = CloseDialogFragment.newInstance(txtCloseDialog, txtYesChoice, txtNoChoice);
        dialog.show(getSupportFragmentManager(), "closeDialog");
    }

    protected final void redirectToHome() {
        FieldsUtils.toastMakeTest(getApplicationContext(), getResources().getText(R.string.title_home));
        RedirectionUtils.redirectToAnotherActivity(this, MainActivity.class);
    }

    public void doPositiveClick() {
        redirectToHome();
    }

    public void doNegativeClick() {
    }

}
