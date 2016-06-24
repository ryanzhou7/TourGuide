package com.ryanzhou.company.tourguide;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.ryanzhou.company.tourguide.genericTab.GenericListFragment;
import com.ryanzhou.company.tourguide.model.Startup;
import com.ryanzhou.company.tourguide.startupTab.StartupFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements StartupFragment.OnListFragmentInteractionListener,
        GenericListFragment.OnFragmentInteractionListener {

    private final int NUM_RECYLER_COLUMNS = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new CategoryFragmentPagerAdapter(getSupportFragmentManager(), createCategoryFragments()));

        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL); //distribute tabs across

    }

    private List<Fragment> createCategoryFragments() {
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(StartupFragment.newInstance(NUM_RECYLER_COLUMNS));
        fragments.add(GenericListFragment.newInstance(R.array.restaurants_array));
        fragments.add(GenericListFragment.newInstance(R.array.attractions_array));
        fragments.add(GenericListFragment.newInstance(R.array.museums_array));
        return fragments;
    }

    @Override
    public void onClickStartup(Startup item) {
        Toast.makeText(this, "Show more info about " + item.getName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClickItemWithname(String itemName) {
        Toast.makeText(this, "Show more info about " + itemName, Toast.LENGTH_SHORT).show();
    }

    private class CategoryFragmentPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mCategoryFragments;
        private final String tabTitles[] = new String[]{"Startups", "Restaurants",
                "Activities", "Attractions"};
        final int PAGE_COUNT = tabTitles.length;

        public CategoryFragmentPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
            super(fm);
            this.mCategoryFragments = fragments;
        }

        @Override
        public int getCount() {
            return PAGE_COUNT;
        }

        @Override
        public Fragment getItem(int position) {
            return mCategoryFragments.get(position);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabTitles[position];
        }
    }
}
