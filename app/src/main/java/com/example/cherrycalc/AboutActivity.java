package com.example.cherrycalc;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        // Initialize GitHub link
        TextView githubLink = findViewById(R.id.btnGitHub);
        githubLink.setOnClickListener(v -> {
            String url = "https://github.com/MunirahSopi/CherryCalc";
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(browserIntent);
        });

        // Bottom navigation setup
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(item -> {
            int id = item.getItemId();

            if (id == R.id.nav_home) {
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();
                return true;
            } else if (id == R.id.nav_about) {
                // Already on about page
                return true;
            }

            return false;
        });

        bottomNav.setSelectedItemId(R.id.nav_about);
    }
}
