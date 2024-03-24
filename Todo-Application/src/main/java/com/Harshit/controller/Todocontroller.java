package com.Harshit.controller;

import java.time.LocalDate;
import java.util.List;

import com.Harshit.Todo;
import com.Harshit.AuthenticationService.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Todocontroller {
	
	
	public Todocontroller(TodoService todoService) {
		super();
		this.todoService = todoService;
	}

	private TodoService todoService;
	//
	@RequestMapping("list-todos")
	public String listAllTodos(ModelMap model) {
		List<Todo> todos = todoService.findByUsername("Harshit");
		
		model.addAttribute("todos", todos);
		
		return "listTodos";
	}
	
	//GET, POST
		@RequestMapping(value="add-todo", method = RequestMethod.GET)
		public String showNewTodoPage(ModelMap model) {
			String username = (String)model.get("name");
			Todo todo = new Todo(0, username, "Default Desc", LocalDate.now().plusYears(1), false);
			model.put("todo", todo);
			return "todo";
		}
		
		@RequestMapping(value="add-todo", method = RequestMethod.POST)
		public String addNewTodo(ModelMap model, Todo todo) {
			String username = (String)model.get("name");
			todoService.addTodo(username, todo.getDescription(), 
					LocalDate.now().plusYears(1), false);
			return "redirect:list-todos";
		}
	
}
