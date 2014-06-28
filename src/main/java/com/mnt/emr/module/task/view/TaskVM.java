package com.mnt.emr.module.task.view;

import java.util.Date;

public class TaskVM {
	public Long id;
	
	public String priority;
	public String status;
	public boolean statTask;
	public String dept;
	public String toTask;
	public String ccTask;
	public Date startDate;
	public String taskList;
	public String taskSubject;
	public Date dueDate;
	public Date fuDate;
	public Date expDate;
	public Date completionDate;
	public String byTask;
	public String commentsTask;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public boolean isStatTask() {
		return statTask;
	}
	public void setStatTask(boolean statTask) {
		this.statTask = statTask;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getToTask() {
		return toTask;
	}
	public void setToTask(String toTask) {
		this.toTask = toTask;
	}
	public String getCcTask() {
		return ccTask;
	}
	public void setCcTask(String ccTask) {
		this.ccTask = ccTask;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public String getTaskList() {
		return taskList;
	}
	public void setTaskList(String taskList) {
		this.taskList = taskList;
	}
	public String getTaskSubject() {
		return taskSubject;
	}
	public void setTaskSubject(String taskSubject) {
		this.taskSubject = taskSubject;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public Date getFuDate() {
		return fuDate;
	}
	public void setFuDate(Date fuDate) {
		this.fuDate = fuDate;
	}
	public Date getExpDate() {
		return expDate;
	}
	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}
	public Date getCompletionDate() {
		return completionDate;
	}
	public void setCompletionDate(Date completionDate) {
		this.completionDate = completionDate;
	}
	public String getByTask() {
		return byTask;
	}
	public void setByTask(String byTask) {
		this.byTask = byTask;
	}
	public String getCommentsTask() {
		return commentsTask;
	}
	public void setCommentsTask(String commentsTask) {
		this.commentsTask = commentsTask;
	}
	
}
