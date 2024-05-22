package com.android.ecotech;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.android.ecotech.FrontDesk.HomeFragment;
import com.android.ecotech.FrontDesk.IdentificationFragment;
import com.android.ecotech.FrontDesk.ParameterFragment;
import com.android.ecotech.FrontDesk.ShopFragment;

// Déclaration de la classe MainActivity qui étend AppCompatActivity
public class MainActivity extends AppCompatActivity {
    private FrameLayout frameLayout; // Zone de conteneur pour afficher les fragments

    private LinearLayout linearLayout; // Layout contenant les boutons de navigation

    private ImageButton buttonHome; // Bouton pour afficher l'écran d'accueil

    private ImageButton buttonShopping; // Bouton pour afficher l'écran de shopping

    private ImageButton buttonLoginRegister; // Bouton pour afficher l'écran de connexion/inscription

    private ImageButton buttonParameter; // Bouton pour afficher l'écran des paramètres

    // Méthode appelée lors de la création de l'activité
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Définit le layout de l'activité

        // Initialisation des éléments graphiques à partir des ressources XML
        frameLayout = (FrameLayout) findViewById(R.id.frameLayout);
        linearLayout = (LinearLayout) findViewById(R.id.layoutFooter);
        buttonHome = findViewById(R.id.buttonHome);
        buttonShopping = findViewById(R.id.buttonShopping);
        buttonLoginRegister = findViewById(R.id.buttonLoginRegister);
        buttonParameter = findViewById(R.id.buttonParameter);

        // Remplace le contenu initial du FrameLayout par le fragment d'accueil lors de la création de l'activité
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameLayout, new HomeFragment())
                .addToBackStack(null)
                .commit();

        // Définition des listeners pour les boutons de navigation

        // Bouton d'accueil
        buttonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new HomeFragment());
            }
        });

        // Bouton de shopping
        buttonShopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new ShopFragment());
            }
        });

        // Bouton de connexion/inscription
        buttonLoginRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new IdentificationFragment());
            }
        });

        // Bouton des paramètres
        buttonParameter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new ParameterFragment());
            }
        });
    }

    // Méthode pour remplacer le fragment actuel par un nouveau fragment
    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager(); // Récupère le gestionnaire de fragments
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction(); // Démarre une transaction de fragments
        fragmentTransaction.replace(R.id.frameLayout, fragment); // Remplace le contenu du FrameLayout par le nouveau fragment
        fragmentTransaction.commit(); // Valide la transaction
    }
}
