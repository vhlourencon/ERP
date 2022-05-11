package br.com.erp.cliente;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JTextPane;
import javax.swing.text.MaskFormatter;

import org.eclipse.jdt.internal.compiler.ast.Clinit;

import br.com.erp.enums.TipoLogradouro;

public class ClienteFormEnderecoPanel extends JPanel {
	private JFormattedTextField textFieldCep;
	private JTextField textFieldCidade;
	private JTextField textFieldComplemento;
	private JTextField textFieldNumero;
	private JTextField textFieldBairro;
	private JTextField textFieldLogradouro;

	private ClienteModel clienteModel;
	private JTextArea textPane;
	private JComboBox<TipoLogradouro> comboBoxTipoLogradouro;
	private JComboBox<String> comboBoxUF;

	public ClienteFormEnderecoPanel() {
		setLayout(null);

		JLabel labelCEP = new JLabel("CEP:");
		labelCEP.setBounds(10, 11, 46, 14);
		add(labelCEP);

		try {
			textFieldCep = new JFormattedTextField(new MaskFormatter("#####-###"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		textFieldCep.setBounds(10, 30, 106, 20);
		add(textFieldCep);
		textFieldCep.setColumns(10);

		JLabel labelCidade = new JLabel("Cidade:");
		labelCidade.setBounds(126, 11, 168, 14);
		add(labelCidade);

		textFieldCidade = new JTextField();
		textFieldCidade.setColumns(10);
		textFieldCidade.setBounds(126, 30, 377, 20);
		add(textFieldCidade);

		JLabel labelUF = new JLabel("UF:");
		labelUF.setBounds(513, 11, 81, 14);
		add(labelUF);

		comboBoxUF = new JComboBox<String>();
		comboBoxUF.setBounds(513, 30, 81, 20);
		comboBoxUF.setModel(new javax.swing.DefaultComboBoxModel<String>(
				new String[] { "", "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA",
						"PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RS", "SC", "SE", "SP", "TO" }));
		add(comboBoxUF);

		JLabel labelComplemento = new JLabel("Complemento:");
		labelComplemento.setBounds(10, 111, 315, 14);
		add(labelComplemento);

		textFieldComplemento = new JTextField();
		textFieldComplemento.setColumns(10);
		textFieldComplemento.setBounds(10, 130, 377, 20);
		add(textFieldComplemento);

		JLabel lblTipoLogradouro = new JLabel("Tipo Logradouro:");
		lblTipoLogradouro.setBounds(10, 61, 106, 14);
		add(lblTipoLogradouro);

		comboBoxTipoLogradouro = new JComboBox<TipoLogradouro>();
		comboBoxTipoLogradouro.setBounds(10, 80, 106, 20);
		comboBoxTipoLogradouro.setModel(new DefaultComboBoxModel<>(TipoLogradouro.values()));
		add(comboBoxTipoLogradouro);

		JLabel labelNumero = new JLabel("Nº:");
		labelNumero.setBounds(513, 61, 81, 14);
		add(labelNumero);

		textFieldNumero = new JTextField();
		textFieldNumero.setColumns(10);
		textFieldNumero.setBounds(513, 80, 81, 20);
		add(textFieldNumero);

		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(397, 111, 168, 14);
		add(lblBairro);

		textFieldBairro = new JTextField();
		textFieldBairro.setColumns(10);
		textFieldBairro.setBounds(397, 130, 197, 20);
		add(textFieldBairro);

		textFieldLogradouro = new JTextField();
		textFieldLogradouro.setColumns(10);
		textFieldLogradouro.setBounds(126, 80, 377, 20);
		add(textFieldLogradouro);

		JLabel labelLogradouro_1 = new JLabel("Logradouro:");
		labelLogradouro_1.setBounds(126, 61, 315, 14);
		add(labelLogradouro_1);

		JLabel lblObservao = new JLabel("Observação:");
		lblObservao.setBounds(10, 161, 95, 14);
		add(lblObservao);

		textPane = new JTextArea();
		textPane.setBounds(10, 180, 584, 90);
		add(textPane);
		setPreferredSize(new Dimension(604, 290));

	}

	public ClienteModel getClienteModel() {
		if (clienteModel != null) {
			clienteModel.setEndCEP(textFieldCep.getText());
			clienteModel.setEndBairro(textFieldBairro.getText());
			clienteModel.setEndCidade(textFieldCidade.getText());
			clienteModel.setEndComplemento(textFieldComplemento.getText());
			clienteModel.setEndLogradouro(textFieldLogradouro.getText());
			clienteModel.setEndNumero(textFieldNumero.getText());
			clienteModel.setEndUF(null);
			if (comboBoxUF.getSelectedItem() != null) {
				clienteModel.setEndUF(comboBoxUF.getSelectedItem().toString());
			}

			TipoLogradouro tipoLogradouro = (TipoLogradouro) comboBoxTipoLogradouro.getSelectedItem();
			clienteModel.setEndTipoLogradouro(null);
			if (tipoLogradouro != null) {
				clienteModel.setEndTipoLogradouro(tipoLogradouro.getSigla());
			}
			clienteModel.setObservacao(textPane.getText());

		}

		return clienteModel;
	}

	public void setClienteModel(ClienteModel clienteModel) {
		this.clienteModel = clienteModel;

		textFieldCep.setText("");
		textFieldCidade.setText("");
		textFieldLogradouro.setText("");
		textFieldNumero.setText("");
		textFieldComplemento.setText("");
		textFieldBairro.setText("");
		textPane.setText("");
		comboBoxUF.setSelectedItem(null);
		comboBoxTipoLogradouro.setSelectedItem(null);
		if (clienteModel != null) {
			comboBoxUF.setSelectedItem(clienteModel.getEndUF());
			if (clienteModel.getEndTipoLogradouro() != null) {
				comboBoxTipoLogradouro
						.setSelectedItem(TipoLogradouro.geTipoLogradouro(clienteModel.getEndTipoLogradouro()));
			}

			textFieldCep.setText(clienteModel.getEndCEP());
			textFieldCidade.setText(clienteModel.getEndCidade());
			textFieldLogradouro.setText(clienteModel.getEndLogradouro());
			textFieldNumero.setText(clienteModel.getEndNumero());
			textFieldComplemento.setText(clienteModel.getEndComplemento());
			textFieldBairro.setText(clienteModel.getEndBairro());
			textPane.setText(clienteModel.getObservacao());
		}

	}

}
