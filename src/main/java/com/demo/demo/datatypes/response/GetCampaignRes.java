package com.demo.demo.datatypes.response;

import java.util.Optional;

import com.demo.demo.model.CampaignModel;
import com.demo.demo.model.ContactModel;

import lombok.Data;

@Data
public class GetCampaignRes extends BaseResponse{
	Optional<CampaignModel> campaigns;
	Optional<ContactModel> contact;
}
