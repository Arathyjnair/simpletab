package com.example.user.simpletab;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private android.support.v7.widget.Toolbar toolbar;
    private TabLayout tablayout;
    private ViewPager viewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar= findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        //to come the arrow in the actionbar like(<-)
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//white screen
        viewpager=(ViewPager) findViewById(R.id.view_pager);
        setupViewPager(viewpager);

        tablayout=(TabLayout) findViewById(R.id.tab_layout);
        tablayout.setupWithViewPager(viewpager);

    }


    private void setupViewPager(ViewPager viewpager)
    {
        ViewPagerAdapter adapter=new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new oneFragment(),"ONE");
        adapter.addFragment(new TwoFragment(),"TWO");
        adapter.addFragment(new ThreeFragment(),"THREE");

        viewpager.setAdapter(adapter);
    }
class  ViewPagerAdapter extends FragmentPagerAdapter
{
    //LIST FOR FRAGMENTS
    private final List<Fragment> mFragmentList = new ArrayList<>();
    //TITLE FOR FRAGMENT
    private final List<String> mFragmentTitleList = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return mFragmentList.get(i);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }
    public void addFragment(Fragment fragment,String title)
    {
        mFragmentList.add(fragment);
        mFragmentTitleList.add(title);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitleList.get(position);
    }
}
}
