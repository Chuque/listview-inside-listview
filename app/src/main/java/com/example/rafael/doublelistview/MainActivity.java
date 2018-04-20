package com.example.rafael.doublelistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.rafael.doublelistview.item.Item;
import com.example.rafael.doublelistview.item.ItemAdapter;
import com.example.rafael.doublelistview.subitem.SubItem;

import java.util.ArrayList;

import static com.example.rafael.doublelistview.utils.ListViewHeightUtil.setListViewHeightBasedOnItems;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Item> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        items = new ArrayList<>();

        //populate arraylists
        ArrayList<SubItem> subItems = new ArrayList<>();
        for(int i=0;i<8;i++){
            SubItem subItem = new SubItem();
            subItem.setText("SubItem " + i);
            subItems.add(subItem);
        }

        for(int i=0;i<5;i++) {
            Item item = new Item();
            item.setText("Item " + i);
            item.setSubItems((ArrayList<SubItem>)subItems.clone());
            items.add(item);
        }

        ListView itemListView = findViewById(R.id.itemList);
        ItemAdapter itemAdapter = new ItemAdapter(this, R.layout.item, items);
        itemListView.setAdapter(itemAdapter);
    }
}
