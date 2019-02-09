package com.mycomputer.kalamnew;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Registration extends AppCompatActivity {
    private EditText name,gmail,password,subject,address;
    private TextView regis;
    private Button Sub;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        name=(EditText)findViewById(R.id.et1);
        gmail=(EditText)findViewById(R.id.et2);
        password=(EditText)findViewById(R.id.et3);
        subject=(EditText)findViewById(R.id.et4);
        address=(EditText)findViewById(R.id.et5);
        regis=(TextView)findViewById(R.id.tv);
        Sub=(Button)findViewById(R.id.btn);
        Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Intent intent=new Intent(Main3Activity.this,Main2Activity.class);
                //   startActivity(intent);



                boolean check = true;
                String namee = name.getText().toString();
                String gmaill = gmail.getText().toString();
                String passs = password.getText().toString();
                String subjectt = subject.getText().toString();
                String addresss = address.getText().toString();
                if (namee.length()<15) {
                    name.setError("Enter more than 15 character!!");
                    check = false;
                }

                if (gmaill.isEmpty()) {
                    gmail.setError("fields is empty");
                    check = false;
                }

                if(!Patterns.EMAIL_ADDRESS.matcher(gmaill).matches())
                {
                    gmail.setError("Enter Valid email");
                    check = false;
                }





                if (passs.length()<8) {
                    password.setError("enter valid password");
                    check = false;
                }

                if (subjectt.length()<10) {
                    subject.setError("enter more than 10 character");
                    check = false;

                }
                if (addresss.length()<12) {
                    address.setError("Enter more than 12 Character");
                    check = false;

                }





                if (check == true) {

                    Toast.makeText(Registration.this, "Registration Successfully", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(Registration.this,LoginActivity.class);
                    startActivity(intent);

                } else {
                    Toast.makeText(Registration.this, "Registration Failed", Toast.LENGTH_SHORT).show();


                }
            }




        });


    }
}
