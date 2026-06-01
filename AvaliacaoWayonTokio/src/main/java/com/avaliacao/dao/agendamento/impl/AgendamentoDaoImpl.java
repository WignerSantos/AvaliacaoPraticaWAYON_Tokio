package com.avaliacao.dao.agendamento.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.avaliacao.dao.agendamento.AgendamentoDao;
import com.avaliacao.model.Agendamento;
import com.avaliacao.utils.SqlUtil;

@Repository
public class AgendamentoDaoImpl implements AgendamentoDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private SqlUtil sqlUtil;

	@SuppressWarnings("unchecked")
	@Override
	public List<Agendamento> findByContaOrigemId(Long contaId) {
		String sql = sqlUtil.getSql("findByContaOrigemId");

		Query query = entityManager.createNativeQuery(sql, Agendamento.class);

		query.setParameter(1, contaId);

		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Agendamento> findByContaDestinoId(Long contaId) {
		String sql = sqlUtil.getSql("findByContaDestinoId");

		Query query = entityManager.createNativeQuery(sql, Agendamento.class);

		query.setParameter(1, contaId);

		return query.getResultList();
	}

}
