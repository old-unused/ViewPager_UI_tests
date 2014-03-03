package com.retor.ViewPager_UI_tests;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by retor on 03.03.14.
 */
public class WallContainer implements Serializable {
    private String message;
    private String author;
    private String date;
    private long id;
    private long commentsCount;
    private ArrayList<CommentContainer> comments;
    private int commentsSize;

    public WallContainer(String _message, String _author, String _date, long _id, long _commentsCount, ArrayList<CommentContainer> _comments){
        setMessage(_message);
        setAuthor(_author);
        setDate(_date);
        setId(_id);
        setCommentsCount(_commentsCount);
        comments = new ArrayList<CommentContainer>();
        setComments(_comments);
        commentsSize = comments.size();
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String _message) {
        message = _message;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String _author) {
        author = _author;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String _date) {
        date = date;
    }
    public long getId() {
        return id;
    }
    public void setId(long _id) {
        id = id;
    }
    public long getCommentsCount() {
        return commentsCount;
    }
    public void setCommentsCount(long _commentsCount) {
        commentsCount = _commentsCount;
    }
    public ArrayList<CommentContainer> getComments() {
        return comments;
    }
    public void setComments(ArrayList<CommentContainer> _comments) {
        comments =new ArrayList<CommentContainer>();
        comments = _comments;
    }
    public int getCommentsSize() {
        return commentsSize;
    }
}
