package com.steven.join_and_join.scratch;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

public class MainActivity extends AppCompatActivity {

    TestView testView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        testView = new TestView(this);
//        setContentView(testView);

        ImageView imageView = (ImageView)findViewById(R.id.img);
        Glide.with(this).load("https://firebasestorage.googleapis.com/v0/b/practice-aa1c4.appspot.com/o/img%2Fcapture.jpg?alt=media&token=9b16fda4-3777-4018-bba7-5f2fd7c0d910").into(imageView);

        WScratchView scratchView = (WScratchView)findViewById(R.id.scratch);
    }
}
