package com.custom.domain;

public enum PlaceofService {
	Pharmacy("Pharmacy"),
	Unassigned("Unassigned"),
	School("School"),
	Homeless_Shelter("Homeless Shelter"),
	Indian_Health_Service_Free_Standing_Facility("Indian Health Service Free Standing Facility"),
	Indian_Health_Service_Provider_Based_Facility("Indian Health Service Provider Based Facility"),
	Tribal_638_Free_Standing_Facility("Tribal 638 Free Standing Facility"),
	Tribal_638_Provider_Based_Facility("Tribal 638 Provider Based Facility"),
	Prison_or_Correctional_Facility("Prison/Correctional Facility"),
	Office("Office"),
	Home("Home"),
	Assisted_Living_Facility("Assisted Living Facility"),
	Walk_in_Retail_Health_Facility("Walk-in Retail Health Facility"),
	Urgent_Care_Facility("Urgent Care Facility"),
	Inpatient_Hospital("Inpatient Hospital"),
	Out_Patient_Hospital("Out Patient Hospital"),
	Emergency_Room_Hospital("Emergency Room-Hospital"),
	Ambulatory_Surgical_Center("Ambulatory Surgical Center"),
	Birthing_Center("Birthing Center"),
	Military_Treatment_Facility("Military Treatment Facility"),
	Skilled_Nursing_Facility("Skilled Nursing Facility"),
	Nursing_Facility("Nursing Facility"),
	Custodial_Care_Facility("Custodial Care Facility"),
	Hospice("Hospice"),
	Ambulance_Land("Ambulance Land"),
	Ambulance_Air_or_Water("Ambulance-Air or Water"),
	Independent_Facility("Independent Facility"),
	Federally_Qualified_Health_Center("Federally Qualified Health Center"),
	Inpatient_Psychiatric_Facility("Inpatient Psychiatric Facility"),
	Psychiatric_Facility_Partial_Hospitalization("Psychiatric Facility-Partial Hospitalization"),
	Community_Mental_Health_Center("Community Mental Health Center"),
	Intermediate_Care_Facility_or_Mentally_Retarded("Intermediate Care Facility/Mentally Retarded"),
	Residential_Substance_Abuse_Treatment_Facility("Home"),
	Psychiatric_Residential_Treatment("Psychiatric Residential Treatment"),
	Non_Residential_Substance_Abuse_Treatment_Facility("Non Residential Substance Abuse Treatment Facility"),
	Mass_Immunization_Center("Mass Immunization Center"),
	Comprehensive_Inpatient_Rehabilitation_Facility("Comprehensive Inpatient Rehabilitation Facility"),
	Comprehen_sive_Outpatient_Rehabilitation_Facility("Comprehensive Outpatient Rehabilitation Facility"),
	End_Stage_Renal_Disease_Treatment_Facility("End-Stage Renal Disease Treatment Facility"),
	Public_Health_Facility("Public Health Facility"),
	Rural_Health_Facility("Rural Health Facility"),
	Independent_Laboratory("Independent Laboratory"),
	Other_Place_of_Service("Other Place of Service");
	
	public String displayValue;
	private PlaceofService(String displayValue) {
		this.displayValue = displayValue;
	}
}
