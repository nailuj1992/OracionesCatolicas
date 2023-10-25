package com.prayers.app.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.prayers.app.activity.AbstractActivity;
import com.prayers.app.activity.R;
import com.prayers.app.model.ninth.Joy;

public class NinthJoysAdapter extends RecyclerView.Adapter<ViewHolder> {

    private Context context;
    private Joy joy;
    private AbstractActivity activity;

    public NinthJoysAdapter(AbstractActivity activity, Joy joy) {
        this.joy = joy;
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
        String text = joy.getLines()[i];
        viewHolder.getTextView().setText(text);

        if (activity.getString(R.string.txt_ninth_joy_answer).equalsIgnoreCase(text)) {
            viewHolder.getTextView().setTextColor(activity.getColor(R.color.colorPrimary));
        }
    }

    @Override
    public int getItemCount() {
        return joy.getLines().length;
    }

}
