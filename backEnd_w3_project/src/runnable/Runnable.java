package runnable;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;

import connector.DbConnection;
import enum_.enum_frequency;
import enum_.enum_genere;
import model.Archive;
import model.Book;
import model.Catalogue;
import model.Magazine;
import model.Prestiti;
import model.Utente;

public class Runnable {
	
	public static void main(String[] args) {
		
		try {
		
			// CHE CERCA UN ELEMENTOPER ID
			Catalogue.getById(4l);
		
			//CERCA UN ELEMENTO PER ANNO
			List<Archive> archives = Catalogue.getByYear(2023);
			System.out.println("\nArchivi pubblicati nel 2023: " + archives);

			 // CERCA UN ELEMENTO PER AUTORE
			List<Archive> ArchiveByAuthor = Catalogue.getByAuthor("bebo");
			System.out.println("\nLibri cercati per autore: " + ArchiveByAuthor);
			
			//CERCA UN ELEMENTO PER TITOLO
			
			List<Archive> archiveByTitle = Catalogue.getByTitle("funz");
			System.out.println("\nLibri cercati per titolo: " + archiveByTitle);
			
			// CERCA PRESTITO SCADUTO NON RESTITUITO
			List<Prestiti> PrestitiScaduti = Catalogue.PrestitiScaduti();
			System.out.println("\n"+PrestitiScaduti);
			
			// CERCA PRESTITO NON SCADUTO PER N. TESSERA
			List<Prestiti> Prestiticercati = Catalogue.getPrestitoById(10l);
			System.out.println(Prestiticercati);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
