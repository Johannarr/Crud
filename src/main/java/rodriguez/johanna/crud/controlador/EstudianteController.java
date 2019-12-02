package rodriguez.johanna.crud.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import rodriguez.johanna.crud.modelo.Estudiante;
import rodriguez.johanna.crud.repositorio.EstudianteRepository;

@Controller

public class EstudianteController {

    @Autowired
    EstudianteRepository estudianteRepo;

    public EstudianteController (EstudianteRepository estudianteRepo){
        this.estudianteRepo = estudianteRepo;
    }

    @RequestMapping("/")
    public String listaEstudiante(Model modelo){

        modelo.addAttribute("titulo", "Lista de Estudiante");
        modelo.addAttribute("estudiantes", estudianteRepo.findAll());
            return "inicio";
        }


    @RequestMapping("nuevoEstudiante")
    public String crearEstudiante(Model modelo){
        modelo.addAttribute("titulo", "Crear Estudiante");
        modelo.addAttribute("label", "Crear Estudiante");
        return "formAgregar";
    }

       @PostMapping(path = "/procesarEstudiante", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String parsearEstudianteFormulario(Estudiante estudiante){
        System.out.println("El estudiante: "+estudiante.toString());
        estudianteRepo.save(estudiante);
        return "redirect:/";
    }

    @GetMapping("editar/{matricula}")
    public String editarEstudiante(Model model, @PathVariable int matricula){
        Estudiante estudiante = estudianteRepo.getOne(matricula);
        String label = "Actualizando Matricula: "+estudiante.getNombre();
        model.addAttribute("estudiante", estudiante);
        model.addAttribute("titulo", label);
        model.addAttribute("label", label);
        return "formEditar";
    }

    @GetMapping(path = "eliminar/{matricula}")
    public String borrarEstudiante(Model model, @PathVariable int matricula){
        Estudiante estudiante = estudianteRepo.getOne(matricula);
        estudianteRepo.delete(estudiante);
        return "redirect:/";
    }

}