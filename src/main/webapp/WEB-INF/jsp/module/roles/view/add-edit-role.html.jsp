	<%@ taglib prefix="css" uri="/WEB-INF/mnt.tld"%>
	<div class="modal-header" data-ng-init='initFormData(${asJson})'>
            <h3 class="modal-title">Add Roles</h3>
    </div>
    <div class="modal-body">
    	<div class="onerow color0-row fieldset" data-ng-repeat="r in roles">
    		<label class="col2">Role {{$index+1}}</label>
    		<input class="col4" type="text" data-ng-model="r.name">
    	</div>
    	<button style="margin-top: 10px;" class="btn btn-sm btn-success last pull-left" data-ng-click="addNewRole()">Add more</button>
    </div>
    <div class="modal-footer">
            <button data-ng-show="clinicForm.id == null" style="margin-top: 10px;"  class="btn btn-primary" ng-click="saveRole()">Save</button>
            <button data-ng-show="clinicForm.id != null" style="margin-top: 10px;"  class="btn btn-primary" ng-click="updateRole()">Update</button>
    </div>

