package mryang.funnyisland.Activity.mine;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import mryang.funnyisland.R;


public class AboutActivity extends AppCompatActivity {

    private LinearLayout mHeadBack;
    private TextView mHeadTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        initView();
    }

    private void initView() {
        mHeadBack = (LinearLayout) findViewById(R.id.head_back);
        //退出页面
        mHeadBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mHeadTitle = (TextView) findViewById(R.id.head_title);
        mHeadTitle.setText("关于极乐岛");
    }
}
