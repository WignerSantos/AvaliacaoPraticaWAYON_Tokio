package com.avaliacao.utils;

import java.io.IOException;
import java.util.Properties;

import javax.annotation.PostConstruct;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

@Component
public class SqlUtil {

	private Properties properties;

	@PostConstruct
	public void init() {

		try {

			properties = new Properties();

			properties.load(new ClassPathResource("queries.properties").getInputStream());

		} catch (IOException e) {

			throw new RuntimeException("Erro ao carregar queries.properties", e);
		}
	}

	public String getSql(String key) {

		String sql = properties.getProperty(key);

		if (sql == null) {

			throw new RuntimeException("Query não encontrada: " + key);
		}

		return sql;
	}

}
