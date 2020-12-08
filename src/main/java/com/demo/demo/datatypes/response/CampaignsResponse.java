package com.demo.demo.datatypes.response;

import java.util.Optional;

import com.demo.demo.model.CampaignModel;

import lombok.Data;

@Data
public class CampaignsResponse extends BaseResponse{
	Optional<CampaignModel> campaigns;
	
}
