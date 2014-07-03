<script type="text/javascript">


controllerProvider.register('PharmacyContentController',function($scope,$http,Modal){
	//$scope.userForm = ${userForm};
	<%@ include file="/WEB-INF/jsp/component/grid.jsp"%>
	
	$scope.savePharmacy = function() {
		$http({method:'POST', url:'${pageContext.request.contextPath}/savePharmacy', data:$scope.pharmacyForm }).success(function(response) {
			Modal.CloseModal();	
			console.log("saved");
	    });	
	};
	
	$scope.updatePharmacy = function() {
		console.log($scope.userForm);
		$http({method:'PUT', url:'${pageContext.request.contextPath}/updatePharmacy', data:$scope.pharmacyForm }).success(function(response) {
			Modal.CloseModal();	
		
	    });	
	};
	
	$scope.deletePharmacy = function() {
		console.log($scope.pharmacyForm);
		$http({method:'PUT', url:'${pageContext.request.contextPath}/deletePharmacy', data:$scope.pharmacyForm }).success(function(response) {
			Modal.CloseModal();	
		
	    });	
	};

	
	$scope.initFormData = function(asJsonData) {
		$scope.pharmacyForm = asJsonData;
		
	};
	$scope.openEntityModalById = function(_id) {
		Modal.OpenModal({
			 templateUrl:'add-edit-pharmacy.html/'+_id,
			 scope: $scope,
			 windowClass: 'custom-modal'
		},function() {
			
		});
	};
	
});

</script>
