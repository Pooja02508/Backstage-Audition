package casting.movie.audition;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import casting.movie.audition.activities.EditProfile;
import casting.movie.audition.activities.SecondActivity;
import casting.movie.audition.databinding.NavigationDrawerActivityBinding;
import pl.droidsonroids.gif.GifImageView;

public class NavigationDrawer extends AppCompatActivity {
    SharedPreferences sp,sp2;
    private AppBarConfiguration mAppBarConfiguration;
    private NavigationDrawerActivityBinding binding;
    private BottomNavigationView bottomNavView;
    GoogleSignInOptions googleSignInOptions;
    GoogleSignInClient googleSignInClient;

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = NavigationDrawerActivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        sp = getSharedPreferences("login",MODE_PRIVATE);
        String MobileNumber=sp.getString("Mobile",null);

        sp2 = getSharedPreferences("findjoblogin",MODE_PRIVATE);

        setSupportActionBar(binding.appBarNavigationDrawer.toolbar);
//        binding.appBarNavigationDrawer.fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(getApplicationContext(), ChatbotActivity.class));
//            }
//        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        bottomNavView = findViewById(R.id.bottom_nav_view);


        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_audition,R.id.nav_profile,R.id.nav_portfolio,R.id.nav_post_call,R.id.nav_find_talent,R.id.nav_backstage_jobs,R.id.nav_contact_us,R.id.nav_content_creator,
                R.id.nav_models,R.id.nav_actors,R.id.nav_freelancer,R.id.nav_crew,R.id.nav_content_staff,R.id.nav_dancer,R.id.nav_technical,R.id.nav_internship,R.id.nav_influencer,
                R.id.nav_models_job,R.id.nav_actors_job,R.id.nav_content_staff_job,R.id.nav_voice_job,R.id.nav_crew_job,R.id.nav_dancer_job,R.id.nav_singer_job,R.id.nav_technical_job,R.id.nav_internship_job,
                R.id.bottom_nav_home, R.id.bottom_nav_contest, R.id.bottom_nav_audition,R.id.bottom_nav_profile)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_navigation_drawer);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
        NavigationUI.setupWithNavController(bottomNavView, navController);

        googleSignInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        googleSignInClient = GoogleSignIn.getClient(this,googleSignInOptions);

        View headerview = navigationView.getHeaderView(0);
        headerview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.backstageaudition.com")));
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation_drawer, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id=item.getItemId();
        switch (id){
            case R.id.nav_logout:
                SharedPreferences.Editor editor=sp.edit();
                editor.clear();
                editor.apply();
                SharedPreferences.Editor editor2=sp2.edit();
                editor2.clear();
                editor2.apply();
//                googleSignInClient.signOut();
//                FirebaseAuth.getInstance().signOut();
                Toast.makeText(getApplicationContext(),"Logout",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), SecondActivity.class));
                finish();
                break;
            case R.id.nav_edit_profile:
                startActivity(new Intent(getApplicationContext(), EditProfile.class));
                break;
        }

        return false;

    }
    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_navigation_drawer);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}