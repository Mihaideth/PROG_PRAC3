package gui;
import java.awt.event.*;
import javax.swing.*;
import exception.NoTrobat;
import fase2.Beca;
import fase2.LlistaBeca;


public class AccioConsultarBeca implements ActionListener{

	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		LlistaBeca llistaBeca=new LlistaBeca(100);
		llistaBeca.carregarBeques();
		boolean comprovat=true;
		int codi=0;
			try {
				String s = JOptionPane.showInputDialog("Diguem el codi de la teva beca");
				codi = Integer.parseInt(s);
			} catch (NumberFormatException e) {
				System.out.print("Error en el format del codi\n");
				comprovat=false;
			}
		
		if(comprovat){
			try {
				Beca beca = llistaBeca.consultarBeca(codi);
			System.out.println(beca);
		} catch (NoTrobat e) {
			System.out.println("No s'ha trobat una beca");
		}
		}
			
	}

}
