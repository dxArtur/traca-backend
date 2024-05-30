package br.com.danielcodigos.traca.domain.user;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/user")

public class UserController {
	
	@Autowired
	private UserRepository repository;
	
	@GetMapping("/all")
	public List<UserResponseDTO> getAllUsers() {
		List<UserResponseDTO> allUsers = repository.findAll().stream().map(UserResponseDTO::new).collect(Collectors.toList());;
		return allUsers;
	}
	
	
	@GetMapping("/{username}")
	public UserResponseDTO getByUsername(@PathVariable String username) { 
		Optional<User> response = repository.findByUsername(username);
		
		return response.map(UserResponseDTO::new).orElse(null);
		
	}
	
	@PostMapping
	public void registerUser(@RequestBody UserRequestDTO data) {
		User newUser = new User(data);
		repository.save(newUser);
	}
	
}
