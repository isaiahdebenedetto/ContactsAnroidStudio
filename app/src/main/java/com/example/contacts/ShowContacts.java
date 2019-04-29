package com.example.contacts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class ShowContacts extends AppCompatActivity {

    Button btn_search;
    ListView lv_listofcontacts;
    AddressBook list;
    AddressBookAdapter adapter;
    public static MyApplication app = new MyApplication();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_contacts);

        btn_search = findViewById(R.id.btn_search);
        lv_listofcontacts = findViewById(R.id.lv_listofcontacts);

        list = ((MyApplication) this.getApplication()).getList();
        adapter = new AddressBookAdapter( ShowContacts.this, app.getList());
        lv_listofcontacts.setAdapter(adapter);

        lv_listofcontacts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               //TODO differentiate between business and person

                Log.d("contactapp", "pos " +  position);
                Toast.makeText(ShowContacts.this, "pos="+position, Toast.LENGTH_SHORT).show();
                BaseContact b = app.getList().getTheList().get(position);
                if (b.getClass() == PersonContact.class) {
                    showPerson(position);
                } else if (b.getClass() == BusinessContact.class) {
                    Intent i = new Intent(getApplicationContext(), ShowBusiness.class);
                    BusinessContact p = (BusinessContact) app.getList().getTheList().get(position);
                    i.putExtra("edit", position);
                    startActivity(i);
                } else
                System.out.println("contact edit test");
            }
        });


    }

    public void loadFile() {
        FileIOService dataService = new FileIOService(this);
        app.setList(dataService.readList("contacts.txt"));
        lv_listofcontacts.setAdapter(new AddressBookAdapter(ShowContacts.this, app.getList()));
    }

    public void saveFile() {
        FileIOService dataService = new FileIOService(this);
        dataService.writeList( app.getList(), "contacts.txt");
        lv_listofcontacts.setAdapter(new AddressBookAdapter(ShowContacts.this, app.getList()));
    }

    public void showBusiness(int position) {
        Intent i = new Intent(getApplicationContext(), ShowBusiness.class);

        BusinessContact p = (BusinessContact) app.getList().getTheList().get(position);

        i.putExtra("edit", position);
        startActivity(i);
    }

    public void showPerson(int position) {
        Intent i = new Intent(getApplicationContext(), ShowPerson.class);
        i.putExtra("edit", position);
        startActivity(i);
    }
}
