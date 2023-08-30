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

public class LoginAttendance extends AppCompatActivity {

    // Deklarasi variabel editTextEmail dengan tipe EditText
    EditText editTextEmail;
    // Deklarasi variabel editTextPassword dengan tipe EditText
    EditText editTextPassword;
    // Deklarasi variabel btn_get_login dengan tipe Buttomn
    Button btn_login;
    //Deklarasi variabel database
    DatabaseKaryawan dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_attendance);
        // Binding edt_txt_email ke variabel editTextEmail
        editTextEmail = findViewById(R.id.edt_txt_email);

        // Binding edt_txt_password ke variabel editTextPassword
        editTextPassword = findViewById(R.id.edt_txt_password);

        // Binding edt_txt_password ke variabel editTextPassword
        btn_login = findViewById(R.id.btn_get_login);

        // Binding Database
        dbHandler = new DatabaseKaryawan(this);

        btn_login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String user = editTextEmail.getText().toString();
                String pass = editTextPassword.getText().toString();

                if(user.equals("")||pass.equals(""))
                    Toast.makeText(LoginAttendance.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkuserpass = dbHandler.checkusernamepassword(user, pass);
                    if(checkuserpass==true){
                        Toast.makeText(LoginAttendance.this, "Sign in successfull", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(LoginAttendance.this, HomeAttendance.class);
                        startActivity(i);
                    }
                    else{
                        Toast.makeText(LoginAttendance.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }

    public void clickForgot(View view) {
        Intent i = new Intent(LoginAttendance.this, ValidasiForgotPassword.class);
        startActivity(i);
    }

    public void clickGetRegister(View view) {
        Intent i = new Intent(LoginAttendance.this, TambahKaryawan.class);
        startActivity(i);
    }

    public void GetStarted(View view) {
        // Validasi input email dan password kosong
        if(TextUtils.isEmpty(editTextEmail.getText().toString().trim())
                &&
                TextUtils.isEmpty(editTextPassword.getText().toString().trim())){
            Toast.makeText(view.getContext(),"Email dan Password Tidak boleh kosong!",Toast.LENGTH_LONG).show();
        }
        // Validasi input email kosong
        if(TextUtils.isEmpty(editTextEmail.getText().toString().trim())){
            Toast.makeText(view.getContext(),"Email Tidak boleh kosong!",Toast.LENGTH_LONG).show();
        }
        // Validasi inputan tipe email
        else if (!isValidEmail(editTextEmail.getText().toString().trim())){
            Toast.makeText(view.getContext(),"Email Tidak Valid",Toast.LENGTH_LONG).show();
        }
        // Validasi password kosong
        else if(TextUtils.isEmpty(editTextPassword.getText().toString().trim())){
            Toast.makeText(view.getContext(),"Password Tidak boleh kosong!",Toast.LENGTH_LONG).show();
        }
        else {
            Intent i = new Intent(LoginAttendance.this, HomeAttendance.class);
            startActivity(i);}
    }

    public static boolean isValidEmail (CharSequence email) {
        return (Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }
}