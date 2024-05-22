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

public class MainActivity extends AppCompatActivity {
    private FrameLayout frameLayout;

    private LinearLayout linearLayout;

    private ImageButton buttonHome;

    private ImageButton buttonShopping;

    private ImageButton buttonLoginRegister;

    private ImageButton buttonParameter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frameLayout = (FrameLayout) findViewById(R.id.frameLayout);
        linearLayout = (LinearLayout) findViewById(R.id.layoutFooter);

        buttonHome = findViewById(R.id.buttonHome);
        buttonShopping = findViewById(R.id.buttonShopping);
        buttonLoginRegister = findViewById(R.id.buttonLoginRegister);
        buttonParameter = findViewById(R.id.buttonParameter);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameLayout, new HomeFragment())
                .addToBackStack(null)
                .commit();

        buttonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new HomeFragment());
            }
        });

        buttonShopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new ShopFragment());
            }
        });

        buttonLoginRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new IdentificationFragment());
            }
        });

        buttonParameter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new ParameterFragment());
            }
        });
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }
}