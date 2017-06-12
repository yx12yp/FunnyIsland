package mryang.funnyisland.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import mryang.funnyisland.R;

/**
 * Created by Mr.Yang on 2017/6/2.
 */

public class ProductFlyListAdapter extends RecyclerView.Adapter<ProductFlyListAdapter.VH> {

    private Context mContext;
    private int[] imgs;

    public interface OnItemClickListener {
        void onItemClick(View view,int position);
    }

    private OnItemClickListener mOnItemClickLitener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickLitener = onItemClickListener;
    }


    public ProductFlyListAdapter(Context context, int[] cosplayImg) {
        this.mContext =context;
        this.imgs = cosplayImg;
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product_fly_list,parent,false);
        VH vh = new VH(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(final VH holder, final int position) {
        holder.mImg.setImageResource(imgs[position]);

        if (mOnItemClickLitener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickLitener.onItemClick(holder.itemView,pos);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return imgs.length;
    }

    class VH extends RecyclerView.ViewHolder {

        private final ImageView mImg;

        public VH(View itemView) {
            super(itemView);
            mImg = (ImageView) itemView.findViewById(R.id.product_fly_img);
        }
    }
}
