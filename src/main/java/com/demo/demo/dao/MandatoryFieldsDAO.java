package com.demo.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.demo.model.MandatoryFieldsModel;

public interface MandatoryFieldsDAO extends JpaRepository<MandatoryFieldsModel, Integer>{

}
