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
import casting.movie.audition.jobs.JobsDescription;
import casting.movie.audition.R;
import casting.movie.audition.models.AuditionAdapter;
import casting.movie.audition.models.Auditions;
import pl.droidsonroids.gif.GifImageView;

public class VoiceJobsFragment extends Fragment implements AuditionAdapter.ItemClickListener{

    private UnifiedNativeAd nativeAd;
    RecyclerView recyclerView;
    ArrayList<Auditions> auditionsArrayList=new ArrayList<>();
    ImageView backstage_icon,santa_img;
   GifImageView fab,live_chat;
    LinearLayout register_now,create_profile;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root= inflater.inflate(R.layout.fragment_voice_jobs, container, false);


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

        auditionsArrayList.add(new Auditions("\uD83D\uDDE3 Dubbing Artist Jobs","https://images.backstageaudition.com/dubbing_artist_jobs.png"));
        auditionsArrayList.add(new Auditions("\uD83D\uDDE3 Radio Show Host Jobs","https://images.backstageaudition.com/radio_show_host_jobs.png"));
        auditionsArrayList.add(new Auditions("\uD83D\uDDE3 Audio Book Narrator Jobs","https://images.backstageaudition.com/audio_book_narrator_jobs.png"));
        auditionsArrayList.add(new Auditions("\uD83D\uDDE3 Character Voice Actor Jobs","https://images.backstageaudition.com/character_voice_actor_jobs.png"));
        auditionsArrayList.add(new Auditions("\uD83D\uDDE3 Voice-over Artist Jobs","https://images.backstageaudition.com/voice_over_artist_jobs.png"));
        auditionsArrayList.add(new Auditions("\uD83D\uDDE3 Animation and Cartoons Jobs","https://images.backstageaudition.com/animation_and_cartoons_jobs.png"));
        auditionsArrayList.add(new Auditions("\uD83D\uDDE3 Voice acting Jobs","https://images.backstageaudition.com/voice_acting_jobs.png"));
        auditionsArrayList.add(new Auditions("\uD83D\uDDE3 Documentary voice artist Jobs","https://images.backstageaudition.com/documentary_voice_artist_jobs.png"));
        auditionsArrayList.add(new Auditions("\uD83D\uDDE3 Studio Recording Specialist Jobs","https://images.backstageaudition.com/studio_recording_specialist_jobs.png"));
        auditionsArrayList.add(new Auditions("\uD83D\uDDE3 Mimicry Artist Jobs","https://images.backstageaudition.com/mimicry_artist_jobs.png"));
        auditionsArrayList.add(new Auditions("\uD83D\uDDE3 Audio editor Jobs","https://images.backstageaudition.com/audio_editor_jobs.png"));
        auditionsArrayList.add(new Auditions("\uD83D\uDDE3 Sound Engineer Jobs","https://images.backstageaudition.com/sound_engineer.png"));
        auditionsArrayList.add(new Auditions("\uD83D\uDDE3 Sound Designer Jobs","https://images.backstageaudition.com/sound_designer_job.png"));
        auditionsArrayList.add(new Auditions("\uD83D\uDDE3 Foley Artist Jobs","https://images.backstageaudition.com/foley_artist.png"));
        auditionsArrayList.add(new Auditions("\uD83D\uDDE3 Music Producer Jobs","https://images.backstageaudition.com/music_producer.png"));
        auditionsArrayList.add(new Auditions("\uD83D\uDDE3 Live Sound Engineer Jobs","https://images.backstageaudition.com/live_sound_engineer.png"));
        auditionsArrayList.add(new Auditions("\uD83D\uDDE3 Audio Technician Jobs","https://images.backstageaudition.com/audio_technician.png"));
        auditionsArrayList.add(new Auditions("\uD83D\uDDE3 Acoustic Consultant Jobs","https://images.backstageaudition.com/acoustic_consultant.png"));
        auditionsArrayList.add(new Auditions("\uD83D\uDDE3 Broadcast Technician Jobs","https://images.backstageaudition.com/broadcast_technician.png"));
        auditionsArrayList.add(new Auditions("\uD83D\uDDE3 Audio Researcher Jobs","https://images.backstageaudition.com/audio_researcher.png"));
        auditionsArrayList.add(new Auditions("\uD83D\uDDE3 Boom Operator Jobs","https://images.backstageaudition.com/boom_operator.png"));


        int numberOfColumns = 2;
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), numberOfColumns));
        AuditionAdapter adapter = new AuditionAdapter(getActivity(),auditionsArrayList);
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

        Intent intent=new Intent(getActivity(), JobsDescription.class);

        switch (position){
            case 0:intent.putExtra("DESCRIPTION","Dubbing Artist");
                intent.putExtra("JobImage","https://images.backstageaudition.com/dubbing_artist_desc.png");
                break;
            case 1:intent.putExtra("DESCRIPTION","Radio Show Host");
                intent.putExtra("JobImage","https://images.backstageaudition.com/radio_show_host_desc.png");
                break;
            case 2:intent.putExtra("DESCRIPTION","Audio Book Narrator");
                intent.putExtra("JobImage","https://images.backstageaudition.com/audio_book_narrator_desc.png");
                break;
            case 3:intent.putExtra("DESCRIPTION","Character Voice Actor");
                intent.putExtra("JobImage","https://images.backstageaudition.com/character_voice_actor_desc.png");
                break;
            case 4:intent.putExtra("DESCRIPTION","Voice Over Artist");
                intent.putExtra("JobImage","https://images.backstageaudition.com/voice_over_artist_desc.png");
                break;
            case 5:intent.putExtra("DESCRIPTION","Animation And Cartoons");
                intent.putExtra("JobImage","https://images.backstageaudition.com/animation_and_cartoons_desc.png");
                break;
            case 6:intent.putExtra("DESCRIPTION","Voice Acting");
                intent.putExtra("JobImage","https://images.backstageaudition.com/voice_acting_desc.png");
                break;
            case 7:intent.putExtra("DESCRIPTION","Documentary Voice Artist");
                intent.putExtra("JobImage","https://images.backstageaudition.com/documentary_voice_artist_desc.png");
                break;
            case 8:intent.putExtra("DESCRIPTION","Studio Recording Specialist");
                intent.putExtra("JobImage","https://images.backstageaudition.com/studio_recording_specialist_desc.png");
                break;
            case 9:intent.putExtra("DESCRIPTION","Mimicry Artist");
                intent.putExtra("JobImage","https://images.backstageaudition.com/mimicry_artist_desc.png");
                break;
            case 10:intent.putExtra("DESCRIPTION","Audio Editor");
                intent.putExtra("JobImage","https://images.backstageaudition.com/audio_editor_desc.png");
                break;
            case 11:intent.putExtra("DESCRIPTION","Sound Engineer");
                intent.putExtra("JobImage","https://images.backstageaudition.com/sound_engineer_desc.png");
                break;
            case 12:intent.putExtra("DESCRIPTION","Sound Designer");
                intent.putExtra("JobImage","https://images.backstageaudition.com/sound_designer_desc.png");
                break;
            case 13:intent.putExtra("DESCRIPTION","Foley Artist");
                intent.putExtra("JobImage","https://images.backstageaudition.com/foley_artist_desc.png");
                break;
            case 14:intent.putExtra("DESCRIPTION","Music Producer");
                intent.putExtra("JobImage","https://images.backstageaudition.com/music_producer_desc.png");
                break;
            case 15:intent.putExtra("DESCRIPTION","Live Sound Engineer");
                intent.putExtra("JobImage","https://images.backstageaudition.com/live_sound_engineer_desc.png");
                break;
            case 16:intent.putExtra("DESCRIPTION","Audio Technician");
                intent.putExtra("JobImage","https://images.backstageaudition.com/audio_technician_desc.png");
                break;
            case 17:intent.putExtra("DESCRIPTION","Acoustic Consultant");
                intent.putExtra("JobImage","https://images.backstageaudition.com/acoustic_consultant_desc.png");
                break;
            case 18:intent.putExtra("DESCRIPTION","Broadcast Technician");
                intent.putExtra("JobImage","https://images.backstageaudition.com/broadcast_technician_desc.png");
                break;
            case 19:intent.putExtra("DESCRIPTION","Audio Researcher");
                intent.putExtra("JobImage","https://images.backstageaudition.com/audio_researcher_desc.png");
                break;
            case 20:intent.putExtra("DESCRIPTION","Boom Operator");
                intent.putExtra("JobImage","https://images.backstageaudition.com/boom_operator_desc.png");
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