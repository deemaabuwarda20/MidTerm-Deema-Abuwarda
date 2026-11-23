package com.example.midterm_deema_abuwarda;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ArtworkDetailsActivity extends AppCompatActivity {

    TextView txtDetails;
    Button btnWebsite, btnBack;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artwork_details);

        txtDetails = findViewById(R.id.txtDetails);
        btnWebsite = findViewById(R.id.btnWebsite);
        btnBack = findViewById(R.id.btnBack);

        String title =
                getIntent().getStringExtra("title");

        String artist =
                getIntent().getStringExtra("artist");

        String year =
                getIntent().getStringExtra("year");

        String website =
                getIntent().getStringExtra("website");

        txtDetails.setText(
                "Title: " + title +
                        "\nArtist: " + artist +
                        "\nYear: " + year
        );

        btnWebsite.setOnClickListener(v -> {

            Intent intent =
                    new Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse(website)
                    );

            startActivity(intent);

        });

        btnBack.setOnClickListener(v -> finish());
    }
}