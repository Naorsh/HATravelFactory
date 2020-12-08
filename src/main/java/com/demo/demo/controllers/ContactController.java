package com.demo.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.demo.datatypes.requests.RegisterContactReq;
import com.demo.demo.datatypes.response.BaseResponse;
import com.demo.demo.services.interfaces.IContactService;

@RequestMapping("api/marketing/ws/partner/campaign/{id}/registration")
@RestController
public class ContactController {

	@Autowired
	private IContactService contactService;
	
	@PostMapping()
	public ResponseEntity<BaseResponse> registerContact(@PathVariable("id") Integer campaignId, @RequestBody RegisterContactReq request) {
		contactService.registerContact(campaignId, request);
		BaseResponse response = new BaseResponse();
		response.setStatus("OK");
		return new ResponseEntity<BaseResponse>(response ,HttpStatus.OK);
	}
}
