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

    public void setId(int id) {
        this.id = id;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setFinishBy(String finishBy) {
        this.finishBy = finishBy;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

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
