package com.avaliacao.manager.auth.impl;

import java.util.concurrent.ThreadLocalRandom;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avaliacao.dao.conta.ContaDao;
import com.avaliacao.dao.usuario.UsuarioDao;
import com.avaliacao.dto.CadastroDTO;
import com.avaliacao.exceptions.BusinessException;
import com.avaliacao.manager.auth.AuthManager;
import com.avaliacao.model.Conta;
import com.avaliacao.model.Usuario;

@Service
@Transactional
public class AuthManagerImpl implements AuthManager {

	@Autowired
	private UsuarioDao usuarioDao;

	@Autowired
	private ContaDao contaDao;

	public void cadastrar(CadastroDTO dto) {

		Usuario usuario = usuarioDao.findByEmail(dto.getEmail());

		if (usuario != null) {
			throw new BusinessException("E-mail já cadastrado");
		}

		Usuario usuarioNovo = new Usuario();

		usuarioNovo.setNome(dto.getNome());
		usuarioNovo.setEmail(dto.getEmail());
		usuarioNovo.setSenha(dto.getSenha());
		usuarioDao.save(usuarioNovo);

		Conta conta = new Conta();

		conta.setNumeroConta(gerarNumeroConta());
		conta.setUsuario(usuarioNovo);
		contaDao.save(conta);
	}

	private String gerarNumeroConta() {
		return String.valueOf(ThreadLocalRandom.current().nextLong(1000000000L, 9999999999L));
	}

}
