package com.example.pr3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    // объявление переменных
    private RadioGroup rgFood;
    private Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // привязка разметки главного окна

        rgFood = findViewById(R.id.rgFood);
        btnNext = findViewById(R.id.btnNext);

        // активация кнопки после выбора
        rgFood.setOnCheckedChangeListener((group, checkedId) -> btnNext.setEnabled(true));

        btnNext.setOnClickListener(v -> {
            // поиск выбпанной радиокнопки и присваивание текста переменной
            int id = rgFood.getCheckedRadioButtonId();
            RadioButton rb = findViewById(id);
            String foodType = rb.getText().toString();

            // переход ко второму окну
            Intent intent = new Intent(MainActivity.this, DataActivity.class);
            intent.putExtra("food_key", foodType); // отправка выбора в следующее окно
            startActivity(intent);
        });

        // кнопка выхода
        findViewById(R.id.btnExit).setOnClickListener(v -> finishAffinity());
    }
}