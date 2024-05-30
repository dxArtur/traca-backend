package br.com.danielcodigos.traca.domain.user;

import java.util.UUID;

public record UserRequestDTO(String name, String email, String username, String password) {
}
