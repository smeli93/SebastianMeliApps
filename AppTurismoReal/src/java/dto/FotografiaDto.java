package dto;

import java.io.InputStream;

public class FotografiaDto {

    private int id_fotografia;
    private String imagen;
    private DepartamentoDto depto_foto;

    public FotografiaDto() {
    }

    public FotografiaDto(int id_fotografia, String imagen, DepartamentoDto depto_foto) {
        this.id_fotografia = id_fotografia;
        this.imagen = imagen;
        this.depto_foto = depto_foto;
    }

    public int getId_fotografia() {
        return id_fotografia;
    }

    public void setId_fotografia(int id_fotografia) {
        this.id_fotografia = id_fotografia;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public DepartamentoDto getDepto_foto() {
        return depto_foto;
    }

    public void setDepto_foto(DepartamentoDto depto_foto) {
        this.depto_foto = depto_foto;
    }

    

}
