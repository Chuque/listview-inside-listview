package com.example.rafael.doublelistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Item> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        items = new ArrayList<>();

        //populate arraylists
        ArrayList<SubItem> subItems = new ArrayList<>();
        for(int i=0;i<2;i++){
            SubItem subItem = new SubItem();
            subItem.setText("abc");
            subItems.add(subItem);
        }

        for(int i=0;i<3;i++) {
            Item item = new Item();
            item.setText("123");
            item.setSubItems(subItems);
            items.add(item);
        }

        ListView itemListView = findViewById(R.id.itemList);
        ArrayAdapter<Item> itemAdapter = new ArrayAdapter<>(this, R.layout.item, R.id.itemText, items);
        itemListView.setAdapter(itemAdapter);
    }
}
