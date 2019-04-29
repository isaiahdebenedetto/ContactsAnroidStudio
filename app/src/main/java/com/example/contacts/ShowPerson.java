package com.example.contacts;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ShowPerson extends AppCompatActivity {

    Button btn_edit, btn_delete, btn_email, btn_call, btn_text, btn_navigate;
    TextView tv_name, tv_phoneNumber, tv_address, tv_postalCode, tv_country, tv_email, tv_birthday, tv_desc;
    ImageView iv_contactPhoto;

    MyApplication app;

    int positionToEdit = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_person);

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
        tv_birthday = findViewById(R.id.tv_birthday);
        tv_desc = findViewById(R.id.tv_hours);

        iv_contactPhoto = findViewById(R.id.iv_contactPhoto);

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

        Bundle incomingIntent = getIntent().getExtras();

        if (incomingIntent != null) {
            String fname = incomingIntent.getString("fname");
            String lname = incomingIntent.getString("lname");
            String phoneNumber = incomingIntent.getString("phoneNumber");
            String street = incomingIntent.getString("street");
            String city = incomingIntent.getString("city");
            String state = incomingIntent.getString("state");
            String postalCode= incomingIntent.getString("postalCode");
            String country = incomingIntent.getString("country");
            String email = incomingIntent.getString("email");
            String birthday = incomingIntent.getString("birthday");
            String desc = incomingIntent.getString("desc");
            String pictureNumber = incomingIntent.getString("pictureNumber");
            positionToEdit = incomingIntent.getInt("edit");

            // fill in the form
            tv_name.setText(fname + " " + lname);
            tv_phoneNumber.setText(phoneNumber);
            tv_address.setText(street + " " + city + ", " + state);
            tv_postalCode.setText(postalCode);
            tv_country.setText(country);
            tv_email.setText(email);
            tv_birthday.setText(birthday);
            tv_desc.setText(desc);

        }
    }
}