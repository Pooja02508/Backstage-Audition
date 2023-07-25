package casting.movie.audition.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.hbb20.CountryCodePicker;

import casting.movie.audition.NavigationDrawer;
import casting.movie.audition.R;


public class LoginActivity extends AppCompatActivity {

    TextView signup_here;
    SharedPreferences sp;
    private FirebaseAuth mAuth;
    TextInputEditText pass,emailid;
    EditText mobile;
    Button login;
    String UserMobile;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference=firebaseDatabase.getInstance().getReference("UserDetails");
    CountryCodePicker codePicker;
    GoogleSignInOptions googleSignInOptions;
    GoogleSignInClient googleSignInClient;
    ImageView googleBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        signup_here=findViewById(R.id.signup_here);
        pass=findViewById(R.id.password);
        emailid=findViewById(R.id.username);
        mobile=findViewById(R.id.mobileNumber);
        login=findViewById(R.id.login);
        codePicker=findViewById(R.id.country_code);

        mAuth = FirebaseAuth.getInstance();
        sp = getSharedPreferences("login",MODE_PRIVATE);


        if(sp.getBoolean("logged",false)){
            goToMainActivity();
        }


        signup_here.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),RegisterActivity.class));
            }
        });


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                loginUserAccount();
            }
        });

        googleBtn = findViewById(R.id.google_btn);

        googleSignInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestIdToken(getString(R.string.default_web_client_id)).requestEmail().build();
        googleSignInClient = GoogleSignIn.getClient(this,googleSignInOptions);

        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        if(acct!=null){
            goToMainActivity();
        }

        googleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });

    }

    void signIn(){
        Intent signInIntent = googleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent,1000);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1000){
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);

            try {
                task.getResult(ApiException.class);
                goToMainActivity();
            } catch (ApiException e) {
                Toast.makeText(getApplicationContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        }

    }

    private void loginUserAccount() {

        String email, password;
        email = emailid.getText().toString();
        password = pass.getText().toString();

        // validations for input email and password
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(getApplicationContext(), "Please enter email!!", Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(getApplicationContext(), "Please enter password!!", Toast.LENGTH_LONG).show();
            return;
        }

        // signin existing user
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(
                        new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(
                                    @NonNull Task<AuthResult> task)
                            {
                                if (task.isSuccessful()) {
                                    String country_code=codePicker.getSelectedCountryCode();
                                    String phone = "+"+country_code+mobile.getText().toString();
                                    Toast.makeText(getApplicationContext(), "Login successful!!", Toast.LENGTH_LONG).show();
                                    sp.edit().putBoolean("logged",true).apply();
                                    sp.edit().putString("UserMobile",phone).apply();
                                    goToMainActivity();
                                    finish();
                                }

                                else {
                                    Toast.makeText(getApplicationContext(), "Login failed!!", Toast.LENGTH_LONG).show();

                                }
                            }
                        });
    }

    public void goToMainActivity(){
        String country_code=codePicker.getSelectedCountryCode();
        String phone =  "+"+country_code+mobile.getText().toString();
        Intent i = new Intent(LoginActivity.this, NavigationDrawer.class);
        sp.edit().putBoolean("logged",true).apply();
        sp.edit().putString("UserMobile",phone).apply();

        i.putExtra("UserMobile",phone);
        startActivity(i);
        finish();

    }

}


//        login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                String Password=password.getText().toString();
//                Mobile="+91"+phone.getText().toString();
//
//                if(TextUtils.isEmpty(password.getText().toString()) || TextUtils.isEmpty(phone.getText().toString())){
//                    Toast.makeText(getApplicationContext(),"Enter valid credentials",Toast.LENGTH_SHORT).show();
//                }
//                else {
//
//
//                    databaseReference.addValueEventListener(new ValueEventListener() {
//                        @Override
//                        public void onDataChange(@NonNull DataSnapshot snapshot) {
//
//                            if(snapshot.hasChild(Mobile)){
//
//                                final String getPassword=snapshot.child(Mobile).child("userPassword").getValue(String.class);
//
//                                if(getPassword.equals(Password)){
//                                    Toast.makeText(getApplicationContext(), "Login Successful.", Toast.LENGTH_SHORT).show();
//                                    goToMainActivity();
//                                    sp.edit().putBoolean("logged",true).apply();
//                                    sp.edit().putString("UserMobile",Mobile).apply();
//
//                                    finish();
//                                }
//                                else{
//
//                                    Toast.makeText(getApplicationContext(), "Wrong Credentials", Toast.LENGTH_SHORT).show();
//                                }
//                            }
//                            else{
//
//                                Toast.makeText(getApplicationContext(), "Wrong Credentials", Toast.LENGTH_SHORT).show();
//                            }
//
//                        }
//
//                        @Override
//                        public void onCancelled(@NonNull DatabaseError error) {
//
//                        }
//                    });
//
//                }
//            }
//        });
