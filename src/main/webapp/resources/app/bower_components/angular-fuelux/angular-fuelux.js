/**
 * angular-fuelux version 0.1
 * License: MIT.
 * Copyright (C)  2014, Jagbir singh and contributors.
 */

(function(window, angular, undefined) {
	'use strict';

	angular.module('angularFuelux', [])
	



		.directive('ngPillbox', ['$window','$parse', function ($window,$parse) {
			return {
				
				require: '^ngModel',
				scope: {
				      ngModel: '=',
				      onAdded: '&',
				      onRemoved: '&',
				      onItemClick:'&',
				      pillClass:'@'
				},
				
				template: '<ul>' +
							'<li ng-class="pillClass" ng-click="onItemClick" data-value="{{pb.value}}" ng-repeat = "pb in ngModel">{{pb.item}}</li>'+
						'</ul>'	,
				link: function (scope, element, attr) {
					element.pillbox({
						added: function(data) {scope.onAdded({$data:data});},
						removed: function(data){scope.onRemoved({$data:data});},
						itemclicked: function(data){scope.onItemClick({$data:data});}
					});
					
				},
				removed: function(data) {
					scope.onRemoved(data);
				}
			};
		}]);

})(window, window.angular);
