package com.retor.ViewPager_UI_tests;

import java.io.Serializable;

/**
 * Created by retor on 03.03.14.
 */
public class CommentContainer implements Serializable {
    private String message;
    private String author;
    private String date;
    private String pic;
    private long tid;


    public CommentContainer(String _message, String _author, String _date, long _tid){
        setMessage(_message);
        setAuthor(_author);
        setDate(_date);
        setTid(_tid);
    }

    public CommentContainer(String _message, String _author, String _date, long _tid, String _pic){
        setMessage(_message);
        setAuthor(_author);
        setDate(_date);
        setPic(_pic);
        setTid(_tid);
    }

    public void setMessage(String _title){
        message=_title;
    }
    public void setAuthor(String _author){
        author=_author;
    }
    public String getMessage(){
        return message.toString();
    }
    public String getAuthor(){
        return author.toString();
    }
    public void setDate(String _date){
        date = _date;
    }
    public String getDate(){
        return date.toString();
    }
    public void setPic(String _url){
        pic = _url;
    }
    public String getPic(){
        return pic.toString();
    }
    public void setTid(long _tid) {
        tid = _tid;
    }
    public long getTid() {

        return tid;
    }
}
