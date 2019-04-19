package com.example.contacts;

public class BusinessContact extends BaseContact {
    private String businessName;
    private String hours;
    private String url;

    public BusinessContact(String fName, String lName, String streetName, String city, String state, String postalCode, String country,
                           String phoneNumber, String pictureNumber, String email, String businessName, String hours, String url) {
        super(fName, lName, streetName, city, state, postalCode, country, phoneNumber, pictureNumber, email);
        this.businessName = businessName;
        this.hours = hours;
        this.url = url;
    }

    public BusinessContact() {
        super("Business", "Contact", "Another street", "Phoenix", "AZ", "85032", "United States", "602-448-5118", "thispicture.jpg", "nobody@gmail.com");
        this.businessName = "Nothing Inc.";
        this.hours = "MTWThF 8:00 AM - 4:00 PM";
        this.url = "business.com";
    }

    public String getBusinessName() {
        return businessName;
    }
    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }
    public String getHours() {
        return hours;
    }
    public void setHours(String hours) {
        this.hours = hours;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }

    public int compareTo(BaseContact b) {
        int compareResult = this.lName.compareTo(b.lName);

        // if names match then return true

        if (compareResult == 0) {
            return this.fName.compareTo(b.fName);
        } else {
            return compareResult;
        }

        // if this = b return 0

        // if this > b return 1
    }

    public String toString() {
        System.out.println();
        String stringReturn = "----------Business Contact--------------\n"
                + "Name = " + super.fName + " " + super.lName + " \n"
                + "Street = " + super.streetName + "\n"
                + "City = " + super.city + " State = " + super.state + "\n"
                + "Zip Code = " + super.postalCode + " Country = " + super.country + "\n"
                + "Phone #: = " + super.phoneNumber + " Email = " + super.email + "Picture= " + super.pictureNumber + "\n"
                + "Business = " + this.businessName + " Business Hours = " + this.hours + " \n"
                + "Website = " + this.url + "\n";

        return stringReturn;
    }
}
