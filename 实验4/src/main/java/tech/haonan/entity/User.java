package tech.haonan.entity;

/**
 * @Author: yhn
 * @Date: 2020/9/24 23:17
 * @Description:
 **/
public class User {
    private int id;
    private String username;
    private String password;

    public User() {
        id = -1;
        username = "";
        password = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
