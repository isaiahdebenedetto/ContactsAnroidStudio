package com.example.contacts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewPersonContact extends AppCompatActivity {

    Button btn_ok, btn_cancel;
    EditText et_fname, et_lname, et_phoneNumber, et_street, et_city, et_state, et_country, et_postalcode, et_email,
            et_birthday, et_desc, et_pictureNumber;
    AddressBook list;
    AddressBookAdapter adapter;
    int positionToEdit = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_person_form);

        btn_ok = findViewById(R.id.btn_ok);
        btn_cancel = findViewById(R.id.btn_cancel);

        et_phoneNumber = findViewById(R.id.et_phoneNumber);
        et_fname = findViewById(R.id.et_fname);
        et_lname = findViewById(R.id.et_lname);
        et_street = findViewById(R.id.et_street);
        et_city = findViewById(R.id.et_city);
        et_state = findViewById(R.id.et_state);
        et_postalcode = findViewById(R.id.et_postalcode);
        et_country = findViewById(R.id.et_country);
        et_email = findViewById(R.id.et_email);
        et_birthday = findViewById(R.id.et_birthday);
        et_desc = findViewById(R.id.et_desc);
        et_pictureNumber = findViewById(R.id.et_pictureNumber);

        list = ((MyApplication) this.getApplication()).getList();

        Bundle incomingInt = getIntent().getExtras();

        if (incomingInt != null) {
            String fname = incomingInt.getString("fname");
            String lname = incomingInt.getString("lname");
            String phoneNumber = incomingInt.getString("phoneNumber");
            String street = incomingInt.getString("street");
            String city = incomingInt.getString("city");
            String state = incomingInt.getString("state");
            String postalCode = incomingInt.getString("postalCode");
            String country = incomingInt.getString("country");
            String email = incomingInt.getString("email");
            String birthday = incomingInt.getString("birthday");
            String desc = incomingInt.getString("desc");
            String pictureNumber = incomingInt.getString("pictureNumber");
            positionToEdit = incomingInt.getInt("edit");

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
            et_birthday.setText(birthday);
            et_desc.setText(desc);
            et_pictureNumber.setText(pictureNumber);



        }
        adapter = new AddressBookAdapter( NewPersonContact.this, ShowContacts.app.getList());
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
                String newBirthday = et_birthday.getText().toString();
                String newDesc = et_desc.getText().toString();
                String newPictureNumber = String.valueOf(et_pictureNumber.getText());

                // put the strings into a message for MainActivity
                // start MainActivity again
                Intent toMain = new Intent( v.getContext(), MainActivity.class );

                PersonContact p = new PersonContact(newFName, newLName, newStreet, newCity, newState,
                        newPostalCode, newCountry, newphoneNumber, newPictureNumber,newEmail, newBirthday, newDesc);

                ShowContacts.app.getList().getTheList().add(p);
                adapter.notifyDataSetChanged();
                System.out.println(ShowContacts.app.getList());
                startActivity(toMain);
            }
        });
    }
}
