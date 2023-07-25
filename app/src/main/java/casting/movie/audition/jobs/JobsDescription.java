package casting.movie.audition.jobs;

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

import casting.movie.audition.activities.ChatbotActivity;
import casting.movie.audition.fragments.AuditionsFragment;
import casting.movie.audition.fragments.BackstageJobsFragment;
import casting.movie.audition.fragments.DashboardFragment;
import casting.movie.audition.fragments.HomeFragment;
import casting.movie.audition.fragments.ProfileFragment;
import casting.movie.audition.R;
import pl.droidsonroids.gif.GifImageView;

public class JobsDescription extends AppCompatActivity {

    ImageView portfolioImg,clickImg,backstage_icon,santa_img;
   GifImageView fab,live_chat;
    ImageView portfolio_bg;
    GifImageView backstage_share1,backstage_share2;
    TextView portfolio_website,backstage_website,job_desc;
    private UnifiedNativeAd nativeAd;
    Button btn1,btn2;
    ImageView audition_alert_img,backstage_mobile_img,dubbing_artist_desc,cma,portfolio_icon,cma2,portfolio_icon2,daily_audition_updates;
    GifImageView cameraman_gif,signup_now,backstage_social,signup_now2,signup_now3,signup_now4,casting_agent,production_companies,create_portfolio_free_online,
    backstage_casting_agency,backstage_online_audition,backstage_casting_calls,auditions_near_me,backstage_online_audition2,backstage_casting_calls2,backstage_casting_app,
            backstage_casting_app2,backstage_online_audition3,backstage_casting_calls3;
   LinearLayout register_now,create_profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jobs_description);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


       register_now=findViewById(R.id.register_now);
        create_profile=findViewById(R.id.create_profile);
        fab = findViewById(R.id.fab);
        live_chat=findViewById(R.id.live_chat);
//        portfolioImg=findViewById(R.id.portfolioImg);
//        clickImg=findViewById(R.id.clickImg);
        dubbing_artist_desc=findViewById(R.id.dubbing_artist_desc);
        job_desc=findViewById(R.id.job_desc);
        portfolio_bg=findViewById(R.id.portfolio_bg);
        portfolio_website=findViewById(R.id.portfolio_website);
        backstage_website=findViewById(R.id.backstage_website);
        backstage_share1=findViewById(R.id.backstage_share1);
        backstage_share2=findViewById(R.id.backstage_share2);
        backstage_icon=findViewById(R.id.backstage_icon);
        santa_img=findViewById(R.id.santa_img);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        audition_alert_img = findViewById(R.id.audition_alert_img);
        backstage_mobile_img = findViewById(R.id.backstage_mobile_img);
        cma = findViewById(R.id.cma);
        portfolio_icon = findViewById(R.id.portfolio_icon);
        cma2 = findViewById(R.id.cma2);
        portfolio_icon2 = findViewById(R.id.portfolio_icon2);
        daily_audition_updates = findViewById(R.id.daily_audition_updates);
        cameraman_gif = findViewById(R.id.cameraman_gif);
        signup_now = findViewById(R.id.signup_now);
        backstage_social = findViewById(R.id.backstage_social);
        signup_now2 = findViewById(R.id.signup_now2);
        signup_now3 = findViewById(R.id.signup_now3);
        signup_now4 = findViewById(R.id.signup_now4);
        casting_agent = findViewById(R.id.casting_agent);
        production_companies = findViewById(R.id.production_companies);
        create_portfolio_free_online = findViewById(R.id.create_portfolio_free_online);
        backstage_casting_agency = findViewById(R.id.backstage_casting_agency);
        backstage_online_audition = findViewById(R.id.backstage_online_audition);
        backstage_casting_calls = findViewById(R.id.backstage_casting_calls);
        auditions_near_me = findViewById(R.id.auditions_near_me);
        backstage_online_audition2 = findViewById(R.id.backstage_online_audition2);
        backstage_casting_calls2 = findViewById(R.id.backstage_casting_calls2);
        backstage_casting_app = findViewById(R.id.backstage_casting_app);
        backstage_casting_app2 = findViewById(R.id.backstage_casting_app2);
        backstage_online_audition3 = findViewById(R.id.backstage_online_audition3);
        backstage_casting_calls3 = findViewById(R.id.backstage_casting_calls3);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav_view);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();

        String DESCRIPTION=getIntent().getStringExtra("DESCRIPTION");
        String JobImage=getIntent().getStringExtra("JobImage");


        job_desc.setText(DESCRIPTION+" jobs are available on backstageaudition.com.❤️  If you are searching for "+DESCRIPTION+" jobs near you, then you are at the right place. Apply to the "+DESCRIPTION+" job around the world, read the "+DESCRIPTION+" job description, and apply for "+DESCRIPTION+" jobs near you. click buttons below for more information");
        Picasso.with(this).load(JobImage).into(dubbing_artist_desc);



        Picasso.with(this).load("https://images.backstageaudition.com/backstage_new1.png").fit().into(backstage_icon);
        Picasso.with(this).load("https://images.backstageaudition.com/backstage_new2.png").fit().into(santa_img);
        Picasso.with(this).load("https://images.backstageaudition.com/portfolio_bg.png").fit().into(portfolio_bg);


        Picasso.with(this).load("https://images.backstageaudition.com/audition_alert_img.png").fit().into(audition_alert_img);
        Picasso.with(this).load("https://images.backstageaudition.com/backstage_mobile_img.png").fit().into(backstage_mobile_img);
        Picasso.with(this).load("https://images.backstageaudition.com/cma.png").fit().into(cma);
        Picasso.with(this).load("https://images.backstageaudition.com/cma.png").fit().into(cma2);
        Picasso.with(this).load("https://images.backstageaudition.com/portfolio_icon.png").fit().into(portfolio_icon);
        Picasso.with(this).load("https://images.backstageaudition.com/portfolio_icon.png").fit().into(portfolio_icon2);
        Picasso.with(this).load("https://images.backstageaudition.com/daily_audition_updates.png").fit().into(daily_audition_updates);


        Glide.with(this).load("https://images.backstageaudition.com/cameraman_gif.gif").into(cameraman_gif);
        Glide.with(this).load("https://images.backstageaudition.com/signup_now.gif").into(signup_now);
        Glide.with(this).load("https://images.backstageaudition.com/signup_now.gif").into(signup_now2);
        Glide.with(this).load("https://images.backstageaudition.com/signup_now.gif").into(signup_now3);
        Glide.with(this).load("https://images.backstageaudition.com/signup_now.gif").into(signup_now4);
        Glide.with(this).load("https://images.backstageaudition.com/backstage_social.gif").into(backstage_social);
        Glide.with(this).load("https://images.backstageaudition.com/casting_agent.gif").into(casting_agent);
        Glide.with(this).load("https://images.backstageaudition.com/production_companies.gif").into(production_companies);
        Glide.with(this).load("https://images.backstageaudition.com/create_portfolio_free_online.gif").into(create_portfolio_free_online);
        Glide.with(this).load("https://images.backstageaudition.com/backstage_casting_agency.gif").into(backstage_casting_agency);
        Glide.with(this).load("https://images.backstageaudition.com/backstage_online_audition.gif").into(backstage_online_audition);
        Glide.with(this).load("https://images.backstageaudition.com/backstage_casting_calls.gif").into(backstage_casting_calls);
        Glide.with(this).load("https://images.backstageaudition.com/auditions_near_me.gif").into(auditions_near_me);
        Glide.with(this).load("https://images.backstageaudition.com/backstage_online_audition.gif").into(backstage_online_audition2);
        Glide.with(this).load("https://images.backstageaudition.com/backstage_casting_calls.gif").into(backstage_casting_calls2);
        Glide.with(this).load("https://images.backstageaudition.com/backstage_casting_app.gif").into(backstage_casting_app);
        Glide.with(this).load("https://images.backstageaudition.com/backstage_casting_app.gif").into(backstage_casting_app2);
        Glide.with(this).load("https://images.backstageaudition.com/backstage_online_audition.gif").into(backstage_online_audition3);
        Glide.with(this).load("https://images.backstageaudition.com/backstage_casting_calls.gif").into(backstage_casting_calls3);

//        Animation animation3 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink_animation);
//        clickImg.startAnimation(animation3);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://a2zportfolio.com/contents/en-us/p2_Create-Portfolio-Online.html"));
                startActivity(intent);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://backstageaudition.com/contents/en-us/p5_Backstage-auditions-near-me.html"));
                startActivity(intent);
            }
        });
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
        backstage_share1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=casting.movie.audition"));
                startActivity(intent);
            }
        });
        backstage_share2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=portfolio.com"));
                startActivity(intent);
            }
        });

        portfolio_bg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=portfolio.com"));
                startActivity(intent);
            }
        });
        backstage_website.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://backstageaudition.com/"));
                startActivity(intent);
            }
        });
        portfolio_website.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.a2zportfolio.com/"));
                startActivity(intent);
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