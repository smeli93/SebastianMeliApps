
package dto;

import java.util.Date;
import java.util.Objects;


public class Mascota {

    
    private int idMascota;
    private String nombreMascota;
    private Date fechaNacimiento;
    private String usuariorutusuario;
    private int razaidRaza;
    private int tipoMascotaidTipoMascota;

    public Mascota(int idMascota, String nombreMascota, Date fechaNacimiento, String usuariorutusuario, int razaidRaza,int tipoMascotaidTipoMascota) {
        this.idMascota = idMascota;
        this.nombreMascota = nombreMascota;
        this.fechaNacimiento = fechaNacimiento;
        this.usuariorutusuario = usuariorutusuario;
        this.razaidRaza = razaidRaza;
        this.tipoMascotaidTipoMascota = tipoMascotaidTipoMascota;
    }




    public Mascota() {

    }

    public int getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }

    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getRazaidRaza() {
        return razaidRaza;
    }

    public void setRazaidRaza(int razaidRaza) {
        this.razaidRaza = razaidRaza;
    }

    public int getTipoMascotaidTipoMascota() {
        return tipoMascotaidTipoMascota;
    }

    public void setTipoMascotaidTipoMascota(int tipoMascotaidTipoMascota) {
        this.tipoMascotaidTipoMascota = tipoMascotaidTipoMascota;
    }

    public String getUsuariorutusuario() {
        return usuariorutusuario;
    }

    public void setUsuariorutusuario(String usuariorutusuario) {
        this.usuariorutusuario = usuariorutusuario;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.idMascota);
        hash = 89 * hash + Objects.hashCode(this.nombreMascota);
        hash = 89 * hash + Objects.hashCode(this.fechaNacimiento);
        hash = 89 * hash + Objects.hashCode(this.razaidRaza);
        hash = 89 * hash + Objects.hashCode(this.tipoMascotaidTipoMascota);
        hash = 89 * hash + Objects.hashCode(this.usuariorutusuario);
        return hash;
    }


    @Override
    public String toString() {
        return "Mascota{" + "idMascota=" + idMascota + ", nombreMascota=" + nombreMascota + ", fechaNacimiento=" + fechaNacimiento + ", razaidRaza=" + razaidRaza + ", tipoMascotaidTipoMascota=" + tipoMascotaidTipoMascota + ", usuariorutusuario=" + usuariorutusuario + '}';
    }
    
    
    
    


    
}
