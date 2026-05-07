package com.prayers.app.ui.adapter;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

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
        View view = LayoutInflater.from(context).inflate(R.layout.joy_row, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        String text = joy.getLines()[i];
        TextView textView = viewHolder.getTextView();
        textView.setText(text);

        boolean isAnswer = activity.getString(R.string.txt_ninth_joy_answer).equalsIgnoreCase(text);
        View card = viewHolder.itemView.findViewById(R.id.card_view);
        FrameLayout.LayoutParams cardParams = (FrameLayout.LayoutParams) card.getLayoutParams();
        if (isAnswer) {
            textView.setTextColor(activity.getColor(R.color.colorPrimary));
            textView.setGravity(Gravity.END);
            textView.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_END);
            cardParams.gravity = Gravity.END;
        } else {
            textView.setTextColor(activity.getColor(R.color.colorOnSurface));
            textView.setGravity(Gravity.START);
            textView.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_START);
            cardParams.gravity = Gravity.START;
        }
        card.setLayoutParams(cardParams);
    }

    @Override
    public int getItemCount() {
        return joy.getLines().length;
    }

}
