package casting.movie.audition.models;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import casting.movie.audition.R;
import pl.droidsonroids.gif.GifImageView;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder>{

    private Context mCtx;
    private ItemClickListener mClickListener;
    private List<ContactUs> auditionsList;

    public ContactAdapter(Context mCtx, List<ContactUs> auditionsList) {
        this.mCtx = mCtx;
        this.auditionsList = auditionsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.contact_layout, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ContactUs product = auditionsList.get(position);

        Animation animation = AnimationUtils.loadAnimation(mCtx, R.anim.blink_animation);
        holder.buttonImg.startAnimation(animation);

        Glide.with(mCtx).load(product.getImage()).into(holder.buttonImg);
        Glide.with(mCtx).load(product.getGif_image()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return auditionsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView buttonImg;
        GifImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            buttonImg = itemView.findViewById(R.id.buttonImg);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }
    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public static void onItemClick(View view, int position) {
        switch (position){
            case 0: view.getContext().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/BackstageAudition/")));
                break;
            case 1: view.getContext().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/@Online.Audition")));
                break;
            case 2: view.getContext().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/backstageaudition/")));
                break;
            case 3: view.getContext().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("Backstagehelpdesk@gmail.com")));
                break;
            case 4: view.getContext().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("tel:+919112473657")));
                break;
            case 5: view.getContext().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://t.me.backstageaudition/")));
                break;
            case 6: view.getContext().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://app.backstageaudition.com/contents/en-us/contactus.html")));
                break;
            case 7: view.getContext().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://my.artibot.ai/backstage")));
                break;
            case 8: view.getContext().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=casting.movie.audition")));
                break;
            case 9: view.getContext().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/EcastingOnline")));
                break;
            case 10: view.getContext().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("")));
                break;
            case 11: view.getContext().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("")));
                break;
            case 12: view.getContext().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/@Online.Audition")));
                break;
            case 13:view.getContext().startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://app.backstageaudition.com/contents/en-us/d169009_Find-Audition-and-Casting-a-job.html")));
                break;
        }

    }

}
