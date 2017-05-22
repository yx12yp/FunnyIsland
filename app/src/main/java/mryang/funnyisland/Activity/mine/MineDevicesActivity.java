package mryang.funnyisland.Activity.mine;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import mryang.funnyisland.R;


public class MineDevicesActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout mHeadBack;
    private TextView mHeadTitle;
    private Button mMineDevicesLineBt;
    private int DEVICES_RESULT = 2;

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
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mine_devices_line_Bt:
                setResult(DEVICES_RESULT);
                finish();
                break;
        }
    }
}
