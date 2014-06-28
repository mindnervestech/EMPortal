<script>

var controllerProvider;

var app = angular.module('home-app', [
  'ngResource',
  'ngRoute',
  'ui.bootstrap',
  'ui.bootstrap.tpls',
  'ui.bootstrap.datetimepicker',
  'ngDialog'
  
],function($controllerProvider) {
	controllerProvider = $controllerProvider;
})
  .config(function ($routeProvider) {
    $routeProvider
      .when('/daily', {
        templateUrl: 'template/daily.schedular.main.html',
        controller:'DailySchedularContentController'
      })
      .when('/monthly', {
    	  templateUrl: 'template/monthly.schedular.main.html',
          controller:'MonthlySchedularContentController'
      })
      .when('/', {
        templateUrl: 'template/daily.schedular.main.html',
        controller:'DailySchedularContentController'
      })
      .otherwise({
          redirectTo: '/'
      });
  });
  
app.directive('dhxScheduler', function() {
  return {
    restrict: 'A',
    scope: false,
    transclude: true,
    template:'<div class="dhx_cal_navline" ng-transclude></div><div class="dhx_cal_header"></div><div class="dhx_cal_data"></div>',

    link:function ($scope, $element, $attrs, $controller) {
      //default state of the scheduler
      if (!$scope.scheduler)
      $scope.scheduler = {};
      $scope.scheduler.mode = $scope.scheduler.mode || "unit";
      $scope.scheduler.date = $scope.scheduler.date || new Date();
	  scheduler.config.first_hour = 8;
	  scheduler.config.last_hour = 17;
	  scheduler.config.time_step = 15;
	  scheduler.xy.scale_height=120;
	  scheduler.config.details_on_create=true;
	  scheduler.config.dblclick_create = true;
	  scheduler.config.limit_time_select = true;
	  //scheduler.config.edit_on_create = true;
	  scheduler.config.select = false;
	  scheduler.config.show_loading = true;
	  scheduler.config.touch = "force";
		var step = 15;
		var format = scheduler.date.date_to_str("%H:%i");
		scheduler.config.xml_date="%Y-%m-%d %H:%i";
		scheduler.templates.hour_scale = function(date) {
			html="";
			for (var i=0; i<60/step; i++){
				html+="<div style='height:22px;line-height:22px;'>"+format(date)+"</div>";
				date = scheduler.date.add(date,step,"minute");
			}
			return html;
		}
	  
	  if ($scope.scheduler.mode == 'unit') {		
		scheduler.createUnitsView({
			name:"unit",
			property: "doctor_id",
			list: $scope.sections
		});
		
		
		/**override this method if requirement is to have complete customized event view.*/
		/*scheduler.renderEvent = function(container, ev, width, height, header_content, body_content) {
			var container_width = container.style.width*2;
			// move section
			var html = "<div class='dhx_event_move my_event_move' style='width: " + container_width + "'></div>";
			html = "this is custom way for rendering event..."; //todo - need to show as per theme requirement.
			container.innerHTML = html;
			return true;
		};*/
		
		scheduler.templates.lightbox_header = function(start,end,ev){
			return "<b>Appointment</b>";
		};
		
		scheduler.templates.quick_info_content = function(start, end, ev){ 
			   return ev.details || ev.text;
		};
		
		scheduler.attachEvent("onClick", function (id, e){
		   //any custom logic here
		   return true;
  	   });
	   
	   /*scheduler.showLightbox = function(id) {
			$scope.addAppointment();
		};*/
		  
		//for showing context menu on click of Event.
		
		var menu = new dhtmlXMenuObject();
		menu.setSkin("dhx_terrace");
		menu.setIconsPath("./data/imgs/");
		menu.renderAsContextMenu();
		menu.addNewChild(menu.topId, 0, "open", "Open", false);
		menu.addNewChild(menu.topId, 1, "save", "Save", false);
		menu.addNewChild(menu.topId, 3, "close", "Close", false);
		
		scheduler.attachEvent("onContextMenu", function (id, native_event_object){
			if (id) {
				var posx = 0;
					var posy = 0;
					if (native_event_object.pageX || native_event_object.pageY) {
						posx = native_event_object.pageX;
						posy = native_event_object.pageY;
					} else if (native_event_object.clientX || native_event_object.clientY) {
						posx = native_event_object.clientX + document.body.scrollLeft + document.documentElement.scrollLeft;
						posy = native_event_object.clientY + document.body.scrollTop + document.documentElement.scrollTop;
					}
					menu.showContextMenu(posx, posy);
				return false;
			}
			return true;
		});

		//Called on single click in cell area.
		/*scheduler.attachEvent("onEmptyClick", function (date, e){
			   //any custom logic here			   
		});*/
		
		scheduler.templates.event_header = function(start,end,ev){
			return "Custom header";
		};
		
		scheduler.templates.event_text = function(start,end,ev) {
			return "Appointment Date " + ev.text;
		};
		
		scheduler.templates.event_class = function(start,end,ev){
			return "";
		};		
		
	  } else if ($scope.scheduler.mode == 'timeline') {	
		scheduler.createTimelineView({
			 name:      "timeline",
			 x_unit:    "minute",
			 x_date:    "%H:%i",
			 x_step:    15,
			 x_size:    12,
			 x_start:   32, 
			 x_start:   32,
			 //x_length:  48,
			 y_unit: $scope.sections,
			 y_property:"section_id",
			 render:    "bar"
		});
	  }
	  
	  
      //watch data collection, reload on changes
      $scope.$watch($attrs.data, function(collection) {
        scheduler.clearAll();
        scheduler.parse(collection, "json");
      }, true);

      //mode or date
      $scope.$watch(function(){
        return $scope.scheduler.mode + $scope.scheduler.date.toString();
      }, function(nv, ov) {
        var mode = scheduler.getState();
        if (nv.date != mode.date || nv.mode != mode.mode)
          scheduler.setCurrentView($scope.scheduler.date, $scope.scheduler.mode);
      }, true);

      //size of scheduler
      $scope.$watch(function() {
        return $element[0].offsetWidth + "." + $element[0].offsetHeight;
      }, function() {
        scheduler.setCurrentView();
      });

      //styling for dhtmlx scheduler
      $element.addClass("dhx_cal_container");
      scheduler.init($element[0], $scope.scheduler.mode, $scope.scheduler.date);
    }
  }
});

app.directive('dhxTemplate', ['$filter', function($filter){
  scheduler.aFilter = $filter;

  return {
    restrict: 'AE',
    terminal:true,
   
    link:function($scope, $element, $attrs, $controller){
      $element[0].style.display = 'none';

      var template = $element[0].innerHTML;
      template = template.replace(/[\r\n]/g,"").replace(/"/g, "\\\"").replace(/\{\{event\.([^\}]+)\}\}/g, function(match, prop){
        if (prop.indexOf("|") != -1){
          var parts = prop.split("|");
          return "\"+scheduler.aFilter('"+(parts[1]).trim()+"')(event."+(parts[0]).trim()+")+\"";
        }
        return '"+event.'+prop+'+"';
      });
      var templateFunc = Function('sd','ed','event', 'return "'+template+'"');
      scheduler.templates[$attrs.dhxTemplate] = templateFunc;
    }
  };
}]);





</script>