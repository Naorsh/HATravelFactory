package com.demo.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.demo.model.ContactModel;

public interface ContactRepositoryDAO extends JpaRepository<ContactModel, Integer>{

}
