<script type="text/javascript">


controllerProvider.register('PermissionContentController',function($scope,$http,Modal){
	//$scope.userForm = ${userForm};
	<%@ include file="/WEB-INF/jsp/component/grid.jsp"%>
	
	$scope.saveFacility = function() {
		$http({method:'POST', url:'${pageContext.request.contextPath}/saveFacilityByAdmin', data:$scope.facilityForm }).success(function(response) {
			Modal.CloseModal();	
			console.log("saved");
	    });	
	};
	
	$scope.updateFacility = function() {
		$http({method:'PUT', url:'${pageContext.request.contextPath}/updateFacility', data:$scope.facilityForm }).success(function(response) {
			Modal.CloseModal();	
		
	    });	
	};
	
	$scope.deleteFacility = function() {
		$http({method:'PUT', url:'${pageContext.request.contextPath}/deleteFacility', data:$scope.facilityForm }).success(function(response) {
			Modal.CloseModal();	
			
	    });	
	};

	$scope.blockBtn = function() {
		alert($scope.getSelectedRows());
	};
	
	$scope.approveFacilities = function() {
		var ids = {
			"ids" : $scope.getSelectedRows()
		};
		
		$http({method:'GET', url:'${pageContext.request.contextPath}/approveFacility', params : ids }).success(function(response) {
			console.log("success");
	    });
	};
	
	$scope.initFormData = function(asJsonData) {
		$scope.facilityForm = asJsonData;
		
	};
	$scope.openEntityModalById = function(_id) {
		Modal.OpenModal({
			 templateUrl:'add-edit-permission.html/'+_id,
			 scope: $scope,
			 windowClass: 'custom-modal'
		},function() {
			
		});
	};
	
});

</script>
