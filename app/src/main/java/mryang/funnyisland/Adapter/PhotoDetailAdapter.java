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

import mryang.funnyisland.Activity.photo.PhotoDetailActivity;
import mryang.funnyisland.R;
import mryang.funnyisland.entity.ImgsModel;

/**
 * Created by Mr.Yang on 2017/5/16.
 */

public class PhotoDetailAdapter extends RecyclerView.Adapter<PhotoDetailAdapter.VH> {

    private Context mContext;
    private List<ImgsModel> data = new ArrayList<>();

    public PhotoDetailAdapter(PhotoDetailActivity photoDetailActivity, List<ImgsModel> data) {
        this.mContext = photoDetailActivity;
        this.data = data;
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product_detail1,parent,false);
        VH vh = new VH(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(final VH holder, int position) {
        WindowManager windowManager = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        Display display = windowManager.getDefaultDisplay();
        display.getMetrics(dm);
        final int screenWidth = dm.widthPixels;
        final int screenHeight = dm.heightPixels;
        Glide.with(mContext).load(data.get(position).getUrl()).asBitmap().diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(new SimpleTarget<Bitmap>(screenWidth, screenHeight) {
                    @Override
                    public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                        if (holder.getAdapterPosition() != RecyclerView.NO_POSITION) {
                            holder.mProduct_detail_img.setImageBitmap(resource);
                        }
                    }
                });

    }

    @Override
    public int getItemCount() {
        if (data == null)
            return 0;
        return data.size();
    }

    class VH extends RecyclerView.ViewHolder {

        private final ImageView mProduct_detail_img;

        public VH(View itemView) {
            super(itemView);
            mProduct_detail_img = (ImageView) itemView.findViewById(R.id.product_detail_img);
        }
    }

}
