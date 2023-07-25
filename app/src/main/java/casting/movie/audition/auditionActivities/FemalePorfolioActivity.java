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
import casting.movie.audition.models.Auditions;
import casting.movie.audition.models.MaleFemaleAdapter;
import pl.droidsonroids.gif.GifImageView;

public class FemalePorfolioActivity extends AppCompatActivity implements MaleFemaleAdapter.ItemClickListener{

    ImageView backstage_icon,santa_img;
    GifImageView fab,live_chat;
    LinearLayout register_now,create_profile;
    private UnifiedNativeAd nativeAd;
    RecyclerView recyclerView;
    ArrayList<Auditions> auditionsArrayList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_female_porfolio);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Female Auditions");
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

        auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/women_age_0.png","135+ Jobs Available","45+ Internships/Trainee Jobs"));
        auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/women_age_5.png","265+ Jobs Available","145+ Internships/Trainee Jobs"));
        auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/women_age_8.png","215+ Jobs Available","245+ Internships/Trainee Jobs"));
        auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/women_age_13.png","145+ Jobs Available","345+ Internships/Trainee Jobs"));
        auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/women_age_18.png","164+ Jobs Available","445+ Internships/Trainee Jobs"));
        auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/women_age_20.png","126+ Jobs Available","545+ Internships/Trainee Jobs"));
        auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/women_age_25.png","182+ Jobs Available","45+ Internships/Trainee Jobs"));
        auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/women_age_30.png","117+ Jobs Available","145+ Internships/Trainee Jobs"));
        auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/women_age_35.png","169+ Jobs Available","245+ Internships/Trainee Jobs"));
        auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/women_age_40.png","150+ Jobs Available","345+ Internships/Trainee Jobs"));
        auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/women_age_45.png","145+ Jobs Available","445+ Internships/Trainee Jobs"));
        auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/women_age_50.png","139+ Jobs Available","545+ Internships/Trainee Jobs"));
        auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/women_age_55.png","174+ Jobs Available","45+ Internships/Trainee Jobs"));
        auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/women_age_60.png","155+ Jobs Available","145+ Internships/Trainee Jobs"));
        auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/women_age_65.png","195+ Jobs Available","245+ Internships/Trainee Jobs"));
        auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/women_age_70.png","285+ Jobs Available","345+ Internships/Trainee Jobs"));
        auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/women_age_75.png","185+ Jobs Available","445+ Internships/Trainee Jobs"));
        auditionsArrayList.add(new Auditions("https://images.backstageaudition.com/women_age_80.png","205+ Jobs Available","545+ Internships/Trainee Jobs"));


        int numberOfColumns = 3;
        recyclerView.setLayoutManager(new GridLayoutManager(this, numberOfColumns));
        MaleFemaleAdapter adapter = new MaleFemaleAdapter(this,auditionsArrayList);
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
        Intent intent=new Intent(getApplicationContext(),AgeAuditionsFemaleActivity.class);

        switch (position) {
            case 0:intent.putExtra("AGE","0-5");
                break;
            case 1:intent.putExtra("AGE","6-8");
                break;
            case 2:intent.putExtra("AGE","9-13");
                break;
            case 3:intent.putExtra("AGE","14-18");
                break;
            case 4:intent.putExtra("AGE","19-20");
                break;
            case 5:intent.putExtra("AGE","21-25");
                break;
            case 6:intent.putExtra("AGE","26-30");
                break;
            case 7:intent.putExtra("AGE","31-35");
                break;
            case 8:intent.putExtra("AGE","36-40");
                break;
            case 9:intent.putExtra("AGE","41-45");
                break;
            case 10:intent.putExtra("AGE","46-50");
                break;
            case 11:intent.putExtra("AGE","51-55");
                break;
            case 12:intent.putExtra("AGE","56-60");
                break;
            case 13:intent.putExtra("AGE","61-65");
                break;
            case 14:intent.putExtra("AGE","66-70");
                break;
            case 15:intent.putExtra("AGE","71-75");
                break;
            case 16:intent.putExtra("AGE","76-80");
                break;
            case 17:intent.putExtra("AGE","80+");
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