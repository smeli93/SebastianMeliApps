
package dto;


import java.util.Collection;
import java.util.Objects;


public class Raza{

    
    private Integer idRaza;
    private String descripcionRaza;

    public Raza(Integer idRaza, String descripcionRaza) {
        this.idRaza = idRaza;
        this.descripcionRaza = descripcionRaza;
    }

    public Raza() {
    }

    public Integer getIdRaza() {
        return idRaza;
    }

    public void setIdRaza(Integer idRaza) {
        this.idRaza = idRaza;
    }

    public String getDescripcionRaza() {
        return descripcionRaza;
    }

    public void setDescripcionRaza(String descripcionRaza) {
        this.descripcionRaza = descripcionRaza;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.idRaza);
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
        final Raza other = (Raza) obj;
        if (!Objects.equals(this.idRaza, other.idRaza)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Raza{" + "idRaza=" + idRaza + ", descripcionRaza=" + descripcionRaza + '}';
    }
    
    
    
}
