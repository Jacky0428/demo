package com.example.demo.store.command;

public class StoreCreateCommand {
    /**
     * The name of the store.
     */
    private String name;

    /**
     * The address of the store.
     */
    private String address;

    /**
     * The first phone number of the store.
     */
    private String phone1;

    /**
     * The second phone number of the store.
     */
    private String phone2;

    /**
     * The description of the store.
     */
    private String description;

    /**
     * The website of the store.
     */
    private String websiteUrl;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }
}
