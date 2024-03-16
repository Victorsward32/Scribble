package com.example.scribble.Database;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import static  androidx.room.OnConflictStrategy.REPLACE;

import com.example.scribble.Models.Notes;

import java.util.List;

@Dao
public interface MainDAO  {

    @Insert(onConflict = REPLACE)
    void insert(Notes notes);

    // query to selecting data from DB
    @Query("SELECT *  FROM notes ORDER BY id DESC")
    List<Notes> getAll();

    // Thats the Query to updating the data
    @Query("UPDATE notes SET title= :title, notes= :notes WHERE ID= :id ")
    void update(int id, String title,String notes);

    //Deleting records
    @Delete
    void delete(Notes notes);

    @Query("UPDATE notes SET pinned= :pin WHERE ID=:id")
    void pin(int id,boolean pin);
}
