/**
 * 
 */
package org.rg.notesapp.service;

import java.util.List;

import org.rg.notesapp.model.Note;

/**
 * @author RG
 *
 */
public interface NotesAppService {

	public String createNewNote(Note note);

	public List<Note> getAllNotes();

	public List<Note> getNoteByTitle(String titleName);

	public String deleteANote(Long title);

	public String deleteAllNotes();

	public String updateANote(Long id, Note note);
	
	public List<Note> getNoteByUser(String userName);

	public Note getNoteById(Long id);

}
