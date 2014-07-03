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
		
		<div id="scheduler" class="dhx_cal_container" style='width:100%; height:100%;'>
		    <div class="dhx_cal_navline">
		        <div class="dhx_cal_prev_button">&nbsp;</div>
		        <div class="dhx_cal_next_button">&nbsp;</div>
		        <!-- <div class="dhx_cal_today_button"></div> -->
		        <div class="dhx_cal_date"></div>
		        <div class="dhx_cal_tab" name="unit_tab" style="right:280px;"></div>
		        <div class="dhx_cal_tab" name="timeline_tab" style="right:280px;"></div>
		        <div class="dhx_cal_tab" name="day_tab" style="right:204px;"></div>
		        <!-- <div class="dhx_cal_tab" name="week_tab" style="right:140px;"></div> -->
		        <!-- <div class="dhx_cal_tab" name="month_tab" style="right:140px;"></div> -->
		    </div>
		    <div class="dhx_cal_header"></div>
		    <div class="dhx_cal_data"></div>       
		</div>

	</div>	
</div>

<script>
		
		var events = [
			{id:1, text:"Meeting",   start_date:"06/21/2014 14:00",end_date:"06/21/2014 17:00", unit_id:"1"},
			{id:2, text:"Conference",start_date:"06/21/2014 12:00",end_date:"06/21/2014 19:00", unit_id:"3"},
			{id:3, text:"Interview", start_date:"06/21/2014 09:00",end_date:"06/21/2014 10:00", unit_id:"2"}
			];
			 
		scheduler.parse("events", "json");
		//method takes the url to the file that will process CRUD operations on the server
		//scheduler.load("url");
		
		scheduler.createUnitsView({
		    name:"unit",
		    property:"unit_id", //the mapped data property
		    y_step:5,
		    list:[              //defines the units of the view
		        {key:1, label:"Dr. 1"},
		        {key:2, label:"Dr. 2"},
		        {key:3, label:"Dr. 3"}  
		    ]
		});
		
		scheduler.createTimelineView({
		     name:"timeline",
		     x_unit:"minute",//measuring unit of the X-Axis.
		     x_date:"%H:%i", //date format of the X-Axis
		     x_step:05,      //X-Axis step in 'x_unit's
		     
		     //fist_hour: 08,
		     //last_hour: 16,
		     //x_size:12,      //X-Axis length specified as the total number of 'x_step's
		     x_start:96,     //X-Axis offset in 'x_unit's
		     x_end:192,     //X-Axis offset in 'x_unit's
		     x_length:8,    //number of 'x_step's that will be scrolled at a time
		     y_unit:         //sections of the view (titles of Y-Axis)
		        [{key:1, label:"<img src='' /></br>Dr. 1"},
		         {key:2, label:"<img src='' /></br>Dr. 2"},
		         {key:3, label:"<img src='' /></br>Dr. 3"},
		         {key:4, label:"<img src='' /></br>Dr. 4"}],
		     y_property:"unit_id", //mapped data property
		     render:"bar",             //view mode - bar, tree, cell
		});
		
		scheduler.init('scheduler', new Date(), "day");
		scheduler.locale.labels.timeline_tab ="Multi-view Schedular";
		scheduler.locale.labels.unit_tab ="Main Schedular";
		scheduler.config.multisection = true; 
		
		scheduler.config.first_hour = 8;
		scheduler.config.last_hour = 17;
		scheduler.config.start_on_monday = true;
		scheduler.config.fix_tab_position = false;
		
		scheduler.config.event_duration = 60; 
		scheduler.config.auto_end_date = true;
		
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
