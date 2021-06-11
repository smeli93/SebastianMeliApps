package dto;

import java.util.Date;

public class DetalleServicioExtraDto {

    private int id_detalleServicio;
    private Date fecha_contratoServicio;
    private ServicioExtraDto servicio_extra;
    private ReservaDto reserva;

    public DetalleServicioExtraDto() {
    }

    public DetalleServicioExtraDto(int id_detalleServicio, Date fecha_contratoServicio, ServicioExtraDto servicio_extra, ReservaDto reserva) {
        this.id_detalleServicio = id_detalleServicio;
        this.fecha_contratoServicio = fecha_contratoServicio;
        this.servicio_extra = servicio_extra;
        this.reserva = reserva;
    }

    public int getId_detalleServicio() {
        return id_detalleServicio;
    }

    public void setId_detalleServicio(int id_detalleServicio) {
        this.id_detalleServicio = id_detalleServicio;
    }

    public Date getFecha_contratoServicio() {
        return fecha_contratoServicio;
    }

    public void setFecha_contratoServicio(Date fecha_contratoServicio) {
        this.fecha_contratoServicio = fecha_contratoServicio;
    }

    public ServicioExtraDto getServicio_extra() {
        return servicio_extra;
    }

    public void setServicio_extra(ServicioExtraDto servicio_extra) {
        this.servicio_extra = servicio_extra;
    }

    public ReservaDto getReserva() {
        return reserva;
    }

    public void setReserva(ReservaDto reserva) {
        this.reserva = reserva;
    }

    @Override
    public String toString() {
        return "DetalleServicioExtraDto{" + "id_detalleServicio=" + id_detalleServicio + ", fecha_contratoServicio=" + fecha_contratoServicio + ", servicio_extra=" + servicio_extra + ", reserva=" + reserva + '}';
    }

}
