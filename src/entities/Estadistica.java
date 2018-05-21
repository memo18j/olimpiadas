package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the estadistica database table.
 * 
 */
@Entity
@NamedQuery(name="Estadistica.findAll", query="SELECT e FROM Estadistica e")
public class Estadistica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int amarilla;

	private int punto;

	private int roja;

	//bi-directional many-to-one association to Funcionario
	@ManyToOne
	@JoinColumn(name="idfuncionario")
	private Funcionario funcionario;

	//bi-directional many-to-one association to Planilla
	@ManyToOne
	@JoinColumn(name="idplanilla")
	private Planilla planilla;

	//bi-directional many-to-one association to Planilla
	@OneToMany(mappedBy="estadistica")
	private List<Planilla> planillas;

	public Estadistica() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAmarilla() {
		return this.amarilla;
	}

	public void setAmarilla(int amarilla) {
		this.amarilla = amarilla;
	}

	public int getPunto() {
		return this.punto;
	}

	public void setPunto(int punto) {
		this.punto = punto;
	}

	public int getRoja() {
		return this.roja;
	}

	public void setRoja(int roja) {
		this.roja = roja;
	}

	public Funcionario getFuncionario() {
		return this.funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Planilla getPlanilla() {
		return this.planilla;
	}

	public void setPlanilla(Planilla planilla) {
		this.planilla = planilla;
	}

	public List<Planilla> getPlanillas() {
		return this.planillas;
	}

	public void setPlanillas(List<Planilla> planillas) {
		this.planillas = planillas;
	}

	public Planilla addPlanilla(Planilla planilla) {
		getPlanillas().add(planilla);
		planilla.setEstadistica(this);

		return planilla;
	}

	public Planilla removePlanilla(Planilla planilla) {
		getPlanillas().remove(planilla);
		planilla.setEstadistica(null);

		return planilla;
	}

}