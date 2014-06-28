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
        templateUrl: 'template/user.main.html',
        controller:'UserContentController'
       
      })
      .otherwise({
          redirectTo: '/'
      });
  });
  



</script>