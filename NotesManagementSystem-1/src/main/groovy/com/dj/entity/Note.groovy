package com.dj.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Note {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique=true)
	private String noteTitle;
	private String noteDescription;
	private String lastUpdatedDate;
    private Long Email_Id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNoteTitle() {
		return noteTitle;
	}
	public void setNoteTitle(String noteTitle) {
		this.noteTitle = noteTitle;
	}
	public String getNoteDescription() {
		return noteDescription;
	}
	public void setNoteDescription(String noteDescription) {
		this.noteDescription = noteDescription;
	}
	public String getLastUpdatedDate() {
		return lastUpdatedDate;
	}
	public void setLastUpdatedDate(String lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}
	public Long getEmail_Id() {
		return Email_Id;
	}
	public void setEmail_Id(Long email_Id) {
		Email_Id = email_Id;
	}
	
	@Override
	public String toString() {
		return "Note [id=" + id + ", noteTitle=" + noteTitle + ", noteDescription=" + noteDescription
				+ ", lastUpdatedDate=" + lastUpdatedDate + ", Email_Id=" + Email_Id + "]";
	} 
}
