/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author Germán
 */
public class MetodoPagoDto {

    private int id_metodo_pago;
    private String desc_metodo_pago;

    public MetodoPagoDto() {
    }

    public MetodoPagoDto(int id_metodo_pago, String desc_metodo_pago) {
        this.id_metodo_pago = id_metodo_pago;
        this.desc_metodo_pago = desc_metodo_pago;
    }

    public int getId_metodo_pago() {
        return id_metodo_pago;
    }

    public void setId_metodo_pago(int id_metodo_pago) {
        this.id_metodo_pago = id_metodo_pago;
    }

    public String getDesc_metodo_pago() {
        return desc_metodo_pago;
    }

    public void setDesc_metodo_pago(String desc_metodo_pago) {
        this.desc_metodo_pago = desc_metodo_pago;
    }

    @Override
    public String toString() {
        return "MetodoPagoDto{" + "id_metodo_pago=" + id_metodo_pago + ", desc_metodo_pago=" + desc_metodo_pago + '}';
    }

}
