package sipetor.model.interfaces;

import java.util.List;
import sipetor.models.HeadTransaksi;

/**
 *
 * @author Rizki Ramadhan
 */
public interface InterfaceHeadTransaksi {
    public boolean insert(HeadTransaksi data);
    public boolean update(HeadTransaksi data);
    public boolean delete(String id_transaksi);
    public String generateID();
    
    public List<HeadTransaksi> getAllHeadTransaksi();
    
    public HeadTransaksi getOneHeadTransaksiByID(String id_transaksi);
    
    public List<HeadTransaksi> getAllHeadTransaksiByNama(String nama_pelanggan);
}
