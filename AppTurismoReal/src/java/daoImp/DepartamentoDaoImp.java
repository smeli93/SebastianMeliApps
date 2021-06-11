package daoImp;

import dao.DepartamentoDao;
import dto.ComunaDto;
import dto.DepartamentoDto;
import java.util.ArrayList;
import sql.Conexion;
import java.sql.*;

public class DepartamentoDaoImp implements DepartamentoDao {

    @Override
    public ArrayList<DepartamentoDto> listarDepartamentos() {
        ArrayList<DepartamentoDto> lista = new ArrayList<>();
        try {
            Connection conexion = Conexion.getConexion();
            String query = "SELECT * FROM DEPARTAMENTO";
            PreparedStatement buscar = conexion.prepareStatement(query);
            ResultSet rs = buscar.executeQuery();
            while (rs.next()) {

                DepartamentoDto depto = new DepartamentoDto();
                ComunaDto comuna = new ComunaDto();

                depto.setId_depto(rs.getInt("id_departamento"));
                depto.setNumero_depto(rs.getString("numero_dep"));
                depto.setDireccion(rs.getString("direccion"));
                depto.setPiso(rs.getInt("piso"));
                depto.setValor(rs.getInt("valor"));
                depto.setCant_personas(rs.getInt("cant_personas"));
                depto.setCant_banos(rs.getInt("cant_baños"));
                depto.setCant_habitaciones(rs.getInt("cant_habitaciones"));
                depto.setCocina(rs.getBoolean("cocina"));
                depto.setEstacionamiento(rs.getBoolean("estacionamiento"));
                depto.setTv_cable(rs.getBoolean("tv_cable"));
                depto.setInternet(rs.getBoolean("internet"));
                depto.setCalefaccion(rs.getBoolean("calefaccion"));
                depto.setAccesible(rs.getBoolean("accesible"));
                depto.setEstado(rs.getBoolean("estado_dep"));
                comuna.setId_comuna(rs.getInt("comuna_id_comuna"));
                depto.setComuna_depto(comuna);

                lista.add(depto);

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
    public ArrayList<DepartamentoDto> buscarPorId(int id) {

        ArrayList<DepartamentoDto> lista = new ArrayList<>();
        try {
            Connection conexion = Conexion.getConexion();
            String query = "SELECT * FROM DEPARTAMENTO WHERE ID_DEPARTAMENTO=?";
            PreparedStatement buscar = conexion.prepareStatement(query);
            buscar.setInt(1, id);
            ResultSet rs = buscar.executeQuery();
            while (rs.next()) {

                DepartamentoDto depto = new DepartamentoDto();
                ComunaDto comuna = new ComunaDto();

                depto.setId_depto(rs.getInt("id_departamento"));
                depto.setNumero_depto(rs.getString("numero_dep"));
                depto.setDireccion(rs.getString("direccion"));
                depto.setPiso(rs.getInt("piso"));
                depto.setValor(rs.getInt("valor"));
                depto.setCant_personas(rs.getInt("cant_personas"));
                depto.setCant_banos(rs.getInt("cant_baños"));
                depto.setCant_habitaciones(rs.getInt("cant_habitaciones"));
                depto.setCocina(rs.getBoolean("cocina"));
                depto.setEstacionamiento(rs.getBoolean("estacionamiento"));
                depto.setTv_cable(rs.getBoolean("tv_cable"));
                depto.setInternet(rs.getBoolean("internet"));
                depto.setCalefaccion(rs.getBoolean("calefaccion"));
                depto.setAccesible(rs.getBoolean("accesible"));
                depto.setEstado(rs.getBoolean("estado_dep"));
                comuna.setId_comuna(rs.getInt("comuna_id_comuna"));
                depto.setComuna_depto(comuna);

                lista.add(depto);

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
    public ArrayList<DepartamentoDto> buscarPorRegion(int region) {
        ArrayList<DepartamentoDto> lista1 = new ArrayList<DepartamentoDto>();
        try {
            Connection conexion = Conexion.getConexion();
            String query = "SELECT * FROM DEPARTAMENTO WHERE USUARIO_RUT_USUARIO=?";
            PreparedStatement buscar = conexion.prepareStatement(query);
            buscar.setInt(1, region);

            ResultSet rs = buscar.executeQuery();

            while (rs.next()) {

                DepartamentoDto dto = new DepartamentoDto();
                dto.setId_depto(rs.getInt(""));
                dto.setNumero_depto(rs.getString(""));
                dto.setValor(rs.getInt(""));
                dto.setDireccion(rs.getString(""));
                //ver el tema de la region
                //dto.setComuna_depto();         
                lista1.add(dto);

            }
            buscar.close();
            conexion.close();
        } catch (SQLException w) {
            System.out.println("Error SQL al buscar tipo Usuarios " + w.getMessage());
        } catch (Exception e) {
            System.out.println("Error al buscar Tipode usuarios " + e.getMessage());
        }
        return lista1;
    }

    @Override
    public ArrayList<DepartamentoDto> listarDepartamentosOferta() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<DepartamentoDto> listarDepartamentosPremium() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String retornaDireccion(int id) {
        String aux = "";
        try {
            Connection conexion = Conexion.getConexion();
            String query = "SELECT DIRECCION FROM DEPARTAMENTO WHERE ID_DEPARTAMENTO=?";
            PreparedStatement buscar = conexion.prepareStatement(query);
            buscar.setInt(1, id);
            ResultSet rs = buscar.executeQuery();
            while (rs.next()) {
                aux = rs.getString("direccion");
            }
            buscar.close();
            conexion.close();

        } catch (SQLException w) {
            System.out.println("Erro SQL" + w.getMessage());
        } catch (Exception e) {
            System.out.println("Error al listar " + e.getMessage());
        }
        return aux;
    }

}
