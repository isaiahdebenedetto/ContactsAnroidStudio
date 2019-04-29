package com.example.contacts;

import android.app.Application;
import android.content.Intent;
import android.net.Uri;
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

    public void openWebPage(String url) {
        if (!url.startsWith("http://") || !url.startsWith("https://")) {
            url = "http://" + url;
        }
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void composeEmail(String[] addresses, String subject) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("*/*"));
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        if(intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void dialPhoneNumber(String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void composeMmsMessage(String phoneNumber, String message) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("smsto:" + phoneNumber));
        intent.putExtra("sms_body", message);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void showMap (Uri geoLocation) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(geoLocation);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
            startActivity(intent);
        }
    }
}
