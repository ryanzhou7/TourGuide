package com.ryanzhou.company.tourguide;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.ryanzhou.company.tourguide.startupTab.StartupFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the ViewPager and set it's PagerAdapter so that it can display items
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new CategoryFragmentPagerAdapter(getSupportFragmentManager(),
                MainActivity.this, createCategoryFragments()));

        // Give the TabLayout the ViewPager
        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    private List<Fragment> createCategoryFragments(){
        List<Fragment> fragments = new ArrayList<>();
        fragments.add( new StartupFragment() );
        return fragments;
    }

    private class CategoryFragmentPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mCategoryFragments;
        private final String tabTitles[] = new String[]{"Startups", "Restaurants",
                "Activities", "Attractions"};
        final int PAGE_COUNT = tabTitles.length;
        private Context context;

        public CategoryFragmentPagerAdapter(FragmentManager fm, Context context,
                                            List<Fragment> fragments) {
            super(fm);
            this.context = context;
            this.mCategoryFragments = fragments;
        }

        @Override
        public int getCount() {
            return 1;
            //PAGE_COUNT;
        }

        @Override
        public Fragment getItem(int position) {
//            return mCategoryFragments.get(position);
            return mCategoryFragments.get(0);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabTitles[position];
        }
    }
}
