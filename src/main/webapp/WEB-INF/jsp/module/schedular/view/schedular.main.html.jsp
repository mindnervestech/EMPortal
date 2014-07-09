<%@include file='/WEB-INF/jsp/module/schedular/controller/schedular.main.js.jsp' %> 
<%@ taglib prefix="css" uri="/WEB-INF/mnt.tld"%>

<script src="${pageContext.request.contextPath}/resources/app/dhtmlx/dhtmlxscheduler.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/app/dhtmlx/dhtmlxscheduler_multisection.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/app/dhtmlx/dhtmlxscheduler_units.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/app/dhtmlx/dhtmlxscheduler_multiselect.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/app/dhtmlx/dhtmlxscheduler_timeline.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/app/dhtmlx/dhtmlxscheduler_treetimeline.js" type="text/javascript"></script>

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/app/dhtmlx/dhtmlxscheduler.css" type="text/css">

<button data-ng-click="openEntityModalById(-1)">Add Appointment</button>
<div class="box">
	<css:FormHeader cssclass="box-header-mini">Schedular</css:FormHeader>
	<div class="box-container">
		
		<a href="#/daily">Daily</a>
		<a href="#/monthly">Monthly</a>
		
		<div ng-view></div>

	</div>	
</div>

<script>

		scheduler.createUnitsView({
		    name:"unit",
		    property:"doctor_id", //the mapped data property
		    //y_step:05,
			//size: 10,
		    list: ${doctorsEvent}
		});
		scheduler.config.first_hour = 8;
		scheduler.config.last_hour = 17;
		scheduler.config.start_on_monday = true;
		scheduler.config.time_step = 15;
		scheduler.locale.labels.unit_tab ="Main Schedular";
		scheduler.config.multisection = true; 
		scheduler.xy.scale_height=120;
		
		scheduler.init('scheduler', new Date(), "unit");
		//scheduler.locale.labels.timeline_tab ="Multi-view Schedular";
		
		var events = ${events};
		
		scheduler.parse("events", "json");
		
		var html = function(id) { return document.getElementById(id); }; //just a helper
		
		scheduler.showLightbox = function(id) {
			var ev = scheduler.getEvent(id);
			scheduler.startLightbox(id, html("my_form"));

			html("description").focus();
			html("description").value = ev.text;
			html("custom1").value = ev.custom1 || "";
			html("custom2").value = ev.custom2 || "";
		};

		function save_form() {
			var ev = scheduler.getEvent(scheduler.getState().lightbox_id);
			ev.text = html("description").value;
			ev.custom1 = html("custom1").value;
			ev.custom2 = html("custom2").value;

			scheduler.endLightbox(true, html("my_form"));
		}
		function close_form() {
			scheduler.endLightbox(false, html("my_form"));
		}

		function delete_event() {
			var event_id = scheduler.getState().lightbox_id;
			scheduler.endLightbox(false, html("my_form"));
			scheduler.deleteEvent(event_id);
		}
		
	</script>
