package dto;

public class ComunaDto {

    private int id_comuna;
    private String nombre_comuna;
    private RegionDto region_Comuna;

    public ComunaDto() {
    }

    public ComunaDto(int id_comuna, String nombre_comuna, RegionDto region_Comuna) {
        this.id_comuna = id_comuna;
        this.nombre_comuna = nombre_comuna;
        this.region_Comuna = region_Comuna;
    }

    public int getId_comuna() {
        return id_comuna;
    }

    public void setId_comuna(int id_comuna) {
        this.id_comuna = id_comuna;
    }

    public String getNombre_comuna() {
        return nombre_comuna;
    }

    public void setNombre_comuna(String nombre_comuna) {
        this.nombre_comuna = nombre_comuna;
    }

    public RegionDto getRegion_Comuna() {
        return region_Comuna;
    }

    public void setRegion_Comuna(RegionDto region_Comuna) {
        this.region_Comuna = region_Comuna;
    }

    @Override
    public String toString() {
        return "ComunaDto{" + "id_comuna=" + id_comuna + ", nombre_comuna=" + nombre_comuna + ", region_Comuna=" + region_Comuna + '}';
    }

}
