package br.com.erp.widget;

import java.net.URL;

import javax.swing.ImageIcon;

public class Icone {

	public static String dirImages = "/br/com/erp/images/";

	public Icone() {
	}

	public static ImageIcon novo(String nome) {
		ImageIcon retorno = null;
		try {
			URL url = Icone.class.getResource(dirImages + nome);

			if (url == null)
				System.out.println("Não foi possivel carregar a imagem: '" + nome + "'");
			else
				retorno = new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage(url));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return retorno;
	}

}