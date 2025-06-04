package com.example.cherrycalc;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    EditText investAmount, dividendRate, months;
    TextView resultMonthly, resultTotal;
    Button calculateBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Input fields
        investAmount = findViewById(R.id.investAmount);
        dividendRate = findViewById(R.id.dividendRate);
        months = findViewById(R.id.months);

        // Result display
        resultMonthly = findViewById(R.id.resultMonthly);
        resultTotal = findViewById(R.id.resultTotal);

        // Buttons
        calculateBtn = findViewById(R.id.calculateBtn);

        // Calculate dividend
        calculateBtn.setOnClickListener(v -> {
            try {
                double invest = Double.parseDouble(investAmount.getText().toString());
                double rate = Double.parseDouble(dividendRate.getText().toString());
                int numMonths = Integer.parseInt(months.getText().toString());

                if (numMonths > 12) numMonths = 12;
                if (numMonths < 1) numMonths = 1;

                double monthlyDividend = (rate / 100 / 12) * invest;
                double totalDividend = monthlyDividend * numMonths;

                resultMonthly.setText(String.format("Monthly Dividend: RM %.2f", monthlyDividend));
                resultTotal.setText(String.format("Total Dividend: RM %.2f", totalDividend));
            } catch (Exception e) {
                Toast.makeText(MainActivity.this, "Please enter valid numbers", Toast.LENGTH_SHORT).show();
            }

            // Clear input fields
            investAmount.setText("");
            dividendRate.setText("");
            months.setText("");
        });

        // Bottom navigation
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(item -> {
            int id = item.getItemId();

            if (id == R.id.nav_home) {
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();
                return true;
            } else if (id == R.id.nav_about) {
                Intent intent = new Intent(this, AboutActivity.class);
                startActivity(intent);
                return true;
            }

            return false;
        });
    }
}