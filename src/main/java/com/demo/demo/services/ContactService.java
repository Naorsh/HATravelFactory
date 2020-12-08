package com.demo.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.demo.dao.CampaignRepositoryDAO;
import com.demo.demo.dao.ContactRepositoryDAO;
import com.demo.demo.datatypes.requests.RegisterContactReq;
import com.demo.demo.model.ContactModel;
import com.demo.demo.services.interfaces.IContactService;

@Service
public class ContactService implements IContactService{
	
	@Autowired
	private ContactRepositoryDAO ContactRepo;
	
	@Autowired
	private CampaignRepositoryDAO campaignRepo;
	

	@Override
	public void registerContact(Integer campaignId, RegisterContactReq request) {
		inputValidation(campaignId, request);
		ContactModel model = new ContactModel();
		model.setContactName(request.getContactName());
		model.setContactPhone(request.getContactPhone());
		model.setContactEmail(request.getContactEmail());
		model.setCampaignId(campaignId);
		
		ContactRepo.save(model);
		
	}

	private void inputValidation(Integer campaignId, RegisterContactReq request) {
		// TODO get mandatory fields by campaign id
		
		// TODO check if campaign exists
		/*
		 * if(campaignRepo.findById(campaignId).isEmpty()){ // TODO throw new
		 * BadRequestExceptio }
		 */
	}

	@Override
	public Optional<ContactModel> getRegisteredContactsPerCanpaign(Integer campaignId) {
		return ContactRepo.findById(campaignId);
	}
	
	

}
