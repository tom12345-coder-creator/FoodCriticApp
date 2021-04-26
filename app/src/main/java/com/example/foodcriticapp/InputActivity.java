package com.example.foodcriticapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InputActivity extends AppCompatActivity {
    EditText userReview;
    EditText foodItem;
    EditText foodPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        foodItem = findViewById(R.id.foodItemInput);
        userReview = findViewById(R.id.userReviewInput);
        foodPrice = findViewById(R.id.foodPriceInput);

        Button saveBtn = findViewById(R.id.savebtn);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String foodItemValues = foodItem.getText().toString();
                String userReviewValue = userReview.getText().toString();
                String foodPriceValues = foodPrice.getText().toString();
                ContentValues values = new ContentValues();
                values.put("foodName", foodItemValues);
                values.put("reviewInput", userReviewValue);
                values.put("foodPrice", foodPriceValues);

                Database db = new Database(getApplicationContext());
                long success = db.addReview(values);
                if (success != -1)
                    startActivity(new Intent(InputActivity.this, ListInputActivity.class));

            }
        });

        Button backBtn = findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InputActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}