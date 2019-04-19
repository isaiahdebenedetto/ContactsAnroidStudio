package com.example.contacts;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseContact {
    String fName, lName, streetName, city, state, postalCode, country, phoneNumber, pictureNumber, email;


    public BaseContact(String fName, String lName, String streetName, String city, String state,
                       String postalCode, String country, String phoneNumber, String pictureNumber, String email) {
        this.fName = fName;
        this.lName = lName;
        this.streetName = streetName;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.country = country;
        this.phoneNumber = phoneNumber;
        this.pictureNumber = pictureNumber;
        this.email = email;
    }

    public BaseContact() {
        this.fName = "No First Name";
        this.lName = "";
        this.streetName = "123 Main St";
        this.city = "Omaha";
        this.state = "NE";
        this.postalCode = "50921";
        this.country = "United States";
        this.phoneNumber = "422-321-9325";
        this.pictureNumber = "mypicture.jpg";
        this.email = "nobody@gmail.com";
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPictureNumber() {
        return pictureNumber;
    }

    public void setPictureNumber(String photoName) {
        this.pictureNumber = photoName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person{ " + " First Name= " + fName + ", Last Name= " + lName + ", Street Name= " + streetName + ", City= " + city
                + ", State= " + state + ", Zip Code= " + postalCode + ", Country= " + country + ", Phone Number = " + phoneNumber
                + ", Photo Name= " + pictureNumber + ", Email= " + email + " }";

    }
}
