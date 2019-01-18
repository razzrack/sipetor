package sipetor.model.interfaces;

import java.util.List;
import sipetor.models.Golongan;

public interface InterfaceGolongan {
    public boolean insert(Golongan data);
    public boolean update(Golongan data);
    public boolean delete(byte id_golongan);
    public int generateID();
    
    public List<Golongan> getAllGolongan();
    
    public Golongan getOneGolonganByID(byte id_golongan);
    
    public List<Golongan> getAllGolonganByName(String nama_golongan);
}
