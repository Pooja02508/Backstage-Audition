package casting.movie.audition.auditionActivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.squareup.picasso.Picasso;

import casting.movie.audition.activities.ChatbotActivity;
import casting.movie.audition.auditionActivities.PortfolioPassport;
import casting.movie.audition.fragments.AuditionsFragment;
import casting.movie.audition.fragments.BackstageJobsFragment;
import casting.movie.audition.fragments.DashboardFragment;
import casting.movie.audition.fragments.HomeFragment;
import casting.movie.audition.fragments.ProfileFragment;
import casting.movie.audition.R;
import pl.droidsonroids.gif.GifImageView;

public class AuditionByAge extends AppCompatActivity {

    ImageView superwomen_girl,age_img1,age_img4;
    ImageView portfolioImg,clickImg,backstage_icon,santa_img;
    GifImageView fab,ageNo,live_chat;
    TextView text2;
    LinearLayout register_now,create_profile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audition_by_age);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        text2=findViewById(R.id.text2);
        superwomen_girl=findViewById(R.id.superwomen_girl);
//        portfolioImg=findViewById(R.id.portfolioImg);
//        clickImg=findViewById(R.id.clickImg);
         fab=findViewById(R.id.fab);
        live_chat=findViewById(R.id.live_chat);
        ageNo=findViewById(R.id.ageNo);
        age_img1=findViewById(R.id.age_img1);
        age_img4=findViewById(R.id.age_img4);

       register_now=findViewById(R.id.register_now);
       create_profile=findViewById(R.id.create_profile);

        backstage_icon=findViewById(R.id.backstage_icon);
        santa_img=findViewById(R.id.santa_img);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav_view);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();


//        Picasso.with(this).load("https://images.backstageaudition.com/talent_img.png").fit().into(portfolioImg);
//        Picasso.with(this).load("https://images.backstageaudition.com/click_img.png").fit().into(clickImg);
       // Glide.with(this).load("https://images.backstageaudition.com/chat_gif.gif").into(fab);
        Picasso.with(this).load("https://images.backstageaudition.com/backstage_new1.png").fit().into(backstage_icon);
        Picasso.with(this).load("https://images.backstageaudition.com/backstage_new2.png").fit().into(santa_img);


        Picasso.with(this).load("https://images.backstageaudition.com/superwomen_girl.png").fit().into(superwomen_girl);
        Picasso.with(this).load("https://images.backstageaudition.com/age_img1.png").fit().into(age_img1);
        Picasso.with(this).load("https://images.backstageaudition.com/age_img4.png").fit().into(age_img4);
        Glide.with(this).load("https://images.backstageaudition.com/age_2.gif").into(ageNo);

        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_down);
        text2.startAnimation(animation);
        ageNo.startAnimation(animation);

        Animation animation2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.left_to_right);
        superwomen_girl.startAnimation(animation2);

        register_now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=XW2MLM3LS4UF6")));
            }
        });
        create_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=XW2MLM3LS4UF6")));
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ChatbotActivity.class));
            }
        });
        live_chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ChatbotActivity.class));
            }
        });

        superwomen_girl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), PortfolioPassport.class));
            }
        });


    }

     private final BottomNavigationView.OnNavigationItemSelectedListener navListener = item -> {

        Fragment selectedFragment = null;
        int itemId = item.getItemId();

        if (itemId == R.id.bottom_nav_home) {
            selectedFragment = new DashboardFragment();
        }
        else if (itemId == R.id.bottom_nav_contest) {
            selectedFragment = new BackstageJobsFragment();
        }
        else if (itemId == R.id.bottom_nav_audition) {
            selectedFragment = new AuditionsFragment();
        }
        else if (itemId == R.id.bottom_nav_profile) {
            selectedFragment = new ProfileFragment();
        }

        if (selectedFragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
        }
        return true;
    };

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
}