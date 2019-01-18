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
import sipetor.model.interfaces.InterfaceLogin;
import sipetor.models.Login;

public class QueryLogin implements InterfaceLogin{
    private Connection conn = SQLConnection.getConnection();

    @Override
    public boolean insert(Login l) {
        String sql = "INSERT INTO login values (?,?,?)";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setString(1, l.getNik());
            statement.setString(2, l.getUsername());
            statement.setString(3, l.getPassword());
            
            int row = statement.executeUpdate();
            if (row > 0) {
                return true;
            }
        } catch (SQLException ex) {
           Logger.getLogger(QueryLogin.class.getName()).log(Level.SEVERE, null, ex);
       }
       return false;
    }

    @Override
    public boolean update(Login l) {
        String sql = "UPDATE login SET password=?"
                + " WHERE nik=? AND username like ?";
        try{
            PreparedStatement statement = conn.prepareStatement(sql);
           
            statement.setString(1, l.getPassword());
            statement.setString(2, l.getNik());
            statement.setString(3, l.getUsername());
            int row = statement.executeUpdate();
            if (row > 0){
                return true;
            }
            statement.close();
        }  catch (SQLException ex){
            Logger.getLogger(QueryLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean delete(String nik) {
        String sql = "DELETE FROM login where nik=?";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setString(1, nik);
            int row = statement.executeUpdate();
            if(row > 0){
                return true;
            }
            statement.close();
        } catch (SQLException ex) {
           Logger.getLogger(QueryKaryawan.class.getName()).log(Level.SEVERE, null, ex);
       }
       return false;
    }

    @Override
    public boolean LoginisMatch(String username, String password) {
    String sql = "SELECT * from login"
            + " WHERE username like ? AND password like ?";
        try {
            if (SQLConnection.getConnection()==null){
                return false;
            }
            else{
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);
            
            ResultSet rs = statement.executeQuery();
                while(rs.next()){
                    return true;
                }
                statement.close();
            }
        } catch (SQLException ex) {
           Logger.getLogger(QueryKaryawan.class.getName()).log(Level.SEVERE, null, ex);
       }
       return false;
    }

    @Override
    public List<Login> getAllLogin() {
       List<Login> listLogin = new ArrayList<>();
        String sql = "Select * from login";
        try {
            if (SQLConnection.getConnection()==null){
                return null;
            }else{
                PreparedStatement statement = conn.prepareStatement(sql);
                
                ResultSet rs = statement.executeQuery();
                while (rs.next()){
                    Login l = new Login(
                            rs.getString(1),
                            rs.getString(2),
                            rs.getString(3)
                    );
                    listLogin.add(l);
                }
            }
        } catch (SQLException ex) {
           Logger.getLogger(QueryKaryawan.class.getName()).log(Level.SEVERE, null, ex);
       }
       return listLogin; 
    }

    @Override
    public Login getUsername(String username) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
