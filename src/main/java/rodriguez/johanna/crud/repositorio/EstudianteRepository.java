package rodriguez.johanna.crud.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rodriguez.johanna.crud.modelo.Estudiante;

import java.util.List;

@Repository
public interface EstudianteRepository extends JpaRepository <Estudiante, Integer> {

    Estudiante findByMatricula (int matricula);

    List<Estudiante> findAllByNombreLike(String nombre);
}
