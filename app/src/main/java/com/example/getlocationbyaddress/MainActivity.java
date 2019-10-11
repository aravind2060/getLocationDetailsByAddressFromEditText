package com.example.getlocationbyaddress;

import androidx.appcompat.app.AppCompatActivity;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editText;
    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      editText=findViewById(R.id.edittxt);
      button=findViewById(R.id.getLocationbyaddress);
      textView=findViewById(R.id.showtxtview);

     button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.getLocationbyaddress)
        {
             String loc=editText.getText().toString();
              Geocoder geocoder=new Geocoder(this);
              List<Address> addresses=null;
            try {
                addresses=geocoder.getFromLocationName(loc,1);
               if (addresses.size()>0)
               {
                   Address address=addresses.get(0);
                   String countryname=address.getCountryName();
                   String featureName=address.getFeatureName();
                   String stateName=address.getAdminArea();
                   String postal=address.getPostalCode();
                   String total="countryName:"+countryname+"\n"+"State:"+stateName+"\n"+"Actucal LocationName:"+featureName+"\n"+"Postal Code:"+postal;
                   textView.setText(""+total);
               }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
