package com.example.gradiuation.stopwatch;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Medication_Adapter extends ArrayAdapter{

    private int resource;
    private LayoutInflater inflater;
    private Context context;
    ArrayList<Medication> objects;

    public Medication_Adapter ( Context ctx, int resourceId,ArrayList<Medication> objects ) {

        super( ctx, resourceId, objects );
        resource = resourceId;
        this.objects=objects;
        inflater = LayoutInflater.from( ctx );
        context=ctx;
    }

    @Override
    public View getView ( final int position, View convertView, ViewGroup parent ) {

        /* create a new view of my layout and inflate it in the row */
        convertView = ( RelativeLayout ) inflater.inflate( resource, null );

        /* Extract the city's object to show */
        Medication city = (Medication) getItem( position );

        /* Take the TextView from layout and set the city's name */
        TextView txtName = (TextView) convertView.findViewById(R.id.MedicationName);
        txtName.setText(city.getName());
        final Other_Medicaton other_medicaton=new Other_Medicaton();


        /* Take the ImageView from layout and set the city's image */
        Button Delete=(Button) convertView.findViewById(R.id.Delete);

        return convertView;
    }

    public Medication getItem(int position) {
        return objects.get(position);
    }

    @Override
    public int getPosition(Object item) {
        return super.getPosition(item);
    }
}