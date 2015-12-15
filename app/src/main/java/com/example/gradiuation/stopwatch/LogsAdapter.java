package com.example.gradiuation.stopwatch;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eagle-eye on 27/07/15.
 */
public class LogsAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private ArrayList<logs> objects;

    private class ViewHolder {
        TextView textView1;
        TextView textView2;
        TextView textView3;
    }

    public LogsAdapter(Context context, ArrayList<logs> objects) {
        inflater = LayoutInflater.from(context);
        this.objects = objects;
    }

    public int getCount() {
        Log.d("size",""+objects.size());
        return objects.size();
    }

    public logs getItem(int position) {
        return objects.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if(convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.listadapter, null);
            holder.textView1 = (TextView) convertView.findViewById(R.id.LogName);
            holder.textView2 = (TextView) convertView.findViewById(R.id.LogTime);
            holder.textView3=(TextView) convertView.findViewById(R.id.LogClock);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.textView1.setText(objects.get(position).getName());
        holder.textView2.setText(objects.get(position).getTime());
        holder.textView3.setText(objects.get(position).getClock());
        return convertView;
    }
}
