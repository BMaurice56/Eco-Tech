package com.android.ecotech;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;

public class ShopActivity extends AppCompatActivity {
    Button showBasket;
    ImageButton imageButtonSixthArticle;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_shop);

        showBasket = findViewById(R.id.button_showBasket);
        imageButtonSixthArticle = findViewById(R.id.imageButtonSixthArticle);

        showBasket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ouvrirPanier();
            }
        });
    }

    private void ouvrirPanier() {
        Intent intent = new Intent(ShopActivity.this, MyBasketActivity.class);
        startActivity(intent);
    }

}
