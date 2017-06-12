package mryang.funnyisland.Fragment.product;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mryang.funnyisland.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProductRecommendListFragment extends Fragment {


    private RecyclerView mProductRecommendListRv;

    public ProductRecommendListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_product_recommend_list, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mProductRecommendListRv = (RecyclerView) view.findViewById(R.id.product_recommend_list_rv);
    }
}
