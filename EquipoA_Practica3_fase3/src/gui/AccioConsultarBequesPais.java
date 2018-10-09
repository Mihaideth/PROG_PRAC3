package gui;
import java.awt.event.*;
import javax.swing.*;
import exception.NoTrobat;
import fase2.Beca;
import fase2.LlistaBeca;

public class AccioConsultarBequesPais implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		
		LlistaBeca llistaBeca=new LlistaBeca(100);
		llistaBeca.carregarBeques();
		
		String pais = JOptionPane.showInputDialog("Diguem el pais de la beca");
		
		try{ 
			Beca[] beques = llistaBeca.llistaBequesPais(pais);
			for (int i = 0; i < beques.length; i++) {
				System.out.println(beques[i].toString());
			}
		
		} catch (NoTrobat e) {
			System.out.println("No s'ha trobat una beca");
		}
	}
		
	

}
