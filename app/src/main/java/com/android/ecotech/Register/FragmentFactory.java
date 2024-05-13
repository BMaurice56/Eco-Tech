// Définition de l'interface FragmentFactory
package com.android.ecotech.Register;

import androidx.fragment.app.Fragment;

public interface FragmentFactory {
    // Méthode pour créer un fragment avec un texte et d'autres éléments
    Fragment createFragment(String text, int showElements);
}