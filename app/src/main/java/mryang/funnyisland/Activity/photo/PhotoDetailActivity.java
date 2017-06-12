package mryang.funnyisland.Activity.photo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

import mryang.funnyisland.Adapter.PhotoDetailAdapter;
import mryang.funnyisland.Adapter.PhotoRecommendAdapter;
import mryang.funnyisland.R;
import mryang.funnyisland.entity.ImgsModel;


public class PhotoDetailActivity extends AppCompatActivity {

    private RecyclerView mPhotoDetailRecyclerview;
    private RecyclerView mRecommendPhotoListRecyclerview;
    private List<ImgsModel> data = new ArrayList<>();
    private String[] urls = {"https://ss0.baidu.com/-Po3dSag_xI4khGko9WTAnF6hhy/image/h%3D220/sign=55691eb096510fb367197095e932c893/a8014c086e061d95b9df673173f40ad162d9ca1a.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1494999582642&di=fc920aaf187ecc283a039cdde5c9b40d&imgtype=0&src=http%3A%2F%2Fimage.tianjimedia.com%2FuploadImages%2F2015%2F285%2F38%2F0E743HD5TJJP.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1494999844597&di=ea78c5338859a45ae4a037840e5de98b&imgtype=0&src=http%3A%2F%2Fimage.tianjimedia.com%2FuploadImages%2F2015%2F159%2F18%2F7K1U17I6QCL3.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1494999844759&di=1d451af8f0f91dcbe8e7a8f277563b49&imgtype=0&src=http%3A%2F%2Fpic.yesky.com%2FuploadImages%2F2015%2F131%2F58%2F62KPG7ZYL453.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1494999923362&di=9a7332106488a1355f454d7da670b5c1&imgtype=0&src=http%3A%2F%2Fimage.tianjimedia.com%2FuploadImages%2F2015%2F215%2F16%2F15ZVS9ZQQ818.jpg",
            "https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=353350139,1833525451&fm=23&gp=0.jpg",
            "https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2847494274,442712643&fm=23&gp=0.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1494999965204&di=532a305d948fe962c8f5734b35dacc8f&imgtype=jpg&src=http%3A%2F%2Fc.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2Fe824b899a9014c08141181ac027b02087bf4f495.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1494999976511&di=02a54f31fedfd8f2c243f30a520b1af9&imgtype=0&src=http%3A%2F%2Fimg.tupianzj.com%2Fuploads%2Fallimg%2F140506%2F1-140506160035.jpg"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_detail);
        initData();
        initView();
    }

    private void initView() {
        mPhotoDetailRecyclerview = (RecyclerView) findViewById(R.id.photoDetailRecyclerview);
        mRecommendPhotoListRecyclerview = (RecyclerView) findViewById(R.id.recommendPhotoListRecyclerview);
        mPhotoDetailRecyclerview.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        mPhotoDetailRecyclerview.setAdapter(new PhotoDetailAdapter(this, data));

        //推荐图集列表
        mRecommendPhotoListRecyclerview.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        mRecommendPhotoListRecyclerview.setAdapter(new PhotoRecommendAdapter(this,data));

    }

    private void initData() {

        for (int i = 0; i < urls.length; i++) {
            ImgsModel imgs = new ImgsModel(urls[i]);
            data.add(imgs);

        }
    }
}
