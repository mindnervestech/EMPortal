<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div style="width: 94%;margin-left:1%; float: left;"id='${_searchContext.entityName()}${mode}${"_search"}' class="well form-inline" >  
		
		<c:if test="${_searchContext.getFilter() != null}">		
		 <c:forEach var="fieldType" items="${_searchContext.getFilter().iterator()}">
			<c:choose>
				 <c:when test='${fieldType.ctype().name() == "INPUT"}'>
				    <input id="${_searchContext.entityName()}${mode}${fieldType.name()}" name="${fieldType.name()}" placeholder="${fieldType.label()}" class="input-medium search-query" type="text">
				 </c:when>
				 <c:when test='${fieldType.ctype().name() == "SELECT_OPTION"}'>
				 	<label style="margin-left: 1%;"class="control-label" for="selectbasic">${fieldType.label()}</label>
				    <select style="width: 20%;"id="${_searchContext.entityName()}${mode}${fieldType.name()}" name="${fieldType.name()}" class="input-xlarge search-on-select">
					    
					    <c:forEach var="option" items="${fieldType.options()}">
					    	<option value='${option}'>${option.getName()}</option>
					    </c:forEach>	
					</select>
				 </c:when>
				 <c:when test='${fieldType.ctype().name() == "DATE"}'>
				 	<label style="margin-left: 2%;"class="control-label" for="selectbasic">${fieldType.label()}</label>
					<div data-provide="datepicker" class="input-append date datepicker" data-date="" data-date-format="dd-mm-yyyy">
	    				<input style="width: 80%;"id='${_searchContext.entityName()}${mode}${fieldType.name()}' size="16" type="text" value="" readonly name='${fieldType.name()}'><span class="add-on"><i class="icon-calendar"></i></span>
					</div>
				 </c:when>
			</c:choose>
		 </c:forEach>
			<label class="control-label" for="singlebutton">&nbsp;</label>
			<button style="margin-left: 5%; color: gray;"id='${_searchContext.entityName()}${mode}${"_searchButton"}' onclick="return false;" name="searchButton" class="btn">Search</button>
		</c:if>		
				
</div>