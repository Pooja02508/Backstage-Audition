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
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
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

import java.util.ArrayList;

import casting.movie.audition.activities.ChatbotActivity;
import casting.movie.audition.fragments.AuditionsFragment;
import casting.movie.audition.fragments.BackstageJobsFragment;
import casting.movie.audition.fragments.DashboardFragment;
import casting.movie.audition.fragments.HomeFragment;
import casting.movie.audition.fragments.ProfileFragment;
import casting.movie.audition.R;
import casting.movie.audition.auditionActivities.AuditionsAgeActivity;
import casting.movie.audition.models.Auditions;
import casting.movie.audition.models.BackstageJobAdapter;
import casting.movie.audition.models.ContactAdapter;
import casting.movie.audition.models.ContactUs;
import casting.movie.audition.models.HomeAdapter;
import pl.droidsonroids.gif.GifImageView;

public class AuditionsDetailActivity extends AppCompatActivity implements HomeAdapter.ItemClickListener, View.OnClickListener{

    private UnifiedNativeAd nativeAd;
    ArrayList<Auditions> auditionsArrayList=new ArrayList<>();
    ArrayList<ContactUs> auditionsArrayList2=new ArrayList<>();
    RecyclerView recyclerView,recyclerView2;
    LinearLayout register_now,create_profile;
    TextView age;
    ImageView audition_detail1,light_image,create_online_portfolio,create_free_profile;
    TextView portfolio_website,backstage_website;
    ImageView backstage_icon,santa_img,model_img;
    GifImageView fab,cameraman_gif,signup_now,live_chat;
    ImageView cma,portfolio_bg,cma2,portfolio_icon,portfolio_icon2,daily_audition_updates;
    GifImageView backstage_casting_app,backstage_online_audition,backstage_casting_calls,auditions_near_me, backstage_online_audition2,
            backstage_casting_calls2,backstage_casting_app2,backstage_online_audition3,backstage_casting_calls3,
            backstage_social,signupnow,signup_now2,signup_now3,signup_now4,casting_agent,production_companies,online_casting_director,
            create_portfolio_free_online,backstage_casting_agency,backstage_share1,backstage_share2;
    GifImageView acting_classes,auditions_alert,casting_call,child_actors,contact_us,dance_classes,frequently_asked_questions,
            modeling_agency,modeling_jobs,online_auditions,post_casting_call,media_jobs,become_affiliateagent,agents_managers,media_internship;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auditions_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav_view);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();

        fab=findViewById(R.id.fab);
        live_chat=findViewById(R.id.live_chat);
        register_now=findViewById(R.id.register_now);
        create_profile=findViewById(R.id.create_profile);
        backstage_icon=findViewById(R.id.backstage_icon);
        santa_img=findViewById(R.id.santa_img);
        model_img=findViewById(R.id.model_img);
        cameraman_gif=findViewById(R.id.cameraman_gif);
        signup_now=findViewById(R.id.signup_now);
        light_image=findViewById(R.id.light_image);
        audition_detail1=findViewById(R.id.audition_detail1);
        create_online_portfolio=findViewById(R.id.create_online_portfolio);
        create_free_profile=findViewById(R.id.create_free_profile);
        age=findViewById(R.id.age);
        portfolio_icon=findViewById(R.id.portfolio_icon);
        portfolio_icon2=findViewById(R.id.portfolio_icon2);
        portfolio_bg=findViewById(R.id.portfolio_bg);
        portfolio_website=findViewById(R.id.portfolio_website);
        backstage_website=findViewById(R.id.backstage_website);
        backstage_share1=findViewById(R.id.backstage_share1);
        backstage_share2=findViewById(R.id.backstage_share2);
        cma=findViewById(R.id.cma);
        cma2=findViewById(R.id.cma2);
        daily_audition_updates=findViewById(R.id.daily_audition_updates);
        backstage_casting_app=findViewById(R.id.backstage_casting_app);
        backstage_online_audition=findViewById(R.id.backstage_online_audition);
        backstage_casting_calls=findViewById(R.id.backstage_casting_calls);
        auditions_near_me=findViewById(R.id.auditions_near_me);
        backstage_online_audition2=findViewById(R.id.backstage_online_audition2);
        backstage_casting_calls2=findViewById(R.id.backstage_casting_calls2);
        backstage_casting_app2=findViewById(R.id.backstage_casting_app2);
        backstage_online_audition3=findViewById(R.id.backstage_online_audition3);
        backstage_casting_calls3=findViewById(R.id.backstage_casting_calls3);
        cameraman_gif=findViewById(R.id.cameraman_gif);
        backstage_social=findViewById(R.id.backstage_social);
        signupnow=findViewById(R.id.signupnow);
        signup_now2=findViewById(R.id.signup_now2);
        signup_now3=findViewById(R.id.signup_now3);
        signup_now4=findViewById(R.id.signup_now4);
        casting_agent=findViewById(R.id.casting_agent);
        production_companies=findViewById(R.id.production_companies);
        online_casting_director=findViewById(R.id.online_casting_director);
        create_portfolio_free_online=findViewById(R.id.create_portfolio_free_online);
        backstage_casting_agency=findViewById(R.id.backstage_casting_agency);
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
        recyclerView=findViewById(R.id.recyclerView);
        recyclerView2=findViewById(R.id.recyclerView2);

        Picasso.with(getApplicationContext()).load("https://images.backstageaudition.com/backstage_new1.png").fit().into(backstage_icon);
        Picasso.with(getApplicationContext()).load("https://images.backstageaudition.com/backstage_new2.png").fit().into(santa_img);
        Picasso.with(this).load("https://images.backstageaudition.com/portfolio_icon.png").fit().into(portfolio_icon);
        Picasso.with(this).load("https://images.backstageaudition.com/portfolio_icon.png").fit().into(portfolio_icon2);
        Picasso.with(this).load("https://images.backstageaudition.com/portfolio_bg.png").fit().into(portfolio_bg);
        Picasso.with(this).load("https://images.backstageaudition.com/cma.png").fit().into(cma);
        Picasso.with(this).load("https://images.backstageaudition.com/cma.png").fit().into(cma2);
        Picasso.with(this).load("https://images.backstageaudition.com/daily_audition_updates.png").fit().into(daily_audition_updates);
        Glide.with(this).load("https://images.backstageaudition.com/backstage_share_icons.gif").into(backstage_share1);
        Glide.with(this).load("https://images.backstageaudition.com/backstage_share_icons.gif").into(backstage_share2);
        Glide.with(this).load("https://images.backstageaudition.com/backstage_casting_app.gif").into(backstage_casting_app);
        Glide.with(this).load("https://images.backstageaudition.com/backstage_online_audition.gif").into(backstage_online_audition);
        Glide.with(this).load("https://images.backstageaudition.com/backstage_casting_calls.gif").into(backstage_casting_calls);
        Glide.with(this).load("https://images.backstageaudition.com/auditions_near_me.gif").into(auditions_near_me);
        Glide.with(this).load("https://images.backstageaudition.com/backstage_online_audition.gif").into(backstage_online_audition2);
        Glide.with(this).load("https://images.backstageaudition.com/backstage_casting_calls.gif").into(backstage_casting_calls2);
        Glide.with(this).load("https://images.backstageaudition.com/backstage_casting_app.gif").into(backstage_casting_app2);
        Glide.with(this).load("https://images.backstageaudition.com/backstage_online_audition.gif").into(backstage_online_audition3);
        Glide.with(this).load("https://images.backstageaudition.com/backstage_casting_calls.gif").into(backstage_casting_calls3);
        Glide.with(this).load("https://images.backstageaudition.com/cameraman_gif.gif").into(cameraman_gif);
        Glide.with(this).load("https://images.backstageaudition.com/backstage_social.gif").into(backstage_social);
        Glide.with(this).load("https://images.backstageaudition.com/signup_now.gif").into(signupnow);
        Glide.with(this).load("https://images.backstageaudition.com/signup_now.gif").into(signup_now2);
        Glide.with(this).load("https://images.backstageaudition.com/signup_now.gif").into(signup_now3);
        Glide.with(this).load("https://images.backstageaudition.com/signup_now.gif").into(signup_now4);
        Glide.with(this).load("https://images.backstageaudition.com/casting_agent.gif").into(casting_agent);
        Glide.with(this).load("https://images.backstageaudition.com/production_companies.gif").into(production_companies);
        Glide.with(this).load("https://images.backstageaudition.com/online_casting_director.gif").into(online_casting_director);
        Glide.with(this).load("https://images.backstageaudition.com/create_portfolio_free_online.gif").into(create_portfolio_free_online);
        Glide.with(this).load("https://images.backstageaudition.com/backstage_casting_agency.gif").into(backstage_casting_agency);
        Glide.with(this).load("https://images.backstageaudition.com/cameraperson_gif.gif").centerCrop().into(cameraman_gif);
        Glide.with(this).load("https://images.backstageaudition.com/signup_now.gif").into(signup_now);
        Picasso.with(this).load("https://images.backstageaudition.com/backstage_new1.png").fit().into(backstage_icon);
        Picasso.with(this).load("https://images.backstageaudition.com/backstage_new2.png").fit().into(santa_img);

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


        auditionsArrayList.add(new Auditions("https://backstageaudition.com/contents/media/t_Production-companies-associated-Backstage.gif","★ Working Worldwide with 782+","https://backstageaudition.com/contents/media/Production-companies-associated-Backstage.png"));
        auditionsArrayList.add(new Auditions("http://app.backstageaudition.com/contents/media/t_backstage-casting-calls.gif","★ More than 89+ Casting Calls today","http://app.backstageaudition.com/contents/media/backstage-casting-calls.png"));
        auditionsArrayList.add(new Auditions("https://backstageaudition.com/contents/media/t_backstage-partners.gif","★ 190+ Online auditions in Next 7 day","https://backstageaudition.com/contents/media/backstage-partners.png"));
        auditionsArrayList.add(new Auditions("https://backstageaudition.com/contents/media/t_backstage-online-audition.gif","★ 190+ Online auditions in Next 7 days","https://backstageaudition.com/contents/media/Backstage-online-audition.png"));
        auditionsArrayList.add(new Auditions("https://backstageaudition.com/contents/media/t_backstage-audition-and-Casting-Alerts.gif","★ Daily Worldwide Audition Updates","https://backstageaudition.com/contents/media/upcoming-auditions-Daily-Audition-Updates.png"));
        auditionsArrayList.add(new Auditions("https://backstageaudition.com/contents/media/t_Auditions-alert.gif","★ CLICK FOR NEAR BY AUDITION INFO","https://backstageaudition.com/contents/media/backstage-%20auditions-near-me.png"));
        auditionsArrayList.add(new Auditions("https://backstageaudition.com/contents/media/t_backstage-internships.gif","★ 1127 free & 2499 Paid internships","https://backstageaudition.com/contents/media/APPLY-FOR-BACKSTAGE-INTENSHIP.png"));
        auditionsArrayList.add(new Auditions("https://backstageaudition.com/contents/media/t_Post-Casting-Call.gif","★ 1899+ Casting Directors Trust us","https://backstageaudition.com/contents/media/post-a_casting_call-on-Backstage.png"));
        auditionsArrayList.add(new Auditions("http://app.backstageaudition.com/contents/media/t_backstage-jobs.gif","★ MORE THAN 3908+ Jobs Available","https://backstageaudition.com/contents/media/Apply-for-Backstage-jobs.png"));
        auditionsArrayList.add(new Auditions("https://backstageaudition.com/contents/media/t_Backstage-agents-and-managers.gif","★ 1127+ Agents Earning Worldwide.","https://backstageaudition.com/contents/media/Become-a-backstage-agent.png"));
        auditionsArrayList.add(new Auditions("https://backstageaudition.com/contents/media/t_Join-Backstage-Affiliate-Program.gif","★ Share/ Data/ Contact/ Project & Earn","https://backstageaudition.com/contents/media/become%20backstage-affiliate-and-earn-money.png"));
        auditionsArrayList.add(new Auditions("https://backstageaudition.com/contents/media/t_contact-backstage-audition.gif","★ ONLINE 24 X 7 Email /Call  /WhatsApp","https://backstageaudition.com/contents/media/backstage-casting-customer-service.png_20230715103752.png"));
        auditionsArrayList.add(new Auditions("https://backstageaudition.com/contents/media/t_frequently-asked-questions.gif","★ All Frequently Asked Questions ?","https://backstageaudition.com/contents/media/Backstage-Frequently-Asked-Questions.png"));
        auditionsArrayList.add(new Auditions("https://backstageaudition.com/contents/media/t_best-modeling-agency-near-me.gif","★ 322+ Modling Agency's Worldwide","https://backstageaudition.com/contents/media/modeling-agency-near-me_20230714184147.png"));
        auditionsArrayList.add(new Auditions("https://backstageaudition.com/contents/media/t_modeling-jobs-available-near-me.gif","★ 617+ Modeling jobs available Today","https://backstageaudition.com/contents/media/modeling-jobs-near-me.png"));

        int numberOfColumns = 2;
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), numberOfColumns));
        HomeAdapter adapter = new HomeAdapter(getApplicationContext(),auditionsArrayList);
        recyclerView.setAdapter(adapter);
        adapter.setClickListener(this);

        auditionsArrayList2.add(new ContactUs("https://images.backstageaudition.com/backstage-youtube-channel.gif","https://images.backstageaudition.com/backstage-youtube-channel.png"));
        auditionsArrayList2.add(new ContactUs("https://images.backstageaudition.com/backstage-audition-instagram.gif","https://images.backstageaudition.com/backstage-audition-instagram.png"));
        auditionsArrayList2.add(new ContactUs("https://images.backstageaudition.com/backstage-audition-and-casting-facebook.gif","https://images.backstageaudition.com/backstage-audition-and-casting-facebook.png"));
        auditionsArrayList2.add(new ContactUs("https://images.backstageaudition.com/backstage-audition-and-casting-twitter.gif","https://images.backstageaudition.com/backstage-audition-and-casting-twitter.png"));
        auditionsArrayList2.add(new ContactUs("https://images.backstageaudition.com/backstage-audition-and-casting-call.gif","https://images.backstageaudition.com/backstage-audition-and-casting-call.png"));
        auditionsArrayList2.add(new ContactUs("https://images.backstageaudition.com/backstage-audition-and-casting-address.gif","http://app.backstageaudition.com/contents/backstage-audition-and-casting-address"));
        auditionsArrayList2.add(new ContactUs("https://images.backstageaudition.com/backstage-audition-and-casting-email-address.gif","https://images.backstageaudition.com/backstage-audition-and-casting-email-address.png"));
        auditionsArrayList2.add(new ContactUs("https://images.backstageaudition.com/backstage-audition-and-casting-mobile-application.gif","https://images.backstageaudition.com/backstage-audition-and-casting-mobile-application.png"));
        auditionsArrayList2.add(new ContactUs("https://images.backstageaudition.com/backstage-audition-and-casting-linkedin.gif","https://images.backstageaudition.com/backstage-audition-and-casting-linkedin.png"));
        auditionsArrayList2.add(new ContactUs("https://images.backstageaudition.com/call-backstage-audition-and-casting.gif","https://images.backstageaudition.com/call-backstage-audition-and-casting.png"));
        auditionsArrayList2.add(new ContactUs("https://images.backstageaudition.com/backstage-audition-and-casting-live-chat.gif","https://images.backstageaudition.com/backstage-audition-and-casting-live-chat.png"));

        int numberOfColumn = 3;
        recyclerView2.setLayoutManager(new GridLayoutManager(getApplicationContext(), numberOfColumn));
        ContactAdapter adapter2 = new ContactAdapter(getApplicationContext(),auditionsArrayList2);
        recyclerView2.setAdapter(adapter2);


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


        String JobImage=getIntent().getStringExtra("JobImage");
        Picasso.with(this).load(JobImage).fit().into(model_img);

        String Age=getIntent().getStringExtra("Age");
        age.setText("IF YOU ARE "+ Age +" YEAR OLD");


        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.left_to_right);
        light_image.startAnimation(animation);
        Animation animation2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink_animation);
        model_img.startAnimation(animation2);

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
        create_online_portfolio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=portfolio.com")));
            }
        });
        create_free_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://backstageaudition.com/contents/en-us/p5_Backstage-auditions-near-me.html")));
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
                FrameLayout frameLayout1 =findViewById(R.id.fl_adplaceholder1);
                FrameLayout frameLayout2 =findViewById(R.id.fl_adplaceholder2);
                FrameLayout frameLayout3 =findViewById(R.id.fl_adplaceholder3);
                FrameLayout frameLayout4 =findViewById(R.id.fl_adplaceholder4);
                FrameLayout frameLayout5 =findViewById(R.id.fl_adplaceholder5);
                FrameLayout frameLayout6 =findViewById(R.id.fl_adplaceholder6);
                UnifiedNativeAdView adView = (UnifiedNativeAdView) getLayoutInflater().inflate(R.layout.ad_unified, null);

                populateUnifiedNativeAdView(unifiedNativeAd, adView);
                frameLayout1.removeAllViews();
                frameLayout2.removeAllViews();
                frameLayout3.removeAllViews();
                frameLayout4.removeAllViews();
                frameLayout5.removeAllViews();
                frameLayout6.removeAllViews();

                frameLayout1.addView(adView);
                frameLayout2.addView(adView);
                frameLayout3.addView(adView);
                frameLayout4.addView(adView);
                frameLayout5.addView(adView);
                frameLayout6.addView(adView);

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
    public void onClick(View v) {

//        Intent intent=new Intent(getApplicationContext(), AuditionsAgeActivity.class);

        switch (v.getId()){
            case R.id.acting_classes:startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://backstageaudition.com/contents/en-us/d169131_acting-classes-for-6-year-olds-near-me.html")));
                break;
            case R.id.auditions_alert:startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://backstageaudition.com/contents/en-us/d169254_Auditions-alert-for-6-year-old.html")));
                break;
            case R.id.casting_call:startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://backstageaudition.com/contents/en-us/d169144_Casting-Calls-for-6-Year-Olds.html")));
                break;
            case R.id.child_actors:startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://backstageaudition.com/contents/en-us/d169276_6-Year-Old-Child-Artist.html")));
                break;
            case R.id.contact_us:startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://backstageaudition.com/contents/en-us/p36_contact-Backstage-Casting.html")));
                break;
            case R.id.dance_classes:startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://backstageaudition.com/contents/en-us/d169228_Dance-classes-for-13-year-olds-near-You.html")));
                break;
            case R.id.frequently_asked_questions:startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://backstageaudition.com/contents/en-us/d169268_how-to-become-a-child-actor-at-13-years.html")));
                break;
            case R.id.modeling_agency:startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://backstageaudition.com/contents/en-us/d169230_Modeling-Agency-for-13-year-old.html")));
                break;
            case R.id.modeling_jobs:startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://backstageaudition.com/contents/en-us/d169203_Modeling-jobs-for-13-year-olds--.html")));
                break;
            case R.id.online_auditions:startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://backstageaudition.com/contents/en-us/d169229_Online-Audition-for-13-year-child-actor.html")));
                break;
            case R.id.post_casting_call:startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://backstageaudition.com/contents/en-us/d169216_post-casting-calls-for-free.html")));
                break;
            case R.id.media_jobs:startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://backstageaudition.com/contents/en-us/d169284_Audition-for-13-year-old.html")));
                break;
            case R.id.become_affiliateagent:startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://backstageaudition.com/contents/en-us/p41_Join-Backstage-affiliate-program.html")));
                break;
            case R.id.agents_managers:startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://backstageaudition.com/contents/en-us/p42_Backstage-Agents-And--Managers-Agents-and-Managers-in-the-Entertainment-Industry.html")));
                break;
            case R.id.media_internship:startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://backstageaudition.com/contents/en-us/d169215_Audition-for-13-year-old-near-you.html")));
                break;

        }
//        startActivity(intent);
    }

    @Override
    public void onItemClick(View view, int position) {

        switch (position){
            case 0:startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://app.backstageaudition.com/contents/en-us/p51_production-companies-associated-backstage.html")));
                 break;
            case 1:startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://app.backstageaudition.com/contents/en-us/p37_Backstage-casting-calls.html")));
                break;
            case 2:startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://app.backstageaudition.com/contents/en-us/p50_Our-Partners.html")));
                break;
            case 3:startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://app.backstageaudition.com/contents/en-us/p49_Backstage-Online-Audition.html")));
                break;
            case 4:startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://app.backstageaudition.com/contents/en-us/p30_Backstage-Auditions-alert--Backstage-Casting-Alerts.html")));
                break;
            case 5:startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://app.backstageaudition.com/contents/en-us/p31_Backstage-Auditions-Near-You.html")));
                break;
            case 6:startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://app.backstageaudition.com/contents/en-us/p45_Backstage-Audition-and-Casting--internship.html")));
                break;
            case 7:startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://app.backstageaudition.com/contents/en-us/p43_Post-Casting-Call-on-BackstageAuditions.com.html")));
                break;
            case 8:startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://app.backstageaudition.com/contents/en-us/p44_Backstage-jobs-Media-Jobs-worldwide.html")));
                break;
            case 9:startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://app.backstageaudition.com/contents/en-us/p42_Backstage-Agents-And--Managers-Agents-and-Managers-in-the-Entertainment-Industry.html")));
                break;
            case 10:startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://app.backstageaudition.com/contents/en-us/p41_Join-Backstage-affiliate-program.html")));
                break;
            case 11:startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://app.backstageaudition.com/contents/en-us/p36_contact-Backstage-Casting.html")));
                break;
            case 12:startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://app.backstageaudition.com/contents/en-us/p38_Frequently-Asked-Questions.html")));
                break;
            case 13:startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://app.backstageaudition.com/contents/en-us/p32_Modeling-Agency.html")));
                break;
            case 14:startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://app.backstageaudition.com/contents/en-us/p35_Backstage-modeling-jobs.html")));
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