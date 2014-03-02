package com.retor.ViewPager_UI_tests;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;
import android.widget.ListView;
import com.astuetz.PagerSlidingTabStrip;

import java.util.ArrayList;


public class HomeActivity extends FragmentActivity {
    /**
     * Called when the activity is first created.
     */
    TestAdapter ta;
    ArrayList<Fragment> fragments;

    ListViewFragment frag1;
    ListViewFragment frag2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        final ActionBar bar = getActionBar();
        ViewPager viewPager = (ViewPager)findViewById(R.id.viewpager);
        PagerSlidingTabStrip pagerSlidingTabStrip = (PagerSlidingTabStrip)findViewById(R.id.tabs);
        pagerSlidingTabStrip.setIndicatorHeight(5);
        pagerSlidingTabStrip.setIndicatorColor(073065);
        pagerSlidingTabStrip.setTextSize(15);
        frag1 = new ListViewFragment();
        frag2 = new ListViewFragment();
        fragments = new ArrayList<Fragment>();

        fragments.add(0, frag1);
        fragments.add(1, frag2);

        ta = new TestAdapter(this, getSupportFragmentManager(), fragments);

        viewPager.setAdapter(ta);
        viewPager.setCurrentItem(0);
        pagerSlidingTabStrip.setViewPager(viewPager);
        //bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        //bar.setDisplayOptions(0, ActionBar.DISPLAY_SHOW_TITLE);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("tab", getActionBar().getSelectedNavigationIndex());
    }

}
