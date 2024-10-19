package com.webview;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by 1 on 1/13/2018.
 */

public class SplashActivity extends AppCompatActivity {

    Button Amazon;
    Button Flipkart;
    Button paytm;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);

        Amazon = findViewById(R.id.Amazon);
        Flipkart = findViewById(R.id.Flipkart);
        paytm = findViewById(R.id.paytm);

        Amazon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String URL = "https://www.amazon.in";
                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                intent.putExtra("URL", URL);
                startActivity(intent);

            }
        });

        Flipkart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String URL = "https://www.flipkart.com/";
                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                intent.putExtra("URL", URL);
                startActivity(intent);

            }
        });

        paytm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String URL = "https://paytm.com/";
                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                intent.putExtra("URL", URL);
                startActivity(intent);

            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
