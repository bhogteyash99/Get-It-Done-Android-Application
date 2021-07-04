package com.example.yash.finalone;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class createActivity extends Activity {

    DatabaseReference database;
    EditText nameTmp, addTmp, mobTmp, vehTmp, batteryTmp, batteryType, amtTmp, dateTmp,warrenty;
    ImageButton createBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_create);
        database = FirebaseDatabase.getInstance().getReference("Data");
    //
        nameTmp = (EditText) findViewById(R.id.nameData);
        addTmp = (EditText) findViewById(R.id.addressData);
        mobTmp = (EditText) findViewById(R.id.mobileData);
        vehTmp = (EditText) findViewById(R.id.vehData);
        batteryTmp = (EditText) findViewById(R.id.batteryData);
        amtTmp = (EditText) findViewById(R.id.amtData);
        dateTmp = (EditText) findViewById(R.id.dateData);
        batteryType = (EditText) findViewById(R.id.batteryType);
        warrenty = (EditText) findViewById(R.id.warrentyData);
        createBtn = (ImageButton) findViewById(R.id.sendBtn);
        CustomAdapter c = new CustomAdapter();
        nameTmp.setText(c.tmpName);
        addTmp.setText(c.tmpAddress);
        mobTmp.setText(c.tmpMob);
        vehTmp.setText(c.tmpVehicle);
        batteryTmp.setText(c.tmpBatteryNo);
        batteryType.setText(c.tmpBatterytype);
        amtTmp.setText(c.tmpAmount);
        dateTmp.setText(c.tmpDate);
        warrenty.setText(c.tmpWarrenty);
        c.tmpName = null;
        c.tmpAddress = null;
        c.tmpAmount = null;
        c.tmpBatteryNo = null;
        c.tmpBatterytype = null;
        c.tmpVehicle=null;
        c.tmpDate = null;
        c.tmpMob = null;
        c.tmpWarrenty=null;


        createBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("smsto:" + mobTmp.getText().toString()));
                intent.putExtra("sms_body", "Thank you "+ nameTmp.getText().toString()+" for purchasing a "+batteryType.getText().toString() +" battery from agarwal batteries on "+ dateTmp.getText().toString()+" of amount "+ amtTmp.getText().toString()+".We are glad to help you.We will provide warrenty service for "+ warrenty.getText().toString()+".We are available 24/7 for your service just call and our men will be available within 24 hours thats our guarantee.We provide all kinds of batteries.\n Agarwal Batteries\n Call us on:-\n9822424185/9370781781");
                startActivity(intent);
            }
        });

    }

    void billClick(View v) {

        if(!validate())
            Toast.makeText(this,"Please Fill up all the Information",Toast.LENGTH_SHORT).show();
        else {
            String id = database.push().getKey();
            Data data = new Data(nameTmp.getText().toString(), addTmp.getText().toString(), mobTmp.getText().toString(), vehTmp.getText().toString(), batteryTmp.getText().toString(), amtTmp.getText().toString(), dateTmp.getText().toString(), batteryType.getText().toString(),warrenty.getText().toString());
            database.child(id).setValue(data);
            Intent Login = new Intent(this, SecActivity.class);
            this.startActivity(Login);
            finish();
        }
    }
    boolean validate ()
    {
        boolean value = true;
        if (nameTmp.getText().toString().isEmpty()||addTmp.getText().toString().isEmpty()||mobTmp.getText().toString().isEmpty()||vehTmp.getText().toString().isEmpty()||batteryTmp.getText().toString().isEmpty()||batteryType.getText().toString().isEmpty()||dateTmp.getText().toString().isEmpty()||amtTmp.getText().toString().isEmpty()||warrenty.getText().toString().isEmpty())
            value = false;

        return value;
    }
}
