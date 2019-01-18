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
import sipetor.model.interfaces.InterfaceDetailTransaksi;
import sipetor.models.DetailTransaksi;

/**
 *
 * @author Rizki Ramadhan
 */
public class QueryDetailTransaksi implements InterfaceDetailTransaksi{
    private Connection conn = SQLConnection.getConnection();

    @Override
    public boolean insert(DetailTransaksi data) {
        String sql = "INSERT INTO detail_trans_penjualan values (?,?,?,?,?)";
        try{
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setInt(1, data.getId_reg());
            statement.setString(2, data.getId_transaksi());
            statement.setString(3, data.getId_sparepart());
            statement.setInt(4, data.getJumlah_beli());
            statement.setInt(5, data.getTotal_beli());
            int row = statement.executeUpdate();
            if (row > 0){
                return true;
            }
            statement.close();
        }  catch (SQLException ex){
            Logger.getLogger(DetailTransaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false; 
    }

    @Override
    public boolean update(DetailTransaksi data) {
        String sql = "UPDATE detail_trans_penjualan "
                + "SET jumlah_beli=?, total_beli=? "
                + "WHERE id_transaksi=? AND id_sparepart=?";
        try{
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setInt(1, data.getJumlah_beli());
            statement.setInt(2, data.getTotal_beli());
            statement.setString(3, data.getId_transaksi());
            statement.setString(4, data.getId_sparepart());
            int row = statement.executeUpdate();
            if (row >0){
                return true;
            }
            statement.close();
        }  catch (SQLException ex){
            Logger.getLogger(DetailTransaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean delete(String id_transaksi, String id_sparepart) {
        String sql = "DELETE FROM detail_trans_penjualan "
                + "where id_transaksi=? AND id_sparepart=?";
        try{
            PreparedStatement statement = conn.prepareStatement(sql);
           
            statement.setString(1, id_transaksi);
            statement.setString(2, id_sparepart);
            int row = statement.executeUpdate();
            if (row >0){
                return true;
            }
            statement.close();
        }  catch (SQLException ex){
            Logger.getLogger(DetailTransaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public List<DetailTransaksi> getAllDetailTransaksi() {
        List<DetailTransaksi> listDetailTransaksi = new ArrayList();
        String sql = "SELECT * FROM detail_trans_penjualan";
        try {
            if (SQLConnection.getConnection()==null){
                return null;
            }else {
                PreparedStatement statement = conn.prepareStatement(sql);
                
                ResultSet rs = statement.executeQuery();
                while (rs.next()){
                    DetailTransaksi dt = new DetailTransaksi(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getInt(4),
                            rs.getInt(5)
                    );        
                    listDetailTransaksi.add(dt);
                }
                statement.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(QueryHeadTransaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listDetailTransaksi;
    }

    @Override
    public DetailTransaksi getOneDetailTransaksiByID(String id_transaksi) {
        DetailTransaksi output = null;
        String sql = "Select * from detail_trans_penjualan where id_transaksi=?";
        try {
            if (SQLConnection.getConnection()==null){
                return null;
            }else{
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, id_transaksi);
                
                ResultSet rs = statement.executeQuery();
                while (rs.next()){
                    output = new DetailTransaksi(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getInt(4),
                            rs.getInt(5)
                    );
                }
                statement.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DetailTransaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return output;
    }

    @Override
    public List<DetailTransaksi> getAllDetailTransaksiByID(String id_transaksi) {
        List<DetailTransaksi> listDetailTransaksi = new ArrayList<>();
        String sql = "SELECT * FROM detail_trans_penjualan "
                + "WHERE id_transaksi like %?%";
        try {
            if (SQLConnection.getConnection()==null){
                return null;
            }else{
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, id_transaksi);
                
                ResultSet rs = statement.executeQuery();
                while (rs.next()){
                    DetailTransaksi p = new DetailTransaksi(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getInt(4),
                            rs.getInt(5)
                    );
                    listDetailTransaksi.add(p);
                }
                statement.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DetailTransaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listDetailTransaksi;
    }
    
    @Override
    public int generateID() {
        int id_detail = 0;
        String sql = "EXEC genIDDetail";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                id_detail = rs.getInt(1);
            }
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(DetailTransaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id_detail;
    }

    @Override
    public int generateIDReg() {
        int id_registrasi = 0;
        String sql = "EXEC getFaktur @id_transaksi = ?";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                id_registrasi = rs.getInt(1);
            }
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(DetailTransaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id_registrasi;
    }
}
