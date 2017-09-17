/*
Chapt 5
Programmer: D.W.H.
Date September 17, 2017
Purpose:

 */


package com.dez.listviewarray;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> todoListItems = new ArrayList<String>();

    //Create ArrayAdapter
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addNewButton = (Button) findViewById(R.id.new_todo_item_button)
        final EditText newToDoText = (EditText) findViewById(R.id.new_todo_item)_edittexst);


        //Get a refernce to the ListView
        ListView todoListView= (ListView) findViewById(R.id.listview_arraylist);

       //Create ArrayAdapter, with the todoListItem Array List as the d

        //Create Adapter: provide Conxtext (Typrically this Activity), a layout file, and textView
        <ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(this, R.layout.todo_list_item, R.id.todo_item, todoListItems);

      todoListview.setAdapter(todoListAdapter);


        //add listener to the button, to add items to the ListView
        addNewButton.setOnClickListener(new View.OnClickListner() {
            @Override
            public void onClick(View v) {

                //read whatever usere had typed into newTodoEditText
                String newItem = newTodoEditText.getText().toString();
                if (newItem.length() == 0) {
                    Toast.makeText(MainActivity.this, "Enter a todo item", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
            //Else, add the String to the ArrayList
                todoListItems.add(newItem);

            //And notify the ArrayAdapter that the data set has changed, to request UI
                todoListAdpater.notifyDataSetChanged();

            //Clear Edittext, ready to type i next item
                newToDoEditText.getText().clear();
            }
        });
        //This Listner responds to long presses on indvidiual list items
        todoListView.setOnItemClickListener(new AdapterView.OnItemLongClickListener(){
         //The position of the list item pressed is provided in the event hander
            @Override
                    public boolean onItemLongclick(AdapterView<?> parent, View view, int position, long id){
                        //Remove the item at position in ArrayList
                        todoListItems.remove(position);
                        //And notify Adapter of changes
                        todoListAdpater.notifyDataSetChanged();

                        return true;
        }
    });
}



