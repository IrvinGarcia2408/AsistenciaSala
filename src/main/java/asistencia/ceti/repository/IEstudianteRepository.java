package asistencia.ceti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import asistencia.ceti.model.Estudiante;

//OCUPAR METODOS DE JPA PARA REALIZAR EL CRUD
@Repository
public interface IEstudianteRepository extends JpaRepository<Estudiante, Integer>{
	
}
