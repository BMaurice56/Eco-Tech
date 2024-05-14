package com.android.ecotech;

public class UserInfo {
    private static UserInfo instance;
    private String username;
    private String password;
    private String radioButtonResponse;
    private String mail;

    private UserInfo() {}

    public static synchronized UserInfo getInstance() {
        if (instance == null) {
            instance = new UserInfo();
        }
        return instance;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() { return password; }

    public String getRadioButtonResponse() {
        return radioButtonResponse;
    }

    public String getMail() { return mail; }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRadioButtonResponse(String radioButtonResponse) {
        this.radioButtonResponse = radioButtonResponse;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
