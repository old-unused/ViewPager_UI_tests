package com.retor.ViewPager_UI_tests;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import static com.perm.kate.api.Auth.*;

/**
 * Created by retor on 03.03.14.
 */
public class AuthDialog extends DialogFragment implements View.OnClickListener {
    WebView wv;
    Button no;
    Activity activity;
    Account account = new Account();
    FragmentManager fm;

    public AuthDialog(Activity _activity, FragmentManager _fm){
        activity = _activity;
        fm = _fm;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        return super.onCreateDialog(savedInstanceState);
    }

    @Override
    public void onCancel(DialogInterface dialog) {
        super.onCancel(dialog);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getDialog().setTitle("VK auth");
        View v = inflater.inflate(R.layout.auth_dialog, null);
        no = (Button)v.findViewById(R.id.nothanks);
        no.setOnClickListener(this);
        wv = (WebView)v.findViewById(R.id.authwv);
        String url= getUrl(Cons.API_ID, getSettings());
        wv.loadUrl(url);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.clearCache(true);
        wv.setWebViewClient(new VkontakteWebViewClient());
        return v;
    }

    @Override
    public void onClick(View v) {
        this.dismiss();
    }
    class VkontakteWebViewClient extends WebViewClient {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            parseUrl(url);
        }
    }

    private void parseUrl(String url) {
        try {
            if(url==null)
                return;
            if(url.startsWith(redirect_url))
            {
                if(!url.contains("error=")){
                    String[] auth= parseRedirectUrl(url);
                    account.user_id = Long.parseLong(auth[1]);
                    account.access_token = auth[0];
                    account.save(activity.getApplicationContext());
                    this.dismiss();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
