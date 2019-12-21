/**
 * 
 */
package org.rg.notesapp.repository;

import java.util.List;

import org.rg.notesapp.model.Note;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

/**
 * @author RG
 *
 */
public interface NotesAppRepository extends CrudRepository<Note, Long>, JpaSpecificationExecutor<Note> {

	List<Note> findByTitle(String titleName);
	
	List<Note> findBycreatedBy(String createdBy);
	
}
