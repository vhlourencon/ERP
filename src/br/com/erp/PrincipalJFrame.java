package br.com.erp;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.plaf.InsetsUIResource;

import br.com.erp.cliente.ClienteListInternalFrame;

public class PrincipalJFrame extends JFrame {

	private JDesktopPane jDesktopPane;

	public PrincipalJFrame() {

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(screenSize);
		setLocation(0, 0);
		setTitle("ERP");

		jDesktopPane = new JDesktopPane();
		setContentPane(jDesktopPane);
	}

	private void criaMenu() {

		JMenuBar jMenuBar = new JMenuBar();

		JMenu jMenuCadastro = new JMenu("Cadastro");
		jMenuBar.add(jMenuCadastro);

		JMenuItem jMenuItemCadastroClientes = new JMenuItem("Clientes");
		jMenuCadastro.add(jMenuItemCadastroClientes);
		jMenuItemCadastroClientes.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					ClienteListInternalFrame clienteListPanel = new ClienteListInternalFrame();
					clienteListPanel.setVisible(true);
					jDesktopPane.add(clienteListPanel, 0);
					clienteListPanel.setSelected(true);

				} catch (Exception excecao) {
					excecao.printStackTrace();
					JOptionPane.showInternalMessageDialog(jDesktopPane,
							excecao.getMessage() + " " + excecao.getLocalizedMessage());

				}

			}
		});

		JSeparator jSeparatorCadastro = new JSeparator();
		jMenuCadastro.add(jSeparatorCadastro);

		JMenuItem jMenuItemCadastroSair = new JMenuItem("Sair");
		jMenuCadastro.add(jMenuItemCadastroSair);
		jMenuItemCadastroSair.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				System.exit(0);

			}
		});

		setJMenuBar(jMenuBar);

	}

	public static void main(String[] args) throws Exception {

		final PrincipalJFrame principalDesktop = new PrincipalJFrame();
		principalDesktop.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		principalDesktop.setExtendedState(MAXIMIZED_BOTH);
		principalDesktop.criaMenu();
		principalDesktop.setVisible(true);

		principalDesktop.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				principalDesktop.setVisible(false);
				principalDesktop.dispose();

				System.exit(0);
			}
		});

		UIManager.put("Table.alternateRowColor", Color.LIGHT_GRAY);
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())

			{
System.out.println(info.getName());
				if ("Windows Classic".equals(info.getName())) {

					UIManager.setLookAndFeel(info.getClassName());
					//UIManager.put("FormattedTextField.margins", "FormattedTextField.contentMargins");

					//UIManager.put("TextField.contentMargins", new InsetsUIResource(0, 0, 0, 0));
					//UIManager.put("TextField.minimumSize", new Dimension(10, 40));

					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		principalDesktop.setExtendedState(MAXIMIZED_BOTH);
		SwingUtilities.updateComponentTreeUI(principalDesktop);

	}

}