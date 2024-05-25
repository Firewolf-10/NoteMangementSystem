package com.dj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dj.entity.Email;

public interface EmailRepository extends JpaRepository<Email, Long>{

}
