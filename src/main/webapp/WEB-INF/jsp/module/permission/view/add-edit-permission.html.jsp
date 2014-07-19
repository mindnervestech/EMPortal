	<%@ taglib prefix="css" uri="/WEB-INF/mnt.tld"%>
	<div class="modal-header" data-ng-init='initFormData(${asJson})'>
            <h3 class="modal-title" style="width: 95%; float: left;">Manage Permission</h3>
            <span class="glyphicon glyphicon-remove" style="top: 12px;cursor: pointer;" data-ng-click="closeModal()"></span>
    </div>
    <div class="modal-body">
    	<fieldset class="border">
    		<input type="hidden" value="${role_id}" class="role_id">
			<div>
				<div class="onerow color1-row" data-ng-repeat="p in permissions">
					<label>{{p.permissionName}}</label>
					<input type="checkbox" class="col1" data-ng-model="p.allowed" >
				</div>
			</div>
	   </fieldset>
    </div>
    <div class="modal-footer">
            <button class="btn btn-primary" ng-click="savePermission()">Save</button>
    </div>

