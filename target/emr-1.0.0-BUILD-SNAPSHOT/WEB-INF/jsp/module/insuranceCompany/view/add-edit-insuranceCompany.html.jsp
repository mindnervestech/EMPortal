	<%@ taglib prefix="css" uri="/WEB-INF/mnt.tld"%>
	<div class="modal-header" data-ng-init='initFormData(${asJson})'>
            <h3 class="modal-title">Add/Edit Insurance Company</h3>
    </div>
    <div class="modal-body">
    	<fieldset class="border">
    	<legend class="border">InsuranceCompany Information</legend>
        
			<div>
				<div class="onerow color1-row">
					<label class="col2  small text-right">Name</label>
					<input class="col4" data-ng-model="insuranceCompanyForm.name" >
					
					<label class="col2  small text-right">Attn</label>
					<input class="col4" data-ng-model="insuranceCompanyForm.attn" >
					
					<label class="col2 small text-right">Address</label>
					<input class="col4 last" data-ng-model="insuranceCompanyForm.address" >
					
				</div>
		
				<div class="onerow color0-row">
					<label class="col2  small text-right">Address 2</label>
					<input class="col4" data-ng-model="insuranceCompanyForm.address2" >
				
					<label class="col2 small text-right">City</label>
					<input class="col4" data-ng-model="insuranceCompanyForm.city" >
					
					<label class="col2 small text-right">State</label>
					<input class="col4 last" data-ng-model="insuranceCompanyForm.state" >
				</div>
				
				<div class="onerow color1-row">
					<label class="col2 small text-right">Zip/Postal</label>
					<input class="col4" data-ng-model="insuranceCompanyForm.postalCode" >
					
					<label class="col2 small text-right">Phone</label>
					<input class="col4" data-ng-model="insuranceCompanyForm.phone" >
					
					<label class="col2 small text-right">CMS ID</label>
					<input class="col4 last" data-ng-model="insuranceCompanyForm.cmsId" >
				</div>
				<div class="onerow color0-row">
					<css:ui 
						data-ng-model="insuranceCompanyForm.payerType" 
						labelClass="col2 small text-right" 
						class="col4 last" 
						cType="select" 
						ds="payerTypes" 
						label="Payer Type"/>
				</div>
				
			</div>
	   
	   </fieldset>
    </div>
    <div class="modal-footer">
            <button data-ng-show="insuranceCompanyForm.id == null" class="btn btn-primary" ng-click="saveinsuranceCompany()">Save</button>
            <button data-ng-show="insuranceCompanyForm.id != null" class="btn btn-primary" ng-click="updateinsuranceCompany()">Update</button>
            <button data-ng-show="insuranceCompanyForm.id != null" class="btn btn-primary" ng-click="deleteinsuranceCompany()">Delete</button>
    </div>

