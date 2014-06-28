<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Portal</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width">
  	<link href="${pageContext.request.contextPath}/resources/app/wizard/wizard.css" rel="stylesheet" media="all">
  	<link href="${pageContext.request.contextPath}/resources/app/bower_components/angular-bootstrap-datetimepicker/src/css/datetimepicker.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/resources/app/bower_components/angular-slider/angular-slider.min.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/resources/app/bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
	
	<link href="${pageContext.request.contextPath}/resources/app/css/style.css" rel="stylesheet" media="all">
	<link href="${pageContext.request.contextPath}/resources/app/css/18grid.css" rel="stylesheet" media="all">
	
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/app/slick-grid/slick.grid.css" type="text/css"/>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/app/slick-grid/slick-default-theme.css"  type="text/css" />
  	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/app/slick-grid/controls/slick.columnpicker.css" type="text/css"/>
  	
  	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/app/bower_components/ng-dialog/css/ngDialog.min.css" type="text/css"/>
  	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/app/bower_components/ng-dialog/css/ngDialog-theme-default.min.css" type="text/css"/>
  	
  	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/app/css/icol16.css" type="text/css"/>
  </head>
  <script>var contextPath = "${pageContext.request.contextPath}"</script>
  <body  class="container18grid" data-ng-app="home-app"  style="overflow-y: scroll;">
  			<span us-spinner spinner-key="loading..." ></span>
  			
  			<div class="onerow">
  			<tiles:insertAttribute name="header" />
  			</div>
			
			<div class="onerow">
				<div class="col3"><tiles:insertAttribute name="leftpane" /></div>
				<div class="col15 last" ng-view=""></div>
				<%-- <div class="col3 last"><tiles:insertAttribute name="rightpane" /></div> --%>
		    </div>
		    
		    <div class="onerow">
		    <tiles:insertAttribute name="footer" />
		    </div>   
  </body>


    <script src="${pageContext.request.contextPath}/resources/app/bower_components/jquery/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/app/wizard/wizard.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/app/wizard/jquery.form.min.js"></script>
    
    <script src="${pageContext.request.contextPath}/resources/app/slick-grid/lib/jquery.event.drag-2.2.js"></script>
	<script src="${pageContext.request.contextPath}/resources/app/slick-grid/slick.dataview.js"></script>
	<script src="${pageContext.request.contextPath}/resources/app/slick-grid/slick.core.js"></script>
	<script src="${pageContext.request.contextPath}/resources/app/slick-grid/slick.formatters.js"></script>
	<script src="${pageContext.request.contextPath}/resources/app/slick-grid/slick.grid.js"></script>
	<script src="${pageContext.request.contextPath}/resources/app/slick-grid/plugins/slick.checkboxselectcolumn.js"></script>
	<script src="${pageContext.request.contextPath}/resources/app/slick-grid/plugins/slick.autotooltips.js"></script>
	<script src="${pageContext.request.contextPath}/resources/app/slick-grid/plugins/slick.cellrangedecorator.js"></script>
	<script src="${pageContext.request.contextPath}/resources/app/slick-grid/plugins/slick.cellrangeselector.js"></script>
	<script src="${pageContext.request.contextPath}/resources/app/slick-grid/plugins/slick.cellcopymanager.js"></script>
	<script src="${pageContext.request.contextPath}/resources/app/slick-grid/plugins/slick.cellselectionmodel.js"></script>
	<script src="${pageContext.request.contextPath}/resources/app/slick-grid/plugins/slick.rowselectionmodel.js"></script>
	<script src="${pageContext.request.contextPath}/resources/app/slick-grid/controls/slick.columnpicker.js"></script>
	<script src="${pageContext.request.contextPath}/resources/app/slick-grid/lib/jquery-ui-1.8.16.custom.min.js"></script>
    
	<script src="${pageContext.request.contextPath}/resources/app/bower_components/moment/moment.js"></script>
	<script src="${pageContext.request.contextPath}/resources/app/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/app/bower_components/angular/angular.js"></script>
    <script src="${pageContext.request.contextPath}/resources/app/bower_components/angular-resource/angular-resource.js"></script>
    <script src="${pageContext.request.contextPath}/resources/app/bower_components/angular-route/angular-route.js"></script>
    <script src="${pageContext.request.contextPath}/resources/app/bower_components/angular-animate/angular-animate.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/app/bower_components/angular-bootstrap/ui-bootstrap.js"></script>
    <script src="${pageContext.request.contextPath}/resources/app/bower_components/angular-bootstrap-datetimepicker/src/js/datetimepicker.js"></script>
	<script src="${pageContext.request.contextPath}/resources/app/bower_components/angular-bootstrap/ui-bootstrap-tpls.js"></script> 
    <script src="${pageContext.request.contextPath}/resources/app/bower_components/angular-validator/dist/angular-validator.js"></script>
    <script src="${pageContext.request.contextPath}/resources/app/bower_components/angular-validator/dist/angular-validator-rules.js"></script>
    <script src="${pageContext.request.contextPath}/resources/app/bower_components/spin.js/spin.js"></script>
	<script src="${pageContext.request.contextPath}/resources/app/bower_components/angular-spinner/angular-spinner.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/app/bower_components/ng-dialog/js/ngDialog.min.js"></script>
    
    <tiles:insertAttribute name="app.js" />
    <tiles:insertAttribute name="services.js" />
    
    
</html>


