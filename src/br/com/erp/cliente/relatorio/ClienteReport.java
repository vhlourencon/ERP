package br.com.erp.cliente.relatorio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import br.com.erp.cliente.ClienteModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class ClienteReport {

	public ClienteReport() {
	}

	public void gerar(ArrayList<ClienteModel> lista)
			throws JRException, SQLException, ClassNotFoundException, FileNotFoundException {
		JasperDesign desenho = JRXmlLoader.load("reports//cliente.jrxml");
		JasperReport reporte = JasperCompileManager.compileReport(desenho);

		ArrayList<ClienteReportModel> listaReport = new ArrayList<ClienteReport.ClienteReportModel>();

		if (lista != null) {
			for (ClienteModel clienteModel : lista) {
				ClienteReportModel clienteReportModel = new ClienteReportModel();
				clienteReportModel.setCpfCnpj(clienteModel.getPfCPF());
				clienteReportModel.setCel(clienteModel.getPfCelular());
				clienteReportModel.setTel(clienteModel.getPfTelefone());
				clienteReportModel.setEmail(clienteModel.getEmail());
				clienteReportModel.setNomeRazao(clienteModel.getNomeRazao());
				if (clienteModel.getTipo().equals("J")) {
					clienteReportModel.setCpfCnpj(clienteModel.getPjCNPJ());
					clienteReportModel.setCel(clienteModel.getPjResponsavelCelular());
					clienteReportModel.setTel(clienteModel.getPjREsponsavelTelefone());
				}
				listaReport.add(clienteReportModel);
			}
		}

		net.sf.jasperreports.engine.data.JRBeanCollectionDataSource jrds = new net.sf.jasperreports.engine.data.JRBeanCollectionDataSource(
				listaReport);
		JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, new LinkedHashMap<String, Object>(), jrds);
		JasperViewer viewer = new JasperViewer(jasperPrint, true);
		viewer.setVisible(true);

	}

	public class ClienteReportModel {
		private String nomeRazao;
		private String tel;
		private String cel;
		private String cpfCnpj;
		private String email;

		public String getNomeRazao() {
			return nomeRazao;
		}

		public void setNomeRazao(String nomeRazao) {
			this.nomeRazao = nomeRazao;
		}

		public String getTel() {
			return tel;
		}

		public void setTel(String tel) {
			this.tel = tel;
		}

		public String getCel() {
			return cel;
		}

		public void setCel(String cel) {
			this.cel = cel;
		}

		public String getCpfCnpj() {
			return cpfCnpj;
		}

		public void setCpfCnpj(String cpfCnpj) {
			this.cpfCnpj = cpfCnpj;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

	}

}