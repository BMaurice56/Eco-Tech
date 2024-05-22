package com.android.ecotech.Register;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.android.ecotech.MainActivity;
import com.android.ecotech.R;

public class ThankYouFragment extends Fragment {

    // Méthode pour créer et retourner la vue du fragment
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_thank_you, container, false);

        // Initialiser le bouton et définir un écouteur de clic
        Button buttonReturnToMain = view.findViewById(R.id.buttonReturnToMain);
        buttonReturnToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Création de l'intent pour revenir à MainActivity
                Intent intent = new Intent(getActivity(), MainActivity.class);
                // Ajouter des flags pour nettoyer la pile d'activités et démarrer une nouvelle tâche
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                // Terminer l'activité actuelle
                getActivity().finish();
            }
        });

        return view;
    }
}
