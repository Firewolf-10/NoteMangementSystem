package com.dj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Service;

import com.dj.entity.Email;
import com.dj.repository.EmailRepository;

@Service
public class EmailService {
	
	@Autowired
	private EmailRepository emailRepository;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public def save(Email email) {
		Email tempemail = null;
		try {
			tempemail = emailRepository.save(email);
		}catch (DataIntegrityViolationException e) {
			e.printStackTrace();
			String query = "SELECT * FROM EMAIL WHERE EMAIL = '"+email.getEmail()+"'";
			Map map = jdbcTemplate.queryForMap(query);
			return map;
		}
		
		return tempemail;
	}
	
	public List<Email> getAllEmails() {
		return emailRepository.findAll();
	}

}
