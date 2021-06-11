package dao;

import java.util.ArrayList;
import dto.DepartamentoDto;

public interface DepartamentoDao {

    public ArrayList<DepartamentoDto> listarDepartamentos();

    public ArrayList<DepartamentoDto> listarDepartamentosOferta();

    public ArrayList<DepartamentoDto> listarDepartamentosPremium();

    public ArrayList<DepartamentoDto> buscarPorId(int id);

    public ArrayList<DepartamentoDto> buscarPorRegion(int region);

    public String retornaDireccion(int id);
    //public ArrayList<DepartamentoDto> buscarDeptosOferta();
}
