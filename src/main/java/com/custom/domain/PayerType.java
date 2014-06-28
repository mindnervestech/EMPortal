package com.custom.domain;

public enum PayerType {
	Other_HCFA("Other HCFA"),
	Medicare_Part_B("Medicare Part B"),
	Medicaid("Medicaid"),
	ChampUSVA("ChampUSVA"),
	ChampUS("ChampUS"),
	Blue_Cross_Blue_Shield("Blue Cross Blue Shield"),
	FECA("FECA"),
	Self_Pay("Self Pay"),
	Central_Certification("Central Certification"),
	Other_Non_Federal_Programs("Other Non-Federal Programs"),
	Preferred_Provider_Organization_EPO("Preferre Provider Organization (EPO)"),
	Indemnity_Insurance("Indemnity_Insurance"),
	Health_Maintenence_Organization_HMO_Medicare_Risk("Health Maintenence Organization (HMO) Medicare_Risk"),
	Automobile_Medical("Automobile Medical"),
	Commercial_Insurance_co("Commercial Insurance co."),
	Disability("Disability"),
	Health_Maintenance_Organization("Health Maintenance Organization"),
	Liability("Liability"),
	Liability_Medical("Liability Medical"),
	Other_Federal_Program("Other Federal Program"),
	Title_V("Title_V"),
	Veterans_Administration_Plan("Veterans Administration Plan"),
	Workers_Compensation_Health_Plan("Workers Compensation Health Plan"),
	Mutually_Defined("Mutually Defined");
	
	public String displayValue;
	private PayerType(String displayValue) {
		this.displayValue = displayValue;
	}
}
