package com.example.scribble;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.scribble.Models.Notes;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NotesTakerActivity extends AppCompatActivity {

    EditText editText_Title,editText_notes;
    ImageView imageView_save;
    Notes notes;
    boolean isOldNote=false;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_taker);


        imageView_save=findViewById(R.id.imageView_save);
        editText_Title=findViewById(R.id.editText_title);
        editText_notes=findViewById(R.id.editText_notes);

        //whenever the NotesTakerAcctivity launch it will search get serializable extra it will find the this
        // to avoid crash we use here try catch

        notes=new Notes();
        try {
            notes= (Notes) getIntent().getSerializableExtra("old_note");
            editText_Title.setText(notes.getTitle());
            editText_notes.setText(notes.getNotes());
            isOldNote=true;
        } catch(Exception e){
            e.printStackTrace();
        }



        imageView_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title= editText_Title.getText().toString();
                String description= editText_notes.getText().toString();

                if (description.isEmpty()) {
                    Toast.makeText(NotesTakerActivity.this, "Please add some notes!", Toast.LENGTH_SHORT).show();
                    return;

                }
                SimpleDateFormat formatter= new SimpleDateFormat("EEE, d MMM yyyy HH:mm a"); //here EEE stands for week days d MMM YYYY for Date And HH for Hourse mm for minutes and a for am /pm
                Date date=new Date();

                if(!isOldNote){
                    notes =new Notes();
                }

                notes.setTitle(title);
                notes.setNotes(description);
                notes.setDate(formatter.format(date));

                Intent intent=new Intent();
                intent.putExtra("note",notes);


                setResult(Activity.RESULT_OK,intent);
                finish();

            }
        });

    }
}