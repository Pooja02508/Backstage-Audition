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
import casting.movie.audition.models.JobsAdapter;
import pl.droidsonroids.gif.GifImageView;

public class JobsActivity extends AppCompatActivity implements JobsAdapter.ItemClickListener{

    RecyclerView recyclerView;
    ArrayList<Auditions> auditionsArrayList=new ArrayList<>();
    private UnifiedNativeAd nativeAd;
    ImageView portfolioImg,clickImg,backstage_icon,santa_img;
   GifImageView fab,live_chat;
   LinearLayout register_now,create_profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jobs);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView=findViewById(R.id.recyclerView);

        fab = findViewById(R.id.fab);
        live_chat=findViewById(R.id.live_chat);
//        portfolioImg=findViewById(R.id.portfolioImg);
//        clickImg=findViewById(R.id.clickImg);
        backstage_icon=findViewById(R.id.backstage_icon);
        santa_img=findViewById(R.id.santa_img);

       register_now=findViewById(R.id.register_now);
        create_profile=findViewById(R.id.create_profile);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav_view);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();

//        Picasso.with(this).load("https://images.backstageaudition.com/talent_img.png").fit().into(portfolioImg);
//        Picasso.with(this).load("https://images.backstageaudition.com/click_img.png").fit().into(clickImg);
       // Glide.with(this).load("https://images.backstageaudition.com/chat_gif.gif").into(fab);
        Picasso.with(this).load("https://images.backstageaudition.com/backstage_new1.png").fit().into(backstage_icon);
        Picasso.with(this).load("https://images.backstageaudition.com/backstage_new2.png").fit().into(santa_img);

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
//        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink_animation);
//        clickImg.startAnimation(animation);
//
//        portfolioImg.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=portfolio.com"));
//                startActivity(intent);
//            }
//        });


        auditionsArrayList.add(new Auditions("Producer","https://images.backstageaudition.com/producer.jpg","135+ Jobs Available","45+ Internships/Trainee Jobs"));
        auditionsArrayList.add(new Auditions("Director","https://images.backstageaudition.com/director.png","100+ Jobs Available","28+ Internships/Trainee Jobs"));
        auditionsArrayList.add(new Auditions("Screenwriter","https://images.backstageaudition.com/screenwriter.jpg","163+ Jobs Available","47+ Internships/Trainee Jobs"));
        auditionsArrayList.add(new Auditions("Voice Over","https://images.backstageaudition.com/voice_over_jobs.png","383+ Jobs Available","247+ Internships/Trainee Jobs"));
        auditionsArrayList.add(new Auditions("Director of Photography","https://images.backstageaudition.com/cinematographer.jpg","250+ Jobs Available","61+ Internships/Trainee Jobs"));
        auditionsArrayList.add(new Auditions("Production Designer","https://images.backstageaudition.com/production_designer.jpg","203+ Jobs Available","37+ Internships/Trainee Jobs"));
        auditionsArrayList.add(new Auditions("Art Director","https://images.backstageaudition.com/art_director.jpg","148+ Jobs Available","52+ Internships/Trainee Jobs"));
        auditionsArrayList.add(new Auditions("Costume Designer","https://images.backstageaudition.com/costume_designer.jpg","180+ Jobs Available","95+ Internships/Trainee Jobs"));
        auditionsArrayList.add(new Auditions("Casting Director","https://images.backstageaudition.com/casting_director.png","220+ Jobs Available","63+ Internships/Trainee Jobs"));
        auditionsArrayList.add(new Auditions("Production Manager","https://images.backstageaudition.com/production_manager.jpg","260+ Jobs Available","82+ Internships/Trainee Jobs"));
        auditionsArrayList.add(new Auditions("Assistant Director (AD)","https://images.backstageaudition.com/assistant_director.jpg","209+ Jobs Available","34+ Internships/Trainee Jobs"));
        auditionsArrayList.add(new Auditions("Editor","https://images.backstageaudition.com/editor.jpg","155+ Jobs Available","45+ Internships/Trainee Jobs"));
        auditionsArrayList.add(new Auditions("Sound Designer","https://images.backstageaudition.com/sound_designer.jpg","125+ Jobs Available","90+ Internships/Trainee Jobs"));
        auditionsArrayList.add(new Auditions("Composer","https://images.backstageaudition.com/composer.jpg","230+ Jobs Available","75+ Internships/Trainee Jobs"));
        auditionsArrayList.add(new Auditions("Visual Effects (VFX) Supervisor","https://images.backstageaudition.com/visual_effects.jpg","200+ Jobs Available","69+ Internships/Trainee Jobs"));
        auditionsArrayList.add(new Auditions("Production Sound Mixer","https://images.backstageaudition.com/sound_mixer.jpg","100+ Jobs Available","50+ Internships/Trainee Jobs"));
        auditionsArrayList.add(new Auditions("Grip","https://images.backstageaudition.com/grip.jpg","185+ Jobs Available","65+ Internships/Trainee Jobs"));
        auditionsArrayList.add(new Auditions("Gaffer","https://images.backstageaudition.com/gaffer.jpg","215+ Jobs Available","245+ Internships/Trainee Jobs"));
        auditionsArrayList.add(new Auditions("Production Assistant (PA)","https://images.backstageaudition.com/production_assistant.jpg","200+ Jobs Available","49+ Internships/Trainee Jobs"));

        int numberOfColumns = 3;
        recyclerView.setLayoutManager(new GridLayoutManager(this, numberOfColumns));
        JobsAdapter adapter = new JobsAdapter(this,auditionsArrayList);
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
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onItemClick(View view, int position) {

        Intent intent=new Intent(getApplicationContext(), JobsDetailsActivity.class);
        switch (position){
            case 0:
            case 1:
            case 2:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17: startActivity(intent);
                break;
            case 3:startActivity(new Intent(getApplicationContext(), VoiceOverJobs.class));
                break;
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