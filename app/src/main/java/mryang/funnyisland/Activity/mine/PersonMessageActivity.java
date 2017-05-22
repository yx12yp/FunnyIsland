package mryang.funnyisland.Activity.mine;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import mryang.funnyisland.R;
import mryang.funnyisland.View.CircleImageView;

import static mryang.funnyisland.R.id.age;
import static mryang.funnyisland.R.id.sex;
import static mryang.funnyisland.R.id.signature;


public class PersonMessageActivity extends AppCompatActivity implements View.OnClickListener{

    private CircleImageView mHeadportrait;
    private CircleImageView mMineSex;
    private TextView mUsername;
    private TextView mUserContext;
    private EditText mSex;
    private LinearLayout mTochooseSex;
    private RadioButton mBoy;
    private RadioGroup mChooseSex;
    private EditText mName;
    private EditText mAge;
    private EditText mPhoneNumber;
    private EditText mSignature;
    private LinearLayout mPersonMessageBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_message);
        initView();
    }

    private void initView() {
        mHeadportrait = (CircleImageView) findViewById(R.id.headportrait);
        mMineSex = (CircleImageView) findViewById(R.id.mine_sex);
        mUsername = (TextView) findViewById(R.id.username);
        mUserContext = (TextView) findViewById(R.id.userContext);
        mSex = (EditText) findViewById(sex);
        mTochooseSex = (LinearLayout) findViewById(R.id.tochoose_sex);
        mBoy = (RadioButton) findViewById(R.id.boy);
        mChooseSex = (RadioGroup) findViewById(R.id.choose_sex);
        mName = (EditText) findViewById(R.id.name);
        mAge = (EditText) findViewById(age);
        mPhoneNumber = (EditText) findViewById(R.id.phoneNumber);
        mSignature = (EditText) findViewById(signature);
        mPersonMessageBack = (LinearLayout) findViewById(R.id.personMessage_back);
        mPersonMessageBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.personMessage_back:
                finish();
                break;
        }
    }

    private void submit() {
        // validate
        String sexString = mSex.getText().toString().trim();
        if (TextUtils.isEmpty(sexString)) {
            Toast.makeText(this, "请选择性别", Toast.LENGTH_SHORT).show();
            return;
        }

        String nameString = mName.getText().toString().trim();
        if (TextUtils.isEmpty(nameString)) {
            Toast.makeText(this, "请输入昵称", Toast.LENGTH_SHORT).show();
            return;
        }

        String ageString = mAge.getText().toString().trim();
        if (TextUtils.isEmpty(ageString)) {
            Toast.makeText(this, "请输入年龄", Toast.LENGTH_SHORT).show();
            return;
        }

        String phoneNumberString = mPhoneNumber.getText().toString().trim();
        if (TextUtils.isEmpty(phoneNumberString)) {
            Toast.makeText(this, "请输入联系方式", Toast.LENGTH_SHORT).show();
            return;
        }

        String signatureString = mSignature.getText().toString().trim();
        if (TextUtils.isEmpty(signatureString)) {
            Toast.makeText(this, "请输入个性签名", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something


    }
}
