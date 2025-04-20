package com.example.cuddletoys;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Animation top, bottom;
    private TextView welcomeTV;
    private TextView sloganTV;
    private ImageView img;

    private Button searchAndBrowseBT;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        welcomeTV = findViewById(R.id.welcomeTV);
        sloganTV = findViewById(R.id.sloganTV);
        img = findViewById(R.id.img);

        searchAndBrowseBT = findViewById(R.id.searchAndBrowseBT);


        top = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottom = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        img.setAnimation(top);
        welcomeTV.setAnimation(bottom);
        sloganTV.setAnimation(bottom);
        searchAndBrowseBT.setAnimation(bottom);

        searchAndBrowseBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Search_Browse_Activity.class);
                startActivity(intent);
            }
        });

    }
}