package com.example.gradiuation.stopwatch;

/**
 * Created by eagle-eye on 27/07/15.
 */
public class logs {
    private String name;
    private String time;
    private String clock;

    public logs(String name, String time, String clock) {
        super();
        this.name = name;
        this.time = time;
        this.clock = clock;
    }
    public void setName(String nameText) {
        name = nameText;
    }
    public String getName() {
        return name;
    }


    public void setTime(String time) {
        this.time = time;
    }
    public String getTime() {
        return time;
    }

    public void setClock(String clock) {
        this.clock = clock;
    }

    public String getClock() {
        return clock;
    }


}
