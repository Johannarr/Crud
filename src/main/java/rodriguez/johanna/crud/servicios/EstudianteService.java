package rodriguez.johanna.crud.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rodriguez.johanna.crud.modelo.Estudiante;
import rodriguez.johanna.crud.repositorio.EstudianteRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepo;

    @Transactional
    public void crearEstudiante (Estudiante estudiante)
    {
        estudianteRepo.save(estudiante);
    }

    public List<Estudiante> listarEstudiantes (){

        return estudianteRepo.findAll();
    }

    public Estudiante buscarEstuadianteByMatricula (int matricula)
    {
        return estudianteRepo.findByMatricula(matricula);
    }

    public void eliminarEstudiante (int matricula)
    {
        Estudiante estudianteToDelete = estudianteRepo.findByMatricula(matricula);

        estudianteRepo.delete(estudianteToDelete);
    }
}
