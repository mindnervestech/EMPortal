<script type="text/javascript">


controllerProvider.register('InsuranceCompanyContentController',function($scope,$http,Modal){
	//$scope.userForm = ${userForm};
	<%@ include file="/WEB-INF/jsp/component/grid.jsp"%>
	
	$scope.saveinsuranceCompany = function() {
		$http({method:'POST', url:'${pageContext.request.contextPath}/saveinsuranceCompany', data:$scope.insuranceCompanyForm }).success(function(response) {
			Modal.CloseModal();	
			console.log("saved");
	    });	
	};
	
	$scope.updateinsuranceCompany = function() {
		console.log($scope.insuranceCompanyForm);
		$http({method:'PUT', url:'${pageContext.request.contextPath}/updateinsuranceCompany', data:$scope.insuranceCompanyForm }).success(function(response) {
			Modal.CloseModal();	
		
	    });	
	};
	
	$scope.deleteinsuranceCompany = function() {
		console.log($scope.insuranceCompanyForm);
		$http({method:'PUT', url:'${pageContext.request.contextPath}/deleteinsuranceCompany', data:$scope.insuranceCompanyForm }).success(function(response) {
			Modal.CloseModal();	
		
	    });	
	};

	
	$scope.initFormData = function(asJsonData) {
		$scope.insuranceCompanyForm = asJsonData;
		
	};
	$scope.openEntityModalById = function(_id) {
		Modal.OpenModal({
			 templateUrl:'add-edit-insuranceCompany.html/'+_id,
			 scope: $scope,
			 windowClass: 'custom-modal'
		},function() {
			
		});
	};
	
});

</script>
