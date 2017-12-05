package com.example.imagenet.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;
import com.example.imagenet.R;
import com.example.imagenet.data.Data;

/**
 * author：Admin
 * date：2017/11/2221:25
 * 编程使我快乐
 */

public class VolleyActivity extends AppCompatActivity {
    private ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley);
        imageView = findViewById(R.id.img_volley);
        RequestQueue mQueue = Volley.newRequestQueue(this);
        ImageRequest imageRequest = new ImageRequest(
                Data.data,
                new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap response) {
                        imageView.setImageBitmap(response);
                    }
                }, 0, 0, Bitmap.Config.RGB_565, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                imageView.setImageResource(R.drawable.ic_launcher_background);
            }
        });
        mQueue.add(imageRequest);

    }
}
