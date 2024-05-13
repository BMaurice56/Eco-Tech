// Implémentation de l'interface FragmentFactory
package com.android.ecotech.Register;

import android.os.Bundle;
import androidx.fragment.app.Fragment;

public class RegisterFragmentFactory implements FragmentFactory {
    @Override
    // Crée un fragment MyFragment
    public Fragment createFragment(String text, int showElements) {
        MyFragment fragment = new MyFragment();
        Bundle args = new Bundle();

        // Ajoute le texte dans les arguments du fragment
        args.putString("text", text);

        // Ajoute un booléen qui indique si un ou plusieurs éléments doivent être visibles ou non
        args.putInt("showElements", showElements);

        // Définit les arguments du fragment
        fragment.setArguments(args);

        // Renvoie le fragment créé
        return fragment;
    }
}