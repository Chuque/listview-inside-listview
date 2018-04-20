package com.example.rafael.doublelistview;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ItemAdapter extends BaseAdapter {

    private Activity act;
    private final ArrayList<Item> items;

    public ItemAdapter(ArrayList<Item> items, Activity act) {
        this.act = act;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        //TODO adicionar um id na classe Item e retorna-lo aqui. Por enquanto, pode retornar 0;
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = act.getLayoutInflater().inflate(R.layout.item, parent, false);
        Item item = items.get(position);

        //pega a referencia das views do layout
        TextView itemText = view.findViewById(R.id.itemText);

        //popula as views
        itemText.setText(item.getText());

        return view;
    }
}
