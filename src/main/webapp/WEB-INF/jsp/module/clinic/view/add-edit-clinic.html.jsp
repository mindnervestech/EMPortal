	<%@ taglib prefix="css" uri="/WEB-INF/mnt.tld"%>
	<div class="modal-header" data-ng-init='initFormData(${asJson})'>
            <h3 class="modal-title" style="width: 95%; float: left;">Add/Edit Clinic</h3>
            <span class="glyphicon glyphicon-remove" style="top: 12px;cursor: pointer;" data-ng-click="closeModal()"></span>
    </div>
    <div class="modal-body">
    	<fieldset class="border">
    	<legend class="border">Clinic Information</legend>
        
			<div>
				<div class="onerow color1-row">
					<label class="col2  small text-right">Clinic Name</label>
					<input class="col4" data-ng-model="clinicForm.name" >
					
					<label class="col2  small text-right">Address 1</label>
					<input class="col4" data-ng-model="clinicForm.address1" >
					
					<label class="col2 small text-right">Address 2</label>
					<input class="col4 last" data-ng-model="clinicForm.address2" >
					
				</div>
		
				<div class="onerow color0-row">
					<label class="col2  small text-right">city</label>
					<input class="col4" data-ng-model="clinicForm.city" >
				
					<label class="col2 small text-right">State</label>
					<input class="col4" data-ng-model="clinicForm.state" >
					
					<label class="col2 small text-right">Zip/Postal</label>
					<input class="col4 last" data-ng-model="clinicForm.postalCode" >
				</div>
				
				<div class="onerow color1-row">
					<css:ui 
						data-ng-model="clinicForm.country" 
						labelClass="col2 small text-right" 
						class="col4 last" 
						cType="select" 
						ds="countries" 
						label="Country"/>
					
					<label class="col2 small text-right">Phone</label>
					<input class="col4" data-ng-model="clinicForm.phone" >
					
					<label class="col2 small text-right">Ext</label>
					<input class="col4 last" data-ng-model="clinicForm.ext" >
				</div>
				<div class="onerow color0-row">
					<label class="col2 small text-right">Contact Name</label>
					<input class="col4 last" data-ng-model="clinicForm.contactName" >
					
					<label class="col2  small text-right">Internal Location</label>
					<input type="checkbox" class="col1 last" data-ng-model="clinicForm.internalLocation" style="margin-left: -2%;">
					
					<label class="col2  small text-right" style="margin-left: -2%;">Dial Area Code</label>
					<input type="checkbox" class="col1 last" data-ng-model="clinicForm.dialAreaCode" style="margin-left: -2%;">
				
					<label class="col2  small text-right" style="margin-left: -2%;">Display in Scheduling</label>
					<input type="checkbox" class="col1 last" data-ng-model="clinicForm.displayInScheduling" style="margin-left: -2%;">
					
					<label class="col2  small text-right" style="margin-left: -2%;">Optical Location</label>
					<input type="checkbox" class="col1 last" data-ng-model="clinicForm.opticalLocation" style="margin-left: -2%;">
					
					<label class="col2  small text-right" style="margin-left: -2%;">Facility Location</label>
					<input type="checkbox" class="col1 last" data-ng-model="clinicForm.facilityLocation" style="margin-left: -2%;">
				</div>
				<div class="onerow color1-row">
					<css:ui 
						data-ng-model="clinicForm.placeOfService" 
						labelClass="col2 small text-right" 
						class="col4 last" 
						cType="select" 
						ds="placeOfServices" 
						label="Place of Service"/>
					
					<label class="col2 small text-right">Facility NPI</label>
					<input class="col4" data-ng-model="clinicForm.facilityNPI" >
					
					<label class="col2 small text-right">Facility Entity ID</label>
					<input class="col4 last" data-ng-model="clinicForm.facilityEntityId" >
				</div>
				<div class="onerow color0-row">
					<label class="col2 small text-right">Note</label>
					<textarea class="col4" data-ng-model="clinicForm.note"></textarea>
					
					<label class="col2 small text-right">Directions</label>
					<textarea class="col4 last" data-ng-model="clinicForm.directions"></textarea>
				</div>
			</div>
	   
	   </fieldset>
    </div>
    <div class="modal-footer">
            <button data-ng-show="clinicForm.id == null" class="btn btn-primary" ng-click="saveClinic()">Save</button>
            <button data-ng-show="clinicForm.id != null" class="btn btn-primary" ng-click="updateClinic()">Update</button>
            <button data-ng-show="clinicForm.id != null" class="btn btn-primary" ng-click="deleteClinic()">Delete</button>
    </div>

