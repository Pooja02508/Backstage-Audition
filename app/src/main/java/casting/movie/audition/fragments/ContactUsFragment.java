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

import casting.movie.audition.R;
import casting.movie.audition.activities.ChatbotActivity;
import casting.movie.audition.models.Auditions;
import casting.movie.audition.models.AuditonsForAdapter;
import casting.movie.audition.models.ContactAdapter;
import casting.movie.audition.models.ContactUs;
import casting.movie.audition.models.HomeAdapter;
import pl.droidsonroids.gif.GifImageView;

public class ContactUsFragment extends Fragment {

    ArrayList<ContactUs> auditionsArrayList=new ArrayList<>();
    RecyclerView recyclerView;
    ImageView backstage_icon,santa_img;
    GifImageView fab,live_chat;
    LinearLayout register_now,create_profile;
    private UnifiedNativeAd nativeAd;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root= inflater.inflate(R.layout.fragment_contact_us, container, false);

        fab=root.findViewById(R.id.fab);
        live_chat=root.findViewById(R.id.live_chat);
        backstage_icon=root.findViewById(R.id.backstage_icon);
        santa_img=root.findViewById(R.id.santa_img);
        register_now=root.findViewById(R.id.register_now);
        create_profile=root.findViewById(R.id.create_profile);
        recyclerView=root.findViewById(R.id.recyclerView);
        Picasso.with(getActivity()).load("https://images.backstageaudition.com/backstage_new1.png").fit().into(backstage_icon);
        Picasso.with(getActivity()).load("https://images.backstageaudition.com/backstage_new2.png").fit().into(santa_img);

        auditionsArrayList.add(new ContactUs("https://images.backstageaudition.com/backstage-youtube-channel.gif","https://images.backstageaudition.com/backstage-youtube-channel.png"));
        auditionsArrayList.add(new ContactUs("https://images.backstageaudition.com/backstage-audition-instagram.gif","https://images.backstageaudition.com/backstage-audition-instagram.png"));
        auditionsArrayList.add(new ContactUs("https://images.backstageaudition.com/backstage-audition-and-casting-facebook.gif","https://images.backstageaudition.com/backstage-audition-and-casting-facebook.png"));
        auditionsArrayList.add(new ContactUs("https://images.backstageaudition.com/backstage-audition-and-casting-twitter.gif","https://images.backstageaudition.com/backstage-audition-and-casting-twitter.png"));
        auditionsArrayList.add(new ContactUs("https://images.backstageaudition.com/backstage-audition-and-casting-call.gif","https://images.backstageaudition.com/backstage-audition-and-casting-call.png"));
        auditionsArrayList.add(new ContactUs("https://images.backstageaudition.com/backstage-audition-and-casting-address.gif","http://app.backstageaudition.com/contents/backstage-audition-and-casting-address"));
        auditionsArrayList.add(new ContactUs("https://images.backstageaudition.com/backstage-audition-and-casting-email-address.gif","https://images.backstageaudition.com/backstage-audition-and-casting-email-address.png"));
        auditionsArrayList.add(new ContactUs("https://images.backstageaudition.com/backstage-audition-and-casting-mobile-application.gif","https://images.backstageaudition.com/backstage-audition-and-casting-mobile-application.png"));
        auditionsArrayList.add(new ContactUs("https://images.backstageaudition.com/backstage-audition-and-casting-linkedin.gif","https://images.backstageaudition.com/backstage-audition-and-casting-linkedin.png"));
        auditionsArrayList.add(new ContactUs("https://images.backstageaudition.com/call-backstage-audition-and-casting.gif","https://images.backstageaudition.com/call-backstage-audition-and-casting.png"));
        auditionsArrayList.add(new ContactUs("https://images.backstageaudition.com/backstage-audition-and-casting-live-chat.gif","https://images.backstageaudition.com/backstage-audition-and-casting-live-chat.png"));

        int numberOfColumns = 3;
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), numberOfColumns));
        ContactAdapter adapter = new ContactAdapter(getActivity(),auditionsArrayList);
        recyclerView.setAdapter(adapter);


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
                startActivity(new Intent(getActivity(), ChatbotActivity.class));
            }
        });
        live_chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ChatbotActivity.class));
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
                FrameLayout frameLayout =root.findViewById(R.id.fl_adplaceholder);
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

        return root;
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