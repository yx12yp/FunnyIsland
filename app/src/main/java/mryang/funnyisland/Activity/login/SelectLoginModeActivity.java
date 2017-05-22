package mryang.funnyisland.Activity.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import mryang.funnyisland.R;

public class SelectLoginModeActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout mJLDLoginBt;
    private LinearLayout mQQLoginBt;
    private LinearLayout mWXLoginBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_login_mode);
        initView();
    }

    private void initView() {
        mJLDLoginBt = (LinearLayout) findViewById(R.id.JLDLoginBt);
        mQQLoginBt = (LinearLayout) findViewById(R.id.QQLoginBt);
        mWXLoginBt = (LinearLayout) findViewById(R.id.WXLoginBt);
        mJLDLoginBt.setOnClickListener(this);
        mQQLoginBt.setOnClickListener(this);
        mWXLoginBt.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.JLDLoginBt://使用极乐岛账号登录
                Intent intent = new Intent(SelectLoginModeActivity.this,JLDLoginActivity.class);
                startActivity(intent);
                break;
            case R.id.QQLoginBt://使用QQ账号登录
                break;
            case R.id.WXLoginBt://使用微信账号登录
                break;
        }
    }

}
