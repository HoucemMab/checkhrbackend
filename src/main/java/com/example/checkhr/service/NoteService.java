package com.example.checkhr.service;

import com.example.checkhr.model.Note;
import com.example.checkhr.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {
    @Autowired
    private NoteRepository noteRepository;

    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    public Note getNoteById(Long id) {
        return noteRepository.findById(id).orElse(null);
    }

    public Note createNote(Note note) {
        return noteRepository.save(note);
    }

    public Note updateNote(Long id, Note updatedNote) {
        Note existingNote = noteRepository.findById(id).orElse(null);
        if (existingNote != null) {
            // Update the existing note with the new data
            existingNote.setContent(updatedNote.getContent());
            existingNote.setTime(updatedNote.getTime());
            return noteRepository.save(existingNote);
        }
        return null; // Note not found
    }

    public void deleteNote(Long id) {
        noteRepository.deleteById(id);
    }
}
