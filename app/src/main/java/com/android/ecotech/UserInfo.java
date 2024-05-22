package com.android.ecotech;

import java.util.ArrayList;
import java.util.List;

public class UserInfo {
    private static UserInfo instance;
    private String username;
    private String password;
    private String radioButtonResponse;
    private String mail;
    private String companyNature;
    private String numberOfDevices;
    private List<String> deviceTypes;
    private String recyclingFrequency;
    private boolean collectionServiceNeeded;
    private String additionalComments;

    private UserInfo() {
        deviceTypes = new ArrayList<>();
    }

    public static synchronized UserInfo getInstance() {
        if (instance == null) {
            instance = new UserInfo();
        }
        return instance;
    }

    // Getters et Setters pour tous les champs

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

    public String getRadioButtonResponse() {
        return radioButtonResponse;
    }

    public void setRadioButtonResponse(String radioButtonResponse) {
        this.radioButtonResponse = radioButtonResponse;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getCompanyNature() {
        return companyNature;
    }

    public void setCompanyNature(String companyNature) {
        this.companyNature = companyNature;
    }

    public String getNumberOfDevices() {
        return numberOfDevices;
    }

    public void setNumberOfDevices(String numberOfDevices) {
        this.numberOfDevices = numberOfDevices;
    }

    public List<String> getDeviceTypes() {
        return deviceTypes;
    }

    public void setDeviceTypes(List<String> deviceTypes) {
        this.deviceTypes = deviceTypes;
    }

    public String getRecyclingFrequency() {
        return recyclingFrequency;
    }

    public void setRecyclingFrequency(String recyclingFrequency) {
        this.recyclingFrequency = recyclingFrequency;
    }

    public boolean isCollectionServiceNeeded() {
        return collectionServiceNeeded;
    }

    public void setCollectionServiceNeeded(boolean collectionServiceNeeded) {
        this.collectionServiceNeeded = collectionServiceNeeded;
    }

    public String getAdditionalComments() {
        return additionalComments;
    }

    public void setAdditionalComments(String additionalComments) {
        this.additionalComments = additionalComments;
    }

    // Methods to add and remove device types
    public void addDeviceType(String deviceType) {
        if (!this.deviceTypes.contains(deviceType)) {
            this.deviceTypes.add(deviceType);
        }
    }

    public void removeDeviceType(String deviceType) {
        this.deviceTypes.remove(deviceType);
    }
}
