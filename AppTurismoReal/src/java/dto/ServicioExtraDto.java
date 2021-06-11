
package dto;


public class ServicioExtraDto {
    private int id_servicioExtra;
    private String nombre_servicioExtra;
    private int valor_servicioExtra;

    public ServicioExtraDto() {
    }

    public ServicioExtraDto(int id_servicioExtra, String nombre_servicioExtra, int valor_servicioExtra) {
        this.id_servicioExtra = id_servicioExtra;
        this.nombre_servicioExtra = nombre_servicioExtra;
        this.valor_servicioExtra = valor_servicioExtra;
    }

    public int getId_servicioExtra() {
        return id_servicioExtra;
    }

    public void setId_servicioExtra(int id_servicioExtra) {
        this.id_servicioExtra = id_servicioExtra;
    }

    public String getNombre_servicioExtra() {
        return nombre_servicioExtra;
    }

    public void setNombre_servicioExtra(String nombre_servicioExtra) {
        this.nombre_servicioExtra = nombre_servicioExtra;
    }

    public int getValor_servicioExtra() {
        return valor_servicioExtra;
    }

    public void setValor_servicioExtra(int valor_servicioExtra) {
        this.valor_servicioExtra = valor_servicioExtra;
    }

    @Override
    public String toString() {
        return "ServicioExtraDto{" + "id_servicioExtra=" + id_servicioExtra + ", nombre_servicioExtra=" + nombre_servicioExtra + ", valor_servicioExtra=" + valor_servicioExtra + '}';
    }
    
    
}
