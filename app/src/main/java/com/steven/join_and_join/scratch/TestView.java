package com.steven.join_and_join.scratch;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

public class TestView extends View {

    private String TAG = "TestView";

    Paint mPenPaint;
    Paint mTransPaint;

    PorterDuffXfermode clear = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);

    Bitmap mBitmap1;
    Canvas mCanvas1;

    Bitmap mBitmap2;
    Canvas mCanvas2;

    float x;
    float y;

    int arr[];
    int wi, he;

    Path mPath = new Path();

    public TestView(Context context) {
        super(context);

        this.mPenPaint = new Paint(Paint.DEV_KERN_TEXT_FLAG);
        this.mPenPaint.setAntiAlias(true);
        this.mPenPaint.setColor(Color.BLUE);
        this.mPenPaint.setStrokeWidth(5f);
        this.mPenPaint.setStyle(Paint.Style.STROKE);

        this.mTransPaint = new Paint(Paint.DEV_KERN_TEXT_FLAG);
        this.mTransPaint.setAntiAlias(true);
        this.mTransPaint.setColor(Color.TRANSPARENT);
        this.mTransPaint.setStrokeWidth(5f);
        this.mTransPaint.setStyle(Paint.Style.STROKE);

        mPath = new Path();



        Log.d(TAG, "TestView");
    }
//
//    @Override
//    public void onWindowFocusChanged(boolean hasWindowFocus) {
//        super.onWindowFocusChanged(hasWindowFocus);
//
//        Log.d(TAG, "onWindowFocusChanged");
//
//    }

    @Override
    protected void onSizeChanged(final int w, final int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        arr = new int[w * h];
wi = w;
he = h;

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPurgeable = true;
        Bitmap temp = BitmapFactory.decodeResource(getResources(), R.drawable.img2, options);
        mBitmap2 = Bitmap.createScaledBitmap(temp, w, h, true); // 위에 있는 애
//        mBitmap2.getPixels(arr, 0, 30, 0, 0, 30, 30);
//        for (int i = 0; i < arr
//                .length; i++) {
//            Log.d("pixelarr", "arr["+i+"] : " + arr[i]);
//        }
//        mBitmap2 = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);

//        mCanvas1 = new Canvas(mBitmap1);
//        mCanvas2 = new Canvas(mBitmap2);
        Glide.with(getContext()).load("https://firebasestorage.googleapis.com/v0/b/practice-aa1c4.appspot.com/o/img%2Fcapture.jpg?alt=media&token=9b16fda4-3777-4018-bba7-5f2fd7c0d910").asBitmap().into(new SimpleTarget<Bitmap>() {
            @Override
            public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                mBitmap1 = Bitmap.createScaledBitmap(resource, getWidth(), getHeight(), true);
                invalidate();

            }
        });
        Log.d(TAG, "onSizeChanged");
        Log.d(TAG, "onSizeChanged w : " + w);
        Log.d(TAG, "onSizeChanged h : " + h);
        Log.d(TAG, "onSizeChanged getw : " + getWidth());
        Log.d(TAG, "onSizeChanged geth : " + getHeight());
        Log.d(TAG, "onSizeChanged oldw : " + oldw);
        Log.d(TAG, "onSizeChanged oldh : " + oldh);
    }


    public void setToPen() {
        mPenPaint.setXfermode(null);
    }

    public void setToEraser() {
        mPenPaint.setXfermode(clear);
    }


    @Override
    protected void onDraw(Canvas canvas) {

        super.onDraw(canvas);
//        canvas.drawBitmap(mBitmap2,0,0, mPenPaint);
        canvas.drawBitmap(mBitmap1,0,0, mPenPaint);
//        canvas.drawPath(mPath,mTransPaint);

        Log.d(TAG, "onDraw");
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN) {


            return true;
        }else if(event.getAction() == MotionEvent.ACTION_MOVE) {

        }else if(event.getAction() == MotionEvent.ACTION_UP) {
//
        }
        return super.onTouchEvent(event);
    }
}
