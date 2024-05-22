package com.android.ecotech;

import java.util.ArrayList;
import java.util.List;

public class UserInfo {
    private static UserInfo instance;
    private String username;
    private String password;
    private String radioButtonResponse;
    private String mail;
    private List<String> selectedItems;

    private UserInfo() {
        selectedItems = new ArrayList<>();
    }

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

    public List<String> getSelectedItems() {
        return selectedItems;
    }

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

    public void setSelectedItems(List<String> selectedItems) {
        this.selectedItems = selectedItems;
    }

    public void addSelectedItem(String item) {
        if (!this.selectedItems.contains(item)) {
            this.selectedItems.add(item);
        }
    }

    public void removeSelectedItem(String item) {
        this.selectedItems.remove(item);
    }
}
