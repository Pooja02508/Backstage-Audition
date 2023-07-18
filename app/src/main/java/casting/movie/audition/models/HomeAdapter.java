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

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder>{

    private Context mCtx;
    private ItemClickListener mClickListener;
    private List<Auditions> auditionsList;

    public HomeAdapter(Context mCtx, List<Auditions> auditionsList) {
        this.mCtx = mCtx;
        this.auditionsList = auditionsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.homepage_layout, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Auditions product = auditionsList.get(position);

        holder.title.setText(product.getJobs());
        Glide.with(mCtx).load(product.getTrainee()).into(holder.buttonImg);
        Glide.with(mCtx).load(product.getImage()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return auditionsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView title;
        ImageView buttonImg;
        GifImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            title = itemView.findViewById(R.id.title);
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
}
