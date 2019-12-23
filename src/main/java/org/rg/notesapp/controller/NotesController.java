/**
 * 
 */
package org.rg.notesapp.controller;

import org.rg.notesapp.apierrors.EntityNotFoundException;
import org.rg.notesapp.model.Note;
import org.rg.notesapp.service.NotesAppService;
import org.rg.notesapp.utilities.ApplicationConstants;
import org.rg.notesapp.utilities.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author RG
 *
 */
@RestController
@RequestMapping(value = "/api/v1")
public class NotesController {

	@Autowired
	NotesAppService notesAppService;

	@GetMapping(value = "/welcome")
	public String showMessage() {
		return "Notes app with basic Spring security";
	}

	@PostMapping(value = "/notes")
	public ResponseBody createANote(@RequestBody Note note) {
		ResponseBody respBody = new ResponseBody();
		try {
			String msg = notesAppService.createNewNote(note);
			respBody.setResponseCode(ApplicationConstants.POST_SUCCESS_CODE);
			respBody.setResponseMessage(msg);
		} catch (Exception e) {
			// TODO: handle exception
			respBody.setResponseCode(ApplicationConstants.SERVER_EXCEPTION_CODE);
			respBody.setResponseMessage(ApplicationConstants.SERVER_EXCEPTION_MSG);
		}
		return respBody;
	}

	@GetMapping(value = "/notes")
	public Page<Note> getAllNotes(
			@PageableDefault(page = 0, size = 3) @SortDefault(sort = "notesId", direction = Sort.Direction.ASC) Pageable pageable)
			throws EntityNotFoundException {
		return notesAppService.getAllNotes(pageable);
	}

	@GetMapping(value = "/notes/id/{id}")
	public Note getNoteById(@PathVariable Long id) throws EntityNotFoundException {
		return notesAppService.getNoteById(id);
	}

	@GetMapping(value = "/notes/{title}")
	public Page<Note> getNoteByTitle(@PathVariable String title, Pageable pageable) throws EntityNotFoundException {
		return notesAppService.getNoteByTitle(title, pageable);
	}

	@GetMapping(value = "/notes/user/{userName}")
	public Slice<Note> getNoteByUser(@PathVariable String userName, Pageable pageable) throws EntityNotFoundException {
		return notesAppService.getNoteByUser(userName, pageable);
	}

	@PutMapping(value = "/notes/{id}")
	public ResponseBody updateANote(@PathVariable Long id, @RequestBody Note note) {
		ResponseBody respBody = new ResponseBody();
		try {
			String msg = notesAppService.updateANote(id, note);
			respBody.setResponseCode(ApplicationConstants.SUCCESS_CODE);
			respBody.setResponseMessage(msg);
		} catch (Exception e) {
			// TODO: handle exception
			respBody.setResponseCode(ApplicationConstants.SERVER_EXCEPTION_CODE);
			respBody.setResponseMessage(ApplicationConstants.SERVER_EXCEPTION_MSG);
		}
		return respBody;
	}

	@DeleteMapping(value = "/notes/{id}")
	public ResponseBody deleteNote(@PathVariable Long id) {
		ResponseBody respBody = new ResponseBody();
		try {
			String msg = notesAppService.deleteANote(id);
			respBody.setResponseCode(ApplicationConstants.SUCCESS_CODE);
			respBody.setResponseMessage(msg);
		} catch (Exception e) {
			// TODO: handle exception
			respBody.setResponseCode(ApplicationConstants.SERVER_EXCEPTION_CODE);
			respBody.setResponseMessage(ApplicationConstants.SERVER_EXCEPTION_MSG);
		}
		return respBody;
	}

	@DeleteMapping(value = "/notes")
	public ResponseBody deleteAllNotes() {
		ResponseBody respBody = new ResponseBody();
		try {
			String msg = notesAppService.deleteAllNotes();
			respBody.setResponseCode(ApplicationConstants.SUCCESS_CODE);
			respBody.setResponseMessage(msg);
		} catch (Exception e) {
			// TODO: handle exception
			respBody.setResponseCode(ApplicationConstants.SERVER_EXCEPTION_CODE);
			respBody.setResponseMessage(ApplicationConstants.SERVER_EXCEPTION_MSG);
		}
		return respBody;
	}

}
