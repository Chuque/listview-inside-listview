package com.example.rafael.doublelistview.subitem;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.rafael.doublelistview.R;

import java.util.ArrayList;

public class SubItemAdapter extends ArrayAdapter<SubItem> {

    private final ArrayList<SubItem> subItems;
    Context context;
    int layoutResourceId;

    public SubItemAdapter(@NonNull Context context, int layoutResourceId, @NonNull ArrayList<SubItem> subItems) {
        super(context, layoutResourceId, subItems);
        this.context = context;
        this.layoutResourceId = layoutResourceId;
        this.subItems = subItems;
    }

    @Override
    public int getCount() {
        return subItems.size();
    }

    @Override
    public SubItem getItem(int position) {
        return subItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        //TODO adicionar um id na classe SubItem e retorna-lo aqui. Por enquanto, pode retornar 0;
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        SubItemHolder holder = null;

        if (view == null) {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            view = inflater.inflate(layoutResourceId, parent,false);

            holder = new SubItemHolder();
            holder.subItemText = view.findViewById(R.id.subItemText);

            view.setTag(holder);

        } else {
            holder = (SubItemHolder) view.getTag();
        }

        holder.subItemText.setText(subItems.get(position).getText());

        return view;
    }

    static class SubItemHolder {
        TextView subItemText;
    }
}
