package com.demo.demo.services.interfaces;

import java.util.Optional;

import com.demo.demo.datatypes.requests.RegisterContactReq;
import com.demo.demo.model.ContactModel;

public interface IContactService {
	public void registerContact(Integer campaignId, RegisterContactReq request);
	public Optional<ContactModel> getRegisteredContactsPerCanpaign(Integer campaignId);
}
