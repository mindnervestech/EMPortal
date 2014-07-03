	<%@ taglib prefix="css" uri="/WEB-INF/mnt.tld"%>
	<div class="modal-header" data-ng-init='initFormData(${asJson})'>
            <h3 class="modal-title">Add/Edit User</h3>
    </div>
    <div class="modal-body">
    	<fieldset class="border">
    	<legend class="border">Personal Information</legend>
        
			<div>
				<div class="onerow color1-row">
					<label class="col2  small text-right">First Name</label>
					<input class="col4" data-ng-model="userForm.firstName" >
					
					<label class="col2  small text-right">Middle Name</label>
					<input class="col4" data-ng-model="userForm.middleName" >
					
					<label class="col2 small text-right">Last Name</label>
					<input class="col4 last" data-ng-model="userForm.lastName" >
					
				</div>
		
				<div class="onerow color0-row">
					<div>
					<css:ui 
						data-ng-model="userForm.gender" 
						labelClass="col2 small text-right" 
						cType="radio" 
						ds="genderList" 
						label="Gender"/>
					</div>	
						<div class="dropdown col4" style="margin-left: 43%;margin-top: -22px;">
                        	<css:ui  
                            data-ng-model="userForm.dateOfBirth"
                            value="{{userForm.dateOfBirth|date:'MMMM-dd-yyyy'||'From'}}"
                            labelClass="small text-right" 
                            cType="date" 
                            label="Date of Birth"/>
                        </div>        
				</div>
				
				<div class="onerow color1-row">
					<label class="col2  small text-right">Email</label>
					<input class="col4" data-ng-model="userForm.email" >
				
					<label class="col2 small text-right">Contact Number</label>
					<input class="col4" data-ng-model="userForm.contactNumber" >
					
					<label class="col2 small text-right">Address</label>
					<input class="col4 last" data-ng-model="userForm.address" >
					
					<%-- <css:ui data-ng-init="userForm.checkBoxMap.3 = true;userForm.checkBoxMap.2 = true " 
						data-ng-model="userForm.checkBoxMap" 
						labelClass="col2 small text-right" 
						cType="checkbox" 
						ds="dummyMap" 
						label="checkBox"/> --%>
				</div>
				<div class="onerow color0-row">
					<label class="col2 small text-right">City</label>
					<input class="col4" data-ng-model="userForm.city" >
					
					<label class="col2 small text-right">State</label>
					<input class="col4" data-ng-model="userForm.state" >
					
					<label class="col2 small text-right">Zip/Postal Code</label>
					<input class="col4 last" data-ng-model="userForm.postalCode" >
				</div>
				<div class="onerow color1-row">
					<css:ui 
						data-ng-model="userForm.country" 
						labelClass="col2 small text-right" 
						class="col4 last" 
						cType="select" 
						ds="countries" 
						label="Country"/>
					
					<label class="col2 small text-right">Professional Qualification</label>
					<input class="col4" data-ng-model="userForm.professionQualification" >
					
					<label class="col2  small text-right">Allow Web Access</label>
					<input type="checkbox"  data-ng-init="userForm.webAccess = true" data-ng-model="userForm.webAccess" class="col4">
				</div>
				<div class="onerow color0-row">
					<css:ui 
						data-ng-model="userForm.userType" 
						labelClass="col2 small text-right" 
						class="col4 last" 
						cType="select" 
						ds="userTypeList" 
						label="UserType"/>
				</div>
			</div>
	   
	   </fieldset>
    </div>
    <div class="modal-footer">
            <button class="btn btn-primary" ng-click="saveUser()">Save</button>
            <button class="btn btn-primary" ng-click="updateUser()">Update</button>
            <button class="btn btn-primary" ng-click="deleteUser()">Delete</button>
    </div>

