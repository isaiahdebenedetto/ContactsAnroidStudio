package com.example.contacts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ContactOptionView extends AppCompatActivity {

    Button btn_business, btn_person;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_option_view);

        btn_business = findViewById(R.id.btn_business);
        btn_person = findViewById(R.id.btn_addPerson);

        btn_business.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toNewBusiness = new Intent( v.getContext(), NewBusinessContact.class );
                startActivity(toNewBusiness);
            }
        });

        btn_person.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toNewPerson = new Intent( v.getContext(), NewPersonContact.class );
                startActivity(toNewPerson);
            }
        });
    }
}
