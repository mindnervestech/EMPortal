<script>

var controllerProvider;

var app = angular.module('home-app', [
  'ngResource',
  'ngRoute',
  'ui.bootstrap',
  'ui.bootstrap.tpls',
  'ui.bootstrap.datetimepicker',
  'ngDialog',
  'angularFuelux'
  
],function($controllerProvider){
	controllerProvider = $controllerProvider;
})
  .config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'template/doctor.main.html',
        controller:'DoctorContentController'
       
      })
      .otherwise({
          redirectTo: '/'
      });
  });
  



</script>