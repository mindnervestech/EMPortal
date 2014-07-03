<script type="text/javascript">

controllerProvider.register('DailySchedularContentController', 
		function($scope,$http){
		
	$scope.events = ${events};
	$scope.sections = ${doctorsEvent};
	
	$scope.scheduler = { date : new Date() };
	$scope.scheduler.mode = "unit";
	
	$scope.getDailyScheduledEvents = function(date) {
		console.log($scope.doctorForm);
		$http({method:'PUT', url:'${pageContext.request.contextPath}/events/daily', 
			data:$scope.doctorForm }).success(function(response) {
			
			$scope.events  = response;
			console.log("Daily Events data retrieved.");	
	    });	
	};

	$scope.addAppointment = function() {
	//show dialog popup.
	/* ngDialog.open({
		template: 'add.appointment.html.jsp'		
	});
	 */
	}
});

controllerProvider.register('MonthlySchedularContentController', 
		function($scope,$http){
	$scope.events = ${events};
	$scope.sections = ${doctorsEvent};
		
	$scope.scheduler = { date : new Date(2013,10,1) };
	$scope.scheduler.mode = "timeline";
	
	$scope.getDailyScheduledEvents = function(date) {
		console.log($scope.doctorForm);
		$http({method:'PUT', url:'${pageContext.request.contextPath}/events/monthly', 
			data:$scope.doctorForm }).success(function(response) {
			
			$scope.events = response;
			console.log("Monthly Events data retrieved.");	
		
	    });	
	};
});

</script>
