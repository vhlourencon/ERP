package br.com.erp.widget;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;


public class ButtonBarComponent extends JPanel {

	private static final long serialVersionUID = 1L;
	public JButton btIncluir = new JButton(Icone.novo("btNovo.png"));
	public JButton btImprimir = new JButton(Icone.novo("btImprime.png"));

	public ButtonBarComponent() {
		setLayout(new FlowLayout(FlowLayout.LEFT));

		btIncluir.setText("Incluir");
		btIncluir.setToolTipText("Incluir");
		add(btIncluir);

		btImprimir.setText("Imprimir");
		btImprimir.setToolTipText("Imprimir ");
		add(btImprimir);

	}


	public void liberarComponentes(boolean liberar) {

		try {

			btIncluir.setEnabled(liberar);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public JButton getBtIncluir() {
		return btIncluir;
	}

	public void setBtIncluir(JButton btIncluir) {
		this.btIncluir = btIncluir;
	}

}
