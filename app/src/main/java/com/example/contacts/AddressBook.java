package com.example.contacts;

import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AddressBook {
    protected List<BaseContact> theList;

    public AddressBook(List<BaseContact> theList) { this.theList = new ArrayList<>(); }


    public AddressBook() {
        String[] startingNames = { "Isaiah" };
        this.theList = new ArrayList();
        BaseContact p = new BaseContact();
        for (int i = 0; i<startingNames.length; i++){
            theList.add(p);
        }

    }

    public List<BaseContact > getTheList() {
        return theList;
    }

    public void setTheList(List<BaseContact> theList) {
        this.theList = theList;
    }

    public <T extends BaseContact> void addOne(T contact) {
        this.theList.add(contact);
    }

    @Override
    public String toString(){
        return "People List{" +
                "theList = " + theList +
                "}";
    }
}
