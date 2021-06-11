
package dto;

import java.util.Collection;
import java.util.Date;
import java.util.Objects;


public class Reserva{

    
    private int idReserva;
    private String motivoReserva;
    private Date fechaReserva;
    private String horaReserva;
    private int estadoidEstado;
    private int veterinarioidVeterinario;
    private String usuariorutusuario;
    private int mascotaidMascota;

    public Reserva(int idReserva, String motivoReserva, Date fechaReserva, String horaReserva, int estadoidEstado, int veterinarioidVeterinario, String usuariorutusuario, int mascotaidMascota) {
        this.idReserva = idReserva;
        this.motivoReserva = motivoReserva;
        this.fechaReserva = fechaReserva;
        this.horaReserva = horaReserva;
        this.estadoidEstado = estadoidEstado;
        this.veterinarioidVeterinario = veterinarioidVeterinario;
        this.usuariorutusuario = usuariorutusuario;
        this.mascotaidMascota = mascotaidMascota;
    }

    public Reserva() {
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public String getMotivoReserva() {
        return motivoReserva;
    }

    public void setMotivoReserva(String motivoReserva) {
        this.motivoReserva = motivoReserva;
    }

    public Date getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public String getHoraReserva() {
        return horaReserva;
    }

    public void setHoraReserva(String horaReserva) {
        this.horaReserva = horaReserva;
    }

    public int getEstadoidEstado() {
        return estadoidEstado;
    }

    public void setEstadoidEstado(int estadoidEstado) {
        this.estadoidEstado = estadoidEstado;
    }

    public int getVeterinarioidVeterinario() {
        return veterinarioidVeterinario;
    }

    public void setVeterinarioidVeterinario(int veterinarioidVeterinario) {
        this.veterinarioidVeterinario = veterinarioidVeterinario;
    }

    public String getUsuariorutusuario() {
        return usuariorutusuario;
    }

    public void setUsuariorutusuario(String usuariorutusuario) {
        this.usuariorutusuario = usuariorutusuario;
    }

    public int getMascotaidMascota() {
        return mascotaidMascota;
    }

    public void setMascotaidMascota(int mascotaidMascota) {
        this.mascotaidMascota = mascotaidMascota;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + this.idReserva;
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
        final Reserva other = (Reserva) obj;
        if (this.idReserva != other.idReserva) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Reserva{" + "idReserva=" + idReserva + ", motivoReserva=" + motivoReserva + ", fechaReserva=" + fechaReserva + ", horaReserva=" + horaReserva + ", estadoidEstado=" + estadoidEstado + ", veterinarioidVeterinario=" + veterinarioidVeterinario + ", usuariorutusuario=" + usuariorutusuario + ", mascotaidMascota=" + mascotaidMascota + '}';
    }


 

    
    
}
