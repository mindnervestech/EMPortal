<script>

var controllerProvider;

var app = angular.module('home-app', [
  'ngResource',
  'ngRoute',
  'ui.bootstrap',
  'ui.bootstrap.tpls',
  'ui.bootstrap.datetimepicker'
  
],function($controllerProvider){
	controllerProvider = $controllerProvider;
})
  .config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'template/pharmacy.main.html',
        controller:'PharmacyContentController'
       
      })
      .otherwise({
          redirectTo: '/'
      });
  });
  



</script>