package com.example.mahesh.cardswipe;

import android.animation.ArgbEvaluator;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    ViewPager viewPager;
    Adapter adapter;
    List<Model> models;
    Integer[] colors = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        models = new ArrayList<>();
        models.add(new Model(R.drawable.brochure,"Brochure"," Brochure is information about company"));
        models.add(new Model(R.drawable.sticker,"Sticker","Sticker ........."));
        models.add(new Model(R.drawable.poster,"Poster","Poster is any piece of printed paper....."));
        models.add(new Model(R.drawable.namecard,"Namecard","Business cards are name cards.........."));

        adapter = new Adapter(models, this);

        viewPager = findViewById(R.id.vp);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(130,0,130,0);

        Integer[] colorstemp= {
                getResources().getColor(R.color.color1),
                getResources().getColor(R.color.color2),
                getResources().getColor(R.color.color3),
                getResources().getColor(R.color.color4)
        };

        colors = colorstemp;



        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
                if(i<(adapter.getCount()-1) && i<(colors.length -1)){
                    viewPager.setBackgroundColor(
                            (Integer)argbEvaluator.evaluate(
                                    v,colors[i],
                                    colors[i+1]
                            )
                    );



                }
                else {

                    viewPager.setBackgroundColor(colors[colors.length-1]);
                }
            }

            @Override
            public void onPageSelected(int i) {

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });


    }
}
