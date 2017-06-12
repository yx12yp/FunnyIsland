package mryang.funnyisland.Activity.product;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import mryang.funnyisland.R;


public class ProductBallActivity extends AppCompatActivity {

    private LinearLayout mHeadBack;
    private TextView mHeadTitle;
    private TextView mProductRecommend;
    private TextView mProductCollection;
    private TextView mProductControl;
    private List<Fragment> fragmentlist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_ball);
        initView();
    }

    private void initView() {
        mHeadBack = (LinearLayout) findViewById(R.id.head_back);
        mHeadBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mHeadTitle = (TextView) findViewById(R.id.head_title);
        mHeadTitle.setText("产品专区");
        mProductRecommend = (TextView) findViewById(R.id.product_recommend);
        mProductCollection = (TextView) findViewById(R.id.product_collection);
        mProductControl = (TextView) findViewById(R.id.product_control);

    }

    private void changeFragment(int position) {
        //获取到FragmentManager
        FragmentManager manager = getSupportFragmentManager();
        //开启一个事务，通过调用beginTransaction方法开启
        FragmentTransaction transaction = manager.beginTransaction();
        //获取当前fragment对象
        Fragment fragment = fragmentlist.get(position);
        //判断当前fragment是否加载过
        if (!fragment.isAdded()) {
            transaction.add(R.id.home_fragment, fragment);
        }
        for (int i = 0; i < fragmentlist.size(); i++) {
            if (i == position) {
                transaction.show(fragmentlist.get(i));

            } else {
                transaction.hide(fragmentlist.get(i));

            }
        }
        //提交事务
        transaction.commit();
    }
}
