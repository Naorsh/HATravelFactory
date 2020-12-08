package com.demo.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.demo.datatypes.requests.AddCampaignReq;
import com.demo.demo.datatypes.response.BaseResponse;
import com.demo.demo.datatypes.response.GetCampaignRes;
import com.demo.demo.services.interfaces.ICampaignService;

@RequestMapping("api/marketing/ws/partner/campaign/{id}")
@RestController
public class CampaignController {
	
	@Autowired
	private ICampaignService campaignService;
	
	@GetMapping()
	public ResponseEntity<GetCampaignRes> getCampaign(@PathVariable("id") Integer campaignId) {
		GetCampaignRes response = new GetCampaignRes();
		response = campaignService.getCampaign(campaignId);
		response.setStatus("S");
		return new ResponseEntity<GetCampaignRes>(response ,HttpStatus.OK);
	}
	
	@PostMapping()
	public ResponseEntity<BaseResponse> addCampaign(@PathVariable("id") Integer campaignId, @RequestBody AddCampaignReq campaign) {
		campaignService.addCampaign(campaignId, campaign);
		BaseResponse response = new BaseResponse();
		response.setStatus("OK");
		return new ResponseEntity<BaseResponse>(response ,HttpStatus.OK);
	}
	
	@PutMapping()
	public ResponseEntity<BaseResponse> editCampaign(@PathVariable("id") Integer campaignId) {
		BaseResponse response = new BaseResponse();
		response.setStatus("OK");
		return new ResponseEntity<BaseResponse>(response ,HttpStatus.OK);
	}
	
	@DeleteMapping()
	public ResponseEntity<BaseResponse> deleteCampaign(@PathVariable("id") Integer campaignId) {
		BaseResponse response = new BaseResponse();
		response.setStatus("OK, campaign id " + campaignId.toString() + " removed");
		return new ResponseEntity<BaseResponse>(response ,HttpStatus.OK);
	}
}
