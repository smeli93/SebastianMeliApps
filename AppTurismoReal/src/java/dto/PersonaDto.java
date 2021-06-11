package dto;

import java.util.Date;

public class PersonaDto {

    private String rut;
    private String primer_nombre;
    private String segundo_nombre;
    private String ap_paterno;
    private String ap_materno;
    private Date fecha_nacimiento;
    private int telefono;
    //private String estado;
    private String direccion;

    public PersonaDto() {
    }

    public PersonaDto(String rut, String primer_nombre, String segundo_nombre, String ap_paterno, String ap_materno, Date fecha_nacimiento, int telefono, String direccion) {
        this.rut = rut;
        this.primer_nombre = primer_nombre;
        this.segundo_nombre = segundo_nombre;
        this.ap_paterno = ap_paterno;
        this.ap_materno = ap_materno;
        this.fecha_nacimiento = fecha_nacimiento;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getPrimer_nombre() {
        return primer_nombre;
    }

    public void setPrimer_nombre(String primer_nombre) {
        this.primer_nombre = primer_nombre;
    }

    public String getSegundo_nombre() {
        return segundo_nombre;
    }

    public void setSegundo_nombre(String segundo_nombre) {
        this.segundo_nombre = segundo_nombre;
    }

    public String getAp_paterno() {
        return ap_paterno;
    }

    public void setAp_paterno(String ap_paterno) {
        this.ap_paterno = ap_paterno;
    }

    public String getAp_materno() {
        return ap_materno;
    }

    public void setAp_materno(String ap_materno) {
        this.ap_materno = ap_materno;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "DTO_Persona{" + "rut=" + rut + ", primer_nombre=" + primer_nombre + ", segundo_nombre=" + segundo_nombre + ", ap_paterno=" + ap_paterno + ", ap_materno=" + ap_materno + ", fecha_nacimiento=" + fecha_nacimiento + ", telefono=" + telefono + ", direccion=" + direccion + '}';
    }

}
