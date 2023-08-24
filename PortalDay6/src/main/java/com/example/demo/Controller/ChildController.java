package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.ChildService;
import com.example.demo.model.Child;

@RestController
public class ChildController {
	
	@Autowired
	ChildService cs;
	
	@PostMapping("addchild")
	public Child addinfo(@RequestBody Child  c) {
		return cs.add(c);
	}
	
	@PostMapping("addnchild")
	public List<Child> addninfo(@RequestBody List<Child> c){
		return (List<Child>) cs.addn(c);
	}
	
	@GetMapping("showchild")
	public List<Child> showinfo(){
		return (List<Child>) cs.show();
	}
	
	@GetMapping("showid/{id}")
	public Optional<Child> showidinfo(@PathVariable int id){
		return cs.showbyid(id);
	}
	
	@GetMapping("sortchild/{babyFName}")
	public List<Child> sortinfo(@PathVariable String babyFName){
		return cs.sort(babyFName);
	}
	
	@GetMapping("pagingchild/{pgno}/{pgsize}")
	public List<Child> pageinfo(@PathVariable int pgno,@PathVariable int pgsize){
		return cs.getpage(pgno, pgsize);
	}
	
	@GetMapping("pagesort/{pgno}/{pgsize}/{babyFName}")
	public List<Child> pagebysortinfo(@PathVariable int pgno,@PathVariable int pgsize,@PathVariable String babyFName){
		return cs.getpagesort(pgno, pgsize, babyFName);
	}
	
	@PutMapping("modchild")
	public Child modinfo(@RequestBody Child c) {
		return cs.modify(c);
	}
	
	@PutMapping("modid")
	public String modidinfo(@PathVariable int id,@RequestBody Child c) {
		return cs.modifybyid(id, c);
	}
	
	
	@DeleteMapping("deletechild")
	public String removeinfo(@RequestBody Child c) {
		cs.remove(c);
		return "DELETED";
	}
	
	@DeleteMapping("deleteid/{id}")
	public String removeidinfo(@PathVariable int id) {
		cs.removeid(id);
		return "DELETEDBYID";
	}
	
}
