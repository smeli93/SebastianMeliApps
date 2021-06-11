
package dto;

import java.util.Collection;
import java.util.Objects;


public class Estado {

    private Integer idEstado;
    private String descripcionEstado;

    public Estado(Integer idEstado, String descripcionEstado) {
        this.idEstado = idEstado;
        this.descripcionEstado = descripcionEstado;
    }
    
    public Estado() {
        this.idEstado = 0;
        this.descripcionEstado = "";
    }

    public Integer getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public String getDescripcionEstado() {
        return descripcionEstado;
    }

    public void setDescripcionEstado(String descripcionEstado) {
        this.descripcionEstado = descripcionEstado;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.idEstado);
        hash = 59 * hash + Objects.hashCode(this.descripcionEstado);
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
        final Estado other = (Estado) obj;
        if (!Objects.equals(this.descripcionEstado, other.descripcionEstado)) {
            return false;
        }
        if (!Objects.equals(this.idEstado, other.idEstado)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Estado{" + "idEstado=" + idEstado + ", descripcionEstado=" + descripcionEstado + '}';
    }
    
    

    
    
}
