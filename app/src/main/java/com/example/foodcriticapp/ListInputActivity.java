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
            String name = reviewList.getString(0);
            TextView textBox = new TextView(this);
            textBox.setText(name);
            container.addView(textBox);

        } while (reviewList.moveToFirst());


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