package com.android.ecotech.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.ecotech.MainActivity;
import com.android.ecotech.R;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {
    // Déclaration des variables pour les champs de saisie et leurs conteneurs
    private EditText usernameEditText;
    private EditText passwordEditText;
    private TextInputLayout usernameTextInputLayout;
    private TextInputLayout passwordTextInputLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialisation des champs de saisie et de leurs conteneurs
        usernameTextInputLayout = findViewById(R.id.username);
        passwordTextInputLayout = findViewById(R.id.password);

        // Liaison des champs de saisie aux éléments de l'interface utilisateur
        usernameEditText = (EditText) usernameTextInputLayout.getEditText();
        passwordEditText = (EditText) passwordTextInputLayout.getEditText();

        // Liaison du bouton de connexion et définition du gestionnaire d'événements onClick
        Button loginButton = findViewById(R.id.button_login);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Récupération des valeurs saisies dans les champs de texte
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                // Vérification de la validité des informations de connexion
                if (isValidLogin(username, password)) {
                    // Si les informations sont valides, démarrer l'activité principale
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    // Sinon, afficher un message d'erreur à l'utilisateur
                    Toast.makeText(LoginActivity.this, "Identifiant ou mot de passe incorrect", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // Méthode pour vérifier la validité des informations de connexion
    private boolean isValidLogin(String username, String password) {
        // Ajoutez ici votre logique de validation
        return true; // Pour l'exemple, renvoie toujours true
    }
}
