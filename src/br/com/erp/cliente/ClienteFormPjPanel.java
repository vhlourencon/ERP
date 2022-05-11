package br.com.erp.cliente;

import java.awt.Dimension;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public class ClienteFormPjPanel extends JPanel {
	private JTextField textFieldRazaoSocial;
	private JTextField textFieldNomeFantasia;
	private JTextField textFieldIE;
	private JTextField textFieldIM;
	private JTextField textFieldEmail;
	private JTextField textFieldResponsavelNome;
	private JTextField textFieldResponsavalEmail;
	private JFormattedTextField textFieldResponsavelCPF;
	private JFormattedTextField textFieldResponsavelDN;
	private JFormattedTextField textFieldCNPJ;
	private JRadioButton radioButtonContNao;
	private JRadioButton radioButtonContSim;
	private JCheckBox checkBoxAtivo;
	private JFormattedTextField textFieldResponsavelCelular;
	private JFormattedTextField textFieldResponsavelTelefone;

	private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

	private ClienteModel clienteModel;

	public ClienteFormPjPanel() {
		setLayout(null);

		JLabel labelRazaoSocial = new JLabel("Razão Social: ");
		labelRazaoSocial.setBounds(10, 11, 150, 14);
		add(labelRazaoSocial);

		textFieldRazaoSocial = new JTextField();
		textFieldRazaoSocial.setColumns(10);
		textFieldRazaoSocial.setBounds(10, 29, 239, 20);
		add(textFieldRazaoSocial);

		textFieldNomeFantasia = new JTextField();
		textFieldNomeFantasia.setColumns(10);
		textFieldNomeFantasia.setBounds(259, 29, 131, 20);
		add(textFieldNomeFantasia);

		JLabel labelNomeFantasia = new JLabel("Nome Fantasia:");
		labelNomeFantasia.setBounds(259, 11, 150, 14);
		add(labelNomeFantasia);

		JLabel lblCnpj = new JLabel("CNPJ:");
		lblCnpj.setBounds(10, 60, 150, 14);
		add(lblCnpj);

		try {
			textFieldCNPJ = new JFormattedTextField(new MaskFormatter("##.###.###/####-##"));
			textFieldCNPJ.setFocusLostBehavior(JFormattedTextField.PERSIST);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		textFieldCNPJ.setFocusLostBehavior(JFormattedTextField.PERSIST);
		textFieldCNPJ.setColumns(10);
		textFieldCNPJ.setBounds(10, 81, 239, 20);
		add(textFieldCNPJ);

		JLabel labelContribuinte = new JLabel("Contribuinte:");
		labelContribuinte.setBounds(259, 60, 131, 14);
		add(labelContribuinte);

		JLabel labelE = new JLabel("Insc. Estadual");
		labelE.setBounds(10, 112, 117, 14);
		add(labelE);

		textFieldIE = new JTextField();
		textFieldIE.setBounds(10, 130, 171, 20);
		add(textFieldIE);

		JLabel labelIM = new JLabel("Insc. Municipal:");
		labelIM.setBounds(191, 112, 117, 14);
		add(labelIM);

		textFieldIM = new JTextField();
		textFieldIM.setBounds(191, 130, 199, 20);
		add(textFieldIM);

		JLabel labelEmail = new JLabel("Email:");
		labelEmail.setBounds(10, 161, 117, 14);
		add(labelEmail);

		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(10, 182, 380, 20);
		add(textFieldEmail);

		JLabel labelTelefone = new JLabel("Telefone:");
		labelTelefone.setBounds(10, 326, 117, 14);
		add(labelTelefone);

		try {
			textFieldResponsavelTelefone = new JFormattedTextField(new MaskFormatter("(##)####-####"));
			textFieldResponsavelTelefone.setFocusLostBehavior(JFormattedTextField.PERSIST);

		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		textFieldResponsavelTelefone.setBounds(10, 347, 171, 20);
		add(textFieldResponsavelTelefone);

		JLabel labelCelular = new JLabel("Celular:");
		labelCelular.setBounds(189, 326, 117, 14);
		add(labelCelular);

		try {
			textFieldResponsavelCelular = new JFormattedTextField(new MaskFormatter("(##)# ####-####"));
			textFieldResponsavelCelular.setFocusLostBehavior(JFormattedTextField.PERSIST);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		textFieldResponsavelCelular.setBounds(189, 347, 201, 20);
		add(textFieldResponsavelCelular);

		JPanel panel = new JPanel();
		panel.setBounds(259, 81, 131, 20);
		add(panel);
		panel.setLayout(null);

		radioButtonContNao = new JRadioButton("Não");
		radioButtonContNao.setBounds(71, 0, 54, 23);
		panel.add(radioButtonContNao);

		radioButtonContSim = new JRadioButton("Sim");
		radioButtonContSim.setBounds(0, 0, 54, 23);
		panel.add(radioButtonContSim);

		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(radioButtonContNao);
		buttonGroup.add(radioButtonContSim);
		// buttonGroup.setSelected(radioButtonContNao, true);

		JLabel labelCPF = new JLabel("CPF:");
		labelCPF.setBounds(10, 274, 150, 14);
		add(labelCPF);

		try {
			textFieldResponsavelCPF = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
			textFieldResponsavelCPF.setFocusLostBehavior(JFormattedTextField.PERSIST);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		textFieldResponsavelCPF.setFocusLostBehavior(JFormattedTextField.PERSIST);
		textFieldResponsavelCPF.setBounds(10, 295, 239, 20);
		add(textFieldResponsavelCPF);

		JLabel labelDN = new JLabel("Data de Nascimento:");
		labelDN.setBounds(259, 274, 131, 14);
		add(labelDN);

		try {
			textFieldResponsavelDN = new JFormattedTextField(new MaskFormatter("##/##/####"));
			textFieldResponsavelDN.setFocusLostBehavior(JFormattedTextField.PERSIST);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		textFieldResponsavelDN.setBounds(259, 295, 131, 20);
		add(textFieldResponsavelDN);

		JLabel lblNomeDoResponsvel = new JLabel("Nome do Responsável:");
		lblNomeDoResponsvel.setBounds(10, 222, 229, 14);
		add(lblNomeDoResponsvel);

		textFieldResponsavelNome = new JTextField();
		textFieldResponsavelNome.setBounds(10, 243, 380, 20);
		add(textFieldResponsavelNome);

		JLabel lblEmailDoResponsvel = new JLabel("Email do Responsável:");
		lblEmailDoResponsvel.setBounds(400, 326, 181, 14);
		add(lblEmailDoResponsvel);

		textFieldResponsavalEmail = new JTextField();
		textFieldResponsavalEmail.setBounds(400, 347, 193, 20);
		add(textFieldResponsavalEmail);

		checkBoxAtivo = new JCheckBox("Ativo");
		checkBoxAtivo.setBounds(396, 28, 208, 23);
		add(checkBoxAtivo);

		setPreferredSize(new Dimension(2000, 370));
		setMaximumSize(new Dimension(2000, 370));

	}

	public ClienteModel getClienteModel() {
		if (clienteModel != null) {
			clienteModel.setNomeRazao(textFieldRazaoSocial.getText());
			clienteModel.setEmail(textFieldEmail.getText());
			clienteModel.setPjAtivo(checkBoxAtivo.isSelected());
			clienteModel.setPjNomeFantasia(textFieldNomeFantasia.getText());
			clienteModel.setPjCNPJ(textFieldCNPJ.getText());
			clienteModel.setPjContribuinte(radioButtonContSim.isSelected());
			clienteModel.setPjIE(textFieldIE.getText());
			clienteModel.setPjIM(textFieldIM.getText());
			clienteModel.setPjResponsavelNome(textFieldResponsavelNome.getText());
			clienteModel.setPjREsponsavelCPF(textFieldResponsavelCPF.getText());
			if (textFieldResponsavelDN.getText() != null) {
				try {
					clienteModel.setPjREsponsvavelDN(simpleDateFormat.parse(textFieldResponsavelDN.getText()));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			clienteModel.setPjREsponsavelTelefone(textFieldResponsavelTelefone.getText());
			clienteModel.setPjResponsavelCelular(textFieldResponsavelCelular.getText());
			clienteModel.setPjREsponsavelEmail(textFieldResponsavalEmail.getText());
		}
		return clienteModel;
	}

	public void setClienteModel(ClienteModel clienteModel) {
		this.clienteModel = clienteModel;
		textFieldRazaoSocial.setText(null);
		textFieldNomeFantasia.setText(null);
		checkBoxAtivo.setSelected(false);
		textFieldCNPJ.setText(null);
		radioButtonContNao.setSelected(true);
		textFieldIE.setText(null);
		textFieldIM.setText(null);
		textFieldEmail.setText(null);
		textFieldResponsavelNome.setText(null);
		textFieldResponsavelCPF.setText(null);
		textFieldResponsavelDN.setText(null);
		textFieldResponsavelTelefone.setText(null);
		textFieldResponsavelCelular.setText(null);
		textFieldResponsavalEmail.setText(null);

		if (clienteModel != null) {
			textFieldRazaoSocial.setText(clienteModel.getNomeRazao());
			textFieldNomeFantasia.setText(clienteModel.getPjNomeFantasia());
			checkBoxAtivo.setSelected(clienteModel.isPjAtivo());
			textFieldCNPJ.setText(clienteModel.getPjCNPJ());
			radioButtonContSim.setSelected(clienteModel.isPjContribuinte());
			textFieldIE.setText(clienteModel.getPjIE());
			textFieldIM.setText(clienteModel.getPjIM());
			textFieldEmail.setText(clienteModel.getEmail());
			textFieldResponsavelNome.setText(clienteModel.getPjResponsavelNome());
			textFieldResponsavelCPF.setText(clienteModel.getPjREsponsavelCPF());
			if (clienteModel.getPjREsponsvavelDN() != null) {
				textFieldResponsavelDN.setText(simpleDateFormat.format(clienteModel.getPjREsponsvavelDN()));
			}

			textFieldResponsavelTelefone.setText(clienteModel.getPjREsponsavelTelefone());
			textFieldResponsavelCelular.setText(clienteModel.getPjResponsavelCelular());
			textFieldResponsavalEmail.setText(clienteModel.getPjREsponsavelEmail());
		}
	}

}
