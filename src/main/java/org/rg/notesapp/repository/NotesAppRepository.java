/**
 * 
 */
package org.rg.notesapp.repository;

import org.rg.notesapp.model.Note;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author RG
 *
 */
public interface NotesAppRepository extends PagingAndSortingRepository<Note, Long>, JpaSpecificationExecutor<Note>{

	Page<Note> findByTitle(String titleName, Pageable pageable);
	
	Slice<Note> findBycreatedBy(String createdBy, Pageable pageable);
	
}
