package com.demo.demo.datatypes.requests;

import java.util.ArrayList;

import lombok.Data;

@Data
public class AddCampaignReq {
	private String campaignName;
	private ArrayList<String> mandatoryFields;
}
