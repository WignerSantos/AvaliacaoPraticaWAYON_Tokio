package com.avaliacao.dao.conta;

import com.avaliacao.model.Conta;

public interface ContaDao {

	Conta findByNumeroConta(String numeroConta);
	
	void save(Conta conta);
	
}
