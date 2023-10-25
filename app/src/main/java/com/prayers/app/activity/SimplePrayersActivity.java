package com.prayers.app.activity;

import android.widget.Button;

import com.prayers.app.activity.simple.SimpleGloryBeActivity;
import com.prayers.app.activity.simple.SimpleHailHolyQueenActivity;
import com.prayers.app.activity.simple.SimpleHailMaryActivity;
import com.prayers.app.activity.simple.SimpleMagnificatActivity;
import com.prayers.app.activity.simple.SimpleOurFatherActivity;
import com.prayers.app.activity.simple.SimpleStMichaelActivity;
import com.prayers.app.utils.FieldsUtils;
import com.prayers.app.utils.RedirectionUtils;

public class SimplePrayersActivity extends AbstractActivity {

    private Button btnOurFather;
    private Button btnHailMary;
    private Button btnGloryBe;
    private Button btnHailHolyQueen;
    private Button btnStMichael;
    private Button btnMagnificat;
    private Button btnPrev;

    @Override
    public int getActivity() {
        return R.layout.simple_prayers_activity;
    }

    @Override
    public void prepareActivity() {
        btnOurFather = (Button) findViewById(R.id.btn_our_father);
        btnOurFather.setOnClickListener(v -> gotoOurFather());

        btnHailMary = (Button) findViewById(R.id.btn_hail_mary);
        btnHailMary.setOnClickListener(v -> gotoHailMary());

        btnGloryBe = (Button) findViewById(R.id.btn_glory_be);
        btnGloryBe.setOnClickListener(v -> gotoGloryBe());

        btnHailHolyQueen = (Button) findViewById(R.id.btn_hail_holy_queen);
        btnHailHolyQueen.setOnClickListener(v -> gotoHailHolyQueen());

        btnStMichael = (Button) findViewById(R.id.btn_st_michael);
        btnStMichael.setOnClickListener(v -> gotoStMichael());

        btnMagnificat = (Button) findViewById(R.id.btn_magnificat);
        btnMagnificat.setOnClickListener(v -> gotoMagnificat());

        btnPrev = (Button) findViewById(R.id.btn_prev);
        btnPrev.setOnClickListener(v -> backAction());
    }

    @Override
    public void updateViewState() {
    }

    @Override
    public void backAction() {
        FieldsUtils.toastMakeTest(getApplicationContext(), getResources().getText(R.string.title_home));
        RedirectionUtils.redirectToAnotherActivity(this, MainActivity.class);
    }

    @Override
    public void nextAction() {
    }

    public void gotoOurFather() {
        FieldsUtils.toastMakeTest(getApplicationContext(), getResources().getText(R.string.title_our_father));
        RedirectionUtils.redirectToAnotherActivity(this, SimpleOurFatherActivity.class);
    }

    public void gotoHailMary() {
        FieldsUtils.toastMakeTest(getApplicationContext(), getResources().getText(R.string.title_hail_mary));
        RedirectionUtils.redirectToAnotherActivity(this, SimpleHailMaryActivity.class);
    }

    public void gotoGloryBe() {
        FieldsUtils.toastMakeTest(getApplicationContext(), getResources().getText(R.string.title_glory_be));
        RedirectionUtils.redirectToAnotherActivity(this, SimpleGloryBeActivity.class);
    }

    public void gotoHailHolyQueen() {
        FieldsUtils.toastMakeTest(getApplicationContext(), getResources().getText(R.string.title_hail_holy_queen));
        RedirectionUtils.redirectToAnotherActivity(this, SimpleHailHolyQueenActivity.class);
    }

    public void gotoStMichael() {
        FieldsUtils.toastMakeTest(getApplicationContext(), getResources().getText(R.string.title_st_michael_long));
        RedirectionUtils.redirectToAnotherActivity(this, SimpleStMichaelActivity.class);
    }

    public void gotoMagnificat() {
        FieldsUtils.toastMakeTest(getApplicationContext(), getResources().getText(R.string.title_magnificat));
        RedirectionUtils.redirectToAnotherActivity(this, SimpleMagnificatActivity.class);
    }

}
