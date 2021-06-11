/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoImp;

import dao.FotografiaDao;
import dto.DepartamentoDto;
import dto.FotografiaDto;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletResponse;
import sql.Conexion;

/**
 *
 * @author Germán
 */
public class FotografiaDaoImp implements FotografiaDao {

    @Override
    public ArrayList<FotografiaDto> mostrarImagenPrincipal(int id) {
        ArrayList<FotografiaDto> lista = new ArrayList<>();

        try {
            Connection conexion = Conexion.getConexion();
            String query = "SELECT * FROM FOTOGRAFIA WHERE DEPARTAMENTO_ID_DEPARTAMENTO=? LIMIT 1";
            PreparedStatement buscar = conexion.prepareStatement(query);
            buscar.setInt(1, id);
            ResultSet rs = buscar.executeQuery();

            while (rs.next()) {

                FotografiaDto foto = new FotografiaDto();
                DepartamentoDto depto = new DepartamentoDto();

                foto.setId_fotografia(rs.getInt("id_fotografia"));
                foto.setImagen(rs.getString("url_fotografia"));
                depto.setId_depto(rs.getInt("departamento_id_departamento"));
                foto.setDepto_foto(depto);

                lista.add(foto);

            }
            buscar.close();
            conexion.close();

        } catch (SQLException w) {
            System.out.println("Erro SQL" + w.getMessage());
        } catch (Exception e) {
            System.out.println("Error al listar " + e.getMessage());
        }
        return lista;
    }

    @Override
    public ArrayList<FotografiaDto> listarImagenes(int id) {
        ArrayList<FotografiaDto> lista = new ArrayList<>();

        try {
            Connection conexion = Conexion.getConexion();
            String query = "SELECT * FROM FOTOGRAFIA WHERE DEPARTAMENTO_ID_DEPARTAMENTO=?";
            PreparedStatement buscar = conexion.prepareStatement(query);
            buscar.setInt(1, id);
            ResultSet rs = buscar.executeQuery();

            while (rs.next()) {

                FotografiaDto foto = new FotografiaDto();
                DepartamentoDto depto = new DepartamentoDto();

                foto.setId_fotografia(rs.getInt("id_fotografia"));
                foto.setImagen(rs.getString("url_fotografia"));
                depto.setId_depto(rs.getInt("departamento_id_departamento"));
                foto.setDepto_foto(depto);

                lista.add(foto);

            }
            buscar.close();
            conexion.close();

        } catch (SQLException w) {
            System.out.println("Erro SQL" + w.getMessage());
        } catch (Exception e) {
            System.out.println("Error al listar " + e.getMessage());
        }
        return lista;
    }

}
