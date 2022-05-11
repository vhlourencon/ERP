package br.com.erp.cliente;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.jhlabs.composite.BurnComposite;

import br.com.erp.enums.TipoLogradouro;
import br.com.erp.widget.Icone;

public class ClienteFormPanel extends JPanel {

	private ClienteListInternalFrame clienteListPanel;

	private ClienteFormPfPanel clienteFormPfPanel;
	private ClienteFormPjPanel clienteFormPjPanel;
	private ClienteFormEnderecoPanel clienteFormEnderecoPanel;

	private ClienteModel clienteModel;

	private JPanel jPanelCenter;

	private JRadioButton radioButtonPessoaJuridica;

	private JRadioButton radioButtonPessoaFisica;

	public ClienteFormPanel(ClienteListInternalFrame clienteListPanel) {
		this.clienteListPanel = clienteListPanel;

		clienteFormPfPanel = new ClienteFormPfPanel();
		clienteFormPjPanel = new ClienteFormPjPanel();
		clienteFormEnderecoPanel = new ClienteFormEnderecoPanel();

		JLabel lblNewLabel = new JLabel("Tipo Pessoa:");
		lblNewLabel.setBounds(5, 5, 191, 14);
		lblNewLabel.setAlignmentX(Component.RIGHT_ALIGNMENT);

		JPanel jPanelLabelTipoPessoa = new JPanel();
		jPanelLabelTipoPessoa.setLayout(null);
		jPanelLabelTipoPessoa.add(lblNewLabel);
		jPanelLabelTipoPessoa.setPreferredSize(new Dimension(0, 50));

		radioButtonPessoaJuridica = new JRadioButton("Pessoa Jurídica");
		radioButtonPessoaJuridica.setBounds(6, 26, 127, 23);
		jPanelLabelTipoPessoa.add(radioButtonPessoaJuridica);

		radioButtonPessoaJuridica.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				if (getClienteModel() != null) {
					if (radioButtonPessoaJuridica.isSelected()) {
						getClienteModel().setTipo("J");
					} else {
						getClienteModel().setTipo("F");
					}
					setClienteModel(getClienteModel());
				}

			}
		});

		radioButtonPessoaFisica = new JRadioButton("Pessoa Física");
		radioButtonPessoaFisica.setBounds(135, 26, 140, 23);

		ButtonGroup buttonGroupTipoPessoa = new ButtonGroup();
		buttonGroupTipoPessoa.add(radioButtonPessoaJuridica);
		buttonGroupTipoPessoa.add(radioButtonPessoaFisica);
		radioButtonPessoaJuridica.setSelected(true);

		jPanelLabelTipoPessoa.add(radioButtonPessoaFisica);

		jPanelCenter = new JPanel();
		jPanelCenter.setLayout(new BoxLayout(jPanelCenter, BoxLayout.Y_AXIS));

		jPanelCenter.setPreferredSize(new Dimension(800, 1000));

		/*
		 * parte inferior
		 */

		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		JButton jButtonSalvar = new JButton("Salvar", Icone.novo("clAgdFin.png"));
		jButtonSalvar.setPreferredSize(new Dimension(120, 40));
		jButtonSalvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				clienteListPanel.acaoSalvar();

			}
		});
		panel.add(jButtonSalvar);

		JButton jButtonCancelar = new JButton("Cancelar", Icone.novo("btCancelar.png"));
		jButtonCancelar.setPreferredSize(new Dimension(120, 40));
		jButtonCancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				clienteListPanel.setModoLista();
			}
		});
		panel.add(jButtonCancelar);

		setLayout(new BorderLayout(0, 0));
		add(panel, BorderLayout.SOUTH);
		add(jPanelCenter, BorderLayout.CENTER);

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel_1, BorderLayout.NORTH);
		add(jPanelLabelTipoPessoa, BorderLayout.NORTH);
	}

	public ClienteModel getClienteModelAtualizado() {
		if (clienteModel.getTipo().equals("J")) {
			clienteModel = clienteFormPjPanel.getClienteModel();
		}
		if (clienteModel.getTipo().equals("F")) {
			clienteModel = clienteFormPfPanel.getClienteModel();
		}
		clienteModel = clienteFormEnderecoPanel.getClienteModel();
		
		return clienteModel;
	}

	private ClienteModel getClienteModel() {
		return clienteModel;
	}

	public void setClienteModel(ClienteModel clienteModel) {
		this.clienteModel = clienteModel;
		clienteFormEnderecoPanel.setClienteModel(clienteModel);
		clienteFormPfPanel.setClienteModel(clienteModel);
		clienteFormPjPanel.setClienteModel(clienteModel);

		if (clienteModel.getTipo() != null) {
			jPanelCenter.removeAll();
			if (clienteModel.getTipo().equals("J")) {
				if (radioButtonPessoaJuridica.isSelected() == false) {
					radioButtonPessoaJuridica.setSelected(true);
				}
				jPanelCenter.add(clienteFormPjPanel);
				// clienteFormPjPanel.repaint();

			}
			if (clienteModel.getTipo().equals("F")) {
				if (radioButtonPessoaFisica.isSelected() == false) {
					radioButtonPessoaFisica.setSelected(true);
				}
				jPanelCenter.add(clienteFormPfPanel);
				// clienteFormPfPanel.repaint();
			}
			jPanelCenter.add(clienteFormEnderecoPanel);
			jPanelCenter.repaint();
			validate();
		}
	}

}
