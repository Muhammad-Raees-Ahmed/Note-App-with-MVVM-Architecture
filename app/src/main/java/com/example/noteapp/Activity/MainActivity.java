package com.example.noteapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.room.Insert;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.noteapp.Adapter.Adapter;
import com.example.noteapp.Note;
import com.example.noteapp.NoteViewModel;
import com.example.noteapp.R;
import com.example.noteapp.databinding.ActivityMainBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding activityMainBinding;
    FloatingActionButton floatingActionButton;
    private NoteViewModel noteViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // view binding
        activityMainBinding=ActivityMainBinding.inflate(getLayoutInflater());
        View view=activityMainBinding.getRoot();
        setContentView(view);

        noteViewModel = new ViewModelProvider(this, (ViewModelProvider.Factory) ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication()))
                .get(NoteViewModel.class);

        activityMainBinding.floatingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,AddNoteActivity.class);
                startActivity(intent);
            }
        });

        activityMainBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        activityMainBinding.recyclerView.setHasFixedSize(true);
        Adapter adapter=new Adapter();
        activityMainBinding.recyclerView.setAdapter(adapter);

        noteViewModel.getData().observe(this, new Observer<List<Note>>() {
            @Override
            public void onChanged(List<Note> notes) {
                adapter.submitList(notes);
            }
        });

    }
}