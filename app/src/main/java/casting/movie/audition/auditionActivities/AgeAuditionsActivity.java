package casting.movie.audition.auditionActivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.formats.MediaView;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.ads.formats.UnifiedNativeAdView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import casting.movie.audition.activities.ChatbotActivity;
import casting.movie.audition.fragments.AuditionsFragment;
import casting.movie.audition.fragments.BackstageJobsFragment;
import casting.movie.audition.fragments.DashboardFragment;
import casting.movie.audition.fragments.HomeFragment;
import casting.movie.audition.fragments.ProfileFragment;
import casting.movie.audition.R;
import casting.movie.audition.models.AgeAdapter;
import casting.movie.audition.models.Auditions;
import pl.droidsonroids.gif.GifImageView;

public class AgeAuditionsActivity extends AppCompatActivity implements AgeAdapter.ItemClickListener{

    ImageView backstage_icon,santa_img;
    GifImageView fab,live_chat;
    LinearLayout register_now,create_profile;
    private UnifiedNativeAd nativeAd;
    RecyclerView recyclerView;
    ArrayList<Auditions> auditionsArrayList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age_auditions);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Male Auditions");
        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav_view);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();

        fab=findViewById(R.id.fab);
        live_chat=findViewById(R.id.live_chat);
        register_now=findViewById(R.id.register_now);
        create_profile=findViewById(R.id.create_profile);
        backstage_icon=findViewById(R.id.backstage_icon);
        santa_img=findViewById(R.id.santa_img);
        recyclerView=findViewById(R.id.recyclerView);

       // Glide.with(this).load("https://images.backstageaudition.com/chat_gif.gif").into(fab);
        Picasso.with(this).load("https://images.backstageaudition.com/backstage_new1.png").fit().into(backstage_icon);
        Picasso.with(this).load("https://images.backstageaudition.com/backstage_new2.png").fit().into(santa_img);

        String AGE=getIntent().getStringExtra("AGE");

        if(AGE.equals("0-5")){
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/1_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/2_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/3_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions(""));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/4_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/5_Year_Old_Boy_Audition.gif"));
        }
        else if(AGE.equals("6-12")){
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/6_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/7_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/8_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions(""));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/9_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/10_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions(""));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/11_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/12_Year_Old_Boy_Audition.gif"));
        }
        else if(AGE.equals("13-19")){
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/13_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/14_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/15_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions(""));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/16_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/17_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions(""));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/18_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/19_Year_Old_Boy_Audition.gif"));
        }
        else if(AGE.equals("20-25")){
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/20_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/21_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/22_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/23_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/24_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/25_Year_Old_Boy_Audition.gif"));
        }
        else if(AGE.equals("26-40")){
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/26_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/27_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/28_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions(""));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/29_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/30_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions(""));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/31_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/32_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions(""));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/33_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/34_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions(""));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/35_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/36_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions(""));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/37_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/38_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions(""));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/39_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/40_Year_Old_Boy_Audition.gif"));
        }
        else if(AGE.equals("41-50")){
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/41_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/42_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/43_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/44_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/45_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/46_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions(""));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/47_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/48_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions(""));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/49_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/50_Year_Old_Boy_Audition.gif"));
        }
        else if(AGE.equals("51-60")){
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/51_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/52_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/53_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/54_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/55_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/56_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions(""));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/57_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/58_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions(""));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/59_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/60_Year_Old_Boy_Audition.gif"));
        }
        else if(AGE.equals("61-80")){
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/61_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/62_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/63_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/64_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/65_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/66_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions(""));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/67_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/68_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions(""));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/69_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/70_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions(""));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/71_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/72_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions(""));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/73_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/74_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions(""));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/75_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/76_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions(""));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/77_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/78_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions(""));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/79_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/80_Year_Old_Boy_Audition.gif"));
        }

        else if(AGE.equals("6-8")){
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/6_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/7_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/8_Year_Old_Boy_Audition.gif"));
        }
        else if(AGE.equals("9-13")){
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/9_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/10_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/11_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions(""));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/12_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/13_Year_Old_Boy_Audition.gif"));
        }
        else if(AGE.equals("14-18")){
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/14_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/15_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/16_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions(""));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/17_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/18_Year_Old_Boy_Audition.gif"));
        }
        else if(AGE.equals("19-20")){
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/19_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/20_Year_Old_Boy_Audition.gif"));
        }
        else if(AGE.equals("21-25")){
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/21_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/22_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/23_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions(""));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/24_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/25_Year_Old_Boy_Audition.gif"));
        }
        else if(AGE.equals("26-30")){
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/26_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/27_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/28_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions(""));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/29_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/30_Year_Old_Boy_Audition.gif"));
        }
        else if(AGE.equals("31-35")){
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/31_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/32_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/33_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions(""));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/34_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/35_Year_Old_Boy_Audition.gif"));
        }
        else if(AGE.equals("36-40")){
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/36_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/37_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/38_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions(""));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/39_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/40_Year_Old_Boy_Audition.gif"));
        }
        else if(AGE.equals("41-45")){
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/41_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/42_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/43_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions(""));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/44_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/45_Year_Old_Boy_Audition.gif"));
        }
        else if(AGE.equals("46-50")){
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/46_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/47_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/48_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions(""));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/49_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/50_Year_Old_Boy_Audition.gif"));
        }
        else if(AGE.equals("50-55")){
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/51_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/52_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/53_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions(""));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/54_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/55_Year_Old_Boy_Audition.gif"));
        }
        else if(AGE.equals("56-60")){
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/56_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/57_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/58_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions(""));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/59_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/60_Year_Old_Boy_Audition.gif"));
        }
        else if(AGE.equals("61-65")){
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/61_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/62_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/63_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions(""));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/64_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/65_Year_Old_Boy_Audition.gif"));
        }
        else if(AGE.equals("66-70")){
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/66_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/67_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/68_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions(""));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/69_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/70_Year_Old_Boy_Audition.gif"));
        }
        else if(AGE.equals("71-75")){
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/71_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/72_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/73_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions(""));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/74_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/75_Year_Old_Boy_Audition.gif"));
        }
        else if(AGE.equals("76-80")){
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/76_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/77_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/78_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions(""));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/79_Year_Old_Boy_Audition.gif"));
            auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/80_Year_Old_Boy_Audition.gif"));
        }



        int numberOfColumns = 3;
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), numberOfColumns));
        AgeAdapter adapter = new AgeAdapter(getApplicationContext(),auditionsArrayList);
        recyclerView.setAdapter(adapter);
        adapter.setClickListener(this);

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

        MobileAds.initialize(this, getString(R.string.ADMOB_ADS_UNIT_ID));

        AdLoader.Builder builder = new AdLoader.Builder(this, getString(R.string.ADMOB_ADS_UNIT_ID));
        builder.forUnifiedNativeAd(new UnifiedNativeAd.OnUnifiedNativeAdLoadedListener() {
            @Override
            public void onUnifiedNativeAdLoaded(UnifiedNativeAd unifiedNativeAd) {
                if (nativeAd != null) {
                    nativeAd.destroy();
                }
                nativeAd = unifiedNativeAd;
                FrameLayout frameLayout =findViewById(R.id.fl_adplaceholder);
                UnifiedNativeAdView adView = (UnifiedNativeAdView) getLayoutInflater().inflate(R.layout.ad_unified, null);

                populateUnifiedNativeAdView(unifiedNativeAd, adView);
                frameLayout.removeAllViews();
                frameLayout.addView(adView);
            }
        });

        NativeAdOptions adOptions = new NativeAdOptions.Builder().build();
        builder.withNativeAdOptions(adOptions);
        AdLoader adLoader = builder.withAdListener (new AdListener(){

            @Override
            public void onAdFailedToLoad(int i) {

            }
        }).build();
        adLoader.loadAd(new AdRequest.Builder().build());

    }

    @Override
    public void onItemClick(View view, int position) {
        Intent intent=new Intent(getApplicationContext(),AuditionsDetailActivity.class);

        String Age=getIntent().getStringExtra("AGE");

        if(Age.equals("0-5")){
            switch (position){
                case 0: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_1_year_old_man.png");
                    intent.putExtra("Age","1");
                    break;
                case 1: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_2_year_old_man.png");
                    intent.putExtra("Age","2");
                    break;
                case 2: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_3_year_old_man.png");
                    intent.putExtra("Age","3");
                    break;
                case 3: break;
                case 4: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_4_year_old_man.png");
                    intent.putExtra("Age","4");
                    break;
                case 5: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_5_year_old_man.png");
                    intent.putExtra("Age","5");
                    break;
            }
            startActivity(intent);
        }
        if(Age.equals("6-8")){
            switch (position){
                case 0: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_6_year_old_man.png");
                    intent.putExtra("Age","6");
                    break;
                case 1: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_7_year_old_man.png");
                    intent.putExtra("Age","7");
                    break;
                case 2: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_8_year_old_man.png");
                    intent.putExtra("Age","8");
                    break;
            }
            startActivity(intent);
        }
        if(Age.equals("9-13")){
            switch (position){
                case 0: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_9_year_old_man.png");
                    intent.putExtra("Age","9");
                    break;
                case 1: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_10_year_old_man.png");
                    intent.putExtra("Age","10");
                    break;
                case 2: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_11_year_old_man.png");
                    intent.putExtra("Age","11");
                    break;
                case 3: break;
                case 4: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_12_year_old_man.png");
                    intent.putExtra("Age","12");
                    break;
                case 5: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_13_year_old_man.png");
                    intent.putExtra("Age","13");
                    break;
            }
            startActivity(intent);
        }
        if(Age.equals("14-18")){
            switch (position){
                case 0: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_14_year_old_man.png");
                    intent.putExtra("Age","14");
                    break;
                case 1: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_15_year_old_man.png");
                    intent.putExtra("Age","15");
                    break;
                case 2: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_16_year_old_man.png");
                    intent.putExtra("Age","16");
                    break;
                case 3: break;
                case 4: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_17_year_old_man.png");
                    intent.putExtra("Age","17");
                    break;
                case 5: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_18_year_old_man.png");
                    intent.putExtra("Age","18");
                    break;
            }
            startActivity(intent);
        }
        if(Age.equals("19-20")){
            switch (position){
                case 0: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_19_year_old_man.png");
                    intent.putExtra("Age","19");
                    break;
                case 1: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_20_year_old_man.png");
                    intent.putExtra("Age","20");
                    break;
            }
            startActivity(intent);
        }
        if(Age.equals("21-25")){
            switch (position){
                case 0: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_21_year_old_man.png");
                    intent.putExtra("Age","21");
                    break;
                case 1: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_22_year_old_man.png");
                    intent.putExtra("Age","22");
                    break;
                case 2: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_23_year_old_man.png");
                    intent.putExtra("Age","23");
                    break;
                case 3: break;
                case 4: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_24_year_old_man.png");
                    intent.putExtra("Age","24");
                    break;
                case 5: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_25_year_old_man.png");
                    intent.putExtra("Age","25");
                    break;
            }
            startActivity(intent);
        }
        if(Age.equals("26-30")){
            switch (position){
                case 0: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_26_year_old_man.png");
                    intent.putExtra("Age","26");
                    break;
                case 1: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_27_year_old_man.png");
                    intent.putExtra("Age","27");
                    break;
                case 2: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_28_year_old_man.png");
                    intent.putExtra("Age","28");
                    break;
                case 3: break;
                case 4: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_29_year_old_man.png");
                    intent.putExtra("Age","29");
                    break;
                case 5: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_30_year_old_man.png");
                    intent.putExtra("Age","30");
                    break;
            }
            startActivity(intent);
        }
        if(Age.equals("31-35")){
            switch (position){
                case 0: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_31_year_old_man.png");
                    intent.putExtra("Age","31");
                    break;
                case 1: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_32_year_old_man.png");
                    intent.putExtra("Age","32");
                    break;
                case 2: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_33_year_old_man.png");
                    intent.putExtra("Age","33");
                    break;
                case 3: break;
                case 4: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_34_year_old_man.png");
                    intent.putExtra("Age","34");
                    break;
                case 5: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_35_year_old_man.png");
                    intent.putExtra("Age","35");
                    break;
            }
            startActivity(intent);
        }
        if(Age.equals("36-40")){
            switch (position){
                case 0: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_36_year_old_man.png");
                    intent.putExtra("Age","36");
                    break;
                case 1: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_37_year_old_man.png");
                    intent.putExtra("Age","37");
                    break;
                case 2: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_38_year_old_man.png");
                    intent.putExtra("Age","38");
                    break;
                case 3: break;
                case 4: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_39_year_old_man.png");
                    intent.putExtra("Age","39");
                    break;
                case 5: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_40_year_old_man.png");
                    intent.putExtra("Age","40");
                    break;
            }
            startActivity(intent);
        }
        if(Age.equals("41-45")){
            switch (position){
                case 0: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_41_year_old_man.png");
                    intent.putExtra("Age","41");
                    break;
                case 1: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_42_year_old_man.png");
                    intent.putExtra("Age","42");
                    break;
                case 2: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_43_year_old_man.png");
                    intent.putExtra("Age","43");
                    break;
                case 3: break;
                case 4: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_44_year_old_man.png");
                    intent.putExtra("Age","44");
                    break;
                case 5: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_45_year_old_man.png");
                    intent.putExtra("Age","45");
                    break;

            }
            startActivity(intent);
        }
        if(Age.equals("46-50")){
            switch (position){
                case 0: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_46_year_old_man.png");
                    intent.putExtra("Age","46");
                    break;
                case 1: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_47_year_old_man.png");
                    intent.putExtra("Age","47");
                    break;
                case 2: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_48_year_old_man.png");
                    intent.putExtra("Age","48");
                    break;
                case 3: break;
                case 4: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_49_year_old_man.png");
                    intent.putExtra("Age","49");
                    break;
                case 5: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_50_year_old_man.png");
                    intent.putExtra("Age","50");
                    break;
            }
            startActivity(intent);
        }
        if(Age.equals("51-55")){
            switch (position){
                case 0: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_51_year_old_man.png");
                    intent.putExtra("Age","51");
                    break;
                case 1: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_52_year_old_man.png");
                    intent.putExtra("Age","52");
                    break;
                case 2: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_53_year_old_man.png");
                    intent.putExtra("Age","53");
                    break;
                case 3: break;
                case 4: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_54_year_old_man.png");
                    intent.putExtra("Age","54");
                    break;
                case 5: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_55_year_old_man.png");
                    intent.putExtra("Age","55");
                    break;
            }
            startActivity(intent);
        }
        if(Age.equals("56-60")){
            switch (position){
                case 0: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_56_year_old_man.png");
                    intent.putExtra("Age","56");
                    break;
                case 1: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_57_year_old_man.png");
                    intent.putExtra("Age","57");
                    break;
                case 2: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_58_year_old_man.png");
                    intent.putExtra("Age","58");
                    break;
                case 3: break;
                case 4: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_59_year_old_man.png");
                    intent.putExtra("Age","59");
                    break;
                case 5: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_60_year_old_man.png");
                    intent.putExtra("Age","60");
                    break;
            }
            startActivity(intent);
        }
        if(Age.equals("61-65")){
            switch (position){
                case 0: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_61_year_old_man.png");
                    intent.putExtra("Age","61");
                    break;
                case 1: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_62_year_old_man.png");
                    intent.putExtra("Age","62");
                    break;
                case 2: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_63_year_old_man.png");
                    intent.putExtra("Age","63");
                    break;
                case 3: break;
                case 4: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_64_year_old_man.png");
                    intent.putExtra("Age","64");
                    break;
                case 5: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_65_year_old_man.png");
                    intent.putExtra("Age","65");
                    break;
            }
            startActivity(intent);
        }
        if(Age.equals("66-70")){
            switch (position){
                case 0: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_66_year_old_man.png");
                    intent.putExtra("Age","66");
                    break;
                case 1: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_67_year_old_man.png");
                    intent.putExtra("Age","67");
                    break;
                case 2: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_68_year_old_man.png");
                    intent.putExtra("Age","68");
                    break;
                case 3: break;
                case 4: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_69_year_old_man.png");
                    intent.putExtra("Age","69");
                    break;
                case 5: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_70_year_old_man.png");
                    intent.putExtra("Age","70");
                    break;
            }
            startActivity(intent);
        }
        if(Age.equals("71-75")){
            switch (position){
                case 0: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_71_year_old_man.png");
                    intent.putExtra("Age","71");
                    break;
                case 1: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_72_year_old_man.png");
                    intent.putExtra("Age","72");
                    break;
                case 2: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_73_year_old_man.png");
                    intent.putExtra("Age","73");
                    break;
                case 3: break;
                case 4: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_74_year_old_man.png");
                    intent.putExtra("Age","74");
                    break;
                case 5: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_75_year_old_man.png");
                    intent.putExtra("Age","75");
                    break;
            }
            startActivity(intent);
        }
        if(Age.equals("76-80")){
            switch (position){
                case 0: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_76_year_old_man.png");
                    intent.putExtra("Age","76");
                    break;
                case 1: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_77_year_old_man.png");
                    intent.putExtra("Age","77");
                    break;
                case 2: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_78_year_old_man.png");
                    intent.putExtra("Age","78");
                    break;
                case 3: break;
                case 4: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_79_year_old_man.png");
                    intent.putExtra("Age","79");
                    break;
                case 5: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_80_year_old_man.png");
                    intent.putExtra("Age","80");
                    break;
            }
            startActivity(intent);
        }


        if(Age.equals("6-12")){
            switch (position){
                case 0: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_6_year_old_man.png");
                    intent.putExtra("Age","6");
                    break;
                case 1: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_7_year_old_man.png");
                    intent.putExtra("Age","7");
                    break;
                case 2: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_8_year_old_man.png");
                    intent.putExtra("Age","8");
                    break;
                case 3: break;
                case 4: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_9_year_old_man.png");
                    intent.putExtra("Age","9");
                    break;
                case 5: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_10_year_old_man.png");
                    intent.putExtra("Age","10");
                    break;
                case 6: break;
                case 7: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_11_year_old_man.png");
                    intent.putExtra("Age","11");
                    break;
                case 8: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_12_year_old_man.png");
                    intent.putExtra("Age","12");
                    break;
            }
            startActivity(intent);
        }
        if(Age.equals("13-19")){
            switch (position){
                case 0: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_13_year_old_man.png");
                    intent.putExtra("Age","13");
                    break;
                case 1: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_14_year_old_man.png");
                    intent.putExtra("Age","14");
                    break;
                case 2: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_15_year_old_man.png");
                    intent.putExtra("Age","15");
                    break;
                case 3: break;
                case 4: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_16_year_old_man.png");
                    intent.putExtra("Age","16");
                    break;
                case 5: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_17_year_old_man.png");
                    intent.putExtra("Age","17");
                    break;
                case 6: break;
                case 7: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_18_year_old_man.png");
                    intent.putExtra("Age","18");
                    break;
                case 8: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_19_year_old_man.png");
                    intent.putExtra("Age","19");
                    break;
            }
            startActivity(intent);
        }
        if(Age.equals("20-25")){
            switch (position){
                case 0: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_20_year_old_man.png");
                    intent.putExtra("Age","21");
                    break;
                case 1: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_21_year_old_man.png");
                    intent.putExtra("Age","22");
                    break;
                case 2: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_22_year_old_man.png");
                    intent.putExtra("Age","23");
                    break;
                case 3:intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_23_year_old_man.png");
                    intent.putExtra("Age","23");
                    break;
                case 4: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_24_year_old_man.png");
                    intent.putExtra("Age","24");
                    break;
                case 5: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_25_year_old_man.png");
                    intent.putExtra("Age","25");
                    break;
            }
            startActivity(intent);
        }
        if(Age.equals("26-40")){
            switch (position){
                case 0: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_26_year_old_man.png");
                    intent.putExtra("Age","26");
                    break;
                case 1: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_27_year_old_man.png");
                    intent.putExtra("Age","27");
                    break;
                case 2: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_28_year_old_man.png");
                    intent.putExtra("Age","28");
                    break;
                case 3: break;
                case 4: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_29_year_old_man.png");
                    intent.putExtra("Age","29");
                    break;
                case 5: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_30_year_old_man.png");
                    intent.putExtra("Age","30");
                    break;
                case 6: break;
                case 7: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_31_year_old_man.png");
                    intent.putExtra("Age","31");
                    break;
                case 8: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_32_year_old_man.png");
                    intent.putExtra("Age","32");
                    break;
                case 9: break;
                case 10: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_33_year_old_man.png");
                    intent.putExtra("Age","33");
                    break;
                case 11: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_34_year_old_man.png");
                    intent.putExtra("Age","34");
                    break;
                case 12: break;
                case 13: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_35_year_old_man.png");
                    intent.putExtra("Age","35");
                    break;
                case 14: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_36_year_old_man.png");
                    intent.putExtra("Age","36");
                    break;
                case 15: break;
                case 16: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_37_year_old_man.png");
                    intent.putExtra("Age","37");
                    break;
                case 17: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_38_year_old_man.png");
                    intent.putExtra("Age","39");
                    break;
                case 18: break;
                case 19: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_39_year_old_man.png");
                    intent.putExtra("Age","39");
                    break;
                case 20: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_40_year_old_man.png");
                    intent.putExtra("Age","40");
                    break;
            }
            startActivity(intent);

        }
        if(Age.equals("41-50")){
            switch (position){
                case 0: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_41_year_old_man.png");
                    intent.putExtra("Age","41");
                    break;
                case 1: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_42_year_old_man.png");
                    intent.putExtra("Age","42");
                    break;
                case 2: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_43_year_old_man.png");
                    intent.putExtra("Age","43");
                    break;
                case 3: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_44_year_old_man.png");
                    intent.putExtra("Age","44");
                    break;
                case 4: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_45_year_old_man.png");
                    intent.putExtra("Age","45");
                    break;
                case 5: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_46_year_old_man.png");
                    intent.putExtra("Age","46");
                    break;
                case 6: break;
                case 7: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_47_year_old_man.png");
                    intent.putExtra("Age","47");
                    break;
                case 8: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_48_year_old_man.png");
                    intent.putExtra("Age","48");
                    break;
                case 9: break;
                case 10: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_49_year_old_man.png");
                    intent.putExtra("Age","49");
                    break;
                case 11: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_50_year_old_man.png");
                    intent.putExtra("Age","50");
                    break;

            }
            startActivity(intent);
        }
        if(Age.equals("51-60")){
            switch (position){
                case 0: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_51_year_old_man.png");
                    intent.putExtra("Age","51");
                    break;
                case 1: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_52_year_old_man.png");
                    intent.putExtra("Age","52");
                    break;
                case 2: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_53_year_old_man.png");
                    intent.putExtra("Age","53");
                    break;
                case 3: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_54_year_old_man.png");
                    intent.putExtra("Age","54");
                    break;
                case 4: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_55_year_old_man.png");
                    intent.putExtra("Age","55");
                    break;
                case 5: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_56_year_old_man.png");
                    intent.putExtra("Age","55");
                    break;
                case 6: break;
                case 7: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_57_year_old_man.png");
                    intent.putExtra("Age","57");
                    break;
                case 8: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_58_year_old_man.png");
                    intent.putExtra("Age","58");
                    break;
                case 9: break;
                case 10: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_59_year_old_man.png");
                    intent.putExtra("Age","59");
                    break;
                case 11: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_60_year_old_man.png");
                    intent.putExtra("Age","60");
                    break;

            }
            startActivity(intent);
        }
        if(Age.equals("61-80")){
            switch (position){
                case 0: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_61_year_old_man.png");
                    intent.putExtra("Age","61");
                    break;
                case 1: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_62_year_old_man.png");
                    intent.putExtra("Age","62");
                    break;
                case 2: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_63_year_old_man.png");
                    intent.putExtra("Age","63");
                    break;
                case 3: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_64_year_old_man.png");
                    intent.putExtra("Age","64");
                    break;
                case 4: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_65_year_old_man.png");
                    intent.putExtra("Age","65");
                    break;
                case 5: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_66_year_old_man.png");
                    intent.putExtra("Age","66");
                    break;
                case 6: break;
                case 7: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_67_year_old_man.png");
                    intent.putExtra("Age","67");
                    break;
                case 8: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_68_year_old_man.png");
                    intent.putExtra("Age","68");
                    break;
                case 9: break;
                case 10: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_69_year_old_man.png");
                    intent.putExtra("Age","69");
                    break;
                case 11: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_70_year_old_man.png");
                    intent.putExtra("Age","70");
                    break;
                case 12: break;
                case 13: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_71_year_old_man.png");
                    intent.putExtra("Age","71");
                    break;
                case 14: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_72_year_old_man.png");
                    intent.putExtra("Age","72");
                    break;
                case 15: break;
                case 16: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_73_year_old_man.png");
                    intent.putExtra("Age","73");
                    break;
                case 17: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_74_year_old_man.png");
                    intent.putExtra("Age","74");
                    break;
                case 18: break;
                case 19: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_75_year_old_man.png");
                    intent.putExtra("Age","75");
                    break;
                case 20: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_76_year_old_man.png");
                    intent.putExtra("Age","76");
                    break;
                case 21: break;
                case 22: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_77_year_old_man.png");
                    intent.putExtra("Age","77");
                    break;
                case 23: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_78_year_old_man.png");
                    intent.putExtra("Age","78");
                    break;
                case 24: break;
                case 25: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_79_year_old_man.png");
                    intent.putExtra("Age","79");
                    break;
                case 26: intent.putExtra("JobImage","https://images.backstageaudition.com/audition_for_80_year_old_man.png");
                    intent.putExtra("Age","80");
                    break;

            }
            startActivity(intent);
        }
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

    private void populateUnifiedNativeAdView(UnifiedNativeAd nativeAd, UnifiedNativeAdView adView) {

        adView.setMediaView((MediaView) adView.findViewById(R.id.ad_media));
        adView.setHeadlineView(adView.findViewById(R.id.ad_headline));
        adView.setBodyView(adView.findViewById(R.id.ad_body));
        adView.setCallToActionView(adView.findViewById(R.id.ad_call_to_action));
        adView.setIconView(adView.findViewById(R.id.ad_app_icon));
        adView.setPriceView(adView.findViewById(R.id.ad_price));
        adView.setAdvertiserView(adView.findViewById(R.id.ad_advertiser));
        adView.setStoreView(adView.findViewById(R.id.ad_store));
        adView.setStarRatingView(adView.findViewById(R.id.ad_stars));

        ((TextView)adView.getHeadlineView()).setText(nativeAd.getHeadline());
        adView.getMediaView().setMediaContent(nativeAd.getMediaContent());

        if (nativeAd.getBody() == null) {
            adView.getBodyView().setVisibility(View.INVISIBLE);
        } else {
            adView.getBodyView().setVisibility(View.VISIBLE);
            ((TextView) adView.getBodyView()).setText(nativeAd.getBody());
        }
        if (nativeAd.getCallToAction() == null) {
            adView.getCallToActionView().setVisibility(View.INVISIBLE);
        } else {
            adView.getCallToActionView().setVisibility(View.VISIBLE);
            ((Button) adView.getCallToActionView()).setText(nativeAd.getCallToAction());
        }
        if (nativeAd.getIcon() == null) {
            adView.getIconView().setVisibility(View.GONE);
        } else {
            ((ImageView) adView.getIconView()).setImageDrawable(nativeAd.getIcon().getDrawable());
            adView.getIconView().setVisibility(View.VISIBLE);
        }
        if (nativeAd.getPrice() == null) {
            adView.getPriceView().setVisibility(View.INVISIBLE);
        } else {
            adView.getPriceView().setVisibility(View.VISIBLE);
            ((TextView) adView.getPriceView()).setText(nativeAd.getPrice());
        }
        if (nativeAd.getStore() == null) {
            adView.getStoreView().setVisibility(View.INVISIBLE);
        } else {
            adView.getStoreView().setVisibility(View.VISIBLE);
            ((TextView) adView.getStoreView()).setText(nativeAd.getStore());

        }
        if (nativeAd.getStarRating() == null) {
            adView.getStarRatingView().setVisibility(View.INVISIBLE);
        } else {
            ((RatingBar) adView.getStarRatingView()).setRating(nativeAd.getStarRating().floatValue());
            adView.getStarRatingView().setVisibility(View.VISIBLE);
        }
        if (nativeAd.getAdvertiser() == null) {
            adView.getAdvertiserView().setVisibility(View.INVISIBLE);

        } else {
            ((TextView) adView.getAdvertiserView()).setText(nativeAd.getAdvertiser());
            adView.getAdvertiserView().setVisibility(View.VISIBLE);
        }
        adView.setNativeAd(nativeAd);
    }

}