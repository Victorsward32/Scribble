package com.example.scribble.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.helper.widget.Layer;
import androidx.recyclerview.widget.RecyclerView;

import com.example.scribble.Models.Notes;
import com.example.scribble.NotesClickListener;
import com.example.scribble.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NotesListAdapter extends RecyclerView.Adapter<NotesViewHolder>{

    Context context;
    List<Notes> list;

    NotesClickListener listener;

    public NotesListAdapter(Context context, List<Notes> list, NotesClickListener listener) {
        this.context = context;
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return  new NotesViewHolder(LayoutInflater.from(context).inflate(R.layout.note_list, parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull NotesViewHolder holder, int position) {
        //for title hold view
        holder.textview_title.setText(list.get(position).getTitle());
        holder.textview_title.setSelected(true);  // it will give scrooll view
        //for textview notes

        holder.textView_notes.setText(list.get(position).getNotes());

        // for textview Dates
        holder.textView_date.setText(list.get(position).getDate());
        holder.textView_date.setSelected(true);// it will give scrooll view

        //pin items
        if (list.get(position).isPinned()) {

            holder.imageView_pin.setImageResource(R.drawable.pin);

        }else{
            holder.imageView_pin.setImageResource(0);

        }

        //here we are adding the random color to the first container

        int color_code= getRandomColor();
        holder.notes_container.setCardBackgroundColor(holder.itemView.getResources().getColor(color_code,null));

        //here we are managing over onliclick and Onmanageditem

        holder.notes_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(list.get(holder.getAdapterPosition()));
            }
        });

        holder.notes_container.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                listener.onLongClick(list.get(holder.getAdapterPosition()),holder.notes_container);
                return true;
            }
        });

    }

    private int getRandomColor(){
        List<Integer> colorCode=new ArrayList<>();
        colorCode.add(R.color.color1);
        colorCode.add(R.color.color2);
        colorCode.add(R.color.color3);
        colorCode.add(R.color.color4);
        colorCode.add(R.color.color5);
        colorCode.add(R.color.color6);
        colorCode.add(R.color.color7);

        Random random=new Random();
        int random_color= random.nextInt(colorCode.size());

        return colorCode.get(random_color);

    }

    @Override
    public int getItemCount() {
        return list.size();


    }

    public void filterList(List<Notes>filteredlist){

        list=filteredlist;
        notifyDataSetChanged();

    }
}

class NotesViewHolder extends RecyclerView.ViewHolder{

    CardView notes_container;
    TextView textview_title,textView_notes,textView_date;

    ImageView imageView_pin;

    public NotesViewHolder(@NonNull View itemView) {
        super(itemView);
        notes_container=itemView.findViewById(R.id.notes_container);
        textview_title = itemView.findViewById(R.id.textview_title);
        textView_notes=itemView.findViewById(R.id.textView_notes);
        textView_date= itemView.findViewById(R.id.textView_date);
        imageView_pin=itemView.findViewById(R.id.imageView_pin);


    }
}