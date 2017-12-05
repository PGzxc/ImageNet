package com.example.imagenet.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.imagenet.R;
import com.example.imagenet.data.Data;
import com.nostra13.universalimageloader.cache.disc.naming.HashCodeFileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.decode.BaseImageDecoder;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.nostra13.universalimageloader.utils.StorageUtils;
import java.io.File;

/**
 * author：Admin
 * date：2017/11/2221:01
 * 编程使我快乐
 */

public class UniversalActivity extends AppCompatActivity {

    private ImageView imageView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_universal);
        imageView=findViewById(R.id.img_univer);
        config();
        //1.用法
        //ImageLoader.getInstance().displayImage(Data.data,imageView);
        //2.用法
        ImageLoader.getInstance().displayImage(Data.data, imageView, new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {
                Toast.makeText(UniversalActivity.this,"onLoadingStarted",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                Toast.makeText(UniversalActivity.this,"onLoadingFailed",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                Toast.makeText(UniversalActivity.this,"onLoadingComplete",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLoadingCancelled(String imageUri, View view) {
                Toast.makeText(UniversalActivity.this,"onLoadingCancelled",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void config() {
        //默认
        ImageLoaderConfiguration configuration = ImageLoaderConfiguration.createDefault(this);

        //自定义设置
        /**
         File cacheDir = StorageUtils.getCacheDirectory(getApplicationContext());  //缓存文件夹路径
         ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext())
         .memoryCacheExtraOptions(480, 800) // default = device screen dimensions 内存缓存文件的最大长宽
         .diskCacheExtraOptions(480, 800, null)  // 本地缓存的详细信息(缓存的最大长宽)，最好不要设置这个
         .threadPoolSize(3) // default  线程池内加载的数量
         .threadPriority(Thread.NORM_PRIORITY - 2) // default 设置当前线程的优先级
         .tasksProcessingOrder(QueueProcessingType.FIFO) // default
         .denyCacheImageMultipleSizesInMemory()
         .memoryCache(new LruMemoryCache(2 * 1024 * 1024)) //可以通过自己的内存缓存实现
         .memoryCacheSize(2 * 1024 * 1024)  // 内存缓存的最大值
         .memoryCacheSizePercentage(13) // default
         .diskCacheSize(50 * 1024 * 1024) // 50 Mb sd卡(本地)缓存的最大值
         .diskCacheFileCount(100)  // 可以缓存的文件数量
         // default为使用HASHCODE对UIL进行加密命名， 还可以用MD5(new Md5FileNameGenerator())加密
         .diskCacheFileNameGenerator(new HashCodeFileNameGenerator())
         .imageDownloader(new BaseImageDownloader(getApplicationContext())) // default
         .imageDecoder(new BaseImageDecoder()) // default
         .defaultDisplayImageOptions(DisplayImageOptions.createSimple()) // default
         .writeDebugLogs() // 打印debug log
         .build(); //开始构建
         */
        ImageLoader.getInstance().init(configuration);
    }
}
