package com.retor.ViewPager_UI_tests;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;


public class HomeActivity extends FragmentActivity {
    /**
     * Called when the activity is first created.
     */
    ViewPager viewPager;
    MyPageAdapter myPageAdapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewPager = new ViewPager(this);
        viewPager.setId(R.id.viewpager);
        viewPager.setAdapter(myPageAdapter);
        setContentView(viewPager);

        final ActionBar bar = getActionBar();
        bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        bar.setDisplayOptions(0, ActionBar.DISPLAY_SHOW_TITLE);

        myPageAdapter = new MyPageAdapter(this.getSupportFragmentManager(), this, viewPager);
        myPageAdapter.addTab(bar.newTab().setText("Simple"),ListViewFragment.class, null);
        myPageAdapter.addTab(bar.newTab().setText("Second"),ListViewFragment.class, null);
/*        myPageAdapter.addTab(bar.newTab().setText("List"),
                FragmentPagerSupport.ArrayListFragment.class, null);
        mTabsAdapter.addTab(bar.newTab().setText("Cursor"),
                CursorFragment.class, null);*/

        if (savedInstanceState != null) {
            bar.setSelectedNavigationItem(savedInstanceState.getInt("tab", 0));
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("tab", getActionBar().getSelectedNavigationIndex());
    }

}
