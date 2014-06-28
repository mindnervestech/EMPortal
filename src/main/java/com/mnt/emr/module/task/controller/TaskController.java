package com.mnt.emr.module.task.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mnt.emr.module.task.service.TaskService;
import com.mnt.emr.module.task.view.TaskVM;
import com.mnt.emr.util.Json;

@Controller
public class TaskController {
	private static String USERGRIDCOLUMN_JSON = getStringFromInputStream(Thread.currentThread().getContextClassLoader()
            .getResourceAsStream("task_grid.json"));
	
	private static final Logger logger = LoggerFactory.getLogger(TaskController.class);
	
	@Autowired
	TaskService taskService;
	@RequestMapping(value = "/saveTask", method = RequestMethod.POST)
	public @ResponseBody Map<String,String> saveTask(@RequestBody TaskVM taskVM   ) {
		logger.info("inside save task");
		taskService.saveTask(taskVM);
		Map<String,String> message = new HashMap<String, String>();
		message.put("success", "Task Saved Successfully!");
		return message;
	}
	
	
	@RequestMapping(value = "/template/task.main.html", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("gridData","[]");
		model.addAttribute("gridColumn",USERGRIDCOLUMN_JSON);
		return "task.main.html";
	}
	
	@RequestMapping(value = "/task-search", method = RequestMethod.GET)
	@ResponseBody
	public List<TaskVM> searchTask(@RequestParam(required=false, value="priority") String name, @RequestParam(required=false, value="status") String role, @RequestParam(required=false, value="dob") String dob) {
		return taskService.searchTasksByFilter(name, role, dob);
	}
	
	@RequestMapping(value = "/updateTask", method = RequestMethod.PUT)
	public @ResponseBody Map<String,String> updateUser(@RequestBody TaskVM taskVM   ) {
		logger.info("inside update task");
		taskService.updateTask(taskVM);
		System.out.println(taskVM);
		Map<String,String> message = new HashMap<String, String>();
		message.put("success", "task Saved Successfully!");
		return message;
	}
	
	@RequestMapping(value = "/deleteTask", method = RequestMethod.PUT)
	public @ResponseBody Map<String,String> deleteUser(@RequestBody TaskVM taskVM   ) {
		logger.info("inside delete task");
		taskService.deleteTask(taskVM);
		System.out.println(taskVM);
		Map<String,String> message = new HashMap<String, String>();
		message.put("success", "Task Deleted Successfully!");
		return message;
	}
	
	@RequestMapping(value = "/add-edit-task.html/{id}", method = RequestMethod.GET)
	public String displayTask(@PathVariable Long id, Model model) {
		TaskVM taskVM = null;
		if(id == -1) {
			taskVM = new TaskVM();
		} else {
			taskVM = taskService.getTaskVMById(id);
		}
		model.addAttribute("asJson", Json.toJson(taskVM));
		model.addAttribute("task", taskVM);
		return "add-edit-task.html";
	}
	
	private static String getStringFromInputStream(InputStream is) {
		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();
		String line;
		try {
			br = new BufferedReader(new InputStreamReader(is));
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return sb.toString();
	}
}
