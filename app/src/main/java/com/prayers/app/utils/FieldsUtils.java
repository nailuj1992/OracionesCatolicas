package com.prayers.app.utils;

import android.content.Context;
import android.graphics.text.LineBreaker;
import android.os.Build;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.prayers.app.activity.AbstractActivity;

public class FieldsUtils {

    private FieldsUtils() {
    }

    public static void justifyText(TextView textView) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            textView.setJustificationMode(LineBreaker.JUSTIFICATION_MODE_INTER_WORD);
        }
    }

    public static RecyclerView configureRecyclerView(AbstractActivity activity, int viewId) {
        RecyclerView view_paragraphs = (RecyclerView) activity.findViewById(viewId);
        view_paragraphs.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(activity.getApplicationContext());
        view_paragraphs.setLayoutManager(layoutManager);
        return view_paragraphs;
    }

    public static void toastMakeTest(Context context, CharSequence string) {
        Toast.makeText(context, string, Toast.LENGTH_SHORT).show();
    }

    public static void toastMakeTest(Context context, String string) {
        Toast.makeText(context, string, Toast.LENGTH_SHORT).show();
    }

}
