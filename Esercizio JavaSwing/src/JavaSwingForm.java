import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JavaSwingForm extends JFrame {
private static final String HTMLtext = null;


public static void main(String[] args) {
	JavaSwingForm paolo = new JavaSwingForm();
	
}
public  JavaSwingForm() {
	initialize();
}


public void initialize() {
	JFrame f=new JFrame();
	
	JLabel l=new JLabel("Matricola: ");
	JLabel l1=new JLabel("Nome: ");
	JLabel l2=new JLabel("Cognome: ");
	JTextField t=new JTextField(10);
	JTextField t1=new JTextField(10);
	JTextField t2=new JTextField(10);
	String[][] dati= new String[5][3] ;
	String[] colonne= new String[] {"codice", "descrizione", "voto"};
	JTable table=new JTable(dati, colonne);
	table.setBounds(30, 40, 200, 300);
	JButton b=new JButton("Submit");
	b.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Studente s=new Studente();
			s.matricola=(Integer.parseInt(t.getText()));
			s.nome=(t1.getText());
			s.cognome=(t2.getText());
			int i=0;
			while(i<table.getRowCount()) {
				Esame ex=new Esame();
				int j=0;
				while(j<table.getColumnCount()) {
					ex.codice=Integer.parseInt((String) table.getValueAt(i, j));
					j++;
					ex.descrizione=(String) table.getValueAt(i, j);
					j++;
					ex.voto=Integer.parseInt((String) table.getValueAt(i, j));
					j++;
				}
				s.esami.add(ex);
				i++;
			}
			s.print();
		}
	});
	JButton b1=new JButton("Clear");
	b1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			t.setText("");
			t1.setText("");
			t2.setText("");
			String[][] dati2= new String[5][3] ;
		    table.setModel(new DefaultTableModel(dati2 ,colonne));
		    
		}
	});
	
	Box line1=Box.createHorizontalBox();
	line1.add(Box.createHorizontalGlue());
	line1.add(l);
	line1.add(t);
	
	Box line2=Box.createHorizontalBox();
	line2.add(Box.createHorizontalGlue());
	line2.add(l1);
	line2.add(t1);
	
	Box line3=Box.createHorizontalBox();
	line3.add(Box.createHorizontalGlue());
	line3.add(l2);
	line3.add(t2);
	
	Box line4=Box.createHorizontalBox();
	line4.add(Box.createHorizontalGlue());
	line4.add(b);
	line4.add(b1);
	
	Box bx=Box.createVerticalBox();
	bx.add(Box.createVerticalGlue());
	bx.add(line1);
	bx.add(line2);
	bx.add(line3);
	
	Box bx1=Box.createVerticalBox();
	bx1.add(Box.createVerticalGlue());
	bx1.add(bx);
	bx1.add(new JScrollPane(table));
	bx1.add(line4);		

	JPanel p=new JPanel();
	p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
	//p.setAlignmentX(Component.CENTER_ALIGNMENT);
	p.add(bx1);
	f.add(p);
	f.setTitle("Christian è bello");
	f.setSize(400,300);
	f.setResizable(false);
    f.setVisible(true);


}
}
