package com.sandbox.myattendance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ValidasiForgotPassword extends AppCompatActivity {

    // Deklarasi EditText
    EditText editTextEmail;
    // Deklarasi variabel btn_get_login dengan tipe Buttomn
    Button btn_forgot_pass;
    //Deklarasi variabel database
    DatabaseKaryawan dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validasi_forgot_password);

        // Binding EditText
        editTextEmail = findViewById(R.id.edt_txt_email);

        // Binding edt_txt_password ke variabel editTextPassword
        btn_forgot_pass = findViewById(R.id.btn_get_forgot);

        // Binding Database
        dbHandler = new DatabaseKaryawan(this);

        btn_forgot_pass.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String user = editTextEmail.getText().toString();

                if(user.equals(""))
                    Toast.makeText(ValidasiForgotPassword.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkuserpass = dbHandler.checkusername(user);
                    if(checkuserpass==true){
                        Toast.makeText(ValidasiForgotPassword.this, "Email Validation in successfull", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(ValidasiForgotPassword.this, ResetPassword.class);
                        i.putExtra("username", user);
                        startActivity(i);
                    }
                    else{
                        Toast.makeText(ValidasiForgotPassword.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    public static boolean isValidEmail (CharSequence email) {
        return (Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }
}