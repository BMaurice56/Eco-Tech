// Fragment personnalisé pour afficher un texte et d'autres éléments
package com.android.ecotech.Register;

import android.annotation.SuppressLint;
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
        // Inflate la mise en page de ce fragment
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        // Récupère un TextView qui affiche les questions depuis le layout du fragment
        textViewContent = view.findViewById(R.id.textViewContent);
        // Récupère le TextView qui affiche le nom écrit lors de l'inscription depuis le layout du fragment
        textViewName = view.findViewById(R.id.textViewName);
        // Récupère le Spinner depuis le layout du fragment
        spinnerContent = view.findViewById(R.id.spinnerContent);
        // Récupère l'EditText pour le mail depuis le layout du fragment
        editTextMail = view.findViewById(R.id.editTextMail);
        // Récupère l'EditText pour le commentaire depuis le layout du fragment
        editTextComment = view.findViewById(R.id.editTextComment);
        // Récupère le Button depuis le layout du fragment
        buttonConfirmation = view.findViewById(R.id.buttonConfirmation);
        // Récupère le LinearLayout depuis le layout du fragment
        checkboxContainer = view.findViewById(R.id.checkboxContainer);


        // Récupère le texte passé en argument
        String text = getArguments().getString("text");

        // Met à jour le texte du TextView avec le texte passé en argument
        textViewContent.setText(text);

        // Récupère les informations données par l'utilisateur dans la classe IdentificationFragment
        UserInfo userInfo = UserInfo.getInstance();

        // Rend les éléments visibles ou invisibles en fonction de la valeur de l'indicateur
        switch (getArguments().getInt("showElements")) {
            case 1:
                ArrayAdapter<CharSequence> adapterChoice = ArrayAdapter.createFromResource(
                        getContext(), R.array.spinner_choice_register, android.R.layout.simple_list_item_1);
                adapterChoice.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerContent.setAdapter(adapterChoice);
                spinnerContent.setVisibility(View.VISIBLE);
                break;
            case 2:
                textViewName.setText(userInfo.getUsername());
                textViewName.setVisibility(View.VISIBLE);
                break;
            case 3:
                textViewName.setText(userInfo.getPassword());
                textViewName.setVisibility(View.VISIBLE);
                break;
            case 4:
                editTextMail.setVisibility(View.VISIBLE);
                userInfo.setMail(String.valueOf(editTextMail.getText()));
                break;
            case 5:
                ArrayAdapter<CharSequence> adapterType = ArrayAdapter.createFromResource(
                        getContext(), R.array.spinner_type_of_company, android.R.layout.simple_list_item_1);
                adapterType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerContent.setAdapter(adapterType);
                spinnerContent.setVisibility(View.VISIBLE);
                break;
            case 6:
                ArrayAdapter<CharSequence> adapterQuantite = ArrayAdapter.createFromResource(
                        getContext(), R.array.spinner_quantity, android.R.layout.simple_list_item_1);
                adapterQuantite.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerContent.setAdapter(adapterQuantite);
                spinnerContent.setVisibility(View.VISIBLE);
                break;
            case 7:
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
                ArrayAdapter<CharSequence> adapterFrequence = ArrayAdapter.createFromResource(
                        getContext(), R.array.spinner_frequency_recycling_options, android.R.layout.simple_list_item_1);
                adapterFrequence.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerContent.setAdapter(adapterFrequence);
                spinnerContent.setVisibility(View.VISIBLE);
                break;
            case 9:
                ArrayAdapter<CharSequence> adapterCollecte = ArrayAdapter.createFromResource(
                        getContext(), R.array.spinner_collecting_options, android.R.layout.simple_list_item_1);
                adapterCollecte.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerContent.setAdapter(adapterCollecte);
                spinnerContent.setVisibility(View.VISIBLE);
            case 10:
                editTextComment.setVisibility(View.VISIBLE);
                break;
            default:
                break;
        }

        // Si le bouton est visible, déclencher le passage au fragment suivant
        if (getArguments().getInt("showElements") != 0) {
            buttonConfirmation.setVisibility(View.VISIBLE);
            buttonConfirmation.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Obtenez l'activité hôte pour accéder au ViewPager2 et passer au fragment suivant
                    RegisterActivity activity = (RegisterActivity) getActivity();
                    if (activity != null) {
                        activity.moveToNextFragment();
                    }
                }
            });
        }

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
                    // Stock dans userInfo
                    userInfo.setSelectedItems(selectedItems);
                    // Affiche les valeurs sélectionnées
                    Toast.makeText(getContext(), "Items sélectionnés : " + selectedItems.toString(), Toast.LENGTH_SHORT).show();
                }
            });
        }

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