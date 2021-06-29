package Model;

public class LoginResult {
    private Boolean uyedurum;
    private String password;
    private String id;
    private String username;
    private String email;
    private String statu;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatu() {
        return statu;
    }

    public void setStatu(String statu) {
        this.statu = statu;
    }

    public Boolean getUyedurum() {
        return uyedurum;
    }

    public void setUyedurum(Boolean uyedurum) {
        this.uyedurum = uyedurum;
    }

    @Override
    public String toString() {
        return "LoginResult{" +
                "uyedurum=" + uyedurum +
                ", password='" + password + '\'' +
                ", id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", statu='" + statu + '\'' +
                '}';
    }
}
