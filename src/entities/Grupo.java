package entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the grupo database table.
 * 
 */
@Entity
@NamedQuery(name="Grupo.findAll", query="SELECT g FROM Grupo g")
public class Grupo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String letra;

	//bi-directional many-to-one association to Delegacion
	@ManyToOne
	@JoinColumn(name="iddelegacion")
	private Delegacion delegacion;

	//bi-directional many-to-one association to Deporte
	@ManyToOne
	@JoinColumn(name="iddeporte")
	private Deporte deporte;

	public Grupo() {
	}
	public Grupo(String letra){
		super();
		this.letra = letra;
	}
	public Grupo(int id,String letra){
		super();
		this.id = id;
		this.letra = letra;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLetra() {
		return this.letra;
	}

	public void setLetra(String letra) {
		this.letra = letra;
	}

	public Delegacion getDelegacion() {
		return this.delegacion;
	}

	public void setDelegacion(Delegacion delegacion) {
		this.delegacion = delegacion;
	}

	public Deporte getDeporte() {
		return this.deporte;
	}

	public void setDeporte(Deporte deporte) {
		this.deporte = deporte;
	}

}