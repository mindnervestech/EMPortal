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
		<div data="events" dhx-scheduler style="height:600px; width:100%;">	
			<div class="dhx_cal_date"></div>
		<div>
	</div>
</div>