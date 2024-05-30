package br.com.danielcodigos.traca.domain.user;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Table(name= "users")
@Entity(name="users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of= "id")
public class User{
		
	@Id @GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	private String name;
	private String username;
	private String email;
	private String password;
	
	public User(UserRequestDTO data) {
		this.email = data.email();
		this.name = data.name();
		this.username = data.username();
		this.password = data.password();
	}
}
