package com.mandatemanager.displayformat;

import java.text.SimpleDateFormat;
import java.util.Date; 

public interface MandateTable {
	public static final Long MandateId = null;
	public static final String PayerName = "";
	public static final String PayeeName = "";
	public static final Date ValidFrom = new Date();
	public static final Date ValidTo = new Date();
	public static final Boolean Status = null;
	Long getMandateId();
	String getPayerName();
	String getPayeeName();
	String getValidFrom();
	String getValidTo();
	Boolean getStatus();
	
	
}
