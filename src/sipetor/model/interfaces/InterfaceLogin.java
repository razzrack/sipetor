package sipetor.model.interfaces;

import java.util.List;
import sipetor.models.Login;

public interface InterfaceLogin {
    public boolean insert(Login data);
    public boolean update(Login data);
    public boolean delete(String nik);
    
    public List<Login> getAllLogin();
    public Login getUsername(String username);
    public boolean LoginisMatch(String username, String password);
}
