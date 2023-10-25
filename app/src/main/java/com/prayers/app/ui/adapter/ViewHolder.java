package com.prayers.app.ui.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.prayers.app.activity.R;

/**
 * Created by Avuunita on 14/12/2017.
 */

public final class ViewHolder extends RecyclerView.ViewHolder {

    private TextView textView;

    public ViewHolder(View view) {
        super(view);
        textView = (TextView) view.findViewById(R.id.txt_paragraph);
    }

    public TextView getTextView() {
        return textView;
    }

    public void setTextView(TextView textView) {
        this.textView = textView;
    }
}
