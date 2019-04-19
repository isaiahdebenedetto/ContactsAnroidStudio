package com.example.contacts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv_title;
    Button btn_showAll, btn_addContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_title = findViewById(R.id.tv_title);
        btn_addContact = findViewById(R.id.btn_addContact);
        btn_showAll = findViewById(R.id.btn_showAll);


        btn_showAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toShowAll = new Intent( v.getContext(), ShowContacts.class );
                startActivity(toShowAll);
            }
        });

        btn_addContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toContactOption = new Intent( v.getContext(), ContactOptionView.class );
                startActivity(toContactOption);
            }
        });
    }
}
