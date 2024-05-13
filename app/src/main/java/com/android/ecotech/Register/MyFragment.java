// Fragment personnalisé pour afficher un texte et d'autres éléments
package com.android.ecotech.Register;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.ecotech.R;

public class MyFragment extends Fragment {
    private TextView textViewContent;
    private Spinner spinnerContent;
    private EditText editTextText;
    private Button buttonConfirmation;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate la mise en page de ce fragment
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        // Récupère le TextView depuis le layout du fragment
        textViewContent = view.findViewById(R.id.textViewContent);
        // Récupère le Spinner depuis le layout du fragment
        spinnerContent = view.findViewById(R.id.spinnerContent);
        // Récupère l'EditText depuis le layout du fragment
        editTextText = view.findViewById(R.id.editTextText);
        // Récupère le Button depuis le layout du fragment
        buttonConfirmation = view.findViewById(R.id.buttonConfirmation);

        // Récupère le texte passé en argument
        String text = getArguments().getString("text");
        // Récupère le booléen pour déterminer si un ou plusieurs éléments doivent être visible ou non
        int showNewElements = getArguments().getInt("showNewElements", 0);


        // Met à jour le texte du TextView avec le texte passé en argument
        textViewContent.setText(text);

        // Rend les éléments visibles ou invisibles en fonction de la valeur de l'indicateur
        switch (showNewElements) {
            case 1:
                spinnerContent.setVisibility(View.VISIBLE);
                buttonConfirmation.setVisibility(View.VISIBLE);
                break;
            case 2:
                editTextText.setVisibility(View.VISIBLE);
                buttonConfirmation.setVisibility(View.VISIBLE);
                break;
            case 0:
                break;
        }

        // Retourne la vue du fragment
        return view;
    }
}