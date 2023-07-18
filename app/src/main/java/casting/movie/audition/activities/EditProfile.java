package casting.movie.audition.activities;

import android.content.ContentResolver;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;


import casting.movie.audition.R;
import de.hdodenhof.circleimageview.CircleImageView;

public class EditProfile extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    EditText userName,userEmail,userLocation,userPassword;
    Button save,btnUpload;
    String getUserName,getUserEmail,getUserPassword,MobileNumber,getUserCity,getUserImage;
    SharedPreferences sp;
    GoogleSignInOptions googleSignInOptions;
    GoogleSignInClient googleSignInClient;

    CircleImageView profile_image;
    ImageView edit_profile;
    FirebaseStorage storage;
    ProgressBar progressBar;
    private Uri imageUri;
    private StorageReference reference = FirebaseStorage.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        userName=findViewById(R.id.userName);
        userEmail=findViewById(R.id.userEmail);
        userLocation=findViewById(R.id.userLocation);
        userPassword=findViewById(R.id.userPassword);
        save=findViewById(R.id.save);
        progressBar = findViewById(R.id.progressBar);

        edit_profile=findViewById(R.id.edit_profile);
        profile_image=findViewById(R.id.profile_image);
        btnUpload = findViewById(R.id.uploadImage);

        sp =getSharedPreferences("login",MODE_PRIVATE);
        MobileNumber=sp.getString("UserMobile",null);


        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("UserDetails");

        googleSignInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        googleSignInClient = GoogleSignIn.getClient(this,googleSignInOptions);

        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        if(acct!=null){
            String personName = acct.getDisplayName();
            String personEmail = acct.getEmail();
            userName.setText(personName);
            userEmail.setText(personEmail);
        }

        if(MobileNumber==null){
        }

        else {
            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {

                    if (snapshot.hasChild(MobileNumber)) {
                        getUserName=snapshot.child(MobileNumber).child("userName").getValue(String.class);
                        getUserEmail=snapshot.child(MobileNumber).child("userEmail").getValue(String.class);
                        getUserPassword=snapshot.child(MobileNumber).child("userPassword").getValue(String.class);
                        getUserCity=snapshot.child(MobileNumber).child("userAddress").getValue(String.class);
                        getUserImage=snapshot.child(MobileNumber).child("ProfileImage").getValue(String.class);
                        userName.setText(getUserName);
                        userEmail.setText(getUserEmail);
                        userPassword.setText(getUserPassword);
                        userLocation.setText(getUserCity);
                        if(getUserImage!=null){
                            Picasso.with(EditProfile.this).load(getUserImage).fit().into(profile_image);
                        }
                        else{
                            profile_image.setImageResource(R.drawable.profile_gif);
                        }

                    } else {
                        Toast.makeText(getApplicationContext(), "Please Sign up.", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }

        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (imageUri != null){
                    uploadToFirebase(imageUri);
                }else{
                    Toast.makeText(EditProfile.this, "Please Select Image", Toast.LENGTH_SHORT).show();
                }
            }
        });
        edit_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent galleryIntent = new Intent();
                galleryIntent.setAction(Intent.ACTION_GET_CONTENT);
                galleryIntent.setType("image/*");
                startActivityForResult(galleryIntent , 2);
            }
        });

        profile_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent galleryIntent = new Intent();
                galleryIntent.setAction(Intent.ACTION_GET_CONTENT);
                galleryIntent.setType("image/*");
                startActivityForResult(galleryIntent , 2);
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isNameChanged()) {
                    Toast.makeText(EditProfile.this, "User Name Changed", Toast.LENGTH_SHORT).show();
                }
                else if(isEmailChanged()){
                    Toast.makeText(EditProfile.this, "Email Changed", Toast.LENGTH_SHORT).show();
                }
                else if(isPasswordChanged()){
                    Toast.makeText(EditProfile.this, "Password Changed", Toast.LENGTH_SHORT).show();
                }
                else if(isAddressChanged()){
                    Toast.makeText(EditProfile.this, "Address Changed", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(EditProfile.this, "No Changes Found", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode ==2 && resultCode == RESULT_OK && data != null){
            imageUri = data.getData();
            profile_image.setImageURI(imageUri);
        }
    }

    private void uploadToFirebase(Uri uri){

        final StorageReference fileRef = reference.child(System.currentTimeMillis() + "." + getFileExtension(uri));
        fileRef.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                fileRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        databaseReference.child(MobileNumber).child("ProfileImage").setValue(uri.toString());
                        progressBar.setVisibility(View.INVISIBLE);
                        Toast.makeText(EditProfile.this, "Uploaded Successfully", Toast.LENGTH_SHORT).show();
                        profile_image.setImageURI(uri);
                    }
                });
            }
        }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(@NonNull UploadTask.TaskSnapshot snapshot) {
                progressBar.setVisibility(View.VISIBLE);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                progressBar.setVisibility(View.INVISIBLE);
                Toast.makeText(EditProfile.this, "Uploading Failed !!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private String getFileExtension(Uri mUri){

        ContentResolver cr = getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(cr.getType(mUri));

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
    private boolean isNameChanged() {
        if (!getUserName.equals(userName.getText().toString())){
            databaseReference.child(MobileNumber).child("userName").setValue(userName.getText().toString());
            getUserName = userName.getText().toString();
            return true;
        } else {
            return false;
        }
    }
    private boolean isEmailChanged() {
        if (!getUserEmail.equals(userEmail.getText().toString())){
            databaseReference.child(MobileNumber).child("userEmail").setValue(userEmail.getText().toString());
            getUserEmail = userEmail.getText().toString();
            return true;
        } else {
            return false;
        }
    }
    private boolean isPasswordChanged() {
        if (!getUserPassword.equals(userPassword.getText().toString())){
            databaseReference.child(MobileNumber).child("userPassword").setValue(userPassword.getText().toString());
            getUserPassword = userPassword.getText().toString();
            return true;
        } else {
            return false;
        }
    }
    private boolean isAddressChanged() {
        if (!getUserCity.equals(userLocation.getText().toString())){
            databaseReference.child(MobileNumber).child("userAddress").setValue(userLocation.getText().toString());
            getUserCity = userLocation.getText().toString();
            return true;
        } else {
            return false;
        }
    }
}