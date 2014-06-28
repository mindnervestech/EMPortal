<script type="text/javascript">


controllerProvider.register('UserContentController',function($scope,$http,Modal){
	//$scope.userForm = ${userForm};
	<%@ include file="/WEB-INF/jsp/component/grid.jsp"%>
	
	$scope.saveUser = function() {
		$http({method:'POST', url:'${pageContext.request.contextPath}/saveUser', data:$scope.userForm }).success(function(response) {
			Modal.CloseModal();	
			console.log("saved");
	    });	
	};
	
	$scope.updateUser = function() {
		console.log($scope.userForm);
		$http({method:'PUT', url:'${pageContext.request.contextPath}/updateUser', data:$scope.userForm }).success(function(response) {
			Modal.CloseModal();	
		
	    });	
	};
	
	$scope.deleteUser = function() {
		console.log($scope.userForm);
		$http({method:'PUT', url:'${pageContext.request.contextPath}/deleteUser', data:$scope.userForm }).success(function(response) {
			Modal.CloseModal();	
		
	    });	
	};

	
	$scope.initFormData = function(asJsonData) {
		$scope.userForm = asJsonData;
		
	};
	$scope.openEntityModalById = function(_id) {
		Modal.OpenModal({
			 templateUrl:'add-edit-user.html/'+_id,
			 scope: $scope,
			 windowClass: 'custom-modal'
		},function() {
			
		});
	};
	
});

</script>
