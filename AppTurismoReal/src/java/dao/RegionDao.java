
package dao;
import java.util.ArrayList;
import dto.RegionDto;

public interface RegionDao {
    public ArrayList<String> listarNombreRegion();
    public int RegionToId(String region);
    public String idToRegion(int id);

}
