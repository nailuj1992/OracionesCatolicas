package com.prayers.app.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;

import com.prayers.app.activity.AbstractClosableActivity;

public class CloseDialogFragment extends DialogFragment {

    public static CloseDialogFragment newInstance(String txtCloseDialog, String txtYesChoice, String txtNoChoice) {
        CloseDialogFragment frag = new CloseDialogFragment();
        Bundle args = new Bundle();
        args.putString("txtCloseDialog", txtCloseDialog);
        args.putString("txtYesChoice", txtYesChoice);
        args.putString("txtNoChoice", txtNoChoice);
        frag.setArguments(args);
        return frag;
    }

    @Override
    public final Dialog onCreateDialog(Bundle savedInstanceState) {
        String txtCloseDialog = getArguments().getString("txtCloseDialog");
        String txtYesChoice = getArguments().getString("txtYesChoice");
        String txtNoChoice = getArguments().getString("txtNoChoice");

        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(txtCloseDialog)
                .setPositiveButton(txtYesChoice, (dialog, id) -> ((AbstractClosableActivity) getActivity()).doPositiveClick())
                .setNegativeButton(txtNoChoice, (dialog, id) -> ((AbstractClosableActivity) getActivity()).doNegativeClick());
        // Create the AlertDialog object and return it
        return builder.create();
    }

}
