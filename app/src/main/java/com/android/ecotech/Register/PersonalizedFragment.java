package com.android.ecotech.Register;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.ecotech.R;
import com.android.ecotech.UserInfo;

import java.util.ArrayList;
import java.util.List;

public class PersonalizedFragment extends Fragment {

    // Déclaration des éléments d'interface utilisateur
    private TextView textViewContent;
    private TextView textViewName;
    private Spinner spinnerContent;
    private EditText editTextMail;
    private EditText editTextComment;
    private Button buttonConfirmation;
    private LinearLayout checkboxContainer;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate le layout pour ce fragment
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        // Initialisation des éléments d'interface utilisateur avec les vues du layout
        textViewContent = view.findViewById(R.id.textViewContent);
        textViewName = view.findViewById(R.id.textViewName);
        spinnerContent = view.findViewById(R.id.spinnerContent);
        editTextMail = view.findViewById(R.id.editTextMail);
        editTextComment = view.findViewById(R.id.editTextComment);
        buttonConfirmation = view.findViewById(R.id.buttonConfirmation);
        checkboxContainer = view.findViewById(R.id.checkboxContainer);

        // Récupère le texte passé en argument et le définit dans textViewContent
        String text = getArguments().getString("text");
        textViewContent.setText(text);

        // Récupère les informations utilisateur depuis la classe UserInfo
        UserInfo userInfo = UserInfo.getInstance();

        // Affiche ou masque les éléments en fonction de la valeur de "showElements" passée en argument
        switch (getArguments().getInt("showElements")) {
            case 1:
                // Remplit le spinner avec les choix d'inscription
                ArrayAdapter<CharSequence> adapterChoice = ArrayAdapter.createFromResource(
                        getContext(), R.array.spinner_choice_register, android.R.layout.simple_list_item_1);
                adapterChoice.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerContent.setAdapter(adapterChoice);
                spinnerContent.setVisibility(View.VISIBLE);
                break;
            case 2:
                // Affiche le nom d'utilisateur
                textViewName.setText(userInfo.getUsername());
                textViewName.setVisibility(View.VISIBLE);
                break;
            case 3:
                // Affiche le mot de passe
                textViewName.setText(userInfo.getPassword());
                textViewName.setVisibility(View.VISIBLE);
                break;
            case 4:
                // Affiche l'EditText pour le mail
                editTextMail.setVisibility(View.VISIBLE);
                userInfo.setMail(String.valueOf(editTextMail.getText()));
                break;
            case 5:
                // Remplit le spinner avec les types de sociétés
                ArrayAdapter<CharSequence> adapterType = ArrayAdapter.createFromResource(
                        getContext(), R.array.spinner_type_of_company, android.R.layout.simple_list_item_1);
                adapterType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerContent.setAdapter(adapterType);
                spinnerContent.setVisibility(View.VISIBLE);
                break;
            case 6:
                // Remplit le spinner avec les quantités
                ArrayAdapter<CharSequence> adapterQuantite = ArrayAdapter.createFromResource(
                        getContext(), R.array.spinner_quantity, android.R.layout.simple_list_item_1);
                adapterQuantite.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerContent.setAdapter(adapterQuantite);
                spinnerContent.setVisibility(View.VISIBLE);
                break;
            case 7:
                // Remplit le container avec les CheckBoxes pour les types d'appareils
                String[] typesAppareils = getResources().getStringArray(R.array.checkbox_typeOfDevices);
                checkboxContainer.removeAllViews();
                for (String type : typesAppareils) {
                    CheckBox checkBox = new CheckBox(getContext());
                    checkBox.setText(type);
                    checkboxContainer.addView(checkBox);
                }
                checkboxContainer.setVisibility(View.VISIBLE);
                break;
            case 8:
                // Remplit le spinner avec les options de fréquence de recyclage
                ArrayAdapter<CharSequence> adapterFrequence = ArrayAdapter.createFromResource(
                        getContext(), R.array.spinner_frequency_recycling_options, android.R.layout.simple_list_item_1);
                adapterFrequence.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerContent.setAdapter(adapterFrequence);
                spinnerContent.setVisibility(View.VISIBLE);
                break;
            case 9:
                // Remplit le spinner avec les options de collecte
                ArrayAdapter<CharSequence> adapterCollecte = ArrayAdapter.createFromResource(
                        getContext(), R.array.spinner_collecting_options, android.R.layout.simple_list_item_1);
                adapterCollecte.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerContent.setAdapter(adapterCollecte);
                spinnerContent.setVisibility(View.VISIBLE);
                break;
            case 10:
                // Affiche l'EditText pour les commentaires
                editTextComment.setVisibility(View.VISIBLE);
                break;
            default:
                break;
        }

        // Si l'élément à afficher n'est pas null, rend le bouton de confirmation visible
        if (getArguments().getInt("showElements") != 0) {
            buttonConfirmation.setVisibility(View.VISIBLE);
            buttonConfirmation.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Passe au fragment suivant en utilisant l'activité hôte
                    RegisterActivity activity = (RegisterActivity) getActivity();
                    if (activity != null) {
                        activity.moveToNextFragment();
                    }
                }
            });
        }

        // Gestion spéciale pour les CheckBoxes (types d'appareils)
        if (getArguments().getInt("showElements") == 7) {
            buttonConfirmation.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    List<String> selectedItems = new ArrayList<>();
                    for (int i = 0; i < checkboxContainer.getChildCount(); i++) {
                        View child = checkboxContainer.getChildAt(i);
                        if (child instanceof CheckBox) {
                            CheckBox checkBox = (CheckBox) child;
                            if (checkBox.isChecked()) {
                                selectedItems.add(checkBox.getText().toString());
                            }
                        }
                    }
                    // Stocke les types d'appareils sélectionnés dans userInfo
                    userInfo.setDeviceTypes(selectedItems);
                    // Affiche un toast avec les éléments sélectionnés
                    Toast.makeText(getContext(), "Items sélectionnés : " + selectedItems.toString(), Toast.LENGTH_SHORT).show();
                }
            });
        }

        // Assure que le bouton confirmation passe au fragment suivant
        buttonConfirmation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegisterActivity activity = (RegisterActivity) getActivity();
                if (activity != null) {
                    activity.moveToNextFragment();
                }
            }
        });

        // Retourne la vue du fragment
        return view;
    }
}
