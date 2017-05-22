package mryang.funnyisland.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import mryang.funnyisland.Adapter.ProductListRecyclerViewAdapter;
import mryang.funnyisland.R;
import mryang.funnyisland.entity.ProductListModel;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProductZoneFragment extends Fragment {


    private RecyclerView mProductListRecyclerview;
    private String[] imgUrl = {"http://ob5u36d1d.bkt.clouddn.com/a.png",
            "http://ob5u36d1d.bkt.clouddn.com/b.png", "http://ob5u36d1d.bkt.clouddn.com/c.png"};
    private String[] title = {"角色扮演有声飞机杯", "旋转伸缩飞机杯", "缩阴球"};
    private List<ProductListModel> data = new ArrayList<>();

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
                        Toast.makeText(getActivity(), "角色扮演有声飞机杯", Toast.LENGTH_SHORT).show();

                        break;
                    case 1:
                        Toast.makeText(getActivity(), "旋转伸缩飞机杯", Toast.LENGTH_SHORT).show();

                        break;
                    case 2:
                        Toast.makeText(getActivity(), "缩阴球", Toast.LENGTH_SHORT).show();

                        break;
                }
            }
        });
    }

    private void initData() {
        for (int i = 0; i < title.length; i++) {
            ProductListModel model = new ProductListModel(imgUrl[i], title[i]);
            data.add(model);
        }
    }

    private void initView(View view) {
        mProductListRecyclerview = (RecyclerView) view.findViewById(R.id.product_list_recyclerview);

    }
}
