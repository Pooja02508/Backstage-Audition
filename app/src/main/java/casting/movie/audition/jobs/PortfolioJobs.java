package casting.movie.audition.jobs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
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

import casting.movie.audition.activities.ChatbotActivity;
import casting.movie.audition.fragments.AuditionsFragment;
import casting.movie.audition.fragments.BackstageJobsFragment;
import casting.movie.audition.fragments.DashboardFragment;
import casting.movie.audition.fragments.HomeFragment;
import casting.movie.audition.fragments.ProfileFragment;
import casting.movie.audition.R;
import casting.movie.audition.models.AuditionAdapter;
import casting.movie.audition.models.Auditions;
import pl.droidsonroids.gif.GifImageView;

public class PortfolioJobs extends AppCompatActivity implements AuditionAdapter.ItemClickListener{

    private UnifiedNativeAd nativeAd;
    RecyclerView recyclerView;
    ArrayList<Auditions> auditionsArrayList=new ArrayList<>();
    ImageView backstage_icon,santa_img;
    GifImageView fab,live_chat;
    LinearLayout register_now,create_profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portfolio_jobs);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView=findViewById(R.id.recyclerView);
        fab = findViewById(R.id.fab);
        live_chat=findViewById(R.id.live_chat);
        backstage_icon=findViewById(R.id.backstage_icon);
        santa_img=findViewById(R.id.santa_img);

        register_now=findViewById(R.id.register_now);
        create_profile=findViewById(R.id.create_profile);

        Picasso.with(this).load("https://images.backstageaudition.com/backstage_new1.png").fit().into(backstage_icon);
        Picasso.with(this).load("https://images.backstageaudition.com/backstage_new2.png").fit().into(santa_img);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav_view);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();

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


        String JobTitle=getIntent().getStringExtra("Job Title");

        if(JobTitle.equals("Voice Job")){
            auditionsArrayList.add(new Auditions("\uD83D\uDDE3 Dubbing Artist","https://images.backstageaudition.com/dubbing_artist_jobs.png"));
            auditionsArrayList.add(new Auditions("\uD83D\uDDE3 Radio Show Host","https://images.backstageaudition.com/radio_show_host_jobs.png"));
            auditionsArrayList.add(new Auditions("\uD83D\uDDE3 Audio Book Narrator","https://images.backstageaudition.com/audio_book_narrator_jobs.png"));
            auditionsArrayList.add(new Auditions("\uD83D\uDDE3 Character Voice Actor","https://images.backstageaudition.com/character_voice_actor_jobs.png"));
            auditionsArrayList.add(new Auditions("\uD83D\uDDE3 Voice-over Artist","https://images.backstageaudition.com/voice_over_artist_jobs.png"));
            auditionsArrayList.add(new Auditions("\uD83D\uDDE3 Animation and Cartoons","https://images.backstageaudition.com/animation_and_cartoons_jobs.png"));
            auditionsArrayList.add(new Auditions("\uD83D\uDDE3 Voice acting","https://images.backstageaudition.com/voice_acting_jobs.png"));
            auditionsArrayList.add(new Auditions("\uD83D\uDDE3 Documentary voice artist","https://images.backstageaudition.com/documentary_voice_artist_jobs.png"));
            auditionsArrayList.add(new Auditions("\uD83D\uDDE3 Studio Recording Specialist","https://images.backstageaudition.com/studio_recording_specialist_jobs.png"));
            auditionsArrayList.add(new Auditions("\uD83D\uDDE3 Mimicry Artist","https://images.backstageaudition.com/mimicry_artist_jobs.png"));
            auditionsArrayList.add(new Auditions("\uD83D\uDDE3 Audio editor","https://images.backstageaudition.com/audio_editor_jobs.png"));
            auditionsArrayList.add(new Auditions("\uD83D\uDDE3 Sound Engineer","https://images.backstageaudition.com/sound_engineer.png"));
            auditionsArrayList.add(new Auditions("\uD83D\uDDE3 Sound Designer","https://images.backstageaudition.com/sound_designer_job.png"));
            auditionsArrayList.add(new Auditions("\uD83D\uDDE3 Foley Artist","https://images.backstageaudition.com/foley_artist.png"));
            auditionsArrayList.add(new Auditions("\uD83D\uDDE3 Music Producer","https://images.backstageaudition.com/music_producer.png"));
            auditionsArrayList.add(new Auditions("\uD83D\uDDE3 Live Sound Engineer","https://images.backstageaudition.com/live_sound_engineer.png"));
            auditionsArrayList.add(new Auditions("\uD83D\uDDE3 Audio Technician","https://images.backstageaudition.com/audio_technician.png"));
            auditionsArrayList.add(new Auditions("\uD83D\uDDE3 Acoustic Consultant","https://images.backstageaudition.com/acoustic_consultant.png"));
            auditionsArrayList.add(new Auditions("\uD83D\uDDE3 Broadcast Technician","https://images.backstageaudition.com/broadcast_technician.png"));
            auditionsArrayList.add(new Auditions("\uD83D\uDDE3 Audio Researcher","https://images.backstageaudition.com/audio_researcher.png"));
            auditionsArrayList.add(new Auditions("\uD83D\uDDE3 Boom Operator","https://images.backstageaudition.com/boom_operator.png"));
        }
        else if(JobTitle.equals("Music Job")){

            auditionsArrayList.add(new Auditions("Musician","https://images.backstageaudition.com/musician.png"));
            auditionsArrayList.add(new Auditions("Instrumentalist","https://images.backstageaudition.com/instrumentalist.png"));
            auditionsArrayList.add(new Auditions("Singer","https://images.backstageaudition.com/singer.png"));
            auditionsArrayList.add(new Auditions("Backup Singer","https://images.backstageaudition.com/backup_singer.png"));
            auditionsArrayList.add(new Auditions("Songwriter","https://images.backstageaudition.com/songwriter.png"));
            auditionsArrayList.add(new Auditions("Composer","https://images.backstageaudition.com/composer_job.png"));
            auditionsArrayList.add(new Auditions("Music Producer","https://images.backstageaudition.com/music_producer_job.png"));
            auditionsArrayList.add(new Auditions("Recording Engineer","https://images.backstageaudition.com/recording_engineer.png"));
            auditionsArrayList.add(new Auditions("Music Teacher","https://images.backstageaudition.com/music_teacher.png"));
            auditionsArrayList.add(new Auditions("Studio Musician","https://images.backstageaudition.com/studio_musician.png"));
            auditionsArrayList.add(new Auditions("Music Instructor","https://images.backstageaudition.com/music_instructor.png"));
            auditionsArrayList.add(new Auditions("Music Director","https://images.backstageaudition.com/music_director.png"));
            auditionsArrayList.add(new Auditions("DJ ( Disc Jockey)","https://images.backstageaudition.com/dj.png"));
            auditionsArrayList.add(new Auditions("Music Journalist","https://images.backstageaudition.com/music_journalist.png"));
            auditionsArrayList.add(new Auditions("A & R Representative","https://images.backstageaudition.com/ar_representative.png"));
            auditionsArrayList.add(new Auditions("Music Agent","https://images.backstageaudition.com/music_agent.png"));
            auditionsArrayList.add(new Auditions("Sound Designer","https://images.backstageaudition.com/sound_designer_music.png"));
            auditionsArrayList.add(new Auditions("Music Publisher","https://images.backstageaudition.com/music_publisher.png"));
            auditionsArrayList.add(new Auditions("Music Librarian","https://images.backstageaudition.com/music_librarian.png"));
            auditionsArrayList.add(new Auditions("Concert Promoter","https://images.backstageaudition.com/concert_promoter.png"));
            auditionsArrayList.add(new Auditions("Tour Manager","https://images.backstageaudition.com/tour_manager.png"));
            auditionsArrayList.add(new Auditions("Music Industry Executive","https://images.backstageaudition.com/music_industry_executive.png"));
            auditionsArrayList.add(new Auditions("Music Instruments Rental","https://images.backstageaudition.com/music_instruments_rental.png"));
            auditionsArrayList.add(new Auditions("Music Instruments Repair","https://images.backstageaudition.com/music_instruments_repair.png"));
            auditionsArrayList.add(new Auditions("Music Equipment Technician","https://images.backstageaudition.com/music_equipment_technician.png"));
            auditionsArrayList.add(new Auditions("Music Event Coordinator","https://images.backstageaudition.com/music_event_coordinator.png"));
            auditionsArrayList.add(new Auditions("Music Streaming Specialist","https://images.backstageaudition.com/music_streaming_specialist.png"));
            auditionsArrayList.add(new Auditions("Music Copyright Specialist","https://images.backstageaudition.com/music_copyright_specialist.png"));
            auditionsArrayList.add(new Auditions("Orchestra Musician","https://images.backstageaudition.com/orchestra_musician.png"));
        }
        else if(JobTitle.equals("Makeup Job")){

            auditionsArrayList.add(new Auditions("Make-up artist","https://images.backstageaudition.com/make_up_artist.png"));
            auditionsArrayList.add(new Auditions("Special effects makeup artist","https://images.backstageaudition.com/special_makeup_artist.png"));
            auditionsArrayList.add(new Auditions("Beauty Consultant","https://images.backstageaudition.com/beauty_consultant.png"));
            auditionsArrayList.add(new Auditions("Makeup Department Head","https://images.backstageaudition.com/makeup_department_head.png"));
            auditionsArrayList.add(new Auditions("Makeup Assistant","https://images.backstageaudition.com/makeup_assistant.png"));
            auditionsArrayList.add(new Auditions("Prosthetic Technician","https://images.backstageaudition.com/prosthetic_technician.png"));
            auditionsArrayList.add(new Auditions("Makeup Effects Coordinator","https://images.backstageaudition.com/makeup_effects_coordinator.png"));
            auditionsArrayList.add(new Auditions("Body Makeup Artist","https://images.backstageaudition.com/body_makeup_artist.png"));
            auditionsArrayList.add(new Auditions("Makeup Designer","https://images.backstageaudition.com/makeup_designer.png"));
            auditionsArrayList.add(new Auditions("Body Painter","https://images.backstageaudition.com/body_painter.png"));
            auditionsArrayList.add(new Auditions("Makeup Researcher","https://images.backstageaudition.com/makeup_researcher.png"));
            auditionsArrayList.add(new Auditions("Hair Stylist","https://images.backstageaudition.com/hair_stylist.png"));
            auditionsArrayList.add(new Auditions("Hair and Makeup Supervisor","https://images.backstageaudition.com/hair_and_makeup_supervisor.png"));
            auditionsArrayList.add(new Auditions("Key Hair Stylist","https://images.backstageaudition.com/key_hair_stylist.png"));
            auditionsArrayList.add(new Auditions("Assistant Hair Stylist","https://images.backstageaudition.com/assistant_hair_stylist.png"));
            auditionsArrayList.add(new Auditions("Wig Master","https://images.backstageaudition.com/wig_master.png"));
            auditionsArrayList.add(new Auditions("Wig Mistress","https://images.backstageaudition.com/wig_mistress.png"));
            auditionsArrayList.add(new Auditions("Hair Colorist","https://images.backstageaudition.com/hair_colorist.png"));
            auditionsArrayList.add(new Auditions("Hair Department Coordinator","https://images.backstageaudition.com/hair_department_coordinator.png"));
            auditionsArrayList.add(new Auditions("Hair Stylist Consultant","https://images.backstageaudition.com/key_hair_stylist.png"));
            auditionsArrayList.add(new Auditions("On-Set Stylist","https://images.backstageaudition.com/on_set_stylist.png"));
            auditionsArrayList.add(new Auditions("Hair Stylist for Special Effects","https://images.backstageaudition.com/hair_stylist_special_effects.png"));
            auditionsArrayList.add(new Auditions("Hair Stylist for Stunt Doubles","https://images.backstageaudition.com/hair_stylist_stunt_doubles.png"));
            auditionsArrayList.add(new Auditions("Period Hair Stylist","https://images.backstageaudition.com/period_hair_stylist.png"));
            auditionsArrayList.add(new Auditions("Key Hair Stylist","https://images.backstageaudition.com/key_hair_stylist2.png"));
            auditionsArrayList.add(new Auditions("Editorial/Photo Shoot Hair Stylist","https://images.backstageaudition.com/editorial_hair_stylist.png"));
            auditionsArrayList.add(new Auditions("Hair stylist for celebrities","https://images.backstageaudition.com/hair_stylist_celebrities.png"));
            auditionsArrayList.add(new Auditions("Barber","https://images.backstageaudition.com/barber.png"));
            auditionsArrayList.add(new Auditions("Crowd makeup artist","https://images.backstageaudition.com/crowd_makeup_artist.png"));
            auditionsArrayList.add(new Auditions("Contact lens optician","https://images.backstageaudition.com/contact_lens_optician.png"));
            auditionsArrayList.add(new Auditions("Wig designer","https://images.backstageaudition.com/wig_designer.png"));
            auditionsArrayList.add(new Auditions("Wig Rental","https://images.backstageaudition.com/wig_rental.png"));
            auditionsArrayList.add(new Auditions("Tattoo designer","https://images.backstageaudition.com/tattoo_designer.png"));
        }
        else if(JobTitle.equals("Costume Job")){
            auditionsArrayList.add(new Auditions("Costume Designer","https://images.backstageaudition.com/costume_designer_job.png"));
            auditionsArrayList.add(new Auditions("Costume Supervisor","https://images.backstageaudition.com/costume_supervisor.png"));
            auditionsArrayList.add(new Auditions("Costume Assistant","https://images.backstageaudition.com/costume_assistant.png"));
            auditionsArrayList.add(new Auditions("Costume Cutter","https://images.backstageaudition.com/costume_cutter.png"));
            auditionsArrayList.add(new Auditions("Costume Maker","https://images.backstageaudition.com/costume_maker.png"));
            auditionsArrayList.add(new Auditions("Costume Breakdown Artist","https://images.backstageaudition.com/costume_breakdown_artist.png"));
            auditionsArrayList.add(new Auditions("Costume Buyer","https://images.backstageaudition.com/costume_buyer.png"));
            auditionsArrayList.add(new Auditions("Wardrobe Supervisor","https://images.backstageaudition.com/wardrobe_supervisor.png"));
            auditionsArrayList.add(new Auditions("Specialty Costume Designer","https://images.backstageaudition.com/specialty_costume_designer.png"));
            auditionsArrayList.add(new Auditions("Costume Assistant Designer","https://images.backstageaudition.com/costume_assistant_designer.png"));
            auditionsArrayList.add(new Auditions("Set Costumer","https://images.backstageaudition.com/set_costumer.png"));
            auditionsArrayList.add(new Auditions("Costume Standby","https://images.backstageaudition.com/costume_standby.png"));
            auditionsArrayList.add(new Auditions("Costume Illustrator","https://images.backstageaudition.com/costume_illustrator.png"));
            auditionsArrayList.add(new Auditions("Costume Beader","https://images.backstageaudition.com/costume_beader.png"));
            auditionsArrayList.add(new Auditions("Costume Rental Manager","https://images.backstageaudition.com/costume_rental_manager.png"));
            auditionsArrayList.add(new Auditions("Dresser","https://images.backstageaudition.com/dresser.png"));
            auditionsArrayList.add(new Auditions("Costume Department Coordinator","https://images.backstageaudition.com/costume_department_coordinator.png"));
            auditionsArrayList.add(new Auditions("Costume Shop Manager","https://images.backstageaudition.com/costume_shop_manager.png"));
            auditionsArrayList.add(new Auditions("Costume Shop Assistant","https://images.backstageaudition.com/costume_shop_assistant.png"));
            auditionsArrayList.add(new Auditions("Costume Rental","https://images.backstageaudition.com/costume_rental.png"));
            auditionsArrayList.add(new Auditions("Costume Milliner (Hat Maker)","https://images.backstageaudition.com/costume_milliner.png"));
            auditionsArrayList.add(new Auditions("Costume Jewelry Maker","https://images.backstageaudition.com/costume_jewelry_maker.png"));
            auditionsArrayList.add(new Auditions("Distressing Artist","https://images.backstageaudition.com/distressing_artist.png"));
            auditionsArrayList.add(new Auditions("Costume Breakdown Shoemaker/Cobbler","https://images.backstageaudition.com/costume_breakdown_shoemaker.png"));
            auditionsArrayList.add(new Auditions("Costume Breakdown Leatherworker","https://images.backstageaudition.com/leatherworker.png"));
            auditionsArrayList.add(new Auditions("Costume Breakdown Textile Specialist","https://images.backstageaudition.com/costume_breakdown_textile_specialist.png"));
            auditionsArrayList.add(new Auditions("Costume Breakdown 3D Printer Technician","https://images.backstageaudition.com/costume_breakdown_3d_printer_technician.png"));
            auditionsArrayList.add(new Auditions("Costume Research Assistant","https://images.backstageaudition.com/costume_research_assistant.png"));
            auditionsArrayList.add(new Auditions("Costume Supervisor for Visual Effects","https://images.backstageaudition.com/costume_supervisor_for_visual_effects.png"));
            auditionsArrayList.add(new Auditions("Costume Photographer","https://images.backstageaudition.com/costume_photographer.png"));
            auditionsArrayList.add(new Auditions("Costume Consultant","https://images.backstageaudition.com/costume_consultant.png"));
            auditionsArrayList.add(new Auditions("Costume 3D Modeler","https://images.backstageaudition.com/costume_3d_modeler.png"));
            auditionsArrayList.add(new Auditions("Costume Embroiderer","https://images.backstageaudition.com/costume_embroiderer.png"));
            auditionsArrayList.add(new Auditions("Costume Warehouse Manager","https://images.backstageaudition.com/costume_warehouse_manager.png"));
        }
        else if(JobTitle.equals("Direction Job")){

            auditionsArrayList.add(new Auditions("Director","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Assistant Director (AD)","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Second Assistant Director ( 2nd AD )","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Script Supervisor","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Casting Director","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Production Designer","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Director of Photography (DP or Cinematographer","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Editor","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Production Manager","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Art Director","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Special Effects Supervisor","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Stunt Coordinator","https://images.backstageaudition.com/find_job.png"));

        }
        else if(JobTitle.equals("Acting Job")){
            auditionsArrayList.add(new Auditions("Actor","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Actress","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Stand-In","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Body Double","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Extras / Background Actor","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Talent Agent","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Acting Coach","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Casting Assistant","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Talent Scout","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Guest star appearance","https://images.backstageaudition.com/find_job.png"));

        }
        else if(JobTitle.equals("Action Job")){
            auditionsArrayList.add(new Auditions("Action Director","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Stunt Performer","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Stunt Coordinator","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Fight Choreographer","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Special Effects Supervisor","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Visual Effects Supervisor","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Action Cinematographer","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Action Camera Operator","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Armorer","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Production Designer for action / Action Art Director","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Action Sound Designer","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Action Scene Editor","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Action Gaffer","https://images.backstageaudition.com/find_job.png"));

        }
        else if(JobTitle.equals("Dance Job")){
            auditionsArrayList.add(new Auditions("Dancer","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Choreographer","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Dance Instructor","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Dance Researcher","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Dance Consultant","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Dance Program Coordinator","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Dance Notator","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Dance Production Manager","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Dance Film/Video Director","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Dance Company Manager","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Dance company rehearsal director","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Dance studio manager","https://images.backstageaudition.com/find_job.png"));
        }
        else if(JobTitle.equals("Editing Job")){
            auditionsArrayList.add(new Auditions("VFX Editor","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Special Effects","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Visual Effects Supervisor","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Digital Loader","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Assistant Director of Photography","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Assistant Editor","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Animator","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Dialogue Editor","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Colorist","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Assistant Colorist","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Title Designer","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Assistant Title Designer","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Previsualization (Previz) Artist","https://images.backstageaudition.com/find_job.png"));

        }
        else if(JobTitle.equals("Camera Production Job")){
            auditionsArrayList.add(new Auditions("Camera Production Assistant","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Camera Trainee","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Steadicam Operator","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Camera Operator","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Data Wrangler","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Digital Imaging Technician","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Assistant Camera Operator","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Rigging Grip","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Dolly Grip","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Best Boy Grip","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Key Grip","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Focus Puller (1st AC)","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Drone Operator","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Production Accountant","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Assistant Production Accountant","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Video Assist Operator","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Film Loader / Clapper Loader","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Digital Asset Manager (DAM)","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Accounting Clerk","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Production Secretary","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Script Reader","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Quality Control Technician","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Previs artist","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Weapons Master","https://images.backstageaudition.com/find_job.png"));
        }
        else if(JobTitle.equals("Other Job")){
            auditionsArrayList.add(new Auditions("Transportation Coordinator","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Driver","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Construction Foreman","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Construction Coordinator","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Property Master","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Set Decorator","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Leadman","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Assistant Set Designer","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Production Secretary","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Production Coordinator","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Location Assistant","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Location Scout","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Assistant Location Manager","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Casting Associate","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Casting Researcher","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Casting Scout","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Casting Coordinator","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Casting Assistant","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Crowd Technical Director","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Digital Matte Painter","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Digital Compositor","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Lighting Supervisor","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Matchmove Supervisor","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Compositing Supervisor","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Render Wrangler","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Animal Handler","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Standby Painter","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Set Painter","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Standby Painter","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Leadman","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Scenic Carpenter","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Model Maker","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Rigger","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Dimmer Operator","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Rigging Electrician","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Texturing Artist","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Matchmover","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Aerial Coordinator","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Transportation Captain","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Pyrotechnician","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Animal Wrangler","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Armorer","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Set Decorator","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Rotoscope Artist","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Compositor","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Focus Puller","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Clapper Loader","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Electrician","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Best Boy Electric","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Lighting Technician","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Props master","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Animal Coordinator","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Key Scenic Artist","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Film Equipment Rental Coordinator","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Film Insurance Agent","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Film lab technician","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Set Extension Artist","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Set Medic","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Film historian","https://images.backstageaudition.com/find_job.png"));
        }
        else {
            auditionsArrayList.add(new Auditions("Film Festival Coordinator","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Film Marketing Manager","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Film Distribution Executive","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Film Sales Agent","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Film Publicist","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Film Projectionist","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Film Rights Acquisitions Executive","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Film Stock Supplier","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Delivery Coordinator","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Trailer Editor","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Film Distributor","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Film Sales Agent","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Media Manager","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Marketing and Publicity Coordinator","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Public Relations Assistant","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Social Media Assistant","https://images.backstageaudition.com/find_job.png"));
        }


        int numberOfColumns = 2;
        recyclerView.setLayoutManager(new GridLayoutManager(this, numberOfColumns));
        AuditionAdapter adapter = new AuditionAdapter(this,auditionsArrayList);
        recyclerView.setAdapter(adapter);
        adapter.setClickListener(this);

        MobileAds.initialize(this, getString(R.string.ADMOB_ADS_UNIT_ID));

        AdLoader.Builder builder = new AdLoader.Builder(this, getString(R.string.ADMOB_ADS_UNIT_ID));
        builder.forUnifiedNativeAd(new UnifiedNativeAd.OnUnifiedNativeAdLoadedListener() {
            @Override
            public void onUnifiedNativeAdLoaded(UnifiedNativeAd unifiedNativeAd) {
                if (nativeAd != null) {
                    nativeAd.destroy();
                }
                nativeAd = unifiedNativeAd;
                FrameLayout frameLayout =findViewById(R.id.fl_adplaceholder);
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
    }

    @Override
    public void onItemClick(View view, int position) {

        Intent intent=new Intent(this, PortfolioDescription.class);
        String JobName=getIntent().getStringExtra("Job Title");

        if(JobName.equals("Voice Job")){
            switch (position){
                case 0:intent.putExtra("DESCRIPTION","Dubbing Artist");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/dubbing_artist_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d4_create-Backstage-Dubbing-Artist-Portfolio-to-Apply-for-Dubbing-Artist-Portfolio-near-you.html");
                    break;
                case 1:intent.putExtra("DESCRIPTION","Radio Show Host");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/radio_show_host_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d3_create-Backstage-Radio-Show-Host-Portfolio-to-Apply-for-Radio-Show-Host-Portfolio-near-you.html");
                    break;
                case 2:intent.putExtra("DESCRIPTION","Audio Book Narrator");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/audio_book_narrator_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d5_create-Backstage-Audio-Book-Narrator--Portfolio-to-Apply-for-Audio-Book-Narrator--Portfolio-near-you.html");
                    break;
                case 3:intent.putExtra("DESCRIPTION","Character Voice Actor");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/character_voice_actor_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d6_create-Backstage-Character-Voice-Actor-Portfolio-to-Apply-for-Character-Voice-Actor-Portfolio-near-you.html");
                    break;
                case 4:intent.putExtra("DESCRIPTION","Voice Over Artist");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/voice_over_artist_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d2_create-Backstage-Voice-Over-Artist-Portfolio-to-Apply-for-Voice-Over-Artist-Portfolio-near-you.html");
                    break;
                case 5:intent.putExtra("DESCRIPTION","Animation And Cartoons");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/animation_and_cartoons_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d8_create-Backstage-Animation-and-Cartoons--Portfolio-to-Apply-for-Animation-and-Cartoons--Portfolio-near-you.html");
                    break;
                case 6:intent.putExtra("DESCRIPTION","Voice Acting");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/voice_acting_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d9_create-Backstage-Voice-acting-Portfolio-to-Apply-for-Voice-acting-Portfolio-near-you.html");
                    break;
                case 7:intent.putExtra("DESCRIPTION","Documentary Voice Artist");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/documentary_voice_artist_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d10_create-Backstage-Documentary-voice-artist-Portfolio-to-Apply-for-Documentary-voice-artist-Portfolio-near-you.html");
                    break;
                case 8:intent.putExtra("DESCRIPTION","Studio Recording Specialist");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/studio_recording_specialist_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d11_create-Backstage-Studio-Recording-Specialist-Portfolio-to-Apply-for-Studio-Recording-Specialist-Portfolio-near-you.html");
                    break;
                case 9:intent.putExtra("DESCRIPTION","Mimicry Artist");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/mimicry_artist_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d12_create-Backstage-Mimicry-Artist-Portfolio-to-Apply-for-Mimicry-Artist-Portfolio-near-you.html");
                    break;
                case 10:intent.putExtra("DESCRIPTION","Audio Editor");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/audio_editor_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d13_create-Backstage-Audio-editor-Portfolio-to-Apply-for-Audio-editor-Portfolio-near-you.html");
                    break;
                case 11:intent.putExtra("DESCRIPTION","Sound Engineer");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/sound_engineer_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d14_create-Backstage-Sound-Engineer-Portfolio-to-Apply-for-Sound-Engineer-Portfolio-near-you.html");
                    break;
                case 12:intent.putExtra("DESCRIPTION","Sound Designer");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/sound_designer_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d15_create-Backstage-Sound-Designer-Portfolio-to-Apply-for-Sound-Designer-Portfolio-near-you.html");
                    break;
                case 13:intent.putExtra("DESCRIPTION","Foley Artist");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/foley_artist_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d16_create-Backstage-Foley-Artist-Portfolio-to-Apply-for-Foley-Artist-Portfolio-near-you.html");
                    break;
                case 14:intent.putExtra("DESCRIPTION","Music Producer");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/music_producer_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d17_create-Backstage-Music-Producer-Portfolio-to-Apply-for-Music-Producer-Portfolio-near-you.html");
                    break;
                case 15:intent.putExtra("DESCRIPTION","Live Sound Engineer");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/live_sound_engineer_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d18_create-Backstage-Live-Sound-Engineer-Portfolio-to-Apply-for-Live-Sound-Engineer-Portfolio-near-you.html");
                    break;
                case 16:intent.putExtra("DESCRIPTION","Audio Technician");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/audio_technician_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d19_create-Backstage-Audio-Technician-Portfolio-to-Apply-for-Audio-Technician-Portfolio-near-you.html");
                    break;
                case 17:intent.putExtra("DESCRIPTION","Acoustic Consultant");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/acoustic_consultant_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d20_create-Backstage-Acoustic-Consultant-Portfolio-to-Apply-for-Acoustic-Consultant-Portfolio-near-you.html");
                    break;
                case 18:intent.putExtra("DESCRIPTION","Broadcast Technician");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/broadcast_technician_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d21_create-Backstage-Broadcast-Technician-Portfolio-to-Apply-for-Broadcast-Technician-Portfolio-near-you.html");
                    break;
                case 19:intent.putExtra("DESCRIPTION","Audio Researcher");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/audio_researcher_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d22_create-Backstage-Audio-Researcher-Portfolio-to-Apply-for-Audio-Researcher-Portfolio-near-you.html");
                    break;
                case 20:intent.putExtra("DESCRIPTION","Boom Operator");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/boom_operator_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d23_create-Backstage-Boom-Operator-Portfolio-to-Apply-for-Boom-Operator-Portfolio-near-you.html");
                    break;
            }
            startActivity(intent);
        }
        else if(JobName.equals("Music Job")){

            switch (position){
                case 0:intent.putExtra("DESCRIPTION","Musician");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/musician_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d25_create-Backstage-Musician-Portfolio-to-Apply-for-Musician-Portfolio-near-you.html");
                    break;
                case 1:intent.putExtra("DESCRIPTION","Instrumentalist");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/instrumentalist_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d27_Apply-for-Instrumentalist-Job-near-you-Backstage-Instrumentalist-jobs.html");
                    break;
                case 2:intent.putExtra("DESCRIPTION","Singer");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/singer_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d28_create-Backstage-Singer-Portfolio-to-Apply-for-Singer-Portfolio-near-you.html");
                    break;
                case 3:intent.putExtra("DESCRIPTION","Backup Singer");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/backup_singer_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d29_Apply-for-Backup-Singer-Job-near-you-Backstage-Backup-Singer-jobs.html");
                    break;
                case 4:intent.putExtra("DESCRIPTION","Songwriter");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/songwriter_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d30_create-Backstage-Songwriter-Portfolio-to-Apply-for-Songwriter-Portfolio-near-you.html");
                    break;
                case 5:intent.putExtra("DESCRIPTION","Composer");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/composer_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d31_create-Backstage-Composer-Portfolio-to-Apply-for-Composer-Portfolio-near-you.html");
                    break;
                case 6:intent.putExtra("DESCRIPTION","Music Producer");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/music_producer_job_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d32_create-Backstage-Music-Producer-Portfolio-to-Apply-for-Music-Producer-Portfolio-near-you.html");
                    break;
                case 7:intent.putExtra("DESCRIPTION","Recording Engineer");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/recording_engineer_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d33_create-Backstage-Recording-Engineer-Portfolio-to-Apply-for-Recording-Engineer-Portfolio-near-you.html");
                    break;
                case 8:intent.putExtra("DESCRIPTION","Music Teacher");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/music_teacher_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d34_create-Backstage-Music-Teacher-Portfolio-to-Apply-for-Music-Teacher-Portfolio-near-you.html");
                    break;
                case 9:intent.putExtra("DESCRIPTION","Studio Musician");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/studio_musician_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d35_create-Backstage-Studio-Musician-Portfolio-to-Apply-for-Studio-Musician-Portfolio-near-you.html");
                    break;
                case 10:intent.putExtra("DESCRIPTION","Music Instructor");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/music_instructor_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d36_create-Backstage-Music-Instructor-Portfolio-to-Apply-for-Music-Instructor-Portfolio-near-you.html");
                    break;
                case 11:intent.putExtra("DESCRIPTION","Music Director");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/music_director_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d37_create-Backstage-Music-Director-Portfolio-to-Apply-for-Music-Director-Portfolio-near-you.html");
                    break;
                case 12:intent.putExtra("DESCRIPTION","DJ (Disc Jockey)");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/dj_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d38_create-Backstage-DJ-(-Disc-Jockey)-Portfolio-to-Apply-for-DJ-(-Disc-Jockey)-Portfolio-near-you.html");
                    break;
                case 13:intent.putExtra("DESCRIPTION","Music Journalist");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/music_journalist_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d39_create-Backstage-Music-Journalist-Portfolio-to-Apply-for-Music-Journalist-Portfolio-near-you.html");
                    break;
                case 14:intent.putExtra("DESCRIPTION","A & R Representative");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/ar_representative_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d40_create-Backstage-A--R-Representative-Portfolio-to-Apply-for-A--R-Representative-Portfolio-near-you.html");
                    break;
                case 15:intent.putExtra("DESCRIPTION","Music Agent");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/music_agent_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d41_create-Backstage-Music-Agent-Portfolio-to-Apply-for-Music-Agent-Portfolio-near-you.html");
                    break;
                case 16:intent.putExtra("DESCRIPTION","Sound Designer");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/sound_designer_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d42_create-Backstage-Sound-Designer-Portfolio-to-Apply-for-Sound-Designer-Portfolio-near-you.html");
                    break;
                case 17:intent.putExtra("DESCRIPTION","Music Publisher");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/music_publisher_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d43_create-Backstage-Music-Publisher-Portfolio-to-Apply-for-Music-Publisher-Portfolio-near-you.html");
                    break;
                case 18:intent.putExtra("DESCRIPTION","Music Librarian");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/music_librarian_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d44_create-Backstage-Music-Librarian-Portfolio-to-Apply-for-Music-Librarian-Portfolio-near-you.html");
                    break;
                case 19:intent.putExtra("DESCRIPTION","Concert Promoter");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/concert_promoter_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d45_create-Backstage-Concert-Promoter-Portfolio-to-Apply-for-Concert-Promoter-Portfolio-near-you.html");
                    break;
                case 20:intent.putExtra("DESCRIPTION","Tour Manager");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/tour_manager_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d46_create-Backstage-Tour-Manager-Portfolio-to-Apply-for-Tour-Manager-Portfolio-near-you.html");
                    break;
                case 21:intent.putExtra("DESCRIPTION","Music Industry Executive");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/music_industry_executive_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d47_create-Backstage-Music-Industry-Executive-Portfolio-to-Apply-for-Music-Industry-Executive-Portfolio-near-you.html");
                    break;
                case 22:intent.putExtra("DESCRIPTION","Music Instruments Rental");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/music_instruments_rental_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d48_create-Backstage-music-instruments-rental-Portfolio-to-Apply-for-music-instruments-rental-Portfolio-near-you.html");
                    break;
                case 23:intent.putExtra("DESCRIPTION","Music Instruments Repair");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/music_instruments_repair_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d49_create-Backstage-Music-instruments-repair-Portfolio-to-Apply-for-Music-instruments-repair-Portfolio-near-you.html");
                    break;
                case 24:intent.putExtra("DESCRIPTION","Music Equipment Technician");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/music_equipment_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d50_create-Backstage-Music-Equipment-Technician-Portfolio-to-Apply-for-Music-Equipment-Technician-Portfolio-near-you.html");
                    break;
                case 25:intent.putExtra("DESCRIPTION","Music Event");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/music_event_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d51_create-Backstage-Music-Event-Coordinator-Portfolio-to-Apply-for-Music-Event-Coordinator-Portfolio-near-you.html");
                    break;
                case 26:intent.putExtra("DESCRIPTION","Music Streaming Specialist");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/music_streaming_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d52_create-Backstage-Music-Streaming-Specialist-Portfolio-to-Apply-for-Music-Streaming-Specialist-Portfolio-near-you.html");
                    break;
                case 27:intent.putExtra("DESCRIPTION","Music Copyright Specialist");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/music_copyright_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d53_create-Backstage-Music-Copyright-Specialist-Portfolio-to-Apply-for-Music-Copyright-Specialist-Portfolio-near-you.html");
                    break;
                case 28:intent.putExtra("DESCRIPTION","Orchestra Musician");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/orchestra_musician_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d54_create-Backstage-Orchestra-Musician-Portfolio-to-Apply-for-Orchestra-Musician-Portfolio-near-you.html");
                    break;

            }
            startActivity(intent);
        }
        else if(JobName.equals("Makeup Job")){
            switch (position){
                case 0:intent.putExtra("DESCRIPTION","Make Up Artist");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/make_up_artist_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d56_create-Backstage-Make-up-artist-Portfolio-to-Apply-for-Make-up-artist-Portfolio-near-you.html");
                    break;
                case 1:intent.putExtra("DESCRIPTION","Special Effects Makeup Artist");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/special_makeup_artist_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d57_create-Backstage-special-effects-makeup-artist-Portfolio-to-Apply-for-special-effects-makeup-artist-Portfolio-near-you.html");
                    break;
                case 2:intent.putExtra("DESCRIPTION","Beauty Consultant");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/beauty_consultant_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d58_create-Backstage-Beauty-Consultant-Portfolio-to-Apply-for-Beauty-Consultant-Portfolio-near-you.html");
                    break;
                case 3:intent.putExtra("DESCRIPTION","Makeup Department Head");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/makeup_department_head_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d59_create-Backstage-Makeup-Department-Head-Portfolio-to-Apply-for-Makeup-Department-Head-Portfolio-near-you.html");
                    break;
                case 4:intent.putExtra("DESCRIPTION","Makeup Assistant");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/makeup_assistant_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d60_create-Backstage-Makeup-Assistant-Portfolio-to-Apply-for-Makeup-Assistant-Portfolio-near-you.html");
                    break;
                case 5:intent.putExtra("DESCRIPTION","Prosthetic Technician");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/prosthetic_technician_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d61_create-Backstage-Prosthetic-Technician-Portfolio-to-Apply-for-Prosthetic-Technician-Portfolio-near-you.html");
                    break;
                case 6:intent.putExtra("DESCRIPTION","Makeup Effects Coordinator");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/makeup_effects_coordinator_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d62_create-Backstage-Makeup-Effects-Coordinator-Portfolio-to-Apply-for-Makeup-Effects-Coordinator-Portfolio-near-you.html");
                    break;
                case 7:intent.putExtra("DESCRIPTION","Body Makeup Artist");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/body_makeup_artist_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d63_create-Backstage-Body-Makeup-Artist-Portfolio-to-Apply-for-Body-Makeup-Artist-Portfolio-near-you.html");
                    break;
                case 8:intent.putExtra("DESCRIPTION","Makeup Designer");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/makeup_designer_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d64_create-Backstage-Makeup-Designer-Portfolio-to-Apply-for-Makeup-Designer-Portfolio-near-you.html");
                    break;
                case 9:intent.putExtra("DESCRIPTION","Body Painter");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/body_painter_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d65_create-Backstage-Body-Painter-Portfolio-to-Apply-for-Body-Painter-Portfolio-near-you.html");
                    break;
                case 10:intent.putExtra("DESCRIPTION","Makeup Researcher");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/makeup_researcher_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d66_create-Backstage-Makeup-Researcher-Portfolio-to-Apply-for-Makeup-Researcher-Portfolio-near-you.html");
                    break;
                case 11:intent.putExtra("DESCRIPTION","Hair Stylist");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/hair_stylist_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d67_create-Backstage-Hair-Stylist-Portfolio-to-Apply-for-Hair-Stylist-Portfolio-near-you.html");
                    break;
                case 12:intent.putExtra("DESCRIPTION","Hair And Makeup Supervisor");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/hair_and_makeup_supervisor_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d68_create-Backstage-Hair-and-Makeup-Supervisor-Portfolio-to-Apply-for-Hair-and-Makeup-Supervisor-Portfolio-near-you.html");
                    break;
                case 13:intent.putExtra("DESCRIPTION","Key Hair Stylist");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/key_hair_stylist_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d69_create-Backstage-Key-Hair-Stylist-Portfolio-to-Apply-for-Key-Hair-Stylist-Portfolio-near-you.html");
                    break;
                case 14:intent.putExtra("DESCRIPTION","Assistant Hair Stylist");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/assistant_hair_stylist_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d70_create-Backstage-Assistant-Hair-Stylist-Portfolio-to-Apply-for-Assistant-Hair-Stylist-Portfolio-near-you.html");
                    break;
                case 15:intent.putExtra("DESCRIPTION","Wig Master");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/wig_master_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d71_create-Backstage-Wig-Master-Portfolio-to-Apply-for-Wig-Master-Portfolio-near-you.html");
                    break;
                case 16:intent.putExtra("DESCRIPTION","Wig Mistress");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/wig_mistress_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d72_create-Backstage-Wig-Mistress-Portfolio-to-Apply-for-Wig-Mistress-Portfolio-near-you.html");
                    break;
                case 17:intent.putExtra("DESCRIPTION","Hair Colorist");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/hair_colorist_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d73_create-Backstage-Hair-Colorist-Portfolio-to-Apply-for-Hair-Colorist-Portfolio-near-you.html");
                    break;
                case 18:intent.putExtra("DESCRIPTION","Hair Department Coordinator");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/hair_department_coordinator_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d74_create-Backstage-Hair-Department-Coordinator-Portfolio-to-Apply-for-Hair-Department-Coordinator-Portfolio-near-you.html");
                    break;
                case 19:intent.putExtra("DESCRIPTION","Hair Stylist Consultant");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/key_hair_stylist_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d75_create-Backstage-Hair-Stylist-Consultant-Portfolio-to-Apply-for-Hair-Stylist-Consultant-Portfolio-near-you.html");
                    break;
                case 20:intent.putExtra("DESCRIPTION","On Set Stylist");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/on_set_stylist_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d76_create-Backstage-On-Set-Stylist-Portfolio-to-Apply-for-On-Set-Stylist-Portfolio-near-you.html");
                    break;
                case 21:intent.putExtra("DESCRIPTION","Hair Stylist For Special Effects");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/hair_stylist_special_effects_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d77_create-Backstage-Hair-Stylist-for-Special-Effects-Portfolio-to-Apply-for-Hair-Stylist-for-Special-Effects-Portfolio-near-you.html");
                    break;
                case 22:intent.putExtra("DESCRIPTION","Hair Stylist For Stunt Doubles");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/hair_stylist_stunt_doubles_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d78_create-Backstage-Hair-Stylist-for-Stunt-Doubles-Portfolio-to-Apply-for-Hair-Stylist-for-Stunt-Doubles-Portfolio-near-you.html");
                    break;
                case 23:intent.putExtra("DESCRIPTION","Period Hair Stylist");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/period_hair_stylist_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d79_create-Backstage-Period-Hair-Stylist-Portfolio-to-Apply-for-Period-Hair-Stylist-Portfolio-near-you.html");
                    break;
                case 24:intent.putExtra("DESCRIPTION","Key Hair Stylist");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/key_hair_stylist2_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d80_create-Backstage-Key-Hair-Stylist-Portfolio-to-Apply-for-Key-Hair-Stylist-Portfolio-near-you.html");
                    break;
                case 25:intent.putExtra("DESCRIPTION","Editorial/Photo Shoot Hair Stylist");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/editorial_hair_stylist_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d81_create-Backstage-EditorialPhoto-Shoot-Hair-Stylist-Portfolio-to-Apply-for-EditorialPhoto-Shoot-Hair-Stylist-Portfolio-near-you.html");
                    break;
                case 26:intent.putExtra("DESCRIPTION","Hair Stylist For Celebrities");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/hair_stylist_celebrities_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d82_create-Backstage-Hair-stylist-for-celebrities-Portfolio-to-Apply-for-Hair-stylist-for-celebrities-Portfolio-near-you.html");
                    break;
                case 27:intent.putExtra("DESCRIPTION","Barber");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/barber_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d83_create-Backstage-Barber-Portfolio-to-Apply-for-Barber-Portfolio-near-you.html");
                    break;
                case 28:intent.putExtra("DESCRIPTION","Crowd Makeup Artist");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/crowd_makeup_artist_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d84_create-Backstage-crowd-makeup-artist-Portfolio-to-Apply-for-crowd-makeup-artist-Portfolio-near-you.html");
                    break;
                case 29:intent.putExtra("DESCRIPTION","Contact Lens Optician");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/contact_lens_optician_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d85_create-Backstage-Contact-lens-optician-Portfolio-to-Apply-for-Contact-lens-optician-Portfolio-near-you.html");
                    break;
                case 30:intent.putExtra("DESCRIPTION","Wig Designer");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/wig_designer_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d86_create-Backstage-Wig-designer-Portfolio-to-Apply-for-Wig-designer-Portfolio-near-you.html");
                    break;
                case 31:intent.putExtra("DESCRIPTION","Wig Rental");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/wig_rental_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d89_create-Backstage-Wig-Rental-Portfolio-to-Apply-for-Wig-Rental-Portfolio-near-you.html");
                    break;
                case 32:intent.putExtra("DESCRIPTION","Tattoo Designer");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/tattoo_designer_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d88_create-Backstage-Tattoo-designer-Portfolio-to-Apply-for-Tattoo-designer-Portfolio-near-you.html");
                    break;
            }
            startActivity(intent);
        }
        else if(JobName.equals("Costume Job")){
            switch (position){

                case 0:intent.putExtra("DESCRIPTION","Costume Designer");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/costume_designer_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d91_create-Backstage-Costume-Designer-Portfolio-to-Apply-for-Costume-Designer-Portfolio-near-you.html");
                    break;
                case 1:intent.putExtra("DESCRIPTION","Costume Supervisor");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/costume_supervisor_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d92_create-Backstage-Costume-Supervisor-Portfolio-to-Apply-for-Costume-Supervisor-Portfolio-near-you.html");
                    break;
                case 2:intent.putExtra("DESCRIPTION","Costume Assistant");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/costume_assistant_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d93_create-Backstage-Costume-Assistant-Portfolio-to-Apply-for-Costume-Assistant-Portfolio-near-you.html");
                    break;
                case 3:intent.putExtra("DESCRIPTION","Costume Cutter");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/costume_cutter_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d94_create-Backstage-Costume-Cutter-Portfolio-to-Apply-for-Costume-Cutter-Portfolio-near-you.html");
                    break;
                case 4:intent.putExtra("DESCRIPTION","Costume Maker");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/costume_maker_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d95_create-Backstage-Costume-Maker-Portfolio-to-Apply-for-Costume-Maker-Portfolio-near-you.html");
                    break;
                case 5:intent.putExtra("DESCRIPTION","Costume Breakdown Artist");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/costume_breakdown_artist_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d96_create-Backstage-Costume-Breakdown-Artist-Portfolio-to-Apply-for-Costume-Breakdown-Artist-Portfolio-near-you.html");
                    break;
                case 6:intent.putExtra("DESCRIPTION","Costume Buyer");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/costume_buyer_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d97_create-Backstage-Costume-Buyer-Portfolio-to-Apply-for-Costume-Buyer-Portfolio-near-you.html");
                    break;
                case 7:intent.putExtra("DESCRIPTION","Wardrobe Supervisor");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/wardrobe_supervisor_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d98_create-Backstage-Wardrobe-Supervisor-Portfolio-to-Apply-for-Wardrobe-Supervisor-Portfolio-near-you.html");
                    break;
                case 8:intent.putExtra("DESCRIPTION","Specialty Costume Designer");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/specialty_costume_designer_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d99_create-Backstage-Specialty-Costume-Designer-Portfolio-to-Apply-for-Specialty-Costume-Designer-Portfolio-near-you.html");
                    break;
                case 9:intent.putExtra("DESCRIPTION","Costume Assistant Designer");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/costume_assistant_designer_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d100_create-Backstage-Costume-Assistant-Designer-Portfolio-to-Apply-for-Costume-Assistant-Designer-Portfolio-near-you.html");
                    break;
                case 10:intent.putExtra("DESCRIPTION","Set Costumer");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/set_costumer_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d101_create-Backstage-Set-Costumer-Portfolio-to-Apply-for-Set-Costumer-Portfolio-near-you.html");
                    break;
                case 11:intent.putExtra("DESCRIPTION","Costume Standby");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/costume_standby_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d102_create-Backstage-Costume-Standby-Portfolio-to-Apply-for-Costume-Standby-Portfolio-near-you.html");
                    break;
                case 12:intent.putExtra("DESCRIPTION","Costume Illustrator");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/costume_illustrator_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d103_create-Backstage-Costume-Illustrator-Portfolio-to-Apply-for-Costume-Illustrator-Portfolio-near-you.html");
                    break;
                case 13:intent.putExtra("DESCRIPTION","Costume Beader");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/costume_beader_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d104_create-Backstage-Costume-Beader-Portfolio-to-Apply-for-Costume-Beader-Portfolio-near-you.html");
                    break;
                case 14:intent.putExtra("DESCRIPTION","Costume Rental Manager");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/costume_rental_manager_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d105_create-Backstage-Costume-Rental-Manager-Portfolio-to-Apply-for-Costume-Rental-Manager-Portfolio-near-you.html");
                    break;
                case 15:intent.putExtra("DESCRIPTION","Dresser");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/dresser_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d106_create-Backstage-Dresser-Portfolio-to-Apply-for-Dresser-Portfolio-near-you.html");
                    break;
                case 16:intent.putExtra("DESCRIPTION","Costume Department Coordinator");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/costume_department_coordinator_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d107_create-Backstage-Costume-Department-Coordinator-Portfolio-to-Apply-for-Costume-Department-Coordinator-Portfolio-near-you.html");
                    break;
                case 17:intent.putExtra("DESCRIPTION","Costume Shop Manager");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/costume_shop_manager_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d108_create-Backstage-Costume-Shop-Manager-Portfolio-to-Apply-for-Costume-Shop-Manager-Portfolio-near-you.html");
                    break;
                case 18:intent.putExtra("DESCRIPTION","Costume Shop Assistant");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/costume_shop_assistant_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d109_create-Backstage-Costume-Shop-Assistant-Portfolio-to-Apply-for-Costume-Shop-Assistant-Portfolio-near-you.html");
                    break;
                case 19:intent.putExtra("DESCRIPTION","Costume Rental");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/costume_rental_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d110_create-Backstage-Costume-Rental-Portfolio-to-Apply-for-Costume-Rental-Portfolio-near-you.html");
                    break;
                case 20:intent.putExtra("DESCRIPTION","Costume Milliner");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/costume_milliner_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d111_create-Backstage-Costume-Milliner-(Hat-Maker)-Portfolio-to-Apply-for-Costume-Milliner-(Hat-Maker)-Portfolio-near-you.html");
                    break;
                case 21:intent.putExtra("DESCRIPTION","Costume Jewelry Maker");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/costume_jewelry_maker_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d112_create-Backstage-Costume-Jewelry-Maker-Portfolio-to-Apply-for-Costume-Jewelry-Maker-Portfolio-near-you.html");
                    break;
                case 22:intent.putExtra("DESCRIPTION","Distressing Artist");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/distressing_artist_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d113_create-Backstage-Distressing-Artist-Portfolio-to-Apply-for-Distressing-Artist-Portfolio-near-you.html");
                    break;
                case 23:intent.putExtra("DESCRIPTION","Costume Breakdown Shoemaker/Cobbler");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/costume_breakdown_shoemaker_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d114_create-Backstage-Costume-Breakdown-ShoemakerCobbler-Portfolio-to-Apply-for-Costume-Breakdown-ShoemakerCobbler-Portfolio-near-you.html");
                    break;
                case 24:intent.putExtra("DESCRIPTION","Costume Leatherworker Breakdown");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/leatherworker_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d115_create-Backstage-Costume-Breakdown-Leatherworker-Portfolio-to-Apply-for-Costume-Breakdown-Leatherworker-Portfolio-near-you.html");
                    break;
                case 25:intent.putExtra("DESCRIPTION","Costume Breakdown Textile Specialist");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/costume_breakdown_textile_specialist_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d116_create-Backstage-Costume-Breakdown-Textile-Specialist-Portfolio-to-Apply-for-Costume-Breakdown-Textile-Specialist-Portfolio-near-you.html");
                    break;
                case 26:intent.putExtra("DESCRIPTION","Costume Breakdown 3d Printer Technician");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/costume_breakdown_3d_printer_technician_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d117_create-Backstage-Costume-Breakdown-3D-Printer-Technician-Portfolio-to-Apply-for-Costume-Breakdown-3D-Printer-Technician-Portfolio-near-you.html");
                    break;
                case 27:intent.putExtra("DESCRIPTION","Costume Research Assistant");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/costume_research_assistant_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d118_create-Backstage-Costume-Research-Assistant-Portfolio-to-Apply-for-Costume-Research-Assistant-Portfolio-near-you.html");
                    break;
                case 28:intent.putExtra("DESCRIPTION","Costume Supervisor For Visual Effects");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/costume_supervisor_for_visual_effects_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d119_create-Backstage-Costume-Supervisor-for-Visual-Effects-Portfolio-to-Apply-for-Costume-Supervisor-for-Visual-Effects-Portfolio-near-you.html");
                    break;
                case 29:intent.putExtra("DESCRIPTION","Costume Photographer");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/costume_photographer_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d120_create-Backstage-Costume-Photographer-Portfolio-to-Apply-for-Costume-Photographer-Portfolio-near-you.html");
                    break;
                case 30:intent.putExtra("DESCRIPTION","Costume Consultant");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/costume_consultant_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d121_create-Backstage-Costume-Consultant-Portfolio-to-Apply-for-Costume-Consultant-Portfolio-near-you.html");
                    break;
                case 31:intent.putExtra("DESCRIPTION","Costume 3d Modeler");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/costume_3d_modeler_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d122_create-Backstage-Costume-3D-Modeler-Portfolio-to-Apply-for-Costume-3D-Modeler-Portfolio-near-you.html");
                    break;
                case 32:intent.putExtra("DESCRIPTION","Costume Embroiderer");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/costume_embroiderer_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d123_create-Backstage-Costume-Embroiderer-Portfolio-to-Apply-for-Costume-Embroiderer-Portfolio-near-you.html");
                    break;
                case 33:intent.putExtra("DESCRIPTION","Costume Warehouse Manager");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/costume_warehouse_manager_desc.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d124_create-Backstage-Costume-Warehouse-Manager-Portfolio-to-Apply-for-Costume-Warehouse-Manager-Portfolio-near-you.html");
                    break;
            }
            startActivity(intent);
        }
        else if(JobName.equals("Direction Job")){

            switch (position){
                case 0:intent.putExtra("DESCRIPTION","Director");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d126_Apply-for-Director-Job-near-you-Backstage-Director-Portfolio.html");
                    break;
                case 1:intent.putExtra("DESCRIPTION","Assistant Director (AD)");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d127_Apply-for-Assistant-Director-(AD)-Job-near-you-Backstage-Assistant-Director-(AD)-Portfolio.html");
                    break;
                case 2:intent.putExtra("DESCRIPTION","Second Assistant Director ( 2nd AD )");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d128_Apply-for-Second-Assistant-Director-(-2nd-AD-)-Job-near-you-Backstage-Second-Assistant-Director-(-2nd-AD-)-Portfolio.html");
                    break;
                case 3:intent.putExtra("DESCRIPTION","Script Supervisor");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d129_Apply-for-Script-Supervisor-Job-near-you-Backstage-Script-Supervisor-Portfolio.html");
                    break;
                case 4:intent.putExtra("DESCRIPTION","Casting Director");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d130_Apply-for-Casting-Director-Job-near-you-Backstage-Casting-Director-Portfolio.html");
                    break;
                case 5:intent.putExtra("DESCRIPTION","Production Designer");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d131_Apply-for-Production-Designer-Portfolio-near-you-Backstage-Production-Designer-Portfolio.html");
                    break;
                case 6:intent.putExtra("DESCRIPTION","Director of Photography (DP or Cinematographer");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d132_Apply-for-Director-of-Photography-(DP-or-Cinematographer-Portfolio-near-you-Backstage-Director-of-Photography-(DP-or-Cinematographer-Portfolio.html");
                    break;
                case 7:intent.putExtra("DESCRIPTION","Editor");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d133_Apply-for-Editor-Portfolio-near-you-Backstage-Editor-Portfolio.html");
                    break;
                case 8:intent.putExtra("DESCRIPTION","Production Manager");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d134_Apply-for-Production-Manager-Portfolio-near-you-Backstage-Production-Manager-Portfolio.html");
                    break;
                case 9:intent.putExtra("DESCRIPTION","Art Director");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d135_Apply-for-Art-Director-Portfolio-near-you-Backstage-Art-Director-Portfolio.html");
                    break;
                case 10:intent.putExtra("DESCRIPTION","Special Effects Supervisor");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d136_Apply-for-Special-Effects-Supervisor-Portfolio-near-you-Backstage-Special-Effects-Supervisor-Portfolio.html");
                    break;
                case 11:intent.putExtra("DESCRIPTION","Stunt Coordinator");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d137_Apply-for-Stunt-Coordinator-Portfolio-near-you-Backstage-Stunt-Coordinator-Portfolio.html");
                    break;
            }
            startActivity(intent);
        }
        else if(JobName.equals("Acting Job")){
            switch (position){
                case 0:intent.putExtra("DESCRIPTION","Actor");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d139_Apply-for-Actor-Portfolio-near-you-Backstage-Actor-Portfolio.html");
                    break;
                case 1:intent.putExtra("DESCRIPTION","Actress");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d140_Apply-for-Actress-Portfolio-near-you-Backstage-Actress-Portfolio.html");
                    break;
                case 2:intent.putExtra("DESCRIPTION","Stand-In");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d141_Apply-for-Stand-In-Portfolio-near-you-Backstage-Stand-In-Portfolio.html");
                    break;
                case 3:intent.putExtra("DESCRIPTION","Body Double");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d142_Apply-for-Body-Double-Portfolio-near-you-Backstage-Body-Double-Portfolio.html");
                    break;
                case 4:intent.putExtra("DESCRIPTION","Extras / Background Actor");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d143_Apply-for-Extras--Background-Actor-Portfolio-near-you-Backstage-Extras--Background-Actor-Portfolio.html");
                    break;
                case 5:intent.putExtra("DESCRIPTION","Talent Agent");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d144_Apply-for-Talent-Agent-Portfolio-near-you-Backstage-Talent-Agent-Portfolio.html");
                    break;
                case 6:intent.putExtra("DESCRIPTION","Acting Coach");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d145_Apply-for-Acting-Coach-Portfolio-near-you-Backstage-Acting-Coach-Portfolio.html");
                    break;
                case 7:intent.putExtra("DESCRIPTION","Casting Assistant");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d146_Apply-for-Casting-Assistant-Portfolio-near-you-Backstage-Casting-Assistant-Portfolio.html");
                    break;
                case 8:intent.putExtra("DESCRIPTION","Talent Scout");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d147_Apply-for-Talent-Scout-Portfolio-near-you-Backstage-Talent-Scout-Portfolio.html");
                    break;
                case 9:intent.putExtra("DESCRIPTION","Guest star appearance");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d148_Apply-for-Guest-star-appearance-Portfolio-near-you-Backstage-Guest-star-appearance-Portfolio.html");
                    break;

            }
            startActivity(intent);
        }
        else if(JobName.equals("Action Job")){
            switch (position){
                case 0:intent.putExtra("DESCRIPTION","Action Director");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d151_Apply-for-Action-Director-Portfolio-near-you-Backstage-Action-Director-Portfolio.html");
                    break;
                case 1:intent.putExtra("DESCRIPTION","Stunt Performer");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d152_Apply-for-Stunt-Performer-Portfolio-near-you-Backstage-Stunt-Performer-Portfolio.html");
                    break;
                case 2:intent.putExtra("DESCRIPTION","Stunt Coordinator");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d153_Apply-for-Stunt-Coordinator-Portfolio-near-you-Backstage-Stunt-Coordinator-Portfolio.html");
                    break;
                case 3:intent.putExtra("DESCRIPTION","Fight Choreographer");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d154_Apply-for-Fight-Choreographer-Portfolio-near-you-Backstage-Fight-Choreographer-Portfolio.html");
                    break;
                case 4:intent.putExtra("DESCRIPTION","Special Effects Supervisor");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d155_Apply-for-Special-Effects-Supervisor-Portfolio-near-you-Backstage-Special-Effects-Supervisor-Portfolio.html");
                    break;
                case 5:intent.putExtra("DESCRIPTION","Visual Effects Supervisor");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d156_Apply-for-Visual-Effects-Supervisor-Portfolio-near-you-Backstage-Visual-Effects-Supervisor-Portfolio.html");
                    break;
                case 6:intent.putExtra("DESCRIPTION","Action Cinematographer");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d157_Apply-for-Action-Cinematographer-Portfolio-near-you-Backstage-Action-Cinematographer-Portfolio.html");
                    break;
                case 7:intent.putExtra("DESCRIPTION","Action Camera Operator");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d158_Apply-for-Action-Camera-Operator-Portfolio-near-you-Backstage-Action-Camera-Operator-Portfolio.html");
                    break;
                case 8:intent.putExtra("DESCRIPTION","Armorer");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d160_Apply-for-Armorer-Portfolio-near-you-Backstage-Armorer-Portfolio.html");
                    break;
                case 9:intent.putExtra("DESCRIPTION","Production Designer for action / Action Art Director");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d161_Apply-for-Production-Designer-for-action--Action-Art-Director-Portfolio-near-you-Backstage-Production-Designer-for-action--Action-Art-Director-Portfolio.html");
                    break;
                case 10:intent.putExtra("DESCRIPTION","Action Sound Designer");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d162_Apply-for-Action-Sound-Designer-Portfolio-near-you-Backstage-Action-Sound-Designer-Portfolio.html");
                    break;
                case 11:intent.putExtra("DESCRIPTION","Action Scene Editor");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d163_Apply-for-Action-Scene-Editor-Portfolio-near-you-Backstage-Action-Scene-Editor-Portfolio.html");
                    break;
                case 12:intent.putExtra("DESCRIPTION","Action Gaffer");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d164_Apply-for-Action-gaffer-Portfolio-near-you-Backstage-Action-gaffer-Portfolio.html");
                    break;
            }
            startActivity(intent);
        }
        else if(JobName.equals("Dance Job")){
            switch (position){
                case 0:intent.putExtra("DESCRIPTION","Dancer");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d166_Apply-for-Dancer-Portfolio-near-you-Backstage-Dancer-Portfolio.html");
                    break;
                case 1:intent.putExtra("DESCRIPTION","Choreographer");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d167_Apply-for-Choreographer-Portfolio-near-you-Backstage-Choreographer-Portfolio.html");
                    break;
                case 2:intent.putExtra("DESCRIPTION","Dance Instructor");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d168_Apply-for-Dance-Instructor-Portfolio-near-you-Backstage-Dance-Instructor-Portfolio.html");
                    break;
                case 3:intent.putExtra("DESCRIPTION","Dance Researcher");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d169_Apply-for-Dance-Researcher-Portfolio-near-you-Backstage-Dance-Researcher-Portfolio.html");
                    break;
                case 4:intent.putExtra("DESCRIPTION","Dance Consultant");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d170_Apply-for-Dance-Consultant-Portfolio-near-you-Backstage-Dance-Consultant-Portfolio.html");
                    break;
                case 5:intent.putExtra("DESCRIPTION","Dance Program Coordinator");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d171_Apply-for-Dance-Program-Coordinator-Portfolio-near-you-Backstage-Dance-Program-Coordinator-Portfolio.html");
                    break;
                case 6:intent.putExtra("DESCRIPTION","Dance Notator");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d172_Apply-for-Dance-Notator-Portfolio-near-you-Backstage-Dance-Notator-Portfolio.html");
                    break;
                case 7:intent.putExtra("DESCRIPTION","Dance Production Manager");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d173_Apply-for-Dance-Production-Manager-Portfolio-near-you-Backstage-Dance-Production-Manager-Portfolio.html");
                    break;
                case 8:intent.putExtra("DESCRIPTION","Dance Film/Video Director");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d174_Apply-for-Dance-FilmVideo-Director-Portfolio-near-you-Backstage-Dance-FilmVideo-Director-Portfolio.html");
                    break;
                case 9:intent.putExtra("DESCRIPTION","Dance Company Manager");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d175_Apply-for-Dance-Company-Manager-Portfolio-near-you-Backstage-Dance-Company-Manager-Portfolio.html");
                    break;
                case 10:intent.putExtra("DESCRIPTION","Dance company rehearsal director");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d176_Apply-for-Dance-company-rehearsal-director-Portfolio-near-you-Backstage-Dance-company-rehearsal-director-Portfolio.html");
                    break;
                case 11:intent.putExtra("DESCRIPTION","Dance studio manager");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d177_Apply-for-Dance-studio-manager-Portfolio-near-you-Backstage-Dance-studio-manager-Portfolio.html");
                    break;
            }
            startActivity(intent);
        }
        else if(JobName.equals("Editing Job")){
            switch (position){
                case 0:intent.putExtra("DESCRIPTION","VFX Editor");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d179_Apply-for-VFX-Editor-Portfolio-near-you-Backstage-VFX-Editor-Portfolio.html");
                    break;
                case 1:intent.putExtra("DESCRIPTION","Special Effects");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d180_Apply-for-Special-Effects-Portfolio-near-you-Backstage-Special-Effects-Portfolio.html");
                    break;
                case 2:intent.putExtra("DESCRIPTION","Visual Effects Supervisor");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d181_Apply-for-Visual-Effects-Supervisor-Portfolio-near-you-Backstage-Visual-Effects-Supervisor-Portfolio.html");
                    break;
                case 3:intent.putExtra("DESCRIPTION","Digital Loader");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d182_Apply-for-Digital-Loader-Portfolio-near-you-Backstage-Digital-Loader-Portfolio.html");
                    break;
                case 4:intent.putExtra("DESCRIPTION","Assistant Director of Photography");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d183_create-Backstage-Assistant-Director-of-Photography-Portfolio-to-Apply-for-Assistant-Director-of-Photography-Portfolio-near-you.html");
                    break;
                case 5:intent.putExtra("DESCRIPTION","Assistant Editor");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d184_create-Backstage-Assistant-Editor-Portfolio-to-Apply-for-Assistant-Editor-Portfolio-near-you.html");
                    break;
                case 6:intent.putExtra("DESCRIPTION","Animator");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d185_create-Backstage-Animator-Portfolio-to-Apply-for-Animator-Portfolio-near-you.html");
                    break;
                case 7:intent.putExtra("DESCRIPTION","Dialogue Editor");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d186_create-Backstage-Dialogue-Editor-Portfolio-to-Apply-for-Dialogue-Editor-Portfolio-near-you.html");
                    break;
                case 8:intent.putExtra("DESCRIPTION","Colorist");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d187_create-Backstage-Colorist-Portfolio-to-Apply-for-Colorist-Portfolio-near-you.html");
                    break;
                case 9:intent.putExtra("DESCRIPTION","Assistant Colorist");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d188_create-Backstage-Assistant-Colorist-Portfolio-to-Apply-for-Assistant-Colorist-Portfolio-near-you.html");
                    break;
                case 10:intent.putExtra("DESCRIPTION","Title Designer");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d189_create-Backstage-Title-Designer-Portfolio-to-Apply-for-Title-Designer-Portfolio-near-you.html");
                    break;
                case 11:intent.putExtra("DESCRIPTION","Assistant Title Designer");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d190_create-Backstage-Assistant-Title-Designer-Portfolio-to-Apply-for-Assistant-Title-Designer-Portfolio-near-you.html");
                    break;
            }
            startActivity(intent);
        }
        else if(JobName.equals("Camera Production Job")){
            switch (position){
                case 0:intent.putExtra("DESCRIPTION","Camera Production Assistant");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d193_create-Backstage-Camera-Production-Assistant-Portfolio-to-Apply-for-Camera-Production-Assistant-Portfolio-near-you.html");
                    break;
                case 1:intent.putExtra("DESCRIPTION","Camera Trainee");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d194_create-Backstage-Camera-Trainee-Portfolio-to-Apply-for-Camera-Trainee-Portfolio-near-you.html");
                    break;
                case 2:intent.putExtra("DESCRIPTION","Steadicam Operator");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d195_create-Backstage-Steadicam-Operator-Portfolio-to-Apply-for-Steadicam-Operator-Portfolio-near-you.html");
                    break;
                case 3:intent.putExtra("DESCRIPTION","Camera Operator");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d196_create-Backstage-Camera-Operator-Portfolio-to-Apply-for-Camera-Operator-Portfolio-near-you.html");
                    break;
                case 4:intent.putExtra("DESCRIPTION","Data Wrangler");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d197_create-Backstage-Data-Wrangler-Portfolio-to-Apply-for-Data-Wrangler-Portfolio-near-you.html");
                    break;
                case 5:intent.putExtra("DESCRIPTION","Digital Imaging Technician");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d198_create-Backstage-Digital-Imaging-Technician-Portfolio-to-Apply-for-Digital-Imaging-Technician-Portfolio-near-you.html");
                    break;
                case 6:intent.putExtra("DESCRIPTION","Assistant Camera Operator");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d199_create-Backstage-Assistant-Camera-Operator-Portfolio-to-Apply-for-Assistant-Camera-Operator-Portfolio-near-you.html");
                    break;
                case 7:intent.putExtra("DESCRIPTION","Rigging Grip");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d200_create-Backstage-Rigging-Grip-Portfolio-to-Apply-for-Rigging-Grip-Portfolio-near-you.html");
                    break;
                case 8:intent.putExtra("DESCRIPTION","Dolly Grip");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d201_create-Backstage-Dolly-Grip-Portfolio-to-Apply-for-Dolly-Grip-Portfolio-near-you.html");
                    break;
                case 9:intent.putExtra("DESCRIPTION","Best Boy Grip");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d202_create-Backstage-Best-Boy-Grip-Portfolio-to-Apply-for-Best-Boy-Grip-Portfolio-near-you.html");
                    break;
                case 10:intent.putExtra("DESCRIPTION","Key Grip");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d203_create-Backstage-Key-Grip-Portfolio-to-Apply-for-Key-Grip-Portfolio-near-you.html");
                    break;
                case 11:intent.putExtra("DESCRIPTION","Focus Puller (1st AC)");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d204_create-Backstage-Focus-Puller-(1st-AC)-Portfolio-to-Apply-for-Focus-Puller-(1st-AC)-Portfolio-near-you.html");
                    break;
                case 12:intent.putExtra("DESCRIPTION","Drone Operator");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d205_create-Backstage-Drone-Operator-Portfolio-to-Apply-for-Drone-Operator-Portfolio-near-you.html");
                    break;
                case 13:intent.putExtra("DESCRIPTION","Production Accountant");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d206_create-Backstage-Production-Accountant-Portfolio-to-Apply-for-Production-Accountant-Portfolio-near-you.html");
                    break;
                case 14:intent.putExtra("DESCRIPTION","Assistant Production Accountant");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d207_create-Backstage-Assistant-Production-Accountant-Portfolio-to-Apply-for-Assistant-Production-Accountant-Portfolio-near-you.html");
                    break;
                case 15:intent.putExtra("DESCRIPTION","Video Assist Operator");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d208_create-Backstage-Video-Assist-Operator-Portfolio-to-Apply-for-Video-Assist-Operator-Portfolio-near-you.html");
                    break;
                case 16:intent.putExtra("DESCRIPTION","Film Loader / Clapper Loader");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d209_create-Backstage-Film-Loader--Clapper-Loader-Portfolio-to-Apply-for-Film-Loader--Clapper-Loader-Portfolio-near-you.html");
                    break;
                case 17:intent.putExtra("DESCRIPTION","Digital Asset Manager (DAM)");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d210_create-Backstage-Digital-Asset-Manager-(DAM)-Portfolio-to-Apply-for-Digital-Asset-Manager-(DAM)-Portfolio-near-you.html");
                    break;
                case 18:intent.putExtra("DESCRIPTION","Accounting Clerk");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d211_create-Backstage-Accounting-Clerk-Portfolio-to-Apply-for-Accounting-Clerk-Portfolio-near-you.html");
                    break;
                case 19:intent.putExtra("DESCRIPTION","Production Secretary");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d212_create-Backstage-Production-Secretary-Portfolio-to-Apply-for-Production-Secretary-Portfolio-near-you.html");
                    break;
                case 20:intent.putExtra("DESCRIPTION","Script Reader");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d213_create-Backstage-Script-Reader-Portfolio-to-Apply-for-Script-Reader-Portfolio-near-you.html");
                    break;
                case 21:intent.putExtra("DESCRIPTION","Quality Control Technician");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d214_create-Backstage-Quality-Control-Technician-Portfolio-to-Apply-for-Quality-Control-Technician-Portfolio-near-you.html");
                    break;
                case 22:intent.putExtra("DESCRIPTION","Previs artist");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d215_create-Backstage-Previs-artist-Portfolio-to-Apply-for-Previs-artist-Portfolio-near-you.html");
                    break;
                case 23:intent.putExtra("DESCRIPTION","Weapons Master");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d216_create-Backstage-Weapons-Master-Portfolio-to-Apply-for-Weapons-Master-Portfolio-near-you.html");
                    break;
            }
            startActivity(intent);
        }
        else if(JobName.equals("Other Job")){
            switch (position){
                case 0:intent.putExtra("DESCRIPTION","Transportation Coordinator");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d218_create-Backstage-Transportation-Coordinator-Portfolio-to-Apply-for-Transportation-Coordinator-Portfolio-near-you.html");
                    break;
                case 1:intent.putExtra("DESCRIPTION","Driver");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d219_create-Backstage-Driver-Portfolio-to-Apply-for-Driver-Portfolio-near-you.html");
                    break;
                case 2:intent.putExtra("DESCRIPTION","Construction Foreman");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d220_create-Backstage-Construction-Foreman-Portfolio-to-Apply-for-Construction-Foreman-Portfolio-near-you.html");
                    break;
                case 3:intent.putExtra("DESCRIPTION","Construction Coordinator");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d221_create-Backstage-Construction-Coordinator-Portfolio-to-Apply-for-Construction-Coordinator-Portfolio-near-you.html");
                    break;
                case 4:intent.putExtra("DESCRIPTION","Property Master");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d222_create-Backstage-Property-Master-Portfolio-to-Apply-for-Property-Master-Portfolio-near-you.html");
                    break;
                case 5:intent.putExtra("DESCRIPTION","Set Decorator");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d223_create-Backstage-Set-Decorator-Portfolio-to-Apply-for-Set-Decorator-Portfolio-near-you.html");
                    break;
                case 6:intent.putExtra("DESCRIPTION","Leadman");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d224_create-Backstage-Leadman-Portfolio-to-Apply-for-Leadman-Portfolio-near-you.html");
                    break;
                case 7:intent.putExtra("DESCRIPTION","Assistant Set Designer");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d225_create-Backstage-Assistant-Set-Designer-Portfolio-to-Apply-for-Assistant-Set-Designer-Portfolio-near-you.html");
                    break;
                case 8:intent.putExtra("DESCRIPTION","Production Secretary");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d226_create-Backstage-Production-Secretary-Portfolio-to-Apply-for-Production-Secretary-Portfolio-near-you.html");
                    break;
                case 9:intent.putExtra("DESCRIPTION","Production Coordinator");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d227_create-Backstage-Production-Coordinator-Portfolio-to-Apply-for-Production-Coordinator-Portfolio-near-you.html");
                    break;
                case 10:intent.putExtra("DESCRIPTION","Location Assistant");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d228_create-Backstage-Production-Coordinator-Portfolio-to-Apply-for-Production-Coordinator-Portfolio-near-you.html");
                    break;
                case 11:intent.putExtra("DESCRIPTION","Location Scout");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d229_create-Backstage-Location-Scout-Portfolio-to-Apply-for-Location-Scout-Portfolio-near-you.html");
                    break;
                case 12:intent.putExtra("DESCRIPTION","Assistant Location Manager");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d230_create-Backstage-Assistant-Location-Manager-Portfolio-to-Apply-for-Assistant-Location-Manager-Portfolio-near-you.html");
                    break;
                case 13:intent.putExtra("DESCRIPTION","Casting Associate");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d231_create-Backstage-Casting-Associate-Portfolio-to-Apply-for-Casting-Associate-Portfolio-near-you.html");
                    break;
                case 14:intent.putExtra("DESCRIPTION","Casting Researcher");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d232_create-Backstage-Casting-Researcher-Portfolio-to-Apply-for-Casting-Researcher-Portfolio-near-you.html");
                    break;
                case 15:intent.putExtra("DESCRIPTION","Casting Scout");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d233_create-Backstage-Casting-Scout-Portfolio-to-Apply-for-Casting-Scout-Portfolio-near-you.html");
                    break;
                case 16:intent.putExtra("DESCRIPTION","Casting Coordinator");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d234_create-Backstage-Casting-Coordinator-Portfolio-to-Apply-for-Casting-Coordinator-Portfolio-near-you.html");
                    break;
                case 17:intent.putExtra("DESCRIPTION","Casting Assistant");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d231_create-Backstage-Casting-Associate-Portfolio-to-Apply-for-Casting-Associate-Portfolio-near-you.html");
                    break;
                case 18:intent.putExtra("DESCRIPTION","Crowd Technical Director");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d236_create-Backstage-Crowd-Technical-Director-Portfolio-to-Apply-for-Crowd-Technical-Director-Portfolio-near-you.html");
                    break;
                case 19:intent.putExtra("DESCRIPTION","Digital Matte Painter");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d237_create-Backstage-Digital-Matte-Painter-Portfolio-to-Apply-for-Digital-Matte-Painter-Portfolio-near-you.html");
                    break;
                case 20:intent.putExtra("DESCRIPTION","Digital Compositor");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d238_create-Backstage-Digital-Compositor-Portfolio-to-Apply-for-Digital-Compositor-Portfolio-near-you.html");
                    break;
                case 21:intent.putExtra("DESCRIPTION","Lighting Supervisor");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d239_create-Backstage-Lighting-Supervisor-Portfolio-to-Apply-for-Lighting-Supervisor-Portfolio-near-you.html");
                    break;
                case 22:intent.putExtra("DESCRIPTION","Matchmove Supervisor");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d240_create-Backstage-Matchmove-Supervisor-Portfolio-to-Apply-for-Matchmove-Supervisor-Portfolio-near-you.html");
                    break;
                case 23:intent.putExtra("DESCRIPTION","Compositing Supervisor");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d241_create-Backstage-Compositing-Supervisor-Portfolio-to-Apply-for-Compositing-Supervisor-Portfolio-near-you.html");
                    break;
                case 24:intent.putExtra("DESCRIPTION","Render Wrangler");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d242_create-Backstage-Render-Wrangler-Portfolio-to-Apply-for-Render-Wrangler-Portfolio-near-you.html");
                    break;
                case 25:intent.putExtra("DESCRIPTION","Animal Handler");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d243_create-Backstage-Animal-Handler-Portfolio-to-Apply-for-Animal-Handler-Portfolio-near-you.html");
                    break;
                case 26:intent.putExtra("DESCRIPTION","Standby Painter");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d246_create-Backstage-Standby-Painter-Portfolio-to-Apply-for-Standby-Painter-Portfolio-near-you.html");
                    break;
                case 27:intent.putExtra("DESCRIPTION","Set Painter");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d245_create-Backstage-Set-Painter-Portfolio-to-Apply-for-Set-Painter-Portfolio-near-you.html");
                    break;
                case 28:intent.putExtra("DESCRIPTION","Standby Painter");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d246_create-Backstage-Standby-Painter-Portfolio-to-Apply-for-Standby-Painter-Portfolio-near-you.html");
                    break;
                case 29:intent.putExtra("DESCRIPTION","Leadman");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d247_create-Backstage-Leadman-Portfolio-to-Apply-for-Leadman-Portfolio-near-you.html");
                    break;
                case 30:intent.putExtra("DESCRIPTION","Scenic Carpenter");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d248_create-Backstage-Scenic-Carpenter-Portfolio-to-Apply-for-Scenic-Carpenter-Portfolio-near-you.html");
                    break;
                case 31:intent.putExtra("DESCRIPTION","Model Maker");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d249_create-Backstage-Model-Maker-Portfolio-to-Apply-for-Model-Maker-Portfolio-near-you.html");
                    break;
                case 32:intent.putExtra("DESCRIPTION","Rigger");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d250_create-Backstage-Rigger-Portfolio-to-Apply-for-Rigger-Portfolio-near-you.html");
                    break;
                case 33:intent.putExtra("DESCRIPTION","Dimmer Operator");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d251_create-Backstage-Dimmer-Operator-Portfolio-to-Apply-for-Dimmer-Operator-Portfolio-near-you.html");
                    break;
                case 34:intent.putExtra("DESCRIPTION","Rigging Electrician");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d252_create-Backstage-Rigging-Electrician-Portfolio-to-Apply-for-Rigging-Electrician-Portfolio-near-you.html");
                    break;
                case 35:intent.putExtra("DESCRIPTION","Texturing Artist");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d253_create-Backstage-Texturing-Artist-Portfolio-to-Apply-for-Texturing-Artist-Portfolio-near-you.html");
                    break;
                case 36:intent.putExtra("DESCRIPTION","Matchmover");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d254_create-Backstage-Matchmover-Portfolio-to-Apply-for-Matchmover-Portfolio-near-you.html");
                    break;
                case 37:intent.putExtra("DESCRIPTION","Aerial Coordinator");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d255_create-Backstage-Aerial-Coordinator-Portfolio-to-Apply-for-Aerial-Coordinator-Portfolio-near-you.html");
                    break;
                case 38:intent.putExtra("DESCRIPTION","Transportation Captain");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d256_create-Backstage-Transportation-Captain-Portfolio-to-Apply-for-Transportation-Captain-Portfolio-near-you.html");
                    break;
                case 39:intent.putExtra("DESCRIPTION","Pyrotechnician");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d257_create-Backstage-Pyrotechnician-Portfolio-to-Apply-for-Pyrotechnician-Portfolio-near-you.html");
                    break;
                case 40:intent.putExtra("DESCRIPTION","Animal Wrangler");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d258_create-Backstage-Animal-Wrangler-Portfolio-to-Apply-for-Animal-Wrangler-Portfolio-near-you.html");
                    break;
                case 41:intent.putExtra("DESCRIPTION","Armorer");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d259_create-Backstage-Armorer-Portfolio-to-Apply-for-Armorer-Portfolio-near-you.html");
                    break;
                case 42:intent.putExtra("DESCRIPTION","Set Decorator");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d260_create-Backstage-Set-Decorator-Portfolio-to-Apply-for-Set-Decorator-Portfolio-near-you.html");
                    break;
                case 43:intent.putExtra("DESCRIPTION","Rotoscope Artist");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d261_create-Backstage-Rotoscope-Artist-Portfolio-to-Apply-for-Rotoscope-Artist-Portfolio-near-you.html");
                    break;
                case 44:intent.putExtra("DESCRIPTION","Compositor");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d262_create-Backstage-Compositor-Portfolio-to-Apply-for-Compositor-Portfolio-near-you.html");
                    break;
                case 45:intent.putExtra("DESCRIPTION","Focus Puller");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d263_create-Backstage-Focus-Puller-Portfolio-to-Apply-for-Focus-Puller-Portfolio-near-you.html");
                    break;
                case 46:intent.putExtra("DESCRIPTION","Clapper Loader");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d264_create-Backstage-Clapper-Loader-Portfolio-to-Apply-for-Clapper-Loader-Portfolio-near-you.html");
                    break;
                case 47:intent.putExtra("DESCRIPTION","Electrician");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d265_create-Backstage-Electrician-Portfolio-to-Apply-for-Electrician-Portfolio-near-you.html");
                    break;
                case 48:intent.putExtra("DESCRIPTION","Best Boy Electric");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d266_create-Backstage-Best-Boy-Electric-Portfolio-to-Apply-for-Best-Boy-Electric-Portfolio-near-you.html");
                    break;
                case 49:intent.putExtra("DESCRIPTION","Lighting Technician");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d267_create-Backstage-Lighting-Technician-Portfolio-to-Apply-for-Lighting-Technician-Portfolio-near-you.html");
                    break;
                case 50:intent.putExtra("DESCRIPTION","Props master");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d268_create-Backstage-Props-master-Portfolio-to-Apply-for-Props-master-Portfolio-near-you.html");
                    break;
                case 51:intent.putExtra("DESCRIPTION","Animal Coordinator");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d269_create-Backstage-Animal-Coordinator-Portfolio-to-Apply-for-Animal-Coordinator-Portfolio-near-you.html");
                    break;
                case 52:intent.putExtra("DESCRIPTION","Key Scenic Artist");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d270_create-Backstage-Key-Scenic-Artist-Portfolio-to-Apply-for-Key-Scenic-Artist-Portfolio-near-you.html");
                    break;
                case 53:intent.putExtra("DESCRIPTION","Film Equipment Rental Coordinator");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d271_create-Backstage-Film-Equipment-Rental-Coordinator-Portfolio-to-Apply-for-Film-Equipment-Rental-Coordinator-Portfolio-near-you.html");
                    break;
                case 54:intent.putExtra("DESCRIPTION","Film Insurance Agent");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d272_create-Backstage-Film-Insurance-Agent-Portfolio-to-Apply-for-Film-Insurance-Agent-Portfolio-near-you.html");
                    break;
                case 55:intent.putExtra("DESCRIPTION","Film lab technician");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d273_create-Backstage-film-lab-technician-Portfolio-to-Apply-for-film-lab-technician-Portfolio-near-you.html");
                    break;
                case 56:intent.putExtra("DESCRIPTION","Set Extension Artist");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d274_create-Backstage-Set-Extension-Artist-Portfolio-to-Apply-for-Set-Extension-Artist-Portfolio-near-you.html");
                    break;
                case 57:intent.putExtra("DESCRIPTION","Set Medic");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d275_create-Backstage-Set-Medic-Portfolio-to-Apply-for-Set-Medic-Portfolio-near-you.html");
                    break;
                case 58:intent.putExtra("DESCRIPTION","Film historian");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d276_create-Backstage-Film-historian-Portfolio-to-Apply-for-Film-historian-Portfolio-near-you.html");
                    break;

            }
            startActivity(intent);
        }
        else {
            switch (position){
                case 0:intent.putExtra("DESCRIPTION","Film Festival Coordinator");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d278_create-Backstage-Film-Festival-Coordinator-Portfolio-to-Apply-for-Film-Festival-Coordinator-Portfolio-near-you.html");
                    break;
                case 1:intent.putExtra("DESCRIPTION","Film Marketing Manager");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d279_create-Backstage-Film-Marketing-Manager-Portfolio-to-Apply-for-Film-Marketing-Manager-Portfolio-near-you.html");
                    break;
                case 2:intent.putExtra("DESCRIPTION","Film Distribution Executive");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d280_create-Backstage-Film-Distribution-Executive-Portfolio-to-Apply-for-Film-Distribution-Executive-Portfolio-near-you.html");
                    break;
                case 3:intent.putExtra("DESCRIPTION","Film Sales Agent");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d281_create-Backstage-Film-Sales-Agent-Portfolio-to-Apply-for-Film-Sales-Agent-Portfolio-near-you.html");
                    break;
                case 4:intent.putExtra("DESCRIPTION","Film Publicist");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d282_create-Backstage-Film-Publicist-Portfolio-to-Apply-for-Film-Publicist-Portfolio-near-you.html");
                    break;
                case 5:intent.putExtra("DESCRIPTION","Film Projectionist");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d283_create-Backstage-Film-Projectionist-Portfolio-to-Apply-for-Film-Projectionist-Portfolio-near-you.html");
                    break;
                case 6:intent.putExtra("DESCRIPTION","Film Rights Acquisitions Executive");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d284_create-Backstage-Film-Rights-Acquisitions-Executive-Portfolio-to-Apply-for-Film-Rights-Acquisitions-Executive-Portfolio-near-you.html");
                    break;
                case 7:intent.putExtra("DESCRIPTION","Film Stock Supplier");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d285_create-Backstage-Film-Stock-Supplier-Portfolio-to-Apply-for-Film-Stock-Supplier-Portfolio-near-you.html");
                    break;
                case 8:intent.putExtra("DESCRIPTION","Delivery Coordinator");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d286_create-Backstage-Delivery-Coordinator-Portfolio-to-Apply-for-Delivery-Coordinator-Portfolio-near-you.html");
                    break;
                case 9:intent.putExtra("DESCRIPTION","Trailer Editor");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d287_create-Backstage-Trailer-Editor-Portfolio-to-Apply-for-Trailer-Editor-Portfolio-near-you.html");
                    break;
                case 10:intent.putExtra("DESCRIPTION","Film Distributor");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d288_create-Backstage-Film-Distributor-Portfolio-to-Apply-for-Film-Distributor-Portfolio-near-you.html");
                    break;
                case 11:intent.putExtra("DESCRIPTION","Film Sales Agent");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d289_create-Backstage-Film-Sales-Agent-Portfolio-to-Apply-for-Film-Sales-Agent-Portfolio-near-you.html");
                    break;
                case 12:intent.putExtra("DESCRIPTION","Media Manager");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d290_create-Backstage-Media-Manager-Portfolio-to-Apply-for-Media-Manager-Portfolio-near-you.html");
                    break;
                case 13:intent.putExtra("DESCRIPTION","Marketing and Publicity Coordinator");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d291_create-Backstage-Marketing-and-Publicity-Coordinator-Portfolio-to-Apply-for-Marketing-and-Publicity-Coordinator-Portfolio-near-you.html");
                    break;
                case 14:intent.putExtra("DESCRIPTION","Public Relations Assistant");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d292_create-Backstage-Public-Relations-Assistant-Portfolio-to-Apply-for-Public-Relations-Assistant-Portfolio-near-you.html");
                    break;
                case 15:intent.putExtra("DESCRIPTION","Social Media Assistant");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    intent.putExtra("PortfolioLink","https://www.a2zportfolio.com/contents/en-us/d293_create-Backstage-Social-Media-Assistant-Portfolio-to-Apply-for-Social-Media-Assistant-Portfolio-near-you.html");
                    break;
            }
            startActivity(intent);
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
}