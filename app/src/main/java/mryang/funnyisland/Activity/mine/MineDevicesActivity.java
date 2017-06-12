package mryang.funnyisland.Activity.mine;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import mryang.funnyisland.R;


public class MineDevicesActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout mHeadBack;
    private TextView mHeadTitle;
    private Button mMineDevicesLineBt;
    private int DEVICES_RESULT = 2;
    private ImageView mDervicesHushi;
    private ImageView mDervicesMaorede;
    private ImageView mDervicesDiandeng;
    private ImageView mDervicesQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine_devices);
        initView();
    }

    private void initView() {
        mHeadBack = (LinearLayout) findViewById(R.id.head_back);
        mHeadTitle = (TextView) findViewById(R.id.head_title);
        mHeadTitle.setText("我的设备");
        //退出页面
        mHeadBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mMineDevicesLineBt = (Button) findViewById(R.id.mine_devices_line_Bt);
        mMineDevicesLineBt.setOnClickListener(this);
        mDervicesHushi = (ImageView) findViewById(R.id.dervices_hushi);
        mDervicesHushi.setOnClickListener(this);
        mDervicesMaorede = (ImageView) findViewById(R.id.dervices_maorede);
        mDervicesMaorede.setOnClickListener(this);
        mDervicesDiandeng = (ImageView) findViewById(R.id.dervices_diandeng);
        mDervicesDiandeng.setOnClickListener(this);
        mDervicesQuestion = (ImageView) findViewById(R.id.dervices_question);
        mDervicesQuestion.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mine_devices_line_Bt:
                setResult(DEVICES_RESULT);
                finish();
                break;
            case R.id.dervices_hushi://护士设备
                setBackgroundAndDervices(R.drawable.biankuang_red, R.drawable.biankuang_white, R.drawable.biankuang_white,
                        R.drawable.hushired, R.drawable.maorede, R.drawable.diandengrede);
                break;
            case R.id.dervices_maorede://猫设备
                setBackgroundAndDervices(R.drawable.biankuang_white, R.drawable.biankuang_red, R.drawable.biankuang_white,
                        R.drawable.hushirede, R.drawable.maored, R.drawable.diandengrede);
                break;
            case R.id.dervices_diandeng://点灯设备
                setBackgroundAndDervices(R.drawable.biankuang_white, R.drawable.biankuang_white, R.drawable.biankuang_red,
                        R.drawable.hushirede, R.drawable.maorede, R.drawable.diandengred);
                break;
            case R.id.dervices_question://疑问
                break;
        }
    }

    public void setBackgroundAndDervices(int hushi,int maorede,int diandeng,int devices1,int devices2,int devices3) {
        mDervicesHushi.setBackground(getResources().getDrawable(hushi));
        mDervicesMaorede.setBackground(getResources().getDrawable(maorede));
        mDervicesDiandeng.setBackground(getResources().getDrawable(diandeng));
        mDervicesHushi.setImageResource(devices1);
        mDervicesMaorede.setImageResource(devices2);
        mDervicesDiandeng.setImageResource(devices3);
    }
}
