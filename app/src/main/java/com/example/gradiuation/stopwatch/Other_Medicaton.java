package com.example.gradiuation.stopwatch;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.ActionBarActivity;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class Other_Medicaton extends ActionBarActivity {
    ListView listView;
    static List codeLearnChapters;
    public Medication_Adapter customAdapter;
    public ArrayList<Medication> objects;
    ArrayAdapter<String> codeLearnArrayAdapter;
    public Context ctx;
    static int loop=1;
    private String Data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other__medicaton);

        listView = ( ListView ) findViewById( R.id.medicationlistView);
        loop=1;
        Intent i=getIntent();
        codeLearnChapters=i.getStringArrayListExtra("medicationlist");



        codeLearnArrayAdapter= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, codeLearnChapters);
        listView.setAdapter(codeLearnArrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public String m_Text;

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //medication_adapter.getItem(position).getName();
                if (listView.getItemAtPosition(position).toString().equals("Other")){

                    AlertDialog.Builder builder = new AlertDialog.Builder(Other_Medicaton.this);
                    builder.setTitle("please enter the other Medication");
                    final EditText input = new EditText(Other_Medicaton.this);
                    input.setInputType(InputType.TYPE_CLASS_TEXT);
                    builder.setView(input);
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            m_Text = input.getText().toString();
                            Intent i =new Intent(Other_Medicaton.this,MainActivity.class);
                            i.putExtra("medication", m_Text);
                            i.putStringArrayListExtra("medicationlist", (ArrayList<String>) codeLearnChapters);
                            startActivity(i);
                            Toast.makeText(Other_Medicaton.this, "you press " + m_Text, Toast.LENGTH_LONG).show();

                        }
                    });
                    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(Other_Medicaton.this,"cancle",Toast.LENGTH_LONG).show();
                            dialog.cancel();
                        }
                    });

                    builder.show();

                }else {
                    Intent i = new Intent(Other_Medicaton.this, MainActivity.class);
                    i.putExtra("medication", listView.getItemAtPosition(position).toString());
                    i.putStringArrayListExtra("medicationlist", (ArrayList<String>) codeLearnChapters);
                    startActivity(i);
                    Toast.makeText(Other_Medicaton.this, "you press " + listView.getItemAtPosition(position), Toast.LENGTH_LONG).show();
                }

            }

        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Other_Medicaton.this, "you press " + listView.getItemAtPosition(position), Toast.LENGTH_LONG).show();
                final int pos=position;
                DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case DialogInterface.BUTTON_POSITIVE:
                                //Yes button clicked
                                codeLearnChapters.remove(pos);
                                codeLearnArrayAdapter.notifyDataSetChanged();
                                break;

                            case DialogInterface.BUTTON_NEGATIVE:
                                //No button clicked
                                break;
                        }
                    }
                };

                AlertDialog.Builder builder = new AlertDialog.Builder(Other_Medicaton.this);
                builder.setMessage("Are you want to delete this Medication ?").setPositiveButton("Yes", dialogClickListener)
                        .setNegativeButton("No", dialogClickListener).show();
                return true;
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.edit, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            Intent i=new Intent(Other_Medicaton.this,Setting.class);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
