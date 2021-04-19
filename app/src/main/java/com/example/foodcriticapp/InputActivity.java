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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);


        userReview = findViewById(R.id.userReviewInput);

        Button btn = findViewById(R.id.savebtn);
        Button backBtn = findViewById(R.id.backBtn);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InputActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userReviewValue = userReview.getText().toString();
                ContentValues values = new ContentValues();
                values.put("username", userReviewValue);

                Database db = new Database(getApplicationContext());
                db.addReview(values);
                startActivity(new Intent(InputActivity.this,ListInputActivity.class));

            }
        });
    }
}