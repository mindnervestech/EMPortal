<script type="text/javascript">
controllerProvider.register('AppointmentController', 
		function($scope,$http, Modal) {
	console.log($scope);
	$scope.patient_selection = false;
	//$scope.patients = ["james","jety"];
	
	$scope.getPatients = function() {
		console.log("getting patients from server on selection.");
	}
	$scope.getMoreDetails = function() {
		console.log("getting patients details from server..");
	}
	
	$scope.onSelectPatient = function() {
		$scope.patient_selection  = true;
		console.log("onSelectPatient");
	}

	$scope.getMoreDetails = function() {
		console.log("getting patients details from server..");
	}
	
	$scope.initFormData = function(appointmentJson, patientJson) {
		$scope.appointmentForm = appointmentJson;
		$scope.patientForm = patientJson;
	};
	
	$scope.onSelectPatient = function() {
		$scope.patient_selection  = true;
		console.log("onSelectPatient");
	}
	
	$scope.saveAppointment = function() {
		console.log("Saving appointment and closing dialog.");
		$scope.patient_selection = false;
		console.log($scope.appointmentForm);
		//call the service to store the data in db.
		$http({method:'POST', url:'${pageContext.request.contextPath}/saveAppointment', 
			data:$scope.appointmentForm }).success(function(response) {
			Modal.CloseModal();	
			console.log("saved");
	    });
	}
	
	$scope.closeAppointment = function() {
		console.log("Closing dialog.");
		$scope.patient_selection = false;
		Modal.CloseModal();
	}
	
	$scope.doctors = ${doctorsEvent};
	
	/*$scope.patients = [	
			{
				id: 1,			
				firstName: 'name1',	
				middleName: 'middle_name',
				lastName: "last_name",				
				dateOfBirth: 'March 21, 2013',
				imgSrc: "",
				phoneNumber: 111-222-333,
				doctorId: 1
			},
			{
				id: 2,			
				firstName: 'name1234',	
				middleName: 'middle_name',
				lastName: "last_name",
				dateOfBirth: 'March 21, 2013',
				imgSrc: "",
				phoneNumber: 111-222-333,
				doctorId: 1
			},
			{
				id: 3,			
				firstName: 'name12345678',	
				middleName: 'middle_name',
				lastName: "last_name",				
				dateOfBirth: 'March 21, 2013',
				imgSrc: "",
				phoneNumber: 111-222-333,
				doctorId: 1
			},
			{
				id: 4,			
				firstName: 'name12349888tfgfg',	
				middleName: 'middle_name',
				lastName: "last_name",				
				dateOfBirth: 'March 21, 2013',
				imgSrc: "",
				phoneNumber: 111-222-333,
				doctorId: 1
			},
			{
				id: 5,			
				firstName: 'name1234ddddrrt555',	
				middleName: 'middle_name',
				lastName: "last_name",				
				dateOfBirth: 'March 21, 2013',
				imgSrc: "",
				phoneNumber: 111-222-333,
				doctorId: 1
			}
		];*/
		 
		var patients = $scope.patients; 
				
        function nameToValue(obj) {
            if (angular.isObject(obj) && angular.isUndefined(obj.value)) {
                obj.value = obj.firstName + " " + obj.lastName;
            }
            return obj;
        }

        function SearchUser() {
        	
            var that = this;
            this.options = {
                html: true,
                minLength: 3, //no. of characters after which call will be trigger to back end for fetching results.
                //outHeight: 100,
                maxWidth: 400,
                source: function (request, response) {
                    // you can $http or $resource service to get data from server.
					var list = [];
					$http({method:'GET', url:'${pageContext.request.contextPath}/findPatients?searchParam='+request.term}).success(function(response1) {
						patients = response1;
						list = patients;
						
						//var list = angular.copy(patients);
	                    var data = [];
	                    angular.forEach(list, function (patient) {
	                        nameToValue(patient);
	                        patient.label = '<li z-index="1" class="media fade.in" style="list-style:none"><a style="cursor:none" class="pull-left" href="#">' + 
								'<img class="media-object" src="${pageContext.request.contextPath}/getPatientImageById/'+ patient.id + '" width=70px height=70px alt="..."> </a>' + 
								'<div class="media-body"><h6 class="media-heading">' +
								'<h6 class="media-heading">' + patient.firstName + ' ' + patient.middleName + ' ' + patient.lastName + '</h6>' +
								'<p>' + moment(patient.dateOfBirth).format("DD-MM-YYYY") + '</p><p>' + patient.email + '</p>' + 
								'<p>' + patient.phoneNumber + '</p>' + 
								'</div>' + 
								'</li>';
	                    });
	                    // filter data, methods will be added after uiAutocomplete initialized.
	                    list = that.methods.filter(list, request.term);
						
						angular.forEach(list, function (patient) {
	                        data.push(patient);
	                    });
						// response data to suggestion menu.
	                    response(data);
					});
					
                    
                },
            	select: function( event, ui ) {
            		var patient = ui.item;
            		console.log(patient);
            		$scope.appointmentForm.appointmentOfId = patient.id;
            	}
            };
            this.events = {
                change: function (event, ui) {
					if (ui.item != null) {
						$scope.patient_selection = true;
						$scope.appointmentForm.appointmentWithId = ui.item.doctorId;
					}
                }
            };
        }

        //$scope.patients = [];

        $scope.changeClass = function (options) {
            var widget = options.methods.widget();
            // remove default class, use bootstrap style
            widget.removeClass('ui-menu ui-corner-all ui-widget-content').addClass('dropdown-menu');
        };

        $scope.searchUser = function () {
            this.searchUser = new SearchUser();
            return this.searchUser;
        };
});
</script>