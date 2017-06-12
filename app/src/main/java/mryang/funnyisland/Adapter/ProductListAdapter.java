package mryang.funnyisland.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mryang.funnyisland.R;

/**
 * Created by Mr.Yang on 2017/6/2.
 */

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.VH> {

    public interface OnItemClickListener {
        void onItemClick(View view,int position);
    }

    private OnItemClickListener mOnItemClickLitener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickLitener = onItemClickListener;
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_second_product_list,parent,false);
        VH vh = new VH(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(final VH holder, int position) {
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
        return 5;
    }

    class VH extends RecyclerView.ViewHolder {
        public VH(View itemView) {
            super(itemView);
        }
    }
}
