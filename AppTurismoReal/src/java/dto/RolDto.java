
package dto;


public class RolDto {
   private int id_rol;
   private int id_modulo;
   private int id_permiso;
   private int id_cargo;

    public RolDto() {
    }

    public RolDto(int id_rol, int id_modulo, int id_permiso, int id_cargo) {
        this.id_rol = id_rol;
        this.id_modulo = id_modulo;
        this.id_permiso = id_permiso;
        this.id_cargo = id_cargo;
    }

    public int getId_rol() {
        return id_rol;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

    public int getId_modulo() {
        return id_modulo;
    }

    public void setId_modulo(int id_modulo) {
        this.id_modulo = id_modulo;
    }

    public int getId_permiso() {
        return id_permiso;
    }

    public void setId_permiso(int id_permiso) {
        this.id_permiso = id_permiso;
    }

    public int getId_cargo() {
        return id_cargo;
    }

    public void setId_cargo(int id_cargo) {
        this.id_cargo = id_cargo;
    }

    @Override
    public String toString() {
        return "DTO_Rol{" + "id_rol=" + id_rol + ", id_modulo=" + id_modulo + ", id_permiso=" + id_permiso + ", id_cargo=" + id_cargo + '}';
    }
   
   
}
