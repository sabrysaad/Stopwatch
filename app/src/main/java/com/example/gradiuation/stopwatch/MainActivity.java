package com.example.gradiuation.stopwatch;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.Editable;
import android.text.Html;
import android.text.InputType;
import android.text.SpannedString;
import android.text.StaticLayout;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    private ListView listViewCity;
    private Context ctx;
    static int statis = 1;

    private Button startButton;
    private TextView timerValue;
    private static long startTime = 0L;
    private static Handler customHandler = new Handler();
    static long timeInMilliseconds = 0L;
    static long timeSwapBuff = 0L;
    static long updatedTime = 0L;
    static int type = 0;
    static String Text = "Start Code ";


    private Button startButton1;
    private TextView timerValue1;
    private static long startTime1 = 0L;
    private static Handler customHandler1 = new Handler();
    static long timeInMilliseconds1 = 0L;
    static long timeSwapBuff1 = 0L;
    static long updatedTime1 = 0L;
    static int type1 = 0;
    static String Text1 = "Start CPR";


    private Button startButton2;
    private TextView timerValue2;
    private static long startTime2 = 0L;
    private static Handler customHandler2 = new Handler();
    static long timeInMilliseconds2 = 0L;
    static long timeSwapBuff2 = 0L;
    static long updatedTime2 = 0L;
    static int type2 = 0;


    private Button startButton3;
    private TextView timerValue3;
    private static long startTime3 = 0L;
    private static Handler customHandler3 = new Handler();
    static long timeInMilliseconds3 = 0L;
    static long timeSwapBuff3 = 0L;
    static long updatedTime3 = 0L;
    static int type3 = 0;


    static ArrayList<logs> objects = new ArrayList<logs>();
    static LogsAdapter customAdapter;
    public static String time1 = "";
    public static String time2 = "";
    public static String time3 = "";
    public static String time4 = "";
    static String Clock;

    ArrayList<String> medication = new ArrayList<>();
    ArrayList<String> Event = new ArrayList<>();
    ArrayList<String> Rhythm = new ArrayList<>();
    ArrayList<String> ROSC = new ArrayList<>();
    private Email email;
    TextView count;
    TextView count1;
    EditText input1, input2;


    //@TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        medication.add("Vasopressin");
        medication.add("Amiodarone");
        medication.add("Lidocaine");
        medication.add("Ca");
        medication.add("MgSO4");
        medication.add("Other");


        Event.add("Oxegeyn");
        Event.add("IV");
        Event.add("ETT");
        Event.add("OPA");
        Event.add("NPA");
        Event.add("Defiprillator");
        Event.add("Other");


        Rhythm.add("VF");
        Rhythm.add("VT");
        Rhythm.add("PEA");
        Rhythm.add("Asystole");
        Rhythm.add("SVT");
        Rhythm.add("AF");
        Rhythm.add("Other");


        ROSC.add("ROSC 1");
        ROSC.add("ROSC 2");
        ROSC.add("ROSC 3");
        ROSC.add("ROSC 4");
        ROSC.add("ROSC 5");
        ROSC.add("ROSC 6");
        ROSC.add("ROSC 7");
        ROSC.add("Other");


        email = new Email();
        email.setEmail("example@email.com");
        email.setTimer(10);
        timerValue = (TextView) findViewById(R.id.timerValue1);
        startButton = (Button) findViewById(R.id.startButton1);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (type == 0) {
                    GetClock();
                    startTime = SystemClock.uptimeMillis();
                    //startTime1 = SystemClock.uptimeMillis();
                    type = 1;
                    Text = "Stop";
                    startButton.setText(Text);
                    customHandler.postDelayed(updateTimerThread, 0);
                    //customHandler1.postDelayed(updateTimerThread1, 0);

                    if (time1.equals("")) {
                        time1 = "0:00:00";
                    }
                    statis = 1;
                    objects.add(new logs("Code Start", time1, "" + Clock));
                    customAdapter.notifyDataSetChanged();

                } else if (type == 1) {
                    GetClock();
                    DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            switch (which) {
                                case DialogInterface.BUTTON_POSITIVE:

                                    type = 0;
                                    type1 = 0;
                                    type2 = 0;
                                    type3 = 0;
                                    statis = 0;
                                    Text = "Start Code";
                                    startButton.setText(Text);
                                    timeSwapBuff = 0L;
                                    objects.add(new logs("Code Stop", time1, "" + Clock));
                                    Text1 = "Start CPR";
                                    startButton2.setText(Text1);
                                    startButton2.setBackgroundResource(R.drawable.start2);
                                    timeSwapBuff += timeSwapBuff;
                                    customHandler.removeCallbacks(updateTimerThread);
                                    timeSwapBuff1 += timeSwapBuff1;
                                    customHandler1.removeCallbacks(updateTimerThread1);
                                    timeSwapBuff2 += timeSwapBuff2;
                                    customHandler2.removeCallbacks(updateTimerThread2);
                                    timeSwapBuff3 += timeSwapBuff3;
                                    customHandler3.removeCallbacks(updateTimerThread3);
                                    count.setText("");
                                    count1.setText("");
                                    count.setBackgroundResource(R.drawable.start3);
                                    count1.setBackgroundResource(R.drawable.start4);

                                    time1 = "00:00:00";
                                    time2 = "00:00:00";
                                    time3 = "00:00:00";
                                    time4 = "00:00:00";
                                    timerValue.setText(time1);
                                    timerValue1.setText(time2);
                                    timerValue2.setText(time3);
                                    timerValue3.setText(time4);
                                    timerValue2.setTextColor(Color.BLACK);


                                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                                    builder.setTitle("the patient ID is");
                                    input1 = new EditText(MainActivity.this);
                                    input1.setInputType(InputType.TYPE_CLASS_NUMBER);
                                    builder.setView(input1);
                                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {

                                        }
                                    });
                                    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {

                                        }
                                    });
                                    final AlertDialog dialog2 = builder.create();
                                    dialog2.show();
                                    //Overriding the handler immediately after show is probably a better approach than OnShowListener as described below
                                    dialog2.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
                                        public String ID;

                                        @Override
                                        public void onClick(View v) {
                                            ID = input1.getText().toString();
                                            if (ID.matches("[0-9]+")) {
                                                final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                                                builder.setTitle("the Doctor name ");
                                                input2 = new EditText(MainActivity.this);
                                                input2.setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);
                                                builder.setView(input2);
                                                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                                    @Override
                                                    public void onClick(DialogInterface dialog, int which) {
                                                    }
                                                });
                                                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                                    @Override
                                                    public void onClick(DialogInterface dialog, int which) {
                                                    }
                                                });
                                                final AlertDialog dialog1 = builder.create();
                                                dialog1.show();
                                                //Overriding the handler immediately after show is probably a better approach than OnShowListener as described below
                                                dialog1.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
                                                    public String Doctor_name;

                                                    @Override
                                                    public void onClick(View v) {
                                                        Doctor_name = input2.getText().toString();
                                                        if (Doctor_name.matches("[a-zA-Z]+")) {
                                                            final List<String> strings = new ArrayList<String>();
                                                            strings.add("this is the logs data of patient that have ID " + ID + " that done by Doctor " + Doctor_name + "the log data is below \n \n \n \n ");
                                                            strings.add("__________________________________ \n");
                                                            strings.add("| Name\t\t|\t\tTime \t\t|\t\tClock |\n ");
                                                            strings.add("__________________________________ \n");
                                                            for (logs object : objects) {
                                                                strings.add(object != null ? " |\t" + object.getName().toString() + "\t|\t" + object.getTime() + "\t|\t" + object.getClock() + " |\n" : null);
                                                                strings.add("__________________________________ \n");
                                                            }
                                                            objects.removeAll(objects);
                                                            customAdapter.notifyDataSetChanged();
                                                            DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                                                                @Override
                                                                public void onClick(DialogInterface dialog, int which) {
                                                                    switch (which) {
                                                                        case DialogInterface.BUTTON_POSITIVE:
                                                                            sendEmail((ArrayList<String>) strings);
                                                                            break;
                                                                        case DialogInterface.BUTTON_NEGATIVE:
                                                                            //No button clicked
                                                                            objects.removeAll(objects);
                                                                            customAdapter.notifyDataSetChanged();
                                                                            break;
                                                                    }
                                                                }
                                                            };
                                                            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                                                            builder.setMessage("Are you want to send Email with this logs ?").setPositiveButton("Yes", dialogClickListener)
                                                                    .setNegativeButton("No", dialogClickListener).show();
                                                            Toast.makeText(MainActivity.this, "text " + Doctor_name, Toast.LENGTH_LONG).show();
                                                            Boolean wantToCloseDialog = true;
                                                            if (wantToCloseDialog)
                                                                dialog1.dismiss();
                                                        } else {
                                                            input2.setError("invalid name");
                                                            Boolean wantToCloseDialog = false;
                                                            if (wantToCloseDialog)
                                                                dialog1.dismiss();
                                                        }


                                                    }
                                                });

                                                dialog1.getButton(AlertDialog.BUTTON_NEGATIVE).setOnClickListener(new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View v) {
                                                        Boolean wantToCloseDialog = true;
                                                        //Do stuff, possibly set wantToCloseDialog to true then...
                                                        if (wantToCloseDialog)
                                                            dialog1.dismiss();
                                                        Toast.makeText(MainActivity.this, "Cancel", Toast.LENGTH_LONG).show();
                                                        objects.removeAll(objects);
                                                        customAdapter.notifyDataSetChanged();
                                                        dialog1.cancel();

                                                        //else dialog stays open. Make sure you have an obvious way to close the dialog especially if you set cancellable to false.
                                                    }
                                                });


                                                Toast.makeText(MainActivity.this, "text " + ID, Toast.LENGTH_LONG).show();
                                                Boolean wantToCloseDialog = true;
                                                //Do stuff, possibly set wantToCloseDialog to true then...
                                                if (wantToCloseDialog)
                                                    dialog2.dismiss();
                                            } else {
                                                input1.setError("invalid ID");
                                                Boolean wantToCloseDialog = false;
                                                //Do stuff, possibly set wantToCloseDialog to true then...
                                                if (wantToCloseDialog)
                                                    dialog2.dismiss();


                                            }
                                        }
                                    });
                                    dialog2.getButton(AlertDialog.BUTTON_NEGATIVE).setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            Boolean wantToCloseDialog = true;
                                            //Do stuff, possibly set wantToCloseDialog to true then...
                                            if (wantToCloseDialog)
                                                dialog2.dismiss();

                                            Toast.makeText(MainActivity.this, "cancle", Toast.LENGTH_LONG).show();
                                            objects.removeAll(objects);
                                            customAdapter.notifyDataSetChanged();
                                            dialog2.cancel();

                                        }
                                    });
                                    break;

                                case DialogInterface.BUTTON_NEGATIVE:
                                    //No button clicked
                                    break;
                            }
                        }
                    };

                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage("Are you sure?").setPositiveButton("Yes", dialogClickListener)
                            .setNegativeButton("No", dialogClickListener).show();


                }
            }

        });

        timerValue1 = (TextView) findViewById(R.id.timerValue2);
        count = (TextView) findViewById(R.id.counter1);
        startButton1 = (Button) findViewById(R.id.startButton2);
        startButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetClock();
                startTime1 = SystemClock.uptimeMillis();
                type1 += 1;
                if (type1 > 9) {
                    count.setTextSize(12);
                }
                if (time2.equals("")) {
                    time2 = "0:00:00";
                }
                count.setText("" + type1);

                count.setScaleY((float) 0.80);
                count.setScaleX((float) 0.80);
                count.setBackgroundResource(R.drawable.countdesign);
                objects.add(new logs("shock", time2, "" + Clock));
                customAdapter.notifyDataSetChanged();
                customHandler1.postDelayed(updateTimerThread1, 0);

            }

        });

        timerValue3 = (TextView) findViewById(R.id.timerValue3);
        count1 = (TextView) findViewById(R.id.counter2);
        startButton3 = (Button) findViewById(R.id.startButton3);
        startButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetClock();
                startTime3 = SystemClock.uptimeMillis();
                type3 += 1;
                if (type3 > 9) {
                    count1.setTextSize(12);
                }
                if (time4.equals("")) {
                    time4 = "0:00:00";
                }
                count1.setText("" + type3);
                count1.setScaleY((float) 0.80);
                count1.setScaleX((float) 0.80);
                count1.setBackgroundResource(R.drawable.countdesign);

                objects.add(new logs("Epinephrine", time4, "" + Clock));
                customAdapter.notifyDataSetChanged();
                customHandler3.postDelayed(updateTimerThread3, 0);

            }

        });


        Button otherMedication = (Button) findViewById(R.id.other_notification);
        otherMedication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Other_Medicaton.class);
                i.putStringArrayListExtra("medicationlist", medication);
                startActivity(i);
            }
        });
        Button Reythm = (Button) findViewById(R.id.rhythm);
        Reythm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, rhythm.class);
                i.putStringArrayListExtra("rhythmList", Rhythm);
                startActivity(i);
            }
        });

        Button Rocs = (Button) findViewById(R.id.Rosc);
        Rocs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent i = new Intent(MainActivity.this, Rosc.class);
                i.putStringArrayListExtra("roscList", ROSC);
                startActivity(i);*/
                GetClock();
                objects.add(new logs("ROSC", time1, "" + Clock));
                customAdapter.notifyDataSetChanged();


            }
        });
        final Button EventButton = (Button) findViewById(R.id.event);
        EventButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Events.class);
                i.putStringArrayListExtra("eventsList", Event);
                startActivity(i);
            }
        });


        timerValue2 = (TextView) findViewById(R.id.timerValue);
        startButton2 = (Button) findViewById(R.id.startButton);
        startButton2.setOnClickListener(new View.OnClickListener() {
            //@TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {

                if (type2 == 0) {
                    GetClock();
                    timerValue2.setTextColor(Color.BLACK);
                    startTime2 = SystemClock.uptimeMillis();
                    type2 = 1;
                    Text1 = "Pause CPR";
                    startButton2.setTextSize(15);
                    startButton2.setText(Text1);
                    startButton2.setBackgroundResource(R.drawable.start9);
                    customHandler2.postDelayed(updateTimerThread2, 0);
                    if (time3.equals("")) {
                        time3 = "0:00:00";
                    }
                    objects.add(new logs("CPR Start", time3, "" + Clock));
                    customAdapter.notifyDataSetChanged();

                } else if (type2 == 1) {
                    type2 = 0;
                    GetClock();
                    timerValue2.setTextColor(Color.BLACK);

                    Text1 = "Restart CPR";
                    startButton2.setTextSize(15);
                    startButton2.setText(Text1);
                    timeSwapBuff2 += timeSwapBuff2;
                    //startTime2 = SystemClock.uptimeMillis();
                    startButton2.setBackgroundResource(R.drawable.start2);
                    customHandler2.removeCallbacks(updateTimerThread2);
                    objects.add(new logs("CPR Paused", time3, "" + Clock));
                    customAdapter.notifyDataSetChanged();

                }
            }
        });


        customAdapter = new LogsAdapter(this, objects);

        listViewCity = (ListView) findViewById(R.id.Loglist);

        listViewCity.setAdapter(customAdapter);

        Intent i = getIntent();


        String mail = i.getStringExtra("Email");
        if (mail != null) {
            email.setEmail(mail);
        }

        String Medication = i.getStringExtra("medication");

        if (Medication != null) {
            GetClock();
            medication = i.getStringArrayListExtra("medicationlist");
            Toast.makeText(MainActivity.this, Medication, Toast.LENGTH_LONG).show();
            objects.add(new logs("" + Medication, time1, "" + Clock));
            startButton.setText(Text);
            if (type1 > 0) {
                count.setText("" + type1);
                count.setScaleY((float) 0.80);
                count.setScaleX((float) 0.80);
                count.setBackgroundColor(Color.parseColor("#f2f2f2"));
            }
            if (type3 > 0) {
                count1.setText("" + type3);
                count1.setScaleY((float) 0.80);
                count1.setScaleX((float) 0.80);
                count1.setBackgroundColor(Color.parseColor("#f2f2f2"));
            }
            if (type2 == 1) {
                startButton2.setTextSize(15);
                startButton2.setText(Text1);
                startButton2.setBackgroundResource(R.drawable.start9);

            } else if (type2 == 0) {
                startButton2.setTextSize(15);
                startButton2.setText(Text1);
                startButton2.setBackgroundResource(R.drawable.start2);

            }

            customAdapter.notifyDataSetChanged();
        }
        String rhythm = i.getStringExtra("rhythm");

        if (rhythm != null) {
            GetClock();
            Rhythm = i.getStringArrayListExtra("rhythmList");
            Toast.makeText(MainActivity.this, rhythm, Toast.LENGTH_LONG).show();
            objects.add(new logs("" + rhythm, time1, "" + Clock));
            startButton.setText(Text);
            customAdapter.notifyDataSetChanged();
            startButton.setText(Text);
            if (type1 > 0) {
                count.setText("" + type1);
                count.setScaleY((float) 0.80);
                count.setScaleX((float) 0.80);
                count.setBackgroundColor(Color.parseColor("#f2f2f2"));
            }
            if (type3 > 0) {
                count1.setText("" + type3);
                count1.setScaleY((float) 0.80);
                count1.setScaleX((float) 0.80);
                count1.setBackgroundColor(Color.parseColor("#f2f2f2"));
            }
            if (type2 == 1) {
                startButton2.setTextSize(15);
                startButton2.setText(Text1);
                startButton2.setBackgroundResource(R.drawable.start9);

            } else if (type2 == 0) {
                startButton2.setTextSize(15);
                startButton2.setText(Text1);
                startButton2.setBackgroundResource(R.drawable.start2);

            }

        }

        String event = i.getStringExtra("Event");

        if (event != null) {
            GetClock();
            Event = i.getStringArrayListExtra("eventsList");
            Toast.makeText(MainActivity.this, event, Toast.LENGTH_LONG).show();
            objects.add(new logs("" + event, time1, "" + Clock));
            startButton.setText(Text);
            customAdapter.notifyDataSetChanged();
            startButton.setText(Text);
            if (type1 > 0) {
                count.setText("" + type1);
                count.setScaleY((float) 0.80);
                count.setScaleX((float) 0.80);
                count.setBackgroundColor(Color.parseColor("#f2f2f2"));
            }
            if (type3 > 0) {
                count1.setText("" + type3);
                count1.setScaleY((float) 0.80);
                count1.setScaleX((float) 0.80);
                count1.setBackgroundColor(Color.parseColor("#f2f2f2"));
            }
            if (type2 == 1) {
                startButton2.setTextSize(15);
                startButton2.setText(Text1);
                startButton2.setBackgroundResource(R.drawable.start9);

            } else if (type2 == 0) {
                startButton2.setTextSize(15);
                startButton2.setText(Text1);
                startButton2.setBackgroundResource(R.drawable.start2);

            }
        }

        String rosc = i.getStringExtra("Rosc");

        if (rosc != null) {
            GetClock();
            ROSC = i.getStringArrayListExtra("roscList");
            Toast.makeText(MainActivity.this, rosc, Toast.LENGTH_LONG).show();
            objects.add(new logs("" + rosc, time1, "" + Clock));
            customAdapter.notifyDataSetChanged();
            startButton.setText(Text);
            if (type1 > 0) {
                count.setText("" + type1);
                count.setScaleY((float) 0.80);
                count.setScaleX((float) 0.80);
                count.setBackgroundColor(Color.parseColor("#f2f2f2"));
            }
            if (type3 > 0) {
                count1.setText("" + type3);
                count1.setScaleY((float) 0.80);
                count1.setScaleX((float) 0.80);
                count1.setBackgroundColor(Color.parseColor("#f2f2f2"));
            }
            if (type2 == 1) {
                startButton2.setTextSize(15);
                startButton2.setText(Text1);
                startButton2.setBackgroundResource(R.drawable.start9);


            } else if (type2 == 0) {
                startButton2.setTextSize(15);
                startButton2.setText(Text1);
                startButton2.setBackgroundResource(R.drawable.start2);

            }
        }


    }

    protected void sendEmail(ArrayList<String> data) {

        Log.i("Send email", "");
        String[] TO = {email.getEmail()};
        String[] CC = {""};

        String listString = "";

        for (String s : data) {
            listString += s + "\t";
        }
        Intent emailIntent2 = new Intent(android.content.Intent.ACTION_SEND);
        emailIntent2.putExtra(android.content.Intent.EXTRA_CC, CC);
        emailIntent2.putExtra(android.content.Intent.EXTRA_EMAIL, TO);
        emailIntent2.putExtra(android.content.Intent.EXTRA_SUBJECT, "EL Araby Hospital Heart Code");
        emailIntent2.putExtra(android.content.Intent.EXTRA_TEXT, "" + listString);
        emailIntent2.setType("text/html");
        startActivity(Intent.createChooser(emailIntent2, "Send mail client :"));
        finish();
    }


    public void GetClock() {
        int secs = (int) (System.currentTimeMillis() / 1000);
        int mins = secs / 60;
        int hour = mins / 60;
        hour += 2;
        mins = mins % 60;
        secs = secs % 60;
        hour = hour % 24;
        Clock = String.format("%02d", hour) + ":"
                + String.format("%02d", mins) + ":"
                + String.format("%02d", secs);
    }


    @Override
    protected void onResume() {
        if (updatedTime == 0 || statis == 0) {
            //nothing to do
        } else {
            customHandler.postDelayed(updateTimerThread, 0);
        }
        if (updatedTime1 == 0 || statis == 0) {
            //nothing to do
        } else if (type1 == 0) {
            startTime1 = SystemClock.uptimeMillis();
            customHandler1.postDelayed(updateTimerThread1, 0);
        } else if (type1 > 0) {
            customHandler1.postDelayed(updateTimerThread1, 0);
        }
        if (updatedTime2 == 0 || statis == 0) {
            //nothing to do
        } else if (type2 == 1) {
            //startTime2 = SystemClock.uptimeMillis();
            customHandler2.postDelayed(updateTimerThread2, 0);

        } else if (type2 == 0) {
            timeSwapBuff2 += timeSwapBuff2;
            customHandler2.removeCallbacks(updateTimerThread2);

        }
        //    customHandler2.postDelayed(updateTimerThread2,0);

        if (updatedTime3 == 0 || statis == 0) {
            //nothing to do
        } else if (type3 == 0) {
            startTime3 = SystemClock.uptimeMillis();
            customHandler3.postDelayed(updateTimerThread3, 0);
        } else if (type1 > 0) {
            customHandler3.postDelayed(updateTimerThread3, 0);
        }


        super.onResume();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                Toast.makeText(this, "Settings selected", Toast.LENGTH_SHORT)
                        .show();
                break;
            default:
                break;
        }

        return true;
    }


    private Runnable updateTimerThread2 = new Runnable() {

        public void run() {
            timeInMilliseconds2 = SystemClock.uptimeMillis() - startTime2;
            updatedTime2 = timeSwapBuff2 + timeInMilliseconds2;
            int secs = (int) (updatedTime2 / 1000);
            int mins = secs / 60;
            int hour = mins / 60;
            mins = mins % 60;
            secs = secs % 60;
            int milliseconds = (int) (updatedTime2 % 1000);

            time3 = String.format("%02d", hour) + ":"
                    + String.format("%02d", mins) + ":"
                    + String.format("%02d", secs);
            if (time3 != "") {
                timerValue2.setText(time3);
            }
            if (secs > email.getTimer() - 1) {
                timerValue2.setTextColor(Color.RED);
            }
            //customAdapter.notifyDataSetInvalidated();
            customHandler2.postDelayed(this, 0);
        }

    };


    private Runnable updateTimerThread = new Runnable() {

        public void run() {
            timeInMilliseconds = SystemClock.uptimeMillis() - startTime;
            updatedTime = timeSwapBuff + timeInMilliseconds;
            int secs = (int) (updatedTime / 1000);
            int mins = secs / 60;
            mins = mins % 60;
            int hour = mins / 60;
            secs = secs % 60;
            int milliseconds = (int) (updatedTime % 1000);
            time1 = String.format("%02d", hour) + ":"
                    + String.format("%02d", mins) + ":"
                    + String.format("%02d", secs);

            if (time1 != "") {
                timerValue.setText(time1);
            }
            //customAdapter.notifyDataSetInvalidated();
            customHandler.postDelayed(this, 0);
        }

    };


    private Runnable updateTimerThread1 = new Runnable() {

        public void run() {
            timeInMilliseconds1 = SystemClock.uptimeMillis() - startTime1;
            updatedTime1 = timeSwapBuff1 + timeInMilliseconds1;
            int secs1 = (int) (updatedTime1 / 1000);
            int mins1 = secs1 / 60;
            int hour = mins1 / 60;
            mins1 = mins1 % 60;
            secs1 = secs1 % 60;

            time2 = (String.format("%02d", hour) + ":"
                    + String.format("%02d", mins1) + ":"
                    + String.format("%02d", secs1));
            if (time2 != "") {
                timerValue1.setText(time2);
            }

            //customAdapter.notifyDataSetInvalidated();
            customHandler1.postDelayed(this, 0);
        }

    };


    private Runnable updateTimerThread3 = new Runnable() {

        public void run() {
            timeInMilliseconds3 = SystemClock.uptimeMillis() - startTime3;
            updatedTime3 = timeSwapBuff3 + timeInMilliseconds3;
            int secs1 = (int) (updatedTime3 / 1000);
            int mins1 = secs1 / 60;
            int hour = mins1 / 60;
            mins1 = mins1 % 60;
            secs1 = secs1 % 60;

            time4 = (String.format("%02d", hour) + ":"
                    + String.format("%02d", mins1) + ":"
                    + String.format("%02d", secs1));
            if (time4 != "") {
                timerValue3.setText(time4);
            }

            //customAdapter.notifyDataSetInvalidated();
            customHandler3.postDelayed(this, 0);
        }

    };


}