package com.example.contacts;

import android.app.Application;
import android.widget.ListView;

public class MyApplication extends Application {

    ListView lv_listofcontacts;

    private AddressBook list = new AddressBook();

    public AddressBook getList() {
        return list;
    }

    public void setList(AddressBook list) {
        this.list = list;
    }


    public void onCreate() {
        super.onCreate();

        FileIOService dataService = new FileIOService(this);
        ShowContacts.app.setList(dataService.readList("contacts.txt"));
    }

    @Override
    public void onTerminate() {
        super.onTerminate();

        FileIOService dataService = new FileIOService(this);
        dataService.writeList( ShowContacts.app.getList(), "contacts.txt");

    }
}
