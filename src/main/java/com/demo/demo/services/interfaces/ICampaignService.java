package com.demo.demo.services.interfaces;

import org.springframework.http.HttpStatus;

import com.demo.demo.datatypes.requests.AddCampaignReq;
import com.demo.demo.datatypes.response.GetCampaignRes;
import com.demo.demo.model.CampaignModel;

public interface ICampaignService {
	public GetCampaignRes getCampaign(Integer campaignId);
	public HttpStatus addCampaign(Integer campaignId, AddCampaignReq campaignDT);
	public void editCampaign(Integer campaignId, CampaignModel campaignDT);
	public void deleteCampaign(Integer campaignId);
}
