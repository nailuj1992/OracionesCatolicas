package com.prayers.app.activity;

import android.widget.Button;

import com.prayers.app.fragment.CloseDialogFragment;
import com.prayers.app.utils.FieldsUtils;
import com.prayers.app.utils.RedirectionUtils;

public abstract class AbstractClosableActivity extends AbstractActivity {

    private Button btnHome;

    /**
     * Prepare all view fields.
     */
    public abstract void prepareOthersActivity();

    @Override
    public final void prepareActivity() {
        btnHome = (Button) findViewById(R.id.btn_home);
        btnHome.setOnClickListener(v -> gotoHome());

        prepareOthersActivity();
    }

    /**
     * Goes to main activity.
     */
    private final void gotoHome() {
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
