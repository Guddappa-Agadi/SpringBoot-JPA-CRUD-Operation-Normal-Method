package com.springboot;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeRepository er;

	@PostMapping("/add")
	public ResponseEntity<Employee> saveData(@RequestBody Employee e) {
		return new ResponseEntity<>(er.save(e), HttpStatus.CREATED);
	}

	@GetMapping("/get")
	public ResponseEntity<List<Employee>> getAllData() {
		List<Employee> lst = er.findAll();
		return new ResponseEntity<>(lst, HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Employee> getByID(@PathVariable int employee_id) {
		Optional<Employee> obj = er.findById(employee_id);
		if (obj.isPresent()) {
			return new ResponseEntity<>(obj.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}

	@PutMapping("/get/{id}")
	public ResponseEntity<Employee> updateByID(@PathVariable int employee_id, @RequestBody Employee e) {
		Optional<Employee> obj = er.findById(employee_id);
		if (obj.isPresent()) {
			obj.get().setEmployee_name(e.getEmployee_name());
			obj.get().setEmployee_age(e.getEmployee_age());
			obj.get().setEmployee_email(e.getEmployee_email());
			obj.get().setEmployee_phoneNo(e.getEmployee_phoneNo());
			obj.get().setEmployee_salary(e.getEmployee_salary());
			return new ResponseEntity<>(er.save(obj.get()), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}

	@DeleteMapping("/get/{id}")
	public ResponseEntity<Employee> deleteByID(@PathVariable int employee_id) {
		Optional<Employee> obj = er.findById(employee_id);
		if (obj.isPresent()) {
			er.deleteById(employee_id);
			return new ResponseEntity<>(obj.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}

	@GetMapping("/get/page")
	public List<Employee> getByPages(@RequestParam int page,@RequestParam int size, @RequestParam String field ) {
		Pageable pag = PageRequest.of(page, size, Direction.ASC,field);
		Page<Employee> p = er.findAll(pag);
		return p.getContent();
	}

	@GetMapping("/get/pages")
	public Page<Employee> page(Pageable page){
		return er.findAll(page);
	}
}
