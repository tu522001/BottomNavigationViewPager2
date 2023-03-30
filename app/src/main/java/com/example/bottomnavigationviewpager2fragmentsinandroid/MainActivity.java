package com.example.bottomnavigationviewpager2fragmentsinandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 mViewPager2;
    private BottomNavigationView mbottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager2 = findViewById(R.id.view_page_2);
        mbottomNavigationView = findViewById(R.id.bottom_navigation);

        MyViewPager2Adapter adapter = new MyViewPager2Adapter(this);
        mViewPager2.setAdapter(adapter);

        mViewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);

                switch (position){
                    case 0: mbottomNavigationView.getMenu().findItem(R.id.menu_home).setChecked(true);
                    break;

                    case 1: mbottomNavigationView.getMenu().findItem(R.id.menu_setting).setChecked(true);
                    break;

                    case 2: mbottomNavigationView.getMenu().findItem(R.id.menu_cellular).setChecked(true);
                        break;
                }
            }
        });

        mbottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menu_home:
                        mViewPager2.setCurrentItem(0);
                        break;

                    case R.id.menu_setting:
                        mViewPager2.setCurrentItem(1);
                        break;

                    case R.id.menu_cellular:
                        mViewPager2.setCurrentItem(2);
                        break;
                }
                return true;
            }
        });
    }
}