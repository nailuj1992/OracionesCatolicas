package com.prayers.app.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.prayers.app.activity.AbstractActivity;
import com.prayers.app.activity.R;
import com.prayers.app.model.ninth.NinthDay;
import com.prayers.app.utils.FieldsUtils;

public class NinthParagraphAdapter extends RecyclerView.Adapter<ViewHolder> {

    private Context context;
    private NinthDay day;
    private AbstractActivity activity;

    public NinthParagraphAdapter(AbstractActivity activity, NinthDay day) {
        this.day = day;
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
        String text = day.getParagraphs().get(i);
        viewHolder.getTextView().setText(text);
        FieldsUtils.justifyText(viewHolder.getTextView());
    }

    @Override
    public int getItemCount() {
        return day.getParagraphs().size();
    }

}
