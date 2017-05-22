package mryang.funnyisland.Activity.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import mryang.funnyisland.R;


public class ForgetPwdActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout mHeadBack;
    private TextView mHeadTitle;
    private EditText mForgetpwdPhonenumber;
    private EditText mForgetpwdVerifyCode;
    private Button mForgetpawSendVerifycodeBt;
    private EditText mForgetpwdNewpwd;
    private EditText mForgetpwdConfirmpwd;
    private Button mForgetpwdSubmitBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_pwd);
        initView();
    }

    private void initView() {
        mHeadBack = (LinearLayout) findViewById(R.id.head_back);
        mHeadTitle = (TextView) findViewById(R.id.head_title);
        mHeadTitle.setText("找回密码");
        mForgetpwdPhonenumber = (EditText) findViewById(R.id.forgetpwd_phonenumber);
        mForgetpwdVerifyCode = (EditText) findViewById(R.id.forgetpwd_verify_code);
        mForgetpawSendVerifycodeBt = (Button) findViewById(R.id.forgetpaw_sendVerifycode_bt);
        mForgetpwdNewpwd = (EditText) findViewById(R.id.forgetpwd_newpwd);
        mForgetpwdConfirmpwd = (EditText) findViewById(R.id.forgetpwd_confirmpwd);
        mForgetpwdSubmitBt = (Button) findViewById(R.id.forgetpwd_submit_bt);
        mHeadBack.setOnClickListener(this);
        mForgetpawSendVerifycodeBt.setOnClickListener(this);
        mForgetpwdSubmitBt.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.forgetpaw_sendVerifycode_bt://发送验证码

                break;
            case R.id.forgetpwd_submit_bt://提交
                finish();
                break;
            case R.id.head_back://退出页面
                finish();
                break;
        }
    }

}
