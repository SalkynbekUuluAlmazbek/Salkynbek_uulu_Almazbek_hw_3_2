package com.geeks.salkynbek_uulu_almazbek_hw_3_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.geeks.salkynbek_uulu_almazbek_hw_3_2.fragments.FirstFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.firstFragmentContainerView, new FirstFragment())
                .commit();
    }

}