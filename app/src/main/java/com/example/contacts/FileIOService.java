package com.example.contacts;

import android.content.Context;

import android.content.Context;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
public class FileIOService {


    Context context;

    ObjectMapper om = new ObjectMapper();


    public FileIOService(Context context) { this.context = context; }

    public void writeList (AddressBook theList, String filename) {

        File path = context.getExternalFilesDir(null);

        File file = new File(path, filename);
        try {
            om.writerWithDefaultPrettyPrinter().writeValue(file, theList);
        } catch ( IOException e) {
            e.printStackTrace();
        }
    }

    public AddressBook readList (String filename) {
        File path = context.getExternalFilesDir(null);
        File file = new File(path, filename);
        AddressBook returnList = new AddressBook();

        try {
            returnList = om.readValue(file, AddressBook.class );
            System.out.println("test try");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("test catch");
        }

        return returnList;
    }

}
