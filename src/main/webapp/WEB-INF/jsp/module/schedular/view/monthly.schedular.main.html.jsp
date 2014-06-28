<%@include file='/WEB-INF/jsp/module/schedular/controller/schedular.main.js.jsp' %> 
<%@ taglib prefix="css" uri="/WEB-INF/mnt.tld"%>

<script src="${pageContext.request.contextPath}/resources/app/scripts/dhtmlx/dhtmlxscheduler.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/app/scripts/dhtmlx/dhtmlxscheduler_multisection.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/app/scripts/dhtmlx/dhtmlxscheduler_units.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/app/scripts/dhtmlx/dhtmlxscheduler_multiselect.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/app/scripts/dhtmlx/dhtmlxscheduler_timeline.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/app/scripts/dhtmlx/dhtmlxscheduler_treetimeline.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/app/scripts/dhtmlx/dhtmlxscheduler_quick_info.js" type="text/javascript"></script>

<script src="${pageContext.request.contextPath}/resources/app/scripts/dhtmlx/dhtmlxmenu.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/app/scripts/dhtmlx/dhtmlxmenu_ext.js" type="text/javascript"></script>


<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/app/scripts/dhtmlx/dhtmlxscheduler.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/app/scripts/dhtmlx/dhx_terrace.css" type="text/css">

<button data-ng-click="openEntityModalById(-1)">Add Appointment</button>
<div class="box">
	<css:FormHeader cssclass="box-header-mini">Schedular</css:FormHeader>
	<div class="box-container">
		
		<a href="#/daily">Daily</a>
		<a href="#/monthly">Monthly</a>
		<div id="scheduler" class="dhx_cal_container" style='width:100%; height:100%;'>
		    <div class="dhx_cal_navline">
		        <div class="dhx_cal_date"></div>
		    </div>
		    <div class="dhx_cal_header"></div>
		    <div class="dhx_cal_data"></div>       
		</div>
		
		
	</div>	
</div>

<script>

		
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
		     y_property:"doctor_id", //mapped data property
		     render:"bar",             //view mode - bar, tree, cell
		});
		
		
		scheduler.locale.labels.timeline_tab ="Multi-view Schedular";
		scheduler.locale.labels.unit_tab ="Main Schedular";
		scheduler.config.multisection = true; 
		
		scheduler.config.first_hour = 8;
		scheduler.config.last_hour = 17;
		scheduler.config.start_on_monday = true;
		scheduler.config.fix_tab_position = false;
		
		scheduler.config.event_duration = 60; 
		scheduler.config.auto_end_date = true;
		
		
		scheduler.init('scheduler', new Date(), "timeline");
		
		var events = ${events};
		
		scheduler.parse("events", "json");
		
				
	</script>
