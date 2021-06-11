package dto;


import java.util.Collection;
import java.util.Objects;


public class TipoMascota{

    
    private Integer idTipoMascota;
    private String descripcionTipoMascota;

    public TipoMascota(Integer idTipoMascota, String descripcionTipoMascota) {
        this.idTipoMascota = idTipoMascota;
        this.descripcionTipoMascota = descripcionTipoMascota;
    }

    public TipoMascota() {
    }

    public Integer getIdTipoMascota() {
        return idTipoMascota;
    }

    public void setIdTipoMascota(Integer idTipoMascota) {
        this.idTipoMascota = idTipoMascota;
    }

    public String getDescripcionTipoMascota() {
        return descripcionTipoMascota;
    }

    public void setDescripcionTipoMascota(String descripcionTipoMascota) {
        this.descripcionTipoMascota = descripcionTipoMascota;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.idTipoMascota);
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
        final TipoMascota other = (TipoMascota) obj;
        if (!Objects.equals(this.idTipoMascota, other.idTipoMascota)) {
            return false;
        }
        return true;
    }

    
    @Override
    public String toString() {
        return "TipoMascota{" + "idTipoMascota=" + idTipoMascota + ", descripcionTipoMascota=" + descripcionTipoMascota + '}';
    }
    
    
    
}
