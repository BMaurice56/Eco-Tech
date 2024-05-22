package com.android.ecotech.FrontDesk;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.android.ecotech.Login.LoginActivity;
import com.android.ecotech.R;
import com.android.ecotech.Register.RegisterActivity;
import com.android.ecotech.UserInfo;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class IdentificationFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;
    private TextInputLayout usernameInputLayout;
    private TextInputLayout passwordInputLayout;
    private TextView login;
    private Button registerButton;
    private RadioGroup radioGroup;
    private RadioButton radioButton;

    // Constructeur public requis
    public IdentificationFragment() {}

    // Méthode statique pour créer une nouvelle instance de IdentificationFragment avec des arguments
    public static IdentificationFragment newInstance(String param1, String param2) {
        IdentificationFragment fragment = new IdentificationFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    // Initialisation du fragment et récupération des arguments
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    // Création de la vue du fragment
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_identification, container, false);

        // Initialisation des champs de texte et des boutons
        usernameInputLayout = view.findViewById(R.id.editUsername);
        passwordInputLayout = view.findViewById(R.id.editPassword);
        registerButton = view.findViewById(R.id.button_register);
        login = view.findViewById(R.id.textViewLogin);
        radioGroup = view.findViewById(R.id.radioGroup);

        // Définition des actions pour le bouton d'inscription
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (verifLog()) {
                    // Obtenir la réponse sélectionnée du RadioButton
                    int radioButtonId = radioGroup.getCheckedRadioButtonId();
                    String username = usernameInputLayout.getEditText().getText().toString();
                    String password = passwordInputLayout.getEditText().getText().toString();

                    if (radioButtonId != -1) {
                        radioButton = view.findViewById(radioButtonId);
                        String responseRadioButton = radioButton.getText().toString();
                        openRegisterActivity(responseRadioButton, username, password);
                    } else {
                        Snackbar.make(view, "Aucun choix sélectionné", Snackbar.LENGTH_SHORT).show();
                    }
                }
            }
        });

        // Mise à jour du radioButton sélectionné
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                radioButton = view.findViewById(checkedId);
            }
        });

        // Définition des actions pour le texte de connexion
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (verifLog()) {
                    openLoginActivity();
                }
            }
        });

        return view;
    }

    // Vérification des champs de connexion
    private boolean verifLog() {
        String username = Objects.requireNonNull(usernameInputLayout.getEditText()).getText().toString().trim();
        String password = Objects.requireNonNull(passwordInputLayout.getEditText()).getText().toString().trim();

        // Vérifier si les champs sont vides
        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
            Toast.makeText(getContext().getApplicationContext(), "Identifiant ou Mot de passe vide", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    // Ouvrir l'activité de connexion
    private void openLoginActivity() {
        Intent intent = new Intent(getActivity(), LoginActivity.class);
        startActivity(intent);
    }

    // Ouvrir l'activité d'inscription avec les informations de l'utilisateur
    private void openRegisterActivity(String responseRadioButton, String username, String password) {
        Intent intent = new Intent(getActivity(), RegisterActivity.class);

        UserInfo userInfo = UserInfo.getInstance();
        userInfo.setUsername(username);
        userInfo.setPassword(password);
        userInfo.setRadioButtonResponse(responseRadioButton);

        startActivity(intent);
    }
}
