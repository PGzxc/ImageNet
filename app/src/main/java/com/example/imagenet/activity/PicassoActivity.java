package com.example.imagenet.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.example.imagenet.R;
import com.example.imagenet.data.Data;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

/**
 * Created by admin on 2017/12/5.
 */

public class PicassoActivity extends AppCompatActivity {
    private ImageView imagePicasso;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picasso);
        initView();
        initData();
    }


    private void initView() {
        imagePicasso = findViewById(R.id.image_picasso);
    }

    private void initData() {
        //1.默认用法
        //Picasso.with(this).load(Data.data).into(imagePicasso);

        //2.图片转换：转换图片以适应布局大小并减少内存占用
        /**
         Picasso.with(this)
         .load(Data.data)
         .resize(50, 50)
         .centerCrop()
         .into(imagePicasso);
         */
        //3.自定义转换
        //Picasso.with(this).load(Data.data).transform(new CropSquareTransformation()).into(imagePicasso);
        //4.Place holders-空白或者错误占位图片：picasso提供了两种占位图片，未加载完成或者加载发生错误的时需要一张图片作为提示
        //Picasso.with(this).load(Data.data).placeholder(R.drawable.ic_default_adimage).error(R.drawable.ic_default_adimage).into(imagePicasso);
        //资源文件的加载：除了加载网络图片picasso还支持加载Resources, assets, files, content providers中的资源文件
        Picasso.with(this).load(R.drawable.ic_default_adimage).into(imagePicasso);
    }

    public class CropSquareTransformation implements Transformation {
        @Override
        public Bitmap transform(Bitmap source) {
            int size = Math.min(source.getWidth(), source.getHeight());
            int x = (source.getWidth() - size) / 2;
            int y = (source.getHeight() - size) / 2;
            Bitmap result = Bitmap.createBitmap(source, x, y, size, size);
            if (result != source) {
                source.recycle();
            }
            return result;
        }

        @Override
        public String key() {
            return "square()";
        }
    }
}
