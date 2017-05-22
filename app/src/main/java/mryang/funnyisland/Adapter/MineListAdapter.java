package mryang.funnyisland.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import mryang.funnyisland.R;

/**
 * Created by Mr.Yang on 2017/5/17.
 */

public class MineListAdapter extends RecyclerView.Adapter<MineListAdapter.MineViewHolder> {

    private List<String> data = new ArrayList<>();

    public MineListAdapter(List<String> data) {
        this.data = data;
    }

    public interface OnItemClickLitener {
        void onItemClick(View view,int position);
    }

    private OnItemClickLitener mOnItemClickLitener;

    public void setOnItemClickListener(OnItemClickLitener onItemClickLitener) {
        this.mOnItemClickLitener = onItemClickLitener;
    }

    @Override
    public MineViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mine_list,parent,false);
        MineViewHolder vh = new MineViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(final MineViewHolder holder, int position) {
        holder.mTitle.setText(data.get(position));
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
        if (data == null)
            return 0;
        return data.size();
    }

    class MineViewHolder extends RecyclerView.ViewHolder {

        private final TextView mTitle;

        public MineViewHolder(View itemView) {
            super(itemView);
            mTitle = (TextView) itemView.findViewById(R.id.mine_list_title);
        }
    }
}
