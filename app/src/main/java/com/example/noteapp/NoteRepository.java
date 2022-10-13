package com.example.noteapp;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class NoteRepository {
    private NoteDAO noteDAO;
    private LiveData<List<Note>> listLiveData;

    public NoteRepository(Context context) {

        NoteDatabase noteDatabase = NoteDatabase.getInstance(context);
        noteDAO = noteDatabase.noteDAO();
        listLiveData = noteDAO.getAll();


    }

    public void insertData(Note note) {
        new InsertNote(noteDAO).execute(note);
    }

    public void deleteData(Note note) {
        new DeleteNote(noteDAO).execute(note);
    }

    public void updateData(Note note) {
        new UpdateNote(noteDAO).execute(note);
    }

    public LiveData<List<Note>> getAllData() {

        return listLiveData;
    }

    private static class InsertNote extends AsyncTask<Note, Void, Void> {
        private NoteDAO noteDAO;

        public InsertNote(NoteDAO noteDAO) {
            this.noteDAO = noteDAO;
        }


        @Override
        protected Void doInBackground(Note... notes) {
            noteDAO.insert(notes[0]);
            return null;
        }
    }

    private static class DeleteNote extends AsyncTask<Note, Void, Void> {
        private NoteDAO noteDAO;

        public DeleteNote(NoteDAO noteDAO) {
            this.noteDAO = noteDAO;
        }


        @Override
        protected Void doInBackground(Note... notes) {
            noteDAO.delete(notes[0]);
            return null;
        }
    }

    private static class UpdateNote extends AsyncTask<Note, Void, Void> {
        private NoteDAO noteDAO;

        public UpdateNote(NoteDAO noteDAO) {
            this.noteDAO = noteDAO;
        }


        @Override
        protected Void doInBackground(Note... notes) {
            noteDAO.update(notes[0]);
            return null;
        }
    }
}
