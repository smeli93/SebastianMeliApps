package daoImp;

import dao.PersonaDao;
import dto.PersonaDto;
import java.util.ArrayList;
import sql.Conexion;
import java.sql.*;
import java.sql.Date;

public class PersonaDaoImp implements PersonaDao {

    @Override
    public boolean validarRut(String rut) {
        boolean resp = false;
        try {
            Connection conexion = Conexion.getConexion();
            String query = "SELECT * FROM PERSONA WHERE RUT_PERSONA=?";
            PreparedStatement valida = conexion.prepareStatement(query);
            valida.setString(1, rut);
            ResultSet rs = valida.executeQuery();

            if (rs.next()) {
                resp = true;
            } else {
                resp = false;
            }

        } catch (SQLException w) {
            System.out.println("Error SQL al validar rut " + w.getMessage());
        } catch (Exception e) {
            System.out.println("Error al validar rut" + e.getMessage());
        }
        return resp;
    }

    @Override
    public boolean modificar(PersonaDto dto) {
        try {
            Connection conexion = Conexion.getConexion();
            String query = "UPDATE PERSONA SET PRIMER_NOMBRE=?,SEGUNDO_NOMBRE=?, "
                    + "APELLIDO_PATERNO=?, APELLIDO_MATERNO=?, FECHA_NACIMIENTO=?, TELEFONO=?, "
                    + "DIRECCION=? WHERE RUT_PERSONA=?";
            PreparedStatement mod = conexion.prepareStatement(query);
            mod.setString(1, dto.getPrimer_nombre());
            mod.setString(2, dto.getSegundo_nombre());
            mod.setString(3, dto.getAp_paterno());
            mod.setString(4, dto.getAp_materno());
            mod.setDate(5, new java.sql.Date(dto.getFecha_nacimiento().getTime()));
            mod.setInt(6, dto.getTelefono());
            mod.setString(7, dto.getDireccion());
            mod.setString(5, dto.getRut());
            mod.execute();
            mod.close();
            conexion.close();
            return true;
        } catch (SQLException w) {
            System.out.println("ERROR SQL AL MODIFICAR " + w.getMessage());
        } catch (Exception e) {
            System.out.println("ERROR A MODIFICAR " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean registrar(PersonaDto dto) {
        try {
            Connection conexion = Conexion.getConexion();
            String query = "INSERT INTO PERSONA(RUT_PERSONA, PRIMER_NOMBRE, SEGUNDO_NOMBRE, "
                    + "APELLIDO_PATERNO, APELLIDO_MATERNO, FECHA_NACIMIENTO, TELEFONO, DIRECCION) VALUES(?,?,?,?,?,?,?,?)";

            PreparedStatement ingresar = conexion.prepareStatement(query);

            ingresar.setString(1, dto.getRut());
            ingresar.setString(2, dto.getPrimer_nombre());
            ingresar.setString(3, dto.getSegundo_nombre());
            ingresar.setString(4, dto.getAp_paterno());
            ingresar.setString(5, dto.getAp_materno());
            ingresar.setDate(6, (Date) dto.getFecha_nacimiento());
            ingresar.setInt(7, dto.getTelefono());
            ingresar.setString(8, dto.getDireccion());
            ingresar.execute();
            ingresar.close();
            conexion.close();
            return true;
        } catch (SQLException w) {
            System.out.println("Error SQL al agregar " + w.getMessage());
        } catch (Exception e) {
            System.out.println("Error al agregar " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean eliminar(PersonaDto dto) {
        try {
            Connection conexion = Conexion.getConexion();
            String query1 = "DELETE FROM PERSONA WHERE RUT_PERSONA=?";
            PreparedStatement del = conexion.prepareStatement(query1);
            del.setString(1, dto.getRut());
            del.execute();
            del.close();
            conexion.close();

            return true;

        } catch (SQLException w) {
            System.out.println("Error SQL al eliminar " + w.getMessage());
        } catch (Exception e) {
            System.out.println("Error al eliminar " + e.getMessage());
        }
        return false;
    }

}
