package com.example.cracking.groupproj;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClick1(View v) {

        Intent intent = new Intent(getApplicationContext(),firstActivity.class);
        startActivity(intent);
    }

    public void onClick2(View v) {

    }

    public void onClick3(View v) {

        Intent intent = new Intent(getApplicationContext(),galleryActivity.class);
        startActivity(intent);
    }

    public void onClick4(View v) {

        Intent intent = new Intent(getApplicationContext(),ListViewActivity.class);
        startActivity(intent);
    }

    public void onClick5(View v) {

    }



    public void insertImg(View v){

    }
}
