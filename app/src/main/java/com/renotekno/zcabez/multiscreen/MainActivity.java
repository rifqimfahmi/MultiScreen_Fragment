package com.renotekno.zcabez.multiscreen;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import com.renotekno.zcabez.multiscreen.adapter.MiwokViewPagerAdapter;

public class MainActivity extends AppCompatActivity {


    private ViewPager viewPager;
    MiwokViewPagerAdapter miwokViewPagerAdapter = new MiwokViewPagerAdapter(getSupportFragmentManager());
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getSupportActionBar() != null){
            getSupportActionBar().setElevation(0);
        }
        initView();

        viewPager.setAdapter(miwokViewPagerAdapter);

        tabLayout.setupWithViewPager(viewPager);
    }

    private void initView() {
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
    }
}
