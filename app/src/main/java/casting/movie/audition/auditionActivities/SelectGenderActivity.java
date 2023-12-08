package casting.movie.audition.auditionActivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

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

import com.bumptech.glide.Glide;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.squareup.picasso.Picasso;

import casting.movie.audition.activities.ChatbotActivity;
import casting.movie.audition.activities.WebViewActivity;
import casting.movie.audition.fragments.AuditionsFragment;
import casting.movie.audition.fragments.BackstageJobsFragment;
import casting.movie.audition.fragments.DashboardFragment;
import casting.movie.audition.fragments.HomeFragment;
import casting.movie.audition.fragments.ProfileFragment;
import casting.movie.audition.R;
import pl.droidsonroids.gif.GifImageView;

public class SelectGenderActivity extends AppCompatActivity {

    ImageView backstage_icon,santa_img;
    GifImageView fab,live_chat;
    Button male_prtfolio,female_prtfolio;
    GifImageView male_icon1,female_icon1;
    LinearLayout register_now,create_profile;
  
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_gender);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Select Gender");

        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav_view);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();

        fab=findViewById(R.id.fab);
        live_chat=findViewById(R.id.live_chat);
        register_now=findViewById(R.id.register_now);
        create_profile=findViewById(R.id.create_profile);
        backstage_icon=findViewById(R.id.backstage_icon);
        santa_img=findViewById(R.id.santa_img);
        male_icon1=findViewById(R.id.male_icon1);
        female_icon1=findViewById(R.id.female_icon1);
        male_prtfolio=findViewById(R.id.male_prtfolio);
        female_prtfolio=findViewById(R.id.female_prtfolio);

        Picasso.with(this).load("https://images.backstageaudition.com/backstage_new1.png").fit().into(backstage_icon);
        Picasso.with(this).load("https://images.backstageaudition.com/backstage_new2.png").fit().into(santa_img);
        Glide.with(this).load("https://images.backstageaudition.com/man_click_here_gif.gif").into(male_icon1);
        Glide.with(this).load("https://images.backstageaudition.com/women_click_here_gif.gif").into(female_icon1);


        male_icon1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MalePorfolioActivity.class));
            }
        });
        female_icon1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), FemalePorfolioActivity.class));
            }
        });
        male_prtfolio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MalePorfolioActivity.class));
            }
        });
        female_prtfolio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), FemalePorfolioActivity.class));
            }
        });
        register_now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), WebViewActivity.class);
                intent.putExtra("Link","https://backstageaudition.com/contents/en-us/p1181_Backstage-Profile-Create-Your-Casting-Profile.html");
                startActivity(intent);
//                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://backstageaudition.com/contents/en-us/p1181_Backstage-Profile-Create-Your-Casting-Profile.html")));
            }
        });
        create_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), WebViewActivity.class);
                intent.putExtra("Link","https://backstageaudition.com/contents/en-us/p1183_Create-an-acting-Portfolio.html");
                startActivity(intent);
//                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://backstageaudition.com/contents/en-us/p1183_Create-an-acting-Portfolio.html")));
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

       //        MobileAds.initialize(this, getString(R.string.ADMOB_ADS_UNIT_ID));
//
//        AdLoader.Builder builder = new AdLoader.Builder(this, getString(R.string.ADMOB_ADS_UNIT_ID));
//        builder.forUnifiedNativeAd(new UnifiedNativeAd.OnUnifiedNativeAdLoadedListener() {
//            @Override
//            public void onUnifiedNativeAdLoaded(UnifiedNativeAd unifiedNativeAd) {
//                if (nativeAd != null) {
//                    nativeAd.destroy();
//                }
//                nativeAd = unifiedNativeAd;
//                FrameLayout frameLayout =findViewById(R.id.fl_adplaceholder);
//                UnifiedNativeAdView adView = (UnifiedNativeAdView) getLayoutInflater().inflate(R.layout.ad_unified, null);
//
//                populateUnifiedNativeAdView(unifiedNativeAd, adView);
//                frameLayout.removeAllViews();
//                frameLayout.addView(adView);
//            }
//        });
//
//        NativeAdOptions adOptions = new NativeAdOptions.Builder().build();
//        builder.withNativeAdOptions(adOptions);
//        AdLoader adLoader = builder.withAdListener (new AdListener(){
//
//            @Override
//            public void onAdFailedToLoad(int i) {
//
//            }
//        }).build();
//        adLoader.loadAd(new AdRequest.Builder().build());
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

//    private void populateUnifiedNativeAdView(UnifiedNativeAd nativeAd, UnifiedNativeAdView adView) {
//
//        adView.setMediaView((MediaView) adView.findViewById(R.id.ad_media));
//        adView.setHeadlineView(adView.findViewById(R.id.ad_headline));
//        adView.setBodyView(adView.findViewById(R.id.ad_body));
//        adView.setCallToActionView(adView.findViewById(R.id.ad_call_to_action));
//        adView.setIconView(adView.findViewById(R.id.ad_app_icon));
//        adView.setPriceView(adView.findViewById(R.id.ad_price));
//        adView.setAdvertiserView(adView.findViewById(R.id.ad_advertiser));
//        adView.setStoreView(adView.findViewById(R.id.ad_store));
//        adView.setStarRatingView(adView.findViewById(R.id.ad_stars));
//
//        ((TextView)adView.getHeadlineView()).setText(nativeAd.getHeadline());
//        adView.getMediaView().setMediaContent(nativeAd.getMediaContent());
//
//        if (nativeAd.getBody() == null) {
//            adView.getBodyView().setVisibility(View.INVISIBLE);
//        } else {
//            adView.getBodyView().setVisibility(View.VISIBLE);
//            ((TextView) adView.getBodyView()).setText(nativeAd.getBody());
//        }
//        if (nativeAd.getCallToAction() == null) {
//            adView.getCallToActionView().setVisibility(View.INVISIBLE);
//        } else {
//            adView.getCallToActionView().setVisibility(View.VISIBLE);
//            ((Button) adView.getCallToActionView()).setText(nativeAd.getCallToAction());
//        }
//        if (nativeAd.getIcon() == null) {
//            adView.getIconView().setVisibility(View.GONE);
//        } else {
//            ((ImageView) adView.getIconView()).setImageDrawable(nativeAd.getIcon().getDrawable());
//            adView.getIconView().setVisibility(View.VISIBLE);
//        }
//        if (nativeAd.getPrice() == null) {
//            adView.getPriceView().setVisibility(View.INVISIBLE);
//        } else {
//            adView.getPriceView().setVisibility(View.VISIBLE);
//            ((TextView) adView.getPriceView()).setText(nativeAd.getPrice());
//        }
//        if (nativeAd.getStore() == null) {
//            adView.getStoreView().setVisibility(View.INVISIBLE);
//        } else {
//            adView.getStoreView().setVisibility(View.VISIBLE);
//            ((TextView) adView.getStoreView()).setText(nativeAd.getStore());
//
//        }
//        if (nativeAd.getStarRating() == null) {
//            adView.getStarRatingView().setVisibility(View.INVISIBLE);
//        } else {
//            ((RatingBar) adView.getStarRatingView()).setRating(nativeAd.getStarRating().floatValue());
//            adView.getStarRatingView().setVisibility(View.VISIBLE);
//        }
//        if (nativeAd.getAdvertiser() == null) {
//            adView.getAdvertiserView().setVisibility(View.INVISIBLE);
//
//        } else {
//            ((TextView) adView.getAdvertiserView()).setText(nativeAd.getAdvertiser());
//            adView.getAdvertiserView().setVisibility(View.VISIBLE);
//        }
//        adView.setNativeAd(nativeAd);
//    }

}