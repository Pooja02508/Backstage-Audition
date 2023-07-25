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

import casting.movie.audition.auditionActivities.AuditionByAge;
import casting.movie.audition.activities.ChatbotActivity;
import casting.movie.audition.fragments.AuditionsFragment;
import casting.movie.audition.fragments.BackstageJobsFragment;
import casting.movie.audition.fragments.DashboardFragment;
import casting.movie.audition.fragments.HomeFragment;
import casting.movie.audition.fragments.ProfileFragment;
import casting.movie.audition.R;
import casting.movie.audition.models.AuditionAdapter;
import casting.movie.audition.models.Auditions;
import pl.droidsonroids.gif.GifImageView;

public class AuditionForYoung extends AppCompatActivity implements AuditionAdapter.ItemClickListener {

    RecyclerView recyclerView;
    ArrayList<Auditions> auditionsArrayList=new ArrayList<>();
    private UnifiedNativeAd nativeAd;
    ImageView portfolioImg,clickImg,backstage_icon,santa_img;
    GifImageView fab,live_chat;
    LinearLayout register_now,create_profile;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audition_for_young);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView=findViewById(R.id.recyclerView);
//        portfolioImg=findViewById(R.id.portfolioImg);
//        clickImg=findViewById(R.id.clickImg);
         fab=findViewById(R.id.fab);
        live_chat=findViewById(R.id.live_chat);
        backstage_icon=findViewById(R.id.backstage_icon);
        santa_img=findViewById(R.id.santa_img);

       register_now=findViewById(R.id.register_now);
        create_profile=findViewById(R.id.create_profile);

//        Picasso.with(this).load("https://images.backstageaudition.com/talent_img.png").fit().into(portfolioImg);
//        Picasso.with(this).load("https://images.backstageaudition.com/click_img.png").fit().into(clickImg);
       // Glide.with(this).load("https://images.backstageaudition.com/chat_gif.gif").into(fab);
        Picasso.with(this).load("https://images.backstageaudition.com/backstage_new1.png").fit().into(backstage_icon);
        Picasso.with(this).load("https://images.backstageaudition.com/backstage_new2.png").fit().into(santa_img);

//        Animation animation3 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink_animation);
//        clickImg.startAnimation(animation3);
//
//        portfolioImg.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=portfolio.com"));
//                startActivity(intent);
//            }
//        });
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

        String AGE=getIntent().getStringExtra("AGE");

        if(AGE.equals("0-5")){
            auditionsArrayList.add(new Auditions("★ Auditions and Casting Calls for 0 year old","https://images.backstageaudition.com/year_3.png"));
            auditionsArrayList.add(new Auditions("★ Auditions and Casting Calls for 1 year old","https://images.backstageaudition.com/year_3.png"));
            auditionsArrayList.add(new Auditions("★ Auditions and Casting Calls for 2 year old","https://images.backstageaudition.com/year_3.png"));
            auditionsArrayList.add(new Auditions("★ Auditions and Casting Calls for 3 year old","https://images.backstageaudition.com/year_3.png"));
            auditionsArrayList.add(new Auditions("★ Auditions and Casting Calls for 4 year old","https://images.backstageaudition.com/year_3.png"));
            auditionsArrayList.add(new Auditions("★ Auditions and Casting Calls for 5 year old","https://images.backstageaudition.com/year_3.png"));

        }
        else if(AGE.equals("6-12")){
            auditionsArrayList.add(new Auditions("★ Auditions and Casting Calls for 6 year old","https://images.backstageaudition.com/year_3.png"));
            auditionsArrayList.add(new Auditions("★ Auditions and Casting Calls for 7 year old","https://images.backstageaudition.com/year_3.png"));
            auditionsArrayList.add(new Auditions("★ Auditions and Casting Calls for 8 year old","https://images.backstageaudition.com/year_3.png"));
            auditionsArrayList.add(new Auditions("★ Auditions and Casting Calls for 9 year old","https://images.backstageaudition.com/year_3.png"));
            auditionsArrayList.add(new Auditions("★ Auditions and Casting Calls for 10 year old","https://images.backstageaudition.com/year_3.png"));
            auditionsArrayList.add(new Auditions("★ Auditions and Casting Calls for 11 year old","https://images.backstageaudition.com/year_3.png"));
            auditionsArrayList.add(new Auditions("★ Auditions and Casting Calls for 12 year old","https://images.backstageaudition.com/year_3.png"));

        }
        else if(AGE.equals("13-19")){
            auditionsArrayList.add(new Auditions("★ Auditions and Casting Calls for 13 year old","https://images.backstageaudition.com/year_3.png"));
            auditionsArrayList.add(new Auditions("★ Auditions and Casting Calls for 14 year old","https://images.backstageaudition.com/year_3.png"));
            auditionsArrayList.add(new Auditions("★ Auditions and Casting Calls for 15 year old","https://images.backstageaudition.com/year_3.png"));
            auditionsArrayList.add(new Auditions("★ Auditions and Casting Calls for 16 year old","https://images.backstageaudition.com/year_3.png"));
            auditionsArrayList.add(new Auditions("★ Auditions and Casting Calls for 17 year old","https://images.backstageaudition.com/year_3.png"));
            auditionsArrayList.add(new Auditions("★ Auditions and Casting Calls for 18 year old","https://images.backstageaudition.com/year_3.png"));
            auditionsArrayList.add(new Auditions("★ Auditions and Casting Calls for 19 year old","https://images.backstageaudition.com/year_3.png"));
        }

        else if(AGE.equals("20-25")){
            auditionsArrayList.add(new Auditions("★ Auditions and Casting Calls for 20 year old","https://images.backstageaudition.com/year_3.png"));
            auditionsArrayList.add(new Auditions("★ Auditions and Casting Calls for 21 year old","https://images.backstageaudition.com/year_3.png"));
            auditionsArrayList.add(new Auditions("★ Auditions and Casting Calls for 22 year old","https://images.backstageaudition.com/year_3.png"));
            auditionsArrayList.add(new Auditions("★ Auditions and Casting Calls for 23 year old","https://images.backstageaudition.com/year_3.png"));
            auditionsArrayList.add(new Auditions("★ Auditions and Casting Calls for 24 year old","https://images.backstageaudition.com/year_3.png"));
            auditionsArrayList.add(new Auditions("★ Auditions and Casting Calls for 25 year old","https://images.backstageaudition.com/year_3.png"));
        }
        else if(AGE.equals("26-40")){
            auditionsArrayList.add(new Auditions("★ Auditions and Casting Calls for 26 year old","https://images.backstageaudition.com/year_3.png"));
            auditionsArrayList.add(new Auditions("★ Auditions and Casting Calls for 27 year old","https://images.backstageaudition.com/year_3.png"));
            auditionsArrayList.add(new Auditions("★ Auditions and Casting Calls for 28 year old","https://images.backstageaudition.com/year_3.png"));
            auditionsArrayList.add(new Auditions("★ Auditions and Casting Calls for 29 year old","https://images.backstageaudition.com/year_3.png"));
            auditionsArrayList.add(new Auditions("★ Auditions and Casting Calls for 30 year old","https://images.backstageaudition.com/year_3.png"));
            auditionsArrayList.add(new Auditions("★ Auditions and Casting Calls for 31 year old","https://images.backstageaudition.com/year_3.png"));
            auditionsArrayList.add(new Auditions("★ Auditions and Casting Calls for 32 year old","https://images.backstageaudition.com/year_3.png"));
            auditionsArrayList.add(new Auditions("★ Auditions and Casting Calls for 33 year old","https://images.backstageaudition.com/year_3.png"));
            auditionsArrayList.add(new Auditions("★ Auditions and Casting Calls for 34 year old","https://images.backstageaudition.com/year_3.png"));
            auditionsArrayList.add(new Auditions("★ Auditions and Casting Calls for 35 year old","https://images.backstageaudition.com/year_3.png"));
            auditionsArrayList.add(new Auditions("★ Auditions and Casting Calls for 36 year old","https://images.backstageaudition.com/year_3.png"));
            auditionsArrayList.add(new Auditions("★ Auditions and Casting Calls for 37 year old","https://images.backstageaudition.com/year_3.png"));
            auditionsArrayList.add(new Auditions("★ Auditions and Casting Calls for 38 year old","https://images.backstageaudition.com/year_3.png"));
            auditionsArrayList.add(new Auditions("★ Auditions and Casting Calls for 39 year old","https://images.backstageaudition.com/year_3.png"));
            auditionsArrayList.add(new Auditions("★ Auditions and Casting Calls for 40 year old","https://images.backstageaudition.com/year_3.png"));
        }
        else if(AGE.equals("41-50")){
            auditionsArrayList.add(new Auditions("★ Auditions and Casting Calls for 41 year old","https://images.backstageaudition.com/year_3.png"));
            auditionsArrayList.add(new Auditions("★ Auditions and Casting Calls for 42 year old","https://images.backstageaudition.com/year_3.png"));
            auditionsArrayList.add(new Auditions("★ Auditions and Casting Calls for 43 year old","https://images.backstageaudition.com/year_3.png"));
            auditionsArrayList.add(new Auditions("★ Auditions and Casting Calls for 44 year old","https://images.backstageaudition.com/year_3.png"));
            auditionsArrayList.add(new Auditions("★ Auditions and Casting Calls for 45 year old","https://images.backstageaudition.com/year_3.png"));
            auditionsArrayList.add(new Auditions("★ Auditions and Casting Calls for 46 year old","https://images.backstageaudition.com/year_3.png"));
            auditionsArrayList.add(new Auditions("★ Auditions and Casting Calls for 47 year old","https://images.backstageaudition.com/year_3.png"));
            auditionsArrayList.add(new Auditions("★ Auditions and Casting Calls for 48 year old","https://images.backstageaudition.com/year_3.png"));
            auditionsArrayList.add(new Auditions("★ Auditions and Casting Calls for 49 year old","https://images.backstageaudition.com/year_3.png"));
            auditionsArrayList.add(new Auditions("★ Auditions and Casting Calls for 50 year old","https://images.backstageaudition.com/year_3.png"));
        }
        else if(AGE.equals("51-60")){
            auditionsArrayList.add(new Auditions("★ Auditions and Casting Calls for 51 year old","https://images.backstageaudition.com/year_3.png"));
            auditionsArrayList.add(new Auditions("★ Auditions and Casting Calls for 52 year old","https://images.backstageaudition.com/year_3.png"));
            auditionsArrayList.add(new Auditions("★ Auditions and Casting Calls for 53 year old","https://images.backstageaudition.com/year_3.png"));
            auditionsArrayList.add(new Auditions("★ Auditions and Casting Calls for 54 year old","https://images.backstageaudition.com/year_3.png"));
            auditionsArrayList.add(new Auditions("★ Auditions and Casting Calls for 55 year old","https://images.backstageaudition.com/year_3.png"));
            auditionsArrayList.add(new Auditions("★ Auditions and Casting Calls for 56 year old","https://images.backstageaudition.com/year_3.png"));
            auditionsArrayList.add(new Auditions("★ Auditions and Casting Calls for 57 year old","https://images.backstageaudition.com/year_3.png"));
            auditionsArrayList.add(new Auditions("★ Auditions and Casting Calls for 58 year old","https://images.backstageaudition.com/year_3.png"));
            auditionsArrayList.add(new Auditions("★ Auditions and Casting Calls for 59 year old","https://images.backstageaudition.com/year_3.png"));
            auditionsArrayList.add(new Auditions("★ Auditions and Casting Calls for 60 year old","https://images.backstageaudition.com/year_3.png"));
        }
        else if(AGE.equals("61-80")){
            auditionsArrayList.add(new Auditions("★ Auditions and Casting Calls for 61 year old","https://images.backstageaudition.com/year_3.png"));
            auditionsArrayList.add(new Auditions("★ Auditions and Casting Calls for 62 year old","https://images.backstageaudition.com/year_3.png"));
            auditionsArrayList.add(new Auditions("★ Auditions and Casting Calls for 63 year old","https://images.backstageaudition.com/year_3.png"));
            auditionsArrayList.add(new Auditions("★ Auditions and Casting Calls for 64 year old","https://images.backstageaudition.com/year_3.png"));
            auditionsArrayList.add(new Auditions("★ Auditions and Casting Calls for 65 year old","https://images.backstageaudition.com/year_3.png"));
            auditionsArrayList.add(new Auditions("★ Auditions and Casting Calls for 66 year old","https://images.backstageaudition.com/year_3.png"));
            auditionsArrayList.add(new Auditions("★ Auditions and Casting Calls for 67 year old","https://images.backstageaudition.com/year_3.png"));
            auditionsArrayList.add(new Auditions("★ Auditions and Casting Calls for 68 year old","https://images.backstageaudition.com/year_3.png"));
            auditionsArrayList.add(new Auditions("★ Auditions and Casting Calls for 69 year old","https://images.backstageaudition.com/year_3.png"));
            auditionsArrayList.add(new Auditions("★ Auditions and Casting Calls for 70 year old","https://images.backstageaudition.com/year_3.png"));
            auditionsArrayList.add(new Auditions("★ Auditions and Casting Calls for 71 year old","https://images.backstageaudition.com/year_3.png"));
            auditionsArrayList.add(new Auditions("★ Auditions and Casting Calls for 72 year old","https://images.backstageaudition.com/year_3.png"));
            auditionsArrayList.add(new Auditions("★ Auditions and Casting Calls for 73 year old","https://images.backstageaudition.com/year_3.png"));
            auditionsArrayList.add(new Auditions("★ Auditions and Casting Calls for 74 year old","https://images.backstageaudition.com/year_3.png"));
            auditionsArrayList.add(new Auditions("★ Auditions and Casting Calls for 75 year old","https://images.backstageaudition.com/year_3.png"));
            auditionsArrayList.add(new Auditions("★ Auditions and Casting Calls for 76 year old","https://images.backstageaudition.com/year_3.png"));
            auditionsArrayList.add(new Auditions("★ Auditions and Casting Calls for 77 year old","https://images.backstageaudition.com/year_3.png"));
            auditionsArrayList.add(new Auditions("★ Auditions and Casting Calls for 78 year old","https://images.backstageaudition.com/year_3.png"));
            auditionsArrayList.add(new Auditions("★ Auditions and Casting Calls for 79 year old","https://images.backstageaudition.com/year_3.png"));
            auditionsArrayList.add(new Auditions("★ Auditions and Casting Calls for 80 year old","https://images.backstageaudition.com/year_3.png"));
        }

        int numberOfColumns = 2;
        recyclerView.setLayoutManager(new GridLayoutManager(this, numberOfColumns));
        AuditionAdapter adapter = new AuditionAdapter(this,auditionsArrayList);
        recyclerView.setAdapter(adapter);
        adapter.setClickListener(this);

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

        Intent intent=new Intent(getApplicationContext(), AuditionByAge.class);

        switch (position){
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                startActivity(intent);
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