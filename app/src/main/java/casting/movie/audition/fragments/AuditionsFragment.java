package casting.movie.audition.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

import casting.movie.audition.activities.ChatbotActivity;
import casting.movie.audition.auditionActivities.SelectGenderActivity;
import casting.movie.audition.R;
import casting.movie.audition.models.Auditions;
import casting.movie.audition.models.AuditonsForAdapter;
import pl.droidsonroids.gif.GifImageView;


public class AuditionsFragment extends Fragment implements AuditonsForAdapter.ItemClickListener{

    ImageView backstage_icon,santa_img;
    RecyclerView recyclerView;
    ArrayList<Auditions> auditionsArrayList=new ArrayList<>();
    private UnifiedNativeAd nativeAd;
    GifImageView fab,live_chat;
    LinearLayout register_now,create_profile;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root= inflater.inflate(R.layout.fragment_auditions, container, false);

        backstage_icon=root.findViewById(R.id.backstage_icon);
        santa_img=root.findViewById(R.id.santa_img);
        Picasso.with(getActivity()).load("https://images.backstageaudition.com/backstage_new1.png").fit().into(backstage_icon);
        Picasso.with(getActivity()).load("https://images.backstageaudition.com/backstage_new2.png").fit().into(santa_img);
        fab = root.findViewById(R.id.fab);
        live_chat=root.findViewById(R.id.live_chat);
        register_now=root.findViewById(R.id.register_now);
        create_profile=root.findViewById(R.id.create_profile);
       // Glide.with(this).load("https://images.backstageaudition.com/chat_gif.gif").into(fab);

        recyclerView=root.findViewById(R.id.recyclerView);

        auditionsArrayList.add(new Auditions("★ Auditions for babies","https://images.backstageaudition.com/auditions_for_babies.gif","[ 0 to 5 Years ]","148+ Auditions Available"));
        auditionsArrayList.add(new Auditions("★ Auditions for Kids","https://images.backstageaudition.com/auditions_for_kids.gif","[ 6 to 12 Years ]","203+ Auditions Available"));
        auditionsArrayList.add(new Auditions("★ Auditions for Teenagers","https://images.backstageaudition.com/auditions_for_teenagers.gif","[ 13 to 19 Years ]","250+ Auditions Available"));
        auditionsArrayList.add(new Auditions("★ Auditions for young","https://images.backstageaudition.com/auditions_for_young.gif","[ 20 to 25 Years ]","383+ Auditions Available"));
        auditionsArrayList.add(new Auditions("★ Auditions for adults","https://images.backstageaudition.com/auditions_for_mature.gif","[ 26 to 40 Years ]","163+ Auditions Available"));
        auditionsArrayList.add(new Auditions("★ Auditions for adults","https://images.backstageaudition.com/auditions_for_adults.gif","[ 41 to 50 Years ]","100+ Auditions Available"));
        auditionsArrayList.add(new Auditions("★ Auditions for old","https://images.backstageaudition.com/auditions_for_old.gif","[ 51 to 60 Years ]","100+ Auditions Available"));
        auditionsArrayList.add(new Auditions("★ Auditions for Senior Citizens","https://images.backstageaudition.com/auditions_for_senior.gif","[ 61 to 80 Years ]","135+ Auditions Available"));
        auditionsArrayList.add(new Auditions("★Post Casting Call/Find Talent","https://images.backstageaudition.com/find_talent.gif","","148+ Auditions Available"));
        auditionsArrayList.add(new Auditions("★ Apply for \njobs","https://images.backstageaudition.com/findjob_gif.gif","","203+ Auditions Available"));
        auditionsArrayList.add(new Auditions("★ Apply for an internship","https://images.backstageaudition.com/apply_internship.gif","","250+ Auditions Available"));
        auditionsArrayList.add(new Auditions("★ Create an Online Portfolio","https://images.backstageaudition.com/create_portfolio.gif","","383+ Auditions Available"));



        int numberOfColumns = 3;
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), numberOfColumns));
        AuditonsForAdapter adapter = new AuditonsForAdapter(getActivity(),auditionsArrayList);
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
                FrameLayout frameLayout = root.findViewById(R.id.fl_adplaceholder);
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

    @Override
    public void onItemClick(View view, int position) {

        Intent intent=new Intent(getActivity(), SelectGenderActivity.class);
        switch (position) {
            case 0:intent.putExtra("AGE","0-5");
                break;
            case 1:intent.putExtra("AGE","6-12");
                break;
            case 2:intent.putExtra("AGE","13-19");
                break;
            case 3:intent.putExtra("AGE","20-25");
                break;
            case 4:intent.putExtra("AGE","26-40");
                break;
            case 5:intent.putExtra("AGE","41-50");
                break;
            case 6:intent.putExtra("AGE","51-60");
                break;
            case 7:intent.putExtra("AGE","61-80");
                break;
        }
        startActivity(intent);
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