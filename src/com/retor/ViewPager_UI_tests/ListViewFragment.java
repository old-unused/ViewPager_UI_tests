package com.retor.ViewPager_UI_tests;

import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Objects;

/**
 * Created by retor on 28.02.14.
 */
public class ListViewFragment extends ListFragment  {
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Toast.makeText(getActivity(), "position = " + position, Toast.LENGTH_SHORT).show();
    }
}