package sipetor.model.interfaces;

import java.util.List;
import sipetor.models.Pelanggan;

/**
 *
 * @author Rizki Ramadhan
 */

public interface InterfacePelanggan {
    public boolean insert(Pelanggan data);
    public boolean update(Pelanggan data);
    public boolean delete(String tnkb_pelanggan);
    
    public List<Pelanggan> getAllPelanggan();
    
    public Pelanggan getOnePelangganByTNBK(String tnkb_pelanggan);
    
    public List<Pelanggan> getAllPelangganByName(String nama_pelanggan);
}
