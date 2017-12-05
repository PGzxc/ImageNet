package com.example.imagenet;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.imagenet.activity.GlideActivity;
import com.example.imagenet.activity.PicassoActivity;
import com.example.imagenet.activity.UniversalActivity;
import com.example.imagenet.activity.VolleyActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setListener();
    }

    private void setListener() {
        findViewById(R.id.btn_glide).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(GlideActivity.class);
            }
        });
        findViewById(R.id.btn_universal).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(UniversalActivity.class);
            }
        });
        findViewById(R.id.btn_volley).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(VolleyActivity.class);
            }
        });
        findViewById(R.id.btn_fresco).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(VolleyActivity.class);
            }
        });
        findViewById(R.id.btn_picasso).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(PicassoActivity.class);
            }
        });
    }

    private void startActivity(Class cls){
        Intent intent=new Intent(this,cls);
        startActivity(intent);
    }

}
