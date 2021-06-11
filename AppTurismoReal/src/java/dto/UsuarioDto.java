package dto;

import dto.PersonaDto;

public class UsuarioDto {

    private int id_usuario;
    private String email;
    private String contrasena;
    private boolean estado;
    private int cargo_usuario;
    private PersonaDto rutPersona;

    public UsuarioDto() {
    }

    public UsuarioDto(int id_usuario, String email, String contrasena, boolean estado, int cargo_usuario, PersonaDto rutPersona) {
        this.id_usuario = id_usuario;
        this.email = email;
        this.contrasena = contrasena;
        this.estado = estado;
        this.cargo_usuario = cargo_usuario;
        this.rutPersona = rutPersona;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getCargo_usuario() {
        return cargo_usuario;
    }

    public void setCargo_usuario(int cargo_usuario) {
        this.cargo_usuario = cargo_usuario;
    }

    public PersonaDto getRutPersona() {
        return rutPersona;
    }

    public void setRutPersona(PersonaDto rutPersona) {
        this.rutPersona = rutPersona;
    }

    @Override
    public String toString() {
        return "UsuarioDto{" + "id_usuario=" + id_usuario + ", email=" + email + ", contrasena=" + contrasena + ", estado=" + estado + ", cargo_usuario=" + cargo_usuario + ", rutPersona=" + rutPersona + '}';
    }

}
