package com.mycomputer.kalamnew;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Adding class comments
 */
public class LoginActivity extends AppCompatActivity  implements GoogleApiClient.OnConnectionFailedListener {

    @BindView(R.id.edit_email)
    EditText editEmail;

    @BindView(R.id.edit_Passwword)
    EditText editPassword;

    @BindView(R.id.loginButton)
    Button btnLogin;

    @BindView(R.id.login_checkbox)
    CheckBox loginCheck;

     @BindView(R.id.sign_in_button)
    Button SignInButton;


    private GoogleApiClient googleApiClient;

    private static final int RC_SIGN_IN = 1;
/*

    @BindView(R.id.login_button)
    LoginButton loginBtn;
*/

    private Button customFacebook;

    String email_str, pass_str;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        GoogleSignInOptions gso =  new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        googleApiClient=new GoogleApiClient.Builder(this)
                .enableAutoManage(this,this)
                .addApi(Auth.GOOGLE_SIGN_IN_API,gso)
                .build();




        SignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
                startActivityForResult(intent,RC_SIGN_IN);
            }
        });








    // loginFb();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Validation();
            }
        });
    }

    //Login Validation
    private void Validation() {

        boolean check=true;
        email_str = editEmail.getText().toString();
        pass_str = editPassword.getText().toString();

        if (TextUtils.isEmpty(email_str.trim()) || email_str.length() == 0) {

            editEmail.setError("Please enter valid password");
            check=false;



        }
        if (TextUtils.isEmpty(pass_str.trim()) || pass_str.length() == 0) {
            editEmail.setError("Please enter valid password");
            check=false;

        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email_str).matches()) {
            editEmail.setError("Please enter valid password");
            check=false;

        }

        if(check==true)
        {
            Intent intent=new Intent(LoginActivity.this,NavigationActivity.class);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show();
        }




    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==RC_SIGN_IN){
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleSignInResult(result);
        }
    }
    private void handleSignInResult(GoogleSignInResult result){
        if(result.isSuccess()){
            gotoProfile();
        }else{
            Toast.makeText(getApplicationContext(),"Sign in cancel",Toast.LENGTH_LONG).show();
        }
    }
    private void gotoProfile(){
        Intent intent=new Intent(LoginActivity.this,ProfileActivity.class);
        startActivity(intent);

    }
}
