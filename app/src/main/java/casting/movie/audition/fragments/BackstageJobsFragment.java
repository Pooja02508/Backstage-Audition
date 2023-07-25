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
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import casting.movie.audition.activities.ChatbotActivity;
import casting.movie.audition.R;
import casting.movie.audition.jobs.FindJobActivity;
import casting.movie.audition.jobs.VoiceOverJobs;
import casting.movie.audition.models.Auditions;
import casting.movie.audition.models.BackstageJobAdapter;
import pl.droidsonroids.gif.GifImageView;


public class BackstageJobsFragment extends Fragment implements BackstageJobAdapter.ItemClickListener{

    ImageView backstage_icon,santa_img;
    private UnifiedNativeAd nativeAd;
    RecyclerView recyclerView;
    ArrayList<Auditions> auditionsArrayList=new ArrayList<>();
    GifImageView fab,live_chat;
    LinearLayout register_now,create_profile;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root= inflater.inflate(R.layout.fragment_backstage_jobs, container, false);

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

        auditionsArrayList.add(new Auditions("Apply For Job","https://images.backstageaudition.com/findjob_gif.gif","135+ Jobs Available","45+ Internships/Trainee Jobs"));
        auditionsArrayList.add(new Auditions("\uD83D\uDDE3Voice ▶ Audio \uD83C\uDFB5 Sound","https://images.backstageaudition.com/voice_gif.gif","135+ Jobs Available","45+ Internships/Trainee Jobs"));
        auditionsArrayList.add(new Auditions("♪ Music","https://images.backstageaudition.com/music_gif.gif","135+ Jobs Available","45+ Internships/Trainee Jobs"));
        auditionsArrayList.add(new Auditions("Makeup & Hair","https://images.backstageaudition.com/makeup_gif.gif","135+ Jobs Available","45+ Internships/Trainee Jobs"));
        auditionsArrayList.add(new Auditions("Costumes","https://images.backstageaudition.com/costume_gif.gif","135+ Jobs Available","45+ Internships/Trainee Jobs"));
        auditionsArrayList.add(new Auditions("Direction","https://images.backstageaudition.com/direction_gif.gif","135+ Jobs Available","45+ Internships/Trainee Jobs"));
        auditionsArrayList.add(new Auditions("Acting","https://images.backstageaudition.com/acting_gif.gif","135+ Jobs Available","45+ Internships/Trainee Jobs"));
        auditionsArrayList.add(new Auditions("Action","https://images.backstageaudition.com/action_gif.gif","135+ Jobs Available","45+ Internships/Trainee Jobs"));
        auditionsArrayList.add(new Auditions("Dance","https://images.backstageaudition.com/dance_gif.gif","135+ Jobs Available","45+ Internships/Trainee Jobs"));
        auditionsArrayList.add(new Auditions("Editing","https://images.backstageaudition.com/editing_gif.gif","135+ Jobs Available","45+ Internships/Trainee Jobs"));
        auditionsArrayList.add(new Auditions("Camera / Production","https://images.backstageaudition.com/camera_production_gif.gif","135+ Jobs Available","45+ Internships/Trainee Jobs"));
        auditionsArrayList.add(new Auditions("Other Jobs","https://images.backstageaudition.com/aotherjobs_gif.gif","135+ Jobs Available","45+ Internships/Trainee Jobs"));
        auditionsArrayList.add(new Auditions("Marketing","https://images.backstageaudition.com/marketing_gif.gif","135+ Jobs Available","45+ Internships/Trainee Jobs"));

        int numberOfColumns = 3;
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), numberOfColumns));
        BackstageJobAdapter adapter = new BackstageJobAdapter(getActivity(),auditionsArrayList);
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
    @Override
    public void onItemClick(View view, int position) {

        Intent intent=new Intent(getActivity(), VoiceOverJobs.class);

        switch (position){
            case 0:startActivity(new Intent(getActivity(), FindJobActivity.class));
                break;
            case 1:intent.putExtra("Job Title","Voice Job");
                startActivity(intent);
                break;
            case 2:intent.putExtra("Job Title","Music Job");
                startActivity(intent);
                break;
            case 3:intent.putExtra("Job Title","Makeup Job");
                startActivity(intent);
                break;
            case 4:intent.putExtra("Job Title","Costume Job");
                startActivity(intent);
                break;
            case 5:intent.putExtra("Job Title","Direction Job");
                startActivity(intent);
                break;
            case 6:intent.putExtra("Job Title","Acting Job");
                startActivity(intent);
                break;
            case 7:intent.putExtra("Job Title","Action Job");
                startActivity(intent);
                break;
            case 8:intent.putExtra("Job Title","Dance Job");
                startActivity(intent);
                break;
            case 9:intent.putExtra("Job Title","Editing Job");
                startActivity(intent);
                break;
            case 10:intent.putExtra("Job Title","Camera Production Job");
                startActivity(intent);
                break;
            case 11:intent.putExtra("Job Title","Other Job");
                startActivity(intent);
                break;
            case 12:intent.putExtra("Job Title","Marketing Job");
                startActivity(intent);
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