<script type="text/javascript">

controllerProvider.register('DailySchedularContentController', 
		function($scope,$http, Modal,ngDialog){
	$scope.sections = ${doctorsEvent};
	$scope.resourceIds=[];
	 angular.forEach($scope.sections , function(obj, key) {
		 $scope.resourceIds.push(obj.key);
	 });
	//console.log(${doctorsEvent});
	//console.log(${events});
	
	$scope.scheduler = { date : new Date() };
	$scope.scheduler.mode = "unit";
	
	$scope.getDailyScheduledEvents = function(date) {
		/* console.log(date);
		var json = {"date_requested" : date};
		$http({method:'GET', url:'${pageContext.request.contextPath}/events/daily', 
			params : json }).success(function(response) {
			console.log("Daily Events data retrieved.");	
	    });	 */
	};

	$scope.closeModal = function() {
		Modal.CloseModal();
	};
	
	$scope.renderAppointmentView = function(_id) {
		Modal.OpenModal({
			 templateUrl:'add-edit-appointment.html/'+_id,
			 scope: $scope,
			 windowClass: 'custom-modal',
			 backdrop : false
		},function() {
			
		});
	};
	
	
	//From Appointment.js
	
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
	
	$scope.showOHideSelectedResource = function(key,isChecked) {
		if(!isChecked) {
			$scope.resourceIds.push(key);
		} else {
			var index = $scope.resourceIds.indexOf(key);
			$scope.resourceIds.splice(index, 1);
		}
		
		$http({method:'POST', url:'${pageContext.request.contextPath}/getAppointmentsByResources',
			data : $scope.resourceIds}).success(function(response) {
				scheduler.updateCollection("units", response.doctorsEvent);
				scheduler.clearAll();
				scheduler.updateView();
				scheduler.parse(response.events,"json");
		});
	};
	
	$scope.initFormData = function(appointmentJson,patientJson) {
		if(appointmentJson.id != null) {
			$scope.appointmentForm = appointmentJson;
			$scope.patientInfo = patientJson;
			$scope.patient = patientJson.firstName + " " + patientJson.lastName;
		} else {
			$scope.patient = "";
		}
	};
	
	$scope.saveAppointment = function() {
		$scope.patient_selection = false;
		//call the service to store the data in db.
		$http({method:'POST', url:'${pageContext.request.contextPath}/saveAppointment', 
			data:$scope.appointmentForm }).success(function(response) {
			Modal.CloseModal();	
			scheduler.clearAll();
			scheduler.updateView();
			console.log("saved");
	    });
	}
	
	$scope.updateAppointment = function() {
		console.log("updating appointment and closing dialog.");
		//call the service to store the data in db.
		$http({method:'PUT', url:'${pageContext.request.contextPath}/updateAppointment', 
			data:$scope.appointmentForm }).success(function(response) {
			Modal.CloseModal();	
			scheduler.clearAll();
			scheduler.updateView();
			console.log("saved");
	    });
	};
	
	$scope.deleteAppointment = function() {
		$http({method:'DELETE', url:'${pageContext.request.contextPath}/deleteAppointment', 
			params : {"appointment_id" : $scope.appointmentForm.id } }).success(function(response) {
			Modal.CloseModal();	
			scheduler.clearAll();
			scheduler.updateView();
			console.log("deleted");
	    });
	};
	
	$scope.closeAppointment = function() {
		console.log("Closing dialog.");
		$scope.patient_selection = false;
		Modal.CloseModal();
	}
	
	$scope.doctors = ${doctorsEvent};
	
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
        		$scope.appointmentForm.appointmentOfId = patient.id;
        		$scope.patientInfo = patient;
        	}
        };
        this.events = {
            change: function (event, ui) {
				if (ui.item != null) {
					//$scope.patient_selection = true;
					//$scope.appointmentForm.appointmentWithId = ui.item.doctorId;
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
    
    /* End Copying appointment.js */
    
	$scope.demographicsDataView = function() {
		ngDialog.open({
		    template: 'demographics_view.jsp',
		    scope: $scope,
		    className: 'ngdialog-theme-default'
		});
	};
	
	$scope.insuranceDataView = function() {
		ngDialog.open({
		    template: 'insurance_view.jsp',
		    scope: $scope,
		    className: 'ngdialog-theme-default'

		});
	};
	$scope.dataReleaseView = function() {
		ngDialog.open({
		    template: 'data_release_view.jsp',
		    scope: $scope,
		    className: 'ngdialog-theme-default'

		});
	};
	
});

controllerProvider.register('MonthlySchedularContentController', 
		function($scope,$http, Modal,ngDialog){
	$scope.events = ${events};
	$scope.sections = ${doctorsEvent};
		
	$scope.scheduler = { date : new Date(2013,10,1) };
	$scope.scheduler.mode = "timeline";
	
	$scope.getDailyScheduledEvents = function(date) {
		console.log($scope.appointmentForm);
		$http({method:'PUT', url:'${pageContext.request.contextPath}/events/monthly', 
			data:$scope.appointmentForm }).success(function(response) {
			$scope.events = response;
			console.log("Monthly Events data retrieved.");	
	    });	
	};
});

</script>
