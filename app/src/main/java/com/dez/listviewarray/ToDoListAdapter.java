package com.dez.listviewarray;

import android.app.Activity;

import android.content.Context;

import android.view.LayoutInflater;

import android.view.View;

import android.view.ViewGroup;

import android.widget.ArrayAdapter;

import android.widget.TextView;

/**
 * Created by danne on 9/27/2017.
 */

public class ToDoListAdapter  extends ArrayAdapter<ToDoItem>{

    Context context;

    public ToDoListAdapter(Context context, int resource){

        super(context, resource);
        this.context = context;

    }

        @Override
    public View getView(int position, View convertView, ViewGroup parent){

        View rowView = convertView;

        if(rowView ==null){
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            rowView = inflater.inflate(R.layout.todo_list_item, parent, false);
        }
        //Get the correct ToDoItem
        ToDoItem item = getItem(position);

//Find the UI elements in the view

        TextView todoText = (TextView) rowView.findViewById(R.id.todo_item_text);
        TextView todoDate = (TextView) rowView.findViewById(R.id.todo_item_created_date);


        //And set their values
        todoText.setText(item.getText());
        todoDate.setText(item.getCreated().toString());

        //Return the row, to be displayed in the ListView.

        return rowView;



    }

}
