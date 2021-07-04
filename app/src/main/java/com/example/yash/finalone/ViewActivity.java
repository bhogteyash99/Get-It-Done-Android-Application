package com.example.yash.finalone;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ViewActivity extends Activity {

    DatabaseReference db;
    FirebaseHelper helper;
    CustomAdapter adapter;
    SearchView searchBar;
    ListView lv;
    TextView nameEditTxt, mobTxt;
    ArrayAdapter<Data> adapter1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        lv = (ListView) findViewById(R.id.listId);


        //INITIALIZE FIREBASE DB
        db = FirebaseDatabase.getInstance().getReference();
        helper = new FirebaseHelper(db);
        //ADAPTER
        //   CustomAdapter a=new CustomAdapter(this, helper.retrieve());
        adapter = new CustomAdapter(this, helper.retrieve());
        lv.setAdapter(adapter);
        searchBar=(SearchView)findViewById(R.id.searchId);
        searchBar.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
    }
}
