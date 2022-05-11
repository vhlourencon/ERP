package br.com.erp.cliente;

import java.awt.Dimension;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import com.lowagie.text.pdf.TextField;

import br.com.erp.enums.EstadoCivilEnum;

public class ClienteFormPfPanel extends JPanel {
	private JTextField textFieldNome;
	private JTextField textFieldApelido;
	private JFormattedTextField textFieldCPF;
	private JComboBox<EstadoCivilEnum> comboBoxEstadoCivil;

	private ClienteModel clienteModel;
	private JFormattedTextField textFieldDN;

	private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
	private JTextField textFieldEmail;
	private JTextField textFieldRG;
	private JTextField textFieldOrgaoEmissor;
	private JComboBox<String> comboBoxUF;
	private JTextField textFieldCNH;
	private JTextField textFieldSeguranca;
	private JTextField textFieldCEI;
	private JFormattedTextField textFieldCelular;
	private JFormattedTextField textFieldTelefone;

	public ClienteFormPfPanel() {
		setLayout(null);

		JLabel labelNomeCompleto = new JLabel("Nome Completo:");
		labelNomeCompleto.setBounds(10, 11, 150, 14);
		add(labelNomeCompleto);

		textFieldNome = new JTextField();
		textFieldNome.setBounds(10, 29, 380, 20);
		add(textFieldNome);
		textFieldNome.setColumns(10);

		textFieldApelido = new JTextField();
		textFieldApelido.setColumns(10);
		textFieldApelido.setBounds(400, 29, 163, 20);
		add(textFieldApelido);

		JLabel labelApelido = new JLabel("Apelido:");
		labelApelido.setBounds(400, 11, 150, 14);
		add(labelApelido);

		JLabel labelCPF = new JLabel("CPF:");
		labelCPF.setBounds(10, 60, 150, 14);
		add(labelCPF);

		try {
			textFieldCPF = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
			textFieldCPF.setFocusLostBehavior(JFormattedTextField.PERSIST);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		textFieldCPF.setBounds(10, 81, 239, 20);
		add(textFieldCPF);
		textFieldCPF.setColumns(10);

		try {
			textFieldDN = new JFormattedTextField(new MaskFormatter("##/##/####"));
			textFieldDN.setFocusLostBehavior(JFormattedTextField.PERSIST);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		textFieldDN.setBounds(259, 81, 131, 20);
		add(textFieldDN);

		JLabel labelDN = new JLabel("Data de Nascimento:");
		labelDN.setBounds(259, 60, 131, 14);
		add(labelDN);

		JLabel labelEstadoCivil = new JLabel("Estado Civil: ");
		labelEstadoCivil.setBounds(400, 60, 117, 14);
		add(labelEstadoCivil);

		comboBoxEstadoCivil = new JComboBox<EstadoCivilEnum>();
		comboBoxEstadoCivil.setModel(new DefaultComboBoxModel<EstadoCivilEnum>(EstadoCivilEnum.values()));
		comboBoxEstadoCivil.setBounds(400, 81, 163, 20);
		add(comboBoxEstadoCivil);

		JLabel labelRG = new JLabel("RG/CNE");
		labelRG.setBounds(10, 112, 117, 14);
		add(labelRG);

		textFieldRG = new JTextField();
		textFieldRG.setBounds(10, 130, 171, 20);
		add(textFieldRG);

		JLabel labelOrgaoEmissor = new JLabel("Orgão Emissor:");
		labelOrgaoEmissor.setBounds(191, 112, 117, 14);
		add(labelOrgaoEmissor);

		textFieldOrgaoEmissor = new JTextField();
		textFieldOrgaoEmissor.setBounds(191, 130, 199, 20);
		add(textFieldOrgaoEmissor);

		JLabel labelUF = new JLabel("UF:");
		labelUF.setBounds(400, 112, 117, 14);
		add(labelUF);

		comboBoxUF = new JComboBox<String>();
		comboBoxUF.setModel(new javax.swing.DefaultComboBoxModel<String>(
				new String[] { "", "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA",
						"PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RS", "SC", "SE", "SP", "TO" }));

		comboBoxUF.setBounds(400, 130, 163, 20);
		add(comboBoxUF);

		JLabel labelCNH = new JLabel("CNH:");
		labelCNH.setBounds(10, 161, 117, 14);
		add(labelCNH);

		textFieldCNH = new JTextField();
		textFieldCNH.setBounds(10, 182, 171, 20);
		add(textFieldCNH);

		JLabel labelSeguranca = new JLabel("Segurança:");
		labelSeguranca.setBounds(191, 161, 105, 14);
		add(labelSeguranca);

		textFieldSeguranca = new JTextField();
		textFieldSeguranca.setBounds(191, 182, 199, 20);
		add(textFieldSeguranca);

		JLabel labelCEI = new JLabel("CEI:");
		labelCEI.setBounds(400, 161, 117, 14);
		add(labelCEI);

		textFieldCEI = new JTextField();
		textFieldCEI.setBounds(400, 182, 163, 20);
		add(textFieldCEI);

		JLabel labelEmail = new JLabel("Email:");
		labelEmail.setBounds(10, 213, 117, 14);
		add(labelEmail);

		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(10, 234, 380, 20);
		add(textFieldEmail);

		JLabel labelTelefone = new JLabel("Telefone:");
		labelTelefone.setBounds(10, 265, 117, 14);
		add(labelTelefone);

		try {
			textFieldTelefone = new JFormattedTextField(new MaskFormatter("(##)####-####"));
			textFieldTelefone.setFocusLostBehavior(JFormattedTextField.PERSIST);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		textFieldTelefone.setBounds(10, 286, 171, 20);
		add(textFieldTelefone);

		JLabel labelCelular = new JLabel("Celular:");
		labelCelular.setBounds(189, 265, 117, 14);
		add(labelCelular);

		try {
			textFieldCelular = new JFormattedTextField(new MaskFormatter("(##)# ####-####"));
			textFieldCelular.setFocusLostBehavior(JFormattedTextField.PERSIST);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		textFieldCelular.setBounds(189, 286, 201, 20);
		add(textFieldCelular);
		setPreferredSize(new Dimension(2000, 320));
		setMaximumSize(new Dimension(2001, 320));
	}

	public ClienteModel getClienteModel() {
		if (clienteModel != null) {

			clienteModel.setNomeRazao(textFieldNome.getText());
			clienteModel.setEmail(textFieldEmail.getText());

			clienteModel.setPfCPF(textFieldCPF.getText());
			clienteModel.setPfApelido(textFieldApelido.getText());

			try {
				clienteModel.setPfDataNascimento(simpleDateFormat.parse(textFieldDN.getText()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			clienteModel.setPfEstadoCivil(null);
			if (comboBoxEstadoCivil.getSelectedItem() != null) {
				clienteModel.setPfEstadoCivil((EstadoCivilEnum) comboBoxEstadoCivil.getSelectedItem());
			}
			clienteModel.setPfRG(textFieldRG.getText());
			clienteModel.setPgORgaoEmissor(textFieldOrgaoEmissor.getText());
			clienteModel.setPfOrgaoEmissoUF(null);
			if (comboBoxUF.getSelectedItem() != null) {
				clienteModel.setPfOrgaoEmissoUF(comboBoxUF.getSelectedItem().toString());
			}
			clienteModel.setPfCNH(textFieldCNH.getText());
			clienteModel.setPfSeguranca(textFieldSeguranca.getText());
			clienteModel.setPfCEI(textFieldCEI.getText());
			clienteModel.setPfTelefone(textFieldTelefone.getText());
			clienteModel.setPfCelular(textFieldCelular.getText());

		}
		return clienteModel;
	}

	public void setClienteModel(ClienteModel clienteModel) {
		this.clienteModel = clienteModel;
		textFieldNome.setText(null);
		textFieldApelido.setText(null);
		textFieldCPF.setValue(null);
		textFieldDN.setValue(null);
		comboBoxEstadoCivil.setSelectedItem(null);
		textFieldRG.setText(null);
		textFieldOrgaoEmissor.setText(null);
		comboBoxUF.setSelectedItem(null);
		textFieldCNH.setText(null);
		textFieldSeguranca.setText(null);
		textFieldCEI.setText(null);
		textFieldEmail.setText(null);
		textFieldTelefone.setText(null);
		textFieldCelular.setText(null);
		if (clienteModel != null) {
			textFieldNome.setText(clienteModel.getNomeRazao());
			textFieldApelido.setText(clienteModel.getPfApelido());
			textFieldCPF.setValue(clienteModel.getPfCPF());
			if (clienteModel.getPfDataNascimento() != null) {
				textFieldDN.setText(simpleDateFormat.format(clienteModel.getPfDataNascimento()));
			}
			if (clienteModel.getPfEstadoCivil() != null) {
				comboBoxEstadoCivil.setSelectedItem(clienteModel.getPfEstadoCivil());
			}
			textFieldRG.setText(clienteModel.getPfRG());
			textFieldOrgaoEmissor.setText(clienteModel.getPgORgaoEmissor());
			comboBoxUF.setSelectedItem(clienteModel.getPfOrgaoEmissoUF());
			textFieldCNH.setText(clienteModel.getPfCNH());
			textFieldSeguranca.setText(clienteModel.getPfSeguranca());
			textFieldCEI.setText(clienteModel.getPfCEI());
			textFieldTelefone.setText(clienteModel.getPfTelefone());
			textFieldCelular.setValue(clienteModel.getPfCelular());
			textFieldEmail.setText(clienteModel.getEmail());

		}
	}

	public static String formatString(String value, String pattern) {
		MaskFormatter mf;
		try {
			mf = new MaskFormatter(pattern);
			mf.setValueContainsLiteralCharacters(false);
			return mf.valueToString(value);
		} catch (ParseException ex) {
			return value;
		}
	}

}
