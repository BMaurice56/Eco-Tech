package com.android.ecotech.Register;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import com.android.ecotech.R;

import java.util.Timer;
import java.util.TimerTask;

public class RegisterActivity extends AppCompatActivity {

    private ViewPager2 viewPager2; // Composant ViewPager2 pour afficher les fragments
    private RegisterFragmentStateAdapter pagerAdapter; // Adaptateur pour les fragments
    private long delayMs = 7500; // Délai initial en millisecondes avant de changer de page
    private static final long PERIOD_MS = 5000; // Intervalle de temps en millisecondes entre les changements de page
    private Timer timer; // Timer pour gérer les changements automatiques de page

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Initialisation de ViewPager2 et du PagerAdapter
        viewPager2 = findViewById(R.id.viewPager2);
        FragmentFactory fragmentFactory = new RegisterFragmentFactory();
        pagerAdapter = new RegisterFragmentStateAdapter(this, fragmentFactory);
        viewPager2.setAdapter(pagerAdapter);

        // Démarrage initial du Timer
        startAutoPageChange(delayMs);
    }

    /**
     * Démarre un nouveau 'Timer' avec le délai spécifié.
     * Appelle 'stopAutoPageChange()' pour s'assurer qu'aucun autre 'Timer' n'est en cours d'exécution avant de démarrer un nouveau.
     *
     * @param delayMs Délai initial avant le démarrage du changement de page
     */
    public void startAutoPageChange(long delayMs) {
        stopAutoPageChange(); // Arrêter tout Timer existant avant de démarrer un nouveau
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                autoPageChange(); // Changer automatiquement de page
            }
        }, delayMs, PERIOD_MS);
    }

    /**
     * Change automatiquement la page du ViewPager2.
     * Utilise un Handler pour poster l'action sur le thread principal.
     */
    private void autoPageChange() {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                int currentItem = viewPager2.getCurrentItem();
                int itemCount = viewPager2.getAdapter().getItemCount();
                if (currentItem < itemCount - 1) {
                    viewPager2.setCurrentItem(currentItem + 1); // Aller à la page suivante
                } else {
                    viewPager2.setCurrentItem(0); // Revenir à la première page si la dernière est atteinte
                }
            }
        });
    }

    /**
     * Arrête le 'Timer' actuel.
     */
    public void stopAutoPageChange() {
        if (timer != null) {
            timer.cancel(); // Arrêter le Timer
            timer = null; // Libérer la référence
        }
    }

    /**
     * Déplace le 'ViewPager2' vers le fragment suivant.
     * Augmente le délai et redémarre le 'Timer' avec le nouveau délai.
     */
    public void moveToNextFragment() {
        int currentItem = viewPager2.getCurrentItem();
        if (currentItem < pagerAdapter.getItemCount() - 1) {
            viewPager2.setCurrentItem(currentItem + 1); // Aller à la page suivante
            delayMs += 7500; // Augmenter le délai
            startAutoPageChange(delayMs); // Redémarrer le Timer avec le nouveau délai
        }
    }
}
