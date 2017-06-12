package mryang.funnyisland.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

import java.util.ArrayList;
import java.util.List;

import mryang.funnyisland.R;
import mryang.funnyisland.entity.ImgsModel;

/**
 * Created by Mr.sorrow on 2017/5/2.
 */

public class PhotoRecommendAdapter extends RecyclerView.Adapter<PhotoRecommendAdapter.ViewHolder> {

    private Context mContext;

    private List<ImgsModel> mData;
    private List<Integer> mHeights = new ArrayList<>();

    public PhotoRecommendAdapter(Context context, List<ImgsModel> data) {
        mContext = context;
        mData = data;
    }

    public interface OnItemClickListener {

        void onItemClick(View view, int position);

    }

    private OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_photo_recommend_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        WindowManager windowManager = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        Display display = windowManager.getDefaultDisplay();
        display.getMetrics(dm);
        final int screenWidth = dm.widthPixels;
        final int screenHeight = dm.heightPixels;
        String url = mData.get(position).getUrl();
        Glide.with(mContext).load(url).asBitmap().diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(new SimpleTarget<Bitmap>(screenWidth, screenHeight) {
                    @Override
                    public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                        if (holder.getAdapterPosition() != RecyclerView.NO_POSITION) {

                            holder.mImg.setImageBitmap(resource);
                        }
                    }
                });

        if (mOnItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickListener.onItemClick(holder.itemView,pos);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        if (mData == null)
            return 0;
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        private final ImageView mImg;

        ViewHolder(View view) {
            super(view);
            mImg = (ImageView) view.findViewById(R.id.recommend_photo_mm);

        }
    }
}
