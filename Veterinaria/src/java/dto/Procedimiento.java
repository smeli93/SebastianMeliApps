
package dto;

import java.util.Date;


public class Procedimiento{

    
    private int idProcedimiento;    
    private String nombreProdecimiento;   
    private Date fechaProcedimiento;    
    private String descripcionProcedimiento;
    private int reservaidReserva;    
    private int mascotaidMascota;

    public Procedimiento(int idProcedimiento, String nombreProdecimiento, Date fechaProcedimiento, String descripcionProcedimiento, int reservaidReserva, int mascotaidMascota) {
        this.idProcedimiento = idProcedimiento;
        this.nombreProdecimiento = nombreProdecimiento;
        this.fechaProcedimiento = fechaProcedimiento;
        this.descripcionProcedimiento = descripcionProcedimiento;
        this.reservaidReserva = reservaidReserva;
        this.mascotaidMascota = mascotaidMascota;
    }

    public Procedimiento() {
    }
    

    public int getIdProcedimiento() {
        return idProcedimiento;
    }

    public void setIdProcedimiento(int idProcedimiento) {
        this.idProcedimiento = idProcedimiento;
    }

    public String getNombreProdecimiento() {
        return nombreProdecimiento;
    }

    public void setNombreProdecimiento(String nombreProdecimiento) {
        this.nombreProdecimiento = nombreProdecimiento;
    }

    public Date getFechaProcedimiento() {
        return fechaProcedimiento;
    }

    public void setFechaProcedimiento(Date fechaProcedimiento) {
        this.fechaProcedimiento = fechaProcedimiento;
    }

    public String getDescripcionProcedimiento() {
        return descripcionProcedimiento;
    }

    public void setDescripcionProcedimiento(String descripcionProcedimiento) {
        this.descripcionProcedimiento = descripcionProcedimiento;
    }

    public int getReservaidReserva() {
        return reservaidReserva;
    }

    public void setReservaidReserva(int reservaidReserva) {
        this.reservaidReserva = reservaidReserva;
    }

    public int getMascotaidMascota() {
        return mascotaidMascota;
    }

    public void setMascotaidMascota(int mascotaidMascota) {
        this.mascotaidMascota = mascotaidMascota;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + this.idProcedimiento;
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
        final Procedimiento other = (Procedimiento) obj;
        if (this.idProcedimiento != other.idProcedimiento) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Procedimiento{" + "idProcedimiento=" + idProcedimiento + ", nombreProdecimiento=" + nombreProdecimiento + ", fechaProcedimiento=" + fechaProcedimiento + ", descripcionProcedimiento=" + descripcionProcedimiento + ", reservaidReserva=" + reservaidReserva + ", mascotaidMascota=" + mascotaidMascota + '}';
    }


}

 