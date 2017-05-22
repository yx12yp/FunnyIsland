package mryang.funnyisland.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import mryang.funnyisland.Activity.mine.AboutActivity;
import mryang.funnyisland.Activity.mine.HelpActivity;
import mryang.funnyisland.Activity.mine.MineDevicesActivity;
import mryang.funnyisland.Activity.mine.MineLogActivity;
import mryang.funnyisland.Activity.mine.PersonMessageActivity;
import mryang.funnyisland.Adapter.MineListAdapter;
import mryang.funnyisland.R;
import mryang.funnyisland.View.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 */
public class MineFragment extends Fragment implements View.OnClickListener{


    private CircleImageView mHeadportrait;
    private TextView mUsername;
    private TextView mUserContext;
    private RecyclerView mMineListRecyclerview;
    private String[] mineList = {"我的设备", "关于极乐岛",  "我的记录","清除图片缓存", "帮助", "退出"};
    private List<String> data = new ArrayList<>();
    private RelativeLayout mPersonMessage;

    public MineFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_mine, container, false);
        initData();
        initView(view);
        return view;
    }

    private void initData() {
        for (int i = 0; i < mineList.length; i++) {
            data.add(mineList[i]);
        }
    }

    private void initView(View view) {
        mHeadportrait = (CircleImageView) view.findViewById(R.id.headportrait);
        mPersonMessage = (RelativeLayout) view.findViewById(R.id.personMessage);
        mPersonMessage.setOnClickListener(this);
        mUsername = (TextView) view.findViewById(R.id.username);
        mUserContext = (TextView) view.findViewById(R.id.userContext);
        mMineListRecyclerview = (RecyclerView) view.findViewById(R.id.mine_list_Recyclerview);
        mMineListRecyclerview.setLayoutManager(new LinearLayoutManager(getContext().getApplicationContext()){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
            // SC嵌套ReCV防止数据显示不完整
//            @Override
//            public void onMeasure(RecyclerView.Recycler recycler, RecyclerView.State state, int widthSpec, int heightSpec) {
//                int expandSpec = View.MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, View.MeasureSpec.AT_MOST);
//                super.onMeasure(recycler, state, widthSpec, expandSpec);
//            }
        });
        MineListAdapter adapter = new MineListAdapter(data);
        mMineListRecyclerview.setAdapter(adapter);
        adapter.setOnItemClickListener(new MineListAdapter.OnItemClickLitener() {
            @Override
            public void onItemClick(View view, int position) {
                switch (position) {
                    case 0://我的设备
                        Intent intent = new Intent(getActivity(), MineDevicesActivity.class);
                        startActivity(intent);
                        break;
                    case 1://关于极乐岛
                        Intent intent1 = new Intent(getActivity(), AboutActivity.class);
                        startActivity(intent1);
                        break;
                    case 2://我的记录
                        Intent intent2 = new Intent(getActivity(), MineLogActivity.class);
                        startActivity(intent2);
                        break;
                    case 3://清除图片缓存
                        Toast.makeText(getContext(),"清除图片缓存", Toast.LENGTH_SHORT).show();
                        break;
                    case 4://帮助
                        Intent intent4 = new Intent(getActivity(), HelpActivity.class);
                        startActivity(intent4);
                        break;
                    case 5://退出
                        getActivity().finish();
                        break;
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.personMessage://个人信息
                Intent intent = new Intent(getActivity(), PersonMessageActivity.class);
                startActivity(intent);
                break;
        }
    }
}
