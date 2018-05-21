package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the planilla database table.
 * 
 */
@Entity
@NamedQuery(name="Planilla.findAll", query="SELECT p FROM Planilla p")
public class Planilla implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Lob
	private String descripcion;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private int iddelegacionA;

	private int iddelegacionB;

	private int idgrupo;

	//bi-directional many-to-one association to Estadistica
	@OneToMany(mappedBy="planilla")
	private List<Estadistica> estadisticas;

	//bi-directional many-to-one association to Escenario
	@ManyToOne
	@JoinColumn(name="idescenario")
	private Escenario escenario;

	//bi-directional many-to-one association to Estadistica
	@ManyToOne
	@JoinColumn(name="idestadistica")
	private Estadistica estadistica;

	public Planilla() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getIddelegacionA() {
		return this.iddelegacionA;
	}

	public void setIddelegacionA(int iddelegacionA) {
		this.iddelegacionA = iddelegacionA;
	}

	public int getIddelegacionB() {
		return this.iddelegacionB;
	}

	public void setIddelegacionB(int iddelegacionB) {
		this.iddelegacionB = iddelegacionB;
	}

	public int getIdgrupo() {
		return this.idgrupo;
	}

	public void setIdgrupo(int idgrupo) {
		this.idgrupo = idgrupo;
	}

	public List<Estadistica> getEstadisticas() {
		return this.estadisticas;
	}

	public void setEstadisticas(List<Estadistica> estadisticas) {
		this.estadisticas = estadisticas;
	}

	public Estadistica addEstadistica(Estadistica estadistica) {
		getEstadisticas().add(estadistica);
		estadistica.setPlanilla(this);

		return estadistica;
	}

	public Estadistica removeEstadistica(Estadistica estadistica) {
		getEstadisticas().remove(estadistica);
		estadistica.setPlanilla(null);

		return estadistica;
	}

	public Escenario getEscenario() {
		return this.escenario;
	}

	public void setEscenario(Escenario escenario) {
		this.escenario = escenario;
	}

	public Estadistica getEstadistica() {
		return this.estadistica;
	}

	public void setEstadistica(Estadistica estadistica) {
		this.estadistica = estadistica;
	}

}