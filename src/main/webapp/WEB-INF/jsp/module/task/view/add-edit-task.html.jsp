	<%@ taglib prefix="css" uri="/WEB-INF/mnt.tld"%>
	<div class="modal-header" data-ng-init='initFormData(${asJson})'>
            <h3 class="modal-title">Add/Edit Task</h3>
    </div>
    <div class="modal-body">
    	<fieldset class="border">
    	<legend class="border">Task Information</legend>
        
			<div>
				<div class="onerow color1-row">
					<css:ui 
						data-ng-model="taskForm.priority" 
						labelClass="col2 small text-right" 
						class="col4 last" 
						cType="select" 
						ds="priorities" 
						label="Priority:"/>
						
						<css:ui 
						data-ng-model="taskForm.status" 
						labelClass="col2 small text-right" 
						class="col4 last" 
						cType="select" 
						ds="status" 
						label="Status:"/>
					
					<label class="col2  small text-right">Stat Task</label>
					<input type="checkbox"  data-ng-model="taskForm.statTask" class="">
				</div>
		
				<div class="onerow color0-row">
					<css:ui 
						data-ng-model="taskForm.dept" 
						labelClass="col2 small text-right" 
						class="col4 last"
						cType="select" 
						ds="departments" 
						label="Dept:"/>
						
					<label class="col2  small text-right">To:</label>
					<input class="col4" data-ng-model="taskForm.toTask" >
				
					<label class="col2 small text-right">CC:</label>
					<input class="col4" data-ng-model="taskForm.ccTask" >
					
						
				</div>
				
				<div class="onerow color1-row">
					<div class="dropdown col4" style="margin-left: 53px;">
                        	<css:ui  
                            data-ng-model="taskForm.startDate"
                            value="{{taskForm.startDate|date:'MMMM-dd-yyyy'||'From'}}"
                            labelClass="small text-right" 
                            cType="date" 
                            label="Start Date:"/>
                    </div>        
                        
                    	<css:ui 
						data-ng-model="taskForm.taskList" 
						labelClass="col2 small text-right" 
						class="col4 last"
						cType="select" 
						ds="taskList" 
						label="Task List:"/>
					<label class="col2  small text-right">Task Subject:</label>
					<input class="col4" data-ng-model="taskForm.taskSubject" >
				</div>
				<div class="onerow color0-row">
					<div class="dropdown col4" style="margin-left: 57px;">
                        	<css:ui  
                            data-ng-model="taskForm.dueDate"
                            value="{{taskForm.dueDate|date:'MMMM-dd-yyyy'||'From'}}"
                            labelClass="small text-right" 
                            cType="date" 
                            label="Due Date:"/>
                    </div> 
                    <div class="dropdown col4" style="">
                        	<css:ui  
                            data-ng-model="taskForm.fuDate"
                            value="{{taskForm.fuDate|date:'MMMM-dd-yyyy'||'From'}}"
                            labelClass="small text-right" 
                            cType="date" 
                            label="F/U:"/>
                    </div> 
                    <div class="dropdown col4" style="">
                        	<css:ui  
                            data-ng-model="taskForm.expDate"
                            value="{{taskForm.expDate|date:'MMMM-dd-yyyy'||'From'}}"
                            labelClass="small text-right" 
                            cType="date" 
                            label="EXP:"/>
                    </div> 
				</div>
				<div class="onerow color1-row">
					<div class="dropdown col8" style="margin-left: 21px;">
                        	<css:ui
                            data-ng-model="taskForm.completionDate"
                            value="{{taskForm.completionDate|date:'MMMM-dd-yyyy'||'From'}}"
                            labelClass="small text-right" 
                            cType="date" 
                            label="Completion Date:"/>
                    </div> 
					<label class="col2 small text-right">By:</label>
					<input class="col4" data-ng-model="taskForm.byTask" >
				</div>
				<div class="onerow color0-row">
					<label class="col2 small text-right">Comments/Notes:</label>
					<textarea class="col12" data-ng-model="taskForm.commentsTask"></textarea>
				</div>
			</div>
	   
	   </fieldset>
    </div>
    <div class="modal-footer">
            <button data-ng-show="taskForm.id == null" class="btn btn-primary" ng-click="saveTask()">Save</button>
            <button data-ng-show="taskForm.id != null" class="btn btn-primary" ng-click="updateTask()">Update</button>
            <button data-ng-show="taskForm.id != null" class="btn btn-primary" ng-click="deleteTask()">Delete</button>
    </div>

