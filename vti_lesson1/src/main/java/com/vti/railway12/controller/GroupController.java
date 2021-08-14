package com.vti.railway12.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.railway12.entity.Group;
import com.vti.railway12.service.GroupService;

@RestController
@RequestMapping("/groupapi")
public class GroupController {
	
	@Autowired
	private GroupService groupService;
	
	@GetMapping("/group-list")
	public List<Group> getAllGroups() {
		return groupService.findAll();
	}
	
	@GetMapping("group/{id}")
	public Group getById(@PathVariable int id) {
		return groupService.findById(id);
	}
	@PutMapping("/update")
	public void updateGroup(@RequestBody Group group) {
		groupService.update(group);
	}
	
	@PostMapping("/create")
	public void createGroup(@RequestBody Group group) {
		groupService.save(group);
	}
	
	@DeleteMapping("/delete/{id}") 
	public void deleteGroupById(@PathVariable int id){
		groupService.delete(id);
	}
	
}
