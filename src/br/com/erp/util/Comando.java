package br.com.erp.util;

import org.hibernate.Session;

public interface Comando {

	public void execute(Session session) throws Exception;

}