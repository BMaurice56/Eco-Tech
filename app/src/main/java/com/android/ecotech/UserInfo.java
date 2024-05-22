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
        // Initialisation de la liste des types d'appareils
        deviceTypes = new ArrayList<>();
    }

    public static synchronized UserInfo getInstance() {
        // Création de l'instance si elle n'existe pas déjà
        if (instance == null) {
            instance = new UserInfo();
        }
        //Retourne l'instance unique
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

    // Méthodes pour ajouter et supprimer des types d'appareils


    // Ajoute un type d'appareil à la liste s'il n'y est pas déjà
    public void addDeviceType(String deviceType) {
        if (!this.deviceTypes.contains(deviceType)) {
            this.deviceTypes.add(deviceType);
        }
    }
    // Supprime un type d'appareil de la liste
    public void removeDeviceType(String deviceType) {
        this.deviceTypes.remove(deviceType);
    }
}
