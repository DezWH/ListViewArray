package com.dez.listviewarray;

import java.util.Date;

/**
 * Created by danne on 9/27/2017.
 */

public class ToDoItem {
    private String text;
    private Date created;

    public ToDoItem(String text){
        this.text = text;
        this.created = new Date(); // Defaults to right now

    }
    public Date getCreated(){
        return created;

    }
    public String getText(){
        return text;

    }
}
