/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.37
 * Generated at: 2014-07-03 18:26:41 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp.module.doctor.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class doctor_main_html_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("/WEB-INF/mnt.tld", Long.valueOf(1404411119000L));
    _jspx_dependants.put("/WEB-INF/jsp/module/doctor/controller/doctor.main.js.jsp", Long.valueOf(1404411119000L));
    _jspx_dependants.put("/WEB-INF/jsp/component/grid.jsp", Long.valueOf(1404411119000L));
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<script type=\"text/javascript\">\n");
      out.write("\n");
      out.write("\n");
      out.write("controllerProvider.register('DoctorContentController',function($scope,$http,Modal,ngDialog,$filter){\n");
      out.write("\t//$scope.userForm = ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${userForm}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write(';');
      out.write('\n');
      out.write('	');
      out.write("\t$scope.gridSearch = \"\";\n");
      out.write("\tdataView = new Slick.Data.DataView({ inlineFilters: true });\n");
      out.write("\t\n");
      out.write("\tvar gridColumn = angular.fromJson(");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${gridColumn}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write(");\n");
      out.write("\t$scope.searchForm={};\n");
      out.write("\t$scope.gridSearchBtn= function(){\n");
      out.write("\t\n");
      out.write("\t\t $http({method:'GET', url:gridColumn.searchUrl, params:$scope.searchForm }).success(function(response) {\n");
      out.write("        \tdataView.setItems(response);\n");
      out.write("        \tdataView.refresh();\n");
      out.write("        \t$scope.grid.invalidate();\n");
      out.write("\t      \t$scope.grid.render();\n");
      out.write("    \t  });\n");
      out.write("\t}\n");
      out.write("\t\n");
      out.write("\t$scope.refreshBtn= function(){\n");
      out.write("\t\n");
      out.write("\t\t $http({method:'GET', url:gridColumn.searchUrl }).success(function(response) {\n");
      out.write("        \tdataView.setItems(response);\n");
      out.write("        \tdataView.refresh();\n");
      out.write("        \t$scope.grid.invalidate();\n");
      out.write("\t      \t$scope.grid.render();\n");
      out.write("    \t  });\n");
      out.write("\t}\n");
      out.write("\t\n");
      out.write("\tvar checkboxSelector = new Slick.CheckboxSelectColumn({\n");
      out.write("      cssClass: \"slick-cell-checkboxsel\"\n");
      out.write("    });\n");
      out.write("    \n");
      out.write("\tvar column =  gridColumn.column;\n");
      out.write("\t\n");
      out.write("\tif(gridColumn.isActionable == true) {\n");
      out.write("    \tcolumn.unshift(checkboxSelector.getColumnDefinition());\n");
      out.write("    }\n");
      out.write("\t\n");
      out.write("\tvar options = {\n");
      out.write("\t\tenableColumnReorder: false,\n");
      out.write("\t    multiColumnSort: true,\n");
      out.write("\t    forceFitColumns: false,\n");
      out.write("\t    enableCellNavigation: true};\n");
      out.write("\t    \n");
      out.write("\t$scope.grid = new Slick.Grid(\"#myGrid\", dataView, column,options );\n");
      out.write("\t$scope.grid.onSort.subscribe(function (e, args) {\n");
      out.write("\t      var cols = args.sortCols;\n");
      out.write("\t      dataView.sort(function (dataRow1, dataRow2) {\n");
      out.write("\t        for (var i = 0, l = cols.length; i < l; i++) {\n");
      out.write("\t          var field = cols[i].sortCol.field;\n");
      out.write("\t          var sign = cols[i].sortAsc ? 1 : -1;\n");
      out.write("\t          var value1 = dataRow1[field], value2 = dataRow2[field];\n");
      out.write("\t          console.log(value1);console.log(value2);\n");
      out.write("\t          var result = (value1 == value2 ? 0 : (value1 > value2 ? 1 : -1)) * sign;\n");
      out.write("\t          if (result != 0) {\n");
      out.write("\t            return result;\n");
      out.write("\t          }\n");
      out.write("\t        }\n");
      out.write("\t        return 0;\n");
      out.write("\t      });\n");
      out.write("\t      $scope.grid.invalidate();\n");
      out.write("\t      $scope.grid.render();\n");
      out.write("\t});\n");
      out.write("\tdataView.onRowCountChanged.subscribe(function (e, args) {\n");
      out.write("\t  $scope.grid.updateRowCount();\n");
      out.write("\t  $scope.grid.render();\n");
      out.write("\t});\n");
      out.write("\t\n");
      out.write("\tfunction gridFilter(item, args) {\n");
      out.write("\t\t\n");
      out.write("\t\tif(args.searchString == \"\") return true;\n");
      out.write("\t\t\n");
      out.write("\t\tvar found = false;\n");
      out.write("\t\tfor(var i = 0 ; i <  args.field.length; i++) {\n");
      out.write("\t\t\tif (item[args.field[i]].toString().indexOf(args.searchString) != -1) {\n");
      out.write("    \t\t\tfound =  true;\n");
      out.write("    \t\t\tbreak;\n");
      out.write("  \t\t\t}\n");
      out.write("\t\t}\n");
      out.write("  \t\treturn found;\n");
      out.write("\t}\n");
      out.write("\t\n");
      out.write("\tdataView.onRowsChanged.subscribe(function (e, args) {\n");
      out.write("\t  $scope.grid.invalidateRows(args.rows);\n");
      out.write("\t  $scope.grid.render();\n");
      out.write("\t});\n");
      out.write("\tdataView.setItems(");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${gridData}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write(");\n");
      out.write("\tdataView.setFilterArgs({\n");
      out.write("    \tsearchString: \"\",\n");
      out.write("    \tfield: gridColumn.searchable\n");
      out.write("  \t});\n");
      out.write("\tdataView.setFilter(gridFilter);\n");
      out.write("\t$scope.$watch('gridSearch', function() {\n");
      out.write("\t\tdataView.setFilterArgs({\n");
      out.write("    \t\tsearchString: $scope.gridSearch,\n");
      out.write("    \t\tfield: gridColumn.searchable\n");
      out.write("  \t\t});\n");
      out.write("\t\tdataView.refresh();\n");
      out.write("\t});\n");
      out.write("\t$scope.grid.onDblClick.subscribe(function(e,args){\n");
      out.write("    \tvar cell = $scope.grid.getCellFromEvent(e);\n");
      out.write("    \tif (!cell) {\n");
      out.write("      \t\treturn;\n");
      out.write("    \t}\n");
      out.write("    \t$scope.openEntityModalById(dataView.getItem(cell.row).id);\n");
      out.write("    \treturn;\n");
      out.write("    });\n");
      out.write("\n");
      out.write("  \t$scope.grid.setActiveCell(0, 0);\n");
      out.write("  \t\n");
      out.write("  \tif(gridColumn.isActionable == true) {\n");
      out.write("  \t\t$scope.grid.setSelectionModel(new Slick.RowSelectionModel({selectActiveRow: false}));\n");
      out.write("    \t$scope.grid.registerPlugin(checkboxSelector);\n");
      out.write("\t}\n");
      out.write("    //var columnpicker = new Slick.Controls.ColumnPicker(column, $scope.grid, options);\n");
      out.write("    \n");
      out.write("    $scope.getSelectedRows = function() {\n");
      out.write("    \tvar selectedRows = $scope.grid.getSelectedRows();\n");
      out.write("    \tvar selectedIds = [];\n");
      out.write("    \tfor(var i = 0 ; i <  selectedRows.length; i++) {\n");
      out.write("\t\t\tselectedIds.push(dataView.getItem(selectedRows[i]).id);\n");
      out.write("\t\t}\n");
      out.write("    \treturn selectedIds;\n");
      out.write("    }\n");
      out.write("    \n");
      out.write("\t");
      out.write("\n");
      out.write("\t$scope.pillboxs = [{item:\"A\",value:1},{item:\"B\",value:2}];\n");
      out.write("\t\n");
      out.write("\t$scope.pillClicked = function(data) {\n");
      out.write("\t\tdata.li.remove();\n");
      out.write("\t\t$scope.pillboxs = $filter('filter')($scope.pillboxs, function(item){return !(item.item == data.text)}, false);\n");
      out.write("\t};\n");
      out.write("\t\n");
      out.write("\t$scope.saveDoctor = function() {\n");
      out.write("\t\tconsole.log($scope.doctorForm);\n");
      out.write("\t\t$http({method:'POST', url:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/saveDoctor', data:$scope.doctorForm }).success(function(response) {\n");
      out.write("\t\t\tModal.CloseModal();\t\n");
      out.write("\t\t\tconsole.log(\"saved\");\n");
      out.write("\t    });\t\n");
      out.write("\t};\n");
      out.write("\t\n");
      out.write("\t$scope.updateDoctor = function() {\n");
      out.write("\t\tconsole.log($scope.doctorForm);\n");
      out.write("\t\t$http({method:'PUT', url:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/updateDoctor', data:$scope.doctorForm }).success(function(response) {\n");
      out.write("\t\t\tModal.CloseModal();\t\n");
      out.write("\t\t\n");
      out.write("\t    });\t\n");
      out.write("\t};\n");
      out.write("\t\n");
      out.write("\t$scope.initFormData = function(asJsonData) {\n");
      out.write("\t\t$scope.doctorForm = asJsonData;\n");
      out.write("\t};\n");
      out.write("\t\n");
      out.write("\t$scope.blockBtn = function() {\n");
      out.write("\t\talert($scope.getSelectedRows());\n");
      out.write("\t};\n");
      out.write("\t$scope.openEntityModalById = function(_id) {\n");
      out.write("\t\tModal.OpenModal({\n");
      out.write("\t\t\t templateUrl:'add-edit-doctor.html/'+_id,\n");
      out.write("\t\t\t scope: $scope,\n");
      out.write("\t\t\t windowClass: 'custom-modal',\n");
      out.write("\t\t\t templateCache: false\n");
      out.write("\t\t\t \n");
      out.write("\t\t},function() {\n");
      out.write("\t\t\t\n");
      out.write("\t\t});\n");
      out.write("\t\t\n");
      out.write("\t\t\n");
      out.write("\t};\n");
      out.write("\t\n");
      out.write("\t$scope.groupDetailModal = function(id) {\n");
      out.write("\t\t$scope.selectedGroupIndex = id;\n");
      out.write("\t\t$scope.selectedGroup = {};\n");
      out.write("\t\tif (id  == -1) {\n");
      out.write("\t\t\tangular.copy($scope.doctorForm.groupDetails[0], $scope.selectedGroup);\n");
      out.write("\t\t} else {\n");
      out.write("\t\t\tangular.copy($scope.doctorForm.groupDetails[id], $scope.selectedGroup);\n");
      out.write("\t\t}\n");
      out.write("\t\tngDialog.open({\n");
      out.write("\t\t    template: 'add-edit-group.html',\n");
      out.write("\t\t    scope: $scope,\n");
      out.write("\t\t    className: 'ngdialog-theme-default'\n");
      out.write("\n");
      out.write("\t\t});\n");
      out.write("\t};\n");
      out.write("\t\n");
      out.write("\t\n");
      out.write("\t\n");
      out.write("\t$scope.addGroupDetail = function () {\n");
      out.write("\t\tif($scope.selectedGroupIndex == -1) {\n");
      out.write("\t\t\tvar selectedGroup = {};\n");
      out.write("\t\t\tangular.copy($scope.selectedGroup,selectedGroup);\n");
      out.write("\t\t\t$scope.doctorForm.groupDetails[$scope.doctorForm.groupDetails.length] = selectedGroup;\n");
      out.write("\t\t} else {\n");
      out.write("\t\t\tangular.copy($scope.selectedGroup,$scope.doctorForm.groupDetails[$scope.selectedGroupIndex]);\n");
      out.write("\t\t}\n");
      out.write("\t};\n");
      out.write("\t\n");
      out.write("\t$scope.removeGroupDetail = function () {\n");
      out.write("\t\t$scope.doctorForm.groupDetails.splice($scope.selectedGroupIndex, 1);\n");
      out.write("\t};\n");
      out.write("});\n");
      out.write("\n");
      out.write("</script>\n");
      out.write(" \n");
      out.write("\n");
      out.write("<!-- JUST A POC of Pillbox-->\n");
      out.write("<div class=\"fuelux\">\n");
      out.write("\t<div data-ng-pillbox class=\"pillbox pillbox-container\" on-item-click=\"pillClicked($data)\" data-ng-model=\"pillboxs\" pill-class=\"status-success\">\n");
      out.write("\t</div>\n");
      out.write("\t<button data-ng-click=\"pillboxs.push({item:'A1', value:3})\">Add</button>\n");
      out.write("</div>\n");
      out.write("  \n");
      out.write("<div class=\"box\">\n");
      out.write("\t");
      if (_jspx_meth_css_005fFormHeader_005f0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\t<div class=\"mws-panel-toolbar\">\n");
      out.write("          <div class=\"btn-toolbar\">\n");
      out.write("              <div class=\"btn-group\">\n");
      out.write("                  <a data-ng-click=\"openEntityModalById(-1)\" class=\"btn\"><i class=\"icol-add\"></i> Add</a>\n");
      out.write("                  <a data-ng-click=\"refreshBtn()\" class=\"btn\"><i class=\"icol-arrow-refresh\"></i> Refresh</a>\n");
      out.write("                  <a data-ng-click=\"blockBtn()\" class=\"btn\"><i class=\"icol-delete\"></i> Block</a>\n");
      out.write("             </div>\n");
      out.write("          </div>\n");
      out.write("    </div>\t\t\t\t\n");
      out.write("\t<div class=\"box-container\">\n");
      out.write("\t  <div class=\"onerow  color1-row\">\n");
      out.write("\t\t  <div class=\"col5\">\n");
      out.write("\t\t    ");
      if (_jspx_meth_css_005fgrid_002dfilter_005f0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\t\t  </div>\n");
      out.write("\t\t  <div class=\"col5\">\n");
      out.write("\t\t  \t");
      if (_jspx_meth_css_005fgrid_002dfilter_005f1(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\t\t  </div>\n");
      out.write("\t\t  <div class=\"dropdown col6\">\t\n");
      out.write("\t\t  \t");
      if (_jspx_meth_css_005fgrid_002dfilter_005f2(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\t\t  </div>\n");
      out.write("\t\t  <div class=\"col2 last\">\n");
      out.write("\t\t  \t<button data-ng-click=\"gridSearchBtn()\">Search</button>\n");
      out.write("\t\t  </div>\n");
      out.write("\t  </div>\n");
      out.write("\t\n");
      out.write("\t\t\n");
      out.write("\t\t<input type=\"text\" data-ng-model=\"gridSearch\" placeholder=\"Search\"  class=\"form-control\">\n");
      out.write("\t\t\n");
      out.write("\t\t<div class=\"col18\" id=\"myGrid\" style=\"height:450px;\" class=\"grid\"></div>\n");
      out.write("\t\n");
      out.write("\t</div>\t\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_css_005fFormHeader_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  css:FormHeader
    com.mnt.emr.tld.FormHeaderUI _jspx_th_css_005fFormHeader_005f0 = (new com.mnt.emr.tld.FormHeaderUI());
    _jsp_instancemanager.newInstance(_jspx_th_css_005fFormHeader_005f0);
    _jspx_th_css_005fFormHeader_005f0.setJspContext(_jspx_page_context);
    // /WEB-INF/jsp/module/doctor/view/doctor.main.html.jsp(11,1) name = cssclass type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_css_005fFormHeader_005f0.setCssclass("box-header-mini");
    _jspx_th_css_005fFormHeader_005f0.setJspBody(new Helper( 0, _jspx_page_context, _jspx_th_css_005fFormHeader_005f0, null));
    _jspx_th_css_005fFormHeader_005f0.doTag();
    _jsp_instancemanager.destroyInstance(_jspx_th_css_005fFormHeader_005f0);
    return false;
  }

  private boolean _jspx_meth_css_005fgrid_002dfilter_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  css:grid-filter
    com.mnt.emr.tld.GridFilter _jspx_th_css_005fgrid_002dfilter_005f0 = (new com.mnt.emr.tld.GridFilter());
    _jsp_instancemanager.newInstance(_jspx_th_css_005fgrid_002dfilter_005f0);
    _jspx_th_css_005fgrid_002dfilter_005f0.setJspContext(_jspx_page_context);
    // /WEB-INF/jsp/module/doctor/view/doctor.main.html.jsp(24,6) name = json type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_css_005fgrid_002dfilter_005f0.setJson((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${gridColumn}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
    // /WEB-INF/jsp/module/doctor/view/doctor.main.html.jsp(24,6) name = field type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_css_005fgrid_002dfilter_005f0.setField("name");
    // /WEB-INF/jsp/module/doctor/view/doctor.main.html.jsp(24,6) null
    _jspx_th_css_005fgrid_002dfilter_005f0.setDynamicAttribute(null, "data-ng-model", "searchForm.name");
    _jspx_th_css_005fgrid_002dfilter_005f0.doTag();
    _jsp_instancemanager.destroyInstance(_jspx_th_css_005fgrid_002dfilter_005f0);
    return false;
  }

  private boolean _jspx_meth_css_005fgrid_002dfilter_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  css:grid-filter
    com.mnt.emr.tld.GridFilter _jspx_th_css_005fgrid_002dfilter_005f1 = (new com.mnt.emr.tld.GridFilter());
    _jsp_instancemanager.newInstance(_jspx_th_css_005fgrid_002dfilter_005f1);
    _jspx_th_css_005fgrid_002dfilter_005f1.setJspContext(_jspx_page_context);
    // /WEB-INF/jsp/module/doctor/view/doctor.main.html.jsp(27,5) name = json type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_css_005fgrid_002dfilter_005f1.setJson((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${gridColumn}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
    // /WEB-INF/jsp/module/doctor/view/doctor.main.html.jsp(27,5) name = field type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_css_005fgrid_002dfilter_005f1.setField("roleType");
    // /WEB-INF/jsp/module/doctor/view/doctor.main.html.jsp(27,5) null
    _jspx_th_css_005fgrid_002dfilter_005f1.setDynamicAttribute(null, "data-ng-model", "searchForm.roleType");
    _jspx_th_css_005fgrid_002dfilter_005f1.doTag();
    _jsp_instancemanager.destroyInstance(_jspx_th_css_005fgrid_002dfilter_005f1);
    return false;
  }

  private boolean _jspx_meth_css_005fgrid_002dfilter_005f2(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  css:grid-filter
    com.mnt.emr.tld.GridFilter _jspx_th_css_005fgrid_002dfilter_005f2 = (new com.mnt.emr.tld.GridFilter());
    _jsp_instancemanager.newInstance(_jspx_th_css_005fgrid_002dfilter_005f2);
    _jspx_th_css_005fgrid_002dfilter_005f2.setJspContext(_jspx_page_context);
    // /WEB-INF/jsp/module/doctor/view/doctor.main.html.jsp(30,5) name = json type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_css_005fgrid_002dfilter_005f2.setJson((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${gridColumn}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
    // /WEB-INF/jsp/module/doctor/view/doctor.main.html.jsp(30,5) name = field type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_css_005fgrid_002dfilter_005f2.setField("dateOfBirth");
    // /WEB-INF/jsp/module/doctor/view/doctor.main.html.jsp(30,5) null
    _jspx_th_css_005fgrid_002dfilter_005f2.setDynamicAttribute(null, "data-ng-model", "searchForm.dob");
    // /WEB-INF/jsp/module/doctor/view/doctor.main.html.jsp(30,5) null
    _jspx_th_css_005fgrid_002dfilter_005f2.setDynamicAttribute(null, "value", "{{searchForm.dob|date:'MMMM-dd-yyyy'||'From'}}");
    _jspx_th_css_005fgrid_002dfilter_005f2.doTag();
    _jsp_instancemanager.destroyInstance(_jspx_th_css_005fgrid_002dfilter_005f2);
    return false;
  }

  private class Helper
      extends org.apache.jasper.runtime.JspFragmentHelper
  {
    private javax.servlet.jsp.tagext.JspTag _jspx_parent;
    private int[] _jspx_push_body_count;

    public Helper( int discriminator, javax.servlet.jsp.JspContext jspContext, javax.servlet.jsp.tagext.JspTag _jspx_parent, int[] _jspx_push_body_count ) {
      super( discriminator, jspContext, _jspx_parent );
      this._jspx_parent = _jspx_parent;
      this._jspx_push_body_count = _jspx_push_body_count;
    }
    public boolean invoke0( javax.servlet.jsp.JspWriter out ) 
      throws java.lang.Throwable
    {
      out.write("Doctor");
      return false;
    }
    public void invoke( java.io.Writer writer )
      throws javax.servlet.jsp.JspException
    {
      javax.servlet.jsp.JspWriter out = null;
      if( writer != null ) {
        out = this.jspContext.pushBody(writer);
      } else {
        out = this.jspContext.getOut();
      }
      try {
        Object _jspx_saved_JspContext = this.jspContext.getELContext().getContext(javax.servlet.jsp.JspContext.class);
        this.jspContext.getELContext().putContext(javax.servlet.jsp.JspContext.class,this.jspContext);
        switch( this.discriminator ) {
          case 0:
            invoke0( out );
            break;
        }
        jspContext.getELContext().putContext(javax.servlet.jsp.JspContext.class,_jspx_saved_JspContext);
      }
      catch( java.lang.Throwable e ) {
        if (e instanceof javax.servlet.jsp.SkipPageException)
            throw (javax.servlet.jsp.SkipPageException) e;
        throw new javax.servlet.jsp.JspException( e );
      }
      finally {
        if( writer != null ) {
          this.jspContext.popBody();
        }
      }
    }
  }
}