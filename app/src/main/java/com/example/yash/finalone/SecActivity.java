package com.example.yash.finalone;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SecActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec);
    }
    public void viewBillClick(View v)
    {
        Intent view=new Intent(this,ViewActivity.class);
        this.startActivity(view);
    }
    public void createBillClick(View v)
    {
        Intent Login=new Intent(this,createActivity.class);
        this.startActivity(Login);
    }
}
