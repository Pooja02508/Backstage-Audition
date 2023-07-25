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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.hbb20.CountryCodePicker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import casting.movie.audition.NavigationDrawer;
import casting.movie.audition.R;
import casting.movie.audition.models.UserDetails;


public class RegisterActivity extends AppCompatActivity {

    SharedPreferences sp;
    TextView login_here;
    EditText userLocation,username,emailId,mobile,pass;
    Button signUp;
    boolean isAllFieldsChecked = false;
    private FirebaseAuth mAuth;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    UserDetails userDetails;
    CountryCodePicker codePicker;

    GoogleSignInOptions googleSignInOptions;
    GoogleSignInClient googleSignInClient;
    ImageView googleBtn;
    String currentDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().hide();

        login_here=findViewById(R.id.login_here);
        userLocation=findViewById(R.id.userLocation);
        signUp=findViewById(R.id.signUp);
        emailId=findViewById(R.id.emailId);
        username=findViewById(R.id.username);
        mobile=findViewById(R.id.mobileNumber);
        pass=findViewById(R.id.password);
        codePicker=findViewById(R.id.country_code);

        mAuth = FirebaseAuth.getInstance();

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("UserDetails");
        userDetails = new UserDetails();

        String UserLocation=getIntent().getStringExtra("UserLocation");
        userLocation.setText(""+UserLocation);
        sp = getSharedPreferences("login",MODE_PRIVATE);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
        currentDate = sdf.format(new Date());


        login_here.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),LoginActivity.class));
            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isAllFieldsChecked = CheckAllFields();
                if (isAllFieldsChecked) {
                    registerNewUser();
                }
            }
        });


        googleBtn = findViewById(R.id.google_btn);

        googleSignInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestIdToken(getString(R.string.default_web_client_id)).requestEmail().build();
        googleSignInClient = GoogleSignIn.getClient(this,googleSignInOptions);

        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        if(acct!=null){
            navigateToSecondActivity();
        }

        googleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });
    }

    private void registerNewUser() {
        // Take the value of two edit texts in Strings
        String email, password;
        email = emailId.getText().toString();
        password = pass.getText().toString();

        // Validations for input email and password
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(getApplicationContext(), "Please enter email!!", Toast.LENGTH_LONG).show();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(getApplicationContext(), "Please enter password!!", Toast.LENGTH_LONG).show();
            return;
        }

        // create new user or register new user
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {

                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task)
                    {
                        if (task.isSuccessful()) {

                            String country_code=codePicker.getSelectedCountryCode();
                            String phone = "+"+country_code+mobile.getText().toString();
                            userDetails.setUserName(username.getText().toString());
                            userDetails.setUserEmail(emailId.getText().toString());
                            userDetails.setUserAddress(userLocation.getText().toString());
                            userDetails.setUserMobile(phone);
                            userDetails.setUserPassword(pass.getText().toString());
                            userDetails.setJoiningTime(currentDate);

                            databaseReference.child("UserDetails").addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot snapshot) {
                                    if(snapshot.hasChild(phone)){
                                        Toast.makeText(getApplicationContext(), "User already exists.", Toast.LENGTH_SHORT).show();
                                    }
                                    else{
                                        databaseReference.child(phone).setValue(userDetails);

                                        Toast.makeText(getApplicationContext(), "Registration Successful", Toast.LENGTH_SHORT).show();
                                        sendEmail();
                                        sp.edit().putBoolean("logged",true).apply();
                                        sp.edit().putString("UserMobile",phone).apply();
                                        sp.edit().putString("UserName",username.getText().toString()).apply();
                                        Intent i = new Intent(RegisterActivity.this, NavigationDrawer.class);
                                        i.putExtra("UserMobile",phone);
                                        i.putExtra("UserName",username.getText().toString());
                                        startActivity(i);
                                        finish();
                                    }
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError error) {
                                    Toast.makeText(getApplicationContext(), "Fail to add data " + error, Toast.LENGTH_SHORT).show();
                                }
                            });

                        }
                        else {
                            // Registration failed
                            Toast.makeText(getApplicationContext(), "Registration failed!! Please try again later", Toast.LENGTH_LONG).show();

                        }
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
                navigateToSecondActivity();
            } catch (ApiException e) {
                Toast.makeText(getApplicationContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        }

    }

    private boolean CheckAllFields() {
        if (username.getText().toString().length() == 0) {
            username.setError("Username is required");
            return false;
        }

        if (emailId.getText().toString().length() == 0) {
            emailId.setError("Email is required");
            return false;
        }
        if (mobile.getText().toString().length() == 0) {
            mobile.setError("Mobile is required");
            return false;
        }
        else if (mobile.getText().toString().length() < 10) {
            mobile.setError("Enter valid mobile number");
            return false;
        }

        if (pass.getText().toString().length() == 0) {
            pass.setError("Password is required");
            return false;
        }
        else if (pass.getText().toString().length() < 8) {
            pass.setError("Password must be minimum 8 characters");
            return false;
        }

        return true;
    }

    public void sendEmail(){

        try {
            String stringSenderEmail = "joinstarcircle@gmail.com";
            String stringReceiverEmail = emailId.getText().toString();
            String stringAdminEmail = "joinstarcircle@gmail.com";
            String stringPasswordSenderEmail = "skrtxwylsvjukvqz";
            String country_code=codePicker.getSelectedCountryCode();
            String phone = "+"+country_code+mobile.getText().toString();
            String stringHost = "smtp.gmail.com";

            Properties properties = System.getProperties();

            properties.put("mail.smtp.host", stringHost);
            properties.put("mail.smtp.port", "465");
            properties.put("mail.smtp.ssl.enable", "true");
            properties.put("mail.smtp.auth", "true");

            javax.mail.Session session = Session.getInstance(properties, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(stringSenderEmail, stringPasswordSenderEmail);
                }
            });

            MimeMessage mimeMessage = new MimeMessage(session);
//            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(stringReceiverEmail));
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(stringAdminEmail));


            mimeMessage.setSubject("Backstage Audition and Casting Registration");
            mimeMessage.setText("Hello "+ username.getText().toString()+
                    "\nYou have successfully registered in Backstage Audition and Casting.\n User Email Id: "+emailId.getText().toString()+
                    "\n User Mobile Number: "+phone+
                    "\n User Password: "+pass.getText().toString()+
                    "\n User Address: " +userLocation.getText().toString()
                    +"\n User Joining App Date: " +currentDate);

            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Transport.send(mimeMessage);
                    } catch (MessagingException e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.start();

        } catch (AddressException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    void navigateToSecondActivity(){
        Toast.makeText(getApplicationContext(), "Registration Successful", Toast.LENGTH_SHORT).show();
        sendEmail();
        sp.edit().putBoolean("logged",true).apply();
        sp.edit().putString("UserName",username.getText().toString()).apply();
        Intent i = new Intent(RegisterActivity.this, NavigationDrawer.class);
        startActivity(i);
        finish();
    }
}