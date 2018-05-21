package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the escenario database table.
 * 
 */
@Entity
@NamedQuery(name="Escenario.findAll", query="SELECT e FROM Escenario e")
public class Escenario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int nombre;

	//bi-directional many-to-one association to Planilla
	@OneToMany(mappedBy="escenario")
	private List<Planilla> planillas;

	public Escenario() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNombre() {
		return this.nombre;
	}

	public void setNombre(int nombre) {
		this.nombre = nombre;
	}

	public List<Planilla> getPlanillas() {
		return this.planillas;
	}

	public void setPlanillas(List<Planilla> planillas) {
		this.planillas = planillas;
	}

	public Planilla addPlanilla(Planilla planilla) {
		getPlanillas().add(planilla);
		planilla.setEscenario(this);

		return planilla;
	}

	public Planilla removePlanilla(Planilla planilla) {
		getPlanillas().remove(planilla);
		planilla.setEscenario(null);

		return planilla;
	}

}