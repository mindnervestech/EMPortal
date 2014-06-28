	$scope.gridSearch = "";
	dataView = new Slick.Data.DataView({ inlineFilters: true });
	
	var gridColumn = angular.fromJson(${gridColumn});
	$scope.searchForm={};
	$scope.gridSearchBtn= function(){
	
		 $http({method:'GET', url:gridColumn.searchUrl, params:$scope.searchForm }).success(function(response) {
        	dataView.setItems(response);
        	dataView.refresh();
        	$scope.grid.invalidate();
	      	$scope.grid.render();
    	  });
	}
	
	$scope.refreshBtn= function(){
	
		 $http({method:'GET', url:gridColumn.searchUrl }).success(function(response) {
        	dataView.setItems(response);
        	dataView.refresh();
        	$scope.grid.invalidate();
	      	$scope.grid.render();
    	  });
	}
	
	var checkboxSelector = new Slick.CheckboxSelectColumn({
      cssClass: "slick-cell-checkboxsel"
    });
    
	var column =  gridColumn.column;
	
	if(gridColumn.isActionable == true) {
    	column.unshift(checkboxSelector.getColumnDefinition());
    }
	
	var options = {
		enableColumnReorder: false,
	    multiColumnSort: true,
	    forceFitColumns: false,
	    enableCellNavigation: true};
	    
	$scope.grid = new Slick.Grid("#myGrid", dataView, column,options );
	$scope.grid.onSort.subscribe(function (e, args) {
	      var cols = args.sortCols;
	      dataView.sort(function (dataRow1, dataRow2) {
	        for (var i = 0, l = cols.length; i < l; i++) {
	          var field = cols[i].sortCol.field;
	          var sign = cols[i].sortAsc ? 1 : -1;
	          var value1 = dataRow1[field], value2 = dataRow2[field];
	          console.log(value1);console.log(value2);
	          var result = (value1 == value2 ? 0 : (value1 > value2 ? 1 : -1)) * sign;
	          if (result != 0) {
	            return result;
	          }
	        }
	        return 0;
	      });
	      $scope.grid.invalidate();
	      $scope.grid.render();
	});
	dataView.onRowCountChanged.subscribe(function (e, args) {
	  $scope.grid.updateRowCount();
	  $scope.grid.render();
	});
	
	function gridFilter(item, args) {
		
		if(args.searchString == "") return true;
		
		var found = false;
		for(var i = 0 ; i <  args.field.length; i++) {
			if (item[args.field[i]].toString().indexOf(args.searchString) != -1) {
    			found =  true;
    			break;
  			}
		}
  		return found;
	}
	
	dataView.onRowsChanged.subscribe(function (e, args) {
	  $scope.grid.invalidateRows(args.rows);
	  $scope.grid.render();
	});
	dataView.setItems(${gridData});
	dataView.setFilterArgs({
    	searchString: "",
    	field: gridColumn.searchable
  	});
	dataView.setFilter(gridFilter);
	$scope.$watch('gridSearch', function() {
		dataView.setFilterArgs({
    		searchString: $scope.gridSearch,
    		field: gridColumn.searchable
  		});
		dataView.refresh();
	});
	$scope.grid.onDblClick.subscribe(function(e,args){
    	var cell = $scope.grid.getCellFromEvent(e);
    	if (!cell) {
      		return;
    	}
    	$scope.openEntityModalById(dataView.getItem(cell.row).id);
    	return;
    });

  	$scope.grid.setActiveCell(0, 0);
  	
  	if(gridColumn.isActionable == true) {
  		$scope.grid.setSelectionModel(new Slick.RowSelectionModel({selectActiveRow: false}));
    	$scope.grid.registerPlugin(checkboxSelector);
	}
    //var columnpicker = new Slick.Controls.ColumnPicker(column, $scope.grid, options);
    
    $scope.getSelectedRows = function() {
    	var selectedRows = $scope.grid.getSelectedRows();
    	var selectedIds = [];
    	for(var i = 0 ; i <  selectedRows.length; i++) {
			selectedIds.push(dataView.getItem(selectedRows[i]).id);
		}
    	return selectedIds;
    }
    
	