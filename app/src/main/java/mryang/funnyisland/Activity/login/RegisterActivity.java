package mryang.funnyisland.Activity.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import mryang.funnyisland.R;

import static mryang.funnyisland.R.id.register_password;
import static mryang.funnyisland.R.id.register_phoneNumber;
import static mryang.funnyisland.R.id.register_verification_code;


public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout mHeadBack;
    private TextView mHeadTitle;
    private EditText mRegisterPhoneNumber;
    private EditText mRegisterPassword;
    private ImageView mLookPwdimg;
    private LinearLayout mRegisterLookPassword;
    private EditText mRegisterVerificationCode;
    private Button mRegisterSendVerificationBt;
    private Button mRegisterRegisterBt;
    private TextView mRegisterUserProtocal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
    }

    private void initView() {
        mHeadBack = (LinearLayout) findViewById(R.id.head_back);
        mHeadTitle = (TextView) findViewById(R.id.head_title);
        mHeadTitle.setText("注册账号");
        mRegisterPhoneNumber = (EditText) findViewById(register_phoneNumber);
        mRegisterPassword = (EditText) findViewById(register_password);
        mLookPwdimg = (ImageView) findViewById(R.id.look_pwdimg);
        mRegisterLookPassword = (LinearLayout) findViewById(R.id.register_look_password);
        mRegisterVerificationCode = (EditText) findViewById(register_verification_code);
        mRegisterSendVerificationBt = (Button) findViewById(R.id.register_send_verification_bt);
        mRegisterRegisterBt = (Button) findViewById(R.id.register_register_bt);
        mRegisterUserProtocal = (TextView) findViewById(R.id.register_user_protocal);
        mHeadBack.setOnClickListener(this);
        mRegisterSendVerificationBt.setOnClickListener(this);
        mRegisterRegisterBt.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.register_send_verification_bt://发送验验证码

                break;
            case R.id.register_register_bt://注册
                finish();
                break;
            case R.id.head_back://退出页面
                finish();
                break;
        }
    }

}
