package com.example.noteapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.noteapp.Note;
import com.example.noteapp.NoteViewModel;
import com.example.noteapp.R;
import com.example.noteapp.databinding.ActivityAddNoteBinding;
import com.example.noteapp.databinding.ActivityMainBinding;

public class AddNoteActivity extends AppCompatActivity {

    ActivityAddNoteBinding activityAddNoteBinding;
    private NoteViewModel noteViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // view binding
        activityAddNoteBinding= ActivityAddNoteBinding.inflate(getLayoutInflater());
        View view=activityAddNoteBinding.getRoot();
        setContentView(view);

        noteViewModel = new ViewModelProvider(this, (ViewModelProvider.Factory) ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication()))
                .get(NoteViewModel.class);

        activityAddNoteBinding.buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SaveNote();

            }
        });
    }

    private void SaveNote() {
        String task = activityAddNoteBinding.editTextTask.getText().toString();
        String desc = activityAddNoteBinding.editTextDesc.getText().toString();
        String finishBy = activityAddNoteBinding.editTextFinishBy.getText().toString();

        if (task.isEmpty()) {
            activityAddNoteBinding.editTextTask.setError("Task Required");
            activityAddNoteBinding.editTextTask.requestFocus();
        }
        if (desc.isEmpty()) {
            activityAddNoteBinding.editTextDesc.setError("Desc  Required");
            activityAddNoteBinding.editTextDesc.requestFocus();
        }
        if (finishBy.isEmpty()) {
            activityAddNoteBinding.editTextFinishBy.setError("Finish by  Required");
            activityAddNoteBinding.editTextFinishBy.requestFocus();
        }

        Note note = new Note();
        note.setTask(task);
        note.setDesc(desc);
        note.setFinishBy(finishBy);
        note.setFinished(false);
        noteViewModel.insert(note);
        Toast.makeText(this, "inserted", Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);

    }
}