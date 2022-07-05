package tech.getarrays.mandatemanager.displayformat;

public interface MandateTable {

	Long getMandateId();
	String getPayerName();
	String getPayeeName();
	String getValidFrom();
	String getValidTo();
	Boolean getStatus();
	
	
}