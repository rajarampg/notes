/**
 * 
 */
package org.rg.notesapp.controller;

import java.util.List;

import org.rg.notesapp.apierrors.EntityNotFoundException;
import org.rg.notesapp.model.Note;
import org.rg.notesapp.service.NotesAppService;
import org.rg.notesapp.utilities.ApplicationConstants;
import org.rg.notesapp.utilities.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping(value = "/api")
public class NotesController {
	
	@Autowired
	NotesAppService notesAppService;

	@GetMapping(value = "/welcome")
	public String showMessage() {
		System.out.println("Inside the method");
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
	public List<Note> getAllNotes() throws EntityNotFoundException {
		return notesAppService.getAllNotes();
	}
	
	@GetMapping(value = "/notes/id/{id}")
	public Note getNoteById(@PathVariable Long id) throws EntityNotFoundException {
		return notesAppService.getNoteById(id);
	}
	
	@GetMapping(value = "/notes/{title}")
	public List<Note> getNoteByTitle(@PathVariable String title) throws EntityNotFoundException {
		return notesAppService.getNoteByTitle(title);
	}
	
	@GetMapping(value = "/notes/user/{userName}")
	public List<Note> getNoteByUser(@PathVariable String userName) throws EntityNotFoundException {
		return notesAppService.getNoteByUser(userName);
	}
	
	@PutMapping(value ="/notes/{id}")
	public ResponseBody updateANote(@PathVariable Long id, @RequestBody Note note) {
		ResponseBody respBody = new ResponseBody();
		try {
			String msg = notesAppService.updateANote(id,note);
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
