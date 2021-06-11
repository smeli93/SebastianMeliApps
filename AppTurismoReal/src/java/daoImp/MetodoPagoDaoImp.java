/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoImp;

import dao.MetodoPagoDao;
import dto.MetodoPagoDto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import sql.Conexion;

/**
 *
 * @author Germán
 */
public class MetodoPagoDaoImp implements MetodoPagoDao {

    @Override
    public ArrayList<String> listarMetodoPago() {

        ArrayList<String> lista = new ArrayList<>();

        try {
            Connection conexion = Conexion.getConexion();
            String query = "SELECT DESC_METODO_PAGO FROM METODO_PAGO";
            PreparedStatement listar = conexion.prepareStatement(query);
            ResultSet rs = listar.executeQuery();

            while (rs.next()) {
                lista.add(rs.getString("DESC_METODO_PAGO"));
            }
            listar.close();
            conexion.close();

        } catch (SQLException ex) {
            System.out.println("Error sql al listar metodos de pago" + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Error al listar metodos de pago" + ex.getMessage());
        }

        return lista;
    }

    @Override
    public int MetodoPagoToId(String desc_metodo_pago) {
        int id = 0;

        try {
            Connection conexion = Conexion.getConexion();
            String query = "SELECT ID_METODO_PAGO FROM METODO_PAGO WHERE DESC_METODO_PAGO=?";
            PreparedStatement buscar = conexion.prepareStatement(query);
            buscar.setString(1, desc_metodo_pago);
            ResultSet rs = buscar.executeQuery();
            if (rs.next()) {
                id = rs.getInt("ID_METODO_PAGO");
            }
            buscar.close();
            conexion.close();
        } catch (SQLException w) {
            System.out.println("Error SQL al buscar id de metodo de pago " + w.getMessage());
        } catch (Exception e) {
            System.out.println("Error al buscar id de metodo de pago" + e.getMessage());
        }
        return id;
    }

}
