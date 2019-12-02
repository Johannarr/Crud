package rodriguez.johanna.crud.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class  Estudiante implements Serializable {

    @Id

    private int matricula;
    private String nombre;
    private String telefono;

    public Estudiante(){

    }

    public Estudiante(int matricula, String nombre, String telefono){
        this.matricula = matricula;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() { return telefono; }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}
