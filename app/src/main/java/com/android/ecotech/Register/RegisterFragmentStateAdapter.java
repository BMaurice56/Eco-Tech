package com.android.ecotech.Register;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class RegisterFragmentStateAdapter extends FragmentStateAdapter {
    private final FragmentFactory fragmentFactory;

    // Constructeur prenant en argument l'activité de fragment et une instance de FragmentFactory
    public RegisterFragmentStateAdapter(@NonNull FragmentActivity fragmentActivity, FragmentFactory fragmentFactory) {
        super(fragmentActivity);
        this.fragmentFactory = fragmentFactory;
    }

    // Crée et retourne le fragment correspondant à la position donnée
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return fragmentFactory.createFragment("Bienvenue !", 0);
            case 1:
                return fragmentFactory.createFragment("Afin de mieux vous aider, nous aimerions vous poser quelques questions", 0);
            case 2:
                return fragmentFactory.createFragment("Vous pourrez modifier vos réponses à la fin du QCM ;)", 0);
            case 3:
                return fragmentFactory.createFragment("Vous êtes ?", 1);
            case 4:
                return fragmentFactory.createFragment("Ceci est-il bien votre nom ?", 2);
            case 5:
                return fragmentFactory.createFragment("Ceci est-il bien votre mot de passe ?", 3);
            case 6:
                return fragmentFactory.createFragment("Entrez votre mail :", 4);
            case 7:
                return fragmentFactory.createFragment("Quelle est la nature de votre entreprise ?", 5);
            case 8:
                return fragmentFactory.createFragment("Combien d'appareils électroniques souhaitez-vous recycler ?", 6);
            case 9:
                return fragmentFactory.createFragment("Quels types d'appareils électroniques avez-vous besoin de recycler ?", 7);
            case 10:
                return fragmentFactory.createFragment("À quelle fréquence prévoyez-vous de recycler vos appareils électroniques ?", 8);
            case 11:
                return fragmentFactory.createFragment("Avez-vous besoin d'un service de collecte pour vos appareils ?", 9);
            case 12:
                return fragmentFactory.createFragment("Avez-vous des besoins ou des commentaires particuliers concernant le recyclage de vos appareils ?", 10);
            case 13:
                return new ThankYouFragment();
            default:
                // Gestion de cas invalide, retourne un fragment vide
                return new Fragment();
        }
    }

    // Retourne le nombre total de fragments à afficher
    @Override
    public int getItemCount() {
        return 14;
    }
}
