package com.dj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable

import com.dj.entity.Note;
import com.dj.repository.NoteRepository;

@Service
public class NoteService {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private NoteRepository noteRepository;
	
	public String saveNote(Note note) {
		try {
			noteRepository.save(note);
		}catch (DataIntegrityViolationException e) {
			e.printStackTrace();
			return "Note Not saved Successfully";
		}
		return "Note Saved Successfully";
	}
	
	public List<Note> GetAllNoteByEmail(String id) {
		Long tempid = Long.parseLong(id);
		String query = "SELECT * FROM NOTE WHERE EMAIL_ID = '"+id+"'";
		List list = jdbcTemplate.queryForList(query);
		return list;
	}
	
	public Optional<Note> getById(String id) {
		Long tempid = Long.parseLong(id);
		return noteRepository.findById(tempid);
	}
	
	public String updateNote(String noteid, Note note) {
		String query = "UPDATE NOTE SET  NOTE_TITLE='"+note.getNoteTitle()+"', NOTE_DESCRIPTION = '"+note.getNoteDescription()+"',  LAST_UPDATED_DATE ='"+note.getLastUpdatedDate()+"' WHERE ID = "+noteid+";";
		jdbcTemplate.execute(query);
		return "updated successfully";
	}
	
	public String deleteNote(String id) {
		Long tempid = Long.parseLong(id);
		noteRepository.deleteById(tempid);
		return "Deleted Successfully";
	}

}
