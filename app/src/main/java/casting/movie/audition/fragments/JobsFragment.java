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
import casting.movie.audition.jobs.JobsDetailsActivity;
import casting.movie.audition.jobs.VoiceOverJobs;
import casting.movie.audition.R;
import casting.movie.audition.models.Auditions;
import casting.movie.audition.models.JobsAdapter;
import pl.droidsonroids.gif.GifImageView;


public class JobsFragment extends Fragment implements JobsAdapter.ItemClickListener {

    RecyclerView recyclerView;
    ArrayList<Auditions> auditionsArrayList=new ArrayList<>();
    private UnifiedNativeAd nativeAd;
    ImageView backstage_icon,santa_img;
   GifImageView fab,live_chat;
    LinearLayout register_now,create_profile;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root= inflater.inflate(R.layout.fragment_jobs, container, false);

        backstage_icon=root.findViewById(R.id.backstage_icon);
        santa_img=root.findViewById(R.id.santa_img);
        Picasso.with(getActivity()).load("https://images.backstageaudition.com/backstage_new1.png").fit().into(backstage_icon);
        Picasso.with(getActivity()).load("https://images.backstageaudition.com/backstage_new2.png").fit().into(santa_img);

        live_chat=root.findViewById(R.id.live_chat);
        fab = root.findViewById(R.id.fab);
        register_now=root.findViewById(R.id.register_now);
        create_profile=root.findViewById(R.id.create_profile);
       // Glide.with(this).load("https://images.backstageaudition.com/chat_gif.gif").into(fab);

        recyclerView=root.findViewById(R.id.recyclerView);


        auditionsArrayList.add(new Auditions("Producer","https://images.backstageaudition.com/producer.jpg","135+ Jobs Available","45+ Internships/Trainee Jobs"));
        auditionsArrayList.add(new Auditions("Director","https://images.backstageaudition.com/director.png","100+ Jobs Available","28+ Internships/Trainee Jobs"));
        auditionsArrayList.add(new Auditions("Screenwriter","https://images.backstageaudition.com/screenwriter.jpg","163+ Jobs Available","47+ Internships/Trainee Jobs"));
        auditionsArrayList.add(new Auditions("Voice Over","https://images.backstageaudition.com/voice_over_jobs.png","383+ Jobs Available","247+ Internships/Trainee Jobs"));
        auditionsArrayList.add(new Auditions("Director of Photography","https://images.backstageaudition.com/cinematographer.jpg","250+ Jobs Available","61+ Internships/Trainee Jobs"));
        auditionsArrayList.add(new Auditions("Production Designer","https://images.backstageaudition.com/production_designer.jpg","203+ Jobs Available","37+ Internships/Trainee Jobs"));
        auditionsArrayList.add(new Auditions("Art Director","https://images.backstageaudition.com/art_director.jpg","148+ Jobs Available","52+ Internships/Trainee Jobs"));
        auditionsArrayList.add(new Auditions("Costume Designer","https://images.backstageaudition.com/costume_designer.jpg","180+ Jobs Available","95+ Internships/Trainee Jobs"));
        auditionsArrayList.add(new Auditions("Casting Director","https://images.backstageaudition.com/casting_director.png","220+ Jobs Available","63+ Internships/Trainee Jobs"));
        auditionsArrayList.add(new Auditions("Production Manager","https://images.backstageaudition.com/production_manager.jpg","260+ Jobs Available","82+ Internships/Trainee Jobs"));
        auditionsArrayList.add(new Auditions("Assistant Director (AD)","https://images.backstageaudition.com/assistant_director.jpg","209+ Jobs Available","34+ Internships/Trainee Jobs"));
        auditionsArrayList.add(new Auditions("Editor","https://images.backstageaudition.com/editor.jpg","155+ Jobs Available","45+ Internships/Trainee Jobs"));
        auditionsArrayList.add(new Auditions("Sound Designer","https://images.backstageaudition.com/sound_designer.jpg","125+ Jobs Available","90+ Internships/Trainee Jobs"));
        auditionsArrayList.add(new Auditions("Composer","https://images.backstageaudition.com/composer.jpg","230+ Jobs Available","75+ Internships/Trainee Jobs"));
        auditionsArrayList.add(new Auditions("Visual Effects (VFX) Supervisor","https://images.backstageaudition.com/visual_effects.jpg","200+ Jobs Available","69+ Internships/Trainee Jobs"));
        auditionsArrayList.add(new Auditions("Production Sound Mixer","https://images.backstageaudition.com/sound_mixer.jpg","100+ Jobs Available","50+ Internships/Trainee Jobs"));
        auditionsArrayList.add(new Auditions("Grip","https://images.backstageaudition.com/grip.jpg","185+ Jobs Available","65+ Internships/Trainee Jobs"));
        auditionsArrayList.add(new Auditions("Gaffer","https://images.backstageaudition.com/gaffer.jpg","215+ Jobs Available","245+ Internships/Trainee Jobs"));
        auditionsArrayList.add(new Auditions("Production Assistant (PA)","https://images.backstageaudition.com/production_assistant.jpg","200+ Jobs Available","49+ Internships/Trainee Jobs"));

//        auditionsArrayList.add(new Auditions("Models",R.drawable.ic_models,"300+ Jobs Available","59+ Internships/Trainee Jobs"));
//        auditionsArrayList.add(new Auditions("Actors",R.drawable.ic_actor,"110+ Jobs Available","54+ Internships/Trainee Jobs"));
//        auditionsArrayList.add(new Auditions("Content Creation Staff",R.drawable.ic_content,"145+ Jobs Available","48+ Internships/Trainee Jobs"));
//        auditionsArrayList.add(new Auditions("Voice Over Artist",R.drawable.ic_voice,"229+ Jobs Available","36+ Internships/Trainee Jobs"));
//        auditionsArrayList.add(new Auditions("Staff / Crew Members",R.drawable.ic_staff,"388+ Jobs Available","68+ Internships/Trainee Jobs"));
//        auditionsArrayList.add(new Auditions("Dancers / Choreographer",R.drawable.ic_dancer,"199+ Jobs Available","38+ Internships/Trainee Jobs"));
//        auditionsArrayList.add(new Auditions("Singer",R.drawable.ic_singer,"120+ Jobs Available","45+ Internships/Trainee Jobs"));
//        auditionsArrayList.add(new Auditions("Technical Staff",R.drawable.ic_technical,"140+ Jobs Available","74+ Internships/Trainee Jobs"));
//        auditionsArrayList.add(new Auditions("Free Internship",R.drawable.ic_internship,"129+ Jobs Available","66+ Internships/Trainee Jobs"));
//


        int numberOfColumns = 3;
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), numberOfColumns));
        JobsAdapter adapter = new JobsAdapter(getActivity(),auditionsArrayList);
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

        Intent intent=new Intent(getActivity(), JobsDetailsActivity.class);
        switch (position){
            case 0:
            case 1:
            case 2:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17: startActivity(intent);
            break;
            case 3:startActivity(new Intent(getActivity(), VoiceOverJobs.class));
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