<%@include file='/WEB-INF/jsp/module/permission/controller/permission.main.js.jsp' %> 
<%@ taglib prefix="css" uri="/WEB-INF/mnt.tld"%>

<div class="box" data-ng-init="gridSearchBtn()">
	<css:FormHeader cssclass="box-header-mini">Permissions</css:FormHeader>
	<div class="mws-panel-toolbar">
          <div class="btn-toolbar">
              <div class="btn-group">
                  <a data-ng-click="refreshBtn()" class="btn"><i class="icol-arrow-refresh"></i> Refresh</a>
             </div>
          </div>
    </div>	
	<div class="box-container">
		<div class="col18" id="myGrid" style="height:450px;"></div>
	</div>	
</div>


