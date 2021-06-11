
package dto;

import java.util.Collection;
import java.util.Objects;


public class Especialidad{


    private Integer idEspecialidad;
    private String descripcionEspecialidad;

    public Especialidad(Integer idEspecialidad, String descripcionEspecialidad) {
        this.idEspecialidad = idEspecialidad;
        this.descripcionEspecialidad = descripcionEspecialidad;
    }

    public Especialidad() {
    }

    public Integer getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(Integer idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public String getDescripcionEspecialidad() {
        return descripcionEspecialidad;
    }

    public void setDescripcionEspecialidad(String descripcionEspecialidad) {
        this.descripcionEspecialidad = descripcionEspecialidad;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.idEspecialidad);
        hash = 47 * hash + Objects.hashCode(this.descripcionEspecialidad);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Especialidad other = (Especialidad) obj;
        if (!Objects.equals(this.descripcionEspecialidad, other.descripcionEspecialidad)) {
            return false;
        }
        if (!Objects.equals(this.idEspecialidad, other.idEspecialidad)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Especialidad{" + "idEspecialidad=" + idEspecialidad + ", descripcionEspecialidad=" + descripcionEspecialidad + '}';
    }
    
    
    
    

}