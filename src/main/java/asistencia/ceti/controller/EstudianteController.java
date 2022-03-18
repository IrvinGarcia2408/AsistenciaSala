package asistencia.ceti.controller;

<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
=======
>>>>>>> refs/heads/edson
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import asistencia.ceti.model.Estudiante;
import asistencia.ceti.repository.IEstudianteRepository;

//Anotacion para que la clase sea reconocida como controlador
@Controller
@RequestMapping("/estudiantes") // DEFINE UN PATH AL CUAL SE APUNTA PARA LA URL Y ACCEDA AL CONRTROLADOR
								// http://localhost:8080/estudiantes
public class EstudianteController {

	// OBJETO POR EL CUAL SE TENDRA ACCESO A LOS METODOS PARA REALIZAR EL CRUD
	@Autowired // SE INYECTA Y NO ES NECESARIO INSTANCIAR
	private IEstudianteRepository estudianteRepository;

	//
	private final Logger logg = org.slf4j.LoggerFactory.getLogger(Estudiante.class);

	// METODO PRINCIPAL QUE OSTRARA LOS ESTUDIANTES
	// QUE TIPO DE PETICION RESPONDERÁ
	@GetMapping("")
	public String home(Model model) {
		// INDICAR QUE LO QUE HAY EN BD SE MUESTRE
		// A TRAVES DE REPOSITORY SE TRAEN TODOS LOS VALORES DE ESTUDIANTES Y SE GUARDAN
		// EN estudiantes
		model.addAttribute("estudiantes", estudianteRepository.findAll());
		return "home";
	}

	// METODOD PARA REDIRECCCIONAR AL CREAR
	@GetMapping("/createAlumno") // http://localhost:8080/estudiantes
	public String createAlumno() {
		return "createAlumno";
	}

	@PostMapping("/saveAlumno")
	public String guardarAlumno(Estudiante estudiante) {
		logg.info("Información del estudiante: {}", estudiante); //MOSTRAR MENSAJE DE CREACION DEL ALUMNO
		estudianteRepository.save(estudiante);
		return "redirect:/estudiantes";
	}
<<<<<<< HEAD
	
=======

	@GetMapping("/editAlumno/{id}")
	// @PathVariable AYUDA A RECIBIR EL VALOR DE LA URL, O DEFINIR
	public String editarAlumno(@PathVariable Integer id, Model model) {
		Estudiante est = estudianteRepository.getOne(id);
		logg.info("Objeto recuperado {}", est);

		model.addAttribute("estudiante", est);

		return "editAlumno";// NOMBRE DE LA PAGINA H
	}
	
	@GetMapping("/deleteAlumno/{id}")
	// @PathVariable AYUDA A RECIBIR EL VALOR DE LA URL, O DIFINIR
	public String deleteAlumno(@PathVariable Integer id) {
		Estudiante est = estudianteRepository.getOne(id);
		logg.info("Objeto eliminado {}", est);
		estudianteRepository.delete(est);
		return "redirect:/estudiantes";
	}
>>>>>>> refs/heads/edson

}
