package asistencia.ceti.controller;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import asistencia.ceti.model.Estudiante;
import asistencia.ceti.repository.IEstudianteRepository;

//Anotacion para que la clase sea reconocida como controlador
@Controller
@RequestMapping("/estudiantes")//DEFINE UN PATH AL CUAL SE APUNTA PARA LA URL Y ACCEDA AL CONRTROLADOR http://localhost:8080/estudiantes
public class EstudianteController {
	
	//OBJETO POR EL CUAL SE TENDRA ACCESO A LOS METODOS PARA REALIZAR EL CRUD
	@Autowired //SE INYECTA Y NO ES NECESARIO INSTANCIAR
	private IEstudianteRepository estudianteRepository;
	
	
	//
	private final Logger logg = org.slf4j.LoggerFactory.getLogger(Estudiante.class);
	
	//METODO PRINCIPAL QUE OSTRARA LOS ESTUDIANTES
	//QUE TIPO DE PETICION RESPONDERÁ
	@GetMapping("")
	public String home(Model model) {
		//INDICAR QUE LO QUE HAY EN BD SE MUESTRE
		//A TRAVES DE REPOSITORY SE TRAEN TODOS LOS VALORES DE ESTUDIANTES Y SE GUARDAN EN estudiantes
		model.addAttribute("estudiantes", estudianteRepository.findAll());
		return "home";
	}
	
	//METODOD PARA REDIRECCCIONAR AL CREAR
	@GetMapping("/createAlumno") //http://localhost:8080/estudiantes
	public String createAlumno() {
		return "createAlumno";
	}
	
	@PostMapping("/saveAlumno")
	public String guardarAlumno(Estudiante estudiante) {
		logg.info("Información del estudiante: {}", estudiante);
		estudianteRepository.save(estudiante);
		return "redirect:/estudiantes";
	}
}
