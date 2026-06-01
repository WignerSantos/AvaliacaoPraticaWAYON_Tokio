package com.avaliacao.dao.conta.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.avaliacao.dao.conta.ContaDao;
import com.avaliacao.model.Conta;
import com.avaliacao.utils.SqlUtil;

@Repository
public class ContaDaoImpl implements ContaDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private SqlUtil sqlUtil;

	@Override
	public Conta findByNumeroConta(String numeroConta) {
		String sql = sqlUtil.getSql("findByNumeroConta");

		Query query = entityManager.createNativeQuery(sql, Conta.class);

		query.setParameter(1, numeroConta);

		@SuppressWarnings("unchecked")
		List<Conta> conta = query.getResultList();

		return conta.isEmpty() ? null : conta.get(0);
	}

	@Override
	public void save(Conta conta) {
		entityManager.persist(conta);
	}

}
