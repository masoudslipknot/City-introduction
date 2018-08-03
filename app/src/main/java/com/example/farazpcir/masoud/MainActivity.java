package com.example.farazpcir.masoud;

import android.content.Intent;
import android.graphics.Paint;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public int whichactivity=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Custom_ViewFlipper flipview=(Custom_ViewFlipper) findViewById(R.id.vf);
        ImageView holly=new ImageView(this);
        holly.setImageResource(R.drawable.holly);
        holly.setScaleType(ImageView.ScaleType.FIT_XY);

        ImageView naderking=new ImageView(this);
        naderking.setImageResource(R.drawable.naderking);
        naderking.setScaleType(ImageView.ScaleType.FIT_XY);
        ImageView arqavandare=new ImageView(this);
        arqavandare.setImageResource(R.drawable.arqhavandare);
        arqavandare.setScaleType(ImageView.ScaleType.FIT_XY);
        ImageView shop=(ImageView)findViewById(R.id.shop);
        ImageView resturany=(ImageView)findViewById(R.id.resturan);
        ImageView abouthotel=(ImageView)findViewById(R.id.hotel);
        Paint paint = new Paint();
        paint.setColor(ContextCompat.getColor(this,R.color.colorPrimary));
        flipview.setPaintCurrent(paint);
        paint = new Paint();

        paint.setColor(ContextCompat.getColor(this,android.R.color.white));
        flipview.setPaintNormal(paint);
        flipview.setRadius(10);
        flipview.setMargin(5);
        TextView txtcentershop=(TextView)findViewById(R.id.shopcenter);
        txtcentershop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                whichactivity=1;
                Intent intent=new Intent(MainActivity.this,SecendActivity.class);
                intent.putExtra("whichone",whichactivity);
                MainActivity.this.startActivity(intent);
            }
        });
        TextView txtres=(TextView)findViewById(R.id.restan);
        txtres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,SecendActivity.class);
                whichactivity=2;
                intent.putExtra("whichone",whichactivity);
                MainActivity.this.startActivity(intent);

            }
        });



        flipview.addView(holly);
        flipview.addView(naderking);
        flipview.addView(arqavandare);
        shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,SecendActivity.class);
                whichactivity=1;
                intent.putExtra("whichone",whichactivity);
                MainActivity.this.startActivity(intent);

            }
        });
        resturany.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,SecendActivity.class);
                whichactivity=2;
                intent.putExtra("whichone",whichactivity);
                MainActivity.this.startActivity(intent);

            }
        });
        abouthotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,FourthActivity.class);
                MainActivity.this.startActivity(intent);

            }
        });
    }
}
