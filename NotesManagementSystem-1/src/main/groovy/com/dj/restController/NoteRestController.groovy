package com.dj.restController;

import java.util.List;

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dj.entity.Note;
import com.dj.service.NoteService;

@RestController
@RequestMapping("/note")
public class NoteRestController {
	
	// Get the SLF4J logger interface, default Logback, a SLF4J implementation
	private static final Logger logger = LoggerFactory.getLogger(NoteRestController.class);
	
	@Autowired
	private NoteService noteService;
	
	@PostMapping("/save")
	public String saveNote( Note note) {
		logger.info(" Note => "+note);
		return noteService.saveNote(note);
	}
	
	@GetMapping("/getAll/{id}")
	public List<Note> GetAllNoteByEmail(@PathVariable(value = "id") String id) {
		return noteService.GetAllNoteByEmail(id);
	}
	
	@GetMapping("/get/{id}")
	public Optional<Note> getById(@PathVariable(value = "id") String id) {
		return noteService.getById(id);
	}
	
	@GetMapping("/update/{noteid}")
	public String updateNote(@PathVariable(value = "noteid") String noteid, Note note) {
		println "noteid "+noteid;
		println "note "+note;
		return noteService.updateNote(noteid, note);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteNote(@PathVariable(value = 'id')  String id) {
		return noteService.deleteNote(id);
	}

}
