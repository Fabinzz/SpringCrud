package com.spring.crud.resources;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.crud.entities.User;
import com.spring.crud.repositories.UserRepository;

@RestController
public class UserResources {
	
	@Autowired
	private UserRepository userRepo;
	
	@GetMapping("/users")
	public ResponseEntity<?> getAllUsers(){
		List<User> users = userRepo.findAll();
		if (users.size() > 0) {
			return new ResponseEntity<List<User>>(users, HttpStatus.OK);
		}else {
			return new ResponseEntity<>("Não foi encontrado nenhum usuário", HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/user")
	public ResponseEntity<?> createUser(@RequestBody User user){
		try {
			user.setRegistrationDate(new Date(System.currentTimeMillis()));
			userRepo.save(user);
			return new ResponseEntity<User>(user, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<?> getUserById(@PathVariable("id")String id){
		Optional<User> userOptional = userRepo.findById(id);
		if (userOptional.isPresent()){
			return new ResponseEntity<>(userOptional.get(), HttpStatus.OK);
		}else {
			return new ResponseEntity<>("Usuario com id "+id+" não foi encontrado", HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/users/{id}")
	public ResponseEntity<?> updateUserById(@PathVariable("id")String id, @RequestBody User user){
		Optional<User> userOptional = userRepo.findById(id);
		if (userOptional.isPresent()){
			User userToSave = userOptional.get();
			userToSave.setCpf(user.getCpf() != null ? user.getCpf() :  userToSave.getCpf());
			userToSave.setName(user.getName() != null ? user.getName() :  userToSave.getName());
			userToSave.setPhone(user.getPhone() != null ? user.getPhone() :  userToSave.getPhone());
			userToSave.setEmail(user.getEmail() != null ? user.getEmail() :  userToSave.getEmail());
			userToSave.setPassword(user.getPassword() != null ? user.getPassword() :  userToSave.getPassword());
			userToSave.setUpdateDate(new Date(System.currentTimeMillis()));
			userRepo.save(userToSave);
			return new ResponseEntity<>(userToSave, HttpStatus.OK);
		}else {
			return new ResponseEntity<>("Usuario com id "+id+" não foi encontrado", HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<?> deleteUserById(@PathVariable("id")String id){
		try {
			userRepo.deleteById(id);
			return new ResponseEntity<>("Usuário com id: "+id+" foi deletado com sucesso.", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
		
	
}
