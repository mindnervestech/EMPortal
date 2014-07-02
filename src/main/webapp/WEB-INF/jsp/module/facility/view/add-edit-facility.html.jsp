	<%@ taglib prefix="css" uri="/WEB-INF/mnt.tld"%>
	<div class="modal-header" data-ng-init='initFormData(${asJson})'>
            <h3 class="modal-title">Add/Edit Facility</h3>
    </div>
    <div class="modal-body">
    	<fieldset class="border">
    	<legend class="border">Facility Information</legend>
        
			<div>
				<div class="onerow color1-row">
					<label class="col2  small text-right">Facility Name</label>
					<input class="col4" data-ng-model="facilityForm.facilityName" >
					
					<label class="col2  small text-right">Contact Name</label>
					<css:ui 
							data-ng-model="facilityForm.salutation" 
							labelClass="col2 small" 
							class="pull-left"
							cType="select" 
							ds="getSalutaions"	/>
					<span class="col1"></span>
					<input class="col4" data-ng-model="facilityForm.contactName" >						
				</div>
		
				<div class="onerow color0-row">
					<label class="col2  small text-right">Address 1</label>
					<input class="col14" data-ng-model="facilityForm.address1" >
				</div>
				
				<div class="onerow color1-row">
					<label class="col2  small text-right">Address 2</label>
					<input class="col14" data-ng-model="facilityForm.address2" >
				</div>
				
				<div class="onerow color0-row">
					<label class="col2 small text-right">City</label>
					<input class="col6" data-ng-model="facilityForm.city" >
					
					<label class="col2 small text-right">State</label>
					<input class="col6" data-ng-model="facilityForm.state" >
				</div>
				
				<div class="onerow color1-row">
				
					<label class="col2 small text-right">Zip/Postal Code</label>
					<input class="col6 last" data-ng-model="facilityForm.zipCode" >
					
					<css:ui 
						data-ng-model="facilityForm.country" 
						labelClass="col2 small text-right" 
						class="col6 last" 
						cType="select" 
						ds="countries" 
						label="Country"
						style="margin-right: 10px;"
						/>
				</div>
				
				<div class="onerow color1-row">
				
					<label class="col2 small text-right">Relative URL</label>
					<input class="col4 last" data-ng-model="facilityForm.relativeUrl" >
					
					<label class="col2 small text-right">Website</label>
					<input class="col4 last" data-ng-model="facilityForm.website" >
					
					<label class="col2 small text-right">Email</label>
					<input class="col4 last" data-ng-model="facilityForm.email" >
				</div>
			</div>
	   
	   </fieldset>
    </div>
    <div class="modal-footer">
            <button class="btn btn-primary" ng-click="saveFacility()">Save</button>
            <button class="btn btn-primary" ng-click="updateFacility()">Update</button>
            <button class="btn btn-primary" ng-click="deleteFacility()">Delete</button>
    </div>

