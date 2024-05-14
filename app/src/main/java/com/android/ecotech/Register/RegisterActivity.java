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
    private ViewPager2 viewPager2;
    private RegisterFragmentStateAdapter pagerAdapter;
    private static final long DELAY_MS = 5000;
    private static final long PERIOD_MS = 5000;
    private Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Initialisation de ViewPager2 et du PagerAdapter
        viewPager2 = findViewById(R.id.viewPager2);
        FragmentFactory fragmentFactory = new RegisterFragmentFactory();
        pagerAdapter = new RegisterFragmentStateAdapter(this, fragmentFactory);
        viewPager2.setAdapter(pagerAdapter);

        // Initialisation du Timer
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                autoPageChange();
            }
        }, DELAY_MS, PERIOD_MS);
    }

    private void autoPageChange() {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                int currentItem = viewPager2.getCurrentItem();
                int itemCount = viewPager2.getAdapter().getItemCount();
                if (currentItem < itemCount - 1) {
                    viewPager2.setCurrentItem(currentItem + 1);
                } else {
                    viewPager2.setCurrentItem(0);
                }
            }
        });
    }

    public void stopAutoPageChange() {
        if (timer != null) {
            timer.cancel();
        }
    }

    public void moveToNextFragment() {
        int currentItem = viewPager2.getCurrentItem();
        if (currentItem < pagerAdapter.getItemCount() - 1) {
            viewPager2.setCurrentItem(currentItem + 1);
        }
    }
}