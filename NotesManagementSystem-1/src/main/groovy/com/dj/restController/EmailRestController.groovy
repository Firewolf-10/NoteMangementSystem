package com.dj.restController;

import java.util.List;

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dj.entity.Email;
import com.dj.service.EmailService;

@RestController
@RequestMapping("/email")
public class EmailRestController {
	
	// Get the SLF4J logger interface, default Logback, a SLF4J implementation
    private static final Logger logger = LoggerFactory.getLogger(EmailRestController.class);
	
	@Autowired
	private EmailService emailService;
	
	@GetMapping("/save/{email}")
	public def save(@PathVariable(value = 'email') String emailaddress) {
		logger.info("Email => "+emailaddress)
		Email email1 = new Email(emailaddress);
		return emailService.save(email1);
	}
	
	@GetMapping("/getAll")
	public List<Email> getAllEmails() {
		return emailService.getAllEmails();
	}

}
