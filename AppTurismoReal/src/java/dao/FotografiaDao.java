/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.FotografiaDto;
import java.util.ArrayList;

/**
 *
 * @author Germán
 */
public interface FotografiaDao {
    public ArrayList<FotografiaDto> mostrarImagenPrincipal(int id);
    public ArrayList<FotografiaDto> listarImagenes(int id);
    
}
