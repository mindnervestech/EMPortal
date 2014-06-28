package com.mnt.emr.module.task.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mnt.emr.module.task.model.Task;
import com.mnt.emr.module.task.repository.TaskRepository;
import com.mnt.emr.module.task.view.TaskVM;

@Service
public class TaskServiceImpl implements TaskService{
	
	@Autowired
	TaskRepository taskRepository;
	
	@Override
	public Task saveTask(TaskVM taskVM) {
		return taskRepository.saveTask(taskVM);
	}

	@Override
	public TaskVM getTaskVMById(Long id) {
		return taskRepository.getTaskVMById(id);
	}

	@Override
	public List<TaskVM> searchTasksByFilter(String name, String role, String dob) {
		return taskRepository.searchTasksByFilter(name, role, dob);
	}

	@Override
	public Task updateTask(TaskVM taskVM) {
		return taskRepository.updateTask(taskVM);
	}
	
	@Override
	public void deleteTask(TaskVM taskVM) {
		 taskRepository.deleteTask(taskVM);
	}
}
