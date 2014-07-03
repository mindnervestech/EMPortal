	<%@ taglib prefix="css" uri="/WEB-INF/mnt.tld"%>
	<div class="modal-header" data-ng-init='initFormData(${asJson})'>
            <h3 class="modal-title">Add/Edit Pharmacy</h3>
    </div>
    <div class="modal-body">
    	<fieldset class="border">
    	<legend class="border">Pharmacy Information</legend>
        
			<div>
				<div class="onerow color1-row">
					<label class="col2  small text-right">Name</label>
					<input class="col4" data-ng-model="pharmacyForm.name" >
					
					<label class="col2  small text-right">Address</label>
					<input class="col4" data-ng-model="pharmacyForm.address" >
					
					<label class="col2 small text-right">Address 2</label>
					<input class="col4 last" data-ng-model="pharmacyForm.address2" >
					
				</div>
		
				<div class="onerow color0-row">
					<label class="col2  small text-right">city</label>
					<input class="col4" data-ng-model="pharmacyForm.city" >
				
					<label class="col2 small text-right">State</label>
					<input class="col4" data-ng-model="pharmacyForm.state" >
					
					<label class="col2 small text-right">Zip/Postal</label>
					<input class="col4 last" data-ng-model="pharmacyForm.postalCode" >
				</div>
				
				<div class="onerow color1-row">
					<label class="col2 small text-right">Email</label>
					<input class="col4" data-ng-model="pharmacyForm.email" >
					
					<label class="col2 small text-right">Phone</label>
					<input class="col4" data-ng-model="pharmacyForm.phone" >
					
					<label class="col2 small text-right">Fax</label>
					<input class="col4 last" data-ng-model="pharmacyForm.fax" >
				</div>
				<div class="onerow color0-row">
					<css:ui 
						data-ng-model="pharmacyForm.method" 
						labelClass="col2 small text-right" 
						class="col4 last" 
						cType="select" 
						ds="methods" 
						label="Communication Method"/>
				</div>
				
			</div>
	   
	   </fieldset>
    </div>
    <div class="modal-footer">
            <button data-ng-show="pharmacyForm.id == null" class="btn btn-primary" ng-click="savePharmacy()">Save</button>
            <button data-ng-show="pharmacyForm.id != null" class="btn btn-primary" ng-click="updatePharmacy()">Update</button>
            <button data-ng-show="pharmacyForm.id != null" class="btn btn-primary" ng-click="deletePharmacy()">Delete</button>
    </div>

