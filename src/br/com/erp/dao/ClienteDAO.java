package br.com.erp.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import br.com.erp.ConnectFactory;
import br.com.erp.cliente.ClienteModel;

public class ClienteDAO {

	public ClienteModel salvar(ClienteModel vo) throws SQLException {

		Session session = ConnectFactory.getSession();
		session.save(vo);
		return vo;
	}

	public void alterar(ClienteModel model) throws SQLException {
		Session session = ConnectFactory.getSession();
		session.merge(model);

	}

	public void excluir(ClienteModel model) throws SQLException {
		Session session = ConnectFactory.getSession();
		session.remove(model);
	}

	public ClienteModel merge(ClienteModel vo) throws SQLException {
		Session session = ConnectFactory.getSession();
		session.merge(vo);

		return vo;
	}

	public ClienteModel obterPorId(ClienteModel model) throws SQLException {
		Session session = ConnectFactory.getSession();
		Query select = session
				.createQuery("select g FROM " + model.getClass().getCanonicalName() + " g WHERE g.id = :id ");
		select.setParameter("id", model.getId());
		model = (ClienteModel) select.getSingleResult();
		return (ClienteModel) model;
	}

	public ClienteModel obterPorId(Long id) throws SQLException {
		Session session = ConnectFactory.getSession();

		Query select = session
				.createQuery("select g FROM " + ClienteModel.class.getCanonicalName() + " g WHERE g.id = :id ");
		select.setParameter("id", id);

		ClienteModel model = (ClienteModel) select.getSingleResult();
		return model;
	}

	public List<ClienteModel> obterTodos() throws SQLException {
		Session session = ConnectFactory.getSession();
		Query select = session.createQuery(" FROM " + ClienteModel.class.getCanonicalName() + " g");
		List<ClienteModel> lista = (ArrayList<ClienteModel>) select.getResultList();
		return lista;
	}

	public ArrayList<ClienteModel> obterTodosComFiltro(String filtro) throws SQLException {

		Session session = ConnectFactory.getSession();
		Query select = session.createQuery(filtro);
		ArrayList<ClienteModel> lista = (ArrayList<ClienteModel>) select.getResultList();
		return lista;
	}

}
