
package dto;


public class ModuloDto {
    private int id_modulo;
    private String nombre_modulo;
    private int numero_modulo;

    public ModuloDto() {
    }

    public ModuloDto(int id_modulo, String nombre_modulo, int numero_modulo) {
        this.id_modulo = id_modulo;
        this.nombre_modulo = nombre_modulo;
        this.numero_modulo = numero_modulo;
    }

    public int getId_modulo() {
        return id_modulo;
    }

    public void setId_modulo(int id_modulo) {
        this.id_modulo = id_modulo;
    }

    public String getNombre_modulo() {
        return nombre_modulo;
    }

    public void setNombre_modulo(String nombre_modulo) {
        this.nombre_modulo = nombre_modulo;
    }

    public int getNumero_modulo() {
        return numero_modulo;
    }

    public void setNumero_modulo(int numero_modulo) {
        this.numero_modulo = numero_modulo;
    }

    @Override
    public String toString() {
        return "DTO_Modulo{" + "id_modulo=" + id_modulo + ", nombre_modulo=" + nombre_modulo + ", numero_modulo=" + numero_modulo + '}';
    }
    
    
}
