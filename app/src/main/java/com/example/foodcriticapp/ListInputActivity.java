package com.example.foodcriticapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ListInputActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_input3);
        LinearLayout container = findViewById(R.id.LayoutContainer);


        Database db = new Database(getApplicationContext());
        Cursor reviewList = db.getReviewList();
        reviewList.moveToFirst();


        do {
            String food = reviewList.getString(0);
            TextView textBox = new TextView(this);
            textBox.setText(food);
            container.addView(textBox);

            String price = reviewList.getString(1);
            TextView textBox1 = new TextView(this);
            textBox1.setText(price);
            container.addView(textBox1);

            String review = reviewList.getString(2);
            TextView textBox2 = new TextView(this);
            textBox2.setText(review);
            container.addView(textBox2);

        } while (reviewList.moveToNext());


        Button backBtn = findViewById(R.id.listUserBackBtn);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListInputActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}