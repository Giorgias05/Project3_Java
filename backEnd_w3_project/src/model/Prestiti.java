package model;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;

@Entity
@Table(name="prestiti")
@NamedQuery(name = "Prestiti.findByTessera", query = "SELECT p FROM Prestiti p WHERE p.utente.tessera = :tessera AND p.data_restituzione_effettiva = null ")
@NamedQuery(name = "Prestiti.prestitiScaduti", query = "SELECT p FROM Prestiti p WHERE p.data_restituzione_effettiva = null OR p.data_restituzione_effettiva > p.data_restituzione_prevista")
public class Prestiti  implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private Utente utente;
	@ManyToOne
	private Archive archivio;
	@Column(nullable = false)
	private LocalDate data_inizio_prestito;
	@Column(nullable = false)
	private LocalDate data_restituzione_prevista;
	private LocalDate data_restituzione_effettiva;
	
	
	public Prestiti(Utente utente, Archive archivio, LocalDate data_inizio_prestito, LocalDate data_restituzione_effettiva) {
		super();
		this.utente = utente;
		this.archivio = archivio;
		this.data_inizio_prestito = data_inizio_prestito;
		this.setData_inizio_prestito(data_inizio_prestito);
		this.data_restituzione_effettiva = data_restituzione_effettiva;
	}

	public Prestiti() {
		super();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Utente getUtente() {
		return utente;
	}
	public void setUtente(Utente utente) {
		this.utente = utente;
	}
	public Archive getArchivio() {
		return archivio;
	}
	public void setArchivio(Archive archivio) {
		this.archivio = archivio;
	}
	public LocalDate getData_inizio_prestito() {
		return data_inizio_prestito;
	}
	public void setData_inizio_prestito(LocalDate data_inizio_prestito) {
		this.data_inizio_prestito = data_inizio_prestito;
		this.setData_restituzione_prevista(data_inizio_prestito.plusDays(30));
	}
	public LocalDate getData_restituzione_prevista() {
		return data_restituzione_prevista;
	}
	public void setData_restituzione_prevista(LocalDate data_restituzione_prevista) {
		this.data_restituzione_prevista = data_restituzione_prevista;
	}
	public LocalDate getData_restituzione_effettiva() {
		return data_restituzione_effettiva;
	}
	public void setData_restituzione_effettiva(LocalDate data_restituzione_effettiva) {
		this.data_restituzione_effettiva = data_restituzione_effettiva;
	}
	
	@Override
	public String toString() {
		return "Prestiti [id=" + id + ", utente=" + utente + ", archivio=" + archivio + ", data_inizio_prestito="
				+ data_inizio_prestito + ", data_restituzione_prevista=" + data_restituzione_prevista
				+ ", data_inizio_restituzione_effettiva=" + data_restituzione_effettiva + "]";
	}
}
