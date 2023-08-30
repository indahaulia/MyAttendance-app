package com.sandbox.myattendance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ResetPassword extends AppCompatActivity {

    // Deklarasi EditText
    TextView code_username;
    EditText restPassword;
    EditText restRepeatPassword;
    Button confirm;
    DatabaseKaryawan dbHandler;
    final int MAX_PASSWORD_LENGTH = 15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        // Binding EditText
        code_username = findViewById(R.id.edt_reset_code);
        restPassword = findViewById(R.id.edt_reset_new_pass);
        restRepeatPassword = findViewById(R.id.edt_confirm_password);
        dbHandler = new DatabaseKaryawan(this);
        confirm = findViewById(R.id.btn_confirm_pass);

        Intent i = getIntent();
        code_username.setText(i.getStringExtra("username"));

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = code_username.getText().toString();
                String password = restPassword.getText().toString();
                String repassword = restRepeatPassword.getText().toString();

                if(password.equals(repassword)){

                Boolean checkpasswordupdate = dbHandler.updatepassword(user,password);
                if (checkpasswordupdate==true){
                    Toast.makeText(ResetPassword.this, "Change Password in successfull", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(ResetPassword.this, LoginAttendance.class);
                    startActivity(i);
                }
                else {
                    Toast.makeText(ResetPassword.this, "Invalid Change Password", Toast.LENGTH_SHORT).show();

                }}
                else {
                    Toast.makeText(ResetPassword.this, "Password Not Match", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    public void postChangePassword(View view) {
        // Validasi kosong
        if(TextUtils.isEmpty(code_username.getText().toString().trim()) &&
                TextUtils.isEmpty(restPassword.getText().toString().trim()) &&
                TextUtils.isEmpty(restRepeatPassword.getText().toString().trim()))
        {
            Toast.makeText(view.getContext(),"Code dan Password Tidak boleh kosong!",Toast.LENGTH_LONG).show();
        }
        // Cek inputan new dan confirm
        else if(TextUtils.isEmpty(code_username.getText().toString().trim())){
            Toast.makeText(view.getContext(),"Code Tidak Boleh Kosong!",Toast.LENGTH_LONG).show();
        }
        else if(TextUtils.isEmpty(restPassword.getText().toString().trim())){
            Toast.makeText(view.getContext(),"Password Tidak boleh kosong!",Toast.LENGTH_LONG).show();
        }
        else if (restPassword.getText().length() > MAX_PASSWORD_LENGTH){
            Toast.makeText(view.getContext(),"Password Lebih Dari 15 Karakter",Toast.LENGTH_LONG).show();
        }
        else if (!restPassword.getText().toString().equals(restRepeatPassword.getText().toString())){
            Toast.makeText(view.getContext(),"Password tidak cocok",Toast.LENGTH_LONG).show();
        }
        else{
            Intent i = new Intent(ResetPassword.this, LoginAttendance.class);
            startActivity(i);
        }

    }
}