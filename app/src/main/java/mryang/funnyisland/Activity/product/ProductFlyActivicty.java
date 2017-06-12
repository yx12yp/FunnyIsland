package mryang.funnyisland.Activity.product;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import mryang.funnyisland.Adapter.ProductFlyListAdapter;
import mryang.funnyisland.R;


public class ProductFlyActivicty extends AppCompatActivity {

    private RecyclerView mProductCosplayRv;
    private int[] cosplayImg = {R.drawable.hushiers, R.drawable.kongjie, R.drawable.laoshi, R.drawable.xuesheng, R.drawable.jingchae, R.drawable.moduo};
    private int[] rotateImg = {R.drawable.koujiaoxiaohushi,R.drawable.xingganshaofu};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_cosplay_activicty);
        initView();
    }

    private void initView() {
        mProductCosplayRv = (RecyclerView) findViewById(R.id.product_cosplay_Rv);
        mProductCosplayRv.setLayoutManager(new GridLayoutManager(ProductFlyActivicty.this, 2));
        Intent intent = getIntent();
        int flags = intent.getFlags();
        ProductFlyListAdapter adapter;
        if (flags == 0) {
            adapter = new ProductFlyListAdapter(this, cosplayImg);
        } else {
            adapter = new ProductFlyListAdapter(this, rotateImg);
        }
            mProductCosplayRv.setAdapter(adapter);
        adapter.setOnItemClickListener(new ProductFlyListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(ProductFlyActivicty.this,ProductListActivity.class);
                startActivity(intent);
            }
        });
    }
}
