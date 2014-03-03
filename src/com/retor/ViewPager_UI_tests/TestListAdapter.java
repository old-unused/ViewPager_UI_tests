package com.retor.ViewPager_UI_tests;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by retor on 02.03.14.
 */
public class TestListAdapter extends ArrayAdapter<Object> {

    Context context;
    ArrayList<Object> content;
    int res;

    public TestListAdapter(Context _context, int resource, ArrayList<Object> objects) {
        super(_context, resource, objects);
        res = resource;
        context = _context;
        content = new ArrayList<Object>();
        content = objects;
    }

    @Override
    public void add(Object object) {
        content.add(object);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v;
        ViewHolder vh = new ViewHolder();
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null){
            v = inflater.inflate(res,null);
        vh.title = (TextView)v.findViewById(R.id.Title);
        vh.message = (TextView)v.findViewById(R.id.message);
        vh.author = (TextView)v.findViewById(R.id.author);
        vh.date = (TextView)v.findViewById(R.id.date);
        vh.answers = (TextView)v.findViewById(R.id.repcount);
        vh.likes = (TextView)v.findViewById(R.id.likescount);

/*        String title = content.get(position);
        String message = content.get(position);
        String author = content.get(position);
        String date = content.get(position);
        String answers = content.get(position);
        String likes = content.get(position);*/
        }else{
            v = convertView;
        }
        return v;
    }

    @Override
    public Object getItem(int position) {
        return content.get(position);
        //return super.getItem(position);
    }

    @Override
    public int getCount() {
        //return super.getCount();
        return content.size();
    }

    static public class ViewHolder{
        TextView title;
        TextView message;
        TextView author;
        TextView date;
        TextView answers;
        TextView likes;
    }
}

