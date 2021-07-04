package com.example.yash.finalone;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import com.google.firebase.database.DatabaseReference;

public class LoginActivity extends Activity {

    Firebase url;
    ImageButton bt;
    EditText txtUser,txtPwd;
    DatabaseReference databaseReference;

  //  private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
  /*      bt=(ImageButton)findViewById(R.id.loginBtn);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth = FirebaseAuth.getInstance();
                txtUser=(EditText)findViewById(R.id.userName);
                txtPwd=(EditText)findViewById(R.id.pwd);
                mAuth.signInWithEmailAndPassword(txtUser.getText().toString().trim(),txtPwd.getText().toString().trim()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            Intent Login=new Intent(LoginActivity.this,SecActivity.class);
                            startActivity(Login);
                        }
                    }
                });
            }
        });*/
    }
    void loginClick(View view)
    {

        txtUser=findViewById(R.id.userName);
        txtPwd=findViewById(R.id.pwd);
        if(txtUser.getText().toString().equals("Agarwal")&&txtPwd.getText().toString().equals("Agarwal")) {
            Intent Login = new Intent(this, SecActivity.class);
            this.startActivity(Login);
            finish();
        }
        else
        {
            Toast.makeText(this,"Wrong Id or Password",Toast.LENGTH_SHORT).show();
        }
    }
}
