package com.avaliacao.dao.usuario;

import com.avaliacao.model.Usuario;

public interface UsuarioDao {

	Usuario findByEmail(String email);
	
	void save(Usuario usuario);
	
}
