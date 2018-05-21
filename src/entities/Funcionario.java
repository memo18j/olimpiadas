package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the funcionario database table.
 * 
 */
@Entity
@NamedQuery(name="Funcionario.findAll", query="SELECT f FROM Funcionario f")
public class Funcionario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String apellido;

	private int delegado;

	private String nombre;

	private String telefono;

	//bi-directional many-to-one association to Estadistica
	@OneToMany(mappedBy="funcionario")
	private List<Estadistica> estadisticas;

	//bi-directional many-to-one association to Delegacion
	@ManyToOne
	@JoinColumn(name="iddelegacion")
	private Delegacion delegacion;

	public Funcionario() {
	}
	public Funcionario(String apellido,int delegado,String nombre,String telefono){
		super();
		this.apellido = apellido;
		this.nombre = nombre;
		this.delegado = delegado;
		this.telefono = telefono;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getDelegado() {
		return this.delegado;
	}

	public void setDelegado(int delegado) {
		this.delegado = delegado;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Estadistica> getEstadisticas() {
		return this.estadisticas;
	}

	public void setEstadisticas(List<Estadistica> estadisticas) {
		this.estadisticas = estadisticas;
	}

	public Estadistica addEstadistica(Estadistica estadistica) {
		getEstadisticas().add(estadistica);
		estadistica.setFuncionario(this);

		return estadistica;
	}

	public Estadistica removeEstadistica(Estadistica estadistica) {
		getEstadisticas().remove(estadistica);
		estadistica.setFuncionario(null);

		return estadistica;
	}

	public Delegacion getDelegacion() {
		return this.delegacion;
	}

	public void setDelegacion(Delegacion delegacion) {
		this.delegacion = delegacion;
	}

}