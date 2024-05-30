package br.com.danielcodigos.traca.domain.user;

import java.util.UUID;

public record UserResponseDTO(UUID id, String name, String email, String username, String password) {
	
	public UserResponseDTO(User user) {
		this(user.getId(), user.getEmail(), user.getName(), user.getUsername(), user.getPassword());
	}
}