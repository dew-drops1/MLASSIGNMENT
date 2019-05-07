package com.example.f_contact;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

public class Gallery extends AppCompatActivity {

    ImageSwitcher imageSwitcher;
    Button btnPrevious, btnNext;
    int[] LOGO = {
            R.drawable.bg6,
            R.drawable.a,
            R.drawable.b,
            R.drawable.c,
            R.drawable.d,
            R.drawable.e,
            R.drawable.f,
            R.drawable.g,
            R.drawable.h,
            R.drawable.i,
            R.drawable.j,
            R.drawable.k,
            R.drawable.l,
            R.drawable.m,
            R.drawable.n,
            R.drawable.o,R.drawable.sa,R.drawable.sb,R.drawable.sc,R.drawable.sd,R.drawable.se,R.drawable.sf,R.drawable.sg,

    };
    int currentIndex = -1;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        btnPrevious = (Button) findViewById(R.id.btnPrevious);
        btnNext = (Button) findViewById(R.id.btnNext);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.btnNext:
                        if (currentIndex < LOGO.length - 1) {
                            currentIndex = currentIndex + 1;
                            imageSwitcher.setBackgroundResource(LOGO[currentIndex]);
                        }
                        break;


                   /*case R.id.btnPrevious:
                        if (currentIndex > 0) {
                            currentIndex = currentIndex - 1;
                            imageSwitcher.setBackgroundResource(LOGO[currentIndex]);
                        }
                        break;*/
                }
            }
        });
        btnPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.btnPrevious:
                        if (currentIndex > 0) {
                            currentIndex = currentIndex - 1;
                            imageSwitcher.setBackgroundResource(LOGO[currentIndex]);
                        }
                        break;
                }
            }
        });

      //  btnPrevious.setOnClickListener(this);

        imageSwitcher = (ImageSwitcher) findViewById(R.id.imageSwitcher);

        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView image = new ImageView(getApplicationContext());
                image.setScaleType(ImageView.ScaleType.FIT_CENTER);
                image.setLayoutParams(new ImageSwitcher.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,ActionBar.LayoutParams.WRAP_CONTENT));
                return image;
            }
        });

    }


    }
