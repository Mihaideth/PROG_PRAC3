
package gui;
import java.awt.event.*;
import javax.swing.*;
import exception.NoTrobat;
import fase2.LlistaBeca;

public class AccioGetNumBequesAmbIdioma implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		LlistaBeca llistaBeca=new LlistaBeca(100);
		llistaBeca.carregarBeques();
		
		String idioma = JOptionPane.showInputDialog("Diguem l'idioma de la beca");
		
		try{
			int[] beques = llistaBeca.consultarBequesAmbIdioma(idioma);
			System.out.println("Els codis de les beques amb aquest idioma són: ");
			for (int i = 0; i < beques.length; i++)
				System.out.println(beques[i]);
		}catch (NoTrobat e){
			System.out.println("Beca no trobada");
		}
	}

}
