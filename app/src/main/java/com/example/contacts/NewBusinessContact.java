package com.example.contacts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewBusinessContact extends AppCompatActivity {

    Button btn_ok, btn_cancel;
    EditText et_fname, et_lname, et_phoneNumber, et_street, et_city, et_state, et_country, et_postalcode, et_email,
            et_businessName, et_hours, et_url, et_pictureNumber;
    AddressBook list;
    AddressBookAdapter adapter;
    int positionToEdit = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_business_form);

        btn_ok = findViewById(R.id.btn_ok);
        btn_cancel = findViewById(R.id.btn_cancel);

        et_phoneNumber = findViewById(R.id.et_phoneNumber);
        et_fname = findViewById(R.id.et_fname);
        et_lname = findViewById(R.id.et_lname);
        et_street = findViewById(R.id.et_street);
        et_city = findViewById(R.id.et_city);
        et_state = findViewById(R.id.et_country);
        et_postalcode = findViewById(R.id.et_postalcode);
        et_country = findViewById(R.id.et_country);
        et_email = findViewById(R.id.et_email);
        et_businessName = findViewById(R.id.et_businessName);
        et_hours = findViewById(R.id.et_hours);
        et_url = findViewById(R.id.et_url);
        et_pictureNumber = findViewById(R.id.et_pictureNumber);

        list = ((MyApplication) this.getApplication()).getList();

        Bundle incomingIntent = getIntent().getExtras();

        if (incomingIntent != null) {
            String fname = incomingIntent.getString("fname");
            String lname = incomingIntent.getString("lname");
            String phoneNumber = incomingIntent.getString("phoneNumber");
            String street = incomingIntent.getString("street");
            String city = incomingIntent.getString("city");
            String state = incomingIntent.getString("state");
            String postalCode = incomingIntent.getString("postalCode");
            String country = incomingIntent.getString("country");
            String email = incomingIntent.getString("email");
            String businessName = incomingIntent.getString("businessName");
            String hours = incomingIntent.getString("hours");
            String url = incomingIntent.getString("url");
            String pictureNumber = incomingIntent.getString("pictureNumber");
            positionToEdit = incomingIntent.getInt("edit");

            // fill in the form
            et_fname.setText(fname);
            et_lname.setText(lname);
            et_phoneNumber.setText(phoneNumber);
            et_street.setText(street);
            et_city.setText(city);
            et_state.setText(state);
            et_postalcode.setText(postalCode);
            et_country.setText(country);
            et_email.setText(email);
            et_businessName.setText(businessName);
            et_hours.setText(hours);
            et_url.setText(url);
            et_pictureNumber.setText(pictureNumber);



        }
        adapter = new AddressBookAdapter( NewBusinessContact.this, ShowContacts.app.getList());
        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // get strngs from et_ view objects
                String newFName = et_fname.getText().toString();
                String newLName = et_lname.getText().toString();
                String newphoneNumber = et_phoneNumber.getText().toString();
                String newStreet = et_street.getText().toString();
                String newCity = et_city.getText().toString();
                String newState = et_state.getText().toString();
                String newCountry = et_country.getText().toString();
                String newPostalCode = et_postalcode.getText().toString();
                String newEmail = et_email.getText().toString();
                String newBusinessName = et_businessName.getText().toString();
                String newHours = et_hours.getText().toString();
                String newURL = et_url.getText().toString();
                String newPictureNumber = String.valueOf(et_pictureNumber.getText());

                // put the strings into a message for MainActivity
                // start MainActivity again
                Intent toMain = new Intent( v.getContext(), MainActivity.class );

                BusinessContact b = new BusinessContact(newFName, newLName, newStreet, newCity, newState,
                        newPostalCode, newCountry, newphoneNumber, newPictureNumber,newEmail, newBusinessName, newHours, newURL);

                ShowContacts.app.getList().getTheList().add(b);
                adapter.notifyDataSetChanged();
                System.out.println(ShowContacts.app.getList());
                startActivity(toMain);
            }
        });
    }

}
