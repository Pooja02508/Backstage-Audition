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

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import casting.movie.audition.activities.ChatbotActivity;
import casting.movie.audition.activities.WebViewActivity;
import casting.movie.audition.fragments.AuditionsFragment;
import casting.movie.audition.fragments.BackstageJobsFragment;
import casting.movie.audition.fragments.DashboardFragment;
import casting.movie.audition.fragments.HomeFragment;
import casting.movie.audition.fragments.ProfileFragment;
import casting.movie.audition.R;
import casting.movie.audition.models.AuditionAdapter;
import casting.movie.audition.models.Auditions;
import pl.droidsonroids.gif.GifImageView;

public class VoiceOverJobs extends AppCompatActivity implements AuditionAdapter.ItemClickListener{

  
    RecyclerView recyclerView;
    ArrayList<Auditions> auditionsArrayList=new ArrayList<>();
    ImageView portfolioImg,clickImg,backstage_icon,santa_img;
    GifImageView fab,live_chat;
    LinearLayout register_now,create_profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voice_over_jobs);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView=findViewById(R.id.recyclerView);
        fab = findViewById(R.id.fab);
        live_chat=findViewById(R.id.live_chat);
//        portfolioImg=findViewById(R.id.portfolioImg);
//        clickImg=findViewById(R.id.clickImg);
        backstage_icon=findViewById(R.id.backstage_icon);
        santa_img=findViewById(R.id.santa_img);

       register_now=findViewById(R.id.register_now);
       create_profile=findViewById(R.id.create_profile);

//        Picasso.with(this).load("https://images.backstageaudition.com/talent_img.png").fit().into(portfolioImg);
//        Picasso.with(this).load("https://images.backstageaudition.com/click_img.png").fit().into(clickImg);
       // Glide.with(this).load("https://images.backstageaudition.com/chat_gif.gif").into(fab);
        Picasso.with(this).load("https://images.backstageaudition.com/backstage_new1.png").fit().into(backstage_icon);
        Picasso.with(this).load("https://images.backstageaudition.com/backstage_new2.png").fit().into(santa_img);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav_view);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();

        register_now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), WebViewActivity.class);
                intent.putExtra("Link","https://backstageaudition.com/contents/en-us/p1181_Backstage-Profile-Create-Your-Casting-Profile.html");
                startActivity(intent);
//                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://backstageaudition.com/contents/en-us/p1181_Backstage-Profile-Create-Your-Casting-Profile.html")));
            }
        });
        create_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), WebViewActivity.class);
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
       

        String JobTitle=getIntent().getStringExtra("Job Title");

        if(JobTitle.equals("Voice Job")){
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
        }
        else if(JobTitle.equals("Music Job")){

            auditionsArrayList.add(new Auditions("Musician Jobs","https://images.backstageaudition.com/musician.png"));
            auditionsArrayList.add(new Auditions("Instrumentalist Jobs","https://images.backstageaudition.com/instrumentalist.png"));
            auditionsArrayList.add(new Auditions("Singer Jobs","https://images.backstageaudition.com/singer.png"));
            auditionsArrayList.add(new Auditions("Backup Singer Jobs","https://images.backstageaudition.com/backup_singer.png"));
            auditionsArrayList.add(new Auditions("Songwriter Jobs","https://images.backstageaudition.com/songwriter.png"));
            auditionsArrayList.add(new Auditions("Composer Jobs","https://images.backstageaudition.com/composer_job.png"));
            auditionsArrayList.add(new Auditions("Music Producer Jobs","https://images.backstageaudition.com/music_producer_job.png"));
            auditionsArrayList.add(new Auditions("Recording Engineer Jobs","https://images.backstageaudition.com/recording_engineer.png"));
            auditionsArrayList.add(new Auditions("Music Teacher Jobs","https://images.backstageaudition.com/music_teacher.png"));
            auditionsArrayList.add(new Auditions("Studio Musician Jobs","https://images.backstageaudition.com/studio_musician.png"));
            auditionsArrayList.add(new Auditions("Music Instructor Jobs","https://images.backstageaudition.com/music_instructor.png"));
            auditionsArrayList.add(new Auditions("Music Director Jobs","https://images.backstageaudition.com/music_director.png"));
            auditionsArrayList.add(new Auditions("DJ ( Disc Jockey) Jobs","https://images.backstageaudition.com/dj.png"));
            auditionsArrayList.add(new Auditions("Music Journalist Jobs","https://images.backstageaudition.com/music_journalist.png"));
            auditionsArrayList.add(new Auditions("A & R Representative Jobs","https://images.backstageaudition.com/ar_representative.png"));
            auditionsArrayList.add(new Auditions("Music Agent Jobs","https://images.backstageaudition.com/music_agent.png"));
            auditionsArrayList.add(new Auditions("Sound Designer Jobs","https://images.backstageaudition.com/sound_designer_music.png"));
            auditionsArrayList.add(new Auditions("Music Publisher Jobs","https://images.backstageaudition.com/music_publisher.png"));
            auditionsArrayList.add(new Auditions("Music Librarian Jobs","https://images.backstageaudition.com/music_librarian.png"));
            auditionsArrayList.add(new Auditions("Concert Promoter Jobs","https://images.backstageaudition.com/concert_promoter.png"));
            auditionsArrayList.add(new Auditions("Tour Manager Jobs","https://images.backstageaudition.com/tour_manager.png"));
            auditionsArrayList.add(new Auditions("Music Industry Executive Jobs","https://images.backstageaudition.com/music_industry_executive.png"));
            auditionsArrayList.add(new Auditions("Music Instruments Rental Jobs","https://images.backstageaudition.com/music_instruments_rental.png"));
            auditionsArrayList.add(new Auditions("Music Instruments Repair Jobs","https://images.backstageaudition.com/music_instruments_repair.png"));
            auditionsArrayList.add(new Auditions("Music Equipment Technician Jobs","https://images.backstageaudition.com/music_equipment_technician.png"));
            auditionsArrayList.add(new Auditions("Music Event Coordinator Jobs","https://images.backstageaudition.com/music_event_coordinator.png"));
            auditionsArrayList.add(new Auditions("Music Streaming Specialist Jobs","https://images.backstageaudition.com/music_streaming_specialist.png"));
            auditionsArrayList.add(new Auditions("Music Copyright Specialist Jobs","https://images.backstageaudition.com/music_copyright_specialist.png"));
            auditionsArrayList.add(new Auditions("Orchestra Musician Jobs","https://images.backstageaudition.com/orchestra_musician.png"));
        }
        else if(JobTitle.equals("Makeup Job")){

            auditionsArrayList.add(new Auditions("Make-up artist Jobs","https://images.backstageaudition.com/make_up_artist.png"));
            auditionsArrayList.add(new Auditions("Special effects makeup artist Jobs","https://images.backstageaudition.com/special_makeup_artist.png"));
            auditionsArrayList.add(new Auditions("Beauty Consultant Jobs","https://images.backstageaudition.com/beauty_consultant.png"));
            auditionsArrayList.add(new Auditions("Makeup Department Head Jobs","https://images.backstageaudition.com/makeup_department_head.png"));
            auditionsArrayList.add(new Auditions("Makeup Assistant Jobs","https://images.backstageaudition.com/makeup_assistant.png"));
            auditionsArrayList.add(new Auditions("Prosthetic Technician Jobs","https://images.backstageaudition.com/prosthetic_technician.png"));
            auditionsArrayList.add(new Auditions("Makeup Effects Coordinator Jobs","https://images.backstageaudition.com/makeup_effects_coordinator.png"));
            auditionsArrayList.add(new Auditions("Body Makeup Artist Jobs","https://images.backstageaudition.com/body_makeup_artist.png"));
            auditionsArrayList.add(new Auditions("Makeup Designer Jobs","https://images.backstageaudition.com/makeup_designer.png"));
            auditionsArrayList.add(new Auditions("Body Painter Jobs","https://images.backstageaudition.com/body_painter.png"));
            auditionsArrayList.add(new Auditions("Makeup Researcher Jobs","https://images.backstageaudition.com/makeup_researcher.png"));
            auditionsArrayList.add(new Auditions("Hair Stylist Jobs","https://images.backstageaudition.com/hair_stylist.png"));
            auditionsArrayList.add(new Auditions("Hair and Makeup Supervisor Jobs","https://images.backstageaudition.com/hair_and_makeup_supervisor.png"));
            auditionsArrayList.add(new Auditions("Key Hair Stylist Jobs","https://images.backstageaudition.com/key_hair_stylist.png"));
            auditionsArrayList.add(new Auditions("Assistant Hair Stylist Jobs","https://images.backstageaudition.com/assistant_hair_stylist.png"));
            auditionsArrayList.add(new Auditions("Wig Master Jobs","https://images.backstageaudition.com/wig_master.png"));
            auditionsArrayList.add(new Auditions("Wig Mistress Jobs","https://images.backstageaudition.com/wig_mistress.png"));
            auditionsArrayList.add(new Auditions("Hair Colorist Jobs","https://images.backstageaudition.com/hair_colorist.png"));
            auditionsArrayList.add(new Auditions("Hair Department Coordinator Jobs","https://images.backstageaudition.com/hair_department_coordinator.png"));
            auditionsArrayList.add(new Auditions("Hair Stylist Consultant Jobs","https://images.backstageaudition.com/key_hair_stylist.png"));
            auditionsArrayList.add(new Auditions("On-Set Stylist Jobs","https://images.backstageaudition.com/on_set_stylist.png"));
            auditionsArrayList.add(new Auditions("Hair Stylist for Special Effects Jobs","https://images.backstageaudition.com/hair_stylist_special_effects.png"));
            auditionsArrayList.add(new Auditions("Hair Stylist for Stunt Doubles Jobs","https://images.backstageaudition.com/hair_stylist_stunt_doubles.png"));
            auditionsArrayList.add(new Auditions("Period Hair Stylist Jobs","https://images.backstageaudition.com/period_hair_stylist.png"));
            auditionsArrayList.add(new Auditions("Key Hair Stylist Jobs","https://images.backstageaudition.com/key_hair_stylist2.png"));
            auditionsArrayList.add(new Auditions("Editorial/Photo Shoot Hair Stylist Jobs","https://images.backstageaudition.com/editorial_hair_stylist.png"));
            auditionsArrayList.add(new Auditions("Hair stylist for celebrities Jobs","https://images.backstageaudition.com/hair_stylist_celebrities.png"));
            auditionsArrayList.add(new Auditions("Barber Jobs","https://images.backstageaudition.com/barber.png"));
            auditionsArrayList.add(new Auditions("Crowd makeup artist Jobs","https://images.backstageaudition.com/crowd_makeup_artist.png"));
            auditionsArrayList.add(new Auditions("Contact lens optician Jobs","https://images.backstageaudition.com/contact_lens_optician.png"));
            auditionsArrayList.add(new Auditions("Wig designer Jobs","https://images.backstageaudition.com/wig_designer.png"));
            auditionsArrayList.add(new Auditions("Wig Rental Jobs","https://images.backstageaudition.com/wig_rental.png"));
            auditionsArrayList.add(new Auditions("Tattoo designer Jobs","https://images.backstageaudition.com/tattoo_designer.png"));
        }
        else if(JobTitle.equals("Costume Job")){
            auditionsArrayList.add(new Auditions("Costume Designer Jobs","https://images.backstageaudition.com/costume_designer_job.png"));
            auditionsArrayList.add(new Auditions("Costume Supervisor Jobs","https://images.backstageaudition.com/costume_supervisor.png"));
            auditionsArrayList.add(new Auditions("Costume Assistant Jobs","https://images.backstageaudition.com/costume_assistant.png"));
            auditionsArrayList.add(new Auditions("Costume Cutter Jobs","https://images.backstageaudition.com/costume_cutter.png"));
            auditionsArrayList.add(new Auditions("Costume Maker Jobs","https://images.backstageaudition.com/costume_maker.png"));
            auditionsArrayList.add(new Auditions("Costume Breakdown Artist Jobs","https://images.backstageaudition.com/costume_breakdown_artist.png"));
            auditionsArrayList.add(new Auditions("Costume Buyer Jobs","https://images.backstageaudition.com/costume_buyer.png"));
            auditionsArrayList.add(new Auditions("Wardrobe Supervisor Jobs","https://images.backstageaudition.com/wardrobe_supervisor.png"));
            auditionsArrayList.add(new Auditions("Specialty Costume Designer Jobs","https://images.backstageaudition.com/specialty_costume_designer.png"));
            auditionsArrayList.add(new Auditions("Costume Assistant Designer Jobs","https://images.backstageaudition.com/costume_assistant_designer.png"));
            auditionsArrayList.add(new Auditions("Set Costumer Jobs","https://images.backstageaudition.com/set_costumer.png"));
            auditionsArrayList.add(new Auditions("Costume Standby Jobs","https://images.backstageaudition.com/costume_standby.png"));
            auditionsArrayList.add(new Auditions("Costume Illustrator Jobs","https://images.backstageaudition.com/costume_illustrator.png"));
            auditionsArrayList.add(new Auditions("Costume Beader Jobs","https://images.backstageaudition.com/costume_beader.png"));
            auditionsArrayList.add(new Auditions("Costume Rental Manager Jobs","https://images.backstageaudition.com/costume_rental_manager.png"));
            auditionsArrayList.add(new Auditions("Dresser Jobs","https://images.backstageaudition.com/dresser.png"));
            auditionsArrayList.add(new Auditions("Costume Department Coordinator Jobs","https://images.backstageaudition.com/costume_department_coordinator.png"));
            auditionsArrayList.add(new Auditions("Costume Shop Manager Jobs","https://images.backstageaudition.com/costume_shop_manager.png"));
            auditionsArrayList.add(new Auditions("Costume Shop Assistant Jobs","https://images.backstageaudition.com/costume_shop_assistant.png"));
            auditionsArrayList.add(new Auditions("Costume Rental Jobs","https://images.backstageaudition.com/costume_rental.png"));
            auditionsArrayList.add(new Auditions("Costume Milliner (Hat Maker) Jobs","https://images.backstageaudition.com/costume_milliner.png"));
            auditionsArrayList.add(new Auditions("Costume Jewelry Maker Jobs","https://images.backstageaudition.com/costume_jewelry_maker.png"));
            auditionsArrayList.add(new Auditions("Distressing Artist Jobs","https://images.backstageaudition.com/distressing_artist.png"));
            auditionsArrayList.add(new Auditions("Costume Breakdown Shoemaker/Cobbler Jobs","https://images.backstageaudition.com/costume_breakdown_shoemaker.png"));
            auditionsArrayList.add(new Auditions("Costume Breakdown Leatherworker Jobs","https://images.backstageaudition.com/leatherworker.png"));
            auditionsArrayList.add(new Auditions("Costume Breakdown Textile Specialist Jobs","https://images.backstageaudition.com/costume_breakdown_textile_specialist.png"));
            auditionsArrayList.add(new Auditions("Costume Breakdown 3D Printer Technician Jobs","https://images.backstageaudition.com/costume_breakdown_3d_printer_technician.png"));
            auditionsArrayList.add(new Auditions("Costume Research Assistant Jobs","https://images.backstageaudition.com/costume_research_assistant.png"));
            auditionsArrayList.add(new Auditions("Costume Supervisor for Visual Effects Jobs","https://images.backstageaudition.com/costume_supervisor_for_visual_effects.png"));
            auditionsArrayList.add(new Auditions("Costume Photographer Jobs","https://images.backstageaudition.com/costume_photographer.png"));
            auditionsArrayList.add(new Auditions("Costume Consultant Jobs","https://images.backstageaudition.com/costume_consultant.png"));
            auditionsArrayList.add(new Auditions("Costume 3D Modeler Jobs","https://images.backstageaudition.com/costume_3d_modeler.png"));
            auditionsArrayList.add(new Auditions("Costume Embroiderer Jobs","https://images.backstageaudition.com/costume_embroiderer.png"));
            auditionsArrayList.add(new Auditions("Costume Warehouse Manager Jobs","https://images.backstageaudition.com/costume_warehouse_manager.png"));
        }
        else if(JobTitle.equals("Direction Job")){

            auditionsArrayList.add(new Auditions("Director Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Assistant Director (AD) Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Second Assistant Director ( 2nd AD ) Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Script Supervisor Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Casting Director Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Production Designer Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Director of Photography (DP or Cinematographer Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Editor Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Production Manager Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Art Director Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Special Effects Supervisor Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Stunt Coordinator Jobs","https://images.backstageaudition.com/find_job.png"));

        }
        else if(JobTitle.equals("Acting Job")){
            auditionsArrayList.add(new Auditions("Actor Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Actress Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Stand-In Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Body Double Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Extras / Background Actor Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Talent Agent Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Acting Coach Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Casting Assistant Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Talent Scout Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Guest star appearance Jobs","https://images.backstageaudition.com/find_job.png"));

        }
        else if(JobTitle.equals("Action Job")){
            auditionsArrayList.add(new Auditions("Action Director Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Stunt Performer Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Stunt Coordinator Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Fight Choreographer Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Special Effects Supervisor Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Visual Effects Supervisor Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Action Cinematographer Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Action Camera Operator Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Armorer Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Production Designer for action / Action Art Director Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Action Sound Designer Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Action Scene Editor Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Action Gaffer Jobs","https://images.backstageaudition.com/find_job.png"));

        }
        else if(JobTitle.equals("Dance Job")){
            auditionsArrayList.add(new Auditions("Dancer Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Choreographer Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Dance Instructor Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Dance Researcher Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Dance Consultant Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Dance Program Coordinator Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Dance Notator Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Dance Production Manager Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Dance Film/Video Director Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Dance Company Manager Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Dance company rehearsal director Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Dance studio manager Jobs","https://images.backstageaudition.com/find_job.png"));
        }
        else if(JobTitle.equals("Editing Job")){
            auditionsArrayList.add(new Auditions("VFX Editor Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Special Effects Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Visual Effects Supervisor Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Digital Loader Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Assistant Director of Photography Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Assistant Editor Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Animator Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Dialogue Editor Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Colorist Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Assistant Colorist Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Title Designer Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Assistant Title Designer Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Previsualization (Previz) Artist Jobs","https://images.backstageaudition.com/find_job.png"));

        }
        else if(JobTitle.equals("Camera Production Job")){
            auditionsArrayList.add(new Auditions("Camera Production Assistant Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Camera Trainee Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Steadicam Operator Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Camera Operator Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Data Wrangler Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Digital Imaging Technician Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Assistant Camera Operator Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Rigging Grip Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Dolly Grip Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Best Boy Grip Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Key Grip Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Focus Puller (1st AC) Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Drone Operator Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Production Accountant Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Assistant Production Accountant Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Video Assist Operator Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Film Loader / Clapper Loader Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Digital Asset Manager (DAM) Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Accounting Clerk Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Production Secretary Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Script Reader Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Quality Control Technician Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Previs artist Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Weapons Master Jobs","https://images.backstageaudition.com/find_job.png"));
        }
        else if(JobTitle.equals("Other Job")){
            auditionsArrayList.add(new Auditions("Transportation Coordinator Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Driver Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Construction Foreman Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Construction Coordinator Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Property Master Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Set Decorator Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Leadman Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Assistant Set Designer Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Production Secretary Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Production Coordinator Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Location Assistant Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Location Scout Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Assistant Location Manager Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Casting Associate Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Casting Researcher Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Casting Scout Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Casting Coordinator Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Casting Assistant Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Crowd Technical Director Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Digital Matte Painter Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Digital Compositor Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Lighting Supervisor Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Matchmove Supervisor Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Compositing Supervisor Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Render Wrangler Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Animal Handler Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Standby Painter Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Set Painter Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Standby Painter Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Leadman Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Scenic Carpenter Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Model Maker Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Rigger Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Dimmer Operator Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Rigging Electrician Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Texturing Artist Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Matchmover Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Aerial Coordinator Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Transportation Captain Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Pyrotechnician Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Animal Wrangler Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Armorer Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Set Decorator Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Rotoscope Artist Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Compositor Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Focus Puller Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Clapper Loader Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Electrician Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Best Boy Electric Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Lighting Technician Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Props master Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Animal Coordinator Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Key Scenic Artist Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Film Equipment Rental Coordinator Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Film Insurance Agent Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Film lab technician Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Set Extension Artist Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Set Medic Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Film historian Jobs","https://images.backstageaudition.com/find_job.png"));
        }
        else {
            auditionsArrayList.add(new Auditions("Film Festival Coordinator Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Film Marketing Manager Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Film Distribution Executive Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Film Sales Agent Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Film Publicist Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Film Projectionist Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Film Rights Acquisitions Executive Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Film Stock Supplier Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Delivery Coordinator Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Trailer Editor Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Film Distributor Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Media Manager Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Marketing and Publicity Coordinator Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Public Relations Assistant Jobs","https://images.backstageaudition.com/find_job.png"));
            auditionsArrayList.add(new Auditions("Social Media Assistant Jobs","https://images.backstageaudition.com/find_job.png"));
        }


        int numberOfColumns = 2;
        recyclerView.setLayoutManager(new GridLayoutManager(this, numberOfColumns));
        AuditionAdapter adapter = new AuditionAdapter(this,auditionsArrayList);
        recyclerView.setAdapter(adapter);
        adapter.setClickListener(this);

       //        MobileAds.initialize(this, getString(R.string.ADMOB_ADS_UNIT_ID));
//
//        AdLoader.Builder builder = new AdLoader.Builder(this, getString(R.string.ADMOB_ADS_UNIT_ID));
//        builder.forUnifiedNativeAd(new UnifiedNativeAd.OnUnifiedNativeAdLoadedListener() {
//            @Override
//            public void onUnifiedNativeAdLoaded(UnifiedNativeAd unifiedNativeAd) {
//                if (nativeAd != null) {
//                    nativeAd.destroy();
//                }
//                nativeAd = unifiedNativeAd;
//                FrameLayout frameLayout =findViewById(R.id.fl_adplaceholder);
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
    }

    @Override
    public void onItemClick(View view, int position) {

        Intent intent=new Intent(this, JobsDescription.class);
        String JobName=getIntent().getStringExtra("Job Title");

        if(JobName.equals("Voice Job")){
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
        else if(JobName.equals("Music Job")){

            switch (position){
                case 0:intent.putExtra("DESCRIPTION","Musician");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/musician_desc.png");
                    break;
                case 1:intent.putExtra("DESCRIPTION","Instrumentalist");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/instrumentalist_desc.png");
                    break;
                case 2:intent.putExtra("DESCRIPTION","Singer");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/singer_desc.png");
                    break;
                case 3:intent.putExtra("DESCRIPTION","Backup Singer");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/backup_singer_desc.png");
                    break;
                case 4:intent.putExtra("DESCRIPTION","Songwriter");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/songwriter_desc.png");
                    break;
                case 5:intent.putExtra("DESCRIPTION","Composer");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/composer_desc.png");
                    break;
                case 6:intent.putExtra("DESCRIPTION","Music Producer");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/music_producer_job_desc.png");
                    break;
                case 7:intent.putExtra("DESCRIPTION","Recording Engineer");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/recording_engineer_desc.png");
                    break;
                case 8:intent.putExtra("DESCRIPTION","Music Teacher");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/music_teacher_desc.png");
                    break;
                case 9:intent.putExtra("DESCRIPTION","Studio Musician");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/studio_musician_desc.png");
                    break;
                case 10:intent.putExtra("DESCRIPTION","Music Instructor");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/music_instructor_desc.png");
                    break;
                case 11:intent.putExtra("DESCRIPTION","Music Director");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/music_director_desc.png");
                    break;
                case 12:intent.putExtra("DESCRIPTION","DJ (Disc Jockey)");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/dj_desc.png");
                    break;
                case 13:intent.putExtra("DESCRIPTION","Music Journalist");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/music_journalist_desc.png");
                    break;
                case 14:intent.putExtra("DESCRIPTION","A & R Representative");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/ar_representative_desc.png");
                    break;
                case 15:intent.putExtra("DESCRIPTION","Music Agent");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/music_agent_desc.png");
                    break;
                case 16:intent.putExtra("DESCRIPTION","Sound Designer");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/sound_designer_desc.png");
                    break;
                case 17:intent.putExtra("DESCRIPTION","Music Publisher");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/music_publisher_desc.png");
                    break;
                case 18:intent.putExtra("DESCRIPTION","Music Librarian");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/music_librarian_desc.png");
                    break;
                case 19:intent.putExtra("DESCRIPTION","Concert Promoter");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/concert_promoter_desc.png");
                    break;
                case 20:intent.putExtra("DESCRIPTION","Tour Manager");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/tour_manager_desc.png");
                    break;
                case 21:intent.putExtra("DESCRIPTION","Music Industry Executive");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/music_industry_executive_desc.png");
                    break;
                case 22:intent.putExtra("DESCRIPTION","Music Instruments Rental");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/music_instruments_rental_desc.png");
                    break;
                case 23:intent.putExtra("DESCRIPTION","Music Instruments Repair");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/music_instruments_repair_desc.png");
                    break;
                case 24:intent.putExtra("DESCRIPTION","Music Equipment");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/music_equipment_desc.png");
                    break;
                case 25:intent.putExtra("DESCRIPTION","Music Event");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/music_event_desc.png");
                    break;
                case 26:intent.putExtra("DESCRIPTION","Music Streaming");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/music_streaming_desc.png");
                    break;
                case 27:intent.putExtra("DESCRIPTION","Music Copyright");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/music_copyright_desc.png");
                    break;
                case 28:intent.putExtra("DESCRIPTION","Orchestra Musician");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/orchestra_musician_desc.png");
                    break;

            }
            startActivity(intent);
        }
        else if(JobName.equals("Makeup Job")){
            switch (position){
                case 0:intent.putExtra("DESCRIPTION","Make Up Artist");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/make_up_artist_desc.png");
                    break;
                case 1:intent.putExtra("DESCRIPTION","Special Effects Makeup Artist");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/special_makeup_artist_desc.png");
                    break;
                case 2:intent.putExtra("DESCRIPTION","Beauty Consultant");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/beauty_consultant_desc.png");
                    break;
                case 3:intent.putExtra("DESCRIPTION","Makeup Department Head");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/makeup_department_head_desc.png");
                    break;
                case 4:intent.putExtra("DESCRIPTION","Makeup Assistant");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/makeup_assistant_desc.png");
                    break;
                case 5:intent.putExtra("DESCRIPTION","Prosthetic Technician");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/prosthetic_technician_desc.png");
                    break;
                case 6:intent.putExtra("DESCRIPTION","Makeup Effects Coordinator");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/makeup_effects_coordinator_desc.png");
                    break;
                case 7:intent.putExtra("DESCRIPTION","Body Makeup Artist");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/body_makeup_artist_desc.png");
                    break;
                case 8:intent.putExtra("DESCRIPTION","Makeup Designer");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/makeup_designer_desc.png");
                    break;
                case 9:intent.putExtra("DESCRIPTION","Body Painter");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/body_painter_desc.png");
                    break;
                case 10:intent.putExtra("DESCRIPTION","Makeup Researcher");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/makeup_researcher_desc.png");
                    break;
                case 11:intent.putExtra("DESCRIPTION","Hair Stylist");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/hair_stylist_desc.png");
                    break;
                case 12:intent.putExtra("DESCRIPTION","Hair And Makeup Supervisor");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/hair_and_makeup_supervisor_desc.png");
                    break;
                case 13:intent.putExtra("DESCRIPTION","Key Hair Stylist");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/key_hair_stylist_desc.png");
                    break;
                case 14:intent.putExtra("DESCRIPTION","Assistant Hair Stylist");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/assistant_hair_stylist_desc.png");
                    break;
                case 15:intent.putExtra("DESCRIPTION","Wig Master");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/wig_master_desc.png");
                    break;
                case 16:intent.putExtra("DESCRIPTION","Wig Mistress");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/wig_mistress_desc.png");
                    break;
                case 17:intent.putExtra("DESCRIPTION","Hair Colorist");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/hair_colorist_desc.png");
                    break;
                case 18:intent.putExtra("DESCRIPTION","Hair Department Coordinator");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/hair_department_coordinator_desc.png");
                    break;
                case 19:intent.putExtra("DESCRIPTION","Hair Stylist Consultant");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/key_hair_stylist_desc.png");
                    break;
                case 20:intent.putExtra("DESCRIPTION","On Set Stylist");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/on_set_stylist_desc.png");
                    break;
                case 21:intent.putExtra("DESCRIPTION","Hair Stylist For Special Effects");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/hair_stylist_special_effects_desc.png");
                    break;
                case 22:intent.putExtra("DESCRIPTION","Hair Stylist For Stunt Doubles");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/hair_stylist_stunt_doubles_desc.png");
                    break;
                case 23:intent.putExtra("DESCRIPTION","Period Hair Stylist");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/period_hair_stylist_desc.png");
                    break;
                case 24:intent.putExtra("DESCRIPTION","Key Hair Stylist");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/key_hair_stylist2_desc.png");
                    break;
                case 25:intent.putExtra("DESCRIPTION","Editorial/Photo Shoot Hair Stylist");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/editorial_hair_stylist_desc.png");
                    break;
                case 26:intent.putExtra("DESCRIPTION","Hair Stylist");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/hair_stylist_celebrities_desc.png");
                    break;
                case 27:intent.putExtra("DESCRIPTION","Barber");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/barber_desc.png");
                    break;
                case 28:intent.putExtra("DESCRIPTION","Crowd Makeup Artist");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/crowd_makeup_artist_desc.png");
                    break;
                case 29:intent.putExtra("DESCRIPTION","Contact Lens Optician");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/contact_lens_optician_desc.png");
                    break;
                case 30:intent.putExtra("DESCRIPTION","Wig Designer");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/wig_designer_desc.png");
                    break;
                case 31:intent.putExtra("DESCRIPTION","Wig Rental");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/wig_rental_desc.png");
                    break;
                case 32:intent.putExtra("DESCRIPTION","Tattoo Designer");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/tattoo_designer_desc.png");
                    break;
            }
            startActivity(intent);
        }
        else if(JobName.equals("Costume Job")){
            switch (position){

                case 0:intent.putExtra("DESCRIPTION","Costume Designer");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/costume_designer_desc.png");
                    break;
                case 1:intent.putExtra("DESCRIPTION","Costume Supervisor");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/costume_supervisor_desc.png");
                    break;
                case 2:intent.putExtra("DESCRIPTION","Costume Assistant");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/costume_assistant_desc.png");
                    break;
                case 3:intent.putExtra("DESCRIPTION","Costume Cutter");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/costume_cutter_desc.png");
                    break;
                case 4:intent.putExtra("DESCRIPTION","Costume Maker");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/costume_maker_desc.png");
                    break;
                case 5:intent.putExtra("DESCRIPTION","Costume Breakdown Artist");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/costume_breakdown_artist_desc.png");
                    break;
                case 6:intent.putExtra("DESCRIPTION","Costume Buyer");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/costume_buyer_desc.png");
                    break;
                case 7:intent.putExtra("DESCRIPTION","Wardrobe Supervisor");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/wardrobe_supervisor_desc.png");
                    break;
                case 8:intent.putExtra("DESCRIPTION","Specialty Costume Designer");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/specialty_costume_designer_desc.png");
                    break;
                case 9:intent.putExtra("DESCRIPTION","Costume Assistant Designer");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/costume_assistant_designer_desc.png");
                    break;
                case 10:intent.putExtra("DESCRIPTION","Set Costumer");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/set_costumer_desc.png");
                    break;
                case 11:intent.putExtra("DESCRIPTION","Costume Standby");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/costume_standby_desc.png");
                    break;
                case 12:intent.putExtra("DESCRIPTION","Costume Illustrator");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/costume_illustrator_desc.png");
                    break;
                case 13:intent.putExtra("DESCRIPTION","Costume Beader");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/costume_beader_desc.png");
                    break;
                case 14:intent.putExtra("DESCRIPTION","Costume Rental Manager");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/costume_rental_manager_desc.png");
                    break;
                case 15:intent.putExtra("DESCRIPTION","Dresser");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/dresser_desc.png");
                    break;
                case 16:intent.putExtra("DESCRIPTION","Costume Department Coordinator");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/costume_department_coordinator_desc.png");
                    break;
                case 17:intent.putExtra("DESCRIPTION","Costume Shop Manager");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/costume_shop_manager_desc.png");
                    break;
                case 18:intent.putExtra("DESCRIPTION","Costume Shop Assistant");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/costume_shop_assistant_desc.png");
                    break;
                case 19:intent.putExtra("DESCRIPTION","Costume Rental");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/costume_rental_desc.png");
                    break;
                case 20:intent.putExtra("DESCRIPTION","Costume Milliner");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/costume_milliner_desc.png");
                    break;
                case 21:intent.putExtra("DESCRIPTION","Costume Jewelry Maker");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/costume_jewelry_maker_desc.png");
                    break;
                case 22:intent.putExtra("DESCRIPTION","Distressing Artist");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/distressing_artist_desc.png");
                    break;
                case 23:intent.putExtra("DESCRIPTION","Costume Breakdown Shoemaker");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/costume_breakdown_shoemaker_desc.png");
                    break;
                case 24:intent.putExtra("DESCRIPTION","Costume Leatherworker Breakdown");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/leatherworker_desc.png");
                    break;
                case 25:intent.putExtra("DESCRIPTION","Costume Breakdown Textile Specialist");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/costume_breakdown_textile_specialist_desc.png");
                    break;
                case 26:intent.putExtra("DESCRIPTION","Costume Breakdown 3d Printer Technician");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/costume_breakdown_3d_printer_technician_desc.png");
                    break;
                case 27:intent.putExtra("DESCRIPTION","Costume Research Assistant");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/costume_research_assistant_desc.png");
                    break;
                case 28:intent.putExtra("DESCRIPTION","Costume Supervisor For Visual Effects");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/costume_supervisor_for_visual_effects_desc.png");
                    break;
                case 29:intent.putExtra("DESCRIPTION","Costume Photographer");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/costume_photographer_desc.png");
                    break;
                case 30:intent.putExtra("DESCRIPTION","Costume Consultant");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/costume_consultant_desc.png");
                    break;
                case 31:intent.putExtra("DESCRIPTION","Costume 3d Modeler");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/costume_3d_modeler_desc.png");
                    break;
                case 32:intent.putExtra("DESCRIPTION","Costume Embroiderer");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/costume_embroiderer_desc.png");
                    break;
                case 33:intent.putExtra("DESCRIPTION","Costume Warehouse Manager");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/costume_warehouse_manager_desc.png");
                    break;
            }
            startActivity(intent);
        }
        else if(JobName.equals("Direction Job")){

            switch (position){
                case 0:intent.putExtra("DESCRIPTION","Director");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 1:intent.putExtra("DESCRIPTION","Assistant Director (AD)");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 2:intent.putExtra("DESCRIPTION","Second Assistant Director ( 2nd AD )");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 3:intent.putExtra("DESCRIPTION","Script Supervisor");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 4:intent.putExtra("DESCRIPTION","Casting Director");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 5:intent.putExtra("DESCRIPTION","Production Designer");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 6:intent.putExtra("DESCRIPTION","Director of Photography (DP or Cinematographer");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 7:intent.putExtra("DESCRIPTION","Editor");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 8:intent.putExtra("DESCRIPTION","Production Manager");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 9:intent.putExtra("DESCRIPTION","Art Director");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 10:intent.putExtra("DESCRIPTION","Special Effects Supervisor");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 11:intent.putExtra("DESCRIPTION","Stunt Coordinator");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
            }
            startActivity(intent);
        }
        else if(JobName.equals("Acting Job")){
            switch (position){
                case 0:intent.putExtra("DESCRIPTION","Actor");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 1:intent.putExtra("DESCRIPTION","Actress");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 2:intent.putExtra("DESCRIPTION","Stand-In");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 3:intent.putExtra("DESCRIPTION","Body Double");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 4:intent.putExtra("DESCRIPTION","Extras / Background Actor");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 5:intent.putExtra("DESCRIPTION","Talent Agent");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 6:intent.putExtra("DESCRIPTION","Acting Coach");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 7:intent.putExtra("DESCRIPTION","Casting Assistant");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 8:intent.putExtra("DESCRIPTION","Talent Scout");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 9:intent.putExtra("DESCRIPTION","Guest star appearance");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;

            }
            startActivity(intent);
        }
        else if(JobName.equals("Action Job")){
            switch (position){
                case 0:intent.putExtra("DESCRIPTION","Action Director");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 1:intent.putExtra("DESCRIPTION","Stunt Performer");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 2:intent.putExtra("DESCRIPTION","Stunt Coordinator");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 3:intent.putExtra("DESCRIPTION","Fight Choreographer");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 4:intent.putExtra("DESCRIPTION","Special Effects Supervisor");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 5:intent.putExtra("DESCRIPTION","Visual Effects Supervisor");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 6:intent.putExtra("DESCRIPTION","Action Cinematographer");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 7:intent.putExtra("DESCRIPTION","Action Camera Operator");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 8:intent.putExtra("DESCRIPTION","Armorer");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 9:intent.putExtra("DESCRIPTION","Production Designer for action / Action Art Director");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 10:intent.putExtra("DESCRIPTION","Action Sound Designer");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 11:intent.putExtra("DESCRIPTION","Action Scene Editor");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 12:intent.putExtra("DESCRIPTION","Action Gaffer");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
            }
            startActivity(intent);
        }
        else if(JobName.equals("Dance Job")){
            switch (position){
                case 0:intent.putExtra("DESCRIPTION","Dancer");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 1:intent.putExtra("DESCRIPTION","Choreographer");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 2:intent.putExtra("DESCRIPTION","Dance Instructor");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 3:intent.putExtra("DESCRIPTION","Dance Researcher");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 4:intent.putExtra("DESCRIPTION","Dance Consultant");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 5:intent.putExtra("DESCRIPTION","Dance Program Coordinator");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 6:intent.putExtra("DESCRIPTION","Dance Notator");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 7:intent.putExtra("DESCRIPTION","Dance Production Manager");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 8:intent.putExtra("DESCRIPTION","Dance Film/Video Director");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 9:intent.putExtra("DESCRIPTION","Dance Company Manager");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 10:intent.putExtra("DESCRIPTION","Dance company rehearsal director");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 11:intent.putExtra("DESCRIPTION","Dance studio manager");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
            }
            startActivity(intent);
        }
        else if(JobName.equals("Editing Job")){
            switch (position){
                case 0:intent.putExtra("DESCRIPTION","VFX Editor");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 1:intent.putExtra("DESCRIPTION","Special Effects");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 2:intent.putExtra("DESCRIPTION","Visual Effects Supervisor");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 3:intent.putExtra("DESCRIPTION","Digital Loader");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 4:intent.putExtra("DESCRIPTION","Assistant Director of Photography");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 5:intent.putExtra("DESCRIPTION","Assistant Editor");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 6:intent.putExtra("DESCRIPTION","Animator");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 7:intent.putExtra("DESCRIPTION","Dialogue Editor");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 8:intent.putExtra("DESCRIPTION","Colorist");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 9:intent.putExtra("DESCRIPTION","Assistant Colorist");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 10:intent.putExtra("DESCRIPTION","Title Designer");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 11:intent.putExtra("DESCRIPTION","Assistant Title Designer");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
            }
            startActivity(intent);
        }
        else if(JobName.equals("Camera Production Job")){
            switch (position){
                case 0:intent.putExtra("DESCRIPTION","Camera Production Assistant");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 1:intent.putExtra("DESCRIPTION","Camera Trainee");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 2:intent.putExtra("DESCRIPTION","Steadicam Operator");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 3:intent.putExtra("DESCRIPTION","Camera Operator");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 4:intent.putExtra("DESCRIPTION","Data Wrangler");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 5:intent.putExtra("DESCRIPTION","Digital Imaging Technician");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 6:intent.putExtra("DESCRIPTION","Assistant Camera Operator");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 7:intent.putExtra("DESCRIPTION","Rigging Grip");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 8:intent.putExtra("DESCRIPTION","Dolly Grip");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 9:intent.putExtra("DESCRIPTION","Best Boy Grip");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 10:intent.putExtra("DESCRIPTION","Key Grip");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 11:intent.putExtra("DESCRIPTION","Focus Puller (1st AC)");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 12:intent.putExtra("DESCRIPTION","Drone Operator");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 13:intent.putExtra("DESCRIPTION","Production Accountant");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 14:intent.putExtra("DESCRIPTION","Assistant Production Accountant");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 15:intent.putExtra("DESCRIPTION","Video Assist Operator");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 16:intent.putExtra("DESCRIPTION","Film Loader / Clapper Loader");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 17:intent.putExtra("DESCRIPTION","Digital Asset Manager (DAM)");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 18:intent.putExtra("DESCRIPTION","Accounting Clerk");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 19:intent.putExtra("DESCRIPTION","Production Secretary");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 20:intent.putExtra("DESCRIPTION","Script Reader");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 21:intent.putExtra("DESCRIPTION","Quality Control Technician");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 22:intent.putExtra("DESCRIPTION","Previs artist");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 23:intent.putExtra("DESCRIPTION","Weapons Master");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
            }
            startActivity(intent);
        }
        else if(JobName.equals("Other Job")){
            switch (position){
                case 0:intent.putExtra("DESCRIPTION","Transportation Coordinator");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 1:intent.putExtra("DESCRIPTION","Driver");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 2:intent.putExtra("DESCRIPTION","Construction Foreman");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 3:intent.putExtra("DESCRIPTION","Construction Coordinator");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 4:intent.putExtra("DESCRIPTION","Property Master");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 5:intent.putExtra("DESCRIPTION","Set Decorator");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 6:intent.putExtra("DESCRIPTION","Leadman");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 7:intent.putExtra("DESCRIPTION","Assistant Set Designer");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 8:intent.putExtra("DESCRIPTION","Production Secretary");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 9:intent.putExtra("DESCRIPTION","Production Coordinator");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 10:intent.putExtra("DESCRIPTION","Location Assistant");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 11:intent.putExtra("DESCRIPTION","Location Scout");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 12:intent.putExtra("DESCRIPTION","Assistant Location Manager");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 13:intent.putExtra("DESCRIPTION","Casting Associate");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 14:intent.putExtra("DESCRIPTION","Casting Researcher");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 15:intent.putExtra("DESCRIPTION","Casting Scout");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 16:intent.putExtra("DESCRIPTION","Casting Coordinator");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 17:intent.putExtra("DESCRIPTION","Casting Assistant");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 18:intent.putExtra("DESCRIPTION","Crowd Technical Director");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 19:intent.putExtra("DESCRIPTION","Digital Matte Painter");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 20:intent.putExtra("DESCRIPTION","Digital Compositor");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 21:intent.putExtra("DESCRIPTION","Lighting Supervisor");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 22:intent.putExtra("DESCRIPTION","Matchmove Supervisor");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 23:intent.putExtra("DESCRIPTION","Compositing Supervisor");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 24:intent.putExtra("DESCRIPTION","Render Wrangler");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 25:intent.putExtra("DESCRIPTION","Animal Handler");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 26:intent.putExtra("DESCRIPTION","Standby Painter");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 27:intent.putExtra("DESCRIPTION","Set Painter");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 28:intent.putExtra("DESCRIPTION","Standby Painter");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 29:intent.putExtra("DESCRIPTION","Leadman");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 30:intent.putExtra("DESCRIPTION","Scenic Carpenter");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 31:intent.putExtra("DESCRIPTION","Model Maker");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 32:intent.putExtra("DESCRIPTION","Rigger");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 33:intent.putExtra("DESCRIPTION","Dimmer Operator");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 34:intent.putExtra("DESCRIPTION","Rigging Electrician");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 35:intent.putExtra("DESCRIPTION","Texturing Artist");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 36:intent.putExtra("DESCRIPTION","Matchmover");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 37:intent.putExtra("DESCRIPTION","Aerial Coordinator");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 38:intent.putExtra("DESCRIPTION","Transportation Captain");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 39:intent.putExtra("DESCRIPTION","Pyrotechnician");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 40:intent.putExtra("DESCRIPTION","Animal Wrangler");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 41:intent.putExtra("DESCRIPTION","Armorer");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 42:intent.putExtra("DESCRIPTION","Set Decorator");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 43:intent.putExtra("DESCRIPTION","Rotoscope Artist");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 44:intent.putExtra("DESCRIPTION","Compositor");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 45:intent.putExtra("DESCRIPTION","Focus Puller");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 46:intent.putExtra("DESCRIPTION","Clapper Loader");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 47:intent.putExtra("DESCRIPTION","Electrician");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 48:intent.putExtra("DESCRIPTION","Best Boy Electric");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 49:intent.putExtra("DESCRIPTION","Lighting Technician");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 50:intent.putExtra("DESCRIPTION","Props master");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 51:intent.putExtra("DESCRIPTION","Animal Coordinator");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 52:intent.putExtra("DESCRIPTION","Key Scenic Artist");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 53:intent.putExtra("DESCRIPTION","Film Equipment Rental Coordinator");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 54:intent.putExtra("DESCRIPTION","Film Insurance Agent");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 55:intent.putExtra("DESCRIPTION","Film lab technician");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 56:intent.putExtra("DESCRIPTION","Set Extension Artist");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 57:intent.putExtra("DESCRIPTION","Set Medic");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 58:intent.putExtra("DESCRIPTION","Film historian");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;

            }
            startActivity(intent);
        }

        else {
            switch (position){
                case 0:intent.putExtra("DESCRIPTION","Film Festival Coordinator");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 1:intent.putExtra("DESCRIPTION","Film Marketing Manager");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 2:intent.putExtra("DESCRIPTION","Film Distribution Executive");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 3:intent.putExtra("DESCRIPTION","Film Sales Agent");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 4:intent.putExtra("DESCRIPTION","Film Publicist");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 5:intent.putExtra("DESCRIPTION","Film Projectionist");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 6:intent.putExtra("DESCRIPTION","Film Rights Acquisitions Executive");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 7:intent.putExtra("DESCRIPTION","Film Stock Supplier");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 8:intent.putExtra("DESCRIPTION","Delivery Coordinator");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 9:intent.putExtra("DESCRIPTION","Trailer Editor");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 10:intent.putExtra("DESCRIPTION","Film Distributor");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 11:intent.putExtra("DESCRIPTION","Media Manager");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 12:intent.putExtra("DESCRIPTION","Marketing and Publicity Coordinator");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 13:intent.putExtra("DESCRIPTION","Public Relations Assistant");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
                    break;
                case 14:intent.putExtra("DESCRIPTION","Social Media Assistant");
                    intent.putExtra("JobImage","https://images.backstageaudition.com/find_job.png");
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