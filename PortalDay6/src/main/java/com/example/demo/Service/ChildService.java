package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.ChildRepo;
import com.example.demo.model.Child;

@Service
public class ChildService {
	
	@Autowired
	ChildRepo cr;
	
	//POST
	
	public Child add(Child c) {
		return cr.save(c);
	}
	
	public List<Child> addn(List<Child>c){
		return (List<Child>)cr.saveAll(c);
	}
	
	//GET
	
	public List<Child> show(){
		return cr.findAll();
	}
	
	public Optional<Child> showbyid(int id){
		return cr.findById(id);
	}
	
	public List<Child> sort(String s){
		return cr.findAll(Sort.by(Sort.Direction.ASC,s));
	}
	
	public List<Child> getpage(int pgno,int pgsize){
		Page<Child> p=cr.findAll(PageRequest.of(pgno,pgsize));
		return p.getContent();
	}
	
	public List<Child> getpagesort(int pgno,int pgsize,String s){
		Page<Child> p=cr.findAll(PageRequest.of(pgno, pgsize,Sort.by(Sort.Direction.ASC,s)));
		return p.getContent();
	}
	
	//UPDATE
	
	public Child modify(Child c) {
		return cr.saveAndFlush(c);
	}
	
	public String modifybyid(int id,Child c) {
		cr.saveAndFlush(c);
		if(cr.existsById(id)) {
			return "UPDATED" ;
		}else {
			return "ENTER VALID ID";
		}
	}
	
	//DELETE
	
	public void remove(Child c) {
		cr.delete(c);
	}
	
	public void removeid(int id) {
		cr.deleteById(id);
	}
}
