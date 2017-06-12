package mryang.funnyisland.Fragment.product;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import mryang.funnyisland.Activity.product.ProductFlyActivicty;
import mryang.funnyisland.Activity.product.ProductBallActivity;
import mryang.funnyisland.Adapter.ProductListRecyclerViewAdapter;
import mryang.funnyisland.R;
import mryang.funnyisland.entity.ProductListModel;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProductZoneFragment extends Fragment {


    private RecyclerView mProductListRecyclerview;
    private String[] title = {"角色扮演有声飞机杯", "旋转伸缩飞机杯", "缩阴球"};
    private int[] imgs = {R.drawable.hushi, R.drawable.feijibei, R.drawable.suoyinqiu};
    private List<ProductListModel> data = new ArrayList<>();
    private LinearLayout mHeadBack;
    private TextView mHeadTitle;

    public ProductZoneFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_product_zone, container, false);
        initView(view);
        initData();
        initList();
        return view;
    }

    private void initList() {
        mProductListRecyclerview.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        ProductListRecyclerViewAdapter adapter = new ProductListRecyclerViewAdapter(getActivity(), data);

        mProductListRecyclerview.setAdapter(adapter);
        adapter.setOnItemClickListener(new ProductListRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                switch (position) {
                    case 0:
                        Intent intent = new Intent(getActivity(), ProductFlyActivicty.class);
                        intent.setFlags(0);
                        startActivity(intent);
                        break;
                    case 1:
                        Intent intent2 = new Intent(getActivity(), ProductFlyActivicty.class);
                        intent2.setFlags(1);
                        startActivity(intent2);
                        break;
                    case 2:
                        Intent intent3 = new Intent(getActivity(), ProductBallActivity.class);
                        startActivity(intent3);
                        break;
                }
            }
        });
    }

    private void initData() {
        for (int i = 0; i < title.length; i++) {
            ProductListModel model = new ProductListModel(imgs[i], title[i]);
            data.add(model);
        }
    }

    private void initView(View view) {
        mProductListRecyclerview = (RecyclerView) view.findViewById(R.id.product_list_recyclerview);

        mHeadBack = (LinearLayout) view.findViewById(R.id.head_back);
        mHeadBack.setVisibility(View.INVISIBLE);
        mHeadTitle = (TextView) view.findViewById(R.id.head_title);
        mHeadTitle.setText("产品专区");
    }
}
