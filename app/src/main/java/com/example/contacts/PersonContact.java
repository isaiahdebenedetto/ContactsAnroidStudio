package com.example.contacts;

public class PersonContact extends BaseContact {

    private String Date;
    private String Desc;

    public PersonContact(String fName, String lName, String streetName, String city, String state, String postalCode,
                         String country, String phoneNumber, String photoName, String email, String date, String desc) {
        super(fName, lName, streetName, city, state, postalCode, country, phoneNumber, photoName, email);
        Date = date;
        Desc = desc;
    }


    public PersonContact() {
        super("Frank", "Green", "Acoma", "Phoenix", "AZ", "85032", "United States", "602-448-5119", "Frank.jpg", "frank@gmail.com");
        this.Date = "09/01/98";
        this.Desc = "A wanna be";
    }


    public String getDate() {
        return Date;
    }


    public void setDate(String date) {
        Date = date;
    }


    public String getDesc() {
        return Desc;
    }


    public void setDesc(String desc) {
        Desc = desc;
    }


    public int compareTo(BaseContact p) {
        int compareResult = this.lName.compareTo(p.lName);

        // if names match then return true

        if (compareResult == 0) {
            return this.fName.compareTo(p.fName);
        } else {
            return compareResult;
        }

        // if this = p return 0

        // if this > p return 1
    }

    public String toString() {
        System.out.println();
        String stringReturn = "----------Person Contact--------------\n"
                + "Name = " + super.fName + " " + super.lName + " \n"
                + "Street = " + super.streetName + "\n"
                + "City = " + super.city + " State = " + super.state + "\n"
                + "Zip Code = " + super.postalCode + " Country = " + super.country + "\n"
                + "Phone #: = " + super.phoneNumber + " Email = " + super.email + "\n"
                + "Picture= " + super.pictureNumber + " Birthday = " + this.Date + "\n"
                + "Description = " + this.Desc + "\n";

        return stringReturn;
    }
}
