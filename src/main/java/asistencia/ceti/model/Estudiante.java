package asistencia.ceti.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="estudiantes")
public class Estudiante {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String estMatricula;
	private String estNombre;
	private Integer estLicenciatura;
	
	public Estudiante() {
		super();
	}

	public Estudiante(Integer id, String estMatricula, String estNombre, Integer estLicenciatura) {
		super();
		this.id = id;
		this.estMatricula = estMatricula;
		this.estNombre = estNombre;
		this.estLicenciatura = estLicenciatura;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEstMatricula() {
		return estMatricula;
	}

	public void setEstMatricula(String estMatricula) {
		this.estMatricula = estMatricula;
	}

	public String getEstNombre() {
		return estNombre;
	}

	public void setEstNombre(String estNombre) {
		this.estNombre = estNombre;
	}

	public Integer getEstLicenciatura() {
		return estLicenciatura;
	}

	public void setEstLicenciatura(Integer estLicenciatura) {
		this.estLicenciatura = estLicenciatura;
	}

	@Override
	public String toString() {
		return "Estudiante [id=" + id + ", estMatricula=" + estMatricula + ", estNombre=" + estNombre
				+ ", estLicenciatura=" + estLicenciatura + "]";
	}
	
	
}
