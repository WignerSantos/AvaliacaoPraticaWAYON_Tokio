package com.avaliacao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avaliacao.dto.CadastroDTO;
import com.avaliacao.manager.auth.AuthManager;

@RestController
@RequestMapping("/auth")
public class AuthService {

	@Autowired
	private AuthManager authManager;

	@PostMapping("/register")
	public ResponseEntity<Void> register(@RequestBody CadastroDTO dto) {
		authManager.cadastrar(dto);

		return ResponseEntity.ok().build();
	}

}
