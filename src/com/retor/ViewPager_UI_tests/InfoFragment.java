package com.retor.ViewPager_UI_tests;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Антон on 06.03.14.
 */
public class InfoFragment extends Fragment {
    int position;

    public InfoFragment(int _position) {
        position = _position;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        inflater.inflate(R.layout.infofragment, null);
        return super.onCreateView(inflater, container, savedInstanceState);

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
