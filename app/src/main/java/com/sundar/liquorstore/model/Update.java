package com.sundar.liquorstore.model;

public class Update {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String conpassword;
    private String image;

    public Update(String firstName, String lastName, String username, String password, String conpassword, String image) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.conpassword = conpassword;
        this.image = image;
    }
    public Update(String firstName, String lastName, String username, String image) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.image = image;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getConpassword() {
        return conpassword;
    }

    public void setConpassword(String conpassword) {
        this.conpassword = conpassword;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
