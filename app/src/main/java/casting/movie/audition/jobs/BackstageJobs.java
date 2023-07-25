package casting.movie.audition.jobs;

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
import casting.movie.audition.models.Auditions;
import casting.movie.audition.models.BackstageJobAdapter;
import pl.droidsonroids.gif.GifImageView;

public class BackstageJobs extends AppCompatActivity implements BackstageJobAdapter.ItemClickListener{

    private UnifiedNativeAd nativeAd;
    RecyclerView recyclerView;
    ArrayList<Auditions> auditionsArrayList=new ArrayList<>();
    ImageView backstage_icon,santa_img;
    GifImageView fab,live_chat;
    LinearLayout register_now,create_profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_backstage_jobs);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Backstage Audition Jobs");

        recyclerView=findViewById(R.id.recyclerView);
        fab=findViewById(R.id.fab);
        live_chat=findViewById(R.id.live_chat);
        backstage_icon=findViewById(R.id.backstage_icon);
        santa_img=findViewById(R.id.santa_img);
        register_now=findViewById(R.id.register_now);
        create_profile=findViewById(R.id.create_profile);

        Picasso.with(this).load("https://images.backstageaudition.com/backstage_new1.png").fit().into(backstage_icon);
        Picasso.with(this).load("https://images.backstageaudition.com/backstage_new2.png").fit().into(santa_img);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav_view);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();

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
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://my.artibot.ai/backstage")));
            }
        });
        live_chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://my.artibot.ai/backstage")));
            }
        });


        auditionsArrayList.add(new Auditions("Apply For Job","https://images.backstageaudition.com/findjob_gif.gif","135+ Jobs Available","45+ Internships/Trainee Jobs"));
        auditionsArrayList.add(new Auditions("\uD83D\uDDE3Voice ▶ Audio \uD83C\uDFB5 Sound","https://images.backstageaudition.com/voice_gif.gif","135+ Jobs Available","45+ Internships/Trainee Jobs"));
        auditionsArrayList.add(new Auditions("♪ Music","https://images.backstageaudition.com/music_gif.gif","135+ Jobs Available","45+ Internships/Trainee Jobs"));
        auditionsArrayList.add(new Auditions("Makeup & Hair","https://images.backstageaudition.com/makeup_gif.gif","135+ Jobs Available","45+ Internships/Trainee Jobs"));
        auditionsArrayList.add(new Auditions("Costumes","https://images.backstageaudition.com/costume_gif.gif","135+ Jobs Available","45+ Internships/Trainee Jobs"));
        auditionsArrayList.add(new Auditions("Direction","https://images.backstageaudition.com/direction_gif.gif","135+ Jobs Available","45+ Internships/Trainee Jobs"));
        auditionsArrayList.add(new Auditions("Acting","https://images.backstageaudition.com/acting_gif.gif","135+ Jobs Available","45+ Internships/Trainee Jobs"));
        auditionsArrayList.add(new Auditions("Action","https://images.backstageaudition.com/action_gif.gif","135+ Jobs Available","45+ Internships/Trainee Jobs"));
        auditionsArrayList.add(new Auditions("Dance","https://images.backstageaudition.com/dance_gif.gif","135+ Jobs Available","45+ Internships/Trainee Jobs"));
        auditionsArrayList.add(new Auditions("Editing","https://images.backstageaudition.com/editing_gif.gif","135+ Jobs Available","45+ Internships/Trainee Jobs"));
        auditionsArrayList.add(new Auditions("Camera / Production","https://images.backstageaudition.com/camera_production_gif.gif","135+ Jobs Available","45+ Internships/Trainee Jobs"));
        auditionsArrayList.add(new Auditions("Other Jobs","https://images.backstageaudition.com/aotherjobs_gif.gif","135+ Jobs Available","45+ Internships/Trainee Jobs"));
        auditionsArrayList.add(new Auditions("Marketing","https://images.backstageaudition.com/marketing_gif.gif","135+ Jobs Available","45+ Internships/Trainee Jobs"));



        int numberOfColumns = 2;
        recyclerView.setLayoutManager(new GridLayoutManager(this, numberOfColumns));
        BackstageJobAdapter adapter = new BackstageJobAdapter(this,auditionsArrayList);
        recyclerView.setAdapter(adapter);
        adapter.setClickListener(this);


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

        Intent intent=new Intent(getApplicationContext(), VoiceOverJobs.class);

        switch (position){
         case 0:startActivity(new Intent(getApplicationContext(), FindJobActivity.class));
                break;
            case 1:intent.putExtra("Job Title","Voice Job");
                startActivity(intent);
                break;
            case 2:intent.putExtra("Job Title","Music Job");
                startActivity(intent);
                break;
            case 3:intent.putExtra("Job Title","Makeup Job");
                startActivity(intent);
                break;
            case 4:intent.putExtra("Job Title","Costume Job");
                startActivity(intent);
                break;
            case 5:intent.putExtra("Job Title","Direction Job");
                startActivity(intent);
                break;
            case 6:intent.putExtra("Job Title","Acting Job");
                startActivity(intent);
                break;
            case 7:intent.putExtra("Job Title","Action Job");
                startActivity(intent);
                break;
            case 8:intent.putExtra("Job Title","Dance Job");
                startActivity(intent);
                break;
            case 9:intent.putExtra("Job Title","Editing Job");
                startActivity(intent);
                break;
            case 10:intent.putExtra("Job Title","Camera Production Job");
                startActivity(intent);
                break;
            case 11:intent.putExtra("Job Title","Other Job");
                startActivity(intent);
                break;
            case 12:intent.putExtra("Job Title","Marketing Job");
                startActivity(intent);
                break;
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