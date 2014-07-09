controllerProvider.register('AppointmentController', 
		function($scope,$http, Modal) {
	
	$scope.patient_selection = false;
	$scope.patients = ["James", "Jecky"];
	
	$scope.getPatients = function() {
		console.log("getting patients from server on selection.");
	$scope.getMoreDetails = function() {
		console.log("getting patients details from server..");
	}
	
	$scope.onSelectPatient = function() {
		$scope.patient_selection  = true;
		console.log("onSelectPatient");
	}
	
	$scope.saveAppointment = function() {
	};
	
	$scope.getMoreDetails = function() {
		console.log("getting patients details from server..");
	}
	
	$scope.onSelectPatient = function() {
		$scope.patient_selection  = true;
		console.log("onSelectPatient");
	}
	
	$scope.saveAppointment = function() {
		console.log("Saving appointment and closing dialog.");
		Modal.CloseModal();
	}
	
	$scope.closeAppointment = function() {
		console.log("Closing dialog.");
		Modal.CloseModal();
	}
})