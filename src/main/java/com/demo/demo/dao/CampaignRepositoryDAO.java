package com.demo.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.demo.model.CampaignModel;

public interface CampaignRepositoryDAO extends JpaRepository<CampaignModel, Integer>{
	
}
