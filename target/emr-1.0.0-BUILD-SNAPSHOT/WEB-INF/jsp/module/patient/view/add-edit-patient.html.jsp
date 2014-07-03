	<%@ taglib prefix="css" uri="/WEB-INF/mnt.tld"%>
	<div class="modal-header" data-ng-init='initFormData(${asJson});selectedTab =1'>
            <h3 class="modal-title">Add/Edit Patient</h3>
    </div>
    <div class="modal-body">
    	<ul class="nav nav-tabs">
		  <li data-ng-class="(selectedTab == 1) ? 'active':''"><a data-ng-click="selectedTab = 1" >Patient Details</a></li>
		  <li data-ng-class="(selectedTab == 2) ? 'active':''"><a  data-ng-click="selectedTab = 2" >Insurance</a></li>
		  <li data-ng-class="(selectedTab == 3) ? 'active':''"><a  data-ng-click="selectedTab = 3" >Stats</a></li>
		</ul>
		
		<div data-ng-if="selectedTab == 1">
			<fieldset class="border">
	    		<legend class="border">Personal Information</legend>
				<div>
					<div class="onerow color0-row">
						<label class="col2 small text-right">Name</label>
						<input class="col2" data-palceholder="salutation" data-ng-model="patientForm.salutation" >
						<input class="col4" data-palceholder="first name" data-ng-model="patientForm.firstName" >
						<input class="col4" data-palceholder="middle name" data-ng-model="patientForm.middleName" >
						<input class="col4" data-palceholder="last name" data-ng-model="patientForm.lastName" >
					</div>
			
					<div class="onerow color1-row">
						<label class="col2 small text-right">Parent</label>
						<input class="col4" data-palceholder="parent" data-ng-model="patientForm.parent" >
					</div>
					
					<div class="onerow color0-row">
						<label class="col2 small text-right">Guardian Name</label>
						<input class="col4" data-palceholder="Guardian Name" data-ng-model="patientForm.guardianName" >
					</div>
					
					<div class="onerow color1-row">
						<label class="col2 small text-right">Nick Name</label>
						<input class="col4" data-palceholder="Nick Name" data-ng-model="patientForm.nickName" >
					</div>
					
					<div class="onerow color0-row">
						<div class="dropdown col12 float-none">
								<css:ui  
								data-ng-model="patientForm.dateOfBirth" 
								value="{{patientForm.dateOfBirth|date:'MMMM-dd-yyyy'||'From'}}"
								labelClass="small col3 text-right float-none" 
								cType="date" 
								label="Date Of Birth"/>
						</div>
						
						<div class="col12">
							<css:ui data-ng-init="patientForm.gender= 'Male'" 
								data-ng-model="patientForm.gender" 
								labelClass="col2 small text-right float-none" 
								cType="radio" 
								ds="genderList" 
								label="Gender"/>
						</div>
					</div>
					
					<div class="onerow color1-row">
						<label class="col2 small text-right">SSN #</label>
						<input class="col4" data-palceholder="SSN" data-ng-model="patientForm.ssn" >
					</div>
				</div>
		   </fieldset>
		   
		   <fieldset class="border">
	    		<legend class="border">Contact Details</legend>
	    		<div class="onerow color0-row">
		   			<label class="col2  small text-right">Phone</label>
					<input class="col5" data-ng-model="patientForm.phoneNumber" >
					<label class="left2 col2  small text-right">Mobile</label>
					<input class="col5" data-ng-model="patientForm.mobileNumber" >
		   		</div>
		   		
		   		<div class="onerow color1-row">
		   			<label class="col2  small text-right">Email</label>
					<input class="col5" data-ng-model="patientForm.email" >
					<label class="left2 col2  small text-right">Preferred Communication</label>
					<input class="col5" data-ng-model="patientForm.preferredCommunication" >
		   		</div>
		   		
		   		<div class="onerow color0-row">
		   			<label class="col2  small text-right">Emergency Contact Name</label>
					<input class="col5" data-ng-model="patientForm.emergencyContactName" >
					<label class="left2 col2  small text-right">Emergency Contact Number</label>
					<input class="col5" data-ng-model="patientForm.emergencyContactNumber" >
		   		</div>
		   </fieldset>
		   
		   <fieldset class="border">
	    		<legend class="border">Address Details</legend>
	    		<button data-ng-click="addressDetailModal(-1)" type="button" class="btn btn-default btn-sm">
	    			<span  class="glyphicon glyphicon-plus"></span>Add
	    		</button>
	    		
	    		<div class="onerow color1-row" data-ng-repeat="gd in patientForm.addressDetails">
	   				<label class="col2  small text-right">Address </label>
					<input class="col5" data-ng-model="gd.address" >
					<label class="left2 col2  small text-right">City</label>
					<input class="col5" data-ng-model="gd.city" >
					<span data-ng-click="addressDetailModal($index)" class="glyphicon glyphicon-pencil"></span>
	    		</div>
		   </fieldset>
		   
		   <fieldset class="border">
	    		<legend class="border">Other Details</legend>
	        
				<div>
				   <div class="onerow color0-row">
			   			<label class="col2  small text-right">Insurance Carrier #</label>
						<input class="col5" data-ng-model="patientForm.insuranceCarrier_1_No" >
						<label class="col2  small text-right">Insurance Carrier #2</label>
						<input class="col5" data-ng-model="patientForm.insuranceCarrier_2_No" >
			   		</div>
			   		
			   		<div class="onerow color1-row">
						<css:ui 
							data-ng-model="patientForm.ethnicity" 
							labelClass="col2 small text-right" 
							class="col5 last" 
							cType="select" 
							ds="getEthnicities" 
							label="Ethnicity"
							/>
			   		</div>
			   	</div>
		   </fieldset>
		   
		   <fieldset class="border">
	    		<legend class="border">Insurance Details</legend>
	    		<button data-ng-click="insuranceDetailModal(-1)" type="button" class="btn btn-default btn-sm">
	    			<span  class="glyphicon glyphicon-plus"></span>Add
	    		</button>
	    		
	    		<div class="onerow color1-row" data-ng-repeat="gd in patientForm.insuranceDetails">
	   				<label class="col2  small text-right">Plan Name </label>
					<input class="col5" data-ng-model="gd.planName" >
					<label class="left2 col2  small text-right">Effective Date</label>
					<input class="col5" data-ng-model="gd.effectiveDate" >
					<span data-ng-click="insuranceDetailModal($index)" class="glyphicon glyphicon-pencil"></span>
	    		</div>
		   </fieldset>
		   
		   <button data-ng-show="patientForm.id == null" class="btn btn-primary" data-ng-click="savePatient()">Save</button>
           <button data-ng-show="patientForm.id != null" class="btn btn-primary" data-ng-click="updatePatient()">Update</button>
		</div>
    </div>
    <div class="modal-footer">
            
    </div>
    
<script  type="text/ng-template" id="add-edit-address.html">    
	<%@include file='/WEB-INF/jsp/module/patient/view/add-edit-address.html' %>
</script>

<script  type="text/ng-template" id="add-edit-insurances.html">    
	<%@include file='/WEB-INF/jsp/module/patient/view/add-edit-insurances.html' %>
</script>