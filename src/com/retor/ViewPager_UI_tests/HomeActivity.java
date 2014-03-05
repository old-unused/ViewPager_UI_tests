package com.retor.ViewPager_UI_tests;

import android.app.ActionBar;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.util.Log;
import com.astuetz.PagerSlidingTabStrip;
import com.perm.kate.api.Api;
import com.perm.kate.api.Group;
import com.perm.kate.api.KException;
import com.perm.kate.api.User;
import org.json.JSONException;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class HomeActivity extends FragmentActivity {
    /**
     * Called when the activity is first created.
     */
    TestAdapter ta;
    ArrayList<Fragment> fragments;
    ListViewFragment frag1;
    ListViewFragment frag2;
    TestListAdapter adapter;
    //vk
    Api api;
    Account account = new Account();
    AuthorContainer auth;
    ArrayList<com.perm.kate.api.WallMessage> wallMessagesVK;
    ArrayList<WallContainer> wall = new ArrayList<WallContainer>();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        final ActionBar bar = getActionBar();
        ViewPager viewPager = (ViewPager)findViewById(R.id.viewpager);
        PagerSlidingTabStrip pagerSlidingTabStrip = (PagerSlidingTabStrip)findViewById(R.id.tabs);
        adapter = new TestListAdapter(this, R.layout.fragment, wall);
        account.restore(this);
        Log.i("Restored", String.valueOf(account.user_id));
//        if(account.access_token == null){
//            showAuthDialog();
//        }else{
            api=new Api(account.access_token, Cons.API_ID);
            BackThread bt = new BackThread();
            bt.execute();
//        }

        frag1 = new ListViewFragment();
        frag2 = new ListViewFragment();
        fragments = new ArrayList<Fragment>();

        fragments.add(0, frag1);
        fragments.add(1, frag2);

        ta = new TestAdapter(this, getSupportFragmentManager(), fragments);

        viewPager.setAdapter(ta);
        viewPager.setCurrentItem(0);
        pagerSlidingTabStrip.setViewPager(viewPager);
        bar.setDisplayOptions(0, ActionBar.DISPLAY_SHOW_TITLE);

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("tab", getActionBar().getSelectedNavigationIndex());
    }

    private void showAuthDialog() {
        FragmentManager fm = getSupportFragmentManager();
        AuthDialog authDialog = new AuthDialog(this, getSupportFragmentManager());
        authDialog.show(fm, "authorization");
    }
    private class BackThread extends AsyncTask<ArrayList<WallContainer>, Void, ArrayList<WallContainer>> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected ArrayList<WallContainer> doInBackground(ArrayList<WallContainer>... params) {
            wallMessagesVK = new ArrayList<com.perm.kate.api.WallMessage>();
            try {
                wallMessagesVK = api.getWallMessages(Long.valueOf(Cons.groupIdw), 10, 0, "all");
                if (wallMessagesVK.size()!=0){
                    String message;
                    String author;
                    String date;
                    long id;
                    long commentsCount;
                    for (int i=0; i<wallMessagesVK.size(); i++){
                        authorInf(wallMessagesVK.get(i).from_id);//new Author();
                        message = wallMessagesVK.get(i).text.toString();
                        author = auth.getName();
                        date = dataConvert(wallMessagesVK.get(i).date);
                        id = auth.getId();
                        commentsCount = wallMessagesVK.get(i).comment_count;
                        WallContainer wm = new WallContainer(message,author,date,id,commentsCount);
                        wall.add(i, wm);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (KException e) {
                e.printStackTrace();
            }
            return wall;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(ArrayList<WallContainer> aVoid) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    frag1.setListAdapter(adapter);
                }
            });
            super.onPostExecute(aVoid);
        }
    }

    public AuthorContainer authorInf(long authorId) throws JSONException, IOException, KException {
        String autId="";
        if (authorId<0){
            String tm = String.valueOf(authorId);
            char t = tm.charAt(0);
            if (t == '-'){
                tm = tm.substring(1);
                ArrayList<Long> id = new ArrayList<Long>();
                id.add(Long.valueOf(tm));
                ArrayList<Group> grt = api.getGroups(id,null,null);
                if (grt.size()!=0){
                    auth = new AuthorContainer(grt.get(0).name.toString(), (int)grt.get(0).gid, grt.get(0).photo_medium);
                /*auth.setName();
                auth.setId((int)grt.get(0).gid);
                auth.setPicture(grt.get(0).photo_medium);*/
                }
            }
        }else{
            autId = String.valueOf(authorId);
            ArrayList<User> user = api.searchUserExtended(autId, "photo_100", null, null, null,
                    null, null, null, null, null, null,
                    null, null, null, null, null, null, null,
                    null, null, null, null, null, null,
                    null, null, null, null, null);
            auth = new AuthorContainer(user.get(0).first_name, user.get(0).last_name, (int)user.get(0).uid, user.get(0).photo_medium_rec.toString());
/*            auth.setName(user.get(0).first_name + " " + user.get(0).last_name);
            auth.setId((int)user.get(0).uid);
            auth.setPicture(user.get(0).photo_medium_rec.toString());*/
        }

        return auth;
    }
    public String dataConvert(long dataString){
        long temp = dataString*1000;// its need to be in milisecond
        Date data = new java.util.Date(temp);
        String dataStr = new SimpleDateFormat("dd.MM.yyyy").format(data);
        return dataStr;
    }
}
