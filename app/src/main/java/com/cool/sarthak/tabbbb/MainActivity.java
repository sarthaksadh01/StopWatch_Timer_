package com.cool.sarthak.tabbbb;

import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private SectionPageAdapter mSectionPageAdapter;
    private ViewPager viewPager;
//    private tab2 x;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        x.runTimer();
        mSectionPageAdapter=new SectionPageAdapter(getSupportFragmentManager());
        viewPager=findViewById(R.id.container);
setupViewPager(viewPager);
        TabLayout tabLayout =findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

    }
    public void setupViewPager(ViewPager viewPager)
    {
      SectionPageAdapter adapter =new SectionPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new tab4(),"Timer");
        adapter.addFragment(new tab2(),"StopWatch");
        //adapter.addFragment(new tab3(),"tab3");

        viewPager.setAdapter(adapter);
    }
}
