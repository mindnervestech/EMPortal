<script>
'use strict';

    controllerProvider.register('AppointmentController', function($scope, $compile) {
	
		$scope.patients = [			
			{
				patientId: 1,			
				patientName: 'name1',			
				age: 25,
				email: 'name1@gmail.com',
				desc: 'user, 111111111111111111',
				imgSrc: "",
				telNo: 12343
			},
			{
				patientId: 2,			
				patientName: 'vinod',			
				age: 25,
				email: 'vinod@gmail.com',
				desc: 'vinod, 111111111111111111',
				imgSrc: "vindy.jpg",
				telNo: 12343
			},
			{
				patientId: 2,			
				patientName: 'vinodlslloo',			
				age: 25,
				email: 'vinod@gmail.com',
				desc: 'vinod, 111111111111111111',
				imgSrc: "vindy.jpg",
				telNo: 12343
			},
			{
				patientId: 2,			
				patientName: 'vinod123',			
				age: 25,
				email: 'vinod@gmail.com',
				desc: 'vinod, 111111111111111111',
				imgSrc: "vindy.jpg",
				telNo: 12343
			},
			{
				patientId: 2,			
				patientName: 'vinod456456',			
				age: 25,
				email: 'vinod@gmail.com',
				desc: 'vinod, 111111111111111111',
				imgSrc: "vindy.jpg",
				telNo: 12343
			},
			{
				patientId: 2,			
				patientName: 'vinod54646fghfg',			
				age: 25,
				email: 'vinod@gmail.com',
				desc: 'vinod, 111111111111111111',
				imgSrc: "vindy.jpg",
				telNo: 12343
			}
		];
		 
		var patients = $scope.patients; 
				
        function nameToValue(obj) {
            if (angular.isObject(obj) && angular.isUndefined(obj.value)) {
                obj.value = obj.patientName;
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
                    var list = angular.copy(patients);
                    var group = {}, data = [];

                    angular.forEach(list, function (patient) {
                        nameToValue(patient);
                        patient.label = '<li class="media" style="list-style:none"><a style="cursor:none" class="pull-left" href="#">' + 
							'<img class="media-object" src="'+'160009.jpg' + '" style="width:40px;height:40px;" alt="..."> </a>' + 
							'<div class="media-body"><h6 class="media-heading">' +
							'<h6 class="media-heading">' + patient.patientName + '</h6>' +
							'<p>' + patient.desc + '|' + patient.email + '</p>' + 
							'<p>' + patient.telNo+ '</p>' + 
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
                }
            };
            this.events = {
                change: function (event, ui) {
                    console.log(ui);
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