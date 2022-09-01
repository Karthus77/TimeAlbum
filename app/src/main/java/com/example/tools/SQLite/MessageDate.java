package com.example.tools.SQLite;

import android.app.Application;
import android.content.Context;

public class MessageDate extends Application {
    private Context context;
    private int all_msg;
    private int like_msg;
    private int focus_msg;
    private int collect_msg;
    private int comment_msg;
    public MessageDate(Context context)
    {
        this.context=context;
    }
    public  int getAll_msg(){
        return all_msg;
    }
    public int getLike_msg(){
        return like_msg;
    }
    public int getFocus_msg(){
        return focus_msg;
    }
    public int getCollect_msg(){
        return collect_msg;
    }
    public int getComment_msg(){
        return comment_msg;
    }
    public void setAll_msg(int n) {
        this.all_msg=n;
    }
    public void setLike_msg(int n) {
        this.like_msg=n;
    }
    public void setCollect_msg(int n) {
        this.collect_msg=n;
    }
    public void setFocus_msg(int n) {
        this.focus_msg=n;
    }
    public void setComment_msg(int n) {
        this.comment_msg=n;
    }

}
