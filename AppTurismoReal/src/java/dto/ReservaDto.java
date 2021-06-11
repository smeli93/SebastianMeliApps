package dto;

import java.util.Date;

public class ReservaDto {

    private int id_reserva;
    private Date fecha_reserva;
    private int cant_dias;
    private Date inicio_reserva;
    private Date termino_reserva;
    private int pago_garantia;
    private int pago_checkIn;
    private int pago_checkOut;
    private int total_servicios;
    private int total_pagar;
    private MetodoPagoDto metodoPago;
    private PersonaDto persona;
    private DepartamentoDto departamento;

    public ReservaDto() {
    }

    public ReservaDto(int id_reserva, Date fecha_reserva, int cant_dias, Date inicio_reserva, Date termino_reserva, int pago_garantia, int pago_checkIn, int pago_checkOut, int total_servicios, int total_pagar, MetodoPagoDto metodoPago, PersonaDto persona, DepartamentoDto departamento) {
        this.id_reserva = id_reserva;
        this.fecha_reserva = fecha_reserva;
        this.cant_dias = cant_dias;
        this.inicio_reserva = inicio_reserva;
        this.termino_reserva = termino_reserva;
        this.pago_garantia = pago_garantia;
        this.pago_checkIn = pago_checkIn;
        this.pago_checkOut = pago_checkOut;
        this.total_servicios = total_servicios;
        this.total_pagar = total_pagar;
        this.metodoPago = metodoPago;
        this.persona = persona;
        this.departamento = departamento;
    }

    public int getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(int id_reserva) {
        this.id_reserva = id_reserva;
    }

    public Date getFecha_reserva() {
        return fecha_reserva;
    }

    public void setFecha_reserva(Date fecha_reserva) {
        this.fecha_reserva = fecha_reserva;
    }

    public int getCant_dias() {
        return cant_dias;
    }

    public void setCant_dias(int cant_dias) {
        this.cant_dias = cant_dias;
    }

    public Date getInicio_reserva() {
        return inicio_reserva;
    }

    public void setInicio_reserva(Date inicio_reserva) {
        this.inicio_reserva = inicio_reserva;
    }

    public Date getTermino_reserva() {
        return termino_reserva;
    }

    public void setTermino_reserva(Date termino_reserva) {
        this.termino_reserva = termino_reserva;
    }

    public int getPago_garantia() {
        return pago_garantia;
    }

    public void setPago_garantia(int pago_garantia) {
        this.pago_garantia = pago_garantia;
    }

    public int getPago_checkIn() {
        return pago_checkIn;
    }

    public void setPago_checkIn(int pago_checkIn) {
        this.pago_checkIn = pago_checkIn;
    }

    public int getPago_checkOut() {
        return pago_checkOut;
    }

    public void setPago_checkOut(int pago_checkOut) {
        this.pago_checkOut = pago_checkOut;
    }

    public int getTotal_servicios() {
        return total_servicios;
    }

    public void setTotal_servicios(int total_servicios) {
        this.total_servicios = total_servicios;
    }

    public int getTotal_pagar() {
        return total_pagar;
    }

    public void setTotal_pagar(int total_pagar) {
        this.total_pagar = total_pagar;
    }

    public MetodoPagoDto getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPagoDto metodoPago) {
        this.metodoPago = metodoPago;
    }

    public PersonaDto getPersona() {
        return persona;
    }

    public void setPersona(PersonaDto persona) {
        this.persona = persona;
    }

    public DepartamentoDto getDepartamento() {
        return departamento;
    }

    public void setDepartamento(DepartamentoDto departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "ReservaDto{" + "id_reserva=" + id_reserva + ", fecha_reserva=" + fecha_reserva + ", cant_dias=" + cant_dias + ", inicio_reserva=" + inicio_reserva + ", termino_reserva=" + termino_reserva + ", pago_garantia=" + pago_garantia + ", pago_checkIn=" + pago_checkIn + ", pago_checkOut=" + pago_checkOut + ", total_servicios=" + total_servicios + ", total_pagar=" + total_pagar + ", metodoPago=" + metodoPago + ", persona=" + persona + ", departamento=" + departamento + '}';
    }

}
