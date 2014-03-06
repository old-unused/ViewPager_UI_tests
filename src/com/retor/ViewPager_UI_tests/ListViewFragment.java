package com.retor.ViewPager_UI_tests;

import android.app.Activity;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by retor on 28.02.14.
 */
public class ListViewFragment extends ListFragment  {

    ListFragmentItemClickListener ifaceItemClickListener;
    public interface ListFragmentItemClickListener {
        /** This method will be invoked when an item in the ListFragment is clicked */
        void onListFragmentItemClick(int position);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try{
            /** This statement ensures that the hosting activity implements ListFragmentItemClickListener */
            ifaceItemClickListener = (ListFragmentItemClickListener) activity;
        }catch(Exception e){
            Toast.makeText(activity.getBaseContext(), "Exception", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {

        /** Invokes the implementation of the method onListFragmentItemClick in the hosting activity */
        ifaceItemClickListener.onListFragmentItemClick(position);

    }
    //    public void onListItemClick(ListView l, View v, int position, long id) {
//        super.onListItemClick(l, v, position, id);
//
//        l.getItemAtPosition(position);
//        Toast.makeText(getActivity(), "position = " + position, Toast.LENGTH_SHORT).show();
//    }
}