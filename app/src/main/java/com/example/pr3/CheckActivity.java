package com.example.pr3;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CheckActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);

        // извлечение предыдущих данных
        String food = getIntent().getStringExtra("food_key");
        String address = getIntent().getStringExtra("address_key");
        String payment = getIntent().getStringExtra("payment_key");

        TextView tvResult = findViewById(R.id.tvResult);

        // формирование результата из полученных данных
        String finalReport = "Ваш заказ: " + food + "\n" +
                "Адрес: " + address + "\n" +
                "Оплата: " + payment;

        tvResult.setText(finalReport);

        findViewById(R.id.btnBack).setOnClickListener(v -> finish());
        findViewById(R.id.btnExit).setOnClickListener(v -> finishAffinity());
    }
}
