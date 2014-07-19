<script type="text/javascript">


controllerProvider.register('DoctorContentController',function($scope,$http,Modal,ngDialog,$filter){
	//$scope.userForm = ${userForm};
	<%@ include file="/WEB-INF/jsp/component/grid.jsp"%>
	$scope.pillboxs = [{item:"A",value:1},{item:"B",value:2}];
	
	$scope.pillClicked = function(data) {
		data.li.remove();
		$scope.pillboxs = $filter('filter')($scope.pillboxs, function(item){return !(item.item == data.text)}, false);
	};
	
	$scope.saveDoctor = function() {
		console.log($scope.doctorForm);
		$http({method:'POST', url:'${pageContext.request.contextPath}/saveDoctor', data:$scope.doctorForm }).success(function(response) {
			Modal.CloseModal();	
			console.log("saved");
	    });	
	};
	
	$scope.updateDoctor = function() {
		console.log($scope.doctorForm);
		$http({method:'PUT', url:'${pageContext.request.contextPath}/updateDoctor', data:$scope.doctorForm }).success(function(response) {
			Modal.CloseModal();	
		
	    });	
	};
	
	$scope.initFormData = function(asJsonData) {
		$scope.doctorForm = asJsonData;
	};
	
	$scope.closeModal = function() {
		Modal.CloseModal();
	};
	
	$scope.blockBtn = function() {
		alert($scope.getSelectedRows());
	};
	$scope.openEntityModalById = function(_id) {
		Modal.OpenModal({
			 templateUrl:'add-edit-doctor.html/'+_id,
			 scope: $scope,
			 windowClass: 'custom-modal',
			 templateCache: false
			 
		},function() {
			
		});
		
		
	};
	
	$scope.groupDetailModal = function(id) {
		$scope.selectedGroupIndex = id;
		$scope.selectedGroup = {};
		if (id  == -1) {
			angular.copy($scope.doctorForm.groupDetails[0], $scope.selectedGroup);
		} else {
			angular.copy($scope.doctorForm.groupDetails[id], $scope.selectedGroup);
		}
		ngDialog.open({
		    template: 'add-edit-group.html',
		    scope: $scope,
		    className: 'ngdialog-theme-default'

		});
	};
	
	
	
	$scope.addGroupDetail = function () {
		if($scope.selectedGroupIndex == -1) {
			var selectedGroup = {};
			angular.copy($scope.selectedGroup,selectedGroup);
			$scope.doctorForm.groupDetails[$scope.doctorForm.groupDetails.length] = selectedGroup;
		} else {
			angular.copy($scope.selectedGroup,$scope.doctorForm.groupDetails[$scope.selectedGroupIndex]);
		}
	};
	
	$scope.removeGroupDetail = function () {
		$scope.doctorForm.groupDetails.splice($scope.selectedGroupIndex, 1);
	};
});

</script>
