package com.retor.ViewPager_UI_tests;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by retor on 02.03.14.
 */
public class TestListAdapter extends BaseAdapter{

    Context context;
    ArrayList<WallContainer> content;
    int res;

    public TestListAdapter(Context _context, int resource, ArrayList<WallContainer> objects) {
        //super(_context, resource, objects);
        res = resource;
        context = _context;
        content = new ArrayList<WallContainer>();
        content = objects;
    }


    public void add(WallContainer object) {
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

        String title = String.valueOf(content.get(position).getCommentsSize());
        String message = content.get(position).getMessage();
        String author = content.get(position).getAuthor();
        String date = content.get(position).getDate();
        String answers = String.valueOf(content.get(position).getCommentsCount());
        String likes = String.valueOf(content.get(position).getId());

            vh.message.setText(message);
            vh.author.setText(author);
            vh.date.setText(date);
            vh.answers.setText(answers);
            vh.likes.setText(likes);
            vh.title.setText(title);
        }else{
            v = convertView;
        }
        return v;
    }

    @Override
    public WallContainer getItem(int position) {
        return content.get(position);
        //return super.getItem(position);
    }

    /**
     * Get the row id associated with the specified position in the list.
     *
     * @param position The position of the item within the adapter's data set whose row id we want.
     * @return The id of the item at the specified position.
     */
    @Override
    public long getItemId(int position) {
        return content.get(position).getId();
        //return 0;
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

