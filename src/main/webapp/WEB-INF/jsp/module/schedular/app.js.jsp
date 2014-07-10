<script>

var controllerProvider;

var app = angular.module('home-app', [
  'ngResource',
  'ngRoute',
  'ui.bootstrap',
  'ui.bootstrap.tpls',
  'ui.bootstrap.datetimepicker',
  'ngDialog',
  'ui.event', 
  'ui.autocomplete'
  
],function($controllerProvider) {
	controllerProvider = $controllerProvider;
})
  .config(function ($routeProvider) {
    $routeProvider
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
      
      $scope.scheduler.mode = $scope.scheduler.mode || "month";
      $scope.scheduler.date = $scope.scheduler.date || new Date();
	  scheduler.config.first_hour = 8;
	  scheduler.config.last_hour = 20;
	  scheduler.config.time_step = 15;
	  scheduler.xy.scale_height=120;
	  scheduler.config.hour_size_px = 176;
	 
	  scheduler.config.drag_create = false;
	  scheduler.config.drag_move = false;
	  scheduler.config.drag_resize= false;
	  
	  scheduler.locale.labels.unit_tab = "Doctors"
	  //scheduler.config.details_on_create=true;
	  //scheduler.config.dblclick_create = true;
	  scheduler.config.limit_time_select = true;
	  //scheduler.config.edit_on_create = true;
	  scheduler.config.select = false;
	  scheduler.config.show_loading = true;
	  scheduler.config.collision_limit = 1;
	  
	  scheduler.config.prevent_cache = true;
	  
	  //scheduler.config.touch = "force";
	  var step = 15;
	  var format = scheduler.date.date_to_str("%H:%i");
	  //scheduler.config.xml_date="%Y-%m-%d %H:%i";
	  scheduler.templates.hour_scale = function(date) {
		  html="";
		  for (var i=0; i<60/step; i++){
			html+="<div style='height:42px;line-height:42px;'>"+format(date)+"</div>";
			date = scheduler.date.add(date,step,"minute");
		  }
		   return html;
		}
	  
	   if ($scope.scheduler.mode == 'unit') {		
			scheduler.createUnitsView({
				name:"unit",
				property: "doctor_id",
				list: scheduler.serverList("units", $scope.sections),
				skip_incorrect : true,
				size : 8,
				step:4
			});
		
			/**override this method if requirement is to have complete customized event view.*/
			/* scheduler.renderEvent = function(container, ev, width, height, header_content, body_content) {
				var container_width = container.style.width*2;
				// move section
				var html = "<div class='dhx_event_move my_event_move' style='width: " + container_width + "' popover='I appeared on focus! Click away and  vanish...'  popover-trigger='focus' >this is test content</div>";
				container.innerHTML = html;
				return true;
			}; */
			
			scheduler.attachEvent("onClick", function (id, e){
			   	console.log("in click");
			   	var eventObj = scheduler.getEvent(id);
			   	$scope.renderAppointmentView(eventObj.eventId);
			   	return false;
	  	     });
			
			scheduler.attachEvent("onEventLoading", function(ev){ 
				console.log("in event load");
				return scheduler.checkCollision(ev);             
			});
			
			scheduler.templates.lightbox_header = function(start,end,ev){
				return "<b>Appointment</b>";
			};
			
			/* scheduler.templates.quick_info_content = function(start, end, ev){ 
				   return ev.details || ev.text;
			}; */
			
		   	scheduler.showLightbox = function(id) {
		   		
		   		//$scope.renderAppointmentView(id);
				return false;
			};
			
			//for showing context menu on click of Event.
			
			var menu = new dhtmlXMenuObject();
			menu.setSkin("dhx_terrace");
			menu.setIconsPath("./data/imgs/");
			menu.renderAsContextMenu();
			menu.addNewChild(menu.topId, 0, "", "Check In & Verify", false);
			menu.addNewChild(menu.topId, 1, "", "Progress Note", false);
			menu.addNewChild(menu.topId, 2, "close", "Checkout", false);
			menu.addNewChild(menu.topId, 3, "close", "Edit Appointment", false);
			menu.addNewChild(menu.topId, 4, "close", "Delete Appointment", false);
			menu.addNewChild(menu.topId, 5, "close", "Quick Balance", false);
			menu.addNewChild(menu.topId, 6, "close", "Cut Appointment", false);		
			menu.addNewChild(menu.topId, 7, "close", "Print", false);
			menu.addNewChild(menu.topId, 8, "close", "Email", false);
			
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
			scheduler.attachEvent("onEmptyClick", function (date, e){
				var s2d = scheduler.date.date_to_str("%H:%i");
				console.log("on Empty Click");
				console.log(e);
				
				var action_data = scheduler.getActionData(e);
				console.log(action_data);
				$scope.appointmentForm = {};
				$scope.appointmentForm.appointmentDmy = date;
				$scope.appointmentForm.startMin = s2d(date);
				$scope.appointmentForm.endMin = s2d(scheduler.date.add(date, scheduler.config.time_step, 'minute'));
				$scope.appointmentForm.appointmentWithId = action_data.section;
				$scope.renderAppointmentView(-1);
			});
			
			/* scheduler.attachEvent("onDragEnd", function (date, e){
				$scope.renderAppointmentView(-1);
				return false;
			}); */
			
			scheduler.attachEvent("onBeforeLightbox", function (id){
				$scope.renderAppointmentView(id);
				return false;
			});
			
			scheduler.attachEvent("onBeforeEventChanged", function(ev, e, is_new) {
					var s2d = scheduler.date.date_to_str("%H:%i");
					
					$scope.appointmentForm = {};
					$scope.appointmentForm.appointmentDmy = ev.start_date;
					$scope.appointmentForm.startMin = s2d(ev.start_date);
					$scope.appointmentForm.endMin = s2d(ev.end_date);
					$scope.appointmentForm.appointmentWithId = ev.doctor_id;
					return true;
			});

			scheduler.templates.event_header = function(start,end,ev){
				return "Custom header";
			};
			
			scheduler.templates.event_text = function(start,end,ev) {
				var d2s = scheduler.date.date_to_str("%d-%M-%Y");
				var d2t = scheduler.date.date_to_str("%H:%i");
				return "Date :" + d2s(start) +"<p>Time:"+d2t(start)+" - " + d2t(end) +"</p>";
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
	 // scheduler.parse('','');
      $scope.$watch($attrs.data, function(collection) {
        //scheduler.clearAll();
        try {
			scheduler.parse(collection, "json");
		} catch (error) {
		}
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
      scheduler.init($element[0], $scope.scheduler.date, $scope.scheduler.mode);
      
      scheduler.setLoadMode("day");
      scheduler.load("events/daily?resources=" + $scope.resourceIds, "json", function() {
    	  console.log("Data has been successfully loaded");
      });
      
      var calendar = scheduler.renderCalendar({
			container:"outer_calendar", 
			navigation:true,
			handler:function(date){
				console.log(date);
				scheduler.setCurrentView(date, scheduler._mode);
			}
		});
		scheduler.linkCalendar(calendar);
		scheduler.setCurrentView(scheduler._date, scheduler._mode);
		console.log("After");
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