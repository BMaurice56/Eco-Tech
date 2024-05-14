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
import com.android.ecotech.UserInfo;

public class MyFragment extends Fragment {
    private TextView textViewContent;
    private TextView textViewName;
    private Spinner spinnerContent;
    private EditText editTextMail;
    private Button buttonConfirmation;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate la mise en page de ce fragment
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        // Récupère un TextView qui affiche les questions depuis le layout du fragment
        textViewContent = view.findViewById(R.id.textViewContent);
        // Récupère le TextView qui affiche le nom écrit lors de l'inscription depuis le layout du fragment
        textViewName = view.findViewById(R.id.textViewName);
        // Récupère le Spinner depuis le layout du fragment
        spinnerContent = view.findViewById(R.id.spinnerContent);
        // Récupère l'EditText depuis le layout du fragment
        editTextMail = view.findViewById(R.id.editTextMail);
        // Récupère le Button depuis le layout du fragment
        buttonConfirmation = view.findViewById(R.id.buttonConfirmation);

        // Récupère le texte passé en argument
        String text = getArguments().getString("text");

        // Met à jour le texte du TextView avec le texte passé en argument
        textViewContent.setText(text);

        // Récupère les informations données par l'utilisateur dans la classe IdentificationFragment
        UserInfo userInfo = UserInfo.getInstance();

        // Rend les éléments visibles ou invisibles en fonction de la valeur de l'indicateur
        switch (getArguments().getInt("showElements")) {
            case 1:
                spinnerContent.setVisibility(View.VISIBLE);
                buttonConfirmation.setVisibility(View.VISIBLE);
                break;
            case 2:
                textViewName.setText(userInfo.getUsername());
                textViewName.setVisibility(View.VISIBLE);
                buttonConfirmation.setVisibility(View.VISIBLE);
                break;
            case 3:
                textViewName.setText(userInfo.getPassword());
                textViewName.setVisibility(View.VISIBLE);
                buttonConfirmation.setVisibility(View.VISIBLE);
                break;
            case 4:
                editTextMail.setVisibility(View.VISIBLE);
                userInfo.setMail(String.valueOf(editTextMail.getText()));
                buttonConfirmation.setVisibility(View.VISIBLE);
                break;
            default:
                break;
        }

        // Retourne la vue du fragment
        return view;
    }
}