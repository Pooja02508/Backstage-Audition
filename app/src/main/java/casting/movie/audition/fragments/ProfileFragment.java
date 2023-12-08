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
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import casting.movie.audition.activities.ChatbotActivity;
import casting.movie.audition.activities.EditProfile;
import casting.movie.audition.activities.ReferEarnActivity;
import casting.movie.audition.R;
import casting.movie.audition.activities.WebViewActivity;
import casting.movie.audition.models.UserDetails;
import de.hdodenhof.circleimageview.CircleImageView;
import pl.droidsonroids.gif.GifImageView;


public class ProfileFragment extends Fragment {

    ImageView backstage_icon,santa_img,edit_profile2;
    CircleImageView profile_image;
    Button edit_profile1;
    SharedPreferences sp;
  
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference=firebaseDatabase.getInstance().getReference("UserDetails");
    TextView user_name,user_email,user_city,user_mobile;
    private FirebaseAuth mAuth;
    GifImageView fab,live_chat;
    LinearLayout register_now,create_profile,refer_earn;

    GoogleSignInOptions googleSignInOptions;
    GoogleSignInClient googleSignInClient;
    String personName,personEmail;
    UserDetails userDetails;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root= inflater.inflate(R.layout.fragment_profile, container, false);


        backstage_icon=root.findViewById(R.id.backstage_icon);
        santa_img=root.findViewById(R.id.santa_img);
        Picasso.with(getActivity()).load("https://images.backstageaudition.com/backstage_new1.png").fit().into(backstage_icon);
        Picasso.with(getActivity()).load("https://images.backstageaudition.com/backstage_new2.png").fit().into(santa_img);
        fab = root.findViewById(R.id.fab);
        live_chat=root.findViewById(R.id.live_chat);
        register_now=root.findViewById(R.id.register_now);
        create_profile=root.findViewById(R.id.create_profile);
        refer_earn=root.findViewById(R.id.refer_earn);
        edit_profile1=root.findViewById(R.id.edit_profile1);
        edit_profile2=root.findViewById(R.id.edit_profile2);
        profile_image=root.findViewById(R.id.profile_image);
       // Glide.with(this).load("https://images.backstageaudition.com/chat_gif.gif").into(fab);

        sp = getActivity().getSharedPreferences("login",MODE_PRIVATE);
        String MobileNumber=sp.getString("UserMobile",null);


        mAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("UserDetails");
        userDetails = new UserDetails();

        user_name=root.findViewById(R.id.user_name);
        user_email=root.findViewById(R.id.user_email);
        user_city=root.findViewById(R.id.user_city);
        user_mobile=root.findViewById(R.id.user_mobile);

        edit_profile1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), EditProfile.class));
            }
        });
        edit_profile2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), EditProfile.class));
            }
        });

        register_now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), WebViewActivity.class);
                intent.putExtra("Link","https://backstageaudition.com/contents/en-us/p1181_Backstage-Profile-Create-Your-Casting-Profile.html");
                startActivity(intent);
//                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://backstageaudition.com/contents/en-us/p1181_Backstage-Profile-Create-Your-Casting-Profile.html")));
            }
        });
        create_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), WebViewActivity.class);
                intent.putExtra("Link","https://backstageaudition.com/contents/en-us/p1183_Create-an-acting-Portfolio.html");
                startActivity(intent);
//                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://backstageaudition.com/contents/en-us/p1183_Create-an-acting-Portfolio.html")));
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
        refer_earn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ReferEarnActivity.class));
            }
        });

        googleSignInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        googleSignInClient = GoogleSignIn.getClient(getActivity(),googleSignInOptions);

        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(getActivity());
        if(acct!=null){
            personName = acct.getDisplayName();
            personEmail = acct.getEmail();
            user_name.setText(personName);
            user_email.setText(personEmail);
            registerNewUser();
        }

        if(MobileNumber==null){

        }

        else {
            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {

                    if(snapshot.hasChild(MobileNumber)){

                        final String getUserFirstName=snapshot.child(MobileNumber).child("userName").getValue(String.class);
                        final String getUserMobile=snapshot.child(MobileNumber).child("userMobile").getValue(String.class);
                        final String getUserEmail=snapshot.child(MobileNumber).child("userEmail").getValue(String.class);
                        final String getUserCity=snapshot.child(MobileNumber).child("userAddress").getValue(String.class);
                        final String getUserImage=snapshot.child(MobileNumber).child("ProfileImage").getValue(String.class);

                        user_name.setText(getUserFirstName);
                        user_mobile.setText(getUserMobile);
                        user_email.setText(getUserEmail);
                        user_city.setText(getUserCity);

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



//        AdView mAdView = root.findViewById(R.id.adView);
//        AdRequest adRequest = new AdRequest.Builder().build();
//        mAdView.loadAd(adRequest);

//        MobileAds.initialize(getActivity(), getString(R.string.ADMOB_ADS_UNIT_ID));
//
//        AdLoader.Builder builder = new AdLoader.Builder(getActivity(), getString(R.string.ADMOB_ADS_UNIT_ID));
//        builder.forUnifiedNativeAd(new UnifiedNativeAd.OnUnifiedNativeAdLoadedListener() {
//            @Override
//            public void onUnifiedNativeAdLoaded(UnifiedNativeAd unifiedNativeAd) {
//                if (nativeAd != null) {
//                    nativeAd.destroy();
//                }
//                nativeAd = unifiedNativeAd;
//                FrameLayout frameLayout = root.findViewById(R.id.fl_adplaceholder);
//                UnifiedNativeAdView adView = (UnifiedNativeAdView) getLayoutInflater().inflate(R.layout.ad_unified, null);
//
//                populateUnifiedNativeAdView(unifiedNativeAd, adView);
//                frameLayout.removeAllViews();
//                frameLayout.addView(adView);
//            }
//        });
//
//        NativeAdOptions adOptions = new NativeAdOptions.Builder().build();
//        builder.withNativeAdOptions(adOptions);
//        AdLoader adLoader = builder.withAdListener (new AdListener(){
//
//            @Override
//            public void onAdFailedToLoad(int i) {
//
//            }
//        }).build();
//        adLoader.loadAd(new AdRequest.Builder().build());

        return root;
    }

    private void registerNewUser() {
        // Take the value of two edit texts in Strings
        String email, password;
        email = personEmail;
        password = personName;

        // create new user or register new user
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {

                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task)
                    {
                        if (task.isSuccessful()) {

                            userDetails.setUserName(personName);
                            userDetails.setUserEmail(personEmail);


                            databaseReference.child("UserDetails").addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot snapshot) {
                                    if(snapshot.hasChild(personName)){
                                        Toast.makeText(getActivity(), "User already exists.", Toast.LENGTH_SHORT).show();
                                    }
                                    else{
                                        databaseReference.child(personName).setValue(userDetails);
                                    }
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError error) {
//                                    Toast.makeText(getActivity(), "Fail to add data " + error, Toast.LENGTH_SHORT).show();
                                }
                            });

                        }
                        else {
                            // Registration failed
//                            Toast.makeText(getActivity(), "Registration failed!! Please try again later", Toast.LENGTH_LONG).show();

                        }
                    }
                });
    }

//    private void populateUnifiedNativeAdView(UnifiedNativeAd nativeAd, UnifiedNativeAdView adView) {
//
//        adView.setMediaView((MediaView) adView.findViewById(R.id.ad_media));
//        adView.setHeadlineView(adView.findViewById(R.id.ad_headline));
//        adView.setBodyView(adView.findViewById(R.id.ad_body));
//        adView.setCallToActionView(adView.findViewById(R.id.ad_call_to_action));
//        adView.setIconView(adView.findViewById(R.id.ad_app_icon));
//        adView.setPriceView(adView.findViewById(R.id.ad_price));
//        adView.setAdvertiserView(adView.findViewById(R.id.ad_advertiser));
//        adView.setStoreView(adView.findViewById(R.id.ad_store));
//        adView.setStarRatingView(adView.findViewById(R.id.ad_stars));
//
//        ((TextView)adView.getHeadlineView()).setText(nativeAd.getHeadline());
//        adView.getMediaView().setMediaContent(nativeAd.getMediaContent());
//
//        if (nativeAd.getBody() == null) {
//            adView.getBodyView().setVisibility(View.INVISIBLE);
//        } else {
//            adView.getBodyView().setVisibility(View.VISIBLE);
//            ((TextView) adView.getBodyView()).setText(nativeAd.getBody());
//        }
//        if (nativeAd.getCallToAction() == null) {
//            adView.getCallToActionView().setVisibility(View.INVISIBLE);
//        } else {
//            adView.getCallToActionView().setVisibility(View.VISIBLE);
//            ((Button) adView.getCallToActionView()).setText(nativeAd.getCallToAction());
//        }
//        if (nativeAd.getIcon() == null) {
//            adView.getIconView().setVisibility(View.GONE);
//        } else {
//            ((ImageView) adView.getIconView()).setImageDrawable(nativeAd.getIcon().getDrawable());
//            adView.getIconView().setVisibility(View.VISIBLE);
//        }
//        if (nativeAd.getPrice() == null) {
//            adView.getPriceView().setVisibility(View.INVISIBLE);
//        } else {
//            adView.getPriceView().setVisibility(View.VISIBLE);
//            ((TextView) adView.getPriceView()).setText(nativeAd.getPrice());
//        }
//        if (nativeAd.getStore() == null) {
//            adView.getStoreView().setVisibility(View.INVISIBLE);
//        } else {
//            adView.getStoreView().setVisibility(View.VISIBLE);
//            ((TextView) adView.getStoreView()).setText(nativeAd.getStore());
//
//        }
//        if (nativeAd.getStarRating() == null) {
//            adView.getStarRatingView().setVisibility(View.INVISIBLE);
//        } else {
//            ((RatingBar) adView.getStarRatingView()).setRating(nativeAd.getStarRating().floatValue());
//            adView.getStarRatingView().setVisibility(View.VISIBLE);
//        }
//        if (nativeAd.getAdvertiser() == null) {
//            adView.getAdvertiserView().setVisibility(View.INVISIBLE);
//
//        } else {
//            ((TextView) adView.getAdvertiserView()).setText(nativeAd.getAdvertiser());
//            adView.getAdvertiserView().setVisibility(View.VISIBLE);
//        }
//        adView.setNativeAd(nativeAd);
//    }

}