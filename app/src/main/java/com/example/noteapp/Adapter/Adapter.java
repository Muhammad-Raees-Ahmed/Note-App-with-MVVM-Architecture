package com.example.noteapp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.noteapp.Note;
import com.example.noteapp.R;

public class Adapter extends ListAdapter<Note,Adapter.ViewHolder > {

    public Adapter(){
        super(CALLBACK);
    }

    private static final DiffUtil.ItemCallback<Note> CALLBACK=new DiffUtil.ItemCallback<Note>() {
        @Override
        public boolean areItemsTheSame(@NonNull Note oldItem, @NonNull Note newItem) {
            return oldItem.getId()== newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Note oldItem, @NonNull Note newItem) {
            return oldItem.getTask().equals(newItem.getTask());
        }
    };

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_tasks, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Note note=getItem(position);
        holder.textViewTask.setText(note.getTask());
        holder.textViewDesc.setText(note.getDesc());
        holder.textViewFinishBy.setText(note.getFinishBy());

        if (note.isFinished())
            holder.textViewStatus.setText("Completed");
        else
            holder.textViewStatus.setText("Not Completed");

    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textViewStatus, textViewTask, textViewDesc, textViewFinishBy;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewStatus = itemView.findViewById(R.id.textViewStatus);
            textViewTask = itemView.findViewById(R.id.textViewTask);
            textViewDesc = itemView.findViewById(R.id.textViewDesc);
            textViewFinishBy = itemView.findViewById(R.id.textViewFinishBy);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    System.out.println("Clicked");
                }
            });
        }
    }
}
