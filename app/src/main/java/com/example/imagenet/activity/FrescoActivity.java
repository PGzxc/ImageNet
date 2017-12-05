package com.example.imagenet.activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.example.imagenet.R;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * author：Admin
 * date：2017/11/2221:41
 * 编程使我快乐
 */

public class FrescoActivity extends AppCompatActivity {
    private SimpleDraweeView sdv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fresco);
        sdv = (SimpleDraweeView) findViewById(R.id.img_fresco);
        Uri uri =  Uri.parse("http://dynamic-image.yesky.com/740x-/uploadImages/2015/163/50/690V3VHW0P77.jpg");
        sdv.setImageURI(uri);
//        DraweeController controller = Fresco.newDraweeControllerBuilder()
//                .setUri(uri)
//                .setAutoPlayAnimations(true)
//                .build();
//        sdv.setController(controller);

        init();

    }

    private void init() {
        //最好放到Applicatio中
        Fresco.initialize(this);

    }
}
