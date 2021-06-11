
package dto;

import java.util.Collection;
import java.util.Objects;


public class Perfil{

    private Integer idPerfil;
    private String descripcionPerfil;

    public Perfil(Integer idPerfil, String descripcionPerfil) {
        this.idPerfil = idPerfil;
        this.descripcionPerfil = descripcionPerfil;
    }

    public Perfil() {
        this.idPerfil = 0;
        this.descripcionPerfil = "";       
    }

    public Integer getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Integer idPerfil) {
        this.idPerfil = idPerfil;
    }

    public String getDescripcionPerfil() {
        return descripcionPerfil;
    }

    public void setDescripcionPerfil(String descripcionPerfil) {
        this.descripcionPerfil = descripcionPerfil;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.idPerfil);
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
        final Perfil other = (Perfil) obj;
        if (!Objects.equals(this.idPerfil, other.idPerfil)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Perfil{" + "idPerfil=" + idPerfil + ", descripcionPerfil=" + descripcionPerfil + '}';
    }
    
    
    
    
    
}
