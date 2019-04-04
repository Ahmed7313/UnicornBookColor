package com.example.unicornbookcolor;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.Queue;

public class FastImageTry extends AppCompatActivity {

    private RelativeLayout dashBoard;
    private ImageView unicornImage;
    private Bitmap bitmap;
    private ImageView redColor, blueColor, greenColor, blackColor, purpleColor;

    private int choosedColor = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fast_image_try);

        dashBoard = findViewById(R.id.unicorn_view);
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.unicorn_2);
        unicornImage = findViewById(R.id.unicorn_image_fast);

        redColor = findViewById(R.id.color_red);
        redColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choosedColor = Color.RED;
                Toast.makeText(FastImageTry.this, "Red color choosed", Toast.LENGTH_SHORT).show();
            }
        });

        blueColor = findViewById(R.id.color_blue);
        blueColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choosedColor = Color.BLUE;
                Toast.makeText(FastImageTry.this, "Blue color choosed", Toast.LENGTH_SHORT).show();
            }
        });

        unicornImage.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int x =(int) event.getX();
                int y = (int) event.getY();

                final Point p1 = new Point();
                p1.x= x; //x co-ordinate where the user touches on the screen
                p1.y= y; //y co-ordinate where the user touches on the screen

                FloodFill f= new FloodFill();
                final int targetColor = bitmap.getPixel((int) x, (int) y);
                f.floodFill(bitmap,p1,targetColor,choosedColor);
                return true;
            }
        });

    }
}



