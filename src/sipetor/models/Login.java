package sipetor.models;

public class Login {
    private String nik;
    private String username;
    private String password;
    
    public Login(String nik, String username, String password){
        this.nik = nik;
        this.username = username;
        this.password = password;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
