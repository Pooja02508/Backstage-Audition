package casting.movie.audition.models;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import casting.movie.audition.R;
import pl.droidsonroids.gif.GifImageView;

public class BackstageJobAdapter extends RecyclerView.Adapter<BackstageJobAdapter.ViewHolder>{

    private Context mCtx;
    private ItemClickListener mClickListener;
    private List<Auditions> auditionsList;

    public BackstageJobAdapter(Context mCtx, List<Auditions> auditionsList) {
        this.mCtx = mCtx;
        this.auditionsList = auditionsList;
    }

    @NonNull
    @Override
    public BackstageJobAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.backstage_job_layout, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BackstageJobAdapter.ViewHolder holder, int position) {
        Auditions product = auditionsList.get(position);

        holder.title.setText(product.getTitle());
        holder.jobs.setText(product.getJobs());
        holder.trainee.setText(product.getTrainee());

        Glide.with(mCtx).load(product.getImage()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return auditionsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView title,jobs,trainee;
        GifImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            image = itemView.findViewById(R.id.image);
            jobs = itemView.findViewById(R.id.jobs);
            trainee = itemView.findViewById(R.id.trainee);
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
}
