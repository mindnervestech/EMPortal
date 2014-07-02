<script type="text/javascript">


controllerProvider.register('PatientContentController',function($scope,$http,Modal,ngDialog){
	//$scope.userForm = ${userForm};
	<%@ include file="/WEB-INF/jsp/component/grid.jsp"%>
	
	$scope.savePatient = function() {
		console.log($scope.patientForm);
		$http({method:'POST', url:'${pageContext.request.contextPath}/savePatient', data:$scope.patientForm }).success(function(response) {
			Modal.CloseModal();	
			console.log("saved");
	    });	
	};
	
	$scope.updatePatient = function() {
		console.log($scope.patientForm);
		$http({method:'PUT', url:'${pageContext.request.contextPath}/updatePatient', data:$scope.patientForm }).success(function(response) {
			Modal.CloseModal();	
			console.log("updated");
	    });	
	};
	
	$scope.initFormData = function(asJsonData) {
		$scope.patientForm = asJsonData;
	
	};
	
	$scope.openEntityModalById = function(_id) {
		Modal.OpenModal({
			 templateUrl:'add-edit-patient.html/'+_id,
			 scope: $scope,
			 windowClass: 'custom-modal'
		},function() {
			
		});
	};

	$scope.addressDetailModal = function(id) {
		$scope.selectedAddressIndex = id;
		if (id  == -1) {
			$scope.selectedAddress = {};
			angular.copy($scope.patientForm.addressDetails[0], $scope.selectedAddress);
		} else {
			angular.copy($scope.patientForm.addressDetails[id], $scope.selectedAddress);
		}
		ngDialog.open({
		    template: 'add-edit-address.html',
		    scope: $scope,
		    className: 'ngdialog-theme-default'

		});
	};
	
	$scope.addAddressDetail = function () {
		if($scope.selectedAddressIndex == -1) {
			var selectedAddress = {};
			angular.copy($scope.selectedAddress,selectedAddress);
			$scope.patientForm.addressDetails[$scope.patientForm.addressDetails.length] = selectedAddress;
		} else {
			angular.copy($scope.selectedAddress,$scope.patientForm.addressDetails[$scope.selectedAddressIndex]);
		}
	};
	
	$scope.removeAddressDetail = function () {
		$scope.patientForm.addressDetails.splice($scope.selectedAddressIndex, 1);
	};

	//Insurance Detail Section
	$scope.insuranceDetailModal = function(id) {
		$scope.selectedInsuranceIndex = id;
		if (id  == -1) {
			$scope.selectedInsurance = {};
			angular.copy($scope.patientForm.insuranceDetails[0], $scope.selectedInsurance);
		} else {
			angular.copy($scope.patientForm.insuranceDetails[id], $scope.selectedInsurance);
		}
		ngDialog.open({
		    template: 'add-edit-insurances.html',
		    scope: $scope,
		    className: 'ngdialog-theme-default'

		});
	};
	
	$scope.addInsuranceDetail = function () {
		if($scope.selectedInsuranceIndex == -1) {
			var selectedInsurance = {};
			angular.copy($scope.selectedInsurance,selectedInsurance);
			$scope.patientForm.insuranceDetails[$scope.patientForm.insuranceDetails.length] = selectedInsurance;
		} else {
			angular.copy($scope.selectedInsurance,$scope.patientForm.insuranceDetails[$scope.selectedInsuranceIndex]);
		}
	};
	
	$scope.removeInsuranceDetail = function () {
		$scope.patientForm.addressDetails.splice($scope.selectedInsuranceIndex, 1);
	};
});

</script>
