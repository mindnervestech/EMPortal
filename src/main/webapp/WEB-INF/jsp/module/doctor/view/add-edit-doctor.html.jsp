	<%@ taglib prefix="css" uri="/WEB-INF/mnt.tld"%>
	<div class="modal-header" data-ng-init='initFormData(${asJson})'>
            <h3 class="modal-title">Add/Edit doctor</h3>
    </div>
    <div class="modal-body">
    	<fieldset class="border">
    	<legend class="border">Personal Information</legend>
        
			<div>
				<div class="onerow color0-row">
					<label class="col2  small text-right">Name</label>
					<input class="col2" data-palceholder="salutation" data-ng-model="doctorForm.salutation" >
					<input class="col4" data-palceholder="first name" data-ng-model="doctorForm.firstName" >
					<input class="col4" data-palceholder="middle name" data-ng-model="doctorForm.middleName" >
					<input class="col4" data-palceholder="last name" data-ng-model="doctorForm.lastName" >
				</div>
		
				<div class="onerow color1-row">
					<css:ui data-ng-init="doctorForm.gender= 'Male'" 
						data-ng-model="doctorForm.gender" 
						labelClass="col2 small text-right float-none" 
						cType="radio" 
						ds="genderList" 
						
						label="Gender"/>
						
						<div class="dropdown float-none">
							<css:ui  
							data-ng-model="doctorForm.dateOfBirth" 
							value="{{doctorForm.dateOfBirth|date:'MMMM-dd-yyyy'||'From'}}"
							labelClass="small text-right" 
							cType="date" 
							label="Date Of Birth"/>
						</div>
				</div>
	   </fieldset>
	   
	   <fieldset class="border">
    		<legend class="border">Contact Details</legend>
        
			<div>
			   <div class="onerow color0-row">
		   			<label class="col2  small text-right">Address</label>
					<input class="col14" data-ng-model="doctorForm.address" >
		   		</div>
		   		
		   		<div class="onerow color1-row">
		   			<label class="col2  small text-right">City</label>
					<input class="col5" data-ng-model="doctorForm.city" >
					<label class="left2 col2  small text-right">State</label>
					<input class="col5" data-ng-model="doctorForm.state" >
		   		</div>
		   		
		   		<div class="onerow color0-row">
		   			<label class="col2  small text-right">Country</label>
					<input class="col5" data-ng-model="doctorForm.country" >
					<label class="left2 col2  small text-right">Postal Code</label>
					<input class="col5" data-ng-model="doctorForm.postalCode" >
		   		</div>
		   		
		   		<div class="onerow color1-row">
		   			<label class="col2  small text-right">Contact Number</label>
					<input class="col5" data-ng-model="doctorForm.contactNumber" >
					<label class="left2 col2  small text-right">Email</label>
					<input class="col5" data-ng-model="doctorForm.email" >
		   		</div>
		   	</div>
	   </fieldset>
	   
	   <fieldset class="border">
    		<legend class="border">Professional Details</legend>
        
			<div>
			   <div class="onerow color0-row">
		   			<label class="col2  small text-right">Primary Speciality</label>
					<input class="col5" data-ng-model="doctorForm.primarySpeciality" >
					<label class="left2 col2  small text-right">Secondary Speciality</label>
					<input class="col5" data-ng-model="doctorForm.secondarySpeciality" >
		   		</div>
		   		
		   		<div class="onerow color1-row">
		   			<label class="col2  small text-right">Professional Qualification</label>
					<input class="col5" data-ng-model="doctorForm.professionalQualification" >
					<label class="left2 col2  small text-right">Employment Status</label>
					<input class="col5" data-ng-model="doctorForm.employmentStatus" >
		   		</div>
		   		
		   		<div class="onerow color0-row">
		   			<label class="col2  small text-right">Professional Reg. No</label>
					<input class="col5" data-ng-model="doctorForm.professionalRegNo" >
					<label class="left2 col2  small text-right">Federal EIN #</label>
					<input class="col5" data-ng-model="doctorForm.federalEin" >
		   		</div>
		   		
		   		<div class="onerow color1-row">
		   			<label class="col2  small text-right">SSN</label>
					<input class="col5" data-ng-model="doctorForm.ssn" >
					<label class="left2 col2  small text-right">NPI</label>
					<input class="col5" data-ng-model="doctorForm.npi" >
		   		</div>
		   		
		   		<div class="onerow color0-row">
		   			<label class="col2  small text-right">DEA</label>
					<input class="col5" data-ng-model="doctorForm.dea" >
					<label class="left2 col2  small text-right">State Licence</label>
					<input class="col5" data-ng-model="doctorForm.stateLicense" >
		   		</div>
		   		
		   		<div class="onerow color1-row">
		   			<label class="col2  small text-right">UPIN</label>
					<input class="col5" data-ng-model="doctorForm.upin" >
					<label class="left2 col2  small text-right">Taxanomy</label>
					<input class="col5" data-ng-model="doctorForm.taxanomy" >
		   		</div>
		   	</div>
	   </fieldset>
	   
	   <fieldset class="border">
    		<legend class="border">Group Details</legend>
    		<button data-ng-click="groupDetailModal(-1)" type="button" class="btn btn-default btn-sm">
    			<span  class="glyphicon glyphicon-plus"></span>Add
    		</button>
    		
    		<div class="onerow color1-row" data-ng-repeat="gd in doctorForm.groupDetails ">
    				<label class="col2  small text-right">Group Name</label>
					<input class="col5" data-ng-model="gd.groupName" >
					<label class="left2 col2  small text-right">Provider Number</label>
					<input class="col5" data-ng-model="gd.providernumber" >
					<span data-ng-click="groupDetailModal($index)" class="glyphicon glyphicon-pencil"></span>
					
    		</div>
	   </fieldset>
	   
	   <fieldset class="border">
    		<legend class="border">Other Details</legend>
        
			<div>
			   <div class="onerow color1-row">
		   			<label class="col2  small text-right">Rendering Provider</label>
					<input class="col5" data-ng-model="doctorForm.renderingProvider" >
					<css:ui data-ng-init="doctorForm.doctorColor = 'Red'" 
						data-ng-model="doctorForm.doctorColor" 
						labelClass="left2 col2 small text-right" 
						class="col5 last" 
						cType="select" 
						ds="doctorColors" 
						label="Doctor Color"/>
		   		</div>
		   		
		   		<div class="onerow color1-row">
		   			<label class="col2  small text-right">Signature</label>
					<input class="col5" data-ng-model="doctorForm.signature" >
					<label class="left2 col2  small text-right">Signature Text</label>
					<input class="col5" data-ng-model="doctorForm.signatureText">
		   		</div>
		   		
		   		<div class="onerow color1-row">
					<css:ui 
						data-ng-model="doctorForm.allowedScheduledEvent" 
						labelClass="col2 small text-right" 
						class="col14 last" 
						cType="select" 
						ds="getAllowedEvents" 
						label="Allowed Sheduled Events"
						multiple="multiple"
						/>
		   		</div>
		   		
		   		<div class="onerow color1-row">
					<input type="checkbox" data-ng-model="doctorForm.isExternalRefer" class="left2 col2">
					<label class="col3  small text-left">Allow External Referral</label>
					<input type="checkbox" data-ng-model="doctorForm.isAdmin" class="col2 left2 ">
					<label class="col2  small text-left">Allow Admin</label>
		   		</div>
		   	</div>
	   </fieldset>
    </div>
    <div class="modal-footer">
            <button data-ng-show="doctorForm.id == null" class="btn btn-primary" ng-click="saveDoctor()">Save</button>
            <button data-ng-show="doctorForm.id != null" class="btn btn-primary" ng-click="updateDoctor()">Update</button>
    </div>
    
<script  type="text/ng-template" id="add-edit-group.html">    
	<%@include file='/WEB-INF/jsp/module/doctor/view/add-edit-group.html' %>
</script>