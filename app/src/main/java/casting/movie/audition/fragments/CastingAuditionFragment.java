package casting.movie.audition.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

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

import casting.movie.audition.activities.ChatbotActivity;
import casting.movie.audition.auditionActivities.FemaleAudition;
import casting.movie.audition.auditionActivities.MaleAudition;
import casting.movie.audition.R;
import pl.droidsonroids.gif.GifImageView;

public class CastingAuditionFragment extends Fragment {

   GifImageView fab,live_chat;
    LinearLayout register_now,create_profile;
    ImageView backstage_icon,santa_img;
    ImageView step1_1,step1_2,step1_3,step1_4;
    private UnifiedNativeAd nativeAd;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root= inflater.inflate(R.layout.fragment_casting_audition, container, false);

        step1_1=root.findViewById(R.id.step1_1);
        step1_2=root.findViewById(R.id.step1_2);
        step1_3=root.findViewById(R.id.step1_3);
        step1_4=root.findViewById(R.id.step1_4);

        backstage_icon=root.findViewById(R.id.backstage_icon);
        santa_img=root.findViewById(R.id.santa_img);
        Picasso.with(getActivity()).load("https://images.backstageaudition.com/backstage_new1.png").fit().into(backstage_icon);
        Picasso.with(getActivity()).load("https://images.backstageaudition.com/backstage_new2.png").fit().into(santa_img);

        fab = root.findViewById(R.id.fab);
        live_chat=root.findViewById(R.id.live_chat);
        register_now=root.findViewById(R.id.register_now);
        create_profile=root.findViewById(R.id.create_profile);
       // Glide.with(this).load("https://images.backstageaudition.com/chat_gif.gif").into(fab);

        Glide.with(this).load("https://images.backstageaudition.com/step1_1.gif").into(step1_1);
        Glide.with(this).load("https://images.backstageaudition.com/step1_2.gif").into(step1_2);
        Glide.with(this).load("https://images.backstageaudition.com/step1_3.gif").into(step1_3);
        Glide.with(this).load("https://images.backstageaudition.com/step1_4.gif").into(step1_4);

        step1_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), FemaleAudition.class));
            }
        });
        step1_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), MaleAudition.class));
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