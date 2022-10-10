package com.example.noteapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.noteapp.Note;
import com.example.noteapp.NoteViewModel;
import com.example.noteapp.R;
import com.example.noteapp.databinding.ActivityAddNoteBinding;
import com.example.noteapp.databinding.ActivityUpdateTaskBinding;

public class UpdateTaskActivity extends AppCompatActivity {

    ActivityUpdateTaskBinding binding;
    private NoteViewModel noteViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityUpdateTaskBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        noteViewModel = new ViewModelProvider(this, (ViewModelProvider.Factory) ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication()))
                .get(NoteViewModel.class);

        // data not come
        Note task = (Note) getIntent().getSerializableExtra("note");

        loadTask(task);

        binding.buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Clicked", Toast.LENGTH_LONG).show();
                updateTask(task);
            }
        });
    }

    private void updateTask(Note task) {
        noteViewModel.delete(task);
    }

    private void loadTask(Note task) {

        System.out.println(task);
//        binding.editTextTask.setText(task.getTask());
//        binding.editTextDesc.setText(task.getDesc());
//        binding.editTextFinishBy.setText(task.getFinishBy());
//        binding.checkBoxFinished.setChecked(task.isFinished());


    }
}