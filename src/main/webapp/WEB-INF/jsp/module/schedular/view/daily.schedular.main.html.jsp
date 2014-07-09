<%@include file='/WEB-INF/jsp/module/schedular/controller/schedular.main.js.jsp' %> 
<%@include file='/WEB-INF/jsp/module/schedular/controller/appointment.js.jsp' %> 


<%@ taglib prefix="css" uri="/WEB-INF/mnt.tld"%>

<script src="${pageContext.request.contextPath}/resources/app/scripts/dhtmlx/dhtmlxscheduler.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/app/scripts/dhtmlx/dhtmlxscheduler_multisection.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/app/scripts/dhtmlx/dhtmlxscheduler_units.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/app/scripts/dhtmlx/dhtmlxscheduler_multiselect.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/app/scripts/dhtmlx/dhtmlxscheduler_timeline.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/app/scripts/dhtmlx/dhtmlxscheduler_treetimeline.js" type="text/javascript"></script>

<script src="${pageContext.request.contextPath}/resources/app/scripts/dhtmlx/dhtmlxmenu.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/app/scripts/dhtmlx/dhtmlxmenu_ext.js" type="text/javascript"></script>
<script src='${pageContext.request.contextPath}/resources/app/scripts/dhtmlx/dhtmlxscheduler_minical.js' type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/app/scripts/dhtmlx/dhtmlxscheduler_collision.js" type="text/javascript"></script>

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/app/scripts/dhtmlx/dhtmlxscheduler.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/app/scripts/dhtmlx/dhx_terrace.css" type="text/css">

<div class="box">
	<css:FormHeader cssclass="box-header-mini">Schedular</css:FormHeader>
	
	<div class="box-container" style="margin-top : 0.2%;">
		<div id="dhx_cal" class="marginBoth"></div>
		<div data="events" dhx-scheduler style="height:600px;;">
			<div class="dhx_cal_tab" name="unit_tab"></div>
			<div class="dhx_cal_prev_button">&nbsp;</div>
			<div class="dhx_cal_next_button">&nbsp;</div>
			<div class="dhx_cal_today_button"></div>
			<div class="dhx_cal_date"></div>
		</div>
	</div>
</div>

<style type="text/css">
	
	.dhx_cal_header {
		height: 25px !important;
	}
</style>

<style type="text/css">
	.dhx_year_week {
		height: 19px !important;
	}
	
	.dhx_scale_bar {
		height: 18px !important;
	}
</style>