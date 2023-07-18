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

public class PortfolioPassport extends AppCompatActivity implements View.OnClickListener {

    ImageView portfolioImg,clickImg,backstage_icon,santa_img;
    GifImageView fab,live_chat;
    GifImageView acting_classes,auditions_alert,casting_call,child_actors,contact_us,dance_classes,frequently_asked_questions,
            modeling_agency,modeling_jobs,online_auditions,post_casting_call,media_jobs,become_affiliateagent,agents_managers,media_internship;
    private UnifiedNativeAd nativeAd;
    LinearLayout register_now,create_profile;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portfolio_passport);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        acting_classes=findViewById(R.id.acting_classes);
        auditions_alert=findViewById(R.id.auditions_alert);
        casting_call=findViewById(R.id.casting_call);
        child_actors=findViewById(R.id.child_actors);
        contact_us=findViewById(R.id.contact_us);
        dance_classes=findViewById(R.id.dance_classes);
        frequently_asked_questions=findViewById(R.id.frequently_asked_questions);
        modeling_agency=findViewById(R.id.modeling_agency);
        modeling_jobs=findViewById(R.id.modeling_jobs);
        online_auditions=findViewById(R.id.online_auditions);
        post_casting_call=findViewById(R.id.post_casting_call);
        media_jobs=findViewById(R.id.media_jobs);
        become_affiliateagent=findViewById(R.id.become_affiliateagent);
        agents_managers=findViewById(R.id.agents_managers);
        media_internship=findViewById(R.id.media_internship);

       register_now=findViewById(R.id.register_now);
        create_profile=findViewById(R.id.create_profile);

//        portfolioImg=findViewById(R.id.portfolioImg);
//        clickImg=findViewById(R.id.clickImg);
        fab = findViewById(R.id.fab);
        live_chat=findViewById(R.id.live_chat);
        backstage_icon=findViewById(R.id.backstage_icon);
        santa_img=findViewById(R.id.santa_img);

//        Picasso.with(this).load("https://images.backstageaudition.com/talent_img.png").fit().into(portfolioImg);
//        Picasso.with(this).load("https://images.backstageaudition.com/click_img.png").fit().into(clickImg);
       // Glide.with(this).load("https://images.backstageaudition.com/chat_gif.gif").into(fab);
        Picasso.with(this).load("https://images.backstageaudition.com/backstage_new1.png").fit().into(backstage_icon);
        Picasso.with(this).load("https://images.backstageaudition.com/backstage_new2.png").fit().into(santa_img);

//        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink_animation);
//        clickImg.startAnimation(animation);

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

        Glide.with(this).load("https://images.backstageaudition.com/acting_classes.gif").into(acting_classes);
        Glide.with(this).load("https://images.backstageaudition.com/auditions_alert.gif").into(auditions_alert);
        Glide.with(this).load("https://images.backstageaudition.com/casting_call.gif").into(casting_call);
        Glide.with(this).load("https://images.backstageaudition.com/child_actors.gif").into(child_actors);
        Glide.with(this).load("https://images.backstageaudition.com/contact_us.gif").into(contact_us);
        Glide.with(this).load("https://images.backstageaudition.com/dance_classes.gif").into(dance_classes);
        Glide.with(this).load("https://images.backstageaudition.com/frequently_asked_questions.gif").into(frequently_asked_questions);
        Glide.with(this).load("https://images.backstageaudition.com/modeling_agency.gif").into(modeling_agency);
        Glide.with(this).load("https://images.backstageaudition.com/modeling_jobs.gif").into(modeling_jobs);
        Glide.with(this).load("https://images.backstageaudition.com/online_auditions.gif").into(online_auditions);
        Glide.with(this).load("https://images.backstageaudition.com/post_casting_call.gif").into(post_casting_call);
        Glide.with(this).load("https://images.backstageaudition.com/media_jobs.gif").into(media_jobs);
        Glide.with(this).load("https://images.backstageaudition.com/become_affiliateagent.gif").into(become_affiliateagent);
        Glide.with(this).load("https://images.backstageaudition.com/agents_managers.gif").into(agents_managers);
        Glide.with(this).load("https://images.backstageaudition.com/media_internship.gif").into(media_internship);

        acting_classes.setOnClickListener(this);
        auditions_alert.setOnClickListener(this);
        casting_call.setOnClickListener(this);
        child_actors.setOnClickListener(this);
        contact_us.setOnClickListener(this);
        dance_classes.setOnClickListener(this);
        frequently_asked_questions.setOnClickListener(this);
        modeling_agency.setOnClickListener(this);
        modeling_jobs.setOnClickListener(this);
        online_auditions.setOnClickListener(this);
        post_casting_call.setOnClickListener(this);
        media_jobs.setOnClickListener(this);
        become_affiliateagent.setOnClickListener(this);
        agents_managers.setOnClickListener(this);
        media_internship.setOnClickListener(this);




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
    public void onClick(View v) {

        Intent intent=new Intent(getApplicationContext(),PortfolioActivity.class);

        switch (v.getId()){
            case R.id.acting_classes:intent.putExtra("Title","Acting Classes");
                break;
            case R.id.auditions_alert:intent.putExtra("Title","Auditions Alert");
                break;
            case R.id.casting_call:intent.putExtra("Title","Casting Call");
                break;
            case R.id.child_actors:intent.putExtra("Title","Child Actors");
                break;
            case R.id.contact_us:intent.putExtra("Title","Contact Us");
                break;
            case R.id.dance_classes:intent.putExtra("Title","Dance Classes");
                break;
            case R.id.frequently_asked_questions:intent.putExtra("Title","Frequently Asked Questions");
                break;
            case R.id.modeling_agency:intent.putExtra("Title","Modeling Agency");
                break;
            case R.id.modeling_jobs:intent.putExtra("Title","Modeling Jobs");
                break;
            case R.id.online_auditions:intent.putExtra("Title","Online Auditions");
                break;
            case R.id.post_casting_call:intent.putExtra("Title","Post Casting Call");
                break;
            case R.id.media_jobs:intent.putExtra("Title","Media Jobs");
                break;
            case R.id.become_affiliateagent:intent.putExtra("Title","Become Affiliate/Agent");
                break;
            case R.id.agents_managers:intent.putExtra("Title","Agents/Managers");
                break;
            case R.id.media_internship:intent.putExtra("Title","Media Internship");
                break;

        }
        startActivity(intent);
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