package dto;


import java.util.Collection;
import java.util.Objects;


public class Usuario{

    
    private String rutUsuario;
    private String passwordUsuario;
    private String nombreUsuario;
    private String apellidoUsuario;
    private String emailUsuario;
    private int telefonoUsuario;
    private int perfilidPerfil;

    public Usuario(String rutUsuario, String passwordUsuario, String nombreUsuario, String apellidoUsuario, String emailUsuario, int telefonoUsuario, int perfilidPerfil) {
        this.rutUsuario = rutUsuario;
        this.passwordUsuario = passwordUsuario;
        this.nombreUsuario = nombreUsuario;
        this.apellidoUsuario = apellidoUsuario;
        this.emailUsuario = emailUsuario;
        this.telefonoUsuario = telefonoUsuario;
        this.perfilidPerfil = perfilidPerfil;
    }

    public Usuario() {
    }

    public String getRutUsuario() {
        return rutUsuario;
    }

    public void setRutUsuario(String rutUsuario) {
        this.rutUsuario = rutUsuario;
    }

    public String getPasswordUsuario() {
        return passwordUsuario;
    }

    public void setPasswordUsuario(String passwordUsuario) {
        this.passwordUsuario = passwordUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidoUsuario() {
        return apellidoUsuario;
    }

    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public int getTelefonoUsuario() {
        return telefonoUsuario;
    }

    public void setTelefonoUsuario(int telefonoUsuario) {
        this.telefonoUsuario = telefonoUsuario;
    }

    public int getPerfilidPerfil() {
        return perfilidPerfil;
    }

    public void setPerfilidPerfil(int perfilidPerfil) {
        this.perfilidPerfil = perfilidPerfil;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.rutUsuario);
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
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.rutUsuario, other.rutUsuario)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Usuario{" + "rutUsuario=" + rutUsuario + ", passwordUsuario=" + passwordUsuario + ", nombreUsuario=" + nombreUsuario + ", apellidoUsuario=" + apellidoUsuario + ", emailUsuario=" + emailUsuario + ", telefonoUsuario=" + telefonoUsuario + ", perfilidPerfil=" + perfilidPerfil + '}';
    }

    
    
}
