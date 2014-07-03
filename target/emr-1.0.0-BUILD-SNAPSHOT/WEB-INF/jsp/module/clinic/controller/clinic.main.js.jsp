<script type="text/javascript">


controllerProvider.register('ClinicContentController',function($scope,$http,Modal){

	<%@ include file="/WEB-INF/jsp/component/grid.jsp"%>
	
	$scope.saveClinic = function() {
		$http({method:'POST', url:'${pageContext.request.contextPath}/saveClinic', data:$scope.clinicForm }).success(function(response) {
			Modal.CloseModal();	
			console.log("saved");
	    });	
	};
	
	$scope.updateClinic = function() {
		console.log($scope.clinicForm);
		$http({method:'PUT', url:'${pageContext.request.contextPath}/updateClinic', data:$scope.clinicForm }).success(function(response) {
			Modal.CloseModal();	
		
	    });	
	};
	
	$scope.deleteClinic = function() {
		console.log($scope.clinicForm);
		$http({method:'PUT', url:'${pageContext.request.contextPath}/deleteClinic', data:$scope.clinicForm }).success(function(response) {
			Modal.CloseModal();	
		
	    });	
	};

	
	$scope.initFormData = function(asJsonData) {
		$scope.clinicForm = asJsonData;
		
	};
	$scope.openEntityModalById = function(_id) {
		Modal.OpenModal({
			 templateUrl:'add-edit-clinic.html/'+_id,
			 scope: $scope,
			 windowClass: 'custom-modal'
		},function() {
			
		});
	};
	
});

</script>
