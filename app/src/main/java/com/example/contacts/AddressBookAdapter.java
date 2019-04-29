package com.example.contacts;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import static com.example.contacts.ShowContacts.app;

public class AddressBookAdapter extends BaseAdapter {

    Activity mActivity;
    AddressBook theList;

    public AddressBookAdapter(Activity mActivity, AddressBook theList) {
        this.mActivity = mActivity;
        this.theList = theList;
    }

    @Override
    public int getCount() { return app.getList().getTheList().size(); }

    @Override
    public Object getItem(int position) { return app.getList().getTheList().get(position); }

    @Override
    public long getItemId(int position) { return 0; }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View onePersonLine;

        LayoutInflater inflater = (LayoutInflater) mActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        onePersonLine = inflater.inflate(R.layout.person_one_line, parent, false);

        TextView tv_fname = onePersonLine.findViewById(R.id.tv_fname);
        TextView tv_phoneNumberValue = onePersonLine.findViewById(R.id.tv_phoneLabel);
        ImageView iv_icon = onePersonLine.findViewById(R.id.iv_icon);

        BaseContact p = (BaseContact) this.getItem(position);

        tv_fname.setText(p.getfName()+ " " +p.getlName());
        tv_phoneNumberValue.setText(p.getPhoneNumber());

        int icon_resource_numbers [] = {
                R.drawable.icon1,
                R.drawable.icon2,
                R.drawable.icon3,
                R.drawable.icon4,
                R.drawable.icon5,
                R.drawable.icon6,
                R.drawable.icon7,
                R.drawable.icon8,
                R.drawable.icon9,
                R.drawable.icon10
        };

        iv_icon.setImageResource(icon_resource_numbers[position]);

        return onePersonLine;
    }
}
