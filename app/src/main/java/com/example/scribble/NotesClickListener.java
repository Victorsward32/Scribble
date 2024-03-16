package com.example.scribble;

import androidx.cardview.widget.CardView;

import com.example.scribble.Models.Notes;

public interface NotesClickListener {

    void onClick(Notes notes);
    Void onLongClick(Notes notes, CardView cardView);
}
