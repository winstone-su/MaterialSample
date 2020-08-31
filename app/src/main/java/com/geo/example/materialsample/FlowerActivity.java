package com.geo.example.materialsample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class FlowerActivity extends AppCompatActivity {
    public static final String FLOWER_NAME = "flower_name";
    public static final String FLOWERE_IMAGE_ID = "flower_image_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flower);
    }
}