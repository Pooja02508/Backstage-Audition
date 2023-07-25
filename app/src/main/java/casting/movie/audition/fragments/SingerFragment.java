package casting.movie.audition.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import casting.movie.audition.R;
import casting.movie.audition.models.ContactAdapter;
import casting.movie.audition.models.ContactUs;
import pl.droidsonroids.gif.GifImageView;

public class SingerFragment extends Fragment implements ContactAdapter.ItemClickListener{

    ImageView backstage_icon,santa_img;
    GifImageView fab,live_chat,cameraman_gif;
    LinearLayout register_now,create_profile;
    private UnifiedNativeAd nativeAd;
    ImageView backstage_mobile_img,superwomen_girl;
    TextView portfolio_website,backstage_website;
    ImageView cma,portfolio_bg,cma2,portfolio_icon,portfolio_icon2,daily_audition_updates;
    GifImageView backstage_casting_app,backstage_online_audition,backstage_casting_calls,auditions_near_me, backstage_online_audition2,
            backstage_casting_calls2,backstage_casting_app2,backstage_online_audition3,backstage_casting_calls3,
            backstage_social,signupnow,signup_now2,signup_now3,signup_now4,casting_agent,production_companies,online_casting_director,
            create_portfolio_free_online,backstage_casting_agency,backstage_share1,backstage_share2;
    GifImageView acting_classes,auditions_alert,casting_call,child_actors,contact_us,dance_classes,frequently_asked_questions,
            modeling_agency,modeling_jobs,online_auditions,post_casting_call,media_jobs,become_affiliateagent,agents_managers,media_internship;
    ArrayList<ContactUs> auditionsArrayList=new ArrayList<>();
    RecyclerView recyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root= inflater.inflate(R.layout.fragment_singer, container, false);

        backstage_icon=root.findViewById(R.id.backstage_icon);
        santa_img=root.findViewById(R.id.santa_img);
        live_chat=root.findViewById(R.id.live_chat);
        fab = root.findViewById(R.id.fab);
        register_now=root.findViewById(R.id.register_now);
        create_profile=root.findViewById(R.id.create_profile);

        recyclerView=root.findViewById(R.id.recyclerView);
        backstage_mobile_img=root.findViewById(R.id.backstage_mobile_img);
        superwomen_girl=root.findViewById(R.id.superwomen_girl);
        portfolio_icon=root.findViewById(R.id.portfolio_icon);
        portfolio_icon2=root.findViewById(R.id.portfolio_icon2);
        portfolio_bg=root.findViewById(R.id.portfolio_bg);
        portfolio_website=root.findViewById(R.id.portfolio_website);
        backstage_website=root.findViewById(R.id.backstage_website);
        backstage_share1=root.findViewById(R.id.backstage_share1);
        backstage_share2=root.findViewById(R.id.backstage_share2);
        cma=root.findViewById(R.id.cma);
        cma2=root.findViewById(R.id.cma2);
        daily_audition_updates=root.findViewById(R.id.daily_audition_updates);
        backstage_casting_app=root.findViewById(R.id.backstage_casting_app);
        backstage_online_audition=root.findViewById(R.id.backstage_online_audition);
        backstage_casting_calls=root.findViewById(R.id.backstage_casting_calls);
        auditions_near_me=root.findViewById(R.id.auditions_near_me);
        backstage_online_audition2=root.findViewById(R.id.backstage_online_audition2);
        backstage_casting_calls2=root.findViewById(R.id.backstage_casting_calls2);
        backstage_casting_app2=root.findViewById(R.id.backstage_casting_app2);
        backstage_online_audition3=root.findViewById(R.id.backstage_online_audition3);
        backstage_casting_calls3=root.findViewById(R.id.backstage_casting_calls3);
        cameraman_gif=root.findViewById(R.id.cameraman_gif);
        backstage_social=root.findViewById(R.id.backstage_social);
        signupnow=root.findViewById(R.id.signupnow);
        signup_now2=root.findViewById(R.id.signup_now2);
        signup_now3=root.findViewById(R.id.signup_now3);
        signup_now4=root.findViewById(R.id.signup_now4);
        casting_agent=root.findViewById(R.id.casting_agent);
        production_companies=root.findViewById(R.id.production_companies);
        online_casting_director=root.findViewById(R.id.online_casting_director);
        create_portfolio_free_online=root.findViewById(R.id.create_portfolio_free_online);
        backstage_casting_agency=root.findViewById(R.id.backstage_casting_agency);
        acting_classes=root.findViewById(R.id.acting_classes);
        auditions_alert=root.findViewById(R.id.auditions_alert);
        casting_call=root.findViewById(R.id.casting_call);
        child_actors=root.findViewById(R.id.child_actors);
        contact_us=root.findViewById(R.id.contact_us);
        dance_classes=root.findViewById(R.id.dance_classes);
        frequently_asked_questions=root.findViewById(R.id.frequently_asked_questions);
        modeling_agency=root.findViewById(R.id.modeling_agency);
        modeling_jobs=root.findViewById(R.id.modeling_jobs);
        online_auditions=root.findViewById(R.id.online_auditions);
        post_casting_call=root.findViewById(R.id.post_casting_call);
        media_jobs=root.findViewById(R.id.media_jobs);
        become_affiliateagent=root.findViewById(R.id.become_affiliateagent);
        agents_managers=root.findViewById(R.id.agents_managers);
        media_internship=root.findViewById(R.id.media_internship);


        Picasso.with(getActivity()).load("https://images.backstageaudition.com/backstage_new1.png").fit().into(backstage_icon);
        Picasso.with(getActivity()).load("https://images.backstageaudition.com/backstage_new2.png").fit().into(santa_img);
        Picasso.with(getActivity()).load("https://images.backstageaudition.com/backstage_mobile_img.png").fit().into(backstage_mobile_img);
        Picasso.with(getActivity()).load("https://images.backstageaudition.com/superwomen_girl.png").fit().into(superwomen_girl);
        Glide.with(getActivity()).load("https://images.backstageaudition.com/cameraman_gif.gif").into(cameraman_gif);
        Picasso.with(getActivity()).load("https://images.backstageaudition.com/portfolio_icon.png").fit().into(portfolio_icon);
        Picasso.with(getActivity()).load("https://images.backstageaudition.com/portfolio_icon.png").fit().into(portfolio_icon2);
        Picasso.with(getActivity()).load("https://images.backstageaudition.com/portfolio_bg.png").fit().into(portfolio_bg);
        Picasso.with(getActivity()).load("https://images.backstageaudition.com/cma.png").fit().into(cma);
        Picasso.with(getActivity()).load("https://images.backstageaudition.com/cma.png").fit().into(cma2);
        Picasso.with(getActivity()).load("https://images.backstageaudition.com/daily_audition_updates.png").fit().into(daily_audition_updates);
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
        Glide.with(this).load("https://images.backstageaudition.com/signup_now.gif").into(signupnow);


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


        auditionsArrayList.add(new ContactUs("https://images.backstageaudition.com/backstage-audition-and-casting-facebook.gif","https://images.backstageaudition.com/backstage-audition-and-casting-facebook.png"));
        auditionsArrayList.add(new ContactUs("https://images.backstageaudition.com/backstage-audition-and-casting-address-youtube-channel.gif","https://images.backstageaudition.com/backstage-youtube-channel.png"));
        auditionsArrayList.add(new ContactUs("https://images.backstageaudition.com/backstage-audition-and-casting-instagram.gif","https://images.backstageaudition.com/backstage-audition-instagram.png"));
        auditionsArrayList.add(new ContactUs("https://images.backstageaudition.com/backstage-audition-and-casting-email-address.gif","https://images.backstageaudition.com/backstage-audition-and-casting-email-address.png"));
        auditionsArrayList.add(new ContactUs("https://images.backstageaudition.com/backstage-audition-and-casting-call.gif","https://images.backstageaudition.com/backstage-audition-and-casting-call.png"));
        auditionsArrayList.add(new ContactUs("https://images.backstageaudition.com/backstage-audition-and-casting-telegram-channel.gif","https://images.backstageaudition.com/backstage-audition-and-casting-telegram-channel.png"));
        auditionsArrayList.add(new ContactUs("https://images.backstageaudition.com/backstage-audition-and-casting-address.gif","https://images.backstageaudition.com/backstage-audition-and-casting-address.png"));
        auditionsArrayList.add(new ContactUs("https://images.backstageaudition.com/backstage-audition-and-casting-contact-number.gif","https://images.backstageaudition.com/backstage-audition-and-casting-contact-number.png"));
        auditionsArrayList.add(new ContactUs("https://images.backstageaudition.com/backstage-audition-and-casting-mobile-application.gif","https://images.backstageaudition.com/backstage-audition-and-casting-mobile-application.png"));
        auditionsArrayList.add(new ContactUs("https://images.backstageaudition.com/Backstage-Audition-and-Casting-twitter.gif","https://images.backstageaudition.com/backstage-audition-and-casting-twitter.png"));
        auditionsArrayList.add(new ContactUs("https://images.backstageaudition.com/Backstage-audition-and-casting-TikTok.gif","https://images.backstageaudition.com/backstage-audition-and-casting-tiktok.png"));
        auditionsArrayList.add(new ContactUs("https://images.backstageaudition.com/backstage-audition-and-casting-linkedin.gif","https://images.backstageaudition.com/backstage-audition-and-casting-linkedin.png"));
        auditionsArrayList.add(new ContactUs("https://images.backstageaudition.com/backstage-audition-and-casting-whatsapp-number.gif","https://images.backstageaudition.com/backstage-audition-and-casting-whatsapp-number.png"));
        auditionsArrayList.add(new ContactUs("https://images.backstageaudition.com/Backstage-audition-and-casting-jobs.gif","https://images.backstageaudition.com/Backstage-audition-and-casting-jobs.png"));
        auditionsArrayList.add(new ContactUs("https://images.backstageaudition.com/backstage-audition-and-casting-portfolio.gif","https://app.backstageaudition.com/contents/media/backstage-audition-and-casting-portfolio.png"));
        auditionsArrayList.add(new ContactUs("https://images.backstageaudition.com/backstage-auditions-near-me.gif","https://app.backstageaudition.com/contents/media/backstage-auditions-near-me.png"));
        auditionsArrayList.add(new ContactUs("https://images.backstageaudition.com/backstage-audition-and-casting-partnership.gif","https://app.backstageaudition.com/contents/media/backstage-audition-and-casting-partnership.png"));


        int numberOfColumn = 2;
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), numberOfColumn));
        ContactAdapter adapter = new ContactAdapter(getActivity(),auditionsArrayList);
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
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://my.artibot.ai/backstage")));
            }
        });
        live_chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://my.artibot.ai/backstage")));
            }
        });

        MobileAds.initialize(getActivity(), getString(R.string.ADMOB_ADS_UNIT_ID));

        AdLoader.Builder builder = new AdLoader.Builder(getActivity(), getString(R.string.ADMOB_ADS_UNIT_ID));
        builder.forUnifiedNativeAd(new UnifiedNativeAd.OnUnifiedNativeAdLoadedListener() {
            @Override
            public void onUnifiedNativeAdLoaded(UnifiedNativeAd unifiedNativeAd) {
                if (nativeAd != null) {
                    nativeAd.destroy();
                }
                nativeAd = unifiedNativeAd;
                FrameLayout frameLayout1 =root.findViewById(R.id.fl_adplaceholder1);
                FrameLayout frameLayout2 =root.findViewById(R.id.fl_adplaceholder2);
                FrameLayout frameLayout3 =root.findViewById(R.id.fl_adplaceholder3);
                FrameLayout frameLayout4 =root.findViewById(R.id.fl_adplaceholder4);
                FrameLayout frameLayout5 =root.findViewById(R.id.fl_adplaceholder5);
                UnifiedNativeAdView adView = (UnifiedNativeAdView) getLayoutInflater().inflate(R.layout.ad_unified, null);

                populateUnifiedNativeAdView(unifiedNativeAd, adView);
                frameLayout1.removeAllViews();
                frameLayout2.removeAllViews();
                frameLayout3.removeAllViews();
                frameLayout4.removeAllViews();
                frameLayout5.removeAllViews();

                frameLayout1.addView(adView);
                frameLayout2.addView(adView);
                frameLayout3.addView(adView);
                frameLayout4.addView(adView);
                frameLayout5.addView(adView);

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


        return root;

    }

    @Override
    public void onItemClick(View view, int position) {
        switch (position){
            case 0: startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/BackstageAudition/")));
                break;
            case 1: startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/@Online.Audition")));
                break;
            case 2: startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/backstageaudition/")));
                break;
            case 3: startActivity(new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + "Backstagehelpdesk@gmail.com")));
                break;
            case 4: String phone = "919112473657";
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
                startActivity(intent);
                break;
            case 5: startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://t.me.backstageaudition/")));
                break;
            case 10:
            case 6: startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://app.backstageaudition.com/contents/en-us/contactus.html")));
                break;
            case 7: startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://my.artibot.ai/backstage")));
                break;
            case 8: startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=casting.movie.audition")));
                break;
            case 9: startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/EcastingOnline")));
                break;
            case 11: startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.linkedin.com/in/BackstageAudition")));
                break;
            case 12: startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://wa.me/919112473657?text=Hi")));
                break;
            case 13:startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://app.backstageaudition.com/contents/en-us/d169009_Find-Audition-and-Casting-a-job.html")));
                break;
            case 14:startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://a2zportfolio.com/contents/en-us/p2_Create-Portfolio-Online.html")));
                break;
            case 15:startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://app.backstageaudition.com/contents/en-us/d169007_Backstage-Audition-and-Casting-call.html")));
                break;
            case 16:startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://app.backstageaudition.com/contents/en-us/d169199_Backstage-Audition-and-Casting-partnership.html")));
                break;
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