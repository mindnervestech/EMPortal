	<%@ taglib prefix="css" uri="/WEB-INF/mnt.tld"%>
	<style>
     .ui-helper-hidden-accessible { //this css is require to disable to helper message shown (no. of results available)
        display: none !important;
      }
	  
	  .media-heading {
		margin: 0 0 0 !important;
	  }
	  
	  p {
		margin: 0 0 0 !important;
	  }
	  
	  .ui-helper-hidden-accessible {
		display: none !important;
	  }
	  
	  .dropdown-menu {
	  	z-index: 2000 !important;
	  }
    </style>
	
	<div class="modal-header" data-ng-init='initFormData(${appointmentJson}, ${patientJson})'>
            <h3 class="modal-title">Appointment</h3>
    </div>
    <div class="modal-body">
    	<fieldset class="border">
			<legend class="border">Select Preferences</legend>
				<div class="onerow color0-row">
					<label class="col2  small text-right">Patient</label>
					<!--<autocomplete class="col4" data-palceholder="patient name" data="patients" data-ng-model="appointmentForm.patientId" 
	                		click-activation="true" on-type="getPatients" on-complete="onSelectPatient"></autocomplete>-->
						<input class="col4" type="text" placeholder="Search in patient names" ng-model="patient" ui-event="{autocompletecreate:'changeClass(searchUser)'}" ui-autocomplete="searchUser()">
					<css:ui 
						data-ng-model="appointmentForm.visitType" 
						labelClass="left2 col4 small" 
						class="col5 last" 
						cType="select" 
						ds="visitTypes" 
						label="Visit Type"/>
				</div>
				
				<div class="onerow color0-row">
					<label class="col2  small text-right">Doctor:</label>
					<select name="doctorId" class="col2  small text-left" data-ng-model="appointmentForm.appointmentWithId" 
						data-ng-options="doctor.key as doctor.firstName for doctor  in doctors" data-ng-disabled="false">
						<!--<option value="doctor.key">{{doctor.doctoName}}</option>-->
					</select>
					<input class="col2  small text-right" type="checkbox" data-ng-model="serviceType"/>
					<css:ui data-ng-disabled="!serviceType"
						labelClass="left2 col2 small" 
						class="col5 last" 
						cType="select" 
						ds="serviceTypes" 
						label="Service Type"/>
				</div>
		</fieldset>
				<!-- show the details about the selected patient. if no patient selected then this block will not be shown. -->
		<fieldset class="border" data-ng-show="appointmentForm.appointmentOfId != undefined">
			<legend class="border">Patient Information</legend>
				<div class="onerow color0-row">
					<div class="col-md-5">
						<div>
							  <img ng-src="resources/app/favicon.ico" />
							  <label>{{patientInfo.salutation}} {{patientInfo.firstName}}&nbsp;{{patientInfo.lastName}}</label>
							  <p><label>{{patientInfo.dateOfBirth | date:'dd-MM-yyyy'}}</label></p>
							  <p><label>(P): </label><span>{{patientInfo.phoneNumber}}</span></p>
							  <p>(M):{{patientInfo.mobileNumber}}</p>
							  <p>(M):{{patientInfo.email}}<p>
						</div>
					</div>
					<div class="col-md-5">
						  <p>Mother:{{patientInfo.parent}}</p>
						  <p>Guardian:{{patientInfo.guardianName}}</p>
						  <p>SS#:{{patientInfo.Ssn}}</p>
						  <p>Ethinity#:{{patientInfo.ethnicity}}</p>
					</div>
					<div  class="col-md-2 text-center">
						<p>Photo ID</p>
						<img ng-src="resources/app/favicon.ico" />
					</div>
				</div>
				<div class="col-md-8 onerow color0-row ng-hide"  data-ng-show="patient_selection">
					<p>Address: </p>
					
				</div>
		</fieldset>
		<fieldset class="border">
			<legend class="border">Details</legend>
				<!-- <div class="onerow color0-row">
					<label class="col2  small text-right">Insurance:</label>
					<input class="col4" data-palceholder="Insurance" data-ng-model="appointmentInfo.insuranceCarrier_1_No">
					<select data-ng-model="appointmentForm.insuranceCarrier_1_No" ng-data-disabled="true">
						<option value="patientInfo.insuranceCarrier_1_No">{{patientInfo.insuranceCarrier_1_Name}}</option>
					</select>
				</div> -->
				<div class="onerow color0-row">
					
						<div class="col-md-4">
							<css:ui  
							data-ng-model="appointmentForm.appointmentDmy" 
							value="{{appointmentForm.appointmentDmy|date:'dd-MM-yyyy'||'From'}}"
							labelClass="small text-right" 
							cType="date" 
							label="Appointment Date"/>
						</div>
						<div class="col-md-4">
							<label class="col6  small text-right">Appointment Start Time:</label>
							<input type="text" class="col4"  data-ng-model="appointmentForm.startMin">
						</div>
				</div>
	   </fieldset>
    </div>
    <div class="modal-footer">
            <button data-ng-show="appointmentForm.id==null" class="btn btn-primary" data-ng-click="saveAppointment()">Save</button>
            <button data-ng-show="appointmentForm.id!=null" class="btn btn-primary" data-ng-click="updateAppointment()">Update</button>
            <button data-ng-show="appointmentForm.id!=null" class="btn btn-primary" data-ng-click="deleteAppointment()">Delete</button>
            <button class="btn btn-primary" data-ng-click="closeAppointment()">Cancel</button>
    </div>
  
