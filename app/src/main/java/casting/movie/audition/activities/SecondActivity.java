package casting.movie.audition.activities;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import casting.movie.audition.fragments.StepOneFragment;
import casting.movie.audition.NavigationDrawer;
import casting.movie.audition.R;

public class SecondActivity extends AppCompatActivity {

    Button loginBtn,signUpBtn;
    SharedPreferences sp;
    public static String filename="userlogin";
    public static String Uname="username";
    public static String Upass="password";
    FusedLocationProviderClient fusedLocationProviderClient;
    private  final  static int REQUEST_CODE=100;

    private static final int CAMERA_PERMISSION_CODE = 100;
    private static final int STORAGE_PERMISSION_CODE = 101;

    String UserLocation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        getSupportActionBar().hide();

        ViewPager viewPager = findViewById(R.id.viewPager);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new StepOneFragment());
        viewPager.setAdapter(viewPagerAdapter);
//        TabLayout tabLayout = findViewById(R.id.tabLayoutIndicator);
//        tabLayout.setupWithViewPager(viewPager);


        loginBtn=findViewById(R.id.loginBtn);
        signUpBtn=findViewById(R.id.signUpBtn);
        fusedLocationProviderClient= LocationServices.getFusedLocationProviderClient(this);
        getLastLocation();

//        checkPermission(Manifest.permission.CAMERA, CAMERA_PERMISSION_CODE);
//
//        checkPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE, STORAGE_PERMISSION_CODE);

        sp=getSharedPreferences(filename, Context.MODE_PRIVATE);

        sp = getSharedPreferences("login",MODE_PRIVATE);
        if(sp.getBoolean("logged",false)){
            goToMainActivity();
        }

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=(new Intent(getApplicationContext(),LoginActivity.class));
                intent.putExtra("UserLocation",UserLocation);
                startActivity(intent);
            }
        });

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=(new Intent(getApplicationContext(),RegisterActivity.class));
                intent.putExtra("UserLocation",UserLocation);
                startActivity(intent);
            }
        });


    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mList = new ArrayList<>();
        public ViewPagerAdapter(FragmentManager supportFragmentManager) {
            super(supportFragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        }
        @Override
        public Fragment getItem(int i) {
            return mList.get(i);
        }
        @Override
        public int getCount() {
            return mList.size();
        }
        public void addFragment(Fragment fragment) {
            mList.add(fragment);
        }
    }

//    public void checkPermission(String permission, int requestCode)
//    {
//        if (ContextCompat.checkSelfPermission(SecondActivity.this, permission) == PackageManager.PERMISSION_DENIED) {
//
//            ActivityCompat.requestPermissions(SecondActivity.this, new String[] { permission }, requestCode);
//        }
//        else {
//            startActivity(new Intent(getApplicationContext(), SecondActivity.class));
//        }
//    }

    private void getLastLocation() {
        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){

            fusedLocationProviderClient.getLastLocation()
                    .addOnSuccessListener(new OnSuccessListener<Location>() {
                        @Override
                        public void onSuccess(Location location) {
                            if (location !=null){
                                Geocoder geocoder=new Geocoder(getApplicationContext(), Locale.getDefault());
                                List<Address> addresses= null;
                                try {
                                    addresses = geocoder.getFromLocation(location.getLatitude(),location.getLongitude(),1);
                                    UserLocation=addresses.get(0).getAddressLine(0);
//                                    city.setText(addresses.get(0).getAddressLine(0));
//                                    city.setText("City :"+addresses.get(0).getLocality());
//                                    country.setText("Country :"+addresses.get(0).getCountryName());
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    });
        }else {
            askPermission();
        }
    }

    private void askPermission() {
        ActivityCompat.requestPermissions(this, new String[]
                {Manifest.permission.ACCESS_FINE_LOCATION},REQUEST_CODE);
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if (requestCode==REQUEST_CODE){
            if (grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                getLastLocation();
            }
            else {
                Toast.makeText(getApplicationContext(), "Required Location Permission", Toast.LENGTH_SHORT).show();
            }
        }

//        else if (requestCode == STORAGE_PERMISSION_CODE) {
//            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                Intent intent=(new Intent(getApplicationContext(),SecondActivity.class));
//                intent.putExtra("UserLocation",UserLocation);
//                startActivity(intent);
//                finish();
//            } else {
//                // Toast.makeText(MainActivity.this, "Storage Permission Denied", Toast.LENGTH_SHORT).show();
//            }
//        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    public void goToMainActivity(){
        Intent i = new Intent(this, NavigationDrawer.class);
        startActivity(i);
        finish();
    }

}