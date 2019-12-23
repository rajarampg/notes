/**
 * 
 */
package org.rg.notesapp.service;

import org.rg.notesapp.model.Note;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

/**
 * @author RG
 *
 */
public interface NotesAppService {

	public String createNewNote(Note note);

	public Page<Note> getAllNotes(Pageable pageable);

	public Page<Note> getNoteByTitle(String titleName, Pageable pageable);

	public String deleteANote(Long title);

	public String deleteAllNotes();

	public String updateANote(Long id, Note note);

	public Slice<Note> getNoteByUser(String userName, Pageable pageable);

	public Note getNoteById(Long id);

}
