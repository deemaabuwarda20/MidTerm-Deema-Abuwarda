package com.example.midterm_deema_abuwarda;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ImageView imgArtwork;
    TextView txtCounter, txtTitle, txtArtist;
    Button btnPrevious, btnNext;

    int currentIndex = 0;

    int[] images = {
            R.drawable.art1,
            R.drawable.art2,
            R.drawable.art3,
            R.drawable.art4,
            R.drawable.art5,
            R.drawable.art6
    };

    String[] titles = {
            "Mona Lisa",
            "Starry Night",
            "Girl with a Pearl Earring",
            "The Persistence of Memory",
            "Composition 8",
            "Guernica"
    };

    String[] artists = {
            "Leonardo da Vinci",
            "Vincent van Gogh",
            "Johannes Vermeer",
            "Salvador Dalí",
            "ًWassily Kandinsky",
            "Pablo Picasso"
    };

    String[] years = {
            "1503",
            "1889",
            "1665",
            "1931",
            "1923",
            "19937"
    };

    String[] websites = {
            "https://en.wikipedia.org/wiki/Mona_Lisa",
            "https://en.wikipedia.org/wiki/The_Starry_Night",
            "https://en.wikipedia.org/wiki/Girl_with_a_Pearl_Earring",
            "https://en.wikipedia.org/wiki/The_Persistence_of_Memory",
            "https://en.wikipedia.org/wiki/Composition_8",
            "https://en.wikipedia.org/wiki/Guernica_(Picasso)"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgArtwork = findViewById(R.id.imgArtwork);
        txtCounter = findViewById(R.id.txtCounter);
        txtTitle = findViewById(R.id.txtTitle);
        txtArtist = findViewById(R.id.txtArtist);

        btnPrevious = findViewById(R.id.btnPrevious);
        btnNext = findViewById(R.id.btnNext);

        if (savedInstanceState != null) {
            currentIndex = savedInstanceState.getInt("index");
        }

        updateArtwork();

        btnNext.setOnClickListener(v -> {
            if (currentIndex < images.length - 1) {
                currentIndex++;
                updateArtwork();
            }
        });

        btnPrevious.setOnClickListener(v -> {
            if (currentIndex > 0) {
                currentIndex--;
                updateArtwork();
            }
        });

        imgArtwork.setOnClickListener(v -> {

            Intent intent =
                    new Intent(MainActivity.this,
                            ArtworkDetailsActivity.class);

            intent.putExtra("title",
                    titles[currentIndex]);

            intent.putExtra("artist",
                    artists[currentIndex]);

            intent.putExtra("year",
                    years[currentIndex]);

            intent.putExtra("website",
                    websites[currentIndex]);

            startActivity(intent);

        });
    }

    private void updateArtwork() {

        imgArtwork.setImageResource(
                images[currentIndex]);

        txtTitle.setText(
                titles[currentIndex]);

        txtArtist.setText(
                artists[currentIndex]
                        + " ("
                        + years[currentIndex]
                        + ")");

        txtCounter.setText(
                (currentIndex + 1)
                        + " / "
                        + images.length);

        btnPrevious.setEnabled(
                currentIndex != 0);

        btnNext.setEnabled(
                currentIndex != images.length - 1);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {

        super.onSaveInstanceState(outState);

        outState.putInt(
                "index",
                currentIndex);
    }
}