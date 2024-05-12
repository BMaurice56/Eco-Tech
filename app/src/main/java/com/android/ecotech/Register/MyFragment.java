package com.android.ecotech.Register;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.ecotech.R;

public class MyFragment extends Fragment {

    private TextView textViewContent;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        // Récupérer le TextView depuis le layout du fragment
        textViewContent = view.findViewById(R.id.textViewContent);

        // Récupérer le texte passé en argument
        String text = getArguments().getString("text");

        // Mettre à jour le texte du TextView avec le texte passé en argument
        textViewContent.setText(text);

        return view;
    }
}