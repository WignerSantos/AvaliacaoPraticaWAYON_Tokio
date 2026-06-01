package com.avaliacao.dao.usuario.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.avaliacao.dao.usuario.UsuarioDao;
import com.avaliacao.model.Usuario;
import com.avaliacao.utils.SqlUtil;

@Repository
public class UsuarioDaoImpl implements UsuarioDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private SqlUtil sqlUtil;

	@SuppressWarnings("unchecked")
	@Override
	public Usuario findByEmail(String email) {
		String sql = sqlUtil.getSql("findByEmail");

		Query query = entityManager.createNativeQuery(sql, Usuario.class);

		query.setParameter(1, email);

		List<Usuario> usuarios = query.getResultList();

		return usuarios.isEmpty() ? null : usuarios.get(0);
	}

	@Override
	public void save(Usuario usuario) {
		entityManager.persist(usuario);
	}

}
