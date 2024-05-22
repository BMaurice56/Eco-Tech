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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link IdentificationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class IdentificationFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private TextInputLayout usernameInputLayout;
    private TextInputLayout passwordInputLayout;
    private TextView login;
    private Button registerButton;
    private RadioGroup radioGroup;
    private RadioButton radioButton;

    public IdentificationFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment IdentificationFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static IdentificationFragment newInstance(String param1, String param2) {
        IdentificationFragment fragment = new IdentificationFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_identification, container, false);

        usernameInputLayout = view.findViewById(R.id.editUsername);
        passwordInputLayout = view.findViewById(R.id.editPassword);
        registerButton = view.findViewById(R.id.button_register);
        login = view.findViewById(R.id.textViewLogin);

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
                        Snackbar.make(view, "Aucun choix sélectionné", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        radioGroup = view.findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                radioButton = view.findViewById(checkedId);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifLog();
                openLoginActivity();
            }
        });



        return view;
    }

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


    private void openLoginActivity() {
        // Créer une intention pour démarrer une nouvelle activité
        Intent intent = new Intent(getActivity(), LoginActivity.class);

        // Démarrer la nouvelle activité
        startActivity(intent);
    }

    private void openRegisterActivity(String responseRadioButton, String username, String password) {
        // Créer une intention pour démarrer une nouvelle activité
        Intent intent = new Intent(getActivity(), RegisterActivity.class);

        UserInfo userInfo = UserInfo.getInstance();
        userInfo.setUsername(username);
        userInfo.setPassword(password);
        userInfo.setRadioButtonResponse(responseRadioButton);

        // Démarrer la nouvelle activité
        startActivity(intent);
    }

}