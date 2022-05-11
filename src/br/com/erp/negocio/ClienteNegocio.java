package br.com.erp.negocio;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.caelum.stella.format.CEPFormatter;
import br.com.caelum.stella.tinytype.CNPJ;
import br.com.caelum.stella.tinytype.CPF;
import br.com.erp.cliente.ClienteModel;
import br.com.erp.dao.ClienteDAO;

public class ClienteNegocio {

	protected ClienteDAO dao;

	public ClienteNegocio() {
		dao = new ClienteDAO();
	}

	public ClienteModel salvar(ClienteModel vo) throws Exception {
		Exception exc = validar(vo);
		if (exc == null) {
			try {
				dao.salvar(vo);
				return vo;
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("Ocorreu um erro ao tentar salvar:\n" + e.getMessage());
			}
		} else {
			throw exc;
		}
	}

	public ClienteModel merge(ClienteModel vo) throws Exception {
		Exception exc = validar(vo);
		if (exc == null) {
			try {
				dao.merge(vo);
				return vo;
			} catch (Exception e) {
				throw (Exception) new Exception("Ocorreu um erro ao tentar salvar:\n" + e.getMessage());
			}
		} else {
			throw exc;
		}
	}

	public void alterar(ClienteModel model) throws Exception {
		Exception exc = validar(model);
		if (exc == null) {
			try {
				dao.alterar(model);

			} catch (Exception e) {
				e.printStackTrace();
				throw (Exception) new Exception("Ocorreu um erro ao tentar alterar:\n" + e.getMessage());
			}
		} else {
			throw exc;
		}
	}

	public void excluir(ClienteModel model) throws Exception {
		try {
			dao.excluir(model);
		} catch (SQLException e) {
			throw new Exception("Ocorreu um erro ao tentar excluir:\n" + e.getMessage());
		}
	}

	public ClienteModel obterPorId(ClienteModel model) throws Exception {

		if (model.getId() != null) {
			try {
				model = dao.obterPorId(model);
				return model;
			} catch (Exception e) {
				throw (Exception) new Exception("Ocorreu um erro ao executar a operação:\n" + e.getMessage());
			}

		} else {
			throw new Exception("O id nÃ£o pode ser nulo");
		}

	}

	public ClienteModel obterPorId(Long id) throws Exception {

		try {
			return dao.obterPorId(id);
		} catch (Exception e) {
			throw (Exception) new Exception("Ocorreu um erro ao executar a operação:\n" + e.getMessage());
		}

	}

	public ArrayList<ClienteModel> obterTodos(Class classe) throws Exception {
		try {
			ArrayList<ClienteModel> lista = (ArrayList<ClienteModel>) dao.obterTodos();
			return lista;
		} catch (Exception e) {
			throw (Exception) new Exception(
					"Ocorreu um erro ao tentar obter os dados da consulta :\n" + e.getMessage());
		}
	}

	public ArrayList<ClienteModel> obterTodosComFiltro(ClienteModel filtroModel) throws Exception {
		try {
			ArrayList<ClienteModel> lista = (ArrayList<ClienteModel>) dao
					.obterTodosComFiltro(getSqlFiltro(filtroModel));
			return lista;
		} catch (Exception e) {
			e.printStackTrace();
			throw (Exception) new Exception("Ocorreu um erro ao tentar obter todos os Itens:\n" + e.getMessage());
		}
	}

	public String getSqlFiltro(ClienteModel vo) {
		String filtro = "FROM " + vo.getClass().getCanonicalName() + " g ";
		filtro += " where 1=1 ";

		if (vo.getNomeRazao() != null && vo.getNomeRazao().trim().length() > 0) {
			filtro += " and lower(nomeRazao) like('%" + vo.getNomeRazao().toLowerCase() + "%')";
		}

		filtro += " order by id asc";

		return filtro;
	}
	public static boolean isValidEmailAddressRegex(String email) {
	    boolean isEmailIdValid = false;
	    if (email != null && email.length() > 0) {
	        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
	        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
	        Matcher matcher = pattern.matcher(email);
	        if (matcher.matches()) {
	            isEmailIdValid = true;
	        }
	    }
	    return isEmailIdValid;
	}

	public Exception validar(ClienteModel vo) {
		StringBuffer msg = new StringBuffer("");
		
		/*
		 * Validacao de Pessoa Juridica
		 */
		if (vo.getTipo().equals("J")) {
			if (vo.getNomeRazao() == null || vo.getNomeRazao().trim().length() == 0) {
				msg.append("O campo RAZAO SOCIAL é de preenchimento obrigatório!\n");
			}
			
			if (vo.getPjNomeFantasia() == null || vo.getPjNomeFantasia().trim().length() == 0) {
				msg.append("O campo NOME FANTASIA é de preenchimento obrigatório!\n");
			}
			if (vo.getPjCNPJ() == null || vo.getPjCNPJ().trim().length() == 0) {
				msg.append("O campo CNPJ é de preenchimento obrigatório!\n");
			} else {
				CNPJ cnpj = new CNPJ(vo.getPjCNPJ());
				if(cnpj.isValid() == false) {
					msg.append("O campo CNPJ está invalido!\n");
				}
			}
		}
		/*
		 * Validacao de Pessoa Fisica
		 */
		
		if (vo.getTipo().equals("F")) {
			if (vo.getNomeRazao() == null || vo.getNomeRazao().trim().length() == 0) {
				msg.append("O campo NOME é de preenchimento obrigatório! \n");
			}
			
			CPF cpf = new CPF(vo.getPfCPF());
			if (cpf.isValido() == false) {
				msg.append("O campo CPF está invalido!\n");
			}	
		}

		if (vo.getEndCEP() == null || vo.getEndCEP().trim().length() == 0) {
			msg.append("O campo CEP é de preenchimento obrigatório!\n");
		} else {
			CEPFormatter cepFormatter = new CEPFormatter();
			if (cepFormatter.isFormatted(vo.getEndCEP()) == false) {
				msg.append("O campo CEP esta invalido!\n");
			}
		}
		
		if (vo.getEmail() == null || vo.getEmail().trim().length() == 0) {
			msg.append("O campo EMAIL é de preenchimento obrigatório!\n");
		} else {
			if(isValidEmailAddressRegex(vo.getEmail())== false) {
				msg.append("O campo EMAIL esta inválido!\n");
			}
		}
		
		

		if (msg.length() > 0)
			return new Exception(msg.toString());
		else
			return null;
	};

}