import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Studente {
 int matricola;
 String cognome;
 String nome;
 List<Esame> esami = new ArrayList<Esame>();
public void print() {
	
	System.out.println("La matricola dello studente è: "+ this.matricola);
	System.out.println("Il cognome dello studente è: "+ this.cognome);
	System.out.println("Il nome dello studente è: "+ this.nome);
	System.out.println("Esami sostenuti:");
	Iterator<Esame> it=this.esami.iterator();
	Esame e = null;
	while(it.hasNext()) {
		e=it.next();
		StampaThread t = new  StampaThread(e);
		t.start();
		
	}
	
}
}
