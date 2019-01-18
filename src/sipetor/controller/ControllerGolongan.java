package sipetor.controller;

import java.util.List;
import sipetor.model.query.QueryGolongan;
import sipetor.models.Golongan;

public class ControllerGolongan {
    private QueryGolongan queryGolongan = new QueryGolongan();
    
    public List<Golongan> getAllData(){
        return queryGolongan.getAllGolongan();
    }
    
    public boolean insertGolongan(byte id, String name){
        if(id==0 && name.isEmpty()){
            return false;
        } else{
            Golongan gol = new Golongan(id,name);
            return queryGolongan.insert(gol);
        }
    }
    
    public boolean updateGolongan(byte id, String name){
        if(id==0 && name.isEmpty()){
            return false;
        } else{
            Golongan gol = new Golongan(id,name);
            return queryGolongan.update(gol);
        }
    }
    
    public boolean deleteGolongan(byte id){
        return queryGolongan.delete(id);
    }
    
    public int generateID(){
        return queryGolongan.generateID();
    }
}
