package br.com.erp.cliente;

import java.awt.BorderLayout;
import java.awt.Desktop.Action;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import org.hibernate.Session;

import br.com.erp.cliente.relatorio.ClienteReport;
import br.com.erp.negocio.ClienteNegocio;
import br.com.erp.util.Comando;
import br.com.erp.util.Conexao;
import br.com.erp.widget.ButtonBarComponent;
import br.com.erp.widget.ButtonColumn;
import br.com.erp.widget.Icone;
import br.com.erp.widget.JSearchTextField;
import net.bytebuddy.matcher.ModifierMatcher.Mode;
import net.sf.jasperreports.engine.JRException;

public class ClienteListInternalFrame extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JSearchTextField textFieldSearch;

	private ClienteFormPanel clienteFormPanel;
	private JScrollPane jScrollPaneTable;
	private JPanel jPanelSuperior;

	private ClienteNegocio clienteNegocio;
	private ClienteModel clienteFiltroModel;
	private ArrayList<ClienteModel> listaDeRegistros;

	public ClienteListInternalFrame() {

		setTitle("Cadastro de Clientes ");
		setClienteFiltroModel(new ClienteModel());
		setClienteNegocio(new ClienteNegocio());

		setResizable(false);
		setClosable(true);
		setVisible(true);
		setMaximizable(true);
		setSize(1196, 800);
		setIconifiable(true);

		clienteFormPanel = new ClienteFormPanel(this);

		/*
		 * parte superior da tela
		 */
		ButtonBarComponent buttonBarComponent = new ButtonBarComponent();
		buttonBarComponent.getBtIncluir().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteModel clienteModel = new ClienteModel();
				clienteModel.setTipo("J");
				clienteFormPanel.setClienteModel(clienteModel);
				getContentPane().removeAll();
				getContentPane().add(clienteFormPanel, BorderLayout.CENTER);
				getContentPane().repaint();
				getContentPane().validate();

			}
		});
		
		buttonBarComponent.btImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new ClienteReport().gerar(getListaDeRegistros());
				} catch ( Exception e1) {
					//JOptionPane.showMessageDialog(this, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
					//JOptionPane.showMessageDialog(this, "", "ERRO", JOptionPane.ERROR_MESSAGE);
				}

			}
		});

		textFieldSearch = new JSearchTextField();
		textFieldSearch.setPreferredSize(new Dimension(400, 40));
		textFieldSearch.setIcon(Icone.novo("find-16x16.png"));
		textFieldSearch.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				getClienteFiltroModel().setNomeRazao(textFieldSearch.getText());
				acaoObterTodos();

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});

		JPanel jPanelSearch = new JPanel();
		jPanelSearch.setBorder(new TitledBorder(null, "Pesquisar", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		jPanelSearch.setLayout(new FlowLayout(FlowLayout.RIGHT));
		jPanelSearch.add(textFieldSearch);

		jPanelSuperior = new JPanel();
		jPanelSuperior.setLayout(new BorderLayout());
		jPanelSuperior.add(buttonBarComponent, BorderLayout.CENTER);
		jPanelSuperior.add(jPanelSearch, BorderLayout.SOUTH);

		/*
		 * centro da tela
		 */
		table = new JTable();

		String[] columnNames = { "id", "Nome/Razão Social", "CPF/CNPJ", "Email", "Tel", "Cel", "", "" };
		Object[][] data = {};

		DefaultTableModel model = new DefaultTableModel(data, columnNames);
		table = new JTable(model);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		table.setFillsViewportHeight(true);
		table.getColumnModel().getColumn(0).setMinWidth(0);
		table.getColumnModel().getColumn(0).setMaxWidth(0);

		table.getColumnModel().getColumn(6).setMinWidth(30);
		table.getColumnModel().getColumn(6).setMaxWidth(30);
		table.getColumnModel().getColumn(7).setMinWidth(30);
		table.getColumnModel().getColumn(7).setMaxWidth(30);

		table.setRowHeight(30);

		// setColunasDaTabela(new String[] { "id", "Nome/Razão Social", "CPF/CNPJ",
		// "Email", "Tel", "Cel", "Ação" });
		javax.swing.Action actionEdit = new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {

				JTable table = (JTable) e.getSource();
				int modelRow = Integer.valueOf(e.getActionCommand());
				String idStr = (String) ((DefaultTableModel) table.getModel()).getValueAt(modelRow, 0);
				System.out.println(idStr);
				Long id = Long.valueOf(idStr);
				ClienteModel clienteModel = getModelPorId(id);
				if (clienteModel != null) {
					clienteFormPanel.setClienteModel(clienteModel);
					getContentPane().removeAll();
					getContentPane().add(clienteFormPanel, BorderLayout.CENTER);
					clienteFormPanel.repaint();
					clienteFormPanel.validate();
					getContentPane().repaint();
					getContentPane().validate();
				}

			}
		};
		javax.swing.Action actionExcluir = new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {

				JTable table = (JTable) e.getSource();
				int modelRow = Integer.valueOf(e.getActionCommand());
				String idStr = (String) ((DefaultTableModel) table.getModel()).getValueAt(modelRow, 0);
				System.out.println(idStr);
				Long id = Long.valueOf(idStr);
				ClienteModel clienteModel = getModelPorId(id);
				if (clienteModel != null) {
					int dialogButton = JOptionPane.YES_NO_OPTION;
			        int dialogResult = JOptionPane.showConfirmDialog(null, "Deseja excluir?", "Warning", dialogButton);
			        if (dialogResult == JOptionPane.YES_OPTION) {
			            acaoExcluir(clienteModel);
			        }
				}

			}
		};
		
        
		ButtonColumn buttonColumnEditar = new ButtonColumn(table, actionEdit, 6);
		ButtonColumn buttonColumnExcluir = new ButtonColumn(table, actionExcluir, 7);

		jScrollPaneTable = new JScrollPane(table);
		setModoLista();
		acaoObterTodos();

	}

	private ClienteModel getModelPorId(Long id) {
		if (getListaDeRegistros() != null) {
			for (ClienteModel clienteModel : listaDeRegistros) {
				if (clienteModel.getId().compareTo(id) == 0) {
					return clienteModel;
				}
			}
		}
		return null;
	}

	public void setModoLista() {
		// removeAll();
		getContentPane().removeAll();
		getContentPane().add(jPanelSuperior, BorderLayout.NORTH);
		getContentPane().add(jScrollPaneTable, BorderLayout.CENTER);
		getContentPane().repaint();
		getContentPane().validate();
		// validate();
		// repaint();
	}

	public void acaoSalvar() {
	

		try {
			ClienteModel model = clienteFormPanel.getClienteModelAtualizado();
			String acao = "Inserido";
			if (model.getId() != null) {
				acao = "Alterado";
			}
			Conexao.Executar(new Comando() {

				@Override
				public void execute(Session session) throws Exception {

					if (model.getId() == null) {
						clienteNegocio.salvar(model);
					} else {
						clienteNegocio.alterar(model);

					}
				}
			});
			setModoLista();
			acaoObterTodos();
			JOptionPane.showMessageDialog(this, acao + " com sucesso!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();

		}
	}
	
	public void acaoExcluir(ClienteModel clienteModel) {
		

		try {
			
			Conexao.Executar(new Comando() {

				@Override
				public void execute(Session session) throws Exception {

					clienteNegocio.excluir(clienteModel);
				}
			});
			setModoLista();
			acaoObterTodos();
			JOptionPane.showMessageDialog(this,  "Excluído com sucesso!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();

		}
	}

	private void acaoObterTodos() {
		try {
			Conexao.Executar(new Comando() {
				@Override
				public void execute(Session session) throws Exception {

					ArrayList<ClienteModel> lista = clienteNegocio.obterTodosComFiltro(getClienteFiltroModel());
					setListaDeRegistros(lista);
					// setPagina(getPagina());
				}
			});

		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}

	public ArrayList<ClienteModel> getListaDeRegistros() {
		return listaDeRegistros;
	}

	public void setListaDeRegistros(ArrayList<ClienteModel> listaDeRegistros) {
		this.listaDeRegistros = listaDeRegistros;
		limpaTabela();
		if (listaDeRegistros != null) {
			DefaultTableModel defaultTableModel = (DefaultTableModel) table.getModel();
			for (ClienteModel clienteModel : listaDeRegistros) {
				defaultTableModel.addRow(modelToRow(clienteModel));
			}
		}
	}

	public Object[] modelToRow(ClienteModel model) {
		String id = String.valueOf(model.getId());
		String nomeRazaoSocial = model.getNomeRazao();
		String cpfCNPJ = model.getPfCPF();
		String tel= model.getPfTelefone();
		String cel =model.getPfCelular();
		
		if(model.getTipo().equals("J")) {
			cpfCNPJ = model.getPjCNPJ(); 
			tel = model.getPjREsponsavelTelefone();
			cel  = model.getPjResponsavelCelular();
		}

		Object[] row = new Object[] { id, nomeRazaoSocial, cpfCNPJ,model.getEmail(),tel  , cel, Icone.novo("btEditar.png"),
				Icone.novo("btExcluir.png") };
		return row;

	}

	public ClienteModel getClienteFiltroModel() {
		return clienteFiltroModel;
	}

	public void setClienteFiltroModel(ClienteModel clienteFiltroModel) {
		this.clienteFiltroModel = clienteFiltroModel;
	}

	public ClienteNegocio getClienteNegocio() {
		return clienteNegocio;
	}

	public void setClienteNegocio(ClienteNegocio clienteNegocio) {
		this.clienteNegocio = clienteNegocio;
	}

	private void limpaTabela() {
		DefaultTableModel defaultTableModel = (DefaultTableModel) table.getModel();
		defaultTableModel.setRowCount(0);
	}

}
