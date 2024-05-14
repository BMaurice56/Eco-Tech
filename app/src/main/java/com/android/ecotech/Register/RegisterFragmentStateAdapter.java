package com.android.ecotech.Register;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class RegisterFragmentStateAdapter extends FragmentStateAdapter {
    private final FragmentFactory fragmentFactory;
    private MyFragment.OnNextButtonClickListener onNextButtonClickListener;

    public RegisterFragmentStateAdapter(@NonNull FragmentActivity fragmentActivity, FragmentFactory fragmentFactory) {
        super(fragmentActivity);
        this.fragmentFactory = fragmentFactory;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return fragmentFactory.createFragment("Bienvenue !", 0);
            case 1:
                return fragmentFactory.createFragment("Afin de mieux vous aidez, nous aimerions vous poser quelques questions", 0);
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
                return fragmentFactory.createFragment("Nous vous remercions pour vos réponses", 0);
            default:
                // Gestion de cas invalide, retourne un fragment vide
                return new Fragment();
        }
    }

    @Override
    public int getItemCount() {
        // Retourne le nombre total de fragments à afficher
        return 8;
    }

    public void setOnNextButtonClickListener(MyFragment.OnNextButtonClickListener listener) {
        this.onNextButtonClickListener = listener;
    }
}