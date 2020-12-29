package com.boot.www.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.www.entity.OaEmail;

public interface MailRepository extends JpaRepository<OaEmail, Integer>{

}
