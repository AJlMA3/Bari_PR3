package com.example.pr3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class DataActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        // данные из прошлого окна
        String food = getIntent().getStringExtra("food_key");

        EditText editAddress = findViewById(R.id.editAddress);
        Spinner spinnerPayment = findViewById(R.id.spinnerPayment);
        Button btnNext = findViewById(R.id.btnNext);
        Button btnBack = findViewById(R.id.btnBack);

        btnNext.setOnClickListener(v -> {
            String address = editAddress.getText().toString();
            String payment = spinnerPayment.getSelectedItem().toString();

            if (address.isEmpty()) {
                editAddress.setError("Введите адрес!"); // валидация пустой строки
                return;
            }

            // передача данных в следующее окно
            Intent intent = new Intent(this, CheckActivity.class);
            intent.putExtra("food_key", food);
            intent.putExtra("address_key", address);
            intent.putExtra("payment_key", payment);
            startActivity(intent);
        });

        btnBack.setOnClickListener(v -> finish()); // возврат назад
    }
}
