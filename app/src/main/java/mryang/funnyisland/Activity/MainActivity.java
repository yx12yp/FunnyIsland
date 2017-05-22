package mryang.funnyisland.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import java.util.ArrayList;
import java.util.List;

import mryang.funnyisland.Activity.product.ProductZoneActivity;
import mryang.funnyisland.Fragment.MineFragment;
import mryang.funnyisland.Fragment.PhotoListFragment;
import mryang.funnyisland.Fragment.ProductZoneFragment;
import mryang.funnyisland.R;

public class MainActivity extends AppCompatActivity {

    private BottomBar mBottomBar;
    private List<Fragment> fragmentlist = new ArrayList<>();
    private int mCurrent = -1;
    private int RESULT_DEVICES = 2;
    private int REQUEST_DEVICES = 1;
    private int NOTHING_DEVICES = 3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        //初始化底部导航样式
        initBottomBarStyle();
        //初始化fragment
        initFragment();
        initViews();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();

    }

    private void initFragment() {

        PhotoListFragment f1 = new PhotoListFragment();
        ProductZoneFragment f2 = new ProductZoneFragment();
        MineFragment f3 = new MineFragment();
        fragmentlist.add(f1);
        fragmentlist.add(f2);
        fragmentlist.add(f3);
    }


    private void initView() {
        mBottomBar = (BottomBar) findViewById(R.id.bottomBar);

    }

    private void initBottomBarStyle() {
        //未选中的tab的icon+title颜色
        mBottomBar.setInActiveTabColor(getResources().getColor(R.color.white));
        //选中的tab的icon+title颜色
        mBottomBar.setActiveTabColor(getResources().getColor(R.color.yellow));

    }



    private void initViews() {
        mBottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                switch (tabId) {
                    case R.id.tab1:
                        changeFragment(0);
                        break;
                    case R.id.tab2:
//                        changeFragment(1);
                        Intent intent = new Intent(MainActivity.this, ProductZoneActivity.class);
                        startActivityForResult(intent,REQUEST_DEVICES);
                        break;
                    case R.id.tab3:
                        changeFragment(2);
                        break;
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_DEVICES) {
            if (resultCode == RESULT_DEVICES) {
                //连接蓝牙成功，进入产品专区页面
                changeFragment(1);
            }else if (resultCode == NOTHING_DEVICES) {
                    mBottomBar.selectTabAtPosition(0);
            }
        }
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
