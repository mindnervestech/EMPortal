<%@include file='/WEB-INF/jsp/module/permission/controller/permission.main.js.jsp' %> 
<%@ taglib prefix="css" uri="/WEB-INF/mnt.tld"%>

<div class="box">
	<css:FormHeader cssclass="box-header-mini">Facility</css:FormHeader>
	<div class="mws-panel-toolbar">
          <div class="btn-toolbar">
              <div class="btn-group">
                  <a data-ng-click="openEntityModalById(-1)" class="btn"><i class="icol-add"></i> Add</a>
                  <a data-ng-click="refreshBtn()" class="btn"><i class="icol-arrow-refresh"></i> Refresh</a>
                  <a data-ng-click="blockBtn()" class="btn"><i class="icol-delete"></i> Block</a>
                  <a data-ng-click="approveFacilities()" class="btn"><i class="icol-ok"></i> Approve It!</a>
             </div>
          </div>
    </div>	
	<div class="box-container">
	  <div class="onerow  color1-row">
		  <div class="col4">
		    <css:grid-filter json="${gridColumn}" field="facilityName" data-ng-model="searchForm.facilityName"/>
		  </div>
		  <div class="col3">
		  	<css:grid-filter  json="${gridColumn}" field="roleType" data-ng-model="searchForm.roleType"/>
		  </div>
		  <div class="dropdown col6">	
		  	<css:grid-filter json="${gridColumn}" field="dob" data-ng-model="searchForm.dob" value="{{searchForm.dob|date:'MMMM-dd-yyyy'||'From'}}"/>
		  </div>
		  <div class="col3">
		  	<button data-ng-click="gridSearchBtn()">Search</button>
		  </div>
	  </div>
	
		
		 <input type="text" data-ng-model="gridSearch" placeholder="Search"  class="form-control">
		
		<div class="col18" id="myGrid" style="height:450px;"></div>
	
	</div>	
</div>


