package casting.movie.audition.fragments;

import static android.content.Context.MODE_PRIVATE;

import android.content.Intent;
import android.content.SharedPreferences;
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
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.google.android.gms.ads.formats.UnifiedNativeAdView;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.formats.MediaView;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import casting.movie.audition.activities.ChatbotActivity;
import casting.movie.audition.activities.EditProfile;
import casting.movie.audition.auditionActivities.FemalePorfolioActivity;
import casting.movie.audition.auditionActivities.MalePorfolioActivity;
import casting.movie.audition.jobs.FindJobActivity;
import casting.movie.audition.R;
import de.hdodenhof.circleimageview.CircleImageView;
import pl.droidsonroids.gif.GifImageView;

public class DashboardFragment extends Fragment {

    SharedPreferences sp;
    TextView userName,findJobs;
    LinearLayout female,male;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference=firebaseDatabase.getInstance().getReference("UserDetails");
    private UnifiedNativeAd nativeAd;

    GoogleSignInOptions googleSignInOptions;
    GoogleSignInClient googleSignInClient;
    ImageView backstage_icon,santa_img;
    GifImageView male_icon1,female_icon1;
    CircleImageView profile_image;
    GifImageView fab,live_chat;
    Button male_prtfolio,female_prtfolio;
    LinearLayout register_now,create_profile;
    RelativeLayout profile_picture;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root= inflater.inflate(R.layout.fragment_dashboard, container, false);

        userName=root.findViewById(R.id.userName);
        profile_image=root.findViewById(R.id.profile_image);
        female=root.findViewById(R.id.female);
        findJobs=root.findViewById(R.id.findJobs);
        male=root.findViewById(R.id.male);
        male_icon1=root.findViewById(R.id.male_icon1);
        female_icon1=root.findViewById(R.id.female_icon1);
        male_prtfolio=root.findViewById(R.id.male_prtfolio);
        female_prtfolio=root.findViewById(R.id.female_prtfolio);
        profile_picture=root.findViewById(R.id.profile_picture);
        backstage_icon=root.findViewById(R.id.backstage_icon);
        santa_img=root.findViewById(R.id.santa_img);
        live_chat=root.findViewById(R.id.live_chat);
        fab = root.findViewById(R.id.fab);
        register_now=root.findViewById(R.id.register_now);
        create_profile=root.findViewById(R.id.create_profile);
       // Glide.with(this).load("https://images.backstageaudition.com/chat_gif.gif").into(fab);

        Picasso.with(getActivity()).load("https://images.backstageaudition.com/backstage_new1.png").fit().into(backstage_icon);
        Picasso.with(getActivity()).load("https://images.backstageaudition.com/backstage_new2.png").fit().into(santa_img);

        Glide.with(this).load("https://images.backstageaudition.com/man_click_here_gif.gif").into(male_icon1);
        Glide.with(this).load("https://images.backstageaudition.com/women_click_here_gif.gif").into(female_icon1);




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
        male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), MalePorfolioActivity.class));
            }
        });
        female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), FemalePorfolioActivity.class));
            }
        });
        male_prtfolio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), MalePorfolioActivity.class));
            }
        });
        female_prtfolio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), FemalePorfolioActivity.class));
            }
        });
        findJobs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), FindJobActivity.class));
            }
        });
        profile_picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),EditProfile.class));
            }
        });

        sp = getActivity().getSharedPreferences("login",MODE_PRIVATE);
        String MobileNumber=sp.getString("UserMobile",null);
        String UserName=sp.getString("UserName",null);



        googleSignInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        googleSignInClient = GoogleSignIn.getClient(getActivity(),googleSignInOptions);
        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(getActivity());
        if(acct!=null){
            String personName = acct.getDisplayName();
            userName.setText("User Name: "+personName);
        }
        else{
            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {

                    if(snapshot.hasChild(MobileNumber)){

                        final String getUserName=snapshot.child(MobileNumber).child("userName").getValue(String.class);
                        final String getUserImage=snapshot.child(MobileNumber).child("ProfileImage").getValue(String.class);
                        userName.setText("User Name: "+getUserName);
                        if(getUserImage!=null){
                            Picasso.with(getActivity()).load(getUserImage).fit().into(profile_image);
                        }
                        else{
                            profile_image.setImageResource(R.drawable.profile_gif);
                        }

                    }
                    else{

                        Toast.makeText(getActivity(), "Please Sign up.", Toast.LENGTH_SHORT).show();
                    }

                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }



//        sp= getActivity().getSharedPreferences(filename, Context.MODE_PRIVATE);
//        if(sp.contains(Uname)){
//            //Toast.makeText(getActivity(),"Username:"+sp.getString(Uname,""),Toast.LENGTH_SHORT).show();
//        }
//
//      //  String email=getActivity().getIntent().getStringExtra("Email Id");
//        sqLiteHelper = new SQLiteHelper(getActivity(), "UserProfile.sqlite", null, 1);
//
//        profile_photo=root.findViewById(R.id.profile_photo);
//
//        profile_photo.setImageBitmap(sqLiteHelper.getImage(sp.getString(Uname,"")));


        // GOOGLE ADMOB
//        MobileAds.initialize(getActivity(), new OnInitializationCompleteListener() {
//            @Override
//            public void onInitializationComplete(InitializationStatus initializationStatus) {
//            }
//        });
//        AdView mAdView = root.findViewById(R.id.adView);
//        AdRequest adRequest = new AdRequest.Builder().build();
//        mAdView.loadAd(adRequest);

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