package com.avaliacao.dao.agendamento;

import java.util.List;

import com.avaliacao.model.Agendamento;

public interface AgendamentoDao {

	List<Agendamento> findByContaOrigemId(Long contaId);

	List<Agendamento> findByContaDestinoId(Long contaId);

}
