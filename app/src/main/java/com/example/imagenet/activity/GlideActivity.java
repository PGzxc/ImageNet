package com.example.imagenet.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.imagenet.R;
import com.example.imagenet.data.Data;

/**
 * author：Admin
 * date：2017/11/2219:58
 * 编程使我快乐
 */

public class GlideActivity extends AppCompatActivity {

    private ImageView imageView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide);
        imageView=findViewById(R.id.image);

      setData();

    }

    private void setData() {
        //1.网络加载图片到ImageView中
        //Glide.with(this).load(Data.data).into(imageView);
        //2.当加载网络图片时，由于加载过程中图片未能及时显示，此时可能需要设置等待时的图片，通过placeHolder()方法
        //Glide.with(this).load(Data.data).placeholder(R.mipmap.ic_launcher).into(imageView);
        //3.当加载图片失败时，通过error(Drawable drawable)方法设置加载失败后的图片显示
        //Glide.with(this).load(Data.data).error(R.mipmap.ic_launcher).into(imageView);
        //4.图片的缩放，centerCrop()和fitCenter()：
         //4.1 使用centerCrop是利用图片图填充ImageView设置的大小，如果ImageView的Height是match_parent则图片就会被拉伸填充
        //Glide.with(this).load(Data.data).centerCrop().into(imageView);
         //4.2 使用fitCenter即缩放图像让图像都测量出来等于或小于 ImageView 的边界范围,该图像将会完全显示，但可能不会填满整个ImageView。
         //Glide.with(this).load(Data.data).fitCenter().into(imageView);
        //5.示gif动画,asGif()判断是否是gif动画
        Glide.with(this).load(Data.gif).asGif().into(imageView);
        //6.显示本地视频
        //String filePath = "/storage/emulated/0/Downloads/a.mp4";
        //Glide.with( this ).load(Uri.parse(Data.video)).into(imageView);

        //7.缓存策略
        //Glide.with(this).load(Data.data).skipMemoryCache(true).into(imageView);//跳过内存缓存
        //Glide.with(this).load(Data.data).diskCacheStrategy(DiskCacheStrategy.NONE).into(imageView);//跳过硬盘缓存
        //8.优先级，设置图片加载的顺序
        //Glide.with(this).load(Data.data).priority( Priority.HIGH).into( imageView);


    }
}
