package mryang.funnyisland.Activity.product;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import mryang.funnyisland.Adapter.ProductListAdapter;
import mryang.funnyisland.R;


public class ProductListActivity extends AppCompatActivity {

    private RecyclerView mProductListRv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);
        initView();
    }

    private void initView() {
        mProductListRv = (RecyclerView) findViewById(R.id.product_list_rv);
        mProductListRv.setLayoutManager(new LinearLayoutManager(this));
        ProductListAdapter adapter = new ProductListAdapter();
        mProductListRv.setAdapter(adapter);
        adapter.setOnItemClickListener(new ProductListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(ProductListActivity.this, "护士" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
