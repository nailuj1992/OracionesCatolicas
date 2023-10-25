package com.prayers.app.ui.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.prayers.app.activity.AbstractActivity;
import com.prayers.app.activity.R;
import com.prayers.app.model.rosary.Mystery;
import com.prayers.app.utils.FieldsUtils;

public class RosaryMysteryAdapter extends RecyclerView.Adapter<ViewHolder> {

    private Context context;
    private Mystery mystery;
    private AbstractActivity activity;

    public RosaryMysteryAdapter(AbstractActivity activity, Mystery mystery) {
        this.mystery = mystery;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.paragraph_row, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        String text = mystery.getParagraphs().get(i);
        viewHolder.getTextView().setText(text);

        final String reflection = activity.getString(R.string.txt_rosary_reflection);
        final String pause = activity.getString(R.string.txt_rosary_pause);

        if (pause.equals(text) || reflection.equals(text)) {
            viewHolder.getTextView().setTypeface(null, Typeface.BOLD);
            if (reflection.equals(text)) {
                viewHolder.getTextView().setTextColor(activity.getColor(R.color.colorPrimary));
            }
        } else {
            FieldsUtils.justifyText(viewHolder.getTextView());
        }
    }

    @Override
    public int getItemCount() {
        return mystery.getParagraphs().size();
    }

}
