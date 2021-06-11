
package dto;

import java.util.Collection;
import java.util.Date;
import java.util.Objects;

public class Veterinario{

    private Integer idVeterinario;
    private String nombre;
    private String apellido;
    private String email;
    private String direccion;
    private String telefono;
    private Date fechaDeIngreso;
    private int idEspecialidad;

    public Veterinario(Integer idVeterinario, String nombre, String apellido, String email, String direccion, String telefono, Date fechaDeIngreso, int idEspecialidad) {
        this.idVeterinario = idVeterinario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fechaDeIngreso = fechaDeIngreso;
        this.idEspecialidad = idEspecialidad;
    }

    public Veterinario() {
    }

    public Integer getIdVeterinario() {
        return idVeterinario;
    }

    public void setIdVeterinario(Integer idVeterinario) {
        this.idVeterinario = idVeterinario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFechaDeIngreso() {
        return fechaDeIngreso;
    }

    public void setFechaDeIngreso(Date fechaDeIngreso) {
        this.fechaDeIngreso = fechaDeIngreso;
    }

    public int getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(int idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.idVeterinario);
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
        final Veterinario other = (Veterinario) obj;
        if (!Objects.equals(this.idVeterinario, other.idVeterinario)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Veterinario{" + "idVeterinario=" + idVeterinario + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", direccion=" + direccion + ", telefono=" + telefono + ", fechaDeIngreso=" + fechaDeIngreso + ", idEspecialidad=" + idEspecialidad + '}';
    }

    
    
    
}
