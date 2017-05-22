package mryang.funnyisland.Activity.product;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

import mryang.funnyisland.Activity.mine.MineDevicesActivity;
import mryang.funnyisland.R;


public class ProductZoneActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mLineDeviceBt;
    private Button mNothingDeviceBt;
    private int REQUEST_DEVICES = 1;
    private int RESULT_DEVICES = 2;
    private int NOTHING_DEVICES = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pruduct_zone);
        initView();
    }

    private void initView() {
        mLineDeviceBt = (Button) findViewById(R.id.lineDeviceBt);
        mNothingDeviceBt = (Button) findViewById(R.id.nothingDeviceBt);

        mLineDeviceBt.setOnClickListener(this);
        mNothingDeviceBt.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.lineDeviceBt:
                Intent intent = new Intent(ProductZoneActivity.this, MineDevicesActivity.class);
                startActivityForResult(intent,REQUEST_DEVICES);
                break;
            case R.id.nothingDeviceBt:
                setResult(NOTHING_DEVICES);
                finish();
                break;
        }
    }

    //返回键监听


    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
            setResult(NOTHING_DEVICES);
            finish();
        }
        return super.dispatchKeyEvent(event);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_DEVICES) {
            if (resultCode == RESULT_DEVICES) {
                setResult(RESULT_DEVICES);
                finish();
            }
        }
    }
}
