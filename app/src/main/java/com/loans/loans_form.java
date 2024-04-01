package com.loans;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.ktx.Firebase;
import com.loans.databinding.ActivityLoansFormBinding;
import com.loans.databinding.ActivityMainBinding;

public class loans_form extends AppCompatActivity {

    private ActivityLoansFormBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoansFormBinding.inflate(getLayoutInflater());
        EdgeToEdge.enable(this);
        setContentView(binding.getRoot());

        binding.cancelButton.setOnClickListener(v -> {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
            finish();

        });
        binding.aceptButton.setOnClickListener(v -> {
            DataLoans data = new DataLoans(
                    binding.firstNameField.getText().toString(),
                    binding.lastNameField.getText().toString(),
                    binding.moneyField.getText().toString(),
                    binding.dataField.getText().toString());
            FirebaseFirestore.getInstance().collection("loans").add(data);
        });
    }
}