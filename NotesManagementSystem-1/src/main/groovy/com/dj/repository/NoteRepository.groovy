package com.dj.repository;

import org.springframework.data.repository.CrudRepository

import com.dj.entity.Note;

public interface NoteRepository extends CrudRepository<Note, Long>{
	
}
