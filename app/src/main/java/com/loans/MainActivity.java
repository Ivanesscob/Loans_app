package com.loans;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.loans.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {


    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        EdgeToEdge.enable(this);
        setContentView(binding.getRoot());

        binding.buttonStart.setOnClickListener(v -> {
            Intent i = new Intent(this,loans_form.class);
            startActivity(i);
            finish();
        });
        binding.buttonToDb.setOnClickListener(v -> {
            Intent i = new Intent(this, show_db.class);
            startActivity(i);
            finish();
        });
        binding.buttonExit.setOnClickListener(v -> {
            finish();
        });
    }
}