package com.example.cuddletoys;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class toy_activity extends AppCompatActivity {

    ImageView toyPic;
    TextView nameTV;
    TextView catTV;
    TextView priTV;
    TextView descriptionTV;
    TextView brandTV;
    TextView typeTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toy_activity);

        toyPic = findViewById(R.id.toyPic);
        nameTV = findViewById(R.id.nameTV);
        catTV = findViewById(R.id.catTV);
        priTV = findViewById(R.id.priTV);
        descriptionTV = findViewById(R.id.descriptionTV);
        brandTV = findViewById(R.id.brandTV);
        typeTV = findViewById(R.id.typeTV);


    }
}
