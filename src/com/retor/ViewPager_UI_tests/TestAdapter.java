package com.retor.ViewPager_UI_tests;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by retor on 01.03.14.
 */
public class TestAdapter extends FragmentPagerAdapter {
    Context context;
    FragmentManager fm;
    ArrayList<Fragment> fragments;

    public TestAdapter(Context _context, FragmentManager _fm, ArrayList<Fragment> _fragments){
        super(_fm);
        context = _context;
        fm = _fm;
        fragments = new ArrayList<Fragment>();
        fragments = _fragments;
    }

    public TestAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return fragments.get(i);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Title One";
            case 1:
                return "Title Two";
            default:
                return null;
        }
    }

}