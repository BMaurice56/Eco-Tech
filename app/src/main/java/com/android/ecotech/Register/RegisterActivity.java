package com.android.ecotech.Register;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        viewPager2 = findViewById(R.id.viewPager2);

        FragmentFactory fragmentFactory = new RegisterFragmentFactory();
        pagerAdapter = new RegisterFragmentStateAdapter(this, fragmentFactory);
        viewPager2.setAdapter(pagerAdapter);

        // Récupérer la réponse du RadioButton depuis l'intention
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("responseRadioButton")) {
            String response = intent.getStringExtra("responseRadioButton");
            System.out.println(response);
        }

        String username = intent.getStringExtra("username");
        String password = intent.getStringExtra("password");

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
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
        }, DELAY_MS, PERIOD_MS);
    }
}