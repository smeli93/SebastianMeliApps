/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.MetodoPagoDto;
import java.util.ArrayList;

/**
 *
 * @author Germán
 */
public interface MetodoPagoDao {

    public ArrayList<String> listarMetodoPago();
    public int MetodoPagoToId(String desc_metodo_pago);
}
