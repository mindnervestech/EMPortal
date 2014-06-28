package com.mnt.emr.module.task.repository;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;
import org.springframework.stereotype.Service;

import com.avaje.ebean.Expr;
import com.avaje.ebean.Expression;
import com.mnt.emr.module.task.model.Task;
import com.mnt.emr.module.task.view.TaskVM;

@Service
public class TaskRepositoryImpl implements TaskRepository{
	@Override
	public Task saveTask(TaskVM taskVM) {
		Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
		Task task = mapper.map(taskVM, Task.class);
		task.save();
		return task;
	}

	@Override
	public TaskVM getTaskVMById(Long id) {
		Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
		Task task = Task.getTaskById(id);
		TaskVM vm = mapper.map(task, TaskVM.class);
		return vm;
	}

	@Override
	public Task updateTask(TaskVM taskVM) {
		Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
		Task task = mapper.map(taskVM, Task.class);
		task.update();
		return task;
	}
	
	@Override
	public void deleteTask(TaskVM taskVM) {
		Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
		Task task = mapper.map(taskVM, Task.class);
		task.delete();
	}
	
	@Override
	public List<TaskVM> searchTasksByFilter(String name, String role, String dob) {
		List<Expression> expressions = new ArrayList<Expression>();
		List<Task> tasks = new ArrayList<>();
		Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
		
		try {
				if(!name.equals("")){
					expressions.add(Expr.ilike("priority", "%" + name + "%")); 
				}
			
		}
		catch(NullPointerException e) {
			e.printStackTrace();
		}
		try {
				if(!role.equals("")){
					expressions.add(Expr.ilike("status", "%" + role + "%")); 
				}
		}
		catch(NullPointerException e) {
			e.printStackTrace();
		}
		if(expressions.size()!=0)
		{
			Expression exp = expressions.get(0);
			for(int i =1;i<expressions.size();i++)
			{
				exp = Expr.and(exp, expressions.get(i));
			}
			
			tasks = Task.find.where(exp).findList();
		}
		else {
			tasks = Task.find.all();
		}
		
		List<TaskVM> taskVMs = new ArrayList<>();
		for(Task t : tasks) {
			TaskVM vm = mapper.map(t, TaskVM.class);
			taskVMs.add(vm);
		}
		
		return taskVMs;
	}

}
