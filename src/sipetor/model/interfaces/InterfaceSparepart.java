package sipetor.model.interfaces;

import java.util.List;
import sipetor.models.Sparepart;

/**
 *
 * @author Rizki Ramadhan
 */

public interface InterfaceSparepart {
    public boolean insert(Sparepart data);
    public boolean update(Sparepart data);
    public boolean delete(int id_sparepart);
    public int generateID();
    
    public List<Sparepart> getAllSparepart();
    
    public Sparepart getOneSparepartByID(int id_sparepart);
    
    public List<Sparepart> getAllSparepartByName(String nama_sparepart);
}
