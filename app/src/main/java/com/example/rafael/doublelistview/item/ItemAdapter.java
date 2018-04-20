package com.example.rafael.doublelistview.item;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.rafael.doublelistview.R;
import com.example.rafael.doublelistview.subitem.SubItem;
import com.example.rafael.doublelistview.subitem.SubItemAdapter;

import java.util.ArrayList;

public class ItemAdapter extends ArrayAdapter<Item> {

    private final ArrayList<Item> items;
    Context context;
    int layoutResourceId;

    public ItemAdapter(@NonNull Context context, int layoutResourceId, @NonNull ArrayList<Item> items) {
        super(context, layoutResourceId, items);
        this.context = context;
        this.layoutResourceId = layoutResourceId;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Item getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        //TODO adicionar um id na classe Item e retorna-lo aqui. Por enquanto, pode retornar 0;
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ItemHolder holder;

        if (view == null) {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            view = inflater.inflate(layoutResourceId, parent,false);

            holder = new ItemHolder();
            holder.itemText = view.findViewById(R.id.itemText);
            holder.subItemList = view.findViewById(R.id.subItemList);

            view.setTag(holder);

        } else {
            holder = (ItemHolder) view.getTag();
        }

        Item item = items.get(position);

        ArrayAdapter<SubItem> subItemAdapter = new SubItemAdapter(context, R.layout.subitem, item.getSubItems());
        holder.subItemList.setAdapter(subItemAdapter);
        holder.itemText.setText(item.getText());

        return view;
    }

    static class ItemHolder {
        TextView itemText;
        ListView subItemList;
    }
}
