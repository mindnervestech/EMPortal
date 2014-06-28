<%@include file='/WEB-INF/jsp/module/doctor/controller/doctor.main.js.jsp' %> 
<%@ taglib prefix="css" uri="/WEB-INF/mnt.tld"%>


<div class="box">
	<css:FormHeader cssclass="box-header-mini">Doctor</css:FormHeader>
	<div class="mws-panel-toolbar">
          <div class="btn-toolbar">
              <div class="btn-group">
                  <a data-ng-click="openEntityModalById(-1)" class="btn"><i class="icol-add"></i> Add</a>
                  <a data-ng-click="refreshBtn()" class="btn"><i class="icol-arrow-refresh"></i> Refresh</a>
                  <a data-ng-click="blockBtn()" class="btn"><i class="icol-delete"></i> Block</a>
             </div>
          </div>
    </div>				
	<div class="box-container">
	  <div class="onerow  color1-row">
		  <div class="col5">
		    <css:grid-filter json="${gridColumn}" field="name" data-ng-model="searchForm.name"/>
		  </div>
		  <div class="col5">
		  	<css:grid-filter  json="${gridColumn}" field="roleType" data-ng-model="searchForm.roleType"/>
		  </div>
		  <div class="dropdown col6">	
		  	<css:grid-filter json="${gridColumn}" field="dateOfBirth" data-ng-model="searchForm.dob" value="{{searchForm.dob|date:'MMMM-dd-yyyy'||'From'}}"/>
		  </div>
		  <div class="col2 last">
		  	<button data-ng-click="gridSearchBtn()">Search</button>
		  </div>
	  </div>
	
		
		<input type="text" data-ng-model="gridSearch" placeholder="Search"  class="form-control">
		
		<div class="col18" id="myGrid" style="height:450px;" class="grid"></div>
	
	</div>	
</div>


