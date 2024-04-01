package com.loans;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.ktx.Firebase;
import com.loans.databinding.ActivityLoansFormBinding;
import com.loans.databinding.ActivityMainBinding;
import com.loans.databinding.ActivityShowDbBinding;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class show_db extends AppCompatActivity {

    private ActivityShowDbBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityShowDbBinding.inflate(getLayoutInflater());
        EdgeToEdge.enable(this);

        setContentView(binding.getRoot());

        binding.button.setOnClickListener(v -> {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
            finish();

        });
        FirebaseFirestore.getInstance().collection("loans").addSnapshotListener((value, error) -> {
            var list = value.getDocuments().stream().map(d -> d.toObject(DataLoans.class)).collect(Collectors.toList());
            binding.recycleViewDate.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
            binding.recycleViewDate.setAdapter(new LoansAdapter(this, list));
        });
    }
}