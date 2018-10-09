package gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import fase2.LlistaBeca;
	
public class Finestra extends JFrame {
	
		private static final long serialVersionUID = 1L;
		private JLabel etiqueta=new JLabel("Menu Beques");
		private JButton[] botons=new JButton[4];
		
		private JPanel panell=new JPanel(); 
		private JPanel entrada=new JPanel();
		// Constructor sense paràmetres,
		// crida a un altre constructor on cal el títol de la finestra com a paràmetre.
		public Finestra(LlistaBeca llistaBeca) {
			super("Finestra");
			
			// Obtenim la referència a l'objecte "contenidor" de la finestra.
			Container container = getContentPane();
			
			// Forcem la disposició dels objectes que contindrà el contenidor
			// de la finestra principal al tipus "BorderLayout"
			container.setLayout(new BorderLayout());
			
			//AccioDelTextField2 accio2=new AccioDelTextField2(this);
			
			entrada.setLayout(new FlowLayout());
			//dades.addActionListener(accio2);
			container.add(entrada, BorderLayout.CENTER);
			
			
			panell.setLayout(new GridLayout(4,1));
			//AccioDelBoto accio= new AccioDelBoto();
	
			String[] text={"Consultar informacio beca a partir del codi","Consultar les beques disponibles a un cert pais","Consultar la quantitat total de diners de la beca ERASMUSPlus","Consultar beques segons idiomes pel cas de ERASMUPlus i ISEP"};
			for (int i=0; i<4;i++){
				botons[i]=new JButton(text[i]);
				botons[i].setBackground(Color.WHITE);
				panell.add(botons[i]);
			}
			
			
			
			AccioConsultarBeca accio=new AccioConsultarBeca();
			botons[0].addActionListener(accio);
			
			AccioConsultarBequesPais accio2 = new AccioConsultarBequesPais();
			botons[1].addActionListener(accio2);
			
			AccioConsultarDinersErasmusPlus accio3=new AccioConsultarDinersErasmusPlus();
			botons[2].addActionListener(accio3);
			
			AccioGetNumBequesAmbIdioma accio4=new AccioGetNumBequesAmbIdioma();
			botons[3].addActionListener(accio4);
			
			container.add(panell, BorderLayout.CENTER);
			container.add(etiqueta, BorderLayout.NORTH);
			
			// Necessari per alliberar la memòria quan tanquem la finestra.
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			// Forcem les mides de l'objecte contenidor, es a dir, la finestra.
			setSize(600,600);
			// Fem la finestra visible.
			setVisible(true);
			
			}


}
			
			
			
			
	

		
	

			


