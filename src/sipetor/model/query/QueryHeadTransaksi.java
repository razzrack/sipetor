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
import sipetor.model.interfaces.InterfaceHeadTransaksi;
import sipetor.models.HeadTransaksi;

/**
 *
 * @author Rizki Ramadhan
 */
public class QueryHeadTransaksi implements InterfaceHeadTransaksi{
    private Connection conn = SQLConnection.getConnection();

    @Override
    public boolean insert(HeadTransaksi data) {
       String sql = "INSERT INTO head_trans_penjualan values (?,?,?,?,?,?)";
        try{
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setString(1, data.getId_transaksi());
            statement.setString(2, data.getId_karyawan());
            statement.setString(3, data.getTnkb_pelanggan());
            statement.setString(4, data.getTanggal_transaksi());
            statement.setInt(5, data.getPembayaran());
            statement.setInt(6, data.getSub_total());
            int row = statement.executeUpdate();
            if (row >0){
                return true;
            }
            statement.close();
        }  catch (SQLException ex){
            Logger.getLogger(HeadTransaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false; 
    }

    @Override
    public boolean update(HeadTransaksi data) {
        String sql = "UPDATE head_trans_penjualan SET pembayaran=?, "
                + "sub_total=?, tanggal_transaksi=? "
                + "WHERE id_transaksi=? AND id_karyawan=? AND tnkb_pelanggan=?";
        try{
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setInt(1, data.getPembayaran());
            statement.setInt(2, data.getSub_total());
            statement.setString(3, data.getTanggal_transaksi());
            statement.setString(4, data.getId_transaksi());
            statement.setString(5, data.getId_karyawan());
            statement.setString(6, data.getTnkb_pelanggan());
            int row = statement.executeUpdate();
            if (row >0){
                return true;
            }
            statement.close();
        }  catch (SQLException ex){
            Logger.getLogger(HeadTransaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean delete(String id_transaksi) {
        String sql = "DELETE FROM head_trans_penjualan where id_transaksi=?";
        try{
            PreparedStatement statement = conn.prepareStatement(sql);
           
            statement.setString(1, id_transaksi);
            int row = statement.executeUpdate();
            if (row >0){
                return true;
            }
            statement.close();
        }  catch (SQLException ex){
            Logger.getLogger(HeadTransaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public List<HeadTransaksi> getAllHeadTransaksi() {
        List<HeadTransaksi> listHeadTransaksi = new ArrayList();
        String sql = "SELECT * FROM head_trans_penjualan";
        try {
            if (SQLConnection.getConnection()==null){
                return null;
            }else {
                PreparedStatement statement = conn.prepareStatement(sql);
                
                ResultSet rs = statement.executeQuery();
                while (rs.next()){
                    HeadTransaksi ht = new HeadTransaksi(
                            rs.getString(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getInt(5),
                            rs.getInt(6)
                    );        
                    listHeadTransaksi.add(ht);
                }
                statement.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(QueryHeadTransaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listHeadTransaksi;
    }

    @Override
    public HeadTransaksi getOneHeadTransaksiByID(String id_transaksi) {
        HeadTransaksi output = null;
        String sql = "Select * from head_trans_penjualan where id_transaksi=?";
        try {
            if (SQLConnection.getConnection()==null){
                return null;
            }else{
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, id_transaksi);
                
                ResultSet rs = statement.executeQuery();
                while (rs.next()){
                    output = new HeadTransaksi(
                            rs.getString(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getInt(5),
                            rs.getInt(6)
                    );
                }
                statement.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(HeadTransaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return output;
    }

    @Override
    public List<HeadTransaksi> getAllHeadTransaksiByNama(String nama_pelanggan) {
        List<HeadTransaksi> listHeadTransaksi = new ArrayList<>();
        String sql = "Select a.*,b.nama_pelanggan "
                + "from head_trans_penjualan a "
                + "JOIN pelanggan b "
                + "ON a.tnkb_pelanggan = b.tnkb "
                + "WHERE b.nama_pelanggan like %?%";
        try {
            if (SQLConnection.getConnection()==null){
                return null;
            }else{
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, nama_pelanggan);
                
                ResultSet rs = statement.executeQuery();
                while (rs.next()){
                    HeadTransaksi p = new HeadTransaksi(
                            rs.getString(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getInt(5),
                            rs.getInt(6)
                    );
                    listHeadTransaksi.add(p);
                }
                statement.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(HeadTransaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listHeadTransaksi;
    }

    @Override
    public String generateID() {
        String id_transaksi = "";
        String sql = "EXEC genIDTransaksi";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                id_transaksi = rs.getString(1);
            }
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(HeadTransaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id_transaksi;
    }
}
