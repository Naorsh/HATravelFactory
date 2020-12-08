package com.demo.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.demo.demo.dao.CampaignRepositoryDAO;
import com.demo.demo.dao.MandatoryFieldsDAO;
import com.demo.demo.datatypes.requests.AddCampaignReq;
import com.demo.demo.datatypes.response.GetCampaignRes;
import com.demo.demo.model.CampaignModel;
import com.demo.demo.model.MandatoryFieldsModel;
import com.demo.demo.services.interfaces.ICampaignService;
import com.demo.demo.services.interfaces.IContactService;

@Service
public class CampaignService implements ICampaignService{
	
	@Autowired
	private CampaignRepositoryDAO campaignRepo;
	
	@Autowired
	private MandatoryFieldsDAO mandatoryFieldsRepo;
	
	@Autowired
	private IContactService contactService;

	public GetCampaignRes getCampaign(Integer campaignId) {
		GetCampaignRes response = new GetCampaignRes();
		response.setCampaigns(campaignRepo.findById(campaignId));
		response.setContact(contactService.getRegisteredContactsPerCanpaign(campaignId));
		return response;
	}
	
	public HttpStatus addCampaign(Integer campaignId, AddCampaignReq campaign) {
		//TODO add mandatory fields to DB
		MandatoryFieldsModel mandatoryModel = new MandatoryFieldsModel();
		for(String field : campaign.getMandatoryFields()) {
			mandatoryModel.setFieldName(field);
			mandatoryFieldsRepo.save(mandatoryModel);
		}
		
		CampaignModel model = new CampaignModel();
		model.setCampaignName(campaign.getCampaignName());
		campaignRepo.save(model);
		return HttpStatus.OK;
	}
	
	public void editCampaign(Integer campaignId, CampaignModel campaignDT) {
		
	}
	
	public void deleteCampaign(Integer campaignId) {
		campaignRepo.deleteById(campaignId);
	}
	
}
