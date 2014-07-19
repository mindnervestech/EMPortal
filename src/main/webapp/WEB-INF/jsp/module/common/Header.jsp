<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<header>
	
	<ul class="nav nav-tabs" >
		<c:forEach var="items" items="${_menuContext.items}">	
	
		 <c:if test="${items.isSubMenu()}"> 
		  		<c:if test='${items.name == "Logout"}'>
		  		<li style="float:right;">
		 			 <a href="#" style="padding-top: 8px; float:left;"> ${user.username} |</a>
		 			 <a style="float:left;" href="<c:url value="${pageContext.request.contextPath}/j_spring_security_logout" />">Logout</a>
		 		</li>
		 		</c:if>
		 		<c:if test='${items.name != "Logout"}'>
		 		<li>
		 			<a href="${pageContext.request.contextPath}${items.url}">${items.name}</a>
		 		</li>
		 		</c:if>
		 	
		 </c:if>
		 <c:if test="${!items.isSubMenu()}">
		 	<li class="dropdown">
		 		<c:if test='${items.name == "Actions"}'>
 		 			
		 		</c:if>	
		 			<a class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" href="#">${items.name} <b class="caret"></b></a>
		 			<ul class="dropdown-menu">
		 			
                  	<c:forEach var="subMenu" items="${items.getSubMenu()}">
                 	 <li><a href='${pageContext.request.contextPath}${subMenu.url}' >${subMenu.name}</a></li>
                 	</c:forEach>
                	</ul>
		 	</li>
		 </c:if>
		 
	</c:forEach>
	</ul>
</header>


<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

