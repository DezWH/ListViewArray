/*
Chapt 5
Programmer: D.W.H.
Date September 17, 2017
Purpose:

 */


package com.dez.listviewarray;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> todoListItems = new ArrayList<String>();

    final static String TAG = "MainActivity";

    //Create ArrayAdapter
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button addNewButton = (Button) findViewById(R.id.new_todo_item_button);
        final EditText newToDoText = (EditText) findViewById(R.id.new_todo_item_edittext);


        //Create an ArrayAdapter. Note generic type ,String> used
        //Aruguments are Context, a TexView's resource ID, a list
        //Get a refernce to the ListView
        ListView todoListView= (ListView) findViewById(R.id.todo_listview);


        final ToDoListAdapter todoListAdapter = new ToDoListAdapter(this, R.layout.todo_list_item);


        //Configure the ListView to use this Adapter for data


        //Add listner to the button, to add items to the ListView
        addNewButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                //read whatever user has typed into newToDoEditText
                String newItemText = newToDoText.getText().toString();

                //Make sure some data was entered. Show error Toast and return if not
                if (newItemText.length() == 0) {
                    Toast.makeText(MainActivity.this, "Enter a todo item", Toast.LENGTH_SHORT).show();
                    return;

                }
                //Else, create a new ToDo Item from the text, and add the ArrayAdapter

                todoListAdapter.add(new ToDoItem(newItemText));

                //And notify the ArrayAdapter that the data set has changed, to request UI update
                todoListAdapter.notifyDataSetChanged();

                //Clear EditText, ready to type in next item
                newToDoText.getText().clear();

            }
        });


       //Create ArrayAdapter, with the todoListItem Array List as the d

        //Create Adapter: provide Conxtext (Typrically this Activity), a layout file, and textView
        //ArrayAdapter <String> arrayAdapter =
                //new ArrayAdapter<String>(this, R.layout.todo_list_item, R.id.todo_item, todoListItems);

      todoListView.setAdapter(todoListAdapter);


        //Add listener to the button, to add items to the ListView
        addNewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Read whatever user has typed into newToDoEditText
                String newItemText = newToDoText.getText().toString();


            //Make sure some data was enterdd.
            if (newItemText.length() == 0) {
                    Toast.makeText(MainActivity.this, "Enter a todo item", Toast.LENGTH_SHORT).show();
                    return;
                }

                //Else add the String to the ArrayList
                ToDoItem newItem = new ToDoItem(newItemText);
                todoListAdapter.add(newItem);

            //And notify the ArrayAdapter that the data set has changed, to request UI
                todoListAdapter.notifyDataSetChanged();

            //Clear Edittext, ready to type i next item
                newToDoText.getText().clear();
            }
        });

        //This Listner responds to long presses on indvidiual list items
        todoListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){


        //Remove the item at postion in ArrayList, but fist ask user if they are sure
        @Override
        public boolean onItemLongClick (AdapterView < ? > parent, View view,int position, long id){
        Log.d(TAG, "On ling click listern");
        final int indexPosition = position; //copy position clicked into final
        final ToDoItem item = todoListAdapter.getItem(position);

        AlertDialog areYouSureDialog = new AlertDialog.Builder(MainActivity.this)
                .setTitle("Delete this item?")
                .setMessage(item.getText())
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Remove the item at position in ArrayList
                        todoListItems.remove(indexPosition);
                        //And notify Adapter of changes
                        todoListAdapter.notifyDataSetChanged();
                    }
                }).

        setNegativeButton(android.R.string.no, null) /*no listener needed, if user presses this button the dialog */
                .create();

        areYouSureDialog.show();

        return true;//Does this event handler completely handle this event?

//Would return false if you wanted this event to then be passed onto other listeners that may receive this event

                    }
                    });
            }
}


