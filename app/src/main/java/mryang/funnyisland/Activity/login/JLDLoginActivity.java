package mryang.funnyisland.Activity.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import mryang.funnyisland.Activity.MainActivity;
import mryang.funnyisland.R;

import static mryang.funnyisland.R.id.login_password_edittext;
import static mryang.funnyisland.R.id.login_phonenumber_editext;


public class JLDLoginActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout mHeadBack;
    private TextView mHeadTitle;
    private EditText mLoginPhonenumberEditext;
    private EditText mLoginPasswordEdittext;
    private ImageView mLookPwd;
    private Button mLogonLoginBtn;
    private TextView mLoginForgetPassword;
    private TextView mLoginRegisterNow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jldlogin);
        initView();
    }

    private void initView() {
        mHeadBack = (LinearLayout) findViewById(R.id.head_back);
        mHeadTitle = (TextView) findViewById(R.id.head_title);
        mHeadTitle.setText("");
        mLoginPhonenumberEditext = (EditText) findViewById(login_phonenumber_editext);
        mLoginPasswordEdittext = (EditText) findViewById(login_password_edittext);
        mLookPwd = (ImageView) findViewById(R.id.look_pwd);
        mLogonLoginBtn = (Button) findViewById(R.id.logon_login_btn);
        mLoginForgetPassword = (TextView) findViewById(R.id.login_forget_password);
        mLoginRegisterNow = (TextView) findViewById(R.id.login_register_now);
        mLoginForgetPassword.setOnClickListener(this);
        mLoginRegisterNow.setOnClickListener(this);
        mLogonLoginBtn.setOnClickListener(this);
        mHeadBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.logon_login_btn://登录
                startActivity(new Intent(JLDLoginActivity.this, MainActivity.class));
                break;
            case R.id.head_back://退出界面
                finish();
                break;
            case R.id.login_forget_password://找回密码
                startActivity(new Intent(JLDLoginActivity.this,ForgetPwdActivity.class));
                break;
            case R.id.login_register_now://注册账户
                startActivity(new Intent(JLDLoginActivity.this,RegisterActivity.class));
                break;
        }
    }

//    private void submit() {
//        // validate
//        String editext = mLoginPhonenumberEditext.getText().toString().trim();
//        if (TextUtils.isEmpty(editext)) {
//            Toast.makeText(this, "请输入手机号码", Toast.LENGTH_SHORT).show();
//            return;
//        }
//
//        String edittext = mLoginPasswordEdittext.getText().toString().trim();
//        if (TextUtils.isEmpty(edittext)) {
//            Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
//            return;
//        }
//
//        // TODO validate success, do something
//
//
//    }
}
