package com.demo.demo.datatypes.requests;

import lombok.Data;

@Data
public class RegisterContactReq {
	private String contactName;
	private String contactPhone;
	private String contactEmail;
}
