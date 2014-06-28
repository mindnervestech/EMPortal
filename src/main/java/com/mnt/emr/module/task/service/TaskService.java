package com.mnt.emr.module.task.service;

import java.util.List;

import com.mnt.emr.module.task.model.Task;
import com.mnt.emr.module.task.view.TaskVM;

public interface TaskService {
	Task saveTask(TaskVM taskVM);
	TaskVM getTaskVMById(Long id);	
	List<TaskVM> searchTasksByFilter(String name, String role, String dob);
	Task updateTask(TaskVM taskVM);
	void deleteTask(TaskVM taskVM );
}
