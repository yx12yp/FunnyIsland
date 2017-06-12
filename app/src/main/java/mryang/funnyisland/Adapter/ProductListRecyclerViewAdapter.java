package mryang.funnyisland.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

import java.util.ArrayList;
import java.util.List;

import mryang.funnyisland.R;
import mryang.funnyisland.entity.ProductListModel;

/**
 * Created by Mr.Yang on 2017/5/16.
 */

public class ProductListRecyclerViewAdapter extends RecyclerView.Adapter<ProductListRecyclerViewAdapter.VH> {

    private List<ProductListModel> mData = new ArrayList<>();
    private Context mContext;
    private int LINE_SUCCESS = 0;

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    private OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    public ProductListRecyclerViewAdapter(Context context, List<ProductListModel> data) {
        this.mData = data;
        this.mContext = context;
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pruduct_list, parent, false);
        VH vh = new VH(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(final VH holder, final int position) {
        holder.mProductName.setText(mData.get(position).getTitle());
        //连接蓝牙成功，显示连接图标
        holder.mLianjie.setVisibility(position == LINE_SUCCESS ? View.VISIBLE : View.GONE);
        Glide.with(mContext).load(mData.get(position).getImgs()).asBitmap().diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                        if (holder.getAdapterPosition() != RecyclerView.NO_POSITION) {
                            holder.mProductImg.setImageBitmap(resource);
                        }
                    }
                });

        //设置回调事件
        if (mOnItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickListener.onItemClick(holder.itemView, pos);
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

    class VH extends RecyclerView.ViewHolder {

        private final ImageView mProductImg;
        private final TextView mProductName;
        private final ImageView mLianjie;

        public VH(View itemView) {
            super(itemView);
            mProductImg = (ImageView) itemView.findViewById(R.id.product_img);
            mProductName = (TextView) itemView.findViewById(R.id.product_name);
            mLianjie = (ImageView) itemView.findViewById(R.id.lianjie_img);
        }
    }
}
