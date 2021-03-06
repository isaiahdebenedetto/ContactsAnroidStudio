package com.example.contacts;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ShowBusiness extends AppCompatActivity {

    Button btn_edit, btn_delete, btn_email, btn_call, btn_text, btn_navigate;
    TextView tv_name, tv_phoneNumber, tv_address, tv_postalCode, tv_country, tv_email, tv_businessName, tv_hours, tv_url;

    MyApplication app;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_business);

        btn_edit = findViewById(R.id.btn_edit);
        btn_delete = findViewById(R.id.btn_delete);
        btn_email = findViewById(R.id.btn_email);
        btn_call = findViewById(R.id.btn_call);
        btn_text = findViewById(R.id.btn_text);
        btn_navigate = findViewById(R.id.btn_navigate);

        tv_name = findViewById(R.id.tv_name);
        tv_phoneNumber = findViewById(R.id.tv_phoneNumber);
        tv_address = findViewById(R.id.tv_address);
        tv_postalCode = findViewById(R.id.tv_postalCode);
        tv_country = findViewById(R.id.tv_country);
        tv_email = findViewById(R.id.tv_email);
        tv_businessName = findViewById(R.id.tv_birthday);
        tv_hours = findViewById(R.id.tv_hours);
        tv_url = findViewById(R.id.tv_url);

        btn_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String [] addresses = new String [1];
                addresses [0] = tv_name.getText().toString();

                app.composeEmail(addresses, "Hello from Isaiah");
            }
        });

        btn_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                app.dialPhoneNumber(tv_phoneNumber.getText().toString());
            }
        });

        btn_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                app.composeMmsMessage(tv_phoneNumber.getText().toString(), "Hello I would like to talk.");
            }
        });

        btn_navigate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mapsQuery = "geo:0,0?q=" + tv_address.getText().toString();
                Uri mapuri = Uri.parse(mapsQuery);
                app.showMap(mapuri);
            }
        });

        }

    }

