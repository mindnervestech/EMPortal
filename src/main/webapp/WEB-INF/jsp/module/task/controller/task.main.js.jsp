<script type="text/javascript">


controllerProvider.register('TaskContentController',function($scope,$http,Modal){
	//$scope.userForm = ${userForm};
	<%@ include file="/WEB-INF/jsp/component/grid.jsp"%>
	
	$scope.saveTask = function() {
		$http({method:'POST', url:'${pageContext.request.contextPath}/saveTask', data:$scope.taskForm }).success(function(response) {
			Modal.CloseModal();	
			console.log("saved");
	    });	
	};
	
	$scope.updateTask = function() {
		console.log($scope.taskForm);
		$http({method:'PUT', url:'${pageContext.request.contextPath}/updateTask', data:$scope.taskForm }).success(function(response) {
			Modal.CloseModal();	
		
	    });	
	};
	
	$scope.deleteTask = function() {
		console.log($scope.taskForm);
		$http({method:'PUT', url:'${pageContext.request.contextPath}/deleteTask', data:$scope.taskForm }).success(function(response) {
			Modal.CloseModal();	
		
	    });	
	};

	$scope.closeModal = function() {
		Modal.CloseModal();
	};
	
	$scope.initFormData = function(asJsonData) {
		$scope.taskForm = asJsonData;
		
	};
	$scope.openEntityModalById = function(_id) {
		Modal.OpenModal({
			 templateUrl:'add-edit-task.html/'+_id,
			 scope: $scope,
			 windowClass: 'custom-modal'
		},function() {
			
		});
	};
	
});

</script>
