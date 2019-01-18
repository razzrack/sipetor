package sipetor.model.query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sipetor.connection.SQLConnection;
import sipetor.model.interfaces.InterfaceSparepart;
import sipetor.models.Sparepart;

/**
 *
 * @author Rizki Ramadhan
 */
public class QuerySparepart implements InterfaceSparepart{
    private Connection conn = SQLConnection.getConnection();

    @Override
    public boolean insert(Sparepart s) {
        String sql = "INSERT into sparepart values(?,?,?,?)";
        try{
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setInt(1, s.getId_sparepart());
            statement.setString(2, s.getNama_sparepart());
            statement.setInt(3, s.getHarga_sparepart());
            statement.setInt(4, s.getStock_sparepart());
            int row = statement.executeUpdate();
            if (row >0){
                return true;
            }
            statement.close();
        }  catch (SQLException ex){
            Logger.getLogger(Sparepart.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean update(Sparepart s) {
        String sql = "UPDATE sparepart SET nama_sparepart=?,"
                + " harga_sparepart=?, stock_sparepart=?"
                + " WHERE id_sparepart=?";
        try{
            PreparedStatement statement = conn.prepareStatement(sql);
           
            statement.setString(1, s.getNama_sparepart());
            statement.setInt(2, s.getHarga_sparepart());
            statement.setInt(3, s.getStock_sparepart());
            statement.setInt(4, s.getId_sparepart());
            int row = statement.executeUpdate();
            if (row >0){
                return true;
            }
            statement.close();
        }  catch (SQLException ex){
            Logger.getLogger(Sparepart.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean delete(int id_sparepart) {
        String sql = "DELETE FROM sparepart where id_sparepart=?";
        try{
            PreparedStatement statement = conn.prepareStatement(sql);
           
            statement.setInt(1, id_sparepart);
            int row = statement.executeUpdate();
            if (row >0){
                return true;
            }
            statement.close();
        }  catch (SQLException ex){
            Logger.getLogger(Sparepart.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public int generateID() {
        int id_sparepart = 0;
        String sql = "EXEC genIDSparepart";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            
            ResultSet rs = statement.executeQuery();
                while (rs.next()){
                    id_sparepart = rs.getInt(1);
                }
                statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(QuerySparepart.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id_sparepart;
    }

    @Override
    public List<Sparepart> getAllSparepart() {
        List<Sparepart> listSparepart = new ArrayList();
        String sql = "SELECT * FROM sparepart";
        try {
            if (SQLConnection.getConnection()==null){
                return null;
            }else {
                PreparedStatement statement = conn.prepareStatement(sql);
                
                ResultSet rs = statement.executeQuery();
                while (rs.next()){
                    Sparepart s = new Sparepart(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getInt(3),
                            rs.getInt(4)
                    );        
                    listSparepart.add(s);
                }
                statement.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuerySparepart.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listSparepart;
    }

    @Override
    public Sparepart getOneSparepartByID(int id_sparepart) {
        Sparepart output = null;
        String sql = "SELECT * from sparepart where id_sparepart=?";
        try {
            if (SQLConnection.getConnection()==null){
                return null;
            }else {
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setInt(1, id_sparepart);
                
                ResultSet rs = statement.executeQuery();
                while (rs.next()){
                    output = new Sparepart(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getInt(3),
                            rs.getInt(4)
                    );
                }
                statement.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuerySparepart.class.getName()).log(Level.SEVERE, null, ex);
        }
        return output;
    }

    @Override
    public List<Sparepart> getAllSparepartByName(String nama_sparepart) {
        List<Sparepart> listSparepart = new ArrayList<>();
        String sql = "SELECT * FROM sparepart WHERE nama_sparepart like '%"+nama_sparepart+"%'";
        try {
            if (SQLConnection.getConnection()==null){
                return null;
            }else {
                PreparedStatement statement = conn.prepareStatement(sql);
                
                ResultSet rs = statement.executeQuery();
                while (rs.next()){
                    Sparepart s = new Sparepart(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getInt(3),
                            rs.getInt(4)
                    );        
                    listSparepart.add(s);
                }
                statement.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(QueryGolongan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listSparepart;
    }   
}
