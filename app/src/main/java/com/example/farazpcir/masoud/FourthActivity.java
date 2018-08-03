package com.example.farazpcir.masoud;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class FourthActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hotel);
        Custom_ViewFlipper custom_viewFlipper=(Custom_ViewFlipper)findViewById(R.id.hotelvf);
        ImageView darvishi1=new ImageView(this);
        darvishi1.setImageResource(R.drawable.darvishi1);
        darvishi1.setScaleType(ImageView.ScaleType.FIT_XY);
        custom_viewFlipper.addView(darvishi1);
        ImageView darvishi2=new ImageView(this);
        darvishi2.setImageResource(R.drawable.davrishi2);
        darvishi2.setScaleType(ImageView.ScaleType.FIT_XY);
        custom_viewFlipper.addView(darvishi2);
        ImageView darvishi3=new ImageView(this);
        darvishi3.setImageResource(R.drawable.darvishi3);
        darvishi3.setScaleType(ImageView.ScaleType.FIT_XY);
        custom_viewFlipper.addView(darvishi3);
        Paint paint = new Paint();
        paint.setColor(ContextCompat.getColor(this,R.color.colorPrimary));
        custom_viewFlipper.setPaintCurrent(paint);

        paint=new Paint();
        paint.setColor(ContextCompat.getColor(this,android.R.color.white));

        custom_viewFlipper.setPaintNormal(paint);
        custom_viewFlipper.setRadius(10);
        custom_viewFlipper.setMargin(5);


    }

}
