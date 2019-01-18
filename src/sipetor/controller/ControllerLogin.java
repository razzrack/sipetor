package sipetor.controller;

import java.util.List;
import sipetor.model.query.QueryLogin;
import sipetor.models.Login;

public class ControllerLogin {
    private QueryLogin queryLogin = new QueryLogin();
    
    public boolean insertLogin(Login data){
        return queryLogin.insert(data);   
    }
    
    public boolean updateLogin(Login data){
        return queryLogin.update(data);   
    }
    
    public boolean deleteLogin(String nik){
        return queryLogin.delete(nik);   
    }
    
    public List<Login> getAllData(){
        return queryLogin.getAllLogin();
    }
    
    public Login getUsername(String username){
        return queryLogin.getUsername(username);
    }
    
    public boolean LoginisMatch(String username, String password){
        return queryLogin.LoginisMatch(username, password);
    }
}
