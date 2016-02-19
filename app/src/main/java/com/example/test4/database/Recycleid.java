package com.example.test4.database;

/**
 * Created by bridgelabz4 on 18/2/16.
 */
public class Recycleid {
    private String uid;
    private String id;
    private String title;


    public Recycleid(String userid1,String id1,String title1 ){
        this.setUserid(userid1);

        this.setId(id1);
        this.setTitle(title1);

    }


    public String getUserid() {
        return uid;
    }

    public void setUserid(String userid) {
        this.uid = userid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
