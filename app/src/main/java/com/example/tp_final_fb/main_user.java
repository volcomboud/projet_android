package com.example.tp_final_fb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class main_user extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_user);
    }
    public void OnClickLogOut(View view){
        Intent intent= new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}