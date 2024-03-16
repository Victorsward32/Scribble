package com.example.scribble.Models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
//This is your Db name Declaration statement
@Entity(tableName = "notes")

public class Notes implements Serializable {
    @PrimaryKey(autoGenerate = true)
            //autogenarated will simple generate Auto increment for our process
    int ID=0;

    @ColumnInfo(name = "title")
    String title="";
    @ColumnInfo(name = "notes")
    String notes="";

    @ColumnInfo(name ="date")
    String date="";

    @ColumnInfo(name ="pinned")
    boolean pinned=false;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isPinned() {
        return pinned;
    }

    public void setPinned(boolean pinned) {
        this.pinned = pinned;
    }
}
