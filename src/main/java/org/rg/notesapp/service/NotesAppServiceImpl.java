/**
 * 
 */
package org.rg.notesapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.rg.notesapp.model.Note;
import org.rg.notesapp.repository.NotesAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author RG
 *
 */
@Component
public class NotesAppServiceImpl implements NotesAppService {

	@Autowired
	NotesAppRepository notesAppRepo;

	@Override
	public String createNewNote(Note note) {
		// TODO Auto-generated method stub
		String status = "Unable to store the note.";
		try {
			notesAppRepo.save(note);
			status = "Successfully stored note.";
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error while executing DB" + e);
		}
		return status;
	}

	@Override
	public List<Note> getAllNotes() {
		// TODO Auto-generated method stub
		List<Note> allNotes = new ArrayList<Note>();
		allNotes = (List<Note>) notesAppRepo.findAll();
		if (allNotes == null)
			throw new EntityNotFoundException("No notes found");
		return allNotes;
	}

	@Override
	public List<Note> getNoteByTitle(String titleName) {
		// TODO Auto-generated method stub
		List<Note> noteByTitle = new ArrayList<Note>();
		noteByTitle = notesAppRepo.findByTitle(titleName);
		if (noteByTitle == null)
			throw new org.rg.notesapp.apierrors.EntityNotFoundException(Note.class, "title", titleName);
		return noteByTitle;
	}

	@Override
	public String deleteANote(Long id) {
		// TODO Auto-generated method stub
		String status = "Unable to delete the note.";
		try {
			notesAppRepo.deleteById(id);
			status = "Successfully delete the note.";
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error while executing DB" + e);
		}
		return status;
	}

	@Override
	public String deleteAllNotes() {
		// TODO Auto-generated method stub
		String status = "Unable to clean up the notes.";
		try {
			notesAppRepo.deleteAll();
			status = "Successfully cleaned up the note.";
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error while executing DB" + e);
		}
		return status;
	}

	@Override
	public String updateANote(Long id, Note note) {
		// TODO Auto-generated method stub
		String status = "Unable to update the note.";
		try {
			Optional<Note> noteVal = notesAppRepo.findById(id);
			Note noteByUserId = noteVal.get();
			if (!noteVal.isPresent()) {
				status = "Note is not available in DB.";
			} else {
				noteByUserId.setNotesId(id);
				noteByUserId.setTitle(note.getTitle());
				noteByUserId.setDescription(note.getDescription());
				noteByUserId.setCreatedBy(note.getCreatedBy());
				notesAppRepo.save(noteByUserId);
				status = "Successfully update the note.";
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error while executing DB" + e);
		}
		return status;
	}

	@Override
	public List<Note> getNoteByUser(String userName) {
		// TODO Auto-generated method stub
		List<Note> noteByUser = new ArrayList<Note>();
		noteByUser = notesAppRepo.findBycreatedBy(userName);
		if (noteByUser == null)
			throw new org.rg.notesapp.apierrors.EntityNotFoundException(Note.class, "Username", userName);
		return noteByUser;
	}

	@Override
	public Note getNoteById(Long id) {
		// TODO Auto-generated method stub
		Note noteById = new Note();
		noteById = notesAppRepo.findById(id).get();
		if(noteById == null)
			throw new org.rg.notesapp.apierrors.EntityNotFoundException(Note.class, "id", id.toString());
		return noteById;
	}

}
