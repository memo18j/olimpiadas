package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the delegacion database table.
 * 
 */
@Entity
@NamedQuery(name="Delegacion.findAll", query="SELECT d FROM Delegacion d")
public class Delegacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Lob
	private String descripcion;

	//bi-directional many-to-one association to Funcionario
	@OneToMany(mappedBy="delegacion")
	private List<Funcionario> funcionarios;

	//bi-directional many-to-one association to Grupo
	@OneToMany(mappedBy="delegacion")
	private List<Grupo> grupos;

	public Delegacion() {
	}
	
	public Delegacion(String nombre) {
		super();
		this.descripcion = nombre;
	}
	public Delegacion(int id,String nombre) {
		super();
		this.id = id;
		this.descripcion = nombre;
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

	public List<Funcionario> getFuncionarios() {
		return this.funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public Funcionario addFuncionario(Funcionario funcionario) {
		getFuncionarios().add(funcionario);
		funcionario.setDelegacion(this);

		return funcionario;
	}

	public Funcionario removeFuncionario(Funcionario funcionario) {
		getFuncionarios().remove(funcionario);
		funcionario.setDelegacion(null);

		return funcionario;
	}

	public List<Grupo> getGrupos() {
		return this.grupos;
	}

	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}

	public Grupo addGrupo(Grupo grupo) {
		getGrupos().add(grupo);
		grupo.setDelegacion(this);

		return grupo;
	}

	public Grupo removeGrupo(Grupo grupo) {
		getGrupos().remove(grupo);
		grupo.setDelegacion(null);

		return grupo;
	}

}