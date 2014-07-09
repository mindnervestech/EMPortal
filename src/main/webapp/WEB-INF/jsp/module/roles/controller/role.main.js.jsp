<script type="text/javascript">


controllerProvider.register('RoleContentController',function($scope,$http,Modal){

	<%@ include file="/WEB-INF/jsp/component/grid.jsp"%>
	
	$scope.saveRole = function() {
		$http({method:'POST', url:'${pageContext.request.contextPath}/saveRole', data: {"roles" :$scope.roles } }).success(function(response) {
			Modal.CloseModal();	
			console.log("saved");
	    });	
	};
	
	$scope.updateRole = function() {
		console.log($scope.clinicForm);
		$http({method:'PUT', url:'${pageContext.request.contextPath}/updateRole', data:$scope.roles }).success(function(response) {
			Modal.CloseModal();	
		
	    });	
	};
	
	$scope.addNewRole = function() {
		$scope.roles.push({}); 
	};
	
	$scope.initFormData = function(asJsonData) {
		console.log(asJsonData);
		$scope.roles = asJsonData;
		
	};
	$scope.openEntityModalById = function(_id) {
		Modal.OpenModal({
			 templateUrl:'add-edit-role.html/'+_id,
			 scope: $scope,
			 windowClass: 'custom-modal'
		},function() {
			
		});
	};
	
});

</script>
