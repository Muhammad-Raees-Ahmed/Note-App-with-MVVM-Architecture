package com.example.noteapp;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "note")
public class Note {

    // these variables are columns in Room db

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name="task")
    private String task;

    @ColumnInfo(name="desc")
    private String desc;

    @ColumnInfo(name="finish_by")
    private String finishBy;

    @ColumnInfo(name="finished")
    private boolean finished;

    public int getId() {
        return id;
    }

    public String getTask() {
        return task;
    }

    public String getDesc() {
        return desc;
    }

    public String getFinishBy() {
        return finishBy;
    }

    public boolean isFinished() {
        return finished;
    }
}
